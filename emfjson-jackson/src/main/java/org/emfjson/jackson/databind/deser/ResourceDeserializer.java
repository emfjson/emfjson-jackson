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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.jackson.JacksonOptions;

import java.io.IOException;

public class ResourceDeserializer extends JsonDeserializer<Resource> {

	private final ResourceSet resourceSet;
	private final JacksonOptions options;
	private Resource.Factory factory;

	public ResourceDeserializer(ResourceSet resourceSet, JacksonOptions options, Resource.Factory factory) {
		this.resourceSet = resourceSet;
		this.options = options;
		this.factory = factory;
	}

	@Override
	public Resource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final Resource resource = getResource(ctxt);
		final ReferenceEntries entries = new ReferenceEntries();

		ctxt.setAttribute("resource", resource);
		ctxt.setAttribute("entries", entries);

		if (!jp.hasCurrentToken()) {
			jp.nextToken();
		}

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {

			while (jp.nextToken() != JsonToken.END_ARRAY) {

				EObject result = ctxt.readPropertyValue(jp,
						new ResourceProperty(resourceSet, resource, entries),
						EObject.class);

				if (result != null) {
					resource.getContents().add(result);
					entries.store(resource, result);
				}
			}

		} else if (jp.getCurrentToken() == JsonToken.START_OBJECT) {

			EObject result = ctxt.readPropertyValue(jp,
					new ResourceProperty(resourceSet, resource, entries),
					EObject.class);

			if (result != null) {
				resource.getContents().add(result);
				entries.store(resource, result);
			}

		}

		entries.resolve(resourceSet, options.uriHandler);

		return resource;
	}

	private Resource getResource(DeserializationContext ctxt) {
		Resource resource = (Resource) ctxt.getAttribute("resource");
		URI uri = getURI(ctxt);

		if (resource == null) {
			resource = factory.createResource(uri);
		}

		if (!resourceSet.equals(resource.getResourceSet())) {
			resourceSet.getResources().add(resource);
		}

		return resource;
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
	public Class<?> handledType() {
		return Resource.class;
	}

}
