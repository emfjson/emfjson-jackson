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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

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

}
