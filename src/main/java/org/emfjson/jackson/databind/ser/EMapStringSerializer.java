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
import org.eclipse.emf.common.util.EList;

import java.io.IOException;
import java.util.Map;

public class EMapStringSerializer extends JsonSerializer<EList<Map.Entry<String, ?>>> {

	@Override
	public void serialize(EList<Map.Entry<String, ?>> value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		if (value == null || value.isEmpty()) {
			jg.writeNull();
			return;
		}

		jg.writeStartObject();
		for (Map.Entry<String, ?> entry : value) {
			jg.writeObjectField(entry.getKey(), entry.getValue());
		}
		jg.writeEndObject();
	}

}
