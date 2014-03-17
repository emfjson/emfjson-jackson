package org.eclipselabs.emfjson.json.map;

import java.util.Map.Entry;

import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JNode;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JString;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Serializer {

	public JsonNode to(JNode node, ObjectMapper mapper) {
		if (node instanceof JObject)
			return to((JObject) node, mapper);
		else
			return to((JArray) node, mapper);
	}

	public ObjectNode to(JObject node, ObjectMapper mapper) {
		ObjectNode result = mapper.createObjectNode();
		for (Entry<String, JNode> entry: node.getFields()) {
			setValue(result, entry.getKey(), entry.getValue(), mapper);
		}

		return result;
	}

	private void setValue(ObjectNode node, String key, JNode value, ObjectMapper mapper) {
		if (value instanceof JObject) {
			node.put(key, to((JObject) value, mapper));
		} else if (value instanceof JArray) {
			node.put(key, to((JArray) value, mapper));
		} else if (value instanceof JString) {
			node.put(key, ((JString) value).getStringValue());
		} else if (value instanceof JNumber) {
			double d = ((JNumber) value).getNumberValue();
			if (d % 1 == 0) {
				node.put(key, (int) d);
			} else {
				node.put(key, d);
			}
		} else if (value instanceof JBoolean) {
			node.put(key, ((JBoolean) value).isBooleanValue());
		}
	}

	public ArrayNode to(JArray node, ObjectMapper mapper) {
		ArrayNode result = mapper.createArrayNode();
		for (JNode element : node.getElements()) {
			addValue(result, element, mapper);
		}
		return result;
	}

	private void addValue(ArrayNode result, JNode element, ObjectMapper mapper) {
		if (element instanceof JObject) {
			result.add(to((JObject) element, mapper));
		} else if (element instanceof JArray) {
			result.add(to((JArray) element, mapper));
		} else if (element instanceof JString) {
			result.add(((JString) element).getStringValue());
		} else if (element instanceof JNumber) {
			result.add(((JNumber) element).getNumberValue());
		} else if (element instanceof JBoolean) {
			result.add(((JBoolean) element).isBooleanValue());
		}
	}

}
