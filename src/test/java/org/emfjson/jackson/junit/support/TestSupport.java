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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class TestSupport {

	protected final Map<String, Object> options = new HashMap<>();
	protected URI baseTestFilesFileDirectory = URI.createFileURI("src/test/resources/tests/");
	protected String baseURI = "http://eclipselabs.org/emfjson/tests/";
	protected ResourceSet resourceSet;
	protected ObjectMapper mapper;

	@Before
	public void setUp() {
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

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());

		createDynamicModel();
	}

	private ObjectMapper createMapper() {
		ObjectMapper mapper = new ObjectMapper();

		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getDefault());

		mapper.setDateFormat(dateFormat);
		mapper.setTimeZone(TimeZone.getDefault());

		return mapper;
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	protected ObjectMapper mapper(EMFModule.FeatureKind feature, Boolean value) {
		final ObjectMapper mapper = createMapper();
		final EMFModule module = new EMFModule();
		module.configure(feature, value);
		mapper.registerModule(module);

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

	protected JsonNode valueToTree(ContextAttributes attributes, Object value) throws IOException {
		return mapper.readTree(mapper
				.writer()
				.with(attributes)
				.writeValueAsBytes(value));
	}

	protected <T> T treeToValue(ContextAttributes attributes, JsonNode tree, Class<T> type) throws JsonProcessingException {
		return mapper.reader()
				.with(attributes)
				.forType(type)
				.treeToValue(tree, type);
	}

}
