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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.utils.Cache;

import java.io.IOException;

public class EcoreIdentitySerializer extends JsonSerializer<EObject> {

	private final EcoreIdentityInfo info;

	public EcoreIdentitySerializer(EcoreIdentityInfo info) {
		this.info = info;
	}

	@Override
	public void serialize(EObject value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final Cache cache = EMFContext.getCache(serializers);

		Resource resource = value.eResource();
		if (resource instanceof JsonResource) {
			String id = ((JsonResource) resource).getID(value);
			if (id != null) {
				jg.writeStringField(info.getProperty(), id);
			}
		} else {
			jg.writeStringField(info.getProperty(), cache.getURI(value).fragment());
		}
	}

}
