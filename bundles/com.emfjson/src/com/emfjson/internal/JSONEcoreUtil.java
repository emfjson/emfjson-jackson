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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * 
 * @author guillaume
 *
 */
public class JSONEcoreUtil {
	
	public static String getElementName(EStructuralFeature feature) {
		EAnnotation annotation = feature.getEAnnotation("JSON");
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
				if (annotation.getDetails().containsKey("root") && annotation.getDetails().containsKey("element")) {
					return annotation.getDetails().get("element");
				} else {
					throw new IllegalArgumentException("The root class @JSON annotation must contain root and element details.");
				}
			} else {
				throw new IllegalArgumentException("The root class must be annotated with @JSON annotation.");
			}
		} else {
			throw new IllegalArgumentException("Option must contain the root class.");
		}
	}
}
