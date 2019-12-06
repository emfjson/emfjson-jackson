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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.PrimaryObject;
import org.emfjson.jackson.junit.model.TargetObject;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FeatureMapTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveFeatureMap() throws IOException {
		ObjectNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
				.put("name", "junit");

		expected.set("featureMapAttributeType1", mapper.createArrayNode().add("Hello"));
		expected.set("featureMapAttributeType2", mapper.createArrayNode().add("World"));

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		primaryObject.getFeatureMapAttributeType1().add("Hello");
		primaryObject.getFeatureMapAttributeType2().add("World");

		assertEquals(2, primaryObject.getFeatureMapAttributeCollection().size());
		assertEquals(1, primaryObject.getFeatureMapAttributeType1().size());
		assertEquals(1, primaryObject.getFeatureMapAttributeType2().size());

		Resource resource = resourceSet.createResource(URI.createURI("test.json"));
		resource.getContents().add(primaryObject);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadFeatureMap() throws IOException {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-load-feature-map.json"), true);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof PrimaryObject);

		PrimaryObject o = (PrimaryObject) resource.getContents().get(0);
		assertEquals("junit", o.getName());
		assertEquals("Hello", o.getFeatureMapAttributeType1().get(0));
		assertEquals("World", o.getFeatureMapAttributeType2().get(0));
		assertEquals(2, o.getFeatureMapAttributeCollection().size());
	}

	@Test
	public void testLoadFeatureMapReferences() throws IOException {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-load-feature-map-refs.json"), true);

		assertEquals(1, resource.getContents().size());
		assertEquals(ModelPackage.Literals.PRIMARY_OBJECT, resource.getContents().get(0).eClass());

		PrimaryObject p = (PrimaryObject) resource.getContents().get(0);

		assertEquals(6, p.getFeatureMapReferenceCollection().size());
		assertEquals(2, p.getFeatureMapReferenceType1().size());
		assertEquals(4, p.getFeatureMapReferenceType2().size());

		TargetObject t1 = p.getFeatureMapReferenceType2().get(0);
		assertEquals("1", t1.getSingleAttribute());

		TargetObject t2 = p.getFeatureMapReferenceType2().get(1);
		assertEquals("2", t2.getSingleAttribute());

		TargetObject t3 = p.getFeatureMapReferenceType2().get(2);
		assertEquals("3", t3.getSingleAttribute());

		TargetObject t4 = p.getFeatureMapReferenceType2().get(3);
		assertEquals("4", t4.getSingleAttribute());

		assertEquals(t1, p.getFeatureMapReferenceType1().get(0));
		assertEquals(t2, p.getFeatureMapReferenceType1().get(1));
	}

	@Test
	public void testSaveFeatureMapReferences() throws IOException {
		ObjectNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject");

		expected.set("featureMapReferenceType1", mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//TargetObject")
						.put("$ref", "//@featureMapReferenceType2.0"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//TargetObject")
						.put("$ref", "//@featureMapReferenceType2.1")));

		expected.set("featureMapReferenceType2", mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("singleAttribute", "1"))
				.add(mapper.createObjectNode()
						.put("singleAttribute", "2"))
				.add(mapper.createObjectNode()
						.put("singleAttribute", "3"))
				.add(mapper.createObjectNode()
						.put("singleAttribute", "4")));

		Resource resource = resourceSet.createResource(URI.createURI("tests.json"));
		assertNotNull(resource);

		PrimaryObject p = ModelFactory.eINSTANCE.createPrimaryObject();
		TargetObject t1 = ModelFactory.eINSTANCE.createTargetObject();
		t1.setSingleAttribute("1");
		TargetObject t2 = ModelFactory.eINSTANCE.createTargetObject();
		t2.setSingleAttribute("2");
		TargetObject t3 = ModelFactory.eINSTANCE.createTargetObject();
		t3.setSingleAttribute("3");
		TargetObject t4 = ModelFactory.eINSTANCE.createTargetObject();
		t4.setSingleAttribute("4");

		p.getFeatureMapReferenceType1().add(t1);
		p.getFeatureMapReferenceType1().add(t2);

		p.getFeatureMapReferenceType2().add(t1);
		p.getFeatureMapReferenceType2().add(t2);
		p.getFeatureMapReferenceType2().add(t3);
		p.getFeatureMapReferenceType2().add(t4);

		resource.getContents().add(p);

		assertEquals(expected, mapper.valueToTree(resource));
	}

}