/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.databind.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.emfjson.*;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class EnumTest extends TestSupport {

	@Test
	public void testEnums() throws IOException {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("sex", "MALE"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("sex", "FEMALE"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setSex(Sex.MALE);

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setSex(Sex.FEMALE);

		resource.getContents().add(u1);
		resource.getContents().add(u2);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadEnums() throws IOException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("name", "A")
						.put("sex", "MALE"))
				.add(mapper.createObjectNode()
						.put("name", "B")
						.put("sex", "FEMALE"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), options);

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
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject")
						.put("kind", "one"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject")
						.put("kind", "two"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject")
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

		assertEquals(expected, mapper.valueToTree(resource));
	}
	
	@Test
	public void testLoadEnumDifferentCases() throws IOException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject")
						.put("kind", "one"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject")
						.put("kind", "two"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject")
						.put("kind", "Three-is-Three"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), options);

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