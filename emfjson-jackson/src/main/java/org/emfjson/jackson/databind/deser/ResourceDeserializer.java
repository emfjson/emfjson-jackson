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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.emfjson.common.ReferenceEntry;
import org.emfjson.jackson.resource.JsonResource;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceDeserializer extends JsonDeserializer<Resource> implements ContextualDeserializer {

	private final Resource resource;
	private final List<ReferenceEntry> entries;
	private final ResourceSet resourceSet;

	public ResourceDeserializer(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		this.resource = null;
		this.entries = new ArrayList<>();
	}

	public ResourceDeserializer(ResourceSet resourceSet, Resource resource, List<ReferenceEntry> entries) {
		this.resourceSet = resourceSet;
		this.resource = resource;
		this.entries = entries;
	}

	@Override
	public Resource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		if (!jp.hasCurrentToken()) {
			jp.nextToken();
		}

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {

			while (jp.nextToken() != JsonToken.END_ARRAY) {

				EObject result = ctxt.readPropertyValue(jp,
					new ResourceProperty(resourceSet, resource, entries),
					EObject.class);

				resource.getContents().add(result);
			}

		} else if (jp.getCurrentToken() == JsonToken.START_OBJECT) {

			EObject result = ctxt.readPropertyValue(jp,
				new ResourceProperty(resourceSet, resource, entries),
				EObject.class);

			resource.getContents().add(result);

		}

		for (ReferenceEntry entry : entries) {
			entry.resolve(resource.getResourceSet());
		}

		return resource;
	}

	@Override
	public Class<?> handledType() {
		return Resource.class;
	}

	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
		Resource resource = (Resource) ctxt.getAttribute("resource");
		Object uri = ctxt.getAttribute("uri");

		URI realURI;
		if (uri instanceof URI) {
			realURI = (URI) uri;
		} else if (uri instanceof String) {
			realURI = URI.createURI((String) uri);
		} else {
			realURI = URI.createURI("default");
		}

		if (resource == null) {
			resource = new JsonResource(realURI);
		}

		if (!resourceSet.equals(resource.getResourceSet())) {
			resourceSet.getResources().add(resource);
		}

		ctxt.setAttribute("resource", resource);
		ctxt.setAttribute("entries", entries);

		return new ResourceDeserializer(resourceSet, resource, entries);
	}

}
