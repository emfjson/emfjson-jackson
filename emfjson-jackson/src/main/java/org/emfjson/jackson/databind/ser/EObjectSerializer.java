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

import org.eclipse.emf.ecore.util.EcoreUtil;
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

		provider.setAttribute("options", options);

		Cache cache = (Cache) provider.getAttribute("cache");
		if (cache == null) {
			provider.setAttribute("cache", cache = new Cache());
		}

		if (object.eContainer() != null && EObjects.isContainmentProxy(object.eContainer(), object)) {
			options.referenceSerializer.serialize(object.eContainer(), object, jg, provider);
			return;
		}

		final EClass eClass = object.eClass();
		final List<EAttribute> attributes = cache.getAttributes(eClass);
		final List<EReference> references = cache.getReferences(eClass);
		final List<EReference> containments = cache.getContainments(eClass);

		jg.writeStartObject();

		writeType(eClass, jg, provider);
		writeId(object, jg, provider);

		for (EAttribute attribute : attributes) {
			if (EObjects.isCandidate(object, attribute, options)) {
				final String field = cache.getKey(attribute);
				final Object value = object.eGet(attribute);

				if (EObjects.isFeatureMap(attribute)) {
					writeFeatureMap(object, attribute, jg, provider);
				} else {
					writeAttribute(jg, (EDataType) object.eClass().getFeatureType(attribute).getEClassifier(), field, value);
				}
			}
		}

		for (EReference reference : references) {
			if (EObjects.isCandidate(object, reference)) {
				final String field = cache.getKey(reference);
				final Object value = object.eGet(reference);

				writeRef(object, field, value, jg, provider);
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

	private void writeAttribute(JsonGenerator jg, EDataType type, String key, Object value) throws IOException {
		if (EcorePackage.Literals.EJAVA_OBJECT.equals(type) || EcorePackage.Literals.EJAVA_CLASS.equals(type)) {
			jg.writeStringField(key, EcoreUtil.convertToString(type, value));
		} else {
			jg.writeObjectField(key, value);
		}
	}

	protected void writeId(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		options.idSerializer.serialize(object, jg, provider);
	}

	protected void writeType(EClass eClass, JsonGenerator jg, SerializerProvider provider) throws IOException {
		options.typeSerializer.serialize(eClass, jg, provider);
	}

	private void writeRef(EObject source, String field, Object value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		jg.writeFieldName(field);

		if (value instanceof Iterable<?>) {
			Iterable<?> values = (Iterable<?>) value;

			jg.writeStartArray();
			for (Object current : values) {
				options.referenceSerializer.serialize(source, (EObject) current, jg, provider);
			}
			jg.writeEndArray();

		} else {
			options.referenceSerializer.serialize(source, (EObject) value, jg, provider);
		}
	}

	private void writeFeatureMap(EObject owner, EAttribute attribute, JsonGenerator jg, SerializerProvider provider) throws IOException {
		final Set<EStructuralFeature> features = featureMaps(owner, attribute);
		final Cache cache = (Cache) provider.getAttribute("cache");

		for (EStructuralFeature feature : features) {
			final Object value = owner.eGet(feature);
			final String key = cache.getKey(feature);

			if (feature instanceof EAttribute) {

				writeAttribute(jg, ((EAttribute) feature).getEAttributeType(), key, value);

			} else {
				final EReference reference = (EReference) feature;

				if (reference.isContainment()) {
					jg.writeObjectField(key, value);
				} else {
					writeRef(owner, key, value, jg, provider);
				}
			}
		}
	}

}
