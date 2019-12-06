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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.EMFContext;

import java.io.IOException;

public class EcoreReferenceDeserializer extends JsonDeserializer<ReferenceEntry> {

	private final EcoreReferenceInfo info;
	private final EcoreTypeInfo typeInfo;

	public EcoreReferenceDeserializer(EcoreReferenceInfo info, EcoreTypeInfo typeInfo) {
		this.typeInfo = typeInfo;
		this.info = info;
	}

	@Override
	public ReferenceEntry deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EObject parent = EMFContext.getParent(ctxt);
		EReference reference = EMFContext.getReference(ctxt);

		String id = null;
		String type = null;

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String field = jp.getCurrentName();

			if (field.equalsIgnoreCase(info.getProperty())) {
				id = jp.nextTextValue();
			} else if (field.equalsIgnoreCase(typeInfo.getProperty())) {
				type = jp.nextTextValue();
			}
		}

		return id != null ? new ReferenceEntry.Base(parent, reference, id, type): null;
	}

}
