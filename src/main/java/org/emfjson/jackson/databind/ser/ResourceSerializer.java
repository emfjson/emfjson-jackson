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

import org.eclipse.emf.ecore.resource.Resource;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ResourceSerializer extends JsonSerializer<Resource> {

	@Override
	public void serialize(Resource value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (value.getContents().size() == 1) {
			jg.writeObject(value.getContents().get(0));
		} else {
			jg.writeObject(value.getContents());
		}
	}

	@Override
	public Class<Resource> handledType() {
		return Resource.class;
	}

}
