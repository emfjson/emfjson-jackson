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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * 
 * @author guillaume hillairet
 *
 */
public class EJsUtil {
	
	public static String getElementName(EStructuralFeature feature) {
		final EAnnotation annotation = feature.getEAnnotation("JSON");
		if (annotation != null && annotation.getDetails().containsKey("element")) {
			return annotation.getDetails().get("element");
		}
		return feature.getName();
	}

	public static String getRootNode(EObject object) {
		if (object instanceof EClass) {
			EClass eClass = (EClass) object;
			
			if (eClass.getEAnnotation("JSON") != null) {
				EAnnotation annotation = eClass.getEAnnotation("JSON");
				
				if (annotation.getDetails().containsKey("root")) {
					if (annotation.getDetails().containsKey("element")) {
						return annotation.getDetails().get("element");
					} else {
						return null;
					}
					
				} else {
//					throw new IllegalArgumentException("The root class @JSON annotation must contain root and element details.");
					return null;
				}
				
			} else {
				return null;
//				throw new IllegalArgumentException("The root class must be annotated with @JSON annotation.");
			}
			
		} else {
			throw new IllegalArgumentException("Option must contain the root class.");
		}
	}
	
	public static URL getURL(URI uri, Object parameters) throws MalformedURLException {
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

	public static EClass findEClass(EClass eReferenceType, JsonNode node) {
		if (eReferenceType.isAbstract() || node.get("type") != null) {
			@SuppressWarnings("deprecation")
			String type = node.get("type").getValueAsText();
			if (type.equals(eReferenceType.getName())) {
				return eReferenceType;
			} else {
				EClassifier found = eReferenceType.getEPackage().getEClassifier(type);
				if (found != null && found instanceof EClass) {
					return (EClass) found;
				} else {
					throw new IllegalArgumentException("Cannot find EClass from type "+type);
				}
			}
		}
		return eReferenceType;
	}
}
