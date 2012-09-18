/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.internal;

import static org.eclipselabs.emfjson.common.Constants.EJS_NS_KEYWORD;
import static org.eclipselabs.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;
import static org.eclipselabs.emfjson.common.ModelUtil.getEObjectURI;
import static org.eclipselabs.emfjson.common.ModelUtil.getElementName;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.common.ModelUtil;

/**
 * A JSON reader for EMF Models.
 */
public class JSONLoad {

	private final Map<String, String> nsMap = new HashMap<String, String>();
	private JsonNode rootNode;
	private EClass rootClass;
	private ResourceSet resourceSet;
	private boolean useProxyAttributes = false;
	private Map<EObject, JsonNode> processed = new HashMap<EObject, JsonNode>();

	public JSONLoad(InputStream inStream, Map<?,?> options) {
		init(JSUtil.getJsonParser(inStream), options);
	}

	public JSONLoad(URL url, Map<?,?> options) {
		init(JSUtil.getJsonParser(url), options);
	}

	@SuppressWarnings("deprecation")
	private void init(JsonParser parser, Map<?,?> options) {
		processed.clear();

		if (options == null) {
			options = Collections.emptyMap();
		}

		JsonNode root = JSUtil.getRootNode(parser);

		checkNotNull(root, "root node should not be null.");

		useProxyAttributes = Boolean.TRUE.equals(options.get(EMFJs.OPTION_PROXY_ATTRIBUTES));

		if (!root.isArray()) {
			if (root.has(EJS_TYPE_KEYWORD)) {
				this.rootClass = getEClass(URI.createURI(root.get(EJS_TYPE_KEYWORD).getValueAsText()));
			}
		}

		if (rootClass == null) {
			this.rootClass = (EClass) options.get(EMFJs.OPTION_ROOT_ELEMENT);
		}

		final String path = ModelUtil.getRootNode(this.rootClass);

		if (path == null) {
			this.rootNode = root;
		} else {
			this.rootNode = root.findPath(path);
		}

		checkNotNull(rootNode);
		fillNamespaces(root);
	}

	private EClass getEClass(URI uri) {
		if (resourceSet == null) {
			return (EClass) new ResourceSetImpl().getEObject(uri, false);	
		}
		return (EClass) resourceSet.getEObject(uri, false);
	}

