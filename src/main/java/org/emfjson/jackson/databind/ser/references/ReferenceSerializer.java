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
package org.emfjson.jackson.databind.ser.references;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.Keywords;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.common.ContextUtils;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;
import org.emfjson.jackson.module.EMFModule;

import java.io.IOException;
import java.util.Map;

import static org.emfjson.jackson.module.EMFModule.FeatureKind.OPTION_SERIALIZE_REF_AS_VALUE;

public class ReferenceSerializer extends JsonSerializer<EObject> {

	private final Keywords keywords;
	private final Map<EMFModule.FeatureKind, Boolean> features;
	private URIHandler handler;

	public ReferenceSerializer(Keywords keywords, Map<EMFModule.FeatureKind, Boolean> features) {
		this.keywords = keywords;
		this.features = features;
	}

	protected boolean isExternal(EObject source, EObject target) {
		Resource sourceResource = source.eResource();
		Resource targetResource = target.eResource();

		return sourceResource == null || !sourceResource.equals(targetResource);
	}

	protected URI deresolve(URIHandler handler, URI targetURI, Cache cache, EObject source) {
		URI sourceURI = cache.getURI(source);
		if (handler == null) {
			handler = new BaseURIHandler();
		}

		return handler.deresolve(sourceURI, targetURI);
	}

	@Override
	public void serialize(EObject value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		EObject parent = ContextUtils.get(EObject.class, "parent", serializers);
		Cache cache = ContextUtils.get(Cache.class, "cache", serializers);

		if (features.get(OPTION_SERIALIZE_REF_AS_VALUE)) {
			if (value == null) {
				jg.writeNull();
			} else {
				URI targetURI = cache.getURI(value);

				if (isExternal(parent, value)) {
					targetURI = deresolve(handler, targetURI, cache, parent);

					if (targetURI == null) {
						jg.writeNull();
					} else {
						jg.writeString(targetURI.toString());
					}
				} else {
					jg.writeString(targetURI.fragment());
				}
			}
		} else {
			if (value == null) {
				jg.writeNull();
			} else {
				URI targetURI = cache.getURI(value);

				jg.writeStartObject();
				if (isExternal(parent, value)) {
					targetURI = deresolve(handler, targetURI, cache, parent);

					if (targetURI == null) {
						jg.writeNullField(keywords._ref);
					} else {
						jg.writeStringField(keywords._type, cache.getURI(value.eClass()).toString());
						jg.writeStringField(keywords._ref, targetURI.toString());
					}
				} else {
					jg.writeStringField(keywords._ref, targetURI.fragment());
				}
				jg.writeEndObject();
			}
		}

	}

}
