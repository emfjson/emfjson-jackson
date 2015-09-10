/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.tests;

import com.google.gwt.core.client.JavaScriptObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import org.emfjson.EMFJs;
import org.emfjson.gwt.junit.model.*;
import org.emfjson.gwt.junit.support.TestSupport;

import java.io.IOException;

public class GwtTestReference extends TestSupport {

	private native JavaScriptObject one() /*-{
		return {
			"eClass":"http://www.eclipselabs.org/emfjson/junit#//User",
			"userId":"1",
			"name":"John"
		}
	}-*/;

	@Test
	public void testSaveOneObjectWithAttributesNoReferences() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));
		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");
		resource.getContents().add(user);

		isSame(one(), resource);
	}

	private native JavaScriptObject second() /*-{
		return [
			{
				"eClass":"http://www.eclipselabs.org/emfjson/junit#//User", 
				"userId":"1", 
				"name":"John"
			},
			{
				"eClass":"http://www.eclipselabs.org/emfjson/junit#//User", 
				"userId":"2", 
				"name":"Paul"
			}
		]
	}-*/;

	@Test
	public void testSaveTwoObjectsWithAttributesNoReferences() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-2.json"));
		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		isSame(second(), resource);
	}

	private native JavaScriptObject third() /*-{
		return [ 
			{
				"eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
				"userId": "1",
				"name": "John",
				"uniqueFriend":{ "$ref" : "2" }
			},
			{
				"eClass": "http://www.eclipselabs.org/emfjson/junit#//User",
				"userId": "2",
				"name": "Paul"
			}
		]
	}-*/;

	@Test
	public void testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));
		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");

		user1.setUniqueFriend(user2);

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);

		isSame(third(), resource);
	}

	@Test
	public void testLoadOneObjectWithAttributes() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		delayTestFinish(500);
		asyncLoad("test-load-1.json", new TestCallback() {
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
	}

	@Test
	public void testLoadTwoObjectsWithAttributesOneContainment() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		delayTestFinish(500);
		asyncLoad("test-load-2.json", new TestCallback() {
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
	}

	@Test
	public void testLoadTwoObjectsNoReferencesNoEType() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		delayTestFinish(500);
		asyncLoad("test-load-3.json", new TestCallback() {
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
	}

	@Test
	public void testLoadTwoObjectsOneReference() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		delayTestFinish(500);
		asyncLoad("test-load-4.json", new TestCallback() {
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
				assertEquals("2", ((User) friend).getUserId());
				assertEquals("Pierre", ((User) friend).getName());

				finishTest();
			}
		});
	}

	@Test
	public void testLoadThreeObjectsTwoReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

		delayTestFinish(500);
		asyncLoad("test-load-5.json", new TestCallback() {
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
	}

	@Test
	public void testLoadContainmentReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.NODE);

		delayTestFinish(500);
		asyncLoad("test-load-6.json", new TestCallback() {
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
	}

	@Test
	public void testLoadMetamodel() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, EcorePackage.Literals.EPACKAGE);

		delayTestFinish(500);
		asyncLoad("model.json", new TestCallback() {
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
	}

	@Test
	public void testLoadOneContainmentHierarchy() throws IOException {
		options.clear();

		delayTestFinish(500);
		asyncLoad("nodes1.json", new TestCallback() {
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
	}

	private native JavaScriptObject containmentProxy() /*-{
		return {
			"eClass": "http://www.eclipselabs.org/emfjson/junit#//Node",
			"label":"1"
		}
	}-*/;

	private native JavaScriptObject container() /*-{
		return {
			"eClass": "http://www.eclipselabs.org/emfjson/junit#//Node",
			"label": "2",
			"child": [ 
				{ "$ref":"proxy.json#/" }
			]
		}
	}-*/;

	@Test
	public void testSaveContainmentResolveProxies() throws IOException {
		Resource resourceProxy = resourceSet.createResource(URI.createURI("proxy.json"));
		Resource resourceProxyLink = resourceSet.createResource(URI.createURI("proxyLink.json"));

		Node linked = ModelFactory.eINSTANCE.createNode();
		linked.setLabel("1");
		resourceProxy.getContents().add(linked);

		Node container = ModelFactory.eINSTANCE.createNode();
		container.setLabel("2");
		resourceProxyLink.getContents().add(container);

		//		Node proxy = ModelFactory.eINSTANCE.createNode();
		//		((InternalEObject)proxy).eSetProxyURI(EcoreUtil.getURI(linked));

		container.getChild().add(linked);

		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);
		isSame(containmentProxy(), resourceProxy);
		isSame(container(), resourceProxyLink);
	}

	@Test
	public void testLoadContainmentResolveProxies() throws IOException {
		asyncLoad("test-proxy-5b.json", new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertFalse(resource.getContents().isEmpty());
				assertEquals(1, resource.getContents().size());
				Node root = (Node) resource.getContents().get(0);

				assertEquals("2", root.getLabel());
				assertEquals(1, root.getChild().size());

				Node child = root.getChild().get(0);

				// Proxy is resolved because GenModel.ContainmentProxy is true
				assertFalse(child.eIsProxy());
			}
		});
	}

}
