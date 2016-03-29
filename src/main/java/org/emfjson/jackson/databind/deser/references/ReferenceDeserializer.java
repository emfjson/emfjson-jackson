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
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.Keywords;
import org.emfjson.jackson.common.ContextUtils;
import org.emfjson.jackson.common.DefaultReferenceEntry;
import org.emfjson.jackson.common.ReferenceEntries.ReferenceEntry;
import org.emfjson.jackson.module.EMFModule;

import java.io.IOException;
import java.util.Map;

import static org.emfjson.jackson.module.EMFModule.FeatureKind.OPTION_SERIALIZE_REF_AS_VALUE;

public class ReferenceDeserializer extends JsonDeserializer<ReferenceEntry> {

	private final Keywords keywords;
	private final Map<EMFModule.FeatureKind, Boolean> features;

	public ReferenceDeserializer(Keywords keywords, Map<EMFModule.FeatureKind, Boolean> features) {
		this.keywords = keywords;
		this.features = features;
	}

	@Override
	public ReferenceEntry deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EObject parent = ContextUtils.get(EObject.class, "parent", ctxt);
		EReference reference = ContextUtils.get(EReference.class, "reference", ctxt);

		// clear context
//		ctxt.setAttribute("parent", new Object());
//		ctxt.setAttribute("reference", new Object());

		String id = null;
		String type = null;

		if (features.get(OPTION_SERIALIZE_REF_AS_VALUE)) {

			if (JsonToken.VALUE_STRING.equals(jp.getCurrentToken())) {
				id = jp.getText();
			}

		} else {
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				final String field = jp.getCurrentName();

				if (field.equalsIgnoreCase(keywords._ref)) {
					id = jp.nextTextValue();
				} else if (field.equalsIgnoreCase(keywords._type)) {
					type = jp.nextTextValue();
				}
			}
		}

		return id != null ?
				new DefaultReferenceEntry(parent, reference, id, type):
				null;
	}

}
