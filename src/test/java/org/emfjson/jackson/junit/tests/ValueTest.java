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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.EMFJs;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ValueTest extends TestSupport {

	@Test
	public void testOptionSaveDefaultValues() throws IOException {
		{
			JsonNode expected = mapper.createObjectNode()
					.put("eClass", "http://www.emfjson.org/jackson/model#//User")
					.put("name", "u1");

			User u = ModelFactory.eINSTANCE.createUser();
			u.setName("u1");

			assertEquals(expected, mapper.valueToTree(u));
		}

		{
			JsonNode expected = mapper.createObjectNode()
					.put("eClass", "http://www.emfjson.org/jackson/model#//User")
					.put("name", "u1")
					.put("sex", "FEMALE");

			User u = ModelFactory.eINSTANCE.createUser();
			u.setName("u1");
			u.setSex(Sex.FEMALE);

			assertEquals(expected, mapper.valueToTree(u));
		}

		options.put(EMFJs.OPTION_SERIALIZE_DEFAULT_VALUE, true);
		{
			JsonNode expected = mapper.createObjectNode()
					.put("eClass", "http://www.emfjson.org/jackson/model#//User")
					.put("name", "u1")
					.put("sex", "MALE");

			User u = ModelFactory.eINSTANCE.createUser();
			u.setName("u1");

			assertEquals(expected, mapper(JacksonOptions.from(options)).valueToTree(u));
		}
		{
			JsonNode expected = mapper.createObjectNode()
					.put("eClass", "http://www.emfjson.org/jackson/model#//User")
					.put("name", "u1")
					.put("sex", "FEMALE");

			User u = ModelFactory.eINSTANCE.createUser();
			u.setName("u1");
			u.setSex(Sex.FEMALE);

			assertEquals(expected, mapper(JacksonOptions.from(options)).valueToTree(u));
		}
	}

	@Test
	public void testStringValues() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
	public void testLoadStringValues() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
				.put("eString", "Hello")
				.set("eStrings", mapper.createArrayNode()
						.add("Hello")
						.add("The")
						.add("World"));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		assertEquals("Hello", ((ETypes) root).getEString());

		assertThat(((ETypes) root).getEStrings())
				.containsExactly("Hello", "The", "World");
	}

	@Test
	public void testLoadNullValue() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
				.putNull("eString");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		assertThat(((ETypes) root).getEString()).isNull();
	}

	@Test
	public void testIntValues() throws IOException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, Calendar.OCTOBER, 10);

		assertNotNull(mapper.getDateFormat());

		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
			.put("eDate", mapper.getDateFormat().format(calendar.getTime()));

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();

		Date value = calendar.getTime();
		valueObject.setEDate(value);

		resource.getContents().add(valueObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadDateValue() throws IOException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
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
			.put("eClass", "http://www.emfjson.org/jackson/model#//ETypes")
			.put("eBigDecimal", 1.5);

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		BigDecimal value = ((ETypes) root).getEBigDecimal();

		assertEquals(new BigDecimal(1.5), value);
	}

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

		EObject obj = mapper.treeToValue(node, EObject.class);

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

		EObject obj = mapper.treeToValue(node, EObject.class);

		assertEquals(value, obj.eGet(classA.getEStructuralFeature("javaClass")));
	}

}