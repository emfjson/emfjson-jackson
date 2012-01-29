package org.eclipselabs.emfjson.couchdb.junit.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.couchdb.junit.support.TestSupport;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.User;
import org.junit.Test;

public class TestStoreDocument extends TestSupport {
		
	@Test
	public void testCreateDatabase() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI(url));
		resource.save(null);
	}
	
	@Test
	public void testStoreDocumentWithOneObject() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI(url));
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("John");
		
		resource.getContents().add(u1);
		
		resource.save(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testStoreDocumentWithTwoRootObjects() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI(url));
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("John");
		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setUserId("2");
		u2.setName("Paul");
		u1.getFriends().add(u2);
		
		resource.getContents().add(u1);
		resource.getContents().add(u2);
		
		resource.save(null);
	}
	
	@Test
	public void testStoreDocumentWithOneObjectAndUpdate() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI(url));
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("John");
		
		resource.getContents().add(u1);
		resource.save(null);
		
		u1.setName("John Smith");
		resource.save(null);
	}
}
