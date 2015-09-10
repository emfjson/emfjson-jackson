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
package org.emfjson.gwt.junit.tests;

import com.google.gwt.core.client.JavaScriptObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import org.emfjson.gwt.junit.model.*;
import org.emfjson.gwt.junit.support.TestSupport;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import static org.eclipse.emf.ecore.util.EcoreUtil.createFromString;

public class GwtTestValue extends TestSupport {

	private static native JavaScriptObject stringValues() /*-{
		return {
			"eClass": "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			"eString": "Hello",
			"eStrings": [ "Hello", "World" ]
		}
	}-*/;

	private static native JavaScriptObject intValues() /*-{
		return {
			"eClass": "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			"eInt": 1,
			"eInts": [ 1, 2 ]
		}
	}-*/;

	private static native JavaScriptObject doubleValues() /*-{
		return {
			"eClass": "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			"eDouble": 1.2,
			"eDoubles": [ 1.2, 2.2]
		}
	}-*/;

	private static native JavaScriptObject booleanValues() /*-{
		return {
			"eClass": "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			"eBoolean": true,
			"eBooleans": [ false, true ]
		}
	}-*/;

	private static native JavaScriptObject dateValues() /*-{
		return {
			"eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			"eDate" : "2011-10-10T00:00:00"
		}
	}-*/;

	private static native JavaScriptObject enumValues() /*-{
		return [
			{
				"eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
				"name": "A"
			},
			{
				"eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
				"name": "B",
				"sex": "FEMALE"
			}
		]
	}-*/;

	@Test
	public void testStringValues() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEString("Hello");

		String[] arrayValue = new String[]{"Hello", "World"};
		valueObject.getEStrings().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		isSame(stringValues(), resource);
	}

	@Test
	public void testLoadStringValues() throws IOException {
		parse(stringValues(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);
				assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

				ETypes types = (ETypes) root;
				assertEquals("Hello", types.getEString());
				assertEquals(2, types.getEStrings().size());
				assertEquals("Hello", types.getEStrings().get(0));
				assertEquals("World", types.getEStrings().get(1));

				finishTest();
			}
		});
	}

	@Test
	public void testIntValues() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEInt(1);

		Integer[] arrayValue = new Integer[]{1, 2};
		valueObject.getEInts().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		isSame(intValues(), resource);
	}

	@Test
	public void testDoubleValues() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEDouble(1.2);

		Double[] arrayValue = new Double[]{1.2, 2.2};
		valueObject.getEDoubles().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		isSame(doubleValues(), resource);
	}

	@Test
	public void testLoadDoubleValues() throws IOException {
		parse(doubleValues(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);
				assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

				ETypes types = (ETypes) root;
				assertEquals(1.2, types.getEDouble());
				assertEquals(2, types.getEDoubles().size());
				assertEquals(1.2, types.getEDoubles().get(0));
				assertEquals(2.2, types.getEDoubles().get(1));

				finishTest();
			}
		});
	}

	@Test
	public void testBooleanValues() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBoolean(true);

		Boolean[] arrayValue = new Boolean[]{false, true};
		valueObject.getEBooleans().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		isSame(booleanValues(), resource);
	}

	@Test
	public void testLoadBooleanValues() throws IOException {
		parse(booleanValues(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);
				assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

				ETypes types = (ETypes) root;
				assertTrue(types.isEBoolean());
				assertEquals(2, types.getEBooleans().size());
				assertFalse(types.getEBooleans().get(0));
				assertTrue(types.getEBooleans().get(1));

				finishTest();
			}
		});
	}

	@Test
	public void testDateValue() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		Date value = (Date) createFromString(EcorePackage.eINSTANCE.getEDate(), "2011-10-10");

		valueObject.setEDate(value);

		resource.getContents().add(valueObject);
		isSame(dateValues(), resource);
	}

	@Test
	public void testLoadDateValues() throws IOException {
		parse(dateValues(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);
				assertEquals(ModelPackage.Literals.ETYPES, root.eClass());
				ETypes types = (ETypes) root;

				assertEquals(createFromString(EcorePackage.eINSTANCE.getEDate(), "2011-10-10"), types.getEDate());

				finishTest();
			}
		});
	}

	@Test
	public void testEnums() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setName("A");
		u1.setSex(Sex.MALE);

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setName("B");
		u2.setSex(Sex.FEMALE);

		resource.getContents().add(u1);
		resource.getContents().add(u2);

		isSame(enumValues(), resource);
	}

	@Test
	public void testLoadEnums() throws IOException {
		parse(enumValues(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(2, resource.getContents().size());

				assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());
				assertEquals(ModelPackage.Literals.USER, resource.getContents().get(1).eClass());

				User u1 = (User) resource.getContents().get(0);
				User u2 = (User) resource.getContents().get(1);

				assertEquals("A", u1.getName());
				assertEquals(Sex.MALE, u1.getSex());
				assertEquals("B", u2.getName());
				assertEquals(Sex.FEMALE, u2.getSex());

				finishTest();
			}
		});
	}

}
