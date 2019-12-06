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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.databind.property.EObjectProperty;
import org.emfjson.jackson.databind.property.EObjectPropertyMap;
import org.emfjson.jackson.databind.property.EObjectTypeProperty;
import org.emfjson.jackson.errors.JSONException;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static org.emfjson.jackson.databind.EMFContext.getFeature;
import static org.emfjson.jackson.databind.EMFContext.getResource;

public class EObjectDeserializer extends JsonDeserializer<EObject> {

	private final EObjectPropertyMap.Builder builder;
	private final Class<?> currentType;

	public EObjectDeserializer(EObjectPropertyMap.Builder builder, Class<?> currentType) {
		this.builder = builder;
		this.currentType = currentType;
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EMFContext.prepare(ctxt);

		final Resource resource = getResource(ctxt);
		final EStructuralFeature feature = getFeature(ctxt);
		final EClass defaultType = getDefaultType(ctxt);

		EObject current = null;
		EObjectPropertyMap propertyMap;

		if (feature == null && defaultType != null) {
			propertyMap = builder.construct(ctxt, defaultType);
		} else if (feature instanceof EReference) {
			propertyMap = builder.construct(ctxt, ((EReference) feature).getEReferenceType());
		} else {
			propertyMap = builder.constructDefault(ctxt);
		}

		TokenBuffer buffer = null;
		JsonToken nextToken = jp.nextToken();
		while (nextToken != JsonToken.END_OBJECT && nextToken != null) {
			final String field = jp.getCurrentName();
			final EObjectProperty property = propertyMap.findProperty(field);

			if (property instanceof EObjectTypeProperty) {
				current = property.deserialize(jp, ctxt);
				if (current != null) {
					propertyMap = builder.construct(ctxt, current.eClass());
				}
			} else if (property != null && current != null) {
				property.deserializeAndSet(jp, current, ctxt, resource);
			} else if (property == null && current != null) {
				handleUnknownProperty(jp, resource, ctxt);
			} else {
				if (buffer == null) {
					buffer = new TokenBuffer(jp);
				}
				buffer.copyCurrentStructure(jp);
			}

			nextToken = jp.nextToken();
		}

		// handle empty objects
		if (buffer == null && current == null && defaultType != null) {
			return EcoreUtil.create(defaultType);
		}

		return buffer == null ? current: postDeserialize(buffer, current, defaultType, ctxt);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt, EObject intoValue) throws IOException {
		if (intoValue == null) {
			return null;
		}

		EMFContext.prepare(ctxt);
		EObjectPropertyMap propertyMap = builder.construct(ctxt, intoValue.eClass());

		final Resource resource = getResource(ctxt);

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String field = jp.getCurrentName();
			final EObjectProperty property = propertyMap.findProperty(field);
			if (property != null) {
				property.deserializeAndSet(jp, intoValue, ctxt, resource);
			} else {
				handleUnknownProperty(jp, resource, ctxt);
			}
		}

		return intoValue;
	}

	private EObject postDeserialize(TokenBuffer buffer, EObject object, EClass defaultType, DeserializationContext ctxt) throws IOException {
		if (object == null && defaultType == null) {
			return null;
		}

		Resource resource = getResource(ctxt);
		JsonParser jp = buffer.asParser();
		JsonNode tree = jp.readValueAsTree();
		jp.close();

		EObjectPropertyMap propertyMap = builder.find(ctxt, defaultType, tree.fieldNames());
		EObjectTypeProperty typeProperty = propertyMap.getTypeProperty();

		if (typeProperty != null) {
			JsonNode value = tree.get(typeProperty.getFieldName());

			if (value != null) {
				object = typeProperty.create(value.asText(), ctxt);
			}
		}

		if (object == null) {
			object = EcoreUtil.create(defaultType);
		}

		// TODO explain that
		propertyMap = builder.construct(ctxt, object.eClass());

		jp = buffer.asParser();
		JsonToken nextToken = jp.nextToken();
		while (nextToken != JsonToken.END_OBJECT && nextToken != null) {
			final String field = jp.getCurrentName();
			final EObjectProperty property = propertyMap.findProperty(field);

			if (property != null) {
				property.deserializeAndSet(jp, object, ctxt, resource);
			} else {
				handleUnknownProperty(jp, resource, ctxt);
			}

			nextToken = jp.nextToken();
		}

		jp.close();
		buffer.close();
		return object;
	}

	private void handleUnknownProperty(JsonParser jp, Resource resource, DeserializationContext ctxt) throws IOException {
		if (resource != null && ctxt.getConfig().hasDeserializationFeatures(FAIL_ON_UNKNOWN_PROPERTIES.getMask())) {
			resource.getErrors().add(new JSONException("Unknown feature " + jp.getCurrentName(), jp.getCurrentLocation()));
		}
		// we didn't find a feature so consume
		// the field and move on
		jp.nextToken();
		jp.skipChildren();
	}

	@Override
	public boolean isCachable() {
		return true;
	}

	@Override
	public Class<?> handledType() {
		return EObject.class;
	}

	private EClass getDefaultType(DeserializationContext ctxt) {
		EClass type = null;

		EObject parent = EMFContext.getParent(ctxt);
		if (parent == null) {
			if (currentType != null && currentType != EObject.class) {
				type = EMFContext.findEClassByQualifiedName(ctxt, currentType.getCanonicalName());
			}
			if (type == null) {
				type = EMFContext.getRoot(ctxt);
			}
		} else {
			EReference reference = (EReference) getFeature(ctxt);
			if (reference != null && !reference.getEReferenceType().isAbstract()) {
				type = reference.getEReferenceType();
			}
		}
		return type;
	}
}