	@SuppressWarnings("deprecation")
	private EClass getEClass(JsonNode node, boolean isRoot) throws IllegalArgumentException {
		if (isRoot && rootClass != null) {
			return rootClass;
		} else {
			if (node.has(EJS_TYPE_KEYWORD)) {
				return getEClass(URI.createURI(node.get(EJS_TYPE_KEYWORD).getValueAsText()));
			} else {
				throw new IllegalArgumentException("Cannot find EClass for node "+node);
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void fillNamespaces(JsonNode node) {
		if (node.has(EJS_NS_KEYWORD)) {
			ObjectNode nsNode = (ObjectNode) node.findPath(EJS_NS_KEYWORD);

			for(Iterator<Entry<String, JsonNode>> it = nsNode.getFields(); it.hasNext();) {
				Entry<String, JsonNode> entry = it.next();
				nsMap.put(entry.getKey(), entry.getValue().getValueAsText());
			}
		}
	}

	public void fillResource(Resource resource) { 
		this.resourceSet = resource.getResourceSet() != null ? resource.getResourceSet() : new ResourceSetImpl();

		// Process json tree and create EObjects with containment references. 
		if (this.rootNode.isArray()) {

			for (Iterator<JsonNode> it = this.rootNode.getElements(); it.hasNext();) {
				JsonNode node = it.next();
				EClass eClass = null;
				try {
					eClass = getEClass(node, true);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}

				if (eClass != null) {
					createEObject(resource, eClass, node);
				}
			}

		} else {
			if (rootClass != null) {
				createEObject(resource, rootClass, rootNode);
			}
		}

		// Process EObject references and proxies.
		for (EObject eObject: resource.getContents()) {
			JsonNode node = processed.get(eObject);
			if (node != null) {
				fillEReference(eObject, node, resource);
			}
		}
	}

	private EObject createEObject(Resource resource, EClass eClass, JsonNode node) {
		if (node.isObject()) {
			final EObject object = EcoreUtil.create(eClass);
			resource.getContents().add(object);
			processed.put(object, node);

			fillEAttribute(object, node);
			fillEContainment(object, node, resource);

			return object;
		}

		return null;
	}

	private EObject createProxy(Resource resource, EClass eClass, JsonNode node) {
		EObject proxy = null;
		if (node.isObject() && node.get(EJS_REF_KEYWORD) != null) {
			final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource.getURI(), nsMap);
			proxy = EcoreUtil.create(eClass);
			((InternalEObject) proxy).eSetProxyURI(objectURI);

			if (useProxyAttributes) {
				JsonNode refNode = JSUtil.getNode(resource, objectURI, eClass);

				if (refNode != null) {
					fillEAttribute(proxy, refNode);
				}
			}
		}

		return proxy;
	}

	private EObject findEObject(Resource resource, JsonNode node) {
		EObject eObject = null;
		if (node.isObject()) {
			final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource.getURI(), nsMap);
			eObject = resourceSet.getEObject(objectURI, false);
		}
		return eObject;
	}

	private void fillEContainment(EObject eObject, JsonNode root, Resource resource) {
		final EClass eClass = eObject.eClass();

		for (EReference reference: eClass.getEAllContainments()) {
			final JsonNode node = root.get(getElementName(reference));

			if (node != null) {
				if (reference.isMany()) {

					@SuppressWarnings("unchecked")
					EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
							JsonNode current = it.next();

							EClass refClass = findEClass(reference.getEReferenceType(), current, root, resource);
							EObject obj = createEObject(resource, refClass, current);

							if (obj != null) {
								values.add(obj);
							}
						}
					} else {
						EClass refClass = findEClass(reference.getEReferenceType(), node, root, resource);
						EObject obj = createEObject(resource, refClass, node);
						if (obj != null) {
							values.add(obj);
						}
					}
				} else {
					if (node.isObject()) {
						EClass refClass = findEClass(reference.getEReferenceType(), node, root, resource);
						EObject obj = createEObject(resource, refClass, node);
						if (obj != null) {
							eObject.eSet(reference, obj);
						}
					}
				}
			}
		}
	}

	private void fillEReference(EObject eObject, JsonNode root, Resource resource) {
		final EClass eClass = eObject.eClass();

		for (EReference reference: eClass.getEAllReferences()) {
			if (reference.isContainment() || reference.isDerived() || reference.isTransient()) {
				continue;
			}

			final JsonNode node = root.get(getElementName(reference));
			if (node != null) {

				if (reference.isMany()) {
					@SuppressWarnings("unchecked")
					EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
							JsonNode current = it.next();

							EObject obj = findEObject(resource, current);
							if (obj == null) {
								EClass refClass = findEClass(reference.getEReferenceType(), current, root, resource);
								obj = createProxy(resource, refClass, current);
							}
							if (obj != null) {
								values.add(obj);
							}
						}
					} else {
						EObject obj = findEObject(resource, node);
						if (obj == null) {
							EClass refClass = findEClass(reference.getEReferenceType(), node, root, resource);
							obj = createProxy(resource, refClass, node);
						}
						if (obj != null) {
							values.add(obj);
						}
					}
				} else {
					EObject obj = findEObject(resource, node);
					if (obj == null) {
						EClass refClass = findEClass(reference.getEReferenceType(), node, root, resource);
						obj = createProxy(resource, refClass, node);
					}
					if (obj != null) {
						eObject.eSet(reference, obj);
					}
				}
			}
		}

		for (TreeIterator<EObject> it = EcoreUtil.getAllContents(eObject, false); it.hasNext();) {
			EObject obj = it.next();
			JsonNode node = processed.get(obj);
			if (node != null) {
				fillEReference(obj, node, resource);
			}
		}
	}

	private void fillEAttribute(EObject obj, JsonNode root) {
		final EClass eClass = obj.eClass();

		for (EAttribute attribute: eClass.getEAllAttributes()) {
			if (!attribute.isTransient() && !FeatureMapUtil.isFeatureMap(attribute)) {
				JsonNode node = root.get(getElementName(attribute));
				if (node != null) {
					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
							setEAttributeValue(obj, attribute, it.next());
						}
					} else {
						setEAttributeValue(obj, attribute, node);
					}
				}
			}
		}
	}

	protected void setEAttributeValue(EObject obj, EAttribute attribute, JsonNode value) {
		@SuppressWarnings("deprecation")
		final String stringValue = value.getValueAsText();
		if (stringValue != null && !stringValue.trim().isEmpty()) {
			Object newValue;
			if (attribute.getEAttributeType().getInstanceClass().isEnum()) {
				newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue.toUpperCase());
			} else {
				newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
			}
			if (!attribute.isMany()) {
				obj.eSet(attribute, newValue);
			} else {
				@SuppressWarnings("unchecked")
				Collection<Object> values = (Collection<Object>) obj.eGet(attribute);
				values.add(newValue);
			}
		}
	}

	private static void checkNotNull(Object object) {
		checkNotNull(object, null);
	}

	private static void checkNotNull(Object object, String message) throws IllegalArgumentException {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	private static JsonNode findNode(URI nodeURI, EClass eClass, JsonNode root) {
		EAttribute eID = eClass.getEIDAttribute();
		if (eID == null) {
			final EStructuralFeature featureName = eClass.getEStructuralFeature("name");
			if (featureName != null && featureName instanceof EAttribute) {
				eID = (EAttribute) featureName;
			} else {
				return null;
			}
		}

		String fragment = nodeURI.fragment().startsWith("//") ? nodeURI.fragment().substring(2) : nodeURI.fragment();

		for (JsonNode node: root.findParents(eID.getName())) {
			String value = node.get(eID.getName()).getTextValue();
			if (value.equals(fragment)){
				return node;
			}
		}
		return null;
	}

	private EClass findEClass(EClass eReferenceType, JsonNode node, JsonNode root, Resource resource) {
		if (eReferenceType.isAbstract() || node.get(EJS_TYPE_KEYWORD) != null) {

			if (node.has(EJS_REF_KEYWORD)) {

				URI refURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource.getURI(), nsMap);
				EObject eObject = resourceSet.getEObject(refURI, false);
				if (eObject != null) {
					return resourceSet.getEObject(refURI, false).eClass();
				}

				if (node.has(EJS_TYPE_KEYWORD)) {
					refURI = URI.createURI(node.get(EJS_TYPE_KEYWORD).asText());
					eObject = resourceSet.getEObject(refURI, false);
					if (eObject != null) {
						return (EClass) eObject;
					}
				}

				JsonNode refNode = findNode(refURI, eReferenceType, rootNode);
				if (refNode != null) {
					return findEClass(eReferenceType, refNode, root, resource);
				}

			}  else if (node.has(EJS_TYPE_KEYWORD)) {
				final URI typeURI = getEObjectURI(node.get(EJS_TYPE_KEYWORD), eReferenceType.eResource().getURI(), nsMap);

				if (typeURI.fragment().equals(eReferenceType.getName())) {
					return eReferenceType;
				} else {
					try {
						return (EClass) this.resourceSet.getEObject(typeURI, false);
					} catch (ClassCastException e) {
						e.printStackTrace();
						return null;
					}
				}

			}
		}
		return eReferenceType;
	}
}
