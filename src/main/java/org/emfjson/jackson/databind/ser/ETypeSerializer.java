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
import org.emfjson.jackson.internal.Cache;
import org.emfjson.jackson.internal.ContextUtils;

import java.io.IOException;

public class ETypeSerializer extends JsonSerializer<EClass> {

	public static final String PROPERTY = "eClass";

	@Override
	public void serialize(EClass value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final Cache cache = ContextUtils.getCache(serializers);

		jg.writeStringField(getProperty(), cache.getType(value));
	}

	public String getProperty() {
		return PROPERTY;
	}

}
