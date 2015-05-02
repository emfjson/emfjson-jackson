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
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.emfjson.*;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.*;
import org.emfjson.jackson.module.*;
import org.junit.*;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class UuidLoadTest extends UuidSupport {
	
	private final Map<String, Object> options = new HashMap<>();
	private final ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		mapper.registerModule(new EMFModule(options));
	}

	@Test
	public void testUuidBehavior() throws IOException {
		Resource in = createUuidResource("in.xmi");
		Container root = ModelFactory.eINSTANCE.createContainer();
		in.getContents().add(root);

		Resource out = createUuidResource("out.xmi");
		out.load(new ByteArrayInputStream(mapper.writeValueAsBytes(in)), options);

		assertEquals(1, out.getContents().size());

		EObject output = out.getContents().get(0);

		assertEquals(uuid(root), uuid(output));
	}

	@Test
	public void testDeserializeOneObject() throws IOException {
		Resource resource = createUuidResource("test.xmi");
		Container root = ModelFactory.eINSTANCE.createContainer();
		resource.getContents().add(root);

		JsonNode node = mapper.valueToTree(root);
		EObject result = mapper.readValue(mapper.writeValueAsString(node), EObject.class);

		assertNotNull(result);
		assertEquals(uuid(root), uuid(result));
	}

	@Test
	public void testDeserializeOneObjectWithTwoChildHavingOneReference() throws IOException {
		Resource resource = createUuidResource("test.xmi");
		Container root = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		one.setName("one");
		ConcreteTypeOne two = ModelFactory.eINSTANCE.createConcreteTypeOne();
		two.setName("two");

		one.getRefProperty().add(two);
		root.getElements().add(one);
		root.getElements().add(two);
		resource.getContents().add(root);

		JsonNode node = mapper.valueToTree(root);
		EObject result = mapper.readValue(mapper.writeValueAsString(node), EObject.class);

		assertNotNull(result);
		assertEquals(uuid(root), uuid(result));
		assertEquals(ModelPackage.Literals.CONTAINER, result.eClass());

		Container resultContainer = (Container) result;
		assertEquals(2, resultContainer.getElements().size());

		AbstractType firstResult = resultContainer.getElements().get(0);
		AbstractType secondResult = resultContainer.getElements().get(1);

		assertEquals("one", firstResult.getName());
		assertEquals(uuid(one), uuid(firstResult));
		assertEquals("two", secondResult.getName());
		assertEquals(uuid(two), uuid(secondResult));

		assertEquals(1, firstResult.getRefProperty().size());
		assertEquals(uuid(secondResult), uuid(firstResult.getRefProperty().get(0)));
		assertEquals(secondResult, firstResult.getRefProperty().get(0));
	}

}