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
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EClass;
import org.emfjson.jackson.annotations.EcoreTypeInfo;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.getCache;
import static org.emfjson.jackson.databind.EMFContext.getResourceSet;

public class EcoreTypeDeserializer extends JsonDeserializer<EClass> {

	private final EcoreTypeInfo info;

	public EcoreTypeDeserializer(EcoreTypeInfo info) {
		this.info = info;
	}

	@Override
	public EClass deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		try {
			return getCache(ctxt).getEClass(getResourceSet(ctxt), jp.nextTextValue());
		} catch (Exception e) {
			return null;
		}
	}

}
