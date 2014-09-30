/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.gwt.map;

import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;
import static org.emfjson.common.Constants.EJS_TYPE_KEYWORD;
import static org.emfjson.common.Constants.EJS_UUID_ANNOTATION;
import static org.emfjson.common.EObjects.featureMaps;
import static org.emfjson.common.EObjects.isCandidate;
import static org.emfjson.common.EObjects.isContainmentProxy;
import static org.emfjson.common.EObjects.isFeatureMap;
import static org.emfjson.common.EObjects.isMapEntry;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.common.Cache;
import org.emfjson.common.IDResolver;
import org.emfjson.common.Options;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JsonWriter {

	private final Resource resource;
	private final Options options;
	private final Cache cache = new Cache();
	private final Values values = new Values();
	private final References referencers;

	public JsonWriter(Resource resource, Options options) {
		this.resource = resource;
		this.options = options;
		this.referencers = new References(new IDResolver(resource.getURI()), options);
	}

	public JSONValue toValue() {
		final List<EObject> content = resource.getContents();
		if (content.size() == 1) {
			return toNode(content.get(0));
		} else {
			return toArray(content);
		}
	}

	public JSONObject toNode(EObject object) {
		final EClass eClass = object.eClass();
		final JSONObject node = new JSONObject();

		if (options.serializeTypes) {
			node.put(EJS_TYPE_KEYWORD, new JSONString(getURI(eClass).toString()));
		}
		if (options.useUUID) {
			node.put(EJS_UUID_ANNOTATION, new JSONString(getURI(object).fragment()));
		}

		final List<EAttribute> attributes = cache.getAttributes(eClass);
		final List<EReference> references = cache.getReferences(eClass);

		for (EAttribute attribute: attributes) {
			if (isCandidate(object, attribute)) {
				final String key = cache.getKey(attribute);
				final Object value = object.eGet(attribute);

				if (isFeatureMap(attribute)) {
					serializeFeatureMap(node, object, attribute);
				} else {
					values.serialize(node, key, attribute, value);
				}
			}
		}

		for (EReference reference: references) {
			if (isCandidate(object, reference)) {
				final Object value = object.eGet(reference);
				final String key = cache.getKey(reference);

				if (isMapEntry(reference.getEReferenceType())) {
					serializeMapEntry(node, key, reference, value);
				} else if (!reference.isContainment()) {
					referencers.serialize(node, key, reference, value);
				} else {
					serializeContainment(node, key, object, reference, value);
				}
			}
		}

		return node;
	}

	public JSONArray toArray(List<EObject> content) {
		JSONArray array = new JSONArray();
		for (int i = 0; i < content.size(); i++) {
			EObject current = content.get(i);
			array.set(i, toNode(current));
		}
		return array;
	}

	private void serializeMapEntry(JSONObject target, String key, EReference reference, Object value) {
		JSONObject entryNode = new JSONObject();
		target.put(key, entryNode);

		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Map.Entry<String, String>> entries = (Collection<Entry<String, String>>) value;
			for (Map.Entry<String, String> entry: entries) {
				entryNode.put(entry.getKey(), new JSONString(entry.getValue()));
			}
		} else {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> entry = (Entry<String, String>) value;
			entryNode.put(entry.getKey(), new JSONString(entry.getValue()));
		}
	}

	private void serializeFeatureMap(JSONObject node, EObject owner, EAttribute attribute) {
		final Set<EStructuralFeature> features = featureMaps(owner, attribute);

		for (EStructuralFeature feature: features) {
			final Object value = owner.eGet(feature);
			final String key = cache.getKey(feature);

			if (feature instanceof EAttribute) {
				values.serialize(node, key, attribute, value);
			} else {
				final EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					serializeContainment(node, key, owner, reference, value);
				} else {
					referencers.serialize(node, key, reference, value);
				}
			}
		}
	}

	private void serializeContainment(JSONObject target, String key, EObject container, EReference reference, Object value) {
		if (reference.isMany()) {
			final JSONArray array = new JSONArray();
			final Collection<?> values = (Collection<?>) value;
			target.put(key, array);

			int i = 0;
			for (Object current: values) {
				JSONObject object = new JSONObject();

				if (isContainmentProxy(container, (EObject) current)) {
					array.set(i, object);
					referencers.createObjectRef(object, (EObject) current);
				} else {
					array.set(i, toNode((EObject) current));
				}
				i++;
			}

		} else {

			JSONObject childNode = new JSONObject();
			if (isContainmentProxy(container, (EObject) value)) {
				target.put(key, referencers.createObjectRef(childNode, (EObject) value));
			} else {
				target.put(key, toNode((EObject) value));
			}

		}
	}

}
