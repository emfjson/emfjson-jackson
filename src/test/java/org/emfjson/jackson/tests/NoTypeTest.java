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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.emfjson.jackson.databind.EMFContext.Attributes.ROOT_ELEMENT;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NoTypeTest {

	private ObjectMapper mapper;
	private ResourceSetImpl resourceSet;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		resourceSet = new ResourceSetImpl();

		EMFModule module = new EMFModule();
		module.configure(OPTION_SERIALIZE_TYPE, false);
		mapper.registerModule(module);

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));
	}

	@Test
	public void testSaveSingleObjectWithNoType() {
		JsonNode expected = mapper.createObjectNode()
				.put("userId", "1")
				.put("name", "Paul");

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("Paul");

		JsonNode result = mapper.valueToTree(u1);

		assertEquals(expected, result);
	}

	@Test
	public void testSaveTwoRootObjectsWithNoType() {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("userId", "1")
						.put("name", "Paul"))
				.add(mapper.createObjectNode()
						.put("userId", "2")
						.put("name", "Anna")
						.put("sex", "FEMALE"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("Paul");

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setUserId("2");
		u2.setName("Anna");
		u2.setSex(Sex.FEMALE);

		Resource resource = new JsonResource(URI.createURI("test"), mapper);
		resource.getContents().add(u1);
		resource.getContents().add(u2);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

	@Test
	public void testLoadSingleObjectWithNoType() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("userId", "1")
				.put("name", "Paul");

		User result = mapper
				.reader()
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, User.class);

		assertNotNull(result);

		assertEquals("1", result.getUserId());
		assertEquals("Paul", result.getName());
		assertEquals("MALE", result.getSex().getLiteral());
	}

	@Test
	public void testLoadTwoRootObjectsWithNoType() throws JsonProcessingException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("userId", "1")
						.put("name", "Paul")
						.put("sex", "MALE"))
				.add(mapper.createObjectNode()
						.put("userId", "2")
						.put("name", "Anna")
						.put("sex", "FEMALE"));

		Resource result = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, Resource.class);

		assertNotNull(result);
		assertEquals(2, result.getContents().size());

		User first = (User) result.getContents().get(0);
		User second = (User) result.getContents().get(1);

		assertEquals("1", first.getUserId());
		assertEquals("Paul", first.getName());
		assertEquals("MALE", first.getSex().getLiteral());

		assertEquals("2", second.getUserId());
		assertEquals("Anna", second.getName());
		assertEquals("FEMALE", second.getSex().getLiteral());
	}

	@Test
	public void testSaveSingleObjectWithNoTypeAndOneContainment() {
		JsonNode expected = mapper.createObjectNode()
				.put("userId", "1")
				.put("name", "Paul")
				.set("address", mapper.createObjectNode()
						.put("addId", "a1")
						.put("city", "Prague"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("Paul");

		Address add = ModelFactory.eINSTANCE.createAddress();
		add.setAddId("a1");
		add.setCity("Prague");

		u1.setAddress(add);

		JsonNode result = mapper.valueToTree(u1);

		assertEquals(expected, result);
	}

	@Test
	public void testLoadSingleObjectWithNoTypeAndOneContainment() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("userId", "1")
				.put("name", "Paul")
				.set("address", mapper.createObjectNode()
						.put("addId", "a1")
						.put("city", "Prague"));

		User result = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, User.class);

		assertNotNull(result);

		assertEquals("1", result.getUserId());
		assertEquals("Paul", result.getName());
		assertEquals("MALE", result.getSex().getLiteral());

		assertNotNull(result.getAddress());
	}

}
