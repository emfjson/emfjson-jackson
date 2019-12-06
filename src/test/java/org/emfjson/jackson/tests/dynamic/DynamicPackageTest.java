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
package org.emfjson.jackson.tests.dynamic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.*;
import org.emfjson.jackson.module.EMFModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DynamicPackageTest {

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		mapper.registerModule(new EMFModule());
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
	}

	@Test
	public void testSavePackageWithTwoClasses() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EPackage")
				.put("name", "p")
				.put("nsURI", "http://foo.org/p")
				.set("eClassifiers", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
								.put("name", "A"))
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
								.put("name", "B")));

		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setNsURI("http://foo.org/p");
		p.setName("p");

		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A");
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B");

		p.getEClassifiers().add(a);
		p.getEClassifiers().add(b);

		assertEquals(expected, mapper.valueToTree(p));
	}

	@Test
	public void testLoadPackageWithTwoClasses() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EPackage")
				.put("name", "p")
				.put("nsURI", "http://foo.org/p")
				.set("eClassifiers", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
								.put("name", "A"))
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
								.put("name", "B")));

		EPackage p = (EPackage) mapper.treeToValue(data, EObject.class);
		assertNotNull(p);

		assertEquals("p", p.getName());
		assertEquals("http://foo.org/p", p.getNsURI());
		assertEquals(2, p.getEClassifiers().size());

		assertEquals("A", p.getEClassifiers().get(0).getName());
		assertEquals("B", p.getEClassifiers().get(1).getName());
	}

}
