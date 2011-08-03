package com.emfjson.twitter.junit.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import com.emfjson.emf.JsURIHandlerImpl;
import com.emfjson.model.search.Result;
import com.emfjson.model.search.ResultType;
import com.emfjson.model.search.SearchPackage;
import com.emfjson.twitter.Search;

public class TestSearchBasic {

	final Map<String ,Object> options = new HashMap<String, Object>();
	ResourceSet resourceSet;
	
	@Before
	public void tearUp() {
		System.setProperty("http.proxyHost", "www-proxy.ericsson.se");
		System.setProperty("http.proxyPort", "8080");
		
		resourceSet = new ResourceSetImpl();
		
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
	}
	
	@Test
	public void testOneSearch() throws IOException {
		Search search = new Search("emf")
			.count(1)
			.resultType(ResultType.MIXED);
		
		Resource resource = resourceSet.createResource(search.getURI());
		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, SearchPackage.eINSTANCE.getResult());
		
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		
		System.out.println(resource.getContents());
		
		for (EObject o: resource.getContents()) {
			Result result = (Result) o;
			System.out.println(result.getId());
			System.out.println(result.getFromUser());
			System.out.println(result.getText());
			System.out.println(result.getToUser());
			
			System.out.println(result.getMetadata());
			System.out.println(result.getSinceId());
			System.out.println();
		}
//		assertTrue(resource.getContents().size() == 2);
	}
	
}
