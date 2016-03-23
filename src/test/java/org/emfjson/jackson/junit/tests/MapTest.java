package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class MapTest extends TestSupport {

	@Test
	public void testSaveMap() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("test"));

		ETypes types = ModelFactory.eINSTANCE.createETypes();
		{
			Type t = ModelFactory.eINSTANCE.createType();
			t.setName("t1");
			Value v = ModelFactory.eINSTANCE.createValue();
			v.setValue(1);
			types.getValues().put(t, v);
		}
		resource.getContents().add(types);

		JsonNode actual = mapper.valueToTree(resource);

		assertThat(actual.get("values"))
				.hasSize(1)
				.contains(
						((ObjectNode) mapper.createObjectNode()
								.set("key", mapper.createObjectNode()
										.put("eClass", "http://www.emfjson.org/jackson/model#//Type")
										.put("name", "t1"))
						).set("value", mapper.createObjectNode()
								.put("eClass", "http://www.emfjson.org/jackson/model#//Value")
								.put("value", 1)));
	}

	@Test
	public void testLoadMap() {
		Resource resource = resourceSet.getResource(uri("test-map-1.json"), true);

		assertThat(resource.getContents()).hasSize(1);
		assertThat(resource.getContents().get(0)).isInstanceOf(ETypes.class);

		ETypes types = (ETypes) resource.getContents().get(0);

		assertThat(types.getValues()).hasSize(2);
	}

	@Test
	public void testSaveMapWithStringKey() {
		Resource resource = resourceSet.createResource(URI.createURI("test"));

		ETypes types = ModelFactory.eINSTANCE.createETypes();
		Value value = ModelFactory.eINSTANCE.createValue();
		value.setValue(12);

		types.getStringMapValues()
				.put("Hello", value);
		resource.getContents().add(types);

		JsonNode actual = mapper.valueToTree(resource);

		assertThat(actual.get("stringMapValues"))
				.isEqualTo(
						mapper.createObjectNode()
								.set("Hello", mapper.createObjectNode()
										.put("eClass", "http://www.emfjson.org/jackson/model#//Value")
										.put("value", 12)));
	}

	@Test
	public void testLoadMapWithStringKey() {
		Resource resource = resourceSet.getResource(uri("test-map-2.json"), true);

		assertThat(resource.getContents()).hasSize(1);
		assertThat(resource.getContents().get(0)).isInstanceOf(ETypes.class);

		ETypes types = (ETypes) resource.getContents().get(0);

		assertThat(types.getStringMapValues()).hasSize(2);

		EMap<String, Value> mapValues = types.getStringMapValues();

		assertThat(mapValues.get("Hello").getValue()).isEqualTo(1);
		assertThat(mapValues.get("World").getValue()).isEqualTo(2);
	}

	@Test
	public void testSaveMapWithRefs() throws IOException {
		JsonNode expected = mapper.readTree(
				Paths.get("src/test/resources/tests/test-map-with-refs.json").toFile());

		Resource resource = resourceSet.createResource(URI.createURI("test"));

		ETypes types = ModelFactory.eINSTANCE.createETypes();

		PrimaryObject p1 = ModelFactory.eINSTANCE.createPrimaryObject();
		p1.setName("p1");

		TargetObject t1 = ModelFactory.eINSTANCE.createTargetObject();
		t1.setSingleAttribute("t1");

		types.getValuesWithRef().put(p1, t1);

		resource.getContents().add(types);
		resource.getContents().add(p1);
		resource.getContents().add(t1);

		assertThat(mapper.valueToTree(resource)).
				isEqualTo(expected);
	}

	@Test
	public void testLoadMapWithRefs() throws IOException {
		Resource resource = resourceSet.getResource(uri("test-map-with-refs.json"), true);

		assertThat(resource.getContents()).hasSize(3);
		assertThat(resource.getContents().get(0)).isInstanceOf(ETypes.class);
		assertThat(resource.getContents().get(1)).isInstanceOf(PrimaryObject.class);
		assertThat(resource.getContents().get(2)).isInstanceOf(TargetObject.class);

		ETypes types = (ETypes) resource.getContents().get(0);
		PrimaryObject p1 = (PrimaryObject) resource.getContents().get(1);
		TargetObject t1 = (TargetObject) resource.getContents().get(2);

		assertThat(types.getValuesWithRef())
				.hasSize(1);

		assertThat(types.getValuesWithRef().map())
				.containsExactly(entry(p1, t1));
	}
}
