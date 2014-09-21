package org.eclipselabs.emfjson.map;

import static org.eclipselabs.emfjson.common.Constants.EJS_NS_KEYWORD;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipselabs.emfjson.common.NamespaceHolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Namespaces implements NamespaceHolder {

	private Map<String, String> namespaces = new HashMap<>();

	@Override
	public Map<String, String> getNamespaces() {
		return namespaces;
	}

	public void createNode(JsonNode node) {
		if (node.isArray()) {
			createNode((ArrayNode) node);
		} else if (node.isObject()) {
			createNode((ObjectNode) node);
		}
	}

	private void createNode(ObjectNode node) {
		ObjectNode ns = node.objectNode();
		node.set(EJS_NS_KEYWORD, ns.objectNode());
	}

	private void createNode(ArrayNode node) {
		ObjectNode ns = node.addObject();
		ns.set(EJS_NS_KEYWORD, ns.objectNode());
	}

	public void serialize(JsonNode node) {
		if (node.isArray()) {
			serialize((ArrayNode) node);
		} else if (node.isObject()) {
			serialize((ObjectNode) node);
		}
	}

	private void serialize(ArrayNode node) {
		ObjectNode ns = (ObjectNode) node.get(0).get(EJS_NS_KEYWORD);

		for (String key: getNamespaces().keySet()) {
			String value = getNamespaces().get(key);
			ns.put(key, value);
		}
	}
	
	private void serialize(ObjectNode node) {
		ObjectNode ns = (ObjectNode) node.get(EJS_NS_KEYWORD);

		for (String key: getNamespaces().keySet()) {
			String value = getNamespaces().get(key);
			ns.put(key, value);
		}
	}

	public Map<String, String> deSerialize(ObjectNode node) {
		final Map<String, String> nsMap = new HashMap<String, String>();

		if (node.has(EJS_NS_KEYWORD)) {
			ObjectNode nsNode = (ObjectNode) node.findPath(EJS_NS_KEYWORD);

			for (Iterator<Entry<String, JsonNode>> it = nsNode.fields(); it.hasNext();) {
				Entry<String, JsonNode> entry = it.next();
				nsMap.put(entry.getKey(), entry.getValue().asText());
			}
		}

		return nsMap;
	}

}
