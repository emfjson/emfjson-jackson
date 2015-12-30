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
package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

public class EMapEntrySerializer extends JsonSerializer<Map.Entry> {

	@Override
	public void serialize(Map.Entry entry, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		if (entry.getKey() instanceof String) {
			jg.writeObjectField((String) entry.getKey(), entry.getValue());
		} else {
			jg.writeStartObject();
			jg.writeObjectField("key", entry.getKey());
			jg.writeObjectField("value", entry.getValue());
			jg.writeEndObject();
		}
	}

	@Override
	public Class<Map.Entry> handledType() {
		return Map.Entry.class;
	}
}
