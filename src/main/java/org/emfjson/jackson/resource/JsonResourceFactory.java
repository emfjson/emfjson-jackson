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
package org.emfjson.jackson.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.emfjson.jackson.module.EMFModule;

/**
 * An implementation of Resource Factory that creates JsonResource.
 */
public class JsonResourceFactory extends ResourceFactoryImpl {

	private final ObjectMapper mapper;

	public JsonResourceFactory() {
		this.mapper = EMFModule.setupDefaultMapper();
	}

	public JsonResourceFactory(ObjectMapper mapper) {
		if (mapper == null) throw new IllegalArgumentException();
		this.mapper = mapper;
	}

	@Override
	public Resource createResource(URI uri) {
		return new JsonResource(uri, mapper);
	}

	public ObjectMapper getMapper() {
		return mapper;
	}
}
