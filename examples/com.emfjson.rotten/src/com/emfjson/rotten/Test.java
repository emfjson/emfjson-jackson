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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.emfjson.model.rotten.Cast;
import com.emfjson.model.rotten.Movie;
import com.emfjson.model.rotten.Poster;
import com.emfjson.model.rotten.RottenFactory;
import com.emfjson.resource.impl.JSONResourceImpl;

public class Test {
	public static void main(String[] args) throws IOException {
//		ResourceSet resourceSet = new ResourceSetImpl();
//		EList uriHandlers = resourceSet.getURIConverter().getURIHandlers();
//		uriHandlers.add(0, new JSONURIHandlerImpl());
//
//		Resource resource = resourceSet.getResource(URI.createURI("json://data.json"), true);
//
//		System.out.println(resource);
		
		Resource resource = new JSONResourceImpl(URI.createURI("out.json"));
		
		Movie movie = RottenFactory.eINSTANCE.createMovie();
		movie.setId("1");
		movie.setRuntime(100);
		movie.setTitle("Terminator");
		
		Poster poster = RottenFactory.eINSTANCE.createPoster();
		poster.setDetailed("some_value");
		
		Cast c1 = RottenFactory.eINSTANCE.createCast();
		c1.setName("John Doe");
		
		Cast c2 = RottenFactory.eINSTANCE.createCast();
		c2.setName("Fred Poe");
		
		movie.setPosters(poster);
		movie.getCastings().add(c1);
		movie.getCastings().add(c2);
		
		resource.getContents().add(movie);
		
		resource.save(null);
	}
}
