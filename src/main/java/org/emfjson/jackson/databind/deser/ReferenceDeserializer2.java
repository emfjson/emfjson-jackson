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
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.common.ReferenceEntries.ReferenceEntry;
import org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer;

import java.io.IOException;

public class ReferenceDeserializer2 extends JsonDeserializer<ReferenceEntry> {

	@Override
	public ReferenceEntry deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EObject parent = (EObject) ctxt.getAttribute("parent");
		EReference reference = (EReference) ctxt.getAttribute("reference");
		ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");

		ctxt.setAttribute("parent", new Object());
		ctxt.setAttribute("reference", new Object());

		ReferenceEntry entry = new ReferenceAsObjectDeserializer().deserialize(jp, parent, reference, ctxt);
		entries.add(entry);
		return entry;
	}

}
