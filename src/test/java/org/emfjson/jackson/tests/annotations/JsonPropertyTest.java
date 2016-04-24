package org.emfjson.jackson.tests.annotations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.annotations.AnnotationsFactory;
import org.emfjson.jackson.junit.annotations.TestA;
import org.emfjson.jackson.junit.annotations.TestB;
import org.emfjson.jackson.module.EMFModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPropertyTest {

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE
				.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	@Test
	public void testAttributeAnnotation_WithValue() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/annotations#//TestA")
				.put("my_value", "Hello");

		TestA a1 = AnnotationsFactory.eINSTANCE.createTestA();
		a1.setValue("Hello");

		assertThat(mapper.valueToTree(a1))
				.isEqualTo(expected);
	}

	@Test
	public void testMethodAnnotation() {
		TestB b1 = AnnotationsFactory.eINSTANCE.createTestB();

		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/annotations#//TestB")
				.put("hello", "Hello");

		assertThat(mapper.valueToTree(b1))
				.isEqualTo(expected);
	}

}
