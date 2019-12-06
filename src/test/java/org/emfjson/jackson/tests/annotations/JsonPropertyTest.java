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

package org.emfjson.jackson.tests.annotations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.annotations.AnnotationsFactory;
import org.emfjson.jackson.junit.annotations.AnnotationsPackage;
import org.emfjson.jackson.junit.annotations.TestB;
import org.emfjson.jackson.module.EMFModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPropertyTest {

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(AnnotationsPackage.eNS_URI, AnnotationsPackage.eINSTANCE);

		mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	@Test
	public void testSave_AttributeAnnotation_WithValue() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/annotations#//TestB")
				.put("my_value", "Hello")
				.put("hello", "Hello");

		TestB b1 = AnnotationsFactory.eINSTANCE.createTestB();
		b1.setValue("Hello");

		assertThat((JsonNode) mapper.valueToTree(b1))
				.isEqualTo(expected);
	}

	@Test
	public void testLoad_AttributeAnnotation_WithValue() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/annotations#//TestB")
				.put("my_value", "Hello")
				.put("hello", "Hello");

		TestB b = mapper.readValue(data.toString(), TestB.class);

		assertThat(b).isNotNull();
		assertThat(b.eResource()).isNull();
		assertThat(b.getValue()).isEqualTo("Hello");
	}

	@Test
	public void testMethodAnnotation() {
		TestB b1 = AnnotationsFactory.eINSTANCE.createTestB();

		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/annotations#//TestB")
				.put("hello", "Hello");

		assertThat((JsonNode) mapper.valueToTree(b1))
				.isEqualTo(expected);
	}

}
