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
package com.emfjson.junit;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import com.emfjson.junit.model.Address;
import com.emfjson.junit.model.ModelFactory;
import com.emfjson.junit.model.ModelPackage;
import com.emfjson.junit.model.User;
import com.emfjson.resource.JsResource;
import com.emfjson.resource.impl.JsResourceFactoryImpl;

public class JsResourceTest {
	
//	@Test
	public void testCreateAndSaveObjects() throws IOException {		
		Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap()
			.put(JsResource.APPLICATION_JSON, new JsResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI("out.json"), JsResource.APPLICATION_JSON);
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("Paul");
		
		Address add1 = ModelFactory.eINSTANCE.createAddress();
		add1.setAddId("add1");
		add1.setCity("Paris");
		add1.setNumber(13);
		add1.setStreet("Rue des Pommes");
		
		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setUserId("2");
		u2.setName("Pierre");
		
		u1.getFriends().add(u2);
		
		resource.getContents().add(u1);
		resource.getContents().add(u2);
		
		resource.save(System.out, null);
	}
	
	@Test
	public void testLoadFromString() throws IOException {
		String json = "[{\"userId\":\"1\",\"name\":\"Paul\"},{\"userId\":\"2\",\"name\":\"Pierre\"}]";
		
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		
		Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap()
			.put(JsResource.APPLICATION_JSON, new JsResourceFactoryImpl());
	
		final Map<String ,Object> options = new HashMap<String, Object>();
		options.put(JsResource.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI("out.json"), JsResource.APPLICATION_JSON);
		
		assertNotNull(resource);
		
		InputStream stream = new ByteArrayInputStream(json.getBytes());
		resource.load(stream, options);
		
//		assertFalse(resource.getContents().isEmpty());

		System.out.println("res "+resource.getContents());
		
//		assertTrue(resource.getContents().size() == 2);
		
	}
}
