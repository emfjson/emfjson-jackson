/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.common.ContextUtils;

import java.io.IOException;

public class TypeDeserializer extends JsonDeserializer<EClass> {

	@Override
	public EClass deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final ResourceSet resourceSet = ContextUtils.get(ResourceSet.class, "resourceSet", ctxt);
		final Cache cache = ContextUtils.get(Cache.class, "cache", ctxt);

		return cache != null ?
				cache.getEClass(resourceSet, jp.nextTextValue()) :
				null;
	}

}
