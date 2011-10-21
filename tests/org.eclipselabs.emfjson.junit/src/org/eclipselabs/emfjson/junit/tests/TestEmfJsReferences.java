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
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.User;
import org.junit.Test;

public class TestEmfJsReferences extends TestSupport {
	
	@Test
	public void testSaveOneObjectWithAttributesNoReferences() throws IOException {
		String expectedString = "{\"userId\":\"1\",\"name\":\"John\"}";
		
		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testSaveTwoObjectsWithAttributesNoReferences() throws IOException {
		String expectedString = "[{\"userId\":\"1\",\"name\":\"John\"},{\"userId\":\"2\",\"name\":\"Paul\"}]";
		
		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");
		
		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-2.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user1);
		resource.getContents().add(user2);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		String expectedString = "[{\"userId\":\"1\",\"name\":\"John\",\"friends\":[{\"$ref\":\"2\"}]},{\"userId\":\"2\",\"name\":\"Paul\"}]";
		
		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");
		
		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");
		
		user1.getFriends().add(user2);
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user1);
		resource.getContents().add(user2);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
}
