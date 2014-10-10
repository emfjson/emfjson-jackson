/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.module;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.streaming.StreamReader;
import org.emfjson.jackson.streaming.StreamWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Module implementation that allows serialization and deserialization of 
 * EMF objects (EObject and Resource).
 * 
 */
public class EMFModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public EMFModule() {
		addSerializer(new EObjectJsonSerializer());
		addSerializer(new ResourceJsonSerializer());
		addDeserializer(EObject.class, new EObjectJsonDeserializer());
		addDeserializer(Resource.class, new ResourceJsonDeserializer());
	}

	@Override
	public String getModuleName() {
		return "emfjson-module";
	}

	@Override
	public Version version() {
		return new Version(0, 9, 0, "SNAPSHOT", "org.emfjson", "emfjson-jackson");
	}

	public static class EObjectJsonSerializer extends JsonSerializer<EObject> {
		@Override
		public void serialize(EObject value, JsonGenerator jgen, SerializerProvider provider) 
				throws IOException, JsonProcessingException {

			StreamWriter writer = new StreamWriter(null);
			writer.generate(jgen, value);
		}

		@Override
		public Class<EObject> handledType() {
			return EObject.class;
		}
	}

	public static class ResourceJsonSerializer extends JsonSerializer<Resource> {
		@Override
		public void serialize(Resource value, JsonGenerator jgen, SerializerProvider provider) 
				throws IOException, JsonProcessingException {

			StreamWriter writer = new StreamWriter(value.getURI());
			writer.generate(jgen, value.getContents());
		}

		@Override
		public Class<Resource> handledType() {
			return Resource.class;
		}
	}

	public static class EObjectJsonDeserializer extends JsonDeserializer<EObject> {
		@Override
		public EObject deserialize(JsonParser jp, DeserializationContext ctxt) 
				throws IOException, JsonProcessingException {

			StreamReader reader = new StreamReader(null);
			return reader.parseObject(jp, null, null, null);
		}

		@Override
		public Class<?> handledType() {
			return EObject.class;
		}
	}

	public static class ResourceJsonDeserializer extends JsonDeserializer<Resource> {
		@Override
		public Resource deserialize(JsonParser jp, DeserializationContext ctxt) 
				throws IOException, JsonProcessingException {

			Resource resource = new JsonResource();
			StreamReader reader = new StreamReader(resource);
			reader.parse(jp);

			return resource;
		}

		@Override
		public Class<?> handledType() {
			return Resource.class;
		}
	}

}
