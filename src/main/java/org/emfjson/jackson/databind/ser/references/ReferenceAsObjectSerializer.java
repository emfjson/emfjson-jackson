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
package org.emfjson.jackson.databind.ser.references;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.handlers.URIHandler;
import org.emfjson.jackson.JacksonOptions;

import java.io.IOException;

public class ReferenceAsObjectSerializer extends AbstractReferenceSerializer {

	@Override
	public void serialize(EObject source, EObject target, JsonGenerator jg, SerializerProvider provider) throws IOException {
		final Cache cache = (Cache) provider.getAttribute("cache");
		final JacksonOptions options = (JacksonOptions) provider.getAttribute("options");
		final URIHandler handler = options.uriHandler;

		if (target == null) {
			jg.writeNull();
		} else {
			URI targetURI = cache.getURI(target);

			jg.writeStartObject();
			if (isExternal(source, target)) {
				targetURI = deresolve(handler, targetURI, cache, source);

				if (targetURI == null) {
					jg.writeNullField(options.refField);
				} else {
					jg.writeStringField(options.refField, targetURI.toString());
				}
			} else {
				jg.writeStringField(options.refField, targetURI.fragment());
			}
			jg.writeEndObject();
		}
	}

}
