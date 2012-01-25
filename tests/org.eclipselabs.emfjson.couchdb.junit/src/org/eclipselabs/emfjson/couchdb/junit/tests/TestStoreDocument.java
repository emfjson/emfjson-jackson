package org.eclipselabs.emfjson.couchdb.junit.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.couchdb.CouchDBHandler;
import org.eclipselabs.emfjson.couchdb.junit.model.ModelFactory;
import org.eclipselabs.emfjson.couchdb.junit.model.User;
import org.junit.Before;
import org.junit.Test;

public class TestStoreDocument {

	protected ResourceSet resourceSet;
	private final String url = "http://127.0.0.1:5984/emfjson_model/users/";
	
	@Before
	public void tearUp() {
		resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIHandlers().add(0, new CouchDBHandler());
	}
	
	@Test
	public void testStoreDocumentWithOneObject() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI(url));
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.set_id("1");
		u1.setName("John");
		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.set_id("2");
		u2.setName("Paul");
		u1.getKnows().add(u2);
		
		resource.getContents().add(u1);
		resource.getContents().add(u2);
		
		resource.save(null);
	}
}
