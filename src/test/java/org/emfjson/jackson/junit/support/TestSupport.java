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
package org.emfjson.jackson.junit.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.After;
import org.junit.Before;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import static org.emfjson.jackson.JacksonOptions.from;

public abstract class TestSupport {

	protected final Map<String, Object> options = new HashMap<>();
	protected URI baseTestFilesFileDirectory = URI.createFileURI("src/test/resources/tests/");
	protected String baseURI = "http://eclipselabs.org/emfjson/tests/";
	protected ResourceSet resourceSet;
	protected ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		URI baseURI = URI.createURI("http://eclipselabs.org/emfjson/tests/");

		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIMap().put(baseURI, baseTestFilesFileDirectory);

		mapper.registerModule(new EMFModule(resourceSet, from(options)));
		final TimeZone timeZone = TimeZone.getTimeZone("GMT");
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		dateFormat.setTimeZone(timeZone);

		mapper.setDateFormat(dateFormat);

		createDynamicModel();
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	protected ObjectMapper mapper(JacksonOptions options) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule(resourceSet, options));
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

		return mapper;
	}

	protected URI uri(String fileName) {
		return URI.createURI(baseURI + fileName, true);
	}

	protected void createDynamicModel() {
		resourceSet.getURIConverter()
				.getURIMap()
				.put(
						URI.createURI("http://emfjson/dynamic/model"),
						URI.createURI("src/test/resources/model/dynamic/model.json"));

		Resource model = resourceSet.getResource(URI.createURI("http://emfjson/dynamic/model"), true);
		EPackage ePackage = (EPackage) model.getContents().get(0);
		resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
	}

}
