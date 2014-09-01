/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.model.tests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.Address;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.Node;
import org.eclipselabs.emfjson.junit.model.User;
import org.eclipselabs.emfjson.junit.model.support.TestSupport;
import org.junit.Test;

public class TestEmfJsReferences extends TestSupport {

	@Test
	public void testSaveOneObjectWithAttributesNoReferences() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", \"userId\":\"1\", \"name\":\"John\", \"sex\":\"MALE\"}";

		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));

		assertNotNull(resource);

		resource.getContents().add(user);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testSaveTwoObjectsWithAttributesNoReferences() throws IOException {
		String expectedString = 
				"[{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", \"userId\":\"1\", \"name\":\"John\", \"sex\":\"MALE\"}," +
						"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", \"userId\":\"2\", \"name\":\"Paul\", \"sex\":\"MALE\"}]";

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

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		String expectedString = 
				"[{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", "
				+ "\"userId\":\"1\", \"name\":\"John\", \"sex\":\"MALE\", \"uniqueFriend\":{\"$ref\":\"2\"}}," +
						"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", "
						+ "\"userId\":\"2\", \"name\":\"Paul\", \"sex\":\"MALE\"}]";

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
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testSaveTwoObjectsWithAttributesOneReferenceUsingRefType() throws IOException {
		String expectedString = 
				"[{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", "
				+ "\"userId\":\"1\", \"name\":\"John\", \"sex\":\"MALE\", " +
						"\"uniqueFriend\":{\"$ref\":\"2\", \"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\"}}," +
						"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\", "
						+ "\"userId\":\"2\", \"name\":\"Paul\", \"sex\":\"MALE\"}]";

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
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, true);

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadOneObjectWithAttributes() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		asyncLoad("test-load-1.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
				assertFalse(resource.getContents().isEmpty());
				assertEquals(1, resource.getContents().size());

				EObject obj = resource.getContents().get(0);
				assertTrue(obj instanceof User);

				assertEquals("1", ((User) obj).getUserId());
				assertEquals("Paul", ((User) obj).getName());
				finishTest();
			}
		});
		delayTestFinish(500);
	}

	@Test
	public void testLoadTwoObjectsWithAttributesOneContainment() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		asyncLoad("test-load-2.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
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

				finishTest();
			}
		});
		delayTestFinish(500);
	}

	@Test
	public void testLoadTwoObjectsNoReferencesNoEType() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		asyncLoad("test-load-3.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
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

				finishTest();
			}
		});
		delayTestFinish(500);
	}

	@Test
	public void testLoadTwoObjectsOneReference() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		asyncLoad("test-load-4.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
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

				friend = EcoreUtil.resolve(friend, resource);

				assertEquals(obj2, friend);
				assertEquals("2", ((User)friend).getUserId());
				assertEquals("Pierre", ((User)friend).getName());

				finishTest();
			}
		});

		delayTestFinish(500);
	}

	@Test
	public void testLoadThreeObjectsTwoReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		asyncLoad("test-load-5.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
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

				finishTest();
			}
		});

		delayTestFinish(500);
	}

	@Test
	public void testLoadContainmentReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.NODE);

		asyncLoad("test-load-6.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
				assertFalse(resource.getContents().isEmpty());
				assertEquals(1, resource.getContents().size());
				assertTrue(resource.getContents().get(0) instanceof Node);

				Node root = (Node) resource.getContents().get(0);

				assertEquals(1, root.getChild().size());
				assertEquals(1, root.getManyRef().size());

				Node refNode = root.getManyRef().get(0);
				Node childNode = root.getChild().get(0);

				assertEquals("Child 1", childNode.getLabel());
				assertEquals("Child 1", refNode.getLabel());

				assertSame(refNode, childNode);

				finishTest();
			}
		});

		delayTestFinish(500);
	}

	@Test
	public void testLoadMetamodel() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, EcorePackage.Literals.EPACKAGE);

		asyncLoad("model.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());
				assertTrue(resource.getContents().get(0) instanceof EPackage);

				EPackage modelPackage = (EPackage) resource.getContents().get(0);

				assertNotNull(modelPackage);
				assertEquals("model", modelPackage.getName());
				assertEquals("http://www.example.org/model", modelPackage.getNsURI());
				assertEquals("model", modelPackage.getNsPrefix());

				assertEquals(2, modelPackage.getEClassifiers().size());

				EClass library = (EClass) modelPackage.getEClassifier("Library");
				assertNotNull(library);

				assertEquals(2, library.getEStructuralFeatures().size());

				EClass book = (EClass) modelPackage.getEClassifier("Book");
				assertNotNull(book);

				assertEquals(1, book.getEStructuralFeatures().size());
				EAttribute title = (EAttribute) book.getEStructuralFeature("title");
				assertNotNull(title);
				assertEquals(1, title.getLowerBound());
				assertEquals(1, title.getUpperBound());
				assertSame(EcorePackage.Literals.ESTRING, title.getEType());

				EReference books = (EReference) library.getEStructuralFeature("books");
				assertNotNull(books);
				assertEquals(0, books.getLowerBound());
				assertEquals(-1, books.getUpperBound());

				assertSame(book, books.getEType());

				finishTest();
			}
		});

		delayTestFinish(500);
	}

	//	@Test
	//	public void testSaveContainmentHierarchy() throws IOException {
	//		Node n = ModelFactory.eINSTANCE.createNode();
	//		n.setLabel("root");
	//
	//		Node n1 = ModelFactory.eINSTANCE.createNode();
	//		n1.setLabel("n1");
	//		Node n12 = ModelFactory.eINSTANCE.createNode();
	//		n12.setLabel("n12");
	//		Node n123 = ModelFactory.eINSTANCE.createNode();
	//		n123.setLabel("n123");
	//		Node n2 = ModelFactory.eINSTANCE.createNode();
	//		n2.setLabel("n2");
	//		Node n21 = ModelFactory.eINSTANCE.createNode();
	//		n21.setLabel("n21");
	//
	//		n.getChild().add(n1);
	//		n.getChild().add(n2);
	//		n1.getChild().add(n12);
	//		n12.getChild().add(n123);
	//		n2.getChild().add(n21);
	//
	//		n.setTarget(n2);
	//		n123.getManyRef().add(n21);
	//		n123.getManyRef().add(n123);
	//
	//		Resource resource = resourceSet.createResource(URI.createURI("tests/nodes.json"));
	//		resource.getContents().add(n);
	//
	//		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
	//		resource.save(options);
	//	}

	@Test
	public void testLoadOneContainmentHierarchy() throws IOException {
		options.clear();

		asyncLoad("nodes1.json", new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
			@Override
			public void onSuccess(Resource resource) {
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

				finishTest();
			}
		});

		delayTestFinish(500);
	}

	//	@Test
	//	public void testLoadContainmentHierarchy() throws IOException {
	//		options.clear();
	//
	//		asyncLoad("nodes.json", new Callback<Resource>() {
	//			@Override
	//			public void onFailure(Throwable caught) {
	//			}
	//			@Override
	//			public void onSuccess(Resource resource) {
	//
	//				assertFalse(resource.getContents().isEmpty());
	//
	//				assertEquals(1, resource.getContents().size());
	//
	//				Node root = (Node) resource.getContents().get(0);
	//
	//				assertEquals("root", root.getLabel());
	//				assertEquals(2, root.getChild().size());
	//				assertEquals(0, root.getManyRef().size());
	//				assertNotNull(root.getTarget());
	//				assertNull(root.getSource());
	//			}
	//		});
	//	}

	//	@Test
	//	public void testSaveContainmentResolveProxies() throws IOException {
	//		String expectedProxyResource = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//Node\",\"label\":\"1\"}";
	//		String expectedProxyLinkResource = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//Node\",\"label\":\"2\",\"child\":[{\"$ref\":\"proxy.json#/\"}]}";
	//		
	//		Resource resourceProxy = resourceSet.createResource(URI.createURI("proxy.json"));
	//		Resource resourceProxyLink = resourceSet.createResource(URI.createURI("proxyLink.json"));
	//		
	//		Node linked = ModelFactory.eINSTANCE.createNode();
	//		linked.setLabel("1");
	//		resourceProxy.getContents().add(linked);
	//		
	//		Node container = ModelFactory.eINSTANCE.createNode();
	//		container.setLabel("2");
	//		resourceProxyLink.getContents().add(container);
	//		
	//		Node proxy = ModelFactory.eINSTANCE.createNode();
	//		((InternalEObject)proxy).eSetProxyURI(EcoreUtil.getURI(linked));
	//		
	//		container.getChild().add(proxy);
	//		
	//		ByteArrayOutputStream proxyStream = new ByteArrayOutputStream();
	//		resourceProxy.save(proxyStream, options);		
	//		assertEquals(expectedProxyResource, new String(proxyStream.toByteArray()));
	//		
	//		ByteArrayOutputStream proxyLinkStream = new ByteArrayOutputStream();
	//		resourceProxyLink.save(proxyLinkStream, options);		
	//		assertEquals(expectedProxyLinkResource, new String(proxyLinkStream.toByteArray()));
	//	}
	//	
	//	@Test
	//	public void testLoadContainmentResolveProxies() throws IOException {
	//		Resource resource = resourceSet.createResource(URI.createURI("tests/test-proxy-5b.json"));
	//		resource.load(options);	
	//			
	//		assertFalse(resource.getContents().isEmpty());		
	//		assertEquals(1, resource.getContents().size());		
	//		Node root = (Node) resource.getContents().get(0);
	//		
	//		assertEquals("2", root.getLabel());
	//		assertEquals(1, root.getChild().size());
	//		
	//		Node child = root.getChild().get(0);
	//		// Proxy is resolved because GenModel.ContainmentProxy is true
	//		assertFalse(child.eIsProxy());
	//	}
	//	
	//	@Test
	//	public void testLoadObjectWithMapContainment() throws IOException {
	//		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.OBJECT_WITH_MAP);
	//		Resource resource = resourceSet.createResource(URI.createURI("tests/test-map.json"));
	//		resource.load(options);	
	//			
	//		assertFalse(resource.getContents().isEmpty());		
	//		assertEquals(1, resource.getContents().size());		
	//		assertEquals(ModelPackage.Literals.OBJECT_WITH_MAP, resource.getContents().get(0).eClass());
	//		
	//		ObjectWithMap root = (ObjectWithMap) resource.getContents().get(0);
	//		
	//		assertEquals(">= 0.0.0", root.getDependencies().get("build-essential"));
	//		assertEquals(">= 0.0.0", root.getDependencies().get("mysql"));
	//	}

	//	@Test
	//	public void testSaveObjectWithMapContainment() throws IOException {
	//		String expectedString = "{\"dependencies\":{\"build-essential\":\">= 0.0.0\",\"mysql\":\">= 0.0.0\"}}";
	//		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);
	//		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);
	//		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);
	//		
	//		Resource resource = resourceSet.createResource(URI.createURI("tests/test-map-save.json"));
	//		
	//		ObjectWithMap aMap = ModelFactory.eINSTANCE.createObjectWithMap();
	//		aMap.getDependencies().put("build-essential", ">= 0.0.0");
	//		aMap.getDependencies().put("mysql", ">= 0.0.0");
	//		
	//		resource.getContents().add(aMap);
	//		
	//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	//		resource.save(outStream, options);
	//		assertEquals(expectedString, new String(outStream.toByteArray()));
	//	}

}
