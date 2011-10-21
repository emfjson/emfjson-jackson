/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.junit.model.ETypes;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.PrimaryObject;
import org.junit.Test;

/**
 * 
 * @author guillaume
 *
 */
public class TestEmfJsAttributes extends TestSupport {
	
	@Test
	public void testStringValues() throws IOException {
		String expectedString = "{\"eString\":\"Hello\",\"eStrings\":[\"Hello\",\"World\"]}";
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		
		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEString("Hello");
		
		String[] arrayValue = new String[]{"Hello", "World"};
		valueObject.getEStrings().addAll(Arrays.asList(arrayValue));
		
		resource.getContents().add(valueObject);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testIntValues() throws IOException {
		String expectedString = "{\"eInt\":1,\"eInts\":[1,2]}";
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		
		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEInt(1);
		
		Integer[] arrayValue = new Integer[]{1, 2};
		valueObject.getEInts().addAll(Arrays.asList(arrayValue));
		
		resource.getContents().add(valueObject);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testBooleanValues() throws IOException {
		String expectedString = "{\"eBoolean\":true,\"eBooleans\":[false,true]}";
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		
		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBoolean(true);
		
		Boolean[] arrayValue = new Boolean[]{false, true};
		valueObject.getEBooleans().addAll(Arrays.asList(arrayValue));
		
		resource.getContents().add(valueObject);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testFeatureMap() throws IOException
	{
		// Setup : Create a primary object and two attributes for the feature map.

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		primaryObject.getFeatureMapAttributeType1().add("Hello");
		primaryObject.getFeatureMapAttributeType2().add("World");

		assertThat(primaryObject.getFeatureMapAttributeCollection().size(), is(2));
		assertThat(primaryObject.getFeatureMapAttributeType1().size(), is(1));
		assertThat(primaryObject.getFeatureMapAttributeType2().size(), is(1));

		// Test : Store the object to MongDB
		
		Resource resource = resourceSet.createResource(URI.createURI("test.json"));
		resource.getContents().add(primaryObject);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, null);
		
		// Verify : Check that the object was stored correctly.

		HashSet<EStructuralFeature> excludeFeatures = new HashSet<EStructuralFeature>(1);
		excludeFeatures.add(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);
		
		System.out.println(new String(outStream.toByteArray()));
		
//		assertThat(actual.getFeatureMapAttributeCollection().size(), is(2));
	}
}
