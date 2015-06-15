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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.common.DefaultReferenceEntry;
import org.emfjson.jackson.JacksonOptions;

import java.io.IOException;

import static org.emfjson.common.ReferenceEntries.ReferenceEntry;

public class ReferenceAsValueDeserializer implements ReferenceDeserializer {

	@Override
	public ReferenceEntry deserialize(JsonParser jp, EObject owner, EReference reference, JacksonOptions options)
		throws IOException {

		if (JsonToken.VALUE_STRING.equals(jp.getCurrentToken())) {
			return new DefaultReferenceEntry(owner, reference, jp.getText());
		}

		return null;
	}

}
