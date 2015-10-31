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
package org.emfjson.jackson.databind.deser.references;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.common.DefaultReferenceEntry;
import org.emfjson.jackson.common.ReferenceEntries.ReferenceEntry;
import org.emfjson.jackson.JacksonOptions;

import java.io.IOException;

public class ReferenceAsObjectDeserializer implements ReferenceDeserializer {

	@Override
	public ReferenceEntry deserialize(JsonParser jp, EObject owner, EReference reference, DeserializationContext ctxt) throws IOException {
		final JacksonOptions options = (JacksonOptions) ctxt.getAttribute("options");
		String id = null;

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			String field = jp.getCurrentName();

			if (field.equalsIgnoreCase(options.refField)) {
				id = jp.nextTextValue();
			}
		}

		return new DefaultReferenceEntry(owner, reference, id);
	}

}
