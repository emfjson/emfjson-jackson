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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.model.impl.PrimaryObjectImpl;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.emfjson.jackson.databind.EMFContext.Attributes.ROOT_ELEMENT;
import static org.junit.Assert.*;

public class ReferenceTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("userId", "1")
						.put("name", "John")
						.set("uniqueFriend", mapper.createObjectNode()
								.put("eClass", "http://www.emfjson.org/jackson/model#//User")
								.put("$ref", "2")
						))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("userId", "2")
						.put("name", "Mary")
						.put("sex", "FEMALE"));

		Resource resource = resourceSet.createResource(URI.createURI("test"));

		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Mary");
		user2.setSex(Sex.FEMALE);

		user1.setUniqueFriend(user2);

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testSaveObjectWithManyReferences() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("test"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("Paul");
		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setUserId("2");
		u2.setName("Pierre");
		User u3 = ModelFactory.eINSTANCE.createUser();
		u3.setUserId("3");
		u3.setName("Victor");

		u1.getFriends().add(u2);
		u1.getFriends().add(u3);

		resource.getContents().add(u1);
		resource.getContents().add(u2);
		resource.getContents().add(u3);

		assertThat((JsonNode) mapper.valueToTree(resource))
				.isEqualTo(mapper.readTree(Paths.get("src/test/resources/tests/test-load-2.json").toFile()));
	}

	@Test
	public void testLoadTwoObjectsWithAttributesOneReference() throws IOException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("userId", "1")
						.put("name", "John")
						.put("sex", "MALE")
						.set("uniqueFriend", mapper.createObjectNode()
								.put("$ref", "2")
						))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("userId", "2")
						.put("name", "Mary")
						.put("sex", "FEMALE"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(2, resource.getContents().size());

		User first = (User) resource.getContents().get(0);
		User second = (User) resource.getContents().get(1);

		assertSame(second, first.getUniqueFriend());
	}

	@Test
	public void testLoadWithExternalReferenceFromFile() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("userId", "2")
				.set("uniqueFriend", mapper.createObjectNode()
						.put("$ref", "http://eclipselabs.org/emfjson/tests/test-load-1.json#1"));

		Resource resource = resourceSet.createResource(URI.createURI("http://resources/second"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertFalse(resource.getContents().isEmpty());

		User u2 = (User) resource.getContents().get(0);

		assertNotNull(u2.getUniqueFriend());
		assertFalse(u2.getUniqueFriend().eIsProxy());
	}

	@Test
	public void testLoadWithExternalReference() throws IOException {
		JsonNode firstResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("userId", "1");

		JsonNode secondResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("userId", "2")
				.set("uniqueFriend", mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("$ref", "http://resources/first#1"));

		Resource first = resourceSet.createResource(URI.createURI("http://resources/first"));
		Resource second = resourceSet.createResource(URI.createURI("http://resources/second"));

		first.load(new ByteArrayInputStream(mapper.writeValueAsBytes(firstResource)), null);
		second.load(new ByteArrayInputStream(mapper.writeValueAsBytes(secondResource)), null);

		assertFalse(first.getContents().isEmpty());
		assertFalse(second.getContents().isEmpty());

		User u1 = (User) first.getContents().get(0);
		User u2 = (User) second.getContents().get(0);

		assertSame(u1, u2.getUniqueFriend());
	}

	@Test
	public void testLoadThreeObjectsTwoReferences() throws IOException {
		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.forType(Resource.class)
				.readValue(Paths.get("src/test/resources/tests/test-load-2.json").toFile());

		assertFalse(resource.getContents().isEmpty());
		assertEquals(3, resource.getContents().size());

		EObject obj1 = resource.getContents().get(0);
		assertTrue(obj1 instanceof User);
		assertEquals("1", ((User) obj1).getUserId());

		EObject obj2 = resource.getContents().get(1);
		assertTrue(obj2 instanceof User);
		assertEquals("2", ((User) obj2).getUserId());

		EObject obj3 = resource.getContents().get(2);
		assertTrue(obj3 instanceof User);
		assertEquals("3", ((User) obj3).getUserId());

		assertFalse(((User) obj1).getFriends().isEmpty());
		assertEquals(2, ((User) obj1).getFriends().size());

		User friend1 = ((User) obj1).getFriends().get(0);
		assertNotNull(friend1);

		User friend2 = ((User) obj1).getFriends().get(1);
		assertNotNull(friend2);

		assertFalse(friend1.eIsProxy());
		assertFalse(friend2.eIsProxy());

		assertEquals(obj2, friend1);
		assertEquals(obj3, friend2);
	}

//	@Test
//	public void testSaveReferenceAsValue() {
//		ObjectMapper mapper = fixture.mapper(OPTION_SERIALIZE_REF_AS_VALUE, true);
//
//		JsonNode expected = mapper.createArrayNode()
//				.add(mapper.createObjectNode()
//						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
//						.put("userId", "1")
//						.put("name", "John")
//						.put("uniqueFriend", "2"))
//				.add(mapper.createObjectNode()
//						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
//						.put("userId", "2")
//						.put("name", "Mary")
//						.put("sex", "FEMALE"));
//
//		User user1 = ModelFactory.eINSTANCE.createUser();
//		user1.setUserId("1");
//		user1.setName("John");
//
//		User user2 = ModelFactory.eINSTANCE.createUser();
//		user2.setUserId("2");
//		user2.setName("Mary");
//		user2.setSex(Sex.FEMALE);
//
//		user1.setUniqueFriend(user2);
//
//		Resource resource = resourceSet.createResource(URI.createURI("test"));
//		resource.getContents().add(user1);
//		resource.getContents().add(user2);
//
//		assertEquals(expected, mapper.valueToTree(resource));
//	}
//
//	@Test
//	public void testLoadReferenceAsValue() throws JsonProcessingException {
//		ObjectMapper mapper = fixture.mapper(OPTION_SERIALIZE_REF_AS_VALUE, true);
//
//		JsonNode data = mapper.createArrayNode()
//				.add(mapper.createObjectNode()
//						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
//						.put("userId", "1")
//						.put("name", "John")
//						.put("sex", "MALE")
//						.put("uniqueFriend", "2"))
//				.add(mapper.createObjectNode()
//						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
//						.put("userId", "2")
//						.put("name", "Mary")
//						.put("sex", "FEMALE"));
//
//		Resource resource = mapper
//				.reader()
//				.withAttribute(RESOURCE_SET, resourceSet)
//				.treeToValue(data, Resource.class);
//
//		assertEquals(2, resource.getContents().size());
//
//		User first = (User) resource.getContents().get(0);
//		User second = (User) resource.getContents().get(1);
//
//		assertSame(second, first.getUniqueFriend());
//	}

	@Test
	public void testLoadShouldNotResolveProxiesIfIsNonResolve() throws IOException {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-non-resolve-1.json"), true);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof PrimaryObject);

		PrimaryObjectImpl source = (PrimaryObjectImpl) resource.getContents().get(0);
		assertTrue(source.eIsSet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_REFERENCE));
		assertTrue(source.basicGetSingleReference().eIsProxy());
		assertFalse(source.getSingleReference().eIsProxy());

		assertEquals("Foo", source.getSingleReference().getSingleAttribute());

		assertTrue(source.eIsSet(ModelPackage.Literals.PRIMARY_OBJECT__MANY_REFERENCES));
		assertEquals(1, source.getManyReferences().size());
	}

	@Test
	public void testLoadObjectWithDeepHierarchy() throws IOException {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-load-3.json"), true);

		assertThat(resource.getContents())
				.hasSize(1)
				.hasOnlyElementsOfType(PrimaryObject.class);

		PrimaryObject p1 = (PrimaryObject) resource.getContents().get(0);
		assertThat(p1.getName())
				.isEqualTo("p1");

		// p1
		assertThat(p1.getMultipleContainmentReferenceNoProxies())
				.hasSize(2);
		assertThat(p1.getMultipleContainmentReferenceNoProxies().get(0).getSingleAttribute())
				.isEqualTo("t1");
		assertThat(p1.getMultipleContainmentReferenceNoProxies().get(1).getSingleAttribute())
				.isEqualTo("t2");
		assertThat(p1.getContainmentReferenceSameCollection())
				.isNotNull();

		// p2
		PrimaryObject p2 = p1.getContainmentReferenceSameCollection();

		assertThat(p2.getMultipleContainmentReferenceNoProxies())
				.hasSize(2);
		assertThat(p2.getMultipleContainmentReferenceNoProxies().get(0).getSingleAttribute())
				.isEqualTo("t3");
		assertThat(p2.getMultipleContainmentReferenceNoProxies().get(1).getSingleAttribute())
				.isEqualTo("t4");

		// p3
		PrimaryObject p3 = p2.getContainmentReferenceSameCollection();

		assertThat(p3.getMultipleContainmentReferenceNoProxies())
				.hasSize(2);
		assertThat(p3.getMultipleContainmentReferenceNoProxies().get(0).getSingleAttribute())
				.isEqualTo("t5");
		assertThat(p3.getMultipleContainmentReferenceNoProxies().get(1).getSingleAttribute())
				.isEqualTo("t6");
	}

	@Test
	public void testLoadArrayInsteadOfObject() throws IOException {
		final Resource resource = resourceSet.getResource(
			URI.createURI("src/test/resources/tests/array-instead-of-object.json"), true);

		assertThat(resource.getContents())
			.hasSize(1)
			.hasOnlyElementsOfType(User.class);
	}
}