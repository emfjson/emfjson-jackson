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

import com.fasterxml.jackson.databind.JsonNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.EMFJs;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class PolymorphicTest extends TestSupport {

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
		Resource resource = resourceSet.createResource(uri("test-load-types.json"));
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
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
		Resource resource = resourceSet.createResource(uri("test-load-types-2.json"));
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
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

	@Test
	public void testContainmentWithHierarchyOfTypes() {
		Resource resource = resourceSet.getResource(uri("test-types-dynamic-1.json"), true);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);

		assertEquals("A", root.eClass().getName());

		EClass a = root.eClass();
		assertTrue(root.eIsSet(a.getEStructuralFeature("containB")));
		assertTrue(root.eIsSet(a.getEStructuralFeature("containBs")));

		EObject root_c1 = (EObject) root.eGet(a.getEStructuralFeature("containB"));
		List<EObject> root_c2 = (List<EObject>) root.eGet(a.getEStructuralFeature("containBs"));

		assertEquals("C", root_c1.eClass().getName());
		assertEquals(2, root_c2.size());

		assertEquals("C", root_c2.get(0).eClass().getName());

		EObject c2 = root_c2.get(0);
		assertEquals("Hello", c2.eGet(c2.eClass().getEStructuralFeature("stringValue")));

		assertEquals("D", root_c2.get(1).eClass().getName());
	}
}