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
import org.emfjson.common.IDResolver;
import org.emfjson.common.Options;

import com.fasterxml.jackson.core.JsonGenerator;

public class ReferenceStreamWriter {

	private final IDResolver idResolver;
	private final Options options;

	public ReferenceStreamWriter(IDResolver idResolver, Options options) {
		this.idResolver = idResolver;
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
					writeObjectRef(generator, (EObject) current);
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
			writeObjectRef(generator, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeObjectRef(JsonGenerator generator, EObject object) throws IOException {
		String ref = idResolver.getValue(object);
		generator.writeStartObject();
		if (options.serializeRefTypes) {
			String type = idResolver.getValue(object.eClass());
			generator.writeStringField(EJS_TYPE_KEYWORD, type);
		}
		generator.writeStringField(EJS_REF_KEYWORD, ref);
		generator.writeEndObject();
	}

}
