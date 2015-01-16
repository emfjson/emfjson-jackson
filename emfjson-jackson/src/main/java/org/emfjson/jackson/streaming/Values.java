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

import static org.eclipse.emf.ecore.util.EcoreUtil.convertToString;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.emfjson.converters.DataTypeConverter;

import com.fasterxml.jackson.core.JsonGenerator;

public class Values {

	private final Map<EDataType, DataTypeConverter<?, ?>> converters = new HashMap<>();

	public Values(Map<EDataType, DataTypeConverter<?, ?>> converters) {
		this.converters.putAll(converters);
	}

	public void serialize(JsonGenerator generator, String key, EAttribute attribute, Object value) {
		final EDataType type = attribute.getEAttributeType();

		if (attribute.isMany()) {
			serializeMany(generator, key, type, (Collection<?>) value);
		} else {
			serializeValue(generator, key, type, value);
		}
	}

	public void serializeMany(JsonGenerator generator, String key, EDataType type, Collection<?> values) {
		try {
			generator.writeFieldName(key);
			generator.writeStartArray();
			for (Object value: values) {
				writeValue(generator, type, value);
			}
			generator.writeEndArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serializeValue(JsonGenerator generator, String key, EDataType type, Object value) {
		try {
			generator.writeFieldName(key);
			writeValue(generator, type, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeValue(JsonGenerator generator, EDataType type, Object value) throws IOException {
		DataTypeConverter<?, ?> converter = converters.get(type);

		if (converter != null) {
			value = converter.getValue(value);
		}

		if (value instanceof String) {
			generator.writeString((String) value);
		}
		else if (value instanceof Integer) {
			generator.writeNumber((Integer) value);
		}
		else if (value instanceof Boolean) {
			generator.writeBoolean((Boolean) value);
		}
		else if (value instanceof Double) {
			generator.writeNumber((Double) value);
		}
		else if (value instanceof Long) {
			generator.writeNumber((Long) value);
		}
		else if (value instanceof Short) {
			generator.writeNumber((Short) value);
		}
		else if (value instanceof Float) {
			generator.writeNumber((Float) value);
		}
		else {
			generator.writeString(convertToString(type, value));
		}
	}

}
