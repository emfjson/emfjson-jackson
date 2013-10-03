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

import static org.eclipselabs.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.common.ModelUtil.getEReference;
import static org.eclipselabs.emfjson.common.ModelUtil.isMapEntry;

import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

class EReferenceDeserializer {

	private Deserializer deserializer;
	private MapDeserializer mapDeserializer;

	EReferenceDeserializer(Deserializer deserializer) {
		this.deserializer = deserializer;
		this.mapDeserializer = new MapDeserializer();
	}

	void deSerialize(EObject eObject, ObjectNode node, Resource resource) {
		if (!node.isObject()) return;

		final EClass eClass = eObject.eClass();
		final ObjectNode root = (ObjectNode) node;

		for (Iterator<Entry<String, JsonNode>> it = root.fields(); it.hasNext();) {
			Entry<String, JsonNode> field = it.next();

			String key = field.getKey();
			JsonNode value = field.getValue();

			EReference reference = getEReference(eClass, key);
			if (reference != null && reference.isContainment() && !reference.isTransient()) {
				if (isMapEntry(reference.getEType()) && value.isObject()) {
					mapDeserializer.deSerializeMapEntry(eObject, reference, value);
				} else {
					deSerializeContainment(eObject, reference, root, value, resource);
				}
			}
		}
	}

	void deSerializeContainment(EObject eObject, EReference reference, ObjectNode root, JsonNode value, Resource resource) {
		if (value.isArray()) {

			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

				for (Iterator<JsonNode> it = value.elements(); it.hasNext();) {
					JsonNode current = it.next();
					EObject contained = createContainedObject(reference, root, current, resource);
					if (contained != null) values.add(contained);
				}
			} 
			else if (value.elements().hasNext()) {
				JsonNode current = value.elements().next();
				EObject contained = createContainedObject(reference, root, current, resource);
				if (contained != null) eObject.eSet(reference, contained);
			}

		} else {
			EObject contained = createContainedObject(reference, root, value, resource);

			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) eObject.eGet(reference);
				if (contained != null) values.add(contained);
			}
			else {
				if (contained != null) eObject.eSet(reference, contained);
			}
		}
	}

	EObject createContainedObject(EReference reference, JsonNode root, JsonNode node, Resource resource) {
		EClass eClass = JSUtil.findEClass(reference.getEReferenceType(), node, root, resource, deserializer.getNamespaces());
		EObject obj = null;

		if (isRefNode(node)) {
			obj = deserializer.getProxyFactory().createProxy(resource, eClass, node);
		} 
		else if (node.isObject()) {
			obj = deserializer.from((ObjectNode) node, eClass, resource);	
		}

		return obj;
	}

	boolean isRefNode(JsonNode node) {
		return node.isObject() && node.get(EJS_REF_KEYWORD) != null;
	}

}
