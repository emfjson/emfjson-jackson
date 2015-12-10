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
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import java.io.IOException;

public class EMapSerializer extends JsonSerializer<EMap> {

	@Override
	public void serialize(EMap value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (value.isEmpty()) {
			jg.writeStartArray();
			jg.writeEndArray();
		} else {
			BasicEMap.Entry<?, ?> o = (BasicEMap.Entry<?, ?>) value.get(0);
			if (o.getKey() instanceof String) {
				jg.writeStartObject();
				for (Object entry : value.entrySet()) {
					jg.writeObject(entry);
				}
				jg.writeEndObject();
			} else {
				jg.writeStartArray();
				for (Object key: value.keySet()) {
					jg.writeStartObject();
					jg.writeObjectField("key", key);
					jg.writeObjectField("value", value.get(key));
					jg.writeEndObject();
				}
				jg.writeEndArray();
			}
		}
	}

	@Override
	public Class<EMap> handledType() {
		return EMap.class;
	}

}

