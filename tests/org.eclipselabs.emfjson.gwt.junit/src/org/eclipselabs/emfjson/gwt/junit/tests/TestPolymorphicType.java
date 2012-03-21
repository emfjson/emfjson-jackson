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
package org.eclipselabs.emfjson.gwt.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.gwt.junit.support.TestSupport;
import org.eclipselabs.emfjson.junit.model.AbstractType;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeTwo;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.junit.Test;

public class TestPolymorphicType extends TestSupport {
	
	@Test
	public void testSaveTwoObjectsWithTypeInformation() throws IOException {
		String expectedString = 
				"{" +
						"\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//Container\",\"elements\":" +
						"[" +
							"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ConcreteTypeOne\",\"name\":\"First\"}," +
							"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ConcreteTypeTwo\",\"name\":\"Two\"}" +
							"]" +
				"}";
		
		Resource resource = resourceSet.createResource(URI.createURI("types.json"));
		
		assertNotNull(resource);
		
		Container c = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		one.setName("First");
		ConcreteTypeTwo two = ModelFactory.eINSTANCE.createConcreteTypeTwo();
		two.setName("Two");
		c.getElements().add(one);
		c.getElements().add(two);
		
		resource.getContents().add(c);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadTwoObjectsWithTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(
				URI.createURI("platform:/plugin/org.eclipselabs.emfjson.junit/tests/test-load-types.json"));
		assertNotNull(resource);
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
		
		resource.load(options);
		
		assertEquals(1, resource.getContents().size());
		
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);
		
		Container container = (Container) root;
		
		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);
		
		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);
		
		assertEquals("First", first.getName());
		assertEquals("one", ((ConcreteTypeOne)first).getPropTypeOne());
		assertEquals("Two", second.getName());
		assertEquals("two", ((ConcreteTypeTwo)second).getPropTypeTwo());
	}
	
	@Test
	public void testLoadTwoObjectsWithReferenceAndTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(
				URI.createURI("platform:/plugin/org.eclipselabs.emfjson.junit/tests/test-load-types-2.json"));
		assertNotNull(resource);
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
		
		resource.load(options);
		
		assertEquals(1, resource.getContents().size());
		
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);
		
		Container container = (Container) root;
		
		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);
		
		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);
		
		assertEquals(1, first.getRefProperty().size());
		
		EObject ref = first.getRefProperty().get(0);
		
		assertEquals(second, ref);
	}
	
	@Test
	public void testLoadTwoObjectsWithReferenceAndTypeInformationAndNamespace() throws IOException {
		Resource resource = resourceSet.createResource(
				URI.createURI("platform:/plugin/org.eclipselabs.emfjson.junit/tests/test-load-ns-types.json"));
		assertNotNull(resource);
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
		
		resource.load(options);
		
		assertEquals(1, resource.getContents().size());
		
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);
		
		Container container = (Container) root;
		
		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);
		
		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);
		
		assertEquals(1, first.getRefProperty().size());
		
		EObject ref = first.getRefProperty().get(0);
		
		assertEquals(second, ref);
	}
}
