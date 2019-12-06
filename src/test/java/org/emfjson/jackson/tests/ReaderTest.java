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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.junit.model.ETypes;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.junit.Assert.*;

public class ReaderTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void shouldReadObjectWhenEClassFieldIsNotFirst() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eInt", 1)
				.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
				.set("eInts", mapper.createArrayNode().add(1).add(2));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);

		assertEquals(ModelPackage.Literals.ETYPES, result.eClass());

		ETypes value = (ETypes) result;

		assertEquals(1, value.getEInt());
		assertEquals(2, value.getEInts().size());
		assertSame(1, value.getEInts().get(0));
		assertSame(2, value.getEInts().get(1));
	}

	@Test
	public void shouldReadObjectTreeWithEClassFieldNotFirst() throws JsonProcessingException {
		JsonNode data = ((ObjectNode) mapper.createObjectNode()
				.put("name", "A")
				.set("eStructuralFeatures", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("name", "foo")
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"))
						.add(mapper.createObjectNode()
								.put("name", "bar")
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"))))
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass");

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass());
		assertEquals(2, ((EClass) result).getEStructuralFeatures().size());

		EStructuralFeature firstAttribute = ((EClass) result).getEStructuralFeatures().get(0);
		assertEquals(EcorePackage.Literals.EATTRIBUTE, firstAttribute.eClass());
		assertEquals("foo", firstAttribute.getName());

		EStructuralFeature secondAttribute = ((EClass) result).getEStructuralFeatures().get(1);
		assertEquals(EcorePackage.Literals.EATTRIBUTE, secondAttribute.eClass());
		assertEquals("bar", secondAttribute.getName());
	}

	@Test
	public void shouldReadObjectTreeWithEClassFieldNotFirstAndNonAbstractChildren() throws JsonProcessingException {
		JsonNode data = ((ObjectNode) mapper.createObjectNode()
				.put("name", "A")
				.set("eOperations", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("name", "foo")
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EOperation"))
						.add(mapper.createObjectNode()
								.put("name", "bar")
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EOperation"))))
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass");

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass());
		assertEquals(2, ((EClass) result).getEOperations().size());

		EOperation firstOperation = ((EClass) result).getEOperations().get(0);
		assertEquals(EcorePackage.Literals.EOPERATION, firstOperation.eClass());
		assertEquals("foo", firstOperation.getName());

		EOperation secondOperation = ((EClass) result).getEOperations().get(1);
		assertEquals(EcorePackage.Literals.EOPERATION, secondOperation.eClass());
		assertEquals("bar", secondOperation.getName());
	}

	@Test
	public void shouldReadObjectTreeWithEClassFieldRandomPosition() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.put("name", "A")
				.set("eStructuralFeatures", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute")
								.put("name", "foo"))
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute")
								.put("name", "bar")));

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass());
		assertEquals(2, ((EClass) result).getEStructuralFeatures().size());
		assertEquals(EcorePackage.Literals.EATTRIBUTE, ((EClass) result).getEStructuralFeatures().get(0).eClass());
		assertEquals(EcorePackage.Literals.EATTRIBUTE, ((EClass) result).getEStructuralFeatures().get(1).eClass());
	}

	@Test
	public void shouldSkipAttributeFieldForWhichThereIsNoFeature() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.put("some_unknown_feature", "some value")
				.put("name", "A");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);

		assertEquals(EcorePackage.Literals.ECLASS, result.eClass());
		assertEquals("A", result.eGet(EcorePackage.Literals.ENAMED_ELEMENT__NAME));
	}

	@Test
	public void shouldReturnErrorsForWhichThereIsNoFeature() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.put("some_unknown_feature", "some value")
				.put("name", "A");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());
		assertEquals(1, resource.getErrors().size());

		Resource.Diagnostic error = resource.getErrors().get(0);

		assertNotNull(error.getMessage());
		assertNotNull(error.getColumn());
		assertNotNull(error.getLine());
	}

	@Test
	public void shouldSkipObjectFieldForWhichThereIsNoFeature() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.put("name", "A")
				.set("some_unknown_feature", mapper.createObjectNode()
						.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute")
						.put("name", "foo"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass());
	}

	@Test
	public void shouldSkipArrayFieldForWhichThereIsNoFeature() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.put("name", "A")
				.set("some_unknown_feature", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute")
								.put("name", "foo")));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject result = resource.getContents().get(0);
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass());
	}

}
