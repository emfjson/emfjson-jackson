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
package org.emfjson.jackson.junit.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.EObjects;
import org.junit.Test;

import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.TestSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static org.junit.Assert.*;

public class ContainmentTest extends TestSupport {

	@Test
	public void testSaveOneRootObjectWithAttributes() throws IOException {
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
	public void testSaveTwoRootObjectsWithAttributesNoReferences() throws IOException {
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
	public void testSaveOneObjectWithOneChild() throws JsonProcessingException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
			.put("sex", "MALE")
			.set("address", mapper.createObjectNode()
					.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Address"));

		Resource resource = resourceSet.createResource(URI.createURI("test"));

		User user = ModelFactory.eINSTANCE.createUser();
		Address address = ModelFactory.eINSTANCE.createAddress();
		user.setAddress(address);
		resource.getContents().add(user);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadOneObjectWithOneChild() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//User")
			.set("address", mapper.createObjectNode()
					.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Address"));

		Resource resource = mapper.reader()
			.withAttribute("resourceSet", resourceSet)
			.treeToValue(data, Resource.class);

		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());

		User user = (User) resource.getContents().get(0);

		assertNotNull(user.getAddress());
	}

	@Test
	public void testSaveOneObjectWithManyChildren() throws JsonProcessingException {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node")
			.set("child", mapper.createArrayNode()
				.add(mapper.createObjectNode().put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node"))
				.add(mapper.createObjectNode().put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node"))
				.add(mapper.createObjectNode().put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node")));

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		Node root = ModelFactory.eINSTANCE.createNode();
		root.getChild().add(ModelFactory.eINSTANCE.createNode());
		root.getChild().add(ModelFactory.eINSTANCE.createNode());
		root.getChild().add(ModelFactory.eINSTANCE.createNode());
		resource.getContents().add(root);

		assertEquals(expected, mapper.valueToTree(resource));
	}

	@Test
	public void testLoadOneObjectWithManyChildren() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node")
			.set("child", mapper.createArrayNode()
				.add(mapper.createObjectNode().put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node"))
				.add(mapper.createObjectNode().put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node"))
				.add(mapper.createObjectNode().put("eClass", "http://www.eclipselabs.org/emfjson/junit#//Node")));

		Resource resource = mapper.reader()
			.withAttribute("resourceSet", resourceSet)
			.treeToValue(data, Resource.class);

		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());

		Node node = (Node) resource.getContents().get(0);

		assertEquals(3, node.getChild().size());
	}

	@Test
	public void testSaveProxyContainment() throws IOException {
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
	public void testLoadProxyContainment() throws IOException {
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
	public void testSaveContainmentWithOpposite() {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://emfjson/dynamic/model#//A")
				.put("someKind", "e1")
				.set("containB", mapper.createObjectNode()
						.put("eClass", "http://emfjson/dynamic/model#//B")
						.put("someKind", "e1"));

		EClass classA = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//A"), true);
		EClass classB = (EClass) resourceSet.getEObject(URI.createURI("http://emfjson/dynamic/model#//B"), true);

		EObject a1 = EcoreUtil.create(classA);
		EObject b1 = EcoreUtil.create(classB);
		EObjects.setOrAdd(b1, (EReference) classA.getEStructuralFeature("parent"), a1);

		assertEquals(expected, mapper.valueToTree(a1));
	}

	@Test
	public void testLoadContainmentWithOpposite() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://emfjson/dynamic/model#//A")
				.put("someKind", "e1")
				.set("containB", mapper.createObjectNode()
						.put("eClass", "http://emfjson/dynamic/model#//B")
						.put("someKind", "e1"));

		EObject a1 = mapper.treeToValue(data, EObject.class);
		EObject b1 = (EObject) a1.eGet(a1.eClass().getEStructuralFeature("containB"));

		assertNotNull(b1);
		assertSame(a1, b1.eGet(b1.eClass().getEStructuralFeature("parent")));
	}

}
