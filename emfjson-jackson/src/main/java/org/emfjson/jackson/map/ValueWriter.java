package org.emfjson.jackson.map;

import static org.eclipse.emf.ecore.util.EcoreUtil.convertToString;
import static org.emfjson.jackson.map.Dates.dateValue;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ValueWriter {

	public void serialize(ObjectNode node, String key, EAttribute attribute, Object value) {
		final EDataType type = attribute.getEAttributeType();
		if (attribute.isMany()) {
			serializeMany(node, key, type, (Collection<?>) value);
		} else {
			serializeValue(node, key, type, value);
		}
	}

	public void serializeMany(ObjectNode node, String key, EDataType type, Collection<?> values) {
		if (values == null || values.isEmpty()) return;

		ArrayNode arrayNode = node.arrayNode();
		node.set(key, arrayNode);

		for (Object value: values) {
			if (value instanceof String) {
				arrayNode.add((String) value);
			}
			else if (value instanceof Integer) {
				arrayNode.add((Integer) value);
			}
			else if (value instanceof Boolean) {
				arrayNode.add((Boolean) value);
			}
			else if (value instanceof Date) {
				arrayNode.add(dateValue((Date) value));
			}
			else if (value instanceof Double) {
				arrayNode.add((Double) value);
			}
			else if (value instanceof Long) {
				arrayNode.add((Long) value);
			}
			else if (value instanceof Short) {
				arrayNode.add((Short) value);
			}
			else if (value instanceof Float) {
				arrayNode.add((Float) value);
			}
			else {
				arrayNode.add((String) convertToString(type, value));
			}
		}
	}

	public void serializeValue(ObjectNode node, String key, EDataType type, Object value) {
		if (value == null) return;

		if (value instanceof String) {
			node.put(key, (String) value);
		}
		else if (value instanceof Integer) {
			node.put(key, (Integer) value);
		}
		else if (value instanceof Boolean) {
			node.put(key, (Boolean) value);
		}
		else if (value instanceof Date) {
			node.put(key, dateValue((Date) value));
		}
		else if (value instanceof Double) {
			node.put(key, (Double) value);
		}
		else if (value instanceof Long) {
			node.put(key, (Long) value);
		}
		else if (value instanceof Short) {
			node.put(key, (Short) value);
		}
		else if (value instanceof Float) {
			node.put(key, (Float) value);
		}
		else {
			node.put(key, (String) convertToString(type, value));
		}
	}

}
