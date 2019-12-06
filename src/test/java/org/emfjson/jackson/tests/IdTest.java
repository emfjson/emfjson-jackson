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

package org.emfjson.jackson.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_USE_ID;
import static org.junit.Assert.assertEquals;

public class IdTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testWriteId() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("@id", "1")
				.put("name", "Joe");

		JsonResource resource = new JsonResource(URI.createURI("test"), mapper);
		User user = ModelFactory.eINSTANCE.createUser();
		user.setName("Joe");
		resource.setID(user, "1");
		resource.getContents().add(user);

		Assert.assertEquals(expected,
				fixture.mapper(OPTION_USE_ID, true)
						.valueToTree(resource));
	}

	@Test
	public void testReadId() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("@id", "1")
				.put("name", "Joe");

		JsonResource resource = fixture.mapper(OPTION_USE_ID, true)
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, JsonResource.class);

		User user = (User) resource.getContents().get(0);

		assertEquals("1", resource.getID(user));
	}

	@Test
	public void testReadId_WhenIdBeforeTypeField() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("@id", "1")
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("name", "Joe");

		JsonResource resource = fixture.mapper(OPTION_USE_ID, true)
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, JsonResource.class);

		User user = (User) resource.getContents().get(0);

		assertEquals("1", resource.getID(user));
	}

}
