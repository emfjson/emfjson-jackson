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

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

import com.fasterxml.jackson.databind.JsonNode;

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

    public static EAttribute getEAttribute(EClass eClass, String key) {
        if (eClass == null || key == null)
            return null;

        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(key);
        if (eStructuralFeature == null) {
            int i = 0;
            while (i < eClass.getEAllAttributes().size() && eStructuralFeature == null) {
                EAttribute eAttribute = eClass.getEAllAttributes().get(i);
                if (key.equals(getElementName(eAttribute))) {
                    eStructuralFeature = eAttribute;
                }
                i++;
            }
        }
        return eStructuralFeature instanceof EAttribute ? (EAttribute) eStructuralFeature : null;
    }

    public static EReference getEReference(EClass eClass, String key) {
        if (eClass == null || key == null)
            return null;

        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(key);
        if (eStructuralFeature == null) {
            int i = 0;
            while (i < eClass.getEAllStructuralFeatures().size() && eStructuralFeature == null) {
                EStructuralFeature current = eClass.getEAllStructuralFeatures().get(i);
                if (key.equals(getElementName(current))) {
                    eStructuralFeature = current;
                }
                i++;
            }
        }

        return eStructuralFeature instanceof EReference ? (EReference) eStructuralFeature : null;
    }

    public static EStructuralFeature getDynamicMapEntryFeature(EClass eClass) {
        if (eClass == null)
            return null;

        EStructuralFeature eMapEntry = null;
        int i = 0;

        while (i < eClass.getEAllStructuralFeatures().size() && eMapEntry == null) {
            EStructuralFeature eFeature = eClass.getEAllStructuralFeatures().get(i);
            if (isDynamicMapEntryFeature(eFeature)) {
                eMapEntry = eFeature;
            }
            i++;
        }

        return eMapEntry;
    }

    public static boolean isDynamicMapEntryFeature(EStructuralFeature eFeature) {
        if (eFeature != null && isMapEntry(eFeature.getEType())) {
            EAnnotation annotation = eFeature.getEAnnotation(EJS_JSON_ANNOTATION);
            if (annotation != null && annotation.getDetails().containsKey("dynamicMap")) {
                return Boolean.parseBoolean(annotation.getDetails().get("dynamicMap"));
            }
        }
        return false;
    }

    public static boolean isMapEntry(EClassifier eType) {
        return eType != null && eType.equals(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
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

    /**
     * Returns resolvable EObject URI from a JSON reference node, using the
     * namespace map is available.
     * 
     * <pre>
     * example: 
     * {"$ref": "#//fragment"} returns resourceURI + #//fragment
     * {"$ref": "model://fragment"} returns resolve URI against nsMap + #//fragement 
     * {"$ref": "id"} returns resourceURI + #id
     * </pre>
     * 
     **/
    public static URI getEObjectURI(JsonNode jsonNode, Resource resource, Map<String, String> nsMap) {
        if (jsonNode == null)
            return null;

        if (nsMap == null) {
            nsMap = Collections.emptyMap();
        }

        final String value = jsonNode.asText();

        if (value.startsWith("#//")) {
            // is fragment
            return resource.getURI().appendFragment(value.substring(1));
        } else if (value.contains(":")) {
            String[] split = value.split(":");
            // is namespaced prefix:fragment
            if (split.length == 2) {
                if (nsMap.keySet().contains(split[0])) {
                    String nsURI = nsMap.get(split[0]);
                    return URI.createURI(nsURI).appendFragment(split[1]);
                }
            }
            return URI.createURI(value);
        } else { // is ID
            return resource.getURI().appendFragment(value.startsWith("#") ? value.substring(1) : value);
        }
    }

}
