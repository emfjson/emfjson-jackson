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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import org.emfjson.jackson.junit.model.ETypes;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.support.TestSupport;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValueTest extends TestSupport {

	@Test
	public void testStringValues() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eString", "Hello")
			.set("eStrings", mapper.createArrayNode()
				.add("Hello")
				.add("The")
				.add("World"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEString("Hello");

		valueObject.getEStrings().add("Hello");
		valueObject.getEStrings().add("The");
		valueObject.getEStrings().add("World");

		resource.getContents().add(valueObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testIntValues() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eInt", 2)
			.set("eInts", mapper.createArrayNode()
				.add(2)
				.add(4)
				.add(7));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEInt(2);

		valueObject.getEInts().add(2);
		valueObject.getEInts().add(4);
		valueObject.getEInts().add(7);

		resource.getContents().add(valueObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadIntValues() throws IOException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eInt", 2)
			.set("eInts", mapper.createArrayNode()
				.add(2)
				.add(4)
				.add(7));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		assertEquals(2, ((ETypes) root).getEInt());

		List<Integer> ints = ((ETypes) root).getEInts();
		assertEquals(3, ints.size());
		assertTrue(2 == ints.get(0));
		assertTrue(4 == ints.get(1));
		assertTrue(7 == ints.get(2));
	}

	@Test
	public void testBooleanValues() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eBoolean", true)
			.set("eBooleans", mapper.createArrayNode()
				.add(false)
				.add(true));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBoolean(true);

		valueObject.getEBooleans().add(false);
		valueObject.getEBooleans().add(true);

		resource.getContents().add(valueObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testDateValue() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eDate", "2011-10-10T00:00:00");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		Date value = (Date) EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(), "2011-10-10");
		valueObject.setEDate(value);

		resource.getContents().add(valueObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadDateValue() throws IOException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eDate", "2011-10-10T00:00:00");

		Date value = (Date) EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(),
			"2011-10-10T00:00:00");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		ETypes root = (ETypes) resource.getContents().get(0);

		assertEquals(value, root.getEDate());
	}

	@Test
	public void testBigIntegerValue() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBigInteger(new BigInteger("15"));
		resource.getContents().add(valueObject);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(new BigInteger("15"), result.get("eBigInteger").bigIntegerValue());
	}

	@Test
	public void testLoadBigIntegerValue() throws IOException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eBigInteger", 15);

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		BigInteger value = ((ETypes) root).getEBigInteger();

		assertEquals(new BigInteger("15"), value);
	}

	@Test
	public void testByteValue() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eByte", 101);

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		byte b = 101;
		valueObject.setEByte(b);
		resource.getContents().add(valueObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testBigDecimalValue() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBigDecimal(new BigDecimal(1.5));
		resource.getContents().add(valueObject);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(new BigDecimal(1.5), result.get("eBigDecimal").decimalValue());
	}

	@Test
	public void testLoadBigDecimalValue() throws IOException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//ETypes")
			.put("eBigDecimal", 1.5);

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		BigDecimal value = ((ETypes) root).getEBigDecimal();

		assertEquals(new BigDecimal(1.5), value);
	}

}