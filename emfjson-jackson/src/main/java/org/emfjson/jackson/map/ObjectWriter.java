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
package org.emfjson.jackson.map;

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.common.Cache;
import org.emfjson.common.IDResolver;
import org.emfjson.common.Options;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * ObjectWriter provides methods to convert the content of a Resource or 
 * a single EObject instance into their representation in JSON. 
 * 
 * <p>ObjectWriter uses the Jackson Object API to create a JSON representation</p>    
 * 
 * @since 0.9.0
 */
public class ObjectWriter {

	private final ObjectMapper mapper;
	private final Options options;
	private final IDResolver idResolver;
	private final ReferenceWriter referenceWriter;
	private final Resource resource;

	private final ValueWriter valueWriter = new ValueWriter();
	private final Cache cache = new Cache();

	/**
	 * 
	 * @param mapper to be used
	 * @param resource to be converted
	 * @param options to be used
	 */
	public ObjectWriter(ObjectMapper mapper, Resource resource, Options options) {
		this.mapper = mapper;
		this.resource = resource;
		this.options = options;
		this.idResolver = new IDResolver(resource.getURI());
		this.referenceWriter = new ReferenceWriter(idResolver, options);
	}

	/**
	 * Returns the Json Object created from the input EObject.
	 * 
	 * <p>This method creates for each feature of the object a pair of key value.</p>
	 * 
	 * @param object to be converted
	 * @return JSON object
	 */
	public ObjectNode toNode(EObject object) {
		ObjectNode result = mapper.createObjectNode();

		to(object, (ObjectNode) result);

		return result;
	}

	/**
	 * Returns the Json representation of the current Resource.
	 * 
	 * @return JSON node
	 */
	public JsonNode toNode() {
		final EList<EObject> contents = resource.getContents();
		JsonNode result;

		if (contents.size() == 1) {
			result = toNode(contents.get(0));
		} else {
			result = mapper.createArrayNode();

			for (EObject obj: contents) {
				JsonNode node = to(obj, mapper.createObjectNode());
				if (node != null) {
					((ArrayNode) result).add(node);
				}
			}
		}
		return result;
	}

	private ObjectNode to(EObject object, ObjectNode node) {
		final EClass eClass = object.eClass();

		if (options.serializeTypes) {
			node.put(EJS_TYPE_KEYWORD, idResolver.get(eClass));	
		}
		if (options.useUUID) {
			node.put(EJS_UUID_ANNOTATION, getURI(object).fragment());
		}

		final List<EAttribute> attributes = cache.getAttributes(eClass);
		final List<EReference> references = cache.getReferences(eClass);

		for (final EAttribute attribute: attributes) {
			if (isCandidate(object, attribute)) {
				final String key = cache.getKey(attribute);
				final Object value = object.eGet(attribute);

				if (isFeatureMap(attribute)) {
					serializeFeatureMap(node, object, attribute);
				} else {
					valueWriter.serialize(node, key, attribute, value);
				}
			}
		}

		for (final EReference reference: references) {
			if (isCandidate(object, reference)) {
				final Object value = object.eGet(reference);
				final String key = cache.getKey(reference);

				if (isMapEntry(reference.getEReferenceType())) {
					serializeMapEntry(node, key, reference, value);
				} else if (!reference.isContainment()) {
					referenceWriter.serialize(node, key, reference, value);
				} else {
					serializeContainment(node, key, object, reference, value);
				}
			}
		}

		return node;
	}

	private void serializeMapEntry(ObjectNode target, String key, EReference reference, Object value) {
		ObjectNode entryNode = target.objectNode();
		target.set(key, entryNode);

		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Map.Entry<String, String>> entries = (Collection<Entry<String, String>>) value;
			for (Map.Entry<String, String> entry: entries) {
				entryNode.put(entry.getKey(), entry.getValue());
			}
		} else {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> entry = (Entry<String, String>) value;
			entryNode.put(entry.getKey(), entry.getValue());
		}
	}

	private void serializeFeatureMap(ObjectNode node, EObject owner, EAttribute attribute) {
		final Set<EStructuralFeature> features = featureMaps(owner, attribute);

		for (EStructuralFeature feature: features) {
			final Object value = owner.eGet(feature);
			final String key = cache.getKey(feature);

			if (feature instanceof EAttribute) {
				valueWriter.serialize(node, key, attribute, value);
			} else {
				final EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					serializeContainment(node, key, owner, reference, value);
				} else {
					referenceWriter.serialize(node, key, reference, value);
				}
			}
		}
	}

	private void serializeContainment(ObjectNode target, String key, EObject container, EReference reference, Object value) {
		if (reference.isMany()) {
			final ArrayNode array = target.putArray(key);
			final Collection<?> values = (Collection<?>) value;

			for (Object current: values) {
				if (isContainmentProxy(container, (EObject) current)) {
					referenceWriter.createObjectRef(array.addObject(), (EObject) current);
				} else {
					to((EObject) current, array.addObject());
				}
			}

		} else {

			if (isContainmentProxy(container, (EObject) value)) {
				target.set(key, referenceWriter.createObjectRef(target.objectNode(), (EObject) value));
			} else {
				target.set(key, to((EObject) value, target.objectNode()));
			}

		}
	}

}
