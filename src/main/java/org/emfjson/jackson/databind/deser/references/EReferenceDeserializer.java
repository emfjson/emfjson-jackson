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
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.databind.deser.references.ReferenceEntries.ReferenceEntry;
import org.emfjson.jackson.internal.ContextUtils;

import java.io.IOException;

public abstract class EReferenceDeserializer extends JsonDeserializer<ReferenceEntry> {

	public static final String PROPERTY = "$ref";
	public static final String PROPERTY_TYPE = "eClass";

	@Override
	public ReferenceEntry deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EObject parent = ContextUtils.get(EObject.class, "parent", ctxt);
		EReference reference = ContextUtils.get(EReference.class, "reference", ctxt);

		return deserialize(jp, parent, reference, ctxt);
	}

	public abstract ReferenceEntry deserialize(JsonParser jp, EObject parent, EReference reference, DeserializationContext context) throws IOException;

	public String getProperty() {
		return PROPERTY;
	}

	public String getPropertyType() {
		return PROPERTY_TYPE;
	}
}
