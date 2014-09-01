package org.eclipselabs.emfjson.gwt.map;

import static org.eclipse.emf.ecore.util.EcoreUtil.convertToString;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.emfjson.common.EObjects;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class Values {

	public void setOrAdd(EObject eObject, EAttribute attribute, JSONValue value) {
		final String stringValue;

		if (value.isString() != null)
		 stringValue = value.isString().stringValue();
		else if (value.isBoolean() != null)
			stringValue = Boolean.toString(value.isBoolean().booleanValue());
		else if (value.isNumber() != null)
			stringValue = value.toString();
		else stringValue = "";

		if (stringValue != null && !stringValue.trim().isEmpty()) {
			EObjects.setOrAdd(eObject, attribute, stringValue);
		}
	}

	public void serialize(JSONObject node, String key, EAttribute attribute, Object value) {
		final EDataType type = attribute.getEAttributeType();
		
		if (attribute.isMany()) {
			final Collection<?> values = (Collection<?>) value;
			final JSONArray array = new JSONArray();
			node.put(key, array);

			int i = 0;
			for (Object current: values) {
				serialize(array, i, type, current);
				i++;
			}
		} else {
			serializeValue(node, key, type, value);
		}
	}

	public void serializeValue(JSONObject node, String key, EDataType type, Object value) {
		if (value == null) return;

		if (value instanceof String) {
			node.put(key, new JSONString((String) value));	
		}
		else if (value instanceof Integer) {
			node.put(key, new JSONNumber((Integer) value));
		}
		else if (value instanceof Boolean) {
			node.put(key, JSONBoolean.getInstance((Boolean) value));
		}
		else if (value instanceof Date) {
			node.put(key, new JSONString(dateValue((Date) value)));
		}
		else if (value instanceof Double) {
			node.put(key, new JSONNumber((Double) value));
		}
		else if (value instanceof Long) {
			node.put(key, new JSONNumber((Long) value));
		}
		else if (value instanceof Short) {
			node.put(key, new JSONNumber((Short) value));
		}
		else if (value instanceof Float) {
			node.put(key, new JSONNumber((Float) value));
		}
		else {
			node.put(key, new JSONString(convertToString(type, value)));
		}
	}

	public void serialize(JSONArray node, int position, EDataType type, Object value) {
		if (value == null) return;

		if (value instanceof String) {
			node.set(position, new JSONString((String) value));	
		}
		else if (value instanceof Integer) {
			node.set(position, new JSONNumber((Integer) value));
		}
		else if (value instanceof Boolean) {
			node.set(position, JSONBoolean.getInstance((Boolean) value));
		}
		else if (value instanceof Date) {
			node.set(position, new JSONString(dateValue((Date) value)));
		}
		else if (value instanceof Double) {
			node.set(position, new JSONNumber((Double) value));
		}
		else if (value instanceof Long) {
			node.set(position, new JSONNumber((Long) value));
		}
		else if (value instanceof Short) {
			node.set(position, new JSONNumber((Short) value));
		}
		else if (value instanceof Float) {
			node.set(position, new JSONNumber((Float) value));
		}
		else {
			node.set(position, new JSONString(convertToString(type, value)));
		}
	}

	protected String dateValue(Date date) {
		DateTimeFormat formatter = DateTimeFormat.getFormat("yyyy-MM-dd'T'HH:mm:ss");
		return formatter.format(date);
	}

}
