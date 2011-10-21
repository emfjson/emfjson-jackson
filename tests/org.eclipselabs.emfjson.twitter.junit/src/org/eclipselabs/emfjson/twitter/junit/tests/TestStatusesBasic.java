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
package org.eclipselabs.emfjson.twitter.junit.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.JsURIHandlerImpl;
import org.eclipselabs.emfjson.search.SearchPackage;
import org.eclipselabs.emfjson.twitter.Statuses;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author guillaume hillairet
 *
 */
public class TestStatusesBasic {
	
	final Map<String ,Object> options = new HashMap<String, Object>();
	ResourceSet resourceSet;
	
	@Before
	public void tearUp() {
		resourceSet = new ResourceSetImpl();
		
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
	}
	
	@Test
	public void testOneStatus() throws IOException {
		Statuses status = new Statuses("99080036249894912")
			.includeEntities();
			
		Resource resource = resourceSet.createResource(status.getURI());
		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, SearchPackage.eINSTANCE.getStatus());
		
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		
		System.out.println(resource.getContents());
	}
}
