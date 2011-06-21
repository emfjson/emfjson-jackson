package com.emfjson.rotten;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.emfjson.model.rotten.Movie;
import com.emfjson.model.rotten.RottenPackage;
import com.emfjson.resource.JSONResource;
import com.emfjson.resource.impl.JSONResourceFactoryImpl;

public class Main {

	
	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(RottenPackage.eNS_URI, RottenPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap()
			.put(JSONResource.APPLICATION_JSON, new JSONResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
	
		Properties properties = new Properties();
		properties.load(new URL("file:src/config.properties").openStream());
		
		final String uri = "http://api.rottentomatoes.com/api/public/v1.0/movies.json";
		
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("q","The+Terminator");
		parameters.put("apikey", properties.get("rotten.apikey").toString());
		parameters.put("page_limit", "1");
		
		final Map<String ,Object> options = new HashMap<String, Object>();
		options.put(JSONResource.OPTION_ROOT_ELEMENT, RottenPackage.eINSTANCE.getMovie());
		options.put(JSONResource.OPTION_URL_PARAMETERS, parameters);
		
		Resource resource = resourceSet.createResource(URI.createURI(uri), JSONResource.APPLICATION_JSON);
		resource.load(options);
		
		Movie movie = (Movie) resource.getContents().get(0);
		System.out.println(movie.getTitle());
		System.out.println(movie.getPosters());
		System.out.println(movie.getRatings());
		System.out.println(movie.getReleases());
		System.out.println(movie.getCastings());
	}
	
}
