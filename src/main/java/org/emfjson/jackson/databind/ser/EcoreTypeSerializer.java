/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EClass;
import org.emfjson.jackson.annotations.EcoreTypeInfo;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.getCache;

public class EcoreTypeSerializer extends JsonSerializer<EClass> {

	private final EcoreTypeInfo info;

	public EcoreTypeSerializer(EcoreTypeInfo info) {
		this.info = info;
	}

	@Override
	public void serialize(EClass value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		jg.writeStringField(info.getProperty(), getCache(serializers).getType(value));
	}

}
