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
package org.eclipselabs.emfjson.gwt.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.gwt.junit.support.TestSupport;
import org.eclipselabs.emfjson.junit.model.Address;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.Node;
import org.eclipselabs.emfjson.junit.model.User;
import org.junit.Test;

public class TestEmfJsReferences extends TestSupport {
	
	@Test
	public void testSaveOneObjectWithAttributesNoReferences() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"1\",\"name\":\"John\"}";
		
		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testSaveTwoObjectsWithAttributesNoReferences() throws IOException {
		String expectedString = 
				"[{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"1\",\"name\":\"John\"}," +
				"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"2\",\"name\":\"Paul\"}]";
		
		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");
		
		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-2.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user1);
		resource.getContents().add(user2);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		String expectedString = 
				"[{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"1\",\"name\":\"John\",\"uniqueFriend\":{\"$ref\":\"2\"}}," +
				"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"2\",\"name\":\"Paul\"}]";
		
		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");
		
		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");
		
		user1.setUniqueFriend(user2);
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));
		
		assertNotNull(resource);
		
		resource.getContents().add(user1);
		resource.getContents().add(user2);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}
	
	@Test
	public void testLoadOneObjectWithAttributes() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		Resource resource = resourceSet.createResource(uri("test-load-1.json"));
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		assertEquals(1, resource.getContents().size());
		
		EObject obj = resource.getContents().get(0);
		assertTrue(obj instanceof User);
		
		assertEquals("1", ((User) obj).getUserId());
		assertEquals("Paul", ((User) obj).getName());
	}
	
	@Test
	public void testLoadTwoObjectsWithAttributesOneContainment() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		Resource resource = resourceSet.createResource(uri("test-load-2.json"));
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		assertEquals(1, resource.getContents().size());
		
		EObject obj = resource.getContents().get(0);
		assertTrue(obj instanceof User);
		
		assertEquals("1", ((User) obj).getUserId());
		assertEquals("Paul", ((User) obj).getName());
		
		assertNotNull(((User) obj).getAddress());
		
		Address contained = ((User) obj).getAddress();
		assertEquals("a1", contained.getAddId());
		assertEquals("Paris", contained.getCity());
		assertEquals("la rue", contained.getStreet());
		assertEquals(new Integer(12), contained.getNumber());
	}
	
	@Test
	public void testLoadTwoObjectsNoReferencesNoEType() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		Resource resource = resourceSet.createResource(uri("test-load-3.json"));
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		assertEquals(2, resource.getContents().size());
		
		EObject obj1 = resource.getContents().get(0);
		assertTrue(obj1 instanceof User);
		assertEquals("1", ((User) obj1).getUserId());
		assertEquals("Paul", ((User) obj1).getName());
		
		EObject obj2 = resource.getContents().get(1);
		assertTrue(obj2 instanceof User);
		assertEquals("2", ((User) obj2).getUserId());
		assertEquals("Pierre", ((User) obj2).getName());
	}
	
	@Test
	public void testLoadTwoObjectsOneReference() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		Resource resource = resourceSet.createResource(uri("test-load-4.json"));
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		assertEquals(2, resource.getContents().size());
		
		EObject obj1 = resource.getContents().get(0);
		assertTrue(obj1 instanceof User);
		assertEquals("1", ((User) obj1).getUserId());
		
		EObject obj2 = resource.getContents().get(1);
		assertTrue(obj2 instanceof User);
		assertEquals("2", ((User) obj2).getUserId());
		
		assertFalse(((User) obj1).getFriends().isEmpty());
		
		assertEquals(1, ((User) obj1).getFriends().size());
		
		EObject friend = ((User) obj1).getFriends().get(0);
		assertNotNull(friend);
		
		assertEquals(obj2, friend);
		assertEquals("2", ((User)friend).getUserId());
		assertEquals("Pierre", ((User)friend).getName());
	}
	
	@Test
	public void testLoadThreeObjectsTwoReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		
		Resource resource = resourceSet.createResource(uri("test-load-5.json"));
		assertNotNull(resource);
		
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		assertEquals(3, resource.getContents().size());
		
		EObject obj1 = resource.getContents().get(0);
		assertTrue(obj1 instanceof User);
		assertEquals("1", ((User) obj1).getUserId());
		
		EObject obj2 = resource.getContents().get(1);
		assertTrue(obj2 instanceof User);
		assertEquals("2", ((User) obj2).getUserId());
		
		EObject obj3 = resource.getContents().get(2);
		assertTrue(obj3 instanceof User);
		assertEquals("3", ((User) obj3).getUserId());
		
		assertFalse(((User) obj1).getFriends().isEmpty());
		assertEquals(2, ((User) obj1).getFriends().size());
		
		EObject friend1 = ((User) obj1).getFriends().get(0);
		assertNotNull(friend1);
		EObject friend2 = ((User) obj1).getFriends().get(1);
		assertNotNull(friend2);
		
		assertFalse(friend1.eIsProxy());
		assertFalse(friend2.eIsProxy());
		
		assertEquals(obj2, friend1);
		assertEquals(obj3, friend2);
	}
	
//	@Test
	public void testLoadCompleteMetamodel() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, EcorePackage.eINSTANCE.getEPackage());
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/model.json"));
		assertNotNull(resource);
		
		resource.load(null);
		
		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof EPackage);
		
		EPackage modelPackage = (EPackage) resource.getContents().get(0);
		assertEquals(ModelPackage.eNAME, modelPackage.getName());
		assertEquals(ModelPackage.eNS_URI, modelPackage.getNsURI());
		assertEquals(ModelPackage.eNS_PREFIX, modelPackage.getNsPrefix());
		
		assertEquals(ModelPackage.eINSTANCE.getEClassifiers().size(), modelPackage.getEClassifiers().size());
		
		EObject userClass = modelPackage.getEClassifier(ModelPackage.eINSTANCE.getUser().getName());
		assertNotNull(userClass);
		assertTrue(userClass instanceof EClass);
		assertEquals(ModelPackage.eINSTANCE.getUser().getEAllStructuralFeatures().size(), ((EClass)userClass).getEAllStructuralFeatures().size());
	}
	
	@Test
	public void testSaveContainmentHierarchy() throws IOException {
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
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/nodes.json"));
		System.out.println(resource.getURI());
		resource.getContents().add(n);
		
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		resource.save(options);
	}
	
	@Test
	public void testLoadOneContainmentHierarchy() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/nodes1.json"));
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		
		assertEquals(1, resource.getContents().size());
		
		Node root = (Node) resource.getContents().get(0);
		
		assertEquals("root", root.getLabel());
		assertEquals(1, root.getChild().size());
		assertEquals(0, root.getManyRef().size());
		assertNotNull(root.getTarget());
		assertNull(root.getSource());
		
		Node target = root.getTarget();
		assertEquals("n1", target.getLabel());
		assertEquals(0, target.getChild().size());
		assertEquals(root, target.getSource());
	}
	
	@Test
	public void testLoadContainmentHierarchy() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/nodes.json"));
		resource.load(options);
		
		assertFalse(resource.getContents().isEmpty());
		
		assertEquals(1, resource.getContents().size());
		
		Node root = (Node) resource.getContents().get(0);
		
		assertEquals("root", root.getLabel());
		assertEquals(2, root.getChild().size());
		assertEquals(0, root.getManyRef().size());
		assertNotNull(root.getTarget());
		assertNull(root.getSource());
	}
}
