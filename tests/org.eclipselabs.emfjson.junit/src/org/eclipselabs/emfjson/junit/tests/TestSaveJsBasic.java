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

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.JsURIHandlerImpl;
import org.eclipselabs.emfjson.internal.JsOutputStream;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.User;
import org.junit.Test;

/**
 * 
 * @author ghillairet
 *
 */
public class TestSaveJsBasic extends TestSupport {
	
	@Test
	public void testSaveSystemFile() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
		
		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");
		
		Resource resource = resourceSet.createResource(URI.createURI("file:/tmp/test-save-1.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user);
		
		resource.save(null);
	}
	
	@Test
	public void testSavePlatformPluginFile() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
		
		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user);
		
		resource.save(null);
	}
	
	@Test
	public void testSaveJsOutputStream() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
		
		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");
		
		Resource resource = resourceSet.createResource(uri("test.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user);
		
		OutputStream out = new JsOutputStream();
		
		resource.save(out, null);
		
		System.out.println(new String(((JsOutputStream) out).toByteArray()));
	}
	
}
