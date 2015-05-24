/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson.junit.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import org.emfjson.EMFJs;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.UuidSupport;
import org.emfjson.jackson.module.EMFModule;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UuidLoadTest extends UuidSupport {

	private final Map<String, Object> options = new HashMap<>();
	private final ObjectMapper mapper = new ObjectMapper();
	{
		options.put(EMFJs.OPTION_USE_ID, true);
	}

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		mapper.registerModule(new EMFModule(new ResourceSetImpl(), JacksonOptions.from(options)));
	}

	@Test
	public void testUuidBehavior() throws IOException {
		Resource in = createUuidResource("in");
		Container root = ModelFactory.eINSTANCE.createContainer();
		in.getContents().add(root);

		Resource out = createUuidResource("out");
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
		Resource result = mapper.treeToValue(node, Resource.class);
		EObject eObject = result.getContents().get(0);

		assertEquals(uuid(root), uuid(eObject));
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
		Resource result = mapper.treeToValue(node, Resource.class);

		EObject eObject = result.getContents().get(0);
		assertNotNull(result);
		assertEquals(uuid(root), uuid(eObject));
		assertEquals(ModelPackage.Literals.CONTAINER, eObject.eClass());

		Container resultContainer = (Container) eObject;
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