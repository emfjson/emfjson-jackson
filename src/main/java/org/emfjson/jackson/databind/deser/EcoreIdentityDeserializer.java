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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;

import java.io.IOException;

public class EcoreIdentityDeserializer extends JsonDeserializer<String> {

	private final EcoreIdentityInfo info;

	public EcoreIdentityDeserializer(EcoreIdentityInfo info) {
		this.info = info;
	}

	@Override
	public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return jp.nextTextValue();
	}

}
