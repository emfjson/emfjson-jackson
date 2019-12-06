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
