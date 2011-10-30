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
package org.eclipselabs.emfjson.youtube.junit.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.JsURIHandlerImpl;
import org.eclipselabs.emfjson.youtube.VideoItem;
import org.eclipselabs.emfjson.youtube.VideoResult;
import org.eclipselabs.emfjson.youtube.YoutubePackage;
import org.eclipselabs.emfjson.youtube.service.YouTube;
import org.junit.Before;
import org.junit.Test;


public class TestSearchBasic {

	final Map<String ,Object> options = new HashMap<String, Object>();
	ResourceSet resourceSet;
	
	@Before
	public void tearUp() {
		resourceSet = new ResourceSetImpl();
		
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
	}
	
	@Test
	public void testOneSearch() throws IOException {
		YouTube service = new YouTube("emf")
			.maxResults(10);
		
		Resource resource = resourceSet.createResource(service.getURI());
		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, YoutubePackage.eINSTANCE.getVideoResult());
		
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		
		System.out.println(resource.getContents());
		
		for (EObject o: resource.getContents()) {
			VideoResult result = (VideoResult) o;
			System.out.println(result.getStartIndex());
			for (VideoItem item: result.getItems()) {
				System.out.println("item: "+item);
				System.out.println("    "+item.getTitle());
				System.out.println("    "+item.getPlayer().getDefault());
				if (item.getContent() != null) {
					System.out.println("    "+item.getContent().getRtsp());	
				}
			}
			
			System.out.println();
		}
		assertTrue(resource.getContents().size() == 1);
	}
	
}
