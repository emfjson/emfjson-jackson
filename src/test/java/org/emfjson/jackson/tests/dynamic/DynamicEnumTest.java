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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.support.DynamicFixture;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_DEFAULT_VALUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynamicEnumTest {

	@ClassRule
	public static StandardFixture fixture = new DynamicFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveDynamicEnum() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://emfjson/dynamic/model#//A")
				.put("intValue", 0)
				.put("someKind", "e1");

		EClass a = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//A"), true);
		EObject a1 = EcoreUtil.create(a);

		JsonNode result = fixture.mapper(OPTION_SERIALIZE_DEFAULT_VALUE, true)
				.valueToTree(a1);

		assertEquals(expected, result);
	}

	@Test
	public void testLoadDynamicEnum() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://emfjson/dynamic/model#//A")
				.put("someKind", "E2");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);

		assertEquals("A", root.eClass().getName());

		Object literal = root.eGet(root.eClass().getEStructuralFeature("someKind"));

		assertTrue(literal instanceof EEnumLiteral);

		assertEquals("e2", ((EEnumLiteral) literal).getName());
		assertEquals("E2", ((EEnumLiteral) literal).getLiteral());
	}

}
