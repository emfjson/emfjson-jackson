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
package org.eclipselabs.emfjson.common;

import static org.eclipselabs.emfjson.common.Constants.EJS_ELEMENT_ANNOTATION;
import static org.eclipselabs.emfjson.common.Constants.EJS_JSON_ANNOTATION;
import static org.eclipselabs.emfjson.common.Constants.EJS_ROOT_ANNOTATION;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * 
 * @author ghillairet
 *
 */
public class ModelUtil {
	
	public static String getElementName(EStructuralFeature feature) {
		final EAnnotation annotation = feature.getEAnnotation(EJS_JSON_ANNOTATION);
		if (annotation != null && annotation.getDetails().containsKey(EJS_ELEMENT_ANNOTATION)) {
			return annotation.getDetails().get(EJS_ELEMENT_ANNOTATION);
		}
		return feature.getName();
	}

    public static boolean isAnonRoot(EStructuralFeature feature) {
        final EAnnotation annotation = feature.getEAnnotation(EJS_JSON_ANNOTATION);
        if (annotation != null && annotation.getDetails().containsKey("AnonRoot")) {
            return annotation.getDetails().get("AnonRoot").equals("true");
        }
        return false;
    }	
	
	public static String getRootNode(EObject object) {
		if (object instanceof EClass) {
			EClass eClass = (EClass) object;

			if (eClass.getEAnnotation(EJS_JSON_ANNOTATION) != null) {
				EAnnotation annotation = eClass.getEAnnotation(EJS_JSON_ANNOTATION);

				if (annotation.getDetails().containsKey(EJS_ROOT_ANNOTATION)) {
					if (annotation.getDetails().containsKey(EJS_ELEMENT_ANNOTATION)) {
						return annotation.getDetails().get(EJS_ELEMENT_ANNOTATION);
					}
				}
			}
			return null;
		}
		return null;
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
	
	public static URI getEObjectURI(JsonNode jsonNode, URI uri, Map<String, String> nsMap) {
		if (jsonNode == null) return null;
		
		final String value = jsonNode.getTextValue();
		if (value.startsWith("#//")) { // is fragment
			return URI.createURI(uri+value);
		} else if (value.contains("#//") && nsMap.keySet().contains(value.split("#//")[0])) {
			String[] split = value.split("#//");
			String nsURI = nsMap.get(split[0]);
			return URI.createURI(nsURI+"#//"+split[1]);
		} else if (value.contains(":")) {
			return URI.createURI(value);
		} else { // is ID
			return uri.appendFragment(value);
		}
	}
	
	public static boolean isMapEntry(EClassifier eType) {
		return eType.equals(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
	}
	
}
