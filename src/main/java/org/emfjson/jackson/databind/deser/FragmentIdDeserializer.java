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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.resource.JsonResource;

import java.io.IOException;

public class FragmentIdDeserializer implements IdDeserializer {

	@Override
	public void deserialize(JsonParser jp, EObject current, DeserializationContext ctxt) throws IOException {
		Resource resource = (Resource) ctxt.getAttribute("resource");
		String id = jp.nextTextValue();

		if (current != null && resource != null) {
			if (resource instanceof JsonResource) {
				((JsonResource) resource).setID(current, id);
			}
		}
	}

}
