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
package org.emfjson.jackson.streaming;

import static org.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.emfjson.common.Constants.EJS_TYPE_KEYWORD;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.common.Cache;
import org.emfjson.common.Options;

import com.fasterxml.jackson.core.JsonGenerator;

public class References {

	private final Cache cache;
	private final Options options;
	private final RefWriter writer;
	private final Resource resource;

	public References(Cache cache, Resource resource, RefWriter writer, Options options) {
		this.cache = cache;
		this.resource = resource;
		this.writer = writer;
		this.options = options;
	}

	public void serialize(JsonGenerator generator, String key, EReference reference, Object value) {
		if (reference.isMany()) {
			serializeMany(generator, key, (Collection<?>) value);
		} else {
			serializeOne(generator, key, (EObject) value);
		}
	}

	public void serializeMany(JsonGenerator generator, String key, Collection<?> values) {
		try {
			generator.writeFieldName(key);
			generator.writeStartArray();
			for (Object current: values) {
				if (current instanceof EObject) {
					writeRef(generator, (EObject) current);
				}
			}
			generator.writeEndArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void serializeOne(JsonGenerator generator, String key, EObject value) {
		try {
			generator.writeFieldName(key);
			writeRef(generator, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeRef(JsonGenerator generator, EObject object) throws IOException {
		writer.write(cache, resource, generator, object, options);
	}

	public interface RefWriter {
		void write(Cache cache, Resource resource, JsonGenerator generator, EObject object, Options options) throws IOException;
	}

	public static class RefAsObjectWriter implements RefWriter {
		@Override
		public void write(Cache cache, Resource resource, JsonGenerator generator, EObject object, Options options) throws IOException {
			String ref = cache.getHref(resource, object);
			generator.writeStartObject();
			if (options.serializeRefTypes) {
				String type = cache.getHref(null, object.eClass());
				generator.writeStringField(EJS_TYPE_KEYWORD, type);
			}
			generator.writeStringField(EJS_REF_KEYWORD, ref);
			generator.writeEndObject();
		}
	}
	
	public static class RefAsValueWriter implements RefWriter {
		@Override
		public void write(Cache cache, Resource resource, JsonGenerator generator, EObject object, Options options) throws IOException {
			generator.writeString(cache.getHref(resource, object));
		}
	}

}
