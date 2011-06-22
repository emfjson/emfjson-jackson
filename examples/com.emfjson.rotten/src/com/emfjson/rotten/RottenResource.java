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
package com.emfjson.rotten;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import com.emfjson.model.rotten.RottenPackage;
import com.emfjson.resource.JSONResource;
import com.emfjson.resource.impl.JSONResourceFactoryImpl;
import com.emfjson.resource.impl.JSONResourceImpl;

public class RottenResource extends JSONResourceImpl {

	private static final URI rotten = URI.createURI("http://api.rottentomatoes.com/api/public/v1.0/movies.json");
	
	static {
		EPackage.Registry.INSTANCE.put(RottenPackage.eNS_URI, RottenPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap()
			.put(JSONResource.APPLICATION_JSON, new JSONResourceFactoryImpl());
	}
	
	public RottenResource() {
		super(rotten);
	}
	
	public static void main(String[] args) {
		
	}
}
