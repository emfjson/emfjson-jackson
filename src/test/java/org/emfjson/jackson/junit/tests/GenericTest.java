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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.EMFJs;
import org.emfjson.jackson.junit.model.GenericContainer;
import org.emfjson.jackson.junit.model.GenericType;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.SpecialTypeOne;
import org.emfjson.jackson.junit.model.SpecialTypeTwo;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class GenericTest extends TestSupport {

	@Test
	public void testSaveTwoObjectsWithTypeInformation() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.emfjson.org/jackson/model#//GenericContainer")
			.set("values", mapper.createArrayNode()
				.add(mapper.createObjectNode()
					.put("eClass", "http://www.emfjson.org/jackson/model#//SpecialTypeOne")
					.put("value", "String"))
				.add(mapper.createObjectNode()
					.put("eClass", "http://www.emfjson.org/jackson/model#//SpecialTypeTwo")
					.put("value", true)));

		Resource resource = resourceSet.createResource(URI.createURI("types-generic.json"));

		GenericContainer gc = ModelFactory.eINSTANCE.createGenericContainer();
		SpecialTypeOne one = ModelFactory.eINSTANCE.createSpecialTypeOne();
		one.setValue("String");
		SpecialTypeTwo two = ModelFactory.eINSTANCE.createSpecialTypeTwo();
		two.setValue(true);
		gc.getValues().add(one);
		gc.getValues().add(two);
		resource.getContents().add(gc);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadTwoObjectsWithTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-load-types-generic.json"));
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getGenericContainer());
		resource.load(options);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof GenericContainer);

		GenericContainer container = (GenericContainer) root;

		assertEquals(2, container.getValues().size());
		GenericType<?> first = container.getValues().get(0);
		GenericType<?> second = container.getValues().get(1);

		assertTrue(first instanceof SpecialTypeOne);
		assertTrue(second instanceof SpecialTypeTwo);

		assertEquals("String", ((SpecialTypeOne) first).getValue());
		assertEquals(true, ((SpecialTypeTwo) second).getValue());
	}
}
