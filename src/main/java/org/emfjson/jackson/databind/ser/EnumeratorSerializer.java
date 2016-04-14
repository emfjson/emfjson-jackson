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
import org.eclipse.emf.common.util.Enumerator;

import java.io.IOException;

public class EnumeratorSerializer extends JsonSerializer<Enumerator> {

	@Override
	public void serialize(Enumerator value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		jg.writeString(value.getLiteral());
	}

	@Override
	public Class<Enumerator> handledType() {
		return Enumerator.class;
	}

}
