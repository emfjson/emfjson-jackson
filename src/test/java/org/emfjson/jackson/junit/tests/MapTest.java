package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.model.ETypes;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.Type;
import org.emfjson.jackson.junit.model.Value;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

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

}
