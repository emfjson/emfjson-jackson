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
package com.emfjson.internal;

import static com.emfjson.internal.JSONEcoreUtil.getElementName;
import static com.emfjson.internal.JSONEcoreUtil.getRootNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.emfjson.resource.JSONResource;

/**
 * {@link JSONLoader} creates the tree of EObject from a JSON tree.
 * 
 * @author guillaume
 *
 */
public class JSONLoader {

	public void loadResource(Resource resource, Map<?, ?> options) {
		URL url = null;
		try {
			url = getURL(resource.getURI(), options.get(JSONResource.OPTION_URL_PARAMETERS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (url != null) {
			final JsonFactory jsonFactory = new JsonFactory();  
			JsonParser jp = null;
			try {
				jp = jsonFactory.createJsonParser(url);
			} catch (JsonParseException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			final ObjectMapper mapper = new ObjectMapper();
			if (jp != null) {
				JsonNode rootNode = null;
				try {
					rootNode = mapper.readValue(jp, JsonNode.class);
				} catch (JsonParseException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				if (rootNode != null) {
					try {
						EClass rootClass = (EClass) options.get(JSONResource.OPTION_ROOT_ELEMENT);
						String path = getRootNode(options.get(JSONResource.OPTION_ROOT_ELEMENT));

						JsonNode root = rootNode.findPath(path);
						if (root != null) {
							EObject rootObject = EcoreUtil.create(rootClass);
							fillEAttribute(rootObject, rootClass, root);
							fillEReference(rootObject, rootClass, root);

							resource.getContents().add(rootObject);
						}
					} catch (ClassCastException e) {
						e.printStackTrace();
					}
				}
			}
		}	
	}

	private URL getURL(URI uri, Object parameters) throws MalformedURLException {
		URI outURI = uri;
		if (parameters != null && parameters instanceof Map) {
			Map<?, ?> map = (Map<?,?>) parameters;
			for (Object key: map.keySet()) {
				String query = key+"="+(String) map.get(key);
				if (outURI.hasQuery()) {
					outURI = URI.createURI(outURI+"&"+query);
				} else {
					outURI = outURI.appendQuery(query);
				}
			}
		}

		return new URL(outURI.toString());
	}

	private void fillEReference(EObject rootObject, EClass rootClass, JsonNode root) {
		for (EReference reference: rootClass.getEAllReferences()) {
			if (reference.isMany()) {
				for (JsonNode node: root.findValues(getElementName(reference))) {
					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
							JsonNode n = it.next();
							EObject obj = createEObject(reference.getEReferenceType(), n);
							if (obj != null) {
								@SuppressWarnings("unchecked")
								EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);
								values.add(obj);
							}
						}
					} else {
						EObject obj = createEObject(reference.getEReferenceType(), node);
						if (obj != null) {
							@SuppressWarnings("unchecked")
							EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);
							values.add(obj);
						}
					}
				}
			}
		}
	}

	private EObject createEObject(EClass eClass, JsonNode node) {
		EObject obj = EcoreUtil.create(eClass);
		fillEAttribute(obj, eClass, node);

		return obj;
	}

	private void fillEAttribute(EObject obj, EClass eClass, JsonNode node) {
		for (EAttribute attribute: eClass.getEAllAttributes()) {
			if (!attribute.isMany() && attribute.isChangeable()) {
				fillUniqueEAttribute(obj, attribute, node);
			} else if (attribute.isChangeable()) {
				fillManyEAttribute(obj, attribute, node);
			}
		}
	}

	protected void fillManyEAttribute(EObject obj, EAttribute attribute, JsonNode node) {
		ArrayList<Object> values = new ArrayList<Object>();
		for (JsonNode n: node.findValues(getElementName(attribute))) {
			if (n.isArray()) {
				for (Iterator<JsonNode> it = n.getElements(); it.hasNext();) {
					String stringValue = it.next().getTextValue();
					if (stringValue != null) {
						Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
						values.add(newValue);
					}
				}
			} else {
				String stringValue = n.getValueAsText();
				if (stringValue != null) {
					Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
					values.add(newValue);
				}
			}
		}
		obj.eSet(attribute, values);
	}

	protected void fillUniqueEAttribute(EObject obj, EAttribute attribute, JsonNode node) {
		JsonNode value = node.findValue(getElementName(attribute));
		if (value != null) {
			String stringValue = value.getValueAsText();
			if (stringValue != null) {
				Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
				obj.eSet(attribute, newValue);
			}
		}
	}

}
