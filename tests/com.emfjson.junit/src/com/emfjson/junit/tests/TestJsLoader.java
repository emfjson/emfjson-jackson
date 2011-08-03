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
package com.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import com.emfjson.emf.JsURIHandlerImpl;
import com.emfjson.junit.model.Address;
import com.emfjson.junit.model.ModelPackage;
import com.emfjson.junit.model.User;

/**
 * 
 * @author guillaume hillairet
 *
 */
public class TestJsLoader {

	final Map<String ,Object> options = new HashMap<String, Object>();
	ResourceSet resourceSet;
	
	@Before
	public void tearUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		
		resourceSet = new ResourceSetImpl();
		
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
	}
	
	@Test
	public void testLoadSingleObjectNoReferences() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("platform:/resource/tests/test-load-1.json", true));

		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		resource.load(options);
		
		assertNotNull(resource.getContents());
		
		EList<EObject> objects = resource.getContents();
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(1, objects.size());
		
		EObject obj = objects.iterator().next();
		
		assertTrue(obj instanceof User);
		assertEquals("1", ((User) obj).getUserId());
		assertEquals("Paul", ((User) obj).getName());
	}
	
//	@Test
	public void testLoadSingleObjectOneContainment() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-load-2.json"));

		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		resource.load(options);
		
		assertNotNull(resource.getContents());
		
		EList<EObject> objects = resource.getContents();
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(1, objects.size());
		
		EObject obj = objects.iterator().next();
		
		assertTrue(obj instanceof User);
		assertEquals("1", ((User) obj).getUserId());
		assertEquals("Paul", ((User) obj).getName());
		
		assertNotNull(((User) obj).getAddress());
		
		Address add = ((User) obj).getAddress();
		assertEquals("a1", add.getAddId());
		assertEquals("Paris", add.getCity());
		assertEquals("la rue", add.getStreet());
		assertEquals(new Integer(12), add.getNumber());
	}
	
//	@Test
	public void testLoadObjectsInArray() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-load-3.json"));

		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		resource.load(options);
		
		assertNotNull(resource.getContents());
		
		EList<EObject> objects = resource.getContents();
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(2, objects.size());
	}
	
//	@Test
	public void testLoadObjectsWithReference() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-load-4.json"));

		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		resource.load(options);
		
		assertNotNull(resource.getContents());
		
		EList<EObject> objects = resource.getContents();
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(2, objects.size());
		
		EObject obj = objects.iterator().next();
		assertTrue(obj instanceof User);
		assertFalse(((User) obj).getFriends().isEmpty());
	}
}
