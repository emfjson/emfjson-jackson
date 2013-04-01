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

import static org.eclipselabs.emfjson.common.Constants.EJS_NS_KEYWORD;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

class NamespaceDeserializer {

	@SuppressWarnings("deprecation")
	Map<String, String> deSerialize(ObjectNode node) {
		final Map<String, String> nsMap = new HashMap<String, String>();

		if (node.has(EJS_NS_KEYWORD)) {
			ObjectNode nsNode = (ObjectNode) node.findPath(EJS_NS_KEYWORD);

			for(Iterator<Entry<String, JsonNode>> it = nsNode.getFields(); it.hasNext();) {
				Entry<String, JsonNode> entry = it.next();
				nsMap.put(entry.getKey(), entry.getValue().getValueAsText());
			}
		}

		return nsMap;
	}
}
