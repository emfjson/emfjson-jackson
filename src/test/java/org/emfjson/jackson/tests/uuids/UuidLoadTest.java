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
package org.emfjson.jackson.tests.uuids;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.module.EMFModule;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UuidLoadTest extends UuidSupport {

	private final ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_USE_ID, true);

		mapper.registerModule(module);
	}

	@Test
	public void testUuidBehavior() throws IOException {
		Resource in = createUuidResource("in", mapper);
		Container root = ModelFactory.eINSTANCE.createContainer();
		in.getContents().add(root);

		Resource out = createUuidResource("out", mapper);
		out.load(new ByteArrayInputStream(mapper.writeValueAsBytes(in)), null);

		assertEquals(1, out.getContents().size());

		EObject output = out.getContents().get(0);

		assertEquals(uuid(root), uuid(output));
	}

	@Test
	public void testDeserializeOneObject() throws IOException {
		Resource resource = createUuidResource("test.xmi", mapper);
		Container root = ModelFactory.eINSTANCE.createContainer();
		resource.getContents().add(root);

		JsonNode node = mapper.valueToTree(root);
		Resource result = mapper
				.reader()
				.withValueToUpdate(createUuidResource("test", mapper))
				.treeToValue(node, Resource.class);

		EObject eObject = result.getContents().get(0);

		assertEquals(uuid(root), uuid(eObject));
	}

	@Test
	public void testDeserializeOneObjectWithTwoChildHavingOneReference() throws IOException {
		Resource resource = createUuidResource("test.xmi", mapper);
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
		Resource result = mapper
				.reader()
				.withValueToUpdate(createUuidResource("test", mapper))
				.treeToValue(node, Resource.class);

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