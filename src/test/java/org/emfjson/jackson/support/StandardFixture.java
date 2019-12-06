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

package org.emfjson.jackson.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.junit.generics.GenericsPackage;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.rules.ExternalResource;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class StandardFixture extends ExternalResource {

	private ObjectMapper mapper;
	private ResourceSetImpl resourceSet;

	protected URI baseTestFilesFileDirectory = URI.createFileURI("src/test/resources/tests/");

	@Override
	protected void before() throws Throwable {
		URI baseURI = URI.createURI("http://eclipselabs.org/emfjson/tests/");

		mapper = createMapper();
		mapper.registerModule(new EMFModule());

		resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter()
				.getURIMap()
				.put(baseURI, baseTestFilesFileDirectory);

		EPackage.Registry.INSTANCE
				.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		EPackage.Registry.INSTANCE
				.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

		EPackage.Registry.INSTANCE
				.put(GenericsPackage.eNS_URI, GenericsPackage.eINSTANCE);

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
	}

	@Override
	protected void after() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	private ObjectMapper createMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getDefault());

		mapper.setDateFormat(dateFormat);
		mapper.setTimeZone(TimeZone.getDefault());

		return mapper;
	}

	public ResourceSetImpl getResourceSet() {
		return resourceSet;
	}

	public ObjectMapper mapper() {
		return mapper;
	}

	public ObjectMapper mapper(EMFModule.Feature feature, Boolean value) {
		final ObjectMapper mapper = createMapper();
		final EMFModule module = new EMFModule();
		module.configure(feature, value);
		mapper.registerModule(module);

		return mapper;
	}
}
