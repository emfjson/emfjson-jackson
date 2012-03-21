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
package org.eclipselabs.emfjson.gwt.internal;

import static org.eclipselabs.emfjson.gwt.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.gwt.common.Constants.EJS_TYPE_KEYWORD;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JSONLoad {

	private JSONValue rootNode;
	private ResourceSet resourceSet;
	private final Map<String, String> nsMap = new HashMap<String, String>();

	public JSONLoad(InputStream inStream, Map<?,?> options) {
//		this.options = options;
		rootNode = JSONParser.parseStrict(toString(inStream));
	}
	
	protected EClass getEClass(JSONObject js) {
		if (js.containsKey("eClass")){
			JSONString value = js.get("eClass").isString();
			if (value != null){
				return getEClass(URI.createURI(value.stringValue()));
			}
		}
		return null;
	}

	private EClass getEClass(URI uri) {
		if (resourceSet == null) {
			return (EClass) new ResourceSetImpl().getEObject(uri, false);	
		}
		return (EClass) resourceSet.getEObject(uri, false);
	}
	
	public Collection<EObject> fillResource(Resource resource) {
		this.resourceSet = resource.getResourceSet() != null ? resource.getResourceSet() : new ResourceSetImpl();
		final Collection<EObject> result = resource.getContents();

		JSONObject rootObject = rootNode.isObject();
		if (rootObject != null){
			EClass eClass = getEClass(rootObject);
			final EObject eObject = EcoreUtil.create(eClass);
			result.add(eObject);

			fillEAttribute(eObject, eClass, rootObject);
			fillEReference(eObject, eClass, rootObject, resource);
		}

		return null;
	}

	private void fillEAttribute(EObject obj, EClass eClass, JSONObject root) {
		for (EAttribute attribute: eClass.getEAllAttributes()) {
			JSONValue node = root.get(attribute.getName());
			if (node != null) {
				JSONArray array = node.isArray();
				if (array != null) {
					for (int i=0; i<array.size(); i++) {
						JSONValue value = array.get(i);
						setEAttributeValue(obj, attribute, value);
					}
				} else {
					setEAttributeValue(obj, attribute, node);
				}
			}
		}
	}

	private void setEAttributeValue(EObject obj, EAttribute attribute, JSONValue node) {
		JSONString string = node.isString();
		if (string != null) {
			setEAttributeStringValue(obj, attribute, string);
		} else {
			JSONNumber number = node.isNumber();
			if (number != null) {
				setEAttributeIntegerValue(obj, attribute, number);
			} else {
				JSONBoolean bool = node.isBoolean();
				if (bool != null) {
					setEAttributeBooleanValue(obj, attribute, bool);
				}
			}
		}
	}
	
	private void setEAttributeStringValue(EObject obj, EAttribute attribute, JSONString value) {
		final String stringValue = value.stringValue();
		
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
	
	private void setEAttributeIntegerValue(EObject obj, EAttribute attribute, JSONNumber value) {
		final int intValue = (int) value.doubleValue();
		
		if (!attribute.isMany()) {
			obj.eSet(attribute, intValue);
		} else {
			@SuppressWarnings("unchecked")
			Collection<Object> values = (Collection<Object>) obj.eGet(attribute);
			values.add(intValue);
		}
	}
	
	private void setEAttributeBooleanValue(EObject obj, EAttribute attribute, JSONBoolean value) {
		final boolean boolValue = value.booleanValue();
		
		if (!attribute.isMany()) {
			obj.eSet(attribute, boolValue);
		} else {
			@SuppressWarnings("unchecked")
			Collection<Object> values = (Collection<Object>) obj.eGet(attribute);
			values.add(boolValue);
		}
	}

	private void fillEReference(EObject rootObject, EClass rootClass, JSONObject root, Resource resource) {
		for (EReference reference: rootClass.getEAllReferences()) {
			final JSONValue node = root.get(reference.getName());

			if (node != null) {

				if (reference.isMany()) {
					@SuppressWarnings("unchecked")
					EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);

					JSONArray array = node.isArray();
					if (array != null) {
						for (int i=0; i<array.size(); i++) {
							JSONValue value = array.get(i); 
							JSONObject current = value.isObject();
							if (current != null){
								EClass eClass = findEClass(reference.getEReferenceType(), current, root, resource);
								EObject obj = createEObject(resource, eClass, current);
								if (obj != null) {
									values.add(obj);
								}
							}
						}
					} else {
						JSONObject current = node.isObject();
						if (current != null){
							EClass eClass = findEClass(reference.getEReferenceType(), current, root, resource);
							EObject obj = createEObject(resource, eClass, current);
							if (obj != null) values.add(obj);
						}
					}
				} else {
					JSONObject current = node.isObject();
					if (current != null) {
						EClass eClass = findEClass(reference.getEReferenceType(), current, root, resource);
						EObject obj = createEObject(resource, eClass, current);

						if (obj != null) rootObject.eSet(reference, obj);
					}
				}

			}
		}
	}

	private EObject createEObject(Resource resource, EClass eClass, JSONObject node) {
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

	private EClass findEClass(EClass eReferenceType, JSONObject node, JSONObject root, Resource resource) {
		if (eReferenceType.isAbstract() || node.get(EJS_TYPE_KEYWORD) != null) {

			if (node.containsKey(EJS_REF_KEYWORD)) {
				URI refURI = getEObjectURI(node.get(EJS_REF_KEYWORD), resource);
				EObject found = resourceSet.getEObject(refURI, false); 
				if (found != null) {
					return found.eClass();
				}
				if (node.containsKey(EJS_TYPE_KEYWORD)) {
					JSONString typeValue = node.get(EJS_TYPE_KEYWORD).isString();
					return (EClass) resourceSet.getEObject(URI.createURI(typeValue.stringValue()), false);
				}
				//				JsonNode refNode = findNode(refURI, eReferenceType, rootNode);
				//				if (refNode != null) {
				//					return findEClass(eReferenceType, refNode, root, resource);
				//				}
			} 
			else if (node.containsKey(EJS_TYPE_KEYWORD)) {
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

	private URI getEObjectURI(JSONValue jsonValue, Resource resource) {
		final JSONString string = jsonValue.isString();
		final String value = string == null ? "" : string.stringValue();

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

	public String toString(InputStream inStream) {
		final StringBuilder out = new StringBuilder();
		byte[] b = new byte[4096];
		try {
			for (int n; (n = inStream.read(b)) != -1;) {
				out.append(new String(b, 0, n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
	}
}
