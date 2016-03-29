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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.Keywords;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.common.ContextUtils;

import java.io.IOException;

public class IdSerializer extends JsonSerializer<EObject> {

	protected final Keywords keywords;

	public IdSerializer(Keywords keywords) {
		this.keywords = keywords;
	}

	@Override
	public void serialize(EObject value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final Cache cache = ContextUtils.get(Cache.class, "cache", serializers);
		URI uri;
		if (cache != null) {
			uri = cache.getURI(value);
		} else {
			uri = EcoreUtil.getURI(value);
		}

		jg.writeStringField(keywords._id, uri.fragment());
	}

}
