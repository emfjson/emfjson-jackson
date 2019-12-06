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
import org.emfjson.jackson.support.StandardFixture;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_DEFAULT_VALUE;
import static org.junit.Assert.assertEquals;

public class EnumTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testEnums() throws IOException {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("sex", "FEMALE"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setSex(Sex.MALE);

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setSex(Sex.FEMALE);

		resource.getContents().add(u1);
		resource.getContents().add(u2);

		Assert.assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadEnums() throws IOException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("name", "A")
						.put("sex", "MALE"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("name", "B")
						.put("sex", "FEMALE"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(2, resource.getContents().size());

		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(1).eClass());

		User u1 = (User) resource.getContents().get(0);
		User u2 = (User) resource.getContents().get(1);

		assertEquals("A", u1.getName());
		assertEquals(Sex.MALE, u1.getSex());
		assertEquals("B", u2.getName());
		assertEquals(Sex.FEMALE, u2.getSex());
	}

	@Test
	public void testSaveEnumDifferentCases() throws IOException {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
						.put("unsettableAttributeWithNonNullDefault", "junit")
						.put("kind", "one"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
						.put("unsettableAttributeWithNonNullDefault", "junit")
						.put("kind", "two"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
						.put("unsettableAttributeWithNonNullDefault", "junit")
						.put("kind", "Three-is-Three"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		{
			PrimaryObject p = ModelFactory.eINSTANCE.createPrimaryObject();
			p.setKind(SomeKind.ONE);
			resource.getContents().add(p);
		}
		{
			PrimaryObject p = ModelFactory.eINSTANCE.createPrimaryObject();
			p.setKind(SomeKind.TWO);
			resource.getContents().add(p);
		}
		{
			PrimaryObject p = ModelFactory.eINSTANCE.createPrimaryObject();
			p.setKind(SomeKind.THREE);
			resource.getContents().add(p);
		}

		Assert.assertEquals(expected, fixture.mapper(OPTION_SERIALIZE_DEFAULT_VALUE, true)
				.valueToTree(resource));
	}

	@Test
	public void testLoadEnumDifferentCases() throws IOException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
						.put("kind", "one"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
						.put("kind", "two"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
						.put("kind", "Three-is-Three"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(3, resource.getContents().size());

		EObject one = resource.getContents().get(0);
		EObject two = resource.getContents().get(1);
		EObject three = resource.getContents().get(2);

		assertEquals(ModelPackage.Literals.PRIMARY_OBJECT, one.eClass());
		assertEquals(ModelPackage.Literals.PRIMARY_OBJECT, two.eClass());
		assertEquals(ModelPackage.Literals.PRIMARY_OBJECT, three.eClass());

		assertEquals(SomeKind.ONE, ((PrimaryObject) one).getKind());
		assertEquals(SomeKind.TWO, ((PrimaryObject) two).getKind());
		assertEquals(SomeKind.THREE, ((PrimaryObject) three).getKind());
	}

}