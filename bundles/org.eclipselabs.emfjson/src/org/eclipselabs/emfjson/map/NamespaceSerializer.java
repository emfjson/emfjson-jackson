package org.eclipselabs.emfjson.map;

import java.util.Map;

import org.eclipselabs.emfjson.common.Constants;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

class NamespaceSerializer {

	ObjectNode createNamespaceNode(ObjectNode container) {
		ObjectNode ns = container.objectNode();
		container.put(Constants.EJS_NS_KEYWORD, ns.objectNode());

		return ns;
	}

	ObjectNode createNamespaceNode(ArrayNode container) {
		ObjectNode ns = container.objectNode();
		ns.put(Constants.EJS_NS_KEYWORD, ns.objectNode());
		container.add(ns);

		return ns;
	}

	void serialize(ArrayNode container, Map<String, String> namespaces) {
		ObjectNode ns = (ObjectNode) container.get(0).get(Constants.EJS_NS_KEYWORD);

		for (String key: namespaces.keySet()) {
			String value = namespaces.get(key);
			ns.put(key, value);
		}
	}

	void serialize(ObjectNode container, Map<String, String> namespaces) {
		ObjectNode ns = (ObjectNode) container.get(Constants.EJS_NS_KEYWORD);

		for (String key: namespaces.keySet()) {
			String value = namespaces.get(key);
			ns.put(key, value);
		}
	}

}
