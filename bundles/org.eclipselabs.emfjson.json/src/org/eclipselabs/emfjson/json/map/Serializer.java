package org.eclipselabs.emfjson.json.map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JField;
import org.eclipselabs.emfjson.json.JNode;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JString;

public class Serializer {


	public JsonNode to(JNode node, ObjectMapper mapper) {
		if (node instanceof JObject)
			return to((JObject)node, mapper);
		else return to((JArray)node, mapper);
	}


	public ObjectNode to(JObject node, ObjectMapper mapper) {
		ObjectNode result = mapper.createObjectNode();
		for (JField field: node.getFields()) {
			setValue(result, field, mapper);
		}

		return result;
	}


	private void setValue(ObjectNode node, JField field, ObjectMapper mapper) {
		JNode value = field.getValue();

		if (value instanceof JObject) {
			node.put(field.getKey(), to((JObject)value, mapper));
		} else if (value instanceof JArray) {
			node.put(field.getKey(), to((JArray)value, mapper));
		} else if (value instanceof JString) {
			node.put(field.getKey(), ((JString) value).getStringValue());
		} else if (value instanceof JNumber) {
			node.put(field.getKey(), ((JNumber) value).getNumberValue());
		} else if (value instanceof JBoolean) {
			node.put(field.getKey(), ((JBoolean) value).isBooleanValue());
		}
	}


	public ArrayNode to(JArray node, ObjectMapper mapper) {
		ArrayNode result = mapper.createArrayNode();
		for (JNode element: node.getElements()) {
			addValue(result, element, mapper);
		}
		return result;
	}


	private void addValue(ArrayNode result, JNode element, ObjectMapper mapper) {
		if (element instanceof JObject) {
			result.add(to((JObject)element, mapper));
		} else if (element instanceof JArray) {
			result.add(to((JArray)element, mapper));
		} else if (element instanceof JString) {
			result.add(((JString) element).getStringValue());
		} else if (element instanceof JNumber) {
			result.add(((JNumber) element).getNumberValue());
		} else if (element instanceof JBoolean) {
			result.add(((JBoolean) element).isBooleanValue());
		}
	}


}
