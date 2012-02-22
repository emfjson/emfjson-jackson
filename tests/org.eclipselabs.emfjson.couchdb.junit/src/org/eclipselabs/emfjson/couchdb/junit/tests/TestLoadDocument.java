package org.eclipselabs.emfjson.couchdb.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.couchdb.junit.support.TestSupport;
import org.eclipselabs.emfjson.junit.model.Node;
import org.junit.Test;

public class TestLoadDocument extends TestSupport {
	
	@Test
	public void testLoadDocumentByID() throws IOException {
		Resource resource = resourceSet.createResource(
				baseURI.appendSegment("nodes").appendSegment("fc4dc3af46a4d5a2a379881926002911"));
		
		assertNotNull(resource);
		
		resource.load(null);
		
		assertEquals(1, resource.getContents().size());
		
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Node);
		
		Node rootNode = (Node) root;
		assertEquals("root", rootNode.getLabel());
		
		assertEquals(2, rootNode.getChild().size());
		
		Node first = rootNode.getChild().get(0);
		Node second = rootNode.getChild().get(1);
		
		assertEquals("n1", first.getLabel());
		assertEquals("n2", second.getLabel());
		
		assertNotNull(rootNode.getTarget());
		assertEquals(second, rootNode.getTarget());
		assertEquals(rootNode, second.getSource());
	}
}
