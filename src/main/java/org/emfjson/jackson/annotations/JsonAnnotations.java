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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JsonAnnotations {

	/**
	 * Returns the name that should be use to serialize the property.
	 *
	 * @param element
	 * @return name of property
	 */
	public static String getElementName(ENamedElement element) {
		String value = getValue(element, "JsonProperty", "value");

		return value == null ? element.getName(): value;
	}

	/**
	 * Returns the configured alias name or null, if there is none.
	 *
	 * @param element any element
	 * @return the property's alias
	 */
	public static String getAliasName(ENamedElement element) {
		return getValue(element, "JsonAlias", "value");
	}

	/**
	 * Returns true if the feature should not be serialize.
	 *
	 * @param feature
	 * @return true if should not be serialize
	 */
	public static boolean shouldIgnore(EStructuralFeature feature) {
		return feature.getEAnnotation("JsonIgnore") != null;
	}

	/**
	 * Returns the property that should be use to store the type information of the classifier.
	 *
	 * @param classifier
	 * @return the type information property
	 */
	public static String getTypeProperty(EClassifier classifier) {
		return getValue(classifier, "JsonType", "property");
	}

	/**
	 * Returns true if the classifier type information should not be serialize.
	 * This is true when the classifier possesses an annotation @JsonType with include = "false".
	 *
	 * @param classifier
	 * @return true if type info should not be serialize
	 */
	public static boolean shouldIgnoreType(EClassifier classifier) {
		EAnnotation annotation = classifier.getEAnnotation("JsonType");

		return annotation != null && "false".equalsIgnoreCase(annotation.getDetails().get("include"));
	}

	/**
	 * Returns the property that should be use to serialize the identity of the object.
	 *
	 * @param classifier
	 * @return the identity property
	 */
	public static String getIdentityProperty(EClassifier classifier) {
		return getValue(classifier, "JsonIdentity", "property");
	}

	protected static String getValue(ENamedElement element, String annotation, String property) {
		EAnnotation ann = element.getEAnnotation(annotation);

		if (ann != null && ann.getDetails().containsKey(property)) {
			return ann.getDetails().get(property);
		}
		return null;
	}
}
