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
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.databind.property.EObjectProperty;
import org.emfjson.jackson.databind.property.EObjectPropertyMap;
import org.emfjson.jackson.utils.EObjects;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.getParent;

public class EObjectSerializer extends JsonSerializer<EObject> {

	private final JsonSerializer<EObject> refSerializer;
	private final EObjectPropertyMap.Builder builder;

	public EObjectSerializer(EObjectPropertyMap.Builder builder, JsonSerializer<EObject> serializer) {
		this.builder = builder;
		this.refSerializer = serializer;
	}

	@Override
	public Class<EObject> handledType() {
		return EObject.class;
	}

	@Override
	public void serialize(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		EObjectPropertyMap properties = builder.construct(provider, object.eClass());

		final EObject parent = getParent(provider);
		if (parent != null && (object.eIsProxy() || EObjects.isContainmentProxy(provider, parent, object))) {
			// containment proxies are serialized as references
			refSerializer.serialize(object, jg, provider);
			return;
		}

		jg.writeStartObject();
		for (EObjectProperty property : properties.getProperties()) {
			property.serialize(object, jg, provider);
		}
		jg.writeEndObject();
	}

}
