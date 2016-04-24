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

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.emfjson.jackson.internal.Cache;
import org.emfjson.jackson.databind.type.EcoreType;

import java.io.IOException;

public class ResourceSerializer extends JsonSerializer<Resource> {

	@Override
	public void serialize(Resource value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		final TypeFactory factory = TypeFactory.defaultInstance();

		provider.setAttribute("cache", new Cache());
		provider.setAttribute("typeFactory", new EcoreType());

		JsonSerializer<Object> serializer;
		if (value.getContents().size() == 1) {
			serializer = provider.findValueSerializer(
					EObject.class
			);
			serializer.serialize(value.getContents().get(0), jg, provider);
		} else {
			serializer = provider.findValueSerializer(
					factory.constructCollectionType(EList.class, factory.constructType(EObject.class))
			);
			serializer.serialize(value.getContents(), jg, provider);
		}
	}

	@Override
	public Class<Resource> handledType() {
		return Resource.class;
	}

}
