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
import static org.eclipselabs.emfjson.common.ModelUtil.getElementName;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.common.ModelUtil;

/**
 * 
 * @author ghillairet
 */
public class JSONLoad {
	
	private JsonNode rootNode;
	private final Map<String, String> nsMap = new HashMap<String, String>();
	private EClass rootClass;
	private ResourceSet resourceSet;

	public JSONLoad(InputStream inStream, Map<?,?> options) {
		init(JSONUtil.getJsonParser(inStream), options);
	}

	public JSONLoad(URL url, Map<?,?> options) {
		init(JSONUtil.getJsonParser(url), options);
	}

	@SuppressWarnings("deprecation")
	private void init(JsonParser parser, Map<?,?> options) {
		JsonNode root = JSONUtil.getRootNode(parser);

		checkNotNull(root, "root node should not be null.");
		checkNotNull(options, "load options parameters should not be null");

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

	private static void checkNotNull(Object object) {
		checkNotNull(object, null);
	}

	private static void checkNotNull(Object object, String message) throws IllegalArgumentException {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public Collection<EObject> fillResource(Resource resource) { 
		this.resourceSet = resource.getResourceSet() != null ? resource.getResourceSet() : new ResourceSetImpl();
		final Collection<EObject> result = resource.getContents();

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
					final EObject rootObject = EcoreUtil.create(eClass);
					resource.getContents().add(rootObject);

					fillEAttribute(rootObject, eClass, node);
					fillEReference(rootObject, eClass, node, resource);

					result.add(rootObject);
				}
			}

		} else {
			if (rootClass != null) {
				final EObject rootObject = EcoreUtil.create(rootClass);
				result.add(rootObject);

				fillEAttribute(rootObject, rootClass, this.rootNode);
				fillEReference(rootObject, rootClass, this.rootNode, resource);
			}
		}

		return result;
	}

	private void fillEReference(EObject rootObject, EClass rootClass, JsonNode root, Resource resource) {
		for (EReference reference: rootClass.getEAllReferences()) {
			final JsonNode node = root.get(getElementName(reference));

			if (node != null) {

				if (reference.isMany()) {
					@SuppressWarnings("unchecked")
					EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);

					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
							JsonNode current = it.next(); 
							EClass eClass = findEClass(reference.getEReferenceType(), current, root, resource);
							EObject obj = createEObject(resource, eClass, current);

							if (obj != null) values.add(obj);
						}
					} else {
						EClass eClass = findEClass(reference.getEReferenceType(), node, root, resource);
						EObject obj = createEObject(resource, eClass, node);
						if (obj != null) values.add(obj);
					}
				} else {

					EClass eClass = findEClass(reference.getEReferenceType(), node, root, resource);
					EObject obj = createEObject(resource, eClass, node);

					if (obj != null) rootObject.eSet(reference, obj);
				}
			}
		}
	}

	private EObject createEObject(Resource resource, EClass eClass, JsonNode node) {
		if (node.isObject()) {

			if (node.get(EJS_REF_KEYWORD) != null) {

				final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource);
				EObject object = resourceSet.getEObject(objectURI, false);

				if (object == null) {
					object = EcoreUtil.create(eClass);
					((InternalEObject)object).eSetProxyURI(objectURI);
				}

				return object;
			} else {

				final EObject obj = EcoreUtil.create(eClass);

				fillEAttribute(obj, eClass, node);
				fillEReference(obj, eClass, node, resource);

				return obj;
			}
		}
		return null;
	}

	private URI getEObjectURI(JsonNode jsonNode, Resource resource) {
		final String value = jsonNode.getTextValue();
		if (value.startsWith("#//")) { // is fragment
			return URI.createURI(resource.getURI()+value);
		} else if (value.contains("#//") && nsMap.keySet().contains(value.split("#//")[0])) {
			String[] split = value.split("#//");
			String nsURI = nsMap.get(split[0]);
			return URI.createURI(nsURI+"#//"+split[1]);
		} else if (value.contains(":")) {
			return URI.createURI(value);
		} else { // is ID
			return resource.getURI().appendFragment(value);
		}
	}

	private void fillEAttribute(EObject obj, EClass eClass, JsonNode root) {
		for (EAttribute attribute: eClass.getEAllAttributes()) {
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

				URI refURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource);
				if (resourceSet.getEObject(refURI, false) != null) {
					return resourceSet.getEObject(refURI, false).eClass();
				}

				JsonNode refNode = findNode(refURI, eReferenceType, rootNode);
				if (refNode != null) {
					return findEClass(eReferenceType, refNode, root, resource);
				}
			} 
			else if (node.has(EJS_TYPE_KEYWORD)) {
				final URI typeURI = getEObjectURI(node.get(EJS_TYPE_KEYWORD), eReferenceType.eResource());
				if (typeURI.fragment().equals(eReferenceType.getName())) {
					return eReferenceType;
				}
				else {
					final EObject o = this.resourceSet.getEObject(typeURI, false);
					final EClass found = o != null && o instanceof EClass ? (EClass)o : null;
					if (found != null) {
						return found;
					} else {
						throw new IllegalArgumentException("Cannot find EClass from type "+typeURI);
					}
				}
			}
		}
		return eReferenceType;
	}
}
