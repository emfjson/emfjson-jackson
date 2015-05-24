/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson.databind.ser;

import org.eclipse.emf.ecore.*;

import org.emfjson.common.Cache;
import org.emfjson.common.EObjects;
import org.emfjson.jackson.JacksonOptions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.emfjson.common.EObjects.featureMaps;

public class EObjectSerializer extends JsonSerializer<EObject> {

	private final JacksonOptions options;
	private final Cache cache = new Cache();

	public EObjectSerializer(JacksonOptions options) {
		this.options = options;
	}

	@Override
	public Class<EObject> handledType() {
		return EObject.class;
	}

	@Override
	public void serialize(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (object == null) {
			jg.writeNull();
			return;
		}

		if (object.eContainer() != null && EObjects.isContainmentProxy(object.eContainer(), object)) {
			options.referenceSerializer.serialize(object.eContainer(), object, jg, options);
			return;
		}

		final EClass eClass = object.eClass();
		final List<EAttribute> attributes = cache.getAttributes(eClass);
		final List<EReference> references = cache.getReferences(eClass);
		final List<EReference> containments = cache.getContainments(eClass);

		jg.writeStartObject();

		writeType(eClass, jg);
		writeId(object, jg);

		for (EAttribute attribute : attributes) {
			if (EObjects.isCandidate(object, attribute)) {
				final String field = cache.getKey(attribute);
				final Object value = object.eGet(attribute);

				if (EObjects.isFeatureMap(attribute)) {
					writeFeatureMap(jg, attribute, object);
				} else {
					jg.writeObjectField(field, value);
				}
			}
		}

		for (EReference reference : references) {
			if (EObjects.isCandidate(object, reference)) {
				final String field = cache.getKey(reference);
				final Object value = object.eGet(reference);

				writeRef(jg, object, field, value);
			}
		}

		for (EReference containment : containments) {
			if (EObjects.isCandidate(object, containment)) {
				final String field = cache.getKey(containment);
				final Object value = object.eGet(containment);

				jg.writeObjectField(field, value);
			}
		}
		jg.writeEndObject();
	}

	protected void writeId(EObject object, JsonGenerator jg) throws IOException {
		options.idSerializer.serialize(object, jg, options);
	}

	protected void writeType(EClass eClass, JsonGenerator jg) throws IOException {
		if (options.serializeTypes) {
			jg.writeStringField(options.typeField, cache.getType(eClass));
		}
	}

	private void writeRef(JsonGenerator jg, EObject source, String field, Object value) throws IOException {
		jg.writeFieldName(field);

		if (value instanceof Iterable<?>) {
			Iterable<?> values = (Iterable<?>) value;

			jg.writeStartArray();
			for (Object current : values) {
				options.referenceSerializer.serialize(source, (EObject) current, jg, options);
			}
			jg.writeEndArray();

		} else {
			options.referenceSerializer.serialize(source, (EObject) value, jg, options);
		}
	}

	private void writeFeatureMap(JsonGenerator jg, EAttribute attribute, EObject owner) throws IOException {
		final Set<EStructuralFeature> features = featureMaps(owner, attribute);

		for (EStructuralFeature feature : features) {
			final Object value = owner.eGet(feature);
			final String key = cache.getKey(feature);

			if (feature instanceof EAttribute) {
				jg.writeObjectField(key, value);
			} else {
				final EReference reference = (EReference) feature;

				if (reference.isContainment()) {
					jg.writeObjectField(key, value);
				} else {
					writeRef(jg, owner, key, value);
				}
			}
		}
	}

}
