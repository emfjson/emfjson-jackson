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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.utils.EObjects;

import java.io.IOException;
import java.util.Map;

public class EMapDeserializer extends JsonDeserializer<EList<Map.Entry<?, ?>>> {

	@Override
	public EList<Map.Entry<?, ?>> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public EList<Map.Entry<?, ?>> deserialize(JsonParser jp, DeserializationContext ctxt, EList<Map.Entry<?, ?>> intoValue) throws IOException {
		EReference reference = EMFContext.getReference(ctxt);

		if (reference != null) {
			EClass referenceType = reference.getEReferenceType();
			EStructuralFeature valueFeature = referenceType.getEStructuralFeature("value");

			if (valueFeature != null) {
				EMFContext.setFeature(ctxt, valueFeature);
			}
		}

		if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				String key = jp.getCurrentName();
				jp.nextToken();

				final Object value;
				if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
					value = ctxt.readValue(jp, EObject.class);
				} else {
					value = ctxt.readValue(jp, Object.class);
				}

				// Dynamic objects do not use the EMap interface
				// but store entries in a DynamicEList instead.
				if (intoValue instanceof EMap) {
					((EMap) intoValue).put(key, value);
				} else if (reference != null) {
					intoValue.add((Map.Entry<?, ?>) EObjects.createEntry(key, value, reference.getEReferenceType()));
				}
			}
		}

		return intoValue;
	}

}
