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
package org.emfjson.jackson.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.JacksonOptions;

/**
 * Module implementation that allows serialization and deserialization of
 * EMF objects (EObject and Resource).
 */
public class EMFModule extends SimpleModule {

	private static final long serialVersionUID = 1L;
	private final ResourceSet resourceSet;
	private final JacksonOptions options;

	public EMFModule(ResourceSet resourceSet) {
		this(resourceSet, new JacksonOptions.Builder().build());
	}

	public EMFModule(ResourceSet resourceSet, JacksonOptions options) {
		this.resourceSet = resourceSet == null ? new ResourceSetImpl(): resourceSet;
		this.options = options == null ? new JacksonOptions.Builder().build(): options;
	}

	@Override
	public void setupModule(SetupContext context) {
		context.addDeserializers(new EMFDeserializers(resourceSet, options));
		context.addSerializers(new EMFSerializers(options));

		super.setupModule(context);
	}

	@Override
	public String getModuleName() {
		return "emfjson-module";
	}

	@Override
	public Version version() {
		return new Version(0, 15, 0, null, "org.emfjson", "emfjson-jackson");
	}

}
