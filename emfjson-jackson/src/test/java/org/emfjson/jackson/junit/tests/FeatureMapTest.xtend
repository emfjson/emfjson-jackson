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
package org.emfjson.jackson.junit.tests

import java.io.ByteArrayOutputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.emfjson.EMFJs
import org.emfjson.jackson.junit.model.ModelFactory
import org.emfjson.jackson.junit.model.PrimaryObject
import org.emfjson.jackson.junit.support.TestSupport
import org.junit.Test

import static org.junit.Assert.*

class FeatureMapTest extends TestSupport {

	override setUp() {
		super.setUp()
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true)
	}

	@Test
	def testSaveFeatureMap() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject",
			  "name" : "junit",
			  "featureMapAttributeType1" : [ "Hello" ],
			  "featureMapAttributeType2" : [ "World" ],
			  "kind" : "one"
			}'''

		val primaryObject = ModelFactory.eINSTANCE.createPrimaryObject()
		primaryObject.setName("junit")

		primaryObject.getFeatureMapAttributeType1().add("Hello")
		primaryObject.getFeatureMapAttributeType2().add("World")

		assertEquals(2, primaryObject.getFeatureMapAttributeCollection().size())
		assertEquals(1, primaryObject.getFeatureMapAttributeType1().size())
		assertEquals(1, primaryObject.getFeatureMapAttributeType2().size())

		val resource = resourceSet.createResource(URI.createURI("test.json"))
		resource.getContents().add(primaryObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testLoadFeatureMap() throws IOException {
		val resource = resourceSet.createResource(uri("test-load-feature-map.json"))
		resource.load(null)
		
		assertEquals(1, resource.getContents().size())
		assertTrue(resource.getContents().get(0) instanceof PrimaryObject)
		
		val o = resource.getContents().get(0) as PrimaryObject
		assertEquals("junit", o.getName())
		assertEquals("Hello", o.getFeatureMapAttributeType1().get(0))
		assertEquals("World", o.getFeatureMapAttributeType2().get(0))
		assertEquals(2, o.getFeatureMapAttributeCollection().size())
	}

	@Test
	def testSaveFeatureMapReferences() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//PrimaryObject",
			  "featureMapReferenceType1" : [ {
			    "$ref" : "//@featureMapReferenceType2.0"
			  }, {
			    "$ref" : "//@featureMapReferenceType2.1"
			  } ],
			  "featureMapReferenceType2" : [ {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//TargetObject",
			    "singleAttribute" : "1"
			  }, {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//TargetObject",
			    "singleAttribute" : "2"
			  }, {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//TargetObject",
			    "singleAttribute" : "3"
			  }, {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//TargetObject",
			    "singleAttribute" : "4"
			  } ],
			  "kind" : "one"
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests.json"));
		assertNotNull(resource);

		val p = ModelFactory.eINSTANCE.createPrimaryObject();
		val t1 = ModelFactory.eINSTANCE.createTargetObject();
		t1.setSingleAttribute("1");
		val t2 = ModelFactory.eINSTANCE.createTargetObject();
		t2.setSingleAttribute("2");
		val t3 = ModelFactory.eINSTANCE.createTargetObject();
		t3.setSingleAttribute("3");
		val t4 = ModelFactory.eINSTANCE.createTargetObject();
		t4.setSingleAttribute("4");

		p.getFeatureMapReferenceType1().add(t1);
		p.getFeatureMapReferenceType1().add(t2);

		p.getFeatureMapReferenceType2().add(t1);
		p.getFeatureMapReferenceType2().add(t2);
		p.getFeatureMapReferenceType2().add(t3);
		p.getFeatureMapReferenceType2().add(t4);

		resource.getContents().add(p);

		val outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

}