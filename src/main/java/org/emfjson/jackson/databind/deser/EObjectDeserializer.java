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
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.EMFJs;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.databind.properties.EcoreProperties;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.errors.JSONException;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static org.emfjson.jackson.common.ContextUtils.get;

public class EObjectDeserializer extends JsonDeserializer<EObject> { //implements ContextualDeserializer {

	private final ResourceSet resourceSet;
	private final JacksonOptions options;

	public EObjectDeserializer(ResourceSet resourceSet, JacksonOptions options, Cache cache) {
		this.resourceSet = resourceSet;
		this.options = options;
	}

	public EObjectDeserializer(ResourceSet resourceSet, JacksonOptions options) {
		this(resourceSet, options, new Cache());
	}

	@Override
	public boolean isCachable() {
		return true;
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		initializeContext(ctxt);

		EObject current = null;
		final EClass defaultType = findRoot(ctxt);
		final Resource resource = get(Resource.class, "resource", ctxt);
		TokenBuffer buffer = null;

		ctxt.setAttribute("parent", new Object());
		ctxt.setAttribute("reference", new Object());

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String fieldName = jp.getCurrentName();

			if (options.typeField.equalsIgnoreCase(fieldName)) {
				if (current == null) {
					current = create(jp, ctxt);
				}
			} else if (options.idField.equalsIgnoreCase(fieldName)) {
				if (current != null) {
					options.idDeserializer.deserialize(jp, current, ctxt);
				} else {
					if (buffer == null) {
						buffer = new TokenBuffer(jp);
					}
					buffer.copyCurrentStructure(jp);
				}
			} else if (options.refField.equalsIgnoreCase(fieldName)) {
				if (current != null) {
					((InternalEObject) current).eSetProxyURI(URI.createURI(jp.nextTextValue()));
				} else {
					if (buffer == null) {
						buffer = new TokenBuffer(jp);
					}
					buffer.copyCurrentStructure(jp);
				}
			} else {
				if (current != null) {
					readFeature(jp, current, fieldName, ctxt, resource);
				} else {
					if (buffer == null) {
						buffer = new TokenBuffer(jp);
					}
					buffer.copyCurrentStructure(jp);
				}
			}
		}

		return postDeserialize(buffer, current, defaultType, ctxt);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt, EObject intoValue) throws IOException {
		if (intoValue == null) {
			return null;
		}

		final Resource resource = get(Resource.class, "resource", ctxt);

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String fieldName = jp.getCurrentName();

			if (options.idField.equalsIgnoreCase(fieldName)) {
				options.idDeserializer.deserialize(jp, intoValue, ctxt);
			} else {
				readFeature(jp, intoValue, fieldName, ctxt, resource);
			}
		}

		return postDeserialize(null, intoValue, null, ctxt);
	}

	protected EObject postDeserialize(TokenBuffer buffer, EObject object, EClass defaultType, DeserializationContext ctxt) throws IOException {
		if (object == null && defaultType == null) {
			return null;
		}

		if (object == null) {
			object = EcoreUtil.create(defaultType);
		}

		if (buffer != null) {
			final Resource resource = get(Resource.class, "resource", ctxt);
			final JsonParser bufferedParser = buffer.asParser();

			while (bufferedParser.nextToken() != null) {
				if (options.idField.equals(bufferedParser.getCurrentName())) {
					options.idDeserializer.deserialize(bufferedParser, object, ctxt);
				} else if (options.refField.equals(bufferedParser.getCurrentName())) {
					((InternalEObject) object).eSetProxyURI(URI.createURI(bufferedParser.nextTextValue()));
				} else {
					readFeature(bufferedParser, object, bufferedParser.getCurrentName(), ctxt, resource);
				}
			}

			bufferedParser.close();
			buffer.close();
		}

		return object;
	}

	private EClass findRoot(DeserializationContext ctxt) {
		Object root = ctxt.getAttribute(EMFJs.OPTION_ROOT_ELEMENT);
		if (root instanceof EClass) {
			return (EClass) root;
		}

		final EReference reference = get(EReference.class, "reference", ctxt);

		if (reference != null && !reference.getEReferenceType().isAbstract()) {
			return reference.getEReferenceType();
		}

		return options.rootElement;
	}

	private void readFeature(JsonParser jp, EObject current, String fieldName, DeserializationContext ctxt, Resource resource) throws IOException {
		final Cache cache = get(Cache.class, "cache", ctxt);

		final EClass eClass = current.eClass();
		final EStructuralFeature feature = cache.getEStructuralFeature(eClass, fieldName);

		if (feature != null) {

			if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {
				jp.nextToken();
			}

			if (jp.getCurrentToken() == JsonToken.VALUE_NULL) {
				return;
			}

			final JavaType type = EcoreType.construct(current, feature);
			if (type == null)
				throw new RuntimeException();

			final JsonDeserializer<Object> deserializer = ctxt.findContextualValueDeserializer(
					type,
					EcoreProperties.create(current, feature));

			switch (EcoreType.FeatureKind.get(feature)) {
				case CONTAINMENT: {
					ctxt.setAttribute("reference", feature);
					ctxt.setAttribute("parent", current);
				}
				case ATTRIBUTE: {
					if (feature.getEType() instanceof EDataType) {
						ctxt.setAttribute("datatype", feature.getEType());
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
				case REFERENCE: {
					ctxt.setAttribute("reference", feature);
					ctxt.setAttribute("parent", current);

					if (feature.isMany()) {
						deserializer.deserialize(jp, ctxt);
					} else {
						deserializer.deserialize(jp, ctxt);
					}
				}
				break;
			}

		} else {

			if (resource != null &&
					ctxt.getConfig().hasDeserializationFeatures(FAIL_ON_UNKNOWN_PROPERTIES.getMask())) {

				resource.getErrors().add(new JSONException(
						"Unknown feature " + fieldName,
						jp.getCurrentLocation()));

			}
			// we didn't find a feature so consume
			// the field and move on
			jp.nextToken();
			jp.skipChildren();
		}
	}

	protected EObject create(JsonParser jp, DeserializationContext context) throws IOException {
		EClass eClass = options.typeDeserializer.deserialize(jp, context);
		if (eClass != null) {
			return EcoreUtil.create(eClass);
		}
		return null;
	}

	@Override
	public Class<?> handledType() {
		return EObject.class;
	}

	protected void initializeContext(DeserializationContext context) {
		if (get(Cache.class, "cache", context) == null)
			context.setAttribute("cache", new Cache());

		if (get(ReferenceEntries.class, "entries", context) == null)
			context.setAttribute("entries", new ReferenceEntries());

		if (get(ResourceSet.class, "resourceSet", context) == null)
			context.setAttribute("resourceSet", resourceSet);

	}

}
