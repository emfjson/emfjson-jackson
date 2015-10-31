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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.deser.EObjectDeserializer;
import org.emfjson.jackson.databind.deser.ResourceDeserializer;
import org.emfjson.jackson.databind.ser.*;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

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
		this.resourceSet = resourceSet == null ? new ResourceSetImpl() : resourceSet;
		this.options = options == null ? new JacksonOptions.Builder().build() : options;

		configure();
	}

	protected void configure() {
		addSerializer(new EObjectSerializer(options));
		addSerializer(new ResourceSerializer());
		addSerializer(Enumerator.class, new EnumeratorSerializer());
		addSerializer(EEnumLiteral.class, new EnumeratorSerializer());
		addSerializer(new EMapSerializer());
		addSerializer(new EStringToStringMapEntrySerializer());
		addDeserializer(EObject.class, new EObjectDeserializer(resourceSet, options));
		addDeserializer(Resource.class, new ResourceDeserializer(resourceSet, options));
	}

	@Override
	public String getModuleName() {
		return "emfjson-module";
	}

	@Override
	public Version version() {
		return new Version(0, 13, 0, null, "org.emfjson", "emfjson-jackson");
	}

}
