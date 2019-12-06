/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */
package org.emfjson.jackson.annotations;

import org.eclipse.emf.ecore.*;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.emfjson.jackson.annotations.EcoreTypeInfo.USE.CLASS;
import static org.emfjson.jackson.annotations.EcoreTypeInfo.USE.NAME;

public class JsonAnnotations {

	private static final String EXTENDED_METADATA = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";

	/**
	 * Returns the name that should be use to serialize the property.
	 *
	 * @param element
	 * @return name of property
	 */
	public static String getElementName(ENamedElement element) {
		String value = getValue(element, "JsonProperty", "value");
		if (value == null) {
			value = getValue(element, EXTENDED_METADATA, "name");
		}

		return value == null ? element.getName(): value;
	}

	/**
	 * Returns the configured alias name or null, if there is none.
	 *
	 * @param element any element
	 * @return the property's alias
	 */
	public static List<String> getAliases(ENamedElement element) {
		return getValues(element, "JsonAlias", "value");
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
	public static EcoreTypeInfo getTypeProperty(final EClassifier classifier) {
		String property = getValue(classifier, "JsonType", "property");
		String use = getValue(classifier, "JsonType", "use");

		ValueReader<String, EClass> valueReader = EcoreTypeInfo.defaultValueReader;
		ValueWriter<EClass, String> valueWriter = EcoreTypeInfo.defaultValueWriter;

		if (use != null) {
			EcoreTypeInfo.USE useType = EcoreTypeInfo.USE.valueOf(use.toUpperCase());

			if (useType == NAME) {
				valueReader = (value, context) -> {
					EClass type = value != null && value.equalsIgnoreCase(classifier.getName()) ? (EClass) classifier: null;
					if (type == null) {
						type = EMFContext.findEClassByName(value, classifier.getEPackage());
					}
					return type;
				};
				valueWriter = (value, context) -> value.getName();
			} else if (useType == CLASS) {
				valueReader = (value, context) -> {
					EClass type = value != null && value.equalsIgnoreCase(classifier.getInstanceClassName()) ? (EClass) classifier: null;
					if (type == null) {
						type = EMFContext.findEClassByQualifiedName(value, classifier.getEPackage());
					}
					return type;
				};
				valueWriter = (value, context) -> value.getInstanceClassName();
			} else {
				valueReader = EcoreTypeInfo.defaultValueReader;
				valueWriter = EcoreTypeInfo.defaultValueWriter;
			}
		}

		return property != null ? new EcoreTypeInfo(property, valueReader, valueWriter): null;
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

	protected static List<String> getValues(ENamedElement element, String annotation, String property) {
		String value = getValue(element, annotation, property);

		if (value == null) {
			return Collections.emptyList();
		}

		if (value.contains(",")) {
			String[] split = value.split(",");
			List<String> values = new ArrayList<>();
			for (String s : split) {
				String v = s.trim();
				if (!v.isEmpty()) {
					values.add(v);
				}
			}
			return values;
		} else {
			return Collections.singletonList(value);
		}
	}
}
