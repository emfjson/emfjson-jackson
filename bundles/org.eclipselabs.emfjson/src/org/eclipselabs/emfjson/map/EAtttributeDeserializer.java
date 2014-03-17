/*******************************************************************************
 * Copyright (c) 2013 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.map;

import static org.eclipselabs.emfjson.common.ModelUtil.getDynamicMapEntryFeature;
import static org.eclipselabs.emfjson.common.ModelUtil.getEAttribute;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

class EAtttributeDeserializer {

	private MapDeserializer mapDeserializer;

	EAtttributeDeserializer() {
		this.mapDeserializer = new MapDeserializer();
	}

	void deSerialize(EObject eObject, JsonNode node) {
		final EClass eClass = eObject.eClass();
		if (!node.isObject())
			return;

		final ObjectNode root = (ObjectNode) node;
		final EStructuralFeature dynamicMapEntry = getDynamicMapEntryFeature(eClass);

		// Iterates over all key values of the JSON Object,
		// if the value is not an object then
		// if the key corresponds to an EAttribute, fill it
		// if not and the EClass contains a MapEntry, fill it with the key,
		// value.
		for (Iterator<Entry<String, JsonNode>> it = root.fields(); it.hasNext();) {
			Entry<String, JsonNode> field = it.next();

			String key = field.getKey();
			JsonNode value = field.getValue();

			if (value.isObject()) // not an attribute
				continue;

			EAttribute attribute = getEAttribute(eClass, key);
			// we allow deserialization of derived feature to 
			// populate feature maps.
			if (attribute != null) {
				if (value.isArray()) {
					for (Iterator<JsonNode> itValue = value.elements(); itValue.hasNext();) {
						deSerializeValue(eObject, attribute, itValue.next());
					}
				} else {
					deSerializeValue(eObject, attribute, value);
				}
			} else if (dynamicMapEntry != null) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) eObject.eGet(dynamicMapEntry);
				values.add(mapDeserializer.deSerializeEntry(key, value));
			}
		}
	}

	void deSerializeValue(EObject eObject, EAttribute attribute, JsonNode value) {
		final String stringValue = value.asText();

		if (stringValue != null && !stringValue.trim().isEmpty()) {
			Object newValue;

			if (attribute.getEAttributeType().getInstanceClass().isEnum()) {
				newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue.toUpperCase());
			} else {
				newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
			}

			if (!attribute.isMany()) {
				eObject.eSet(attribute, newValue);
			} else {
				@SuppressWarnings("unchecked")
				Collection<Object> values = (Collection<Object>) eObject.eGet(attribute);
				values.add(newValue);
			}
		}
	}

}
