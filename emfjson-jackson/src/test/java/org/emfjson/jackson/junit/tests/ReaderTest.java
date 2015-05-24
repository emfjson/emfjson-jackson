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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import org.emfjson.jackson.junit.model.ETypes;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.support.TestSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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
		assertEquals(EcorePackage.Literals.EATTRIBUTE, ((EClass) result).getEStructuralFeatures().get(0).eClass());
		assertEquals(EcorePackage.Literals.EATTRIBUTE, ((EClass) result).getEStructuralFeatures().get(1).eClass());
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
