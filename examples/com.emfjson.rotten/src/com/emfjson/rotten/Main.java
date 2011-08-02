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
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.emfjson.emf.JsURIHandlerImpl;
import com.emfjson.model.rotten.Movie;
import com.emfjson.model.rotten.Movies;
import com.emfjson.model.rotten.RottenPackage;

public class Main {
	
	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(RottenPackage.eNS_URI, RottenPackage.eINSTANCE);
		
		
		ResourceSet resourceSet = new ResourceSetImpl();
	
		Properties properties = new Properties();
		properties.load(new URL("file:src/config.properties").openStream());
		
		Rotten rotten = new Rotten("lists/movies/opening")
			.key(properties.get("rotten.apikey"))
			.pageLimit(5)
			.query("Terminator");
		
		final Map<String ,Object> options = new HashMap<String, Object>();
		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, RottenPackage.eINSTANCE.getMovies());
		
		Resource resource = resourceSet.createResource(rotten.getURI());
		resource.load(options);
		
		Movies movies = (Movies) resource.getContents().get(0);
		
		for (Movie movie: movies.getMovies()) {
			System.out.println("movie "+movie.getTitle());
			System.out.println("    posters "+movie.getPosters());
			System.out.println("    ratings "+movie.getRatings());
			System.out.println("    releases "+movie.getReleases());
			System.out.println("    castings "+movie.getCastings());	
		}
	}
	
}
