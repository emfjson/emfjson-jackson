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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.support.DynamicFixture;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.junit.Assert.assertEquals;

public class DynamicValueTest {

	@ClassRule
	public static StandardFixture fixture = new DynamicFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveEJavaObjectValue() {
		EClass classA = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//A"), true);
		EDataType type = (EDataType) classA.getEStructuralFeature("javaType").getEType();

		final Object value = "Hello";
		final EObject obj = EcoreUtil.create(classA);
		obj.eSet(classA.getEStructuralFeature("javaType"), value);

		String stringValue = EcorePackage.eINSTANCE.getEFactoryInstance().convertToString(type, value);

		JsonNode result = mapper.valueToTree(obj);
		assertEquals(stringValue, result.get("javaType").asText());
	}

	@Test
	public void testLoadEJavaObjectValue() throws JsonProcessingException {
		EClass classA = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//A"), true);
		EDataType type = (EDataType) classA.getEStructuralFeature("javaType").getEType();

		final Object value = "Hello";
		String stringValue = EcorePackage.eINSTANCE.getEFactoryInstance().convertToString(type, value);

		JsonNode node = mapper.createObjectNode()
				.put("eClass", "http://emfjson/dynamic/model#//A")
				.put("javaType", stringValue);

		EObject obj = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(node, EObject.class);

		assertEquals(value, obj.eGet(classA.getEStructuralFeature("javaType")));
	}

	@Test
	public void testSaveEJavaClassValue() {
		EClass classA = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//A"), true);
		EDataType type = (EDataType) classA.getEStructuralFeature("javaClass").getEType();

		final Object value = this.getClass();
		final EObject obj = EcoreUtil.create(classA);
		obj.eSet(classA.getEStructuralFeature("javaClass"), value);

		String stringValue = EcorePackage.eINSTANCE.getEFactoryInstance().convertToString(type, value);

		JsonNode result = mapper.valueToTree(obj);
		assertEquals(stringValue, result.get("javaClass").asText());
	}

	@Test
	public void testLoadEJavaClassValue() throws JsonProcessingException {
		EClass classA = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//A"), true);
		EDataType type = (EDataType) classA.getEStructuralFeature("javaClass").getEType();

		final Object value = this.getClass();
		String stringValue = EcorePackage.eINSTANCE.getEFactoryInstance().convertToString(type, value);

		JsonNode node = mapper.createObjectNode()
				.put("eClass", "http://emfjson/dynamic/model#//A")
				.put("javaClass", stringValue);

		EObject obj = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(node, EObject.class);

		assertEquals(value, obj.eGet(classA.getEStructuralFeature("javaClass")));
	}

}
