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
