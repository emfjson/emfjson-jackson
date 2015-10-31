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
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EClass;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.JacksonOptions;

import java.io.IOException;

public class DefaultTypeSerializer implements TypeSerializer {
	@Override
	public void serialize(EClass eClass, JsonGenerator jg, SerializerProvider provider) throws IOException {
		final Cache cache = (Cache) provider.getAttribute("cache");
		final JacksonOptions options = (JacksonOptions) provider.getAttribute("options");

		if (options != null && cache != null && options.serializeTypes) {
			jg.writeStringField(options.typeField, cache.getType(eClass));
		}
	}
}
