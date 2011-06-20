package com.emfjson.junit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.emfjson.junit.rotten.Movie;
import com.emfjson.junit.rotten.RottenPackage;
import com.emfjson.resource.JSONResource;
import com.emfjson.resource.impl.JSONResourceFactoryImpl;

public class BasicTest {

	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(RottenPackage.eNS_URI, RottenPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap().put(JSONResource.APPLICATION_JSON, new JSONResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		
		Map<String ,Object> options = new HashMap<String, Object>();
		options.put(JSONResource.OPTION_ROOT_ELEMENT, RottenPackage.eINSTANCE.getMovie());
		
		Resource resource = resourceSet.createResource(URI.createURI("file:data.json"), JSONResource.APPLICATION_JSON);
		resource.load(options);
		
		Movie movie = (Movie) resource.getContents().get(0);
		System.out.println(movie.getTitle());
		System.out.println(movie.getPosters());
		System.out.println(movie.getRatings());
		System.out.println(movie.getReleases());
		System.out.println(movie.getCastings());
	}
	
}
