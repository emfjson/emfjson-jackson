package org.emfjson.jackson.junit.tests.annotations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.emfjson.jackson.junit.annotations.AnnotationsFactory;
import org.emfjson.jackson.junit.annotations.TestA;
import org.emfjson.jackson.module.EMFModule;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPropertyTest {

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());
	}

	@Test
	public void test() {
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
		TestA a1 = AnnotationsFactory.eINSTANCE.createTestA();

		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/annotations#//TestA")
				.put("hello", "Hello");

		assertThat(mapper.valueToTree(a1))
				.isEqualTo(expected);
	}
}
