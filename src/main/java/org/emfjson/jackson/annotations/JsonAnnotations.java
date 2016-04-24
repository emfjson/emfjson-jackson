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
package org.emfjson.jackson.annotations;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JsonAnnotations {

	public static String getElementName(EStructuralFeature feature) {
		final EAnnotation annotation = feature.getEAnnotation("JsonProperty");
		if (annotation != null && annotation.getDetails().containsKey("value")) {
			return annotation.getDetails().get("value");
		}
		return feature.getName();
	}

	public static boolean shouldIgnore(EStructuralFeature feature) {
		return feature.getEAnnotation("JsonIgnore") != null;
	}

}
