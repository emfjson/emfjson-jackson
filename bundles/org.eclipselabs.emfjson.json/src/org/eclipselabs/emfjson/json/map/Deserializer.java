package org.eclipselabs.emfjson.json.map;

import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JField;
import org.eclipselabs.emfjson.json.JNode;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JSONFactory;
import org.eclipselabs.emfjson.json.JString;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Deserializer {

	private final JSONFactory factory = JSONFactory.eINSTANCE;

	public JNode from(JsonNode node, Resource resource, boolean isRoot) {
		if (node == null)
			return null;

		JNode result = null;

		if (node.isArray()) {
			result = from((ArrayNode) node, resource);
		} else if (node.isObject()) {
			result = from((ObjectNode) node, resource);
		} else if (node.isBoolean()) {
			result = createBoolean(node);
		} else if (node.isTextual()) {
			result = createString(node);
		} else if (node.isNumber()) {
			result = createNumber(node);
		} else if (node.isNull()) {
			result = factory.createJNull();
		}

		if (result != null && isRoot) {
			resource.getContents().add(result);
		}

		return result;
	}

	private JObject from(ObjectNode node, Resource resource) {
		JObject result = factory.createJObject();
		for (Iterator<Entry<String, JsonNode>> it = node.fields(); it.hasNext();) {
			Entry<String, JsonNode> current = it.next();
			JField field = factory.createJField();
			field.setKey(current.getKey());
			field.setValue(from(current.getValue(), resource, false));
			result.getFields().add(field);
		}
		return result;
	}

	private JArray from(ArrayNode node, Resource resource) {
		JArray result = factory.createJArray();
		for (Iterator<JsonNode> it = node.elements(); it.hasNext();) {
			JsonNode current = it.next();
			JNode converted = from(current, resource, false);
			result.getElements().add(converted);
		}
		return result;
	}

	private JString createString(JsonNode node) {
		JString result = factory.createJString();
		result.setStringValue(node.asText());
		return result;
	}

	private JBoolean createBoolean(JsonNode node) {
		JBoolean result = factory.createJBoolean();
		result.setBooleanValue(node.asBoolean());
		return result;
	}

	private JNumber createNumber(JsonNode node) {
		JNumber result = factory.createJNumber();
		result.setNumberValue(node.asInt());
		return result;
	}

}
