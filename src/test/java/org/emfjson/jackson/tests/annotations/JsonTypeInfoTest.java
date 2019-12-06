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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.junit.annotations.*;
import org.emfjson.jackson.junit.annotations.impl.*;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.emfjson.jackson.databind.EMFContext.Attributes.ROOT_ELEMENT;
import static org.emfjson.jackson.junit.annotations.AnnotationsPackage.Literals.*;
import static org.emfjson.jackson.support.Utils.uriOf;

public class JsonTypeInfoTest {

	private ObjectMapper mapper;
	private ResourceSetImpl resourceSet;

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(AnnotationsPackage.eNS_URI, AnnotationsPackage.eINSTANCE);

		mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());

		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	@Test
	public void testSave_WithCustomTypeInfo() {
		JsonNode expected = mapper.createObjectNode()
				.put("@type", "http://www.emfjson.org/jackson/annotations#//TestA")
				.put("my_value", "a1")
				.set("childOfTypeC", mapper.createObjectNode());

		TestA a = AnnotationsFactory.eINSTANCE.createTestA();
		TestC c = AnnotationsFactory.eINSTANCE.createTestC();

		a.setValue("a1");
		a.setChildOfTypeC(c);

		assertThat((JsonNode) mapper.valueToTree(a))
				.isEqualTo(expected);
	}

	@Test
	public void testLoad_WithCustomTypeInfo() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("@type", "http://www.emfjson.org/jackson/annotations#//TestA")
				.put("my_value", "a1")
				.set("childOfTypeC", mapper.createObjectNode());

		TestA a = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, TEST_A)
				.forType(TestA.class)
				.readValue(data);

		assertThat(a).isNotNull();
		assertThat(a.getChildOfTypeC()).isNotNull();
	}

	@Test
	public void testLoad_WithAlias() throws IOException {
		final JsonNode data = mapper.createObjectNode()
				.put("eClass", uriOf(TEST_F))
				.put("value", "foo");

		resourceSet.createResource(URI.createURI("test.json"));

		final TestF f = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, TEST_F)
				.forType(TestF.class)
				.readValue(data);

		assertThat(f).isNotNull();
		assertThat(f.getValue()).isEqualTo("foo");
	}

	@Test
	public void testLoad_WithMultipleAlias() throws IOException {
		ArrayNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", uriOf(TEST_F))
						.put("foo", "foo"))
				.add(mapper.createObjectNode()
						.put("eClass", uriOf(TEST_F))
						.put("bar", "bar"));

		resourceSet.createResource(URI.createURI("test.json"));

		TestF[] result = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, TEST_F)
				.forType(TestF[].class)
				.readValue(data);

		assertThat(result).hasSize(2);
		assertThat(result[0].getOtherValue()).isEqualTo("foo");
		assertThat(result[1].getOtherValue()).isEqualTo("bar");
	}

	@Test
	public void testSave_WithAlias() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", uriOf(TEST_F))
				.put("v", "foo");

		resourceSet.createResource(URI.createURI("test.json"));

		TestF test = AnnotationsFactory.eINSTANCE.createTestF();
		test.setValue("foo");

		assertThat((JsonNode) mapper.valueToTree(test))
				.isEqualTo(expected);
	}

	@Test
	public void testSave_Tree() {
		JsonNode expected = ((ObjectNode) mapper.createObjectNode()
				.put("@type", uriOf(TEST_A))
				.set("childOfTypeC", mapper.createObjectNode()
						.put("value", 1)
						.set("manyValues", mapper.createArrayNode()
								.add(mapper.createObjectNode()
										.put("value", 2))
								.add(mapper.createObjectNode()
										.put("@bar", uriOf(TEST_D))
										.put("value", 3))
								.add(mapper.createObjectNode()
										.put("@foo", uriOf(TEST_E))
										.put("value", 4))
						)))
				.set("childrenOfTypeD", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("name", "bar"))
						.add(mapper.createObjectNode()
								.put("@foo", uriOf(TEST_E))
								.put("name", "foo")));

		TestA a1 = AnnotationsFactory.eINSTANCE.createTestA();

		TestC c1 = AnnotationsFactory.eINSTANCE.createTestC();
		c1.setValue(1);

		TestC c2 = AnnotationsFactory.eINSTANCE.createTestC();
		c2.setValue(2);

		TestD d11 = AnnotationsFactory.eINSTANCE.createTestD();
		d11.setValue(3);

		TestE e12 = AnnotationsFactory.eINSTANCE.createTestE();
		e12.setValue(4);

		c1.getManyValues().add(c2);
		c1.getManyValues().add(d11);
		c1.getManyValues().add(e12);

		TestD d1 = AnnotationsFactory.eINSTANCE.createTestD();
		d1.setName("bar");
		TestE e1 = AnnotationsFactory.eINSTANCE.createTestE();
		e1.setName("foo");

		a1.setChildOfTypeC(c1);
		a1.getChildrenOfTypeD().add(d1);
		a1.getChildrenOfTypeD().add(e1);

		assertThat((JsonNode) mapper.valueToTree(a1))
				.isEqualTo(expected);
	}

	@Test
	public void testLoad_Tree() throws IOException {
		JsonNode data = ((ObjectNode) mapper.createObjectNode()
				.put("@type", uriOf(TEST_A))
				.set("childOfTypeC", mapper.createObjectNode()
						.put("value", 1)
						.set("manyValues", mapper.createArrayNode()
								.add(mapper.createObjectNode()
										.put("value", 2))
								.add(mapper.createObjectNode()
										.put("@bar", uriOf(TEST_D))
										.put("value", 3))
								.add(mapper.createObjectNode()
										.put("@foo", uriOf(TEST_E))
										.put("value", 4))
						)))
				.set("childrenOfTypeD", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("name", "bar"))
						.add(mapper.createObjectNode()
								.put("@foo", uriOf(TEST_E))
								.put("name", "foo")));

		TestA a1 = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, TEST_A)
				.forType(TestA.class)
				.readValue(data);

		assertThat(a1).isNotNull();

		assertThat(a1.getChildOfTypeC()).isNotNull();
		assertThat(a1.getChildOfTypeC()).isInstanceOf(TestC.class);
		assertThat(a1.getChildrenOfTypeD()).hasSize(2);

		assertThat(a1.getChildrenOfTypeD()).hasAtLeastOneElementOfType(TestD.class);
		assertThat(a1.getChildrenOfTypeD()).hasAtLeastOneElementOfType(TestE.class);

		TestC c1 = a1.getChildOfTypeC();
		assertThat(c1.getValue()).isEqualTo(1);
		assertThat(c1.getManyValues()).hasSize(3);
		assertThat(c1.getManyValues()).hasAtLeastOneElementOfType(TestC.class);
		assertThat(c1.getManyValues()).hasAtLeastOneElementOfType(TestD.class);
		assertThat(c1.getManyValues()).hasAtLeastOneElementOfType(TestE.class);
	}

	@Test
	public void testReadClassByName() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("@type", TEST_TYPE_NAME.getName())
				.put("value", "foo");

		TestTypeName value = mapper
				.reader()
				.withAttribute(ROOT_ELEMENT, TEST_TYPE_NAME)
				.treeToValue(data, TestTypeName.class);

		assertThat(value).isNotNull();
		assertThat(value.getValue()).isEqualTo("foo");
	}

	@Test
	public void testReadClassByNameAgain() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", uriOf(CONTAINER))
				.set("typedByNames", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("@type", FOO_TYPE_NAME.getName())
								.put("value", "foo")
						)
						.add(mapper.createObjectNode()
								.put("@type", BAR_TYPE_NAME.getName())
								.put("value", "bar")
						)
						.add(mapper.createObjectNode()
								.put("@type", TEST_TYPE_NAME.getName())
								.put("value", "bar")
						));

		Resource value = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertThat(value).isNotNull();
		Container container = (Container) value.getContents().get(0);

		assertThat(container.getTypedByNames()).hasSize(3);
		assertThat(container.getTypedByNames().get(0))
				.isExactlyInstanceOf(FooTypeNameImpl.class);
		assertThat(container.getTypedByNames().get(1))
				.isExactlyInstanceOf(BarTypeNameImpl.class);
		assertThat(container.getTypedByNames().get(2))
				.isExactlyInstanceOf(TestTypeNameImpl.class);
	}

	@Test
	public void testReadClassByQualifiedClassName() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", uriOf(CONTAINER))
				.set("typedByClasses", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("_type", FOO_TYPE_CLASS.getInstanceClassName())
								.put("value", "foo")
						)
						.add(mapper.createObjectNode()
								.put("_type", BAR_TYPE_CLASS.getInstanceClassName())
								.put("value", "bar")
						)
						.add(mapper.createObjectNode()
								.put("_type", TEST_TYPE_CLASS.getInstanceClassName())
								.put("value", "bar")
						));

		Resource value = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertThat(value).isNotNull();
		Container container = (Container) value.getContents().get(0);

		assertThat(container.getTypedByClasses()).hasSize(3);
		assertThat(container.getTypedByClasses().get(0))
				.isExactlyInstanceOf(FooTypeClassImpl.class);
		assertThat(container.getTypedByClasses().get(1))
				.isExactlyInstanceOf(BarTypeClassImpl.class);
		assertThat(container.getTypedByClasses().get(2))
				.isExactlyInstanceOf(TestTypeClassImpl.class);
	}

	@Test
	public void testLoadFromType() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("@type", TEST_TYPE_NAME.getName())
				.put("value", "bar");

		TestTypeName value = mapper.readValue(data.toString(), TestTypeName.class);

		assertThat(value).isNotNull();
	}

	@Test
	public void testLoadFromListType() throws IOException {
		JsonNode data = mapper.createArrayNode().add(
				mapper.createObjectNode()
						.put("@type", TEST_TYPE_NAME.getName())
						.put("value", "foo"))
				.add(mapper.createObjectNode()
						.put("@type", TEST_TYPE_NAME.getName())
						.put("value", "bar"));

		List<TestTypeName> values = mapper.readValue(data.toString(), new TypeReference<List<TestTypeName>>() {
		});
		assertThat(values).isNotEmpty();
	}
}
