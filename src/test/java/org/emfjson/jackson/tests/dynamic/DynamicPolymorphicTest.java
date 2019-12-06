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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.support.DynamicFixture;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynamicPolymorphicTest {

	@ClassRule
	public static StandardFixture fixture = new DynamicFixture();

	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testContainmentWithHierarchyOfTypes() {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-types-dynamic-1.json"), true);

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
