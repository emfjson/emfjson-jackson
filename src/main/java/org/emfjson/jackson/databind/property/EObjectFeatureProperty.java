/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */

package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.databind.deser.ReferenceEntries;
import org.emfjson.jackson.databind.deser.ReferenceEntry;
import org.emfjson.jackson.databind.type.FeatureKind;

import java.io.IOException;

import static org.emfjson.jackson.annotations.JsonAnnotations.getElementName;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_DEFAULT_VALUE;

public class EObjectFeatureProperty extends EObjectProperty {

	private final EStructuralFeature feature;
	private final JavaType javaType;
	private final boolean defaultValues;

	private JsonSerializer<Object> serializer;

	public EObjectFeatureProperty(EStructuralFeature feature, JavaType type, int features) {
		super(getElementName(feature));

		this.feature = feature;
		this.javaType = type;
		this.defaultValues = OPTION_SERIALIZE_DEFAULT_VALUE.enabledIn(features);
	}

	@Override
	public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException {
		final JsonDeserializer<Object> deserializer = ctxt.findContextualValueDeserializer(javaType, null);

		if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {
			jp.nextToken();
		}

		if (jp.getCurrentToken() == JsonToken.VALUE_NULL) {
			return;
		}

		switch (FeatureKind.get(feature)) {
			case MAP:
			case MANY_CONTAINMENT:
			case SINGLE_CONTAINMENT: {
				EMFContext.setFeature(ctxt, feature);
				EMFContext.setParent(ctxt, current);
			}
			case SINGLE_ATTRIBUTE:
			case MANY_ATTRIBUTE: {
				if (feature.getEType() instanceof EDataType) {
					EMFContext.setDataType(ctxt, feature.getEType());
				}

				if (feature.isMany()) {
					deserializer.deserialize(jp, ctxt, current.eGet(feature));
				} else {
					Object value = deserializer.deserialize(jp, ctxt);

					if (value != null) {
						current.eSet(feature, value);
					}
				}
			}
			break;
			case MANY_REFERENCE:
			case SINGLE_REFERENCE: {
				EMFContext.setFeature(ctxt, feature);
				EMFContext.setParent(ctxt, current);

				ReferenceEntries entries = EMFContext.getEntries(ctxt);
				if (feature.isMany()) {
					deserializer.deserialize(jp, ctxt, entries.entries());
				} else {
					Object value = deserializer.deserialize(jp, ctxt);
					if (entries != null && value instanceof ReferenceEntry) {
						entries.entries().add((ReferenceEntry) value);
					}
				}
			}
			break;
		}
	}

	@Override
	public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (serializer == null) {
			serializer = provider.findValueSerializer(javaType);
		}

		EMFContext.setParent(provider, bean);
		EMFContext.setFeature(provider, feature);

		if (bean.eIsSet(feature)) {
			Object value = bean.eGet(feature, false);

			jg.writeFieldName(getFieldName());

			if (serializer instanceof UnknownSerializer) {
				JsonSerializer<Object> other = provider.findValueSerializer(value.getClass());
				if (other != null) {
					other.serialize(value, jg, provider);
				}
			} else {
				serializer.serialize(value, jg, provider);
			}
		} else if (defaultValues) {
			Object value = feature.getDefaultValue();

			if (value != null) {
				jg.writeFieldName(getFieldName());
				serializer.serialize(value, jg, provider);
			}
		}
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return null;
	}
}
