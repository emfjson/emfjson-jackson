/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.databind.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.util.*;
import org.emfjson.*;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class ReferenceTest extends TestSupport {

	@Test
	public void testSaveOneObjectWithAttributesNoReferences() throws IOException {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
				.put("userId", "1")
				.put("name", "John")
				.put("sex", "MALE");

		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");

		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));
		assertNotNull(resource);

		resource.getContents().add(user);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testSaveTwoObjectsWithAttributesNoReferences() throws IOException {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("userId", "1")
						.put("name", "John")
						.put("sex", "MALE"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("userId", "2")
						.put("name", "Mary")
						.put("sex", "FEMALE"));

		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Mary");
		user2.setSex(Sex.FEMALE);

		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-2.json"));
		resource.getContents().add(user1);
		resource.getContents().add(user2);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("userId", "1")
						.put("name", "John")
						.put("sex", "MALE")
						.set("uniqueFriend", mapper.createObjectNode()
								.put("$ref", "2")
						))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("userId", "2")
						.put("name", "Mary")
						.put("sex", "FEMALE"));

		User user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		User user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Mary");
		user2.setSex(Sex.FEMALE);

		user1.setUniqueFriend(user2);

		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadWithResolveProxies() throws IOException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
				.put("userId", "2")
				.set("uniqueFriend", mapper.createObjectNode()
						.put("$ref", "http://eclipselabs.org/emfjson/tests/test-load-1.json#1"));

		Resource resource = resourceSet.createResource(URI.createURI("http://resources/second"));
		resource.load(new ByteArrayInputStream(mapper.writeValueAsBytes(data)), options);

		assertFalse(resource.getContents().isEmpty());

		User u2 = (User) resource.getContents().get(0);

		assertNotNull(u2.getUniqueFriend());
		assertFalse(u2.getUniqueFriend().eIsProxy());
	}

	@Test
	public void testLoadWithExternalReference() throws IOException {
		JsonNode firstResource = mapper.createObjectNode()
				.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
				.put("userId", "1");

		JsonNode secondResource = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
				.put("userId", "2")
				.set("uniqueFriend", mapper.createObjectNode()
						.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
						.put("$ref", "http://resources/first#1"));

		Resource first = resourceSet.createResource(URI.createURI("http://resources/first"));
		Resource second = resourceSet.createResource(URI.createURI("http://resources/second"));

		first.load(new ByteArrayInputStream(mapper.writeValueAsBytes(firstResource)), options);
		second.load(new ByteArrayInputStream(mapper.writeValueAsBytes(secondResource)), options);

		assertFalse(first.getContents().isEmpty());
		assertFalse(second.getContents().isEmpty());

		User u1 = (User) first.getContents().get(0);
		User u2 = (User) second.getContents().get(0);

		assertSame(u1, u2.getUniqueFriend());
	}

	@Test
	public void testSaveContainmentResolveProxies() throws IOException {
		JsonNode expectedProxyResource = mapper.createObjectNode()
				.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node")
				.put("label", "1");

		JsonNode expectedProxyLinkResource = mapper.createObjectNode()
				.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node")
				.put("label", "2")
				.set("child", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("$ref", "proxy.json#/")));

		Resource resourceProxy = resourceSet.createResource(URI.createURI("proxy.json"));
		Resource resourceProxyLink = resourceSet.createResource(URI.createURI("proxyLink.json"));

		Node linked = ModelFactory.eINSTANCE.createNode();
		linked.setLabel("1");
		resourceProxy.getContents().add(linked);

		Node container = ModelFactory.eINSTANCE.createNode();
		container.setLabel("2");
		resourceProxyLink.getContents().add(container);

		Node proxy = ModelFactory.eINSTANCE.createNode();
		proxy.eSetProxyURI(EcoreUtil.getURI(linked));

		container.getChild().add(proxy);

		assertEquals(expectedProxyResource, mapper.valueToTree(resourceProxy));
		assertEquals(expectedProxyLinkResource, mapper.valueToTree(resourceProxyLink));
	}

	@Test
	public void testLoadContainmentResolveProxies() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-proxy-5b.json"));
		resource.load(options);

		assertFalse(resource.getContents().isEmpty());
		assertEquals(1, resource.getContents().size());
		Node root = (Node) resource.getContents().get(0);

		assertEquals("2", root.getLabel());
		assertEquals(1, root.getChild().size());

		Node child = root.getChild().get(0);
		// Proxy is resolved because GenModel.ContainmentProxy is true
		assertFalse(child.eIsProxy());
	}

	@Test
	public void testLoadFeatureMapReferences() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-load-feature-map-refs.json"));
		assertNotNull(resource);
		resource.load(options);

		assertEquals(1, resource.getContents().size());
		assertEquals(ModelPackage.Literals.PRIMARY_OBJECT, resource.getContents().get(0).eClass());

		PrimaryObject p = (PrimaryObject) resource.getContents().get(0);

		assertEquals(6, p.getFeatureMapReferenceCollection().size());
		assertEquals(2, p.getFeatureMapReferenceType1().size());
		assertEquals(4, p.getFeatureMapReferenceType2().size());

		TargetObject t1 = p.getFeatureMapReferenceType2().get(0);
		assertEquals("1", t1.getSingleAttribute());

		TargetObject t2 = p.getFeatureMapReferenceType2().get(1);
		assertEquals("2", t2.getSingleAttribute());

		TargetObject t3 = p.getFeatureMapReferenceType2().get(2);
		assertEquals("3", t3.getSingleAttribute());

		TargetObject t4 = p.getFeatureMapReferenceType2().get(3);
		assertEquals("4", t4.getSingleAttribute());

		assertEquals(t1, p.getFeatureMapReferenceType1().get(0));
		assertEquals(t2, p.getFeatureMapReferenceType1().get(1));
	}

	@Test
	public void testLoadThreeObjectsTwoReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);

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

		User friend1 = ((User) obj1).getFriends().get(0);
		assertNotNull(friend1);

		User friend2 = ((User) obj1).getFriends().get(1);
		assertNotNull(friend2);

		assertFalse(friend1.eIsProxy());
		assertFalse(friend2.eIsProxy());

		assertEquals(obj2, friend1);
		assertEquals(obj3, friend2);
	}
	

}