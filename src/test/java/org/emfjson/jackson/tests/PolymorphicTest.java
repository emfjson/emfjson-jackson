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
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.emfjson.jackson.databind.EMFContext.Attributes.ROOT_ELEMENT;
import static org.junit.Assert.*;

public class PolymorphicTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveTwoObjectsWithTypeInformation() throws IOException {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//Container")
				.set("elements", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.emfjson.org/jackson/model#//ConcreteTypeOne")
								.put("name", "First"))
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.emfjson.org/jackson/model#//ConcreteTypeTwo")
								.put("name", "Two")));

		Resource resource = resourceSet.createResource(URI.createURI("types.json"));

		Container c = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		one.setName("First");
		ConcreteTypeTwo two = ModelFactory.eINSTANCE.createConcreteTypeTwo();
		two.setName("Two");
		c.getElements().add(one);
		c.getElements().add(two);
		resource.getContents().add(c);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadTwoObjectsWithTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("src/test/resources/tests/test-load-types.json"));
		Map<Object, Object> options = new HashMap<>();
		// TODO
		options.put(ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
		resource.load(options);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);

		Container container = (Container) root;

		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);

		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);

		assertEquals("First", first.getName());
		assertEquals("one", ((ConcreteTypeOne) first).getPropTypeOne());
		assertEquals("Two", second.getName());
		assertEquals("two", ((ConcreteTypeTwo) second).getPropTypeTwo());
	}

	@Test
	public void testLoadTwoObjectsWithReferenceAndTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("src/test/resources/tests/test-load-types-2.json"));
		Map<Object, Object> options = new HashMap<>();
		// TODO
		options.put(ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());

		resource.load(options);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);

		Container container = (Container) root;

		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);

		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);
		assertEquals(1, first.getRefProperty().size());

		AbstractType ref = first.getRefProperty().get(0);
		assertSame(second, ref);
	}

}