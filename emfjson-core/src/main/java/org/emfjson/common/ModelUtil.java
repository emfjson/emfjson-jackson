/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.common;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;

import static org.emfjson.common.Constants.EJS_ELEMENT_ANNOTATION;
import static org.emfjson.common.Constants.EJS_JSON_ANNOTATION;

public class ModelUtil {

	public static String getElementName(EStructuralFeature feature) {
		final EAnnotation annotation = feature.getEAnnotation(EJS_JSON_ANNOTATION);
		if (annotation != null && annotation.getDetails().containsKey(EJS_ELEMENT_ANNOTATION)) {
			return annotation.getDetails().get(EJS_ELEMENT_ANNOTATION);
		}
		return feature.getName();
	}

}
