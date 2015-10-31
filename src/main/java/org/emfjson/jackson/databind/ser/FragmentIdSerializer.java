/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.JacksonOptions;

import java.io.IOException;

public class FragmentIdSerializer implements IdSerializer {

	@Override
	public void serialize(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		final Cache cache = (Cache) provider.getAttribute("cache");
		final JacksonOptions options = (JacksonOptions) provider.getAttribute("options");

		if (options != null && options.useId) {

			URI uri;
			if (cache != null) {
				uri = cache.getURI(object);
			} else {
				uri = EcoreUtil.getURI(object);
			}

			jg.writeStringField(options.idField, uri.fragment());
		}
	}

}
