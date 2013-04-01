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

import java.util.Iterator;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

class MapDeserializer {

	void deSerializeMapEntry(EObject container, EReference reference, JsonNode jsonNode) {
		if (!(jsonNode instanceof ObjectNode)) return;
		final ObjectNode node = (ObjectNode) jsonNode;

		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) container.eGet(reference);

			for (Iterator<Entry<String, JsonNode>> it = node.getFields(); it.hasNext();) {
				Entry<String, JsonNode> element = it.next();
				values.add(deSerializeEntry(element.getKey(), element.getValue()));
			}
		} else {
			if (node.getFields().hasNext()) {
				Entry<String, JsonNode> element = node.getFields().next();
				container.eSet(reference, deSerializeEntry(element.getKey(), element.getValue()));
			}
		}
	}

	@SuppressWarnings("deprecation")
	EObject deSerializeEntry(String key, JsonNode value) {
		EObject eObject = EcoreUtil.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY, key);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, value.getValueAsText());

		return eObject;
	}
}
