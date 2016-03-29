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
import com.fasterxml.jackson.databind.type.SimpleType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.Options;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.common.ReferenceEntries;
import org.emfjson.jackson.handlers.URIHandler;

import java.io.IOException;

import static org.emfjson.jackson.common.ContextUtils.get;

public class ResourceDeserializer extends JsonDeserializer<Resource> {

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

		final ReferenceEntries entries = new ReferenceEntries();
		final ResourceSet resourceSet = resource.getResourceSet();

		ctxt.setAttribute("resource", resource);
		ctxt.setAttribute("entries", entries);
		ctxt.setAttribute("cache", new Cache());
		ctxt.setAttribute("resourceSet", resourceSet);

		if (!jp.hasCurrentToken()) {
			jp.nextToken();
		}

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {

			while (jp.nextToken() != JsonToken.END_ARRAY) {

				JsonDeserializer<Object> deserializer = ctxt.findContextualValueDeserializer(
						SimpleType.construct(EObject.class),
						new ResourceProperty(resourceSet, resource, entries));

				EObject value = (EObject) deserializer.deserialize(jp, ctxt);

				if (value != null) {
					resource.getContents().add(value);
				}
			}

		} else if (jp.getCurrentToken() == JsonToken.START_OBJECT) {

			JsonDeserializer<Object> deserializer = ctxt.findContextualValueDeserializer(
					SimpleType.construct(EObject.class),
					new ResourceProperty(resourceSet, resource, entries));

			EObject value = (EObject) deserializer.deserialize(jp, ctxt);

			if (value != null) {
				resource.getContents().add(value);
			}
		}

		entries.resolve(resourceSet, get(URIHandler.class, Options.OPTION_URI_HANDLER, ctxt));

		return resource;
	}

	private Resource getResource(DeserializationContext context, Resource resource) {
		if (resource == null) {
			resource = get(Resource.class, "resource", context);

			if (resource == null) {
				ResourceSet resourceSet = getResourceSet(context);
				URI uri = getURI(context);
				resource = resourceSet.createResource(uri);
				// no factory found for uri
				if (resource == null) {
					throw new RuntimeException("Cannot create resource for uri " + uri);
				}
			}
		}

		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			resourceSet = getResourceSet(context);
			resourceSet.getResources().add(resource);
		}

		return resource;
	}

	protected ResourceSet getResourceSet(DeserializationContext context) {
		if (get(ResourceSet.class, "resourceSet", context) == null) {
			context.setAttribute("resourceSet", new ResourceSetImpl());
		}

		return get(ResourceSet.class, "resourceSet", context);
	}

	private URI getURI(DeserializationContext ctxt) {
		Object uri = ctxt.getAttribute("uri");

		URI realURI;
		if (uri instanceof URI) {
			realURI = (URI) uri;
		} else if (uri instanceof String) {
			realURI = URI.createURI((String) uri);
		} else {
			realURI = URI.createURI("default");
		}

		return realURI;
	}

	@Override
	public Class<Resource> handledType() {
		return Resource.class;
	}

}
