package org.emfjson.jackson.tests.annotations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.junit.annotations.*;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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

		assertThat(mapper.valueToTree(a))
				.isEqualTo(expected);
	}

	@Test
	public void testLoad_WithCustomTypeInfo() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("@type", "http://www.emfjson.org/jackson/annotations#//TestA")
				.put("my_value", "a1")
				.set("childOfTypeC", mapper.createObjectNode());

		Resource resource = resourceSet.createResource(URI.createURI("test.json"));

		TestA a = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
//				.withAttribute(EMFContext.Attributes.RESOURCE, resource)
				.withAttribute(ROOT_ELEMENT, TEST_A)
				.forType(TestA.class)
				.readValue(data);

		assertThat(a).isNotNull();
//		assertThat(a.eResource()).isSameAs(resource);
		assertThat(a.getChildOfTypeC()).isNotNull();
	}

	@Test
	public void testSave_Tree() throws IOException {
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

		assertThat(mapper.valueToTree(a1))
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
}
