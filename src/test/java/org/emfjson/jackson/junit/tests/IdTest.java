package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.junit.support.TestSupport;
import org.emfjson.jackson.resource.JsonResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IdTest extends TestSupport {

	final JacksonOptions options = new JacksonOptions.Builder()
			.withID(true)
			.build();

	@Test
	public void testWriteId() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("_id", "1")
				.put("name", "Joe");

		JsonResource resource = new JsonResource();
		User user = ModelFactory.eINSTANCE.createUser();
		user.setName("Joe");
		resource.setID(user, "1");
		resource.getContents().add(user);

		assertEquals(expected, mapper(options).valueToTree(resource));
	}

	@Test
	public void testReadId() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("_id", "1")
				.put("name", "Joe");

		JsonResource resource = (JsonResource) mapper(options).treeToValue(data, Resource.class);
		User user = (User) resource.getContents().get(0);

		assertEquals("1", resource.getID(user));
	}

	@Test
	public void testReadId_WhenIdBeforeTypeField() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("_id", "1")
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("name", "Joe");

		JsonResource resource = (JsonResource) mapper(options).treeToValue(data, Resource.class);
		User user = (User) resource.getContents().get(0);

		assertEquals("1", resource.getID(user));
	}

}
