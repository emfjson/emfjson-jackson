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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.deser.DateDeserializer;
import org.emfjson.jackson.databind.deser.EObjectDeserializer;
import org.emfjson.jackson.databind.deser.ResourceDeserializer;
import org.emfjson.jackson.databind.ser.*;
import org.emfjson.jackson.resource.JsonResourceFactory;

import java.util.Date;

/**
 * Module implementation that allows serialization and deserialization of
 * EMF objects (EObject and Resource).
 */
public class EMFModule extends SimpleModule {

	private static final long serialVersionUID = 1L;
	private final ResourceSet resourceSet;
	private final JacksonOptions options;
	private final Resource.Factory factory;

	public EMFModule(ResourceSet resourceSet) {
		this(resourceSet, new JacksonOptions.Builder().build(), null);
	}

	public EMFModule(ResourceSet resourceSet, JacksonOptions options) {
		this(resourceSet, options, null);
	}

	public EMFModule(ResourceSet resourceSet, JacksonOptions options, Resource.Factory factory) {
		if (factory != null) {
			this.factory = factory;
		} else {
			this.factory = new JsonResourceFactory();
		}
		if (resourceSet == null) {
			this.resourceSet = new ResourceSetImpl();
		} else {
			this.resourceSet = resourceSet;
		}

		if (options == null) {
			this.options = new JacksonOptions.Builder().build();
		} else {
			this.options = options;
		}

		configure();
	}

	protected void configure() {
		addSerializer(new EObjectSerializer(options));
		addSerializer(new ResourceSerializer());
		addSerializer(new DateSerializer());
		EnumeratorSerializer enumeratorSerializer = new EnumeratorSerializer();
		addSerializer(new EEnumLiteralSerializer(enumeratorSerializer));
		addSerializer(enumeratorSerializer);
		addSerializer(new EMapSerializer());
		addSerializer(new EStringToStringMapEntrySerializer());
		addDeserializer(EObject.class, new EObjectDeserializer(resourceSet, options, factory));
		addDeserializer(Resource.class, new ResourceDeserializer(resourceSet, options, factory));
		addDeserializer(Date.class, new DateDeserializer());
	}

	@Override
	public String getModuleName() {
		return "emfjson-module";
	}

	@Override
	public Version version() {
		return new Version(0, 11, 0, "SNAPSHOT", "org.emfjson", "emfjson-jackson");
	}

}
