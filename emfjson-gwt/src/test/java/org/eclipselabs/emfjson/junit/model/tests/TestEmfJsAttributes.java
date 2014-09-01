/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.model.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.ETypes;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.Sex;
import org.eclipselabs.emfjson.junit.model.User;
import org.eclipselabs.emfjson.junit.model.support.TestSupport;
import org.junit.Test;

public class TestEmfJsAttributes extends TestSupport {

	@Test
	public void testStringValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\", \"eString\":\"Hello\", \"eStrings\":[\"Hello\",\"World\"]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEString("Hello");

		String[] arrayValue = new String[]{"Hello", "World"};
		valueObject.getEStrings().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testIntValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\", \"eInt\":1, \"eInts\":[1,2]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEInt(1);

		Integer[] arrayValue = new Integer[]{1, 2};
		valueObject.getEInts().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testDoubleValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\", \"eDouble\":1.2, \"eDoubles\":[1.2,2.2]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEDouble(1.2);

		Double[] arrayValue = new Double[]{1.2, 2.2};
		valueObject.getEDoubles().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadDoubleValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\", \"eDouble\":1.2, \"eDoubles\":[1.2,2.2]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(expectedString.getBytes()), options);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		ETypes types = (ETypes)root;
		assertEquals(1.2, types.getEDouble());

		assertEquals(2, types.getEDoubles().size());
		assertEquals(1.2, types.getEDoubles().get(0));
		assertEquals(2.2, types.getEDoubles().get(1));
	}

	@Test
	public void testBooleanValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\", \"eBoolean\":true, \"eBooleans\":[false,true]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBoolean(true);

		Boolean[] arrayValue = new Boolean[]{false, true};
		valueObject.getEBooleans().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testDateValue() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\", \"eDate\":\"2011-10-10T00:00:00\"}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		Date value = (Date) EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(), "2011-10-10");

		valueObject.setEDate(value);

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testEnums() throws IOException {
		String expectedString = "["
				+ "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", \"sex\":\"MALE\"},"
				+ "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", \"sex\":\"FEMALE\"}]";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setSex(Sex.MALE);

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setSex(Sex.FEMALE);

		resource.getContents().add(u1);
		resource.getContents().add(u2);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadEnums() throws IOException {
		String inputString = "[{\"name\":\"A\", \"sex\":\"MALE\"}, {\"name\":\"B\", \"sex\":\"FEMALE\"}]";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);
		ByteArrayInputStream inStream = new ByteArrayInputStream(inputString.getBytes());
		resource.load(inStream, options);

		assertEquals(2, resource.getContents().size());

		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(1).eClass());

		User u1 = (User) resource.getContents().get(0);
		User u2 = (User) resource.getContents().get(1);

		assertEquals("A", u1.getName());
		assertEquals(Sex.MALE, u1.getSex());
		assertEquals("B", u2.getName());
		assertEquals(Sex.FEMALE, u2.getSex());
	}

	@Test
	public void testLoadOneObjectWithTypeFromFile() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		asyncLoad("test-load-1.json", new Callback<Resource>() {
			@Override
			public void onSuccess(Resource resource) {
				assertNotNull(resource);

				assertEquals(1, resource.getContents().size());
				assertTrue(resource.getContents().get(0) instanceof User);

				User user = (User) resource.getContents().get(0);
				assertEquals("1", user.getUserId());
				assertEquals("Paul", user.getName());

				finishTest();
			}
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
		});
		delayTestFinish(10000);
	}

	@Test
	public void testLoadOneObjectWithTypeFromInputStream() throws IOException {
		String data = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"1\",\"name\":\"Paul\"}";
		ByteArrayInputStream inStream = new ByteArrayInputStream(data.getBytes());
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		assertNotNull(resource);
		resource.load(inStream, null);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof User);

		User user = (User) resource.getContents().get(0);
		assertEquals("1", user.getUserId());
		assertEquals("Paul", user.getName());
	}

}
