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
