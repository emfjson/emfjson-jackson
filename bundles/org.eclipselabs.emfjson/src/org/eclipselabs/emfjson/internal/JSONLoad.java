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
import static org.eclipselabs.emfjson.common.ModelUtil.getDynamicMapEntryFeature;
import static org.eclipselabs.emfjson.common.ModelUtil.getEAttribute;
import static org.eclipselabs.emfjson.common.ModelUtil.getEObjectURI;
import static org.eclipselabs.emfjson.common.ModelUtil.getEReference;
import static org.eclipselabs.emfjson.common.ModelUtil.isMapEntry;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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

		if (root == null) { 
			throw new IllegalArgumentException("root node should not be null.");
		}

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

		fillNamespaces(root);
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
					EObject eObject = createEObject(resource, eClass, node);
					resource.getContents().add(eObject);
				}
			}
		} else {
			if (rootClass != null) {
				EObject eObject = createEObject(resource, rootClass, rootNode);
				resource.getContents().add(eObject);
			}
		}

		// Process EObject references and proxies.
		for (EObject eObject: resource.getContents()) {
			if (processed.containsKey(eObject))
				fillEReference(eObject, processed.get(eObject), resource);
		}
	}

	private EObject createEObject(Resource resource, EClass eClass, JsonNode node) {
		if (node.isObject()) {
			final EObject object = EcoreUtil.create(eClass);
			processed.put(object, node);

			fillEAttribute(object, node);
			fillEContainment(object, node, resource);

			return object;
		}

		return null;
	}

	private void fillEAttribute(EObject container, JsonNode root) {
		final EClass eClass = container.eClass();
	
		// Iterates over all key values of the JSON Object,
		// if the value is not an object then
		// if the key corresponds to an EAttribute, fill it
		// if not and the EClass contains a MapEntry, fill it with the key, value.
		for (Iterator<Entry<String, JsonNode>> it = root.getFields(); it.hasNext();) {
			Entry<String, JsonNode> field = it.next();
	
			String key = field.getKey();
			JsonNode value = field.getValue();
	
			if (value.isObject()) // not an attribute
				continue;
	
			EAttribute attribute = getEAttribute(eClass, key);
			if (attribute != null && !attribute.isTransient() && !attribute.isDerived()) {
				if (value.isArray()) {
					for (Iterator<JsonNode> itValue = value.getElements(); itValue.hasNext();) {
						setEAttributeValue(container, attribute, itValue.next());
					}
				} else {
					setEAttributeValue(container, attribute, value);
				}
			} else {
				EStructuralFeature eFeature = getDynamicMapEntryFeature(eClass);
				if (eFeature != null) {
					@SuppressWarnings("unchecked")
					EList<EObject> values = (EList<EObject>) container.eGet(eFeature);
					values.add(createEntry(key, value));
				}
			}
		}
	}

	private void fillEContainment(EObject eObject, JsonNode root, Resource resource) {
		final EClass eClass = eObject.eClass();

		for (Iterator<Entry<String, JsonNode>> it = root.getFields(); it.hasNext();) {
			Entry<String, JsonNode> field = it.next();

			String key = field.getKey();
			JsonNode value = field.getValue();

			EReference reference = getEReference(eClass, key);
			if (reference != null && reference.isContainment() && !reference.isTransient()) {
				if (isMapEntry(reference.getEType()) && value.isObject()) {
					createMapEntry(eObject, reference, value);
				} else {
					createContainment(eObject, reference, root, value, resource);
				}
			}
		}
	}

	private void fillEReference(EObject eObject, JsonNode root, Resource resource) {
		final EClass eClass = eObject.eClass();
	
		for (Iterator<Entry<String, JsonNode>> it = root.getFields(); it.hasNext();) {
			Entry<String, JsonNode> field = it.next();
	
			String key = field.getKey();
			JsonNode value = field.getValue();
	
			EReference reference = getEReference(eClass, key);
			if (reference != null && !reference.isContainment() && 
					!reference.isDerived() && !reference.isTransient()) {
	
				if (value.isArray()) {
					for (Iterator<JsonNode> itEl = value.getElements(); itEl.hasNext();) {
						JsonNode current = itEl.next();
						createProxyReference(eObject, root, current, reference, resource);
					}
				} else {
					createProxyReference(eObject, root, value, reference, resource);
				}
	
			}
		}
	
		for (EObject content: eObject.eContents()) {
			if (processed.containsKey(content))
				fillEReference(content, processed.get(content), resource);
		}
	}

	private void createContainment(EObject eObject, EReference reference, JsonNode root, JsonNode node, Resource resource) {
		if (node.isArray()) {
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

				for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
					JsonNode current = it.next();
					EObject contained = createContainedObject(reference, root, current, resource);
					if (contained != null) values.add(contained);
				}
			} else if (node.getElements().hasNext()) {
				JsonNode current = node.getElements().next();
				EObject contained = createContainedObject(reference, root, current, resource);
				if (contained != null) eObject.eSet(reference, contained);
			}
		} else {
			EObject contained = createContainedObject(reference, root, node, resource);

			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) eObject.eGet(reference);
				if (contained != null) values.add(contained);
			} else {
				if (contained != null) eObject.eSet(reference, contained);
			}
		}
	}

	private EObject createContainedObject(EReference reference, JsonNode root, JsonNode node, Resource resource) {
		EClass refClass = findEClass(reference.getEReferenceType(), node, root, resource);
		EObject obj;

		if (isRefNode(node)) {
			obj = createProxy(resource, refClass, node);
		} else {
			obj = createEObject(resource, refClass, node);	
		}

		return obj;
	}

	private EObject getOrCreateProxyReference(EReference reference, JsonNode root, JsonNode node, Resource resource) {
		EObject obj = findEObject(resource, node);
		if (obj == null) {
			EClass refClass = findEClass(reference.getEReferenceType(), node, root, resource);
			obj = createProxy(resource, refClass, node);
		}
		return obj;
	}

	private void createProxyReference(EObject eObject, JsonNode root, JsonNode node, EReference reference, Resource resource) {
		EObject proxy = getOrCreateProxyReference(reference, root, node, resource);
		if (proxy != null && reference.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) eObject.eGet(reference);
			values.add(proxy);
		} else if (proxy != null) {
			eObject.eSet(reference, proxy);
		}
	}

	private void setEAttributeValue(EObject obj, EAttribute attribute, JsonNode value) {
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

	private void createMapEntry(EObject container, EReference reference, JsonNode node) {
		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) container.eGet(reference);

			for (Iterator<Entry<String, JsonNode>> it = node.getFields(); it.hasNext();) {
				Entry<String, JsonNode> element = it.next();
				values.add(createEntry(element.getKey(), element.getValue()));
			}
		} else {
			if (node.getFields().hasNext()) {
				Entry<String, JsonNode> element = node.getFields().next();
				container.eSet(reference, createEntry(element.getKey(), element.getValue()));
			}
		}
	}

	@SuppressWarnings("deprecation")
	private EObject createEntry(String key, JsonNode value) {
		EObject eObject = EcoreUtil.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY, key);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, value.getValueAsText());

		return eObject;
	}

	private EObject createProxy(Resource resource, EClass eClass, JsonNode node) {
		EObject proxy = null;

		if (isRefNode(node)) {
			final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource.getURI(), nsMap);
			proxy = EcoreUtil.create(eClass);
			((InternalEObject) proxy).eSetProxyURI(objectURI);

			if (useProxyAttributes) {
				JsonNode refNode = JSUtil.getNode(resource, objectURI, eClass);
				if (refNode != null) fillEAttribute(proxy, refNode);
			}
		}

		return proxy;
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

	private boolean isRefNode(JsonNode node) {
		return node.isObject() && node.get(EJS_REF_KEYWORD) != null;
	}

	private EObject findEObject(Resource resource, JsonNode node) {
		EObject eObject = null;
		if (node.isObject()) {
			final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource.getURI(), nsMap);
			eObject = resourceSet.getEObject(objectURI, false);
		}
		return eObject;
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
