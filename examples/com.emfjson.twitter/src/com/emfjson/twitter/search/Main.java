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
package com.emfjson.twitter.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.emfjson.model.search.Result;
import com.emfjson.model.search.SearchPackage;
import com.emfjson.resource.JSONResource;
import com.emfjson.resource.impl.JSONResourceFactoryImpl;

public class Main {
	
	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(SearchPackage.eNS_URI, SearchPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap()
			.put(JSONResource.APPLICATION_JSON, new JSONResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		
		Map<String ,Object> options = new HashMap<String, Object>();
		options.put(JSONResource.OPTION_ROOT_ELEMENT, SearchPackage.eINSTANCE.getResult());
		
		Resource resource = resourceSet.createResource(URI.createURI("file:data.json"), JSONResource.APPLICATION_JSON);
		resource.load(options);
		
		Result result = (Result) resource.getContents().get(0);
		System.out.println(result.getId());
		System.out.println(result.getFromUser());
		System.out.println(result.getText());
		System.out.println(result.getToUser());
		
		System.out.println(result.getMetadata());
		System.out.println(result.getSinceId());
	}
	
}
