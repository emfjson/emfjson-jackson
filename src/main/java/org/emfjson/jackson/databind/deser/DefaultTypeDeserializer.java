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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.common.Cache;

import java.io.IOException;

public class DefaultTypeDeserializer implements TypeDeserializer {

	@Override
	public EClass deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final ResourceSet resourceSet = (ResourceSet) ctxt.getAttribute("resourceSet");
		final Cache cache = (Cache) ctxt.getAttribute("cache");

		return cache.getEClass(resourceSet, jp.nextTextValue());
	}

}
