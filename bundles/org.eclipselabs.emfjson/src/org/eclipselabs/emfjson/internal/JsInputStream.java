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

import static org.eclipselabs.emfjson.internal.EJsUtil.getElementName;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.JsURIHandlerImpl;


/**
 * 
 * @author guillaume hillairet
 *
 */
public class JsInputStream extends InputStream implements URIConverter.Loadable {

	@SuppressWarnings("unused")
	private URI uri;
	private Map<?, ?> options;

	public JsInputStream(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options;
	}

	@Override
	public void loadResource(Resource resource) throws IOException {
		URL url = null;
		try {
			url = getURL(resource.getURI(), options.get(JsURIHandlerImpl.OPTION_URL_PARAMETERS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		final JsonParser jp = getJsonParser(url);
		final JsonNode rootNode = jp != null ? getRootNode(jp) : null;
		
		Collection<EObject> roots = rootNode != null ? loadRootEObject(rootNode, options) : Collections.<EObject> emptyList();
		
		resource.getContents().addAll(roots);
	}

	private JsonNode getRootNode(JsonParser jp) {
		final ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;

		if (jp != null) {
			try {
				rootNode = mapper.readValue(jp, JsonNode.class);
			} catch (JsonParseException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return rootNode;
	}

//	private JsonParser getJsonParser(InputStream inStream) {
//		final JsonFactory jsonFactory = new JsonFactory();  
//		JsonParser jp = null;
//		try {
//			jp = jsonFactory.createJsonParser(inStream);
//		} catch (JsonParseException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		return jp;
//	}

	private JsonParser getJsonParser(URL url) {
		final JsonFactory jsonFactory = new JsonFactory();  
		JsonParser jp = null;
		try {
			jp = jsonFactory.createJsonParser(url);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return jp;
	}

	/**
	 * Returns the root object(s).
	 * 
	 * @param rootNode
	 * @param options
	 * @return
	 */
	protected Collection<EObject> loadRootEObject(JsonNode rootNode, Map<?, ?> options) { 
		if (rootNode == null) {
			return null;
		}

		final EClass rootClass = (EClass) options.get(JsURIHandlerImpl.OPTION_ROOT_ELEMENT);
		final String path = EJsUtil.getRootNode((EObject) options.get(JsURIHandlerImpl.OPTION_ROOT_ELEMENT));
		final JsonNode root;
		if (path == null) {
			root = rootNode;
		} else {
			root = rootNode.findPath(path);
		}

		if (root == null) {
			return null;
		}
		
		final Collection<EObject> result = new BasicEList<EObject>();
		if (root.isArray()) {
			for (Iterator<JsonNode> it = root.getElements(); it.hasNext();) {
				JsonNode node = it.next();
				final EObject rootObject = EcoreUtil.create(rootClass);
				fillEAttribute(rootObject, rootClass, node);
				fillEReference(rootObject, rootClass, node);
				
				result.add(rootObject);
			}
		} else {
			final EObject rootObject = EcoreUtil.create(rootClass);
			fillEAttribute(rootObject, rootClass, root);
			fillEReference(rootObject, rootClass, root);
			
			result.add(rootObject);
		}

		return result;
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
							setEReferenceValues(rootObject, reference, it.next());
						}
					} else {
						setEReferenceValues(rootObject, reference, node);
					}
				}
			} else {
				final JsonNode node = root.findValue(getElementName(reference));
				if (node != null) {
					setEReferenceValues(rootObject, reference, node);
				}
			}
		}
	}

	private void setEReferenceValues(EObject rootObject, EReference reference, JsonNode n) {
		final EObject obj = createEObject(reference.getEReferenceType(), n);
		if (obj != null) {
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);
				values.add(obj);
			} else {
				rootObject.eSet(reference, obj);
			}
		}
	}

	private EObject createEObject(EClass eClass, JsonNode node) {
		EObject obj = EcoreUtil.create(eClass);
		fillEAttribute(obj, eClass, node);
		fillEReference(obj, eClass, node);

		return obj;
	}

	private void fillEAttribute(EObject obj, EClass eClass, JsonNode node) {
		for (EAttribute attribute: eClass.getEAllAttributes()) {
			if (!attribute.isMany() && attribute.isChangeable()) {
				fillUniqueEAttribute(obj, attribute, node);
			} else if (attribute.isMany() && attribute.isChangeable()) {
				fillManyEAttribute(obj, attribute, node);
			}
		}
	}

	protected void fillManyEAttribute(EObject obj, EAttribute attribute, JsonNode node) {
		ArrayList<Object> values = new ArrayList<Object>();
		for (JsonNode n: node.findValues(getElementName(attribute))) {
			if (n.isArray()) {
				// get values from array
				for (Iterator<JsonNode> it = n.getElements(); it.hasNext();) {
					setEAttributeValue(obj, attribute, it.next());
				}
			} else {
				setEAttributeValue(obj, attribute, n);
			}
		}
		obj.eSet(attribute, values);
	}

	protected void fillUniqueEAttribute(EObject obj, EAttribute attribute, JsonNode node) {
		JsonNode value = node.findValue(getElementName(attribute));
		if (value != null) {
			setEAttributeValue(obj, attribute, value);
		}
	}

	protected void setEAttributeValue(EObject obj, EAttribute attribute, JsonNode value) {
		final String stringValue = value.getValueAsText();
		if (stringValue != null && !stringValue.trim().isEmpty()) {
			Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
			if (!attribute.isMany()) {
				obj.eSet(attribute, newValue);
			} else {
				@SuppressWarnings("unchecked")
				Collection<Object> values = (Collection<Object>) obj.eGet(attribute);
				values.add(newValue);
			}
		}
	}
	
	@Override
	public int read() throws IOException {
		return 0;
	}

}
