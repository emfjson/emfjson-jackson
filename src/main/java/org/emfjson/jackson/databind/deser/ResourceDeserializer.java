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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.handlers.URIHandler;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;

public class ResourceDeserializer extends JsonDeserializer<Resource> {

	private final URIHandler uriHandler;

	public ResourceDeserializer(URIHandler uriHandler) {
		this.uriHandler = uriHandler;
	}

	@Override
	public boolean isCachable() {
		return true;
	}

	@Override
	public Resource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return deserialize(jp, ctxt, null);
	}

	@Override
	public Resource deserialize(JsonParser jp, DeserializationContext ctxt, Resource intoValue) throws IOException {
		final Resource resource = getResource(ctxt, intoValue);
		if (resource == null) {
			throw new IllegalArgumentException("Invalid resource");
		}

		EMFContext.init(resource, ctxt);

		if (!jp.hasCurrentToken()) {
			jp.nextToken();
		}

		JsonDeserializer<Object> deserializer =
				ctxt.findRootValueDeserializer(ctxt.constructType(EObject.class));

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {

			while (jp.nextToken() != JsonToken.END_ARRAY) {

				EObject value = (EObject) deserializer.deserialize(jp, ctxt);
				if (value != null) {
					resource.getContents().add(value);
				}
			}

		} else if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
			EObject value = (EObject) deserializer.deserialize(jp, ctxt);
			if (value != null) {
				resource.getContents().add(value);
			}
		}

		EMFContext.resolve(ctxt, uriHandler);

		return resource;
	}

	private Resource getResource(DeserializationContext context, Resource resource) {
		if (resource == null) {
			resource = EMFContext.getResource(context);

			if (resource == null) {
				ResourceSet resourceSet = getResourceSet(context);
				URI uri = getURI(context);
				resource = resourceSet.createResource(uri);
				// no factory found for uri
				if (resource == null) {
					throw new RuntimeException("Cannot create resource for uri " + uri);
				}
			}
		} else {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet == null) {
				resourceSet = getResourceSet(context);
				resourceSet.getResources().add(resource);
			}

			return resource;
		}

		return resource;
	}

	protected ResourceSet getResourceSet(DeserializationContext context) {
		ResourceSet resourceSet = EMFContext.getResourceSet(context);
		if (resourceSet == null) {
			context.setAttribute(RESOURCE_SET, resourceSet = new ResourceSetImpl());
		}

		return resourceSet;
	}

	private URI getURI(DeserializationContext ctxt) {
		URI uri = EMFContext.getURI(ctxt);
		if (uri == null) {
			uri = URI.createURI("default");
		}

		return uri;
	}

	@Override
	public Class<Resource> handledType() {
		return Resource.class;
	}

}
