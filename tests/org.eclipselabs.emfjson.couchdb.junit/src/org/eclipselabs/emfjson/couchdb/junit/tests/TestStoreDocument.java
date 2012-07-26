package org.eclipselabs.emfjson.couchdb.junit.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.couchdb.junit.support.TestSupport;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.Node;
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
	
	@Test
	public void testStoreHierarchyOfObjects() throws IOException {
		Node n = ModelFactory.eINSTANCE.createNode();
		n.setLabel("root");
		
		Node n1 = ModelFactory.eINSTANCE.createNode();
		n1.setLabel("n1");
		Node n12 = ModelFactory.eINSTANCE.createNode();
		n12.setLabel("n12");
		Node n123 = ModelFactory.eINSTANCE.createNode();
		n123.setLabel("n123");
		Node n2 = ModelFactory.eINSTANCE.createNode();
		n2.setLabel("n2");
		Node n21 = ModelFactory.eINSTANCE.createNode();
		n21.setLabel("n21");
		
		n.getChild().add(n1);
		n.getChild().add(n2);
		n1.getChild().add(n12);
		n12.getChild().add(n123);
		n2.getChild().add(n21);
		
		n.setTarget(n2);
		n123.getManyRef().add(n21);
		n123.getManyRef().add(n123);
		
		Resource resource = resourceSet.createResource(baseURI.appendSegment("nodes"));
		System.out.println(resource.getURI());
		resource.getContents().add(n);
		
		resource.save(null);
	}
	
	@Test
	public void testCreateStoreDocumentNotExistant() throws IOException {
		Resource resource = resourceSet.createResource(baseURI.appendSegment("emfjson_test").appendSegment("test_create"));
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("John");
		
		resource.getContents().add(u1);
		
		resource.save(null);
	}
	
	@Test
	public void testCreateStoreDocumentDatabaseNotExistant() throws IOException {
		Resource resource = resourceSet.createResource(baseURI.appendSegment("emfjson_not_exist").appendSegment("test_create"));
		
		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");
		u1.setName("John");
		
		resource.getContents().add(u1);
		
		resource.save(null);
	}
}
