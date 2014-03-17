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

import static org.eclipse.emf.ecore.util.EcoreUtil.convertToString;
import static org.eclipselabs.emfjson.common.ModelUtil.getElementName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author ghillairet
 * @since 0.6.0
 */
class EAttributeSerializer {

	private final Serializer serializer;

	EAttributeSerializer(Serializer serializer) {
		this.serializer = serializer;
	}

	void serialize(EObject eObject, ObjectNode node) {
		for (EAttribute eAttribute: eObject.eClass().getEAllAttributes()) {

			if (isCandidate(eObject, eAttribute)) {
				if (isFeatureMap(eAttribute)) {
					serializeFeatureMap(eObject, eAttribute, node);
				}
				else if (eAttribute.isMany()) {
					serializeMany(eObject, eAttribute, node);
				}
				else {
					serializeValue(node, eAttribute, eObject.eGet(eAttribute));
				}
			}
		}
	}

	void serializeMany(EObject eObject, EAttribute eAttribute, ObjectNode node) {
		final EList<?> rawValues = (EList<?>) eObject.eGet(eAttribute);

		if (!rawValues.isEmpty()) {
			ArrayNode arrayNode = node.arrayNode();
			node.put(getElementName(eAttribute), arrayNode);

			for (Object val: rawValues) {
				serializeValue(arrayNode, eAttribute, val);
			}
		}
	}

	void serializeFeatureMap(EObject eObject, EAttribute eAttribute, ObjectNode node) {
		final FeatureMap.Internal featureMap = (FeatureMap.Internal) eObject.eGet(eAttribute);
		final Iterator<FeatureMap.Entry> iterator = featureMap.basicIterator();

		while (iterator.hasNext()) {
			FeatureMap.Entry entry = iterator.next();
			EStructuralFeature feature = entry.getEStructuralFeature();
			Object value = entry.getValue();

			if (feature instanceof EAttribute) {
				serializeValue(node, (EAttribute) feature, value);
			} else if (feature instanceof EReference) {
				if (((EReference) feature).isContainment()) {
					serializer.getReferenceSerializer().serializeContainments(eObject, (EReference) feature, node, eObject.eResource());
				} else {
					serializer.getReferenceSerializer().serializeReferences(node, eObject, (EReference) feature);
				}
			}
		}
	}

	static boolean isCandidate(EObject eObject, EAttribute eAttribute) {
		return (eObject.eIsSet(eAttribute) || eAttribute.getEType() instanceof EEnum) && 
				!eAttribute.isDerived() && 
				!eAttribute.isTransient() && 
				!eAttribute.isUnsettable();
	}

	boolean isFeatureMap(EAttribute eAttribute) {
		return FeatureMapUtil.isFeatureMap(eAttribute);
	}

	void serializeValue(JsonNode node, EAttribute attribute, Object value) {
		if (value == null) return;

		String key = getElementName(attribute);

		if (value instanceof Integer) {
			serializeInteger(node, key, (Integer) value);
		}
		else if (value instanceof Boolean) {
			serializeBoolean(node, key, (Boolean) value);
		}
		else if (value instanceof Date) {
			serializeDate(node, key, (Date) value);
		}
		else if (value instanceof Double) {
			serializeDouble(node, key, (Double) value);
		}
		else if (value instanceof Long) {
			serializeLong(node, key, (Long) value);
		}
		else if (value instanceof Short) {
			serializeShort(node, key, (Short) value);
		}
		else if (value instanceof Float) {
			serializeFloat(node, key, (Float) value);
		}
		else {
			serializeString(node, key, 
					convertToString(attribute.getEAttributeType(),
							value));
		}
	}

	void serializeString(JsonNode node, String key, String value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeBoolean(JsonNode node, String key, Boolean value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeInteger(JsonNode node, String key, Integer value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeDouble(JsonNode node, String key, Double value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeLong(JsonNode node, String key, Long value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeShort(JsonNode node, String key, Short value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeFloat(JsonNode node, String key, Float value) {
		if (node.isObject()) {
			((ObjectNode)node).put(key, value);
		} else {
			((ArrayNode)node).add(value);
		}
	}

	void serializeDate(JsonNode node, String key, Date value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String dateValue = sdf.format(value);

		if (node.isObject()) {
			((ObjectNode)node).put(key, dateValue);
		} else {
			((ArrayNode)node).add(dateValue);
		}
	}

}
