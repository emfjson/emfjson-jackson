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

import java.io.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.emfjson.jackson.junit.model.ETypes;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReaderTest extends TestSupport {

	@Test
	public void shouldReadObjectWhenEClassFieldIsNotFirst() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eInt", 1)
				.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
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

		Resource resource = mapper.treeToValue(data, Resource.class);

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

		Resource resource = mapper.treeToValue(data, Resource.class);

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
				.put("name", "A")
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.set("eStructuralFeatures", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("name", "foo")
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"))
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EAttribute")
								.put("name", "bar")));

		Resource resource = mapper.treeToValue(data, Resource.class);

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
