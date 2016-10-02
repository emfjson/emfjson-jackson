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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
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
import static org.emfjson.jackson.databind.EMFContext.getResource;

public class EObjectDeserializer extends JsonDeserializer<EObject> {

	private final EObjectPropertyMap.Builder builder;

	public EObjectDeserializer(EObjectPropertyMap.Builder builder) {
		this.builder = builder;
	}

//	@Override
//	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
////		if (property == null) {
////			EClass rootType = EMFContext.getRoot(ctxt);
////			if (rootType != null) {
////				return new EObjectDeserializer(builder, builder.construct(rootType));
////			}
////		}
//		return this;
//	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EMFContext.prepare(ctxt);

		final EClass defaultType = findRoot(ctxt);
		final Resource resource = getResource(ctxt);
		final EStructuralFeature feature = EMFContext.getFeature(ctxt);

		EObject current = null;
		EObjectPropertyMap propertyMap;

		if (feature == null && defaultType != null) {
			propertyMap = builder.construct(defaultType);
		} else if (feature instanceof EReference) {
			propertyMap = builder.construct(((EReference) feature).getEReferenceType());
		} else {
			propertyMap = builder.constructDefault();
		}

		TokenBuffer buffer = null;
//
//		System.out.println("context name " + jp.getParsingContext().getCurrentName());
//		System.out.println("current " + jp.getCurrentValue());
//		if (jp.getParsingContext().getParent() != null) {
//			System.out.println("context parent name " + jp.getParsingContext().getParent().getCurrentName());
//		}

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String field = jp.getCurrentName();
			final EObjectProperty property = propertyMap.findProperty(field);

			if (property instanceof EObjectTypeProperty) {
				current = property.deserialize(jp, ctxt);
				if (current != null) {
					propertyMap = builder.construct(current.eClass());
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
		}

		return buffer == null ? current: postDeserialize(buffer, current, defaultType, ctxt);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt, EObject intoValue) throws IOException {
		if (intoValue == null) {
			return null;
		}

		EMFContext.prepare(ctxt);
		EObjectPropertyMap propertyMap = builder.construct(intoValue.eClass());

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

	protected EObject postDeserialize(TokenBuffer buffer, EObject object, EClass defaultType, DeserializationContext ctxt) throws IOException {
		if (object == null && defaultType == null) {
			return null;
		}

		if (object == null) {
			object = EcoreUtil.create(defaultType);
		}

		final Resource resource = getResource(ctxt);
		final JsonParser jp = buffer.asParser();
		final EObjectPropertyMap propertyMap = builder.construct(object.eClass());

		while (jp.nextToken() != null) {
			final String field = jp.getCurrentName();
			final EObjectProperty property = propertyMap.findProperty(field);

			if (property != null) {
				property.deserializeAndSet(jp, object, ctxt, resource);
			} else {
				handleUnknownProperty(jp, resource, ctxt);
			}
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

	private EClass findRoot(DeserializationContext ctxt) {
		final EObject parent = EMFContext.getParent(ctxt);
		if (parent == null) {
			EClass root = EMFContext.getRoot(ctxt);
			if (root != null) {
				return root;
			}
		} else {
			final EReference reference = EMFContext.getReference(ctxt);
			if (reference != null && !reference.getEReferenceType().isAbstract()) {
				return reference.getEReferenceType();
			}
		}

		return null;
	}

	@Override
	public boolean isCachable() {
		return true;
	}

	@Override
	public Class<?> handledType() {
		return EObject.class;
	}

}
