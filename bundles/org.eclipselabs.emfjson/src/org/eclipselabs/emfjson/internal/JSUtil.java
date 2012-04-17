package org.eclipselabs.emfjson.internal;

import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

public class JSUtil {

	public static JsonParser getJsonParser(URL url) {
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

	public static JsonParser getJsonParser(InputStream inStream) {
		final JsonFactory jsonFactory = new JsonFactory();  
		JsonParser jp = null;
		try {
			jp = jsonFactory.createJsonParser(inStream);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return jp;
	}

	public static JsonNode getRootNode(JsonParser jp) {
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

	public static JsonNode getNode(Resource resource, URI objectURI, EClass eClass) {
		URI fileURI = objectURI.trimFragment();
		ResourceSet resourceSet = resource.getResourceSet();
		URIConverter uriConverter = resourceSet.getURIConverter();

		String slash = "/";
		String current = slash;
		try {
			InputStream inStream = uriConverter.createInputStream(fileURI);
			JsonParser parser = getJsonParser(inStream);
			JsonNode root = getRootNode(parser);

			return findNode(root, resourceSet, current, objectURI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static JsonNode findNode(JsonNode node, ResourceSet resourceSet, String fragment, URI objectURI) {
		if (node.isArray()) {
			int pos = 0;
			String idx = fragment;
			for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
				idx = fragment + pos;
				JsonNode current = it.next();
				
				final EClass currentEClass = getEClass(current, resourceSet);
				if (currentEClass != null) {
					EAttribute id = currentEClass.getEIDAttribute();
					if (id != null) {
						if (objectURI.trimFragment().appendFragment(current.get(id.getName()).asText()).equals(objectURI)) {
							return current;
						}
					} else {
						if (objectURI.trimFragment().appendFragment(idx).equals(objectURI)) {
							return current;
						}
					}

					for (EReference reference: currentEClass.getEAllContainments()) {
						if (current.has(reference.getName())) {
							JsonNode found = findNode(
									current.get(reference.getName()), 
									resourceSet, 
									idx += "/@"+reference.getName() + (reference.isMany() ? "." : ""), 
									objectURI);
							if (found != null) {
								return found;
							}
						}
					}
				}

				pos++;
			}
		} else {
			final EClass currentEClass = getEClass(node, resourceSet);
			if (currentEClass != null) {
				EAttribute id = currentEClass.getEIDAttribute();
				if (id != null) {
					if (objectURI.trimFragment().appendFragment(node.get(id.getName()).asText()).equals(objectURI)) {
						return node;
					}
				} else {
					if (objectURI.trimFragment().appendFragment(fragment).equals(objectURI)) {
						return node;
					}
				}

				for (EReference reference: currentEClass.getEAllContainments()) {
					if (node.has(reference.getName())) {
						JsonNode found = findNode(
								node.get(reference.getName()), 
								resourceSet, 
								fragment += "/@"+reference.getName() + (reference.isMany() ? "." : ""), 
								objectURI);
						if (found != null) {
							return found;
						}
					}
				}
			}
		}

		return null;
	}

	public static EClass getEClass(JsonNode node, ResourceSet resourceSet) {
		if (node.has(EJS_TYPE_KEYWORD)) {
			return (EClass) resourceSet.getEObject(URI.createURI(node.get(EJS_TYPE_KEYWORD).getTextValue()), false);
		} else {
			return null;
		}
	}

}
