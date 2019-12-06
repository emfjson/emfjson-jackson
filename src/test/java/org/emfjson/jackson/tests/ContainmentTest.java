/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */
package org.emfjson.jackson.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.model.impl.PhysicalNodeImpl;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.junit.Assert.*;

public class ContainmentTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveOneRootObjectWithAttributes() throws IOException {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.put("userId", "1")
				.put("name", "John");

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
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
						.put("userId", "1")
						.put("name", "John"))
				.add(mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//User")
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
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.set("address", mapper.createObjectNode());

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
				.put("eClass", "http://www.emfjson.org/jackson/model#//User")
				.set("address", mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//Address"));

		Resource resource = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());

		User user = (User) resource.getContents().get(0);

		assertNotNull(user.getAddress());
	}

	@Test
	public void testSaveOneObjectWithManyChildren() throws JsonProcessingException {
		JsonNode expected = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//Node")
				.set("child", mapper.createArrayNode()
						.add(mapper.createObjectNode())
						.add(mapper.createObjectNode())
						.add(mapper.createObjectNode()));

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
				.put("eClass", "http://www.emfjson.org/jackson/model#//Node")
				.set("child", mapper.createArrayNode()
						.add(mapper.createObjectNode())
						.add(mapper.createObjectNode())
						.add(mapper.createObjectNode()));

		Resource resource = mapper.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());

		Node node = (Node) resource.getContents().get(0);

		assertEquals(3, node.getChild().size());
	}

	@Test
	public void testSaveProxyContainment() throws IOException {
		// proxy.json
		JsonNode expectedProxyResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//Node")
				.put("label", "1");

		// proxyLink.json
		JsonNode expectedProxyLinkResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//Node")
				.put("label", "2")
				.set("child", mapper.createArrayNode()
						.add(mapper.createObjectNode()
								.put("eClass", "http://www.emfjson.org/jackson/model#//Node")
								.put("$ref", "proxy.json#/")));

		Resource resourceProxy = resourceSet.createResource(URI.createURI("proxy.json"));
		Resource resourceProxyLink = resourceSet.createResource(URI.createURI("proxyLink.json"));

		Node linked = ModelFactory.eINSTANCE.createNode();
		linked.setLabel("1");
		resourceProxy.getContents().add(linked);

		Node container = ModelFactory.eINSTANCE.createNode();
		container.setLabel("2");
		container.getChild().add(linked);
		resourceProxyLink.getContents().add(container);

		assertSame(resourceProxy, linked.eResource());
		assertSame(container, linked.eContainer());
		assertSame(ModelPackage.Literals.NODE__CHILD, linked.eContainmentFeature());
		assertTrue(ModelPackage.Literals.NODE__CHILD.isContainment());
		assertTrue(ModelPackage.Literals.NODE__CHILD.isResolveProxies());
		assertSame(resourceProxyLink, container.eResource());

		assertEquals(expectedProxyResource, mapper.valueToTree(resourceProxy));
		assertEquals(expectedProxyLinkResource, mapper.valueToTree(resourceProxyLink));
	}

	@Test
	public void testSaveProxyRootContainmentWithOppositeReference() throws IOException {
		JsonNode expectedTargetResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//TargetObject")
				.put("singleAttribute", "Foo");

		JsonNode expectedSourceResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
				.put("name", "TheSource")
				.set("singleContainmentReferenceProxies", mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//TargetObject")
						.put("$ref", "target.json#/"));

		Resource resourceTarget = resourceSet.createResource(URI.createURI("target.json"));
		TargetObject target = ModelFactory.eINSTANCE.createTargetObject();
		target.setSingleAttribute("Foo");
		resourceTarget.getContents().add(target);

		Resource resourceSource = resourceSet.createResource(URI.createURI("source.json"));
		PrimaryObject source = ModelFactory.eINSTANCE.createPrimaryObject();
		source.setName("TheSource");
		resourceSource.getContents().add(source);

		// setting the opposite reference will set the containment
		target.setSingleReferenceNotResolveProxies(source);

		assertSame(source, target.eContainer());
		assertSame(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, target.eContainingFeature());
		assertSame(resourceTarget, target.eResource());

		assertEquals(expectedTargetResource, mapper.valueToTree(resourceTarget));
		assertEquals(expectedSourceResource, mapper.valueToTree(resourceSource));
	}

	@Test
	public void testSaveProxies() throws IOException {
		JsonNode expectedTargetResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//TargetObject")
				.set("manyReferences", mapper.createArrayNode()
						.add(
								mapper.createObjectNode()
										.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
										.put("$ref", "source.json#/")));

		JsonNode expectedSourceResource = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//PrimaryObject")
				.put("name", "TheSource")
				.set("singleContainmentReferenceNoProxies", mapper.createObjectNode()
						.put("eClass", "http://www.emfjson.org/jackson/model#//TargetObject")
						.put("$ref", "target.json#/"));

		Resource resourceTarget = resourceSet.createResource(URI.createURI("target.json"));
		Resource resourceSource = resourceSet.createResource(URI.createURI("source.json"));

		TargetObject target = ModelFactory.eINSTANCE.createTargetObject();
		resourceTarget.getContents().add(target);

		PrimaryObject source = ModelFactory.eINSTANCE.createPrimaryObject();
		source.setName("TheSource");
		resourceSource.getContents().add(source);

		PrimaryObject sourceProxy = ModelFactory.eINSTANCE.createPrimaryObject();
		((InternalEObject) sourceProxy).eSetProxyURI(EcoreUtil.getURI(source));
		target.getManyReferences().add(sourceProxy);

		TargetObject targetProxy = ModelFactory.eINSTANCE.createTargetObject();
		((InternalEObject) targetProxy).eSetProxyURI(EcoreUtil.getURI(target));
		source.setSingleContainmentReferenceNoProxies(targetProxy);

		assertSame(source, targetProxy.eContainer());
		assertSame(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, targetProxy.eContainingFeature());
		assertSame(resourceTarget, target.eResource());

		assertEquals(expectedTargetResource, mapper.valueToTree(resourceTarget));
		assertEquals(expectedSourceResource, mapper.valueToTree(resourceSource));
	}

	@Test
	public void testLoadProxyRootContainmentWithOppositeReference() throws IOException {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-proxy-6.json"), true);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof PrimaryObject);

		PrimaryObject source = (PrimaryObject) resource.getContents().get(0);

		assertEquals("TheSource", source.getName());
		assertTrue(source.eIsSet(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES));

		TargetObject target = source.getSingleContainmentReferenceProxies();
		assertFalse(target.eIsProxy());

		assertSame(source, target.getSingleReferenceNotResolveProxies());
		assertSame(source, target.eContainer());
		assertSame(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, target.eContainingFeature());
		assertNotSame(source.eResource(), target.eResource());
	}

	@Test
	public void testLoadResolvingProxyContainment() throws IOException {
		Resource resource = resourceSet.getResource(
				URI.createURI("src/test/resources/tests/test-proxy-5b.json"), true);

		assertFalse(resource.getContents().isEmpty());
		assertEquals(1, resource.getContents().size());

		Node root = (Node) resource.getContents().get(0);

		assertEquals("2", root.getLabel());
		assertEquals(1, root.getChild().size());

		Node child = root.getChild().get(0);
		// Proxy is resolved because GenModel.ContainmentProxy is true
		assertFalse(child.eIsProxy());

		assertNotSame(root.eResource(), child.eResource());
		assertEquals("1", child.getLabel());
	}

	@Test
	public void testLoadResolvingProxyContainmentWithAbstract() throws IOException {
		Resource resource = resourceSet.getResource(
				URI.createURI("src/test/resources/tests/test-proxy-7b.json"), true);

		assertFalse(resource.getContents().isEmpty());
		assertEquals(1, resource.getContents().size());

		PhysicalNodeImpl root = (PhysicalNodeImpl) resource.getContents().get(0);
		assertEquals("2", root.getLabel());
		assertEquals(1, root.getChild().size());

		AbstractNode child = root.getChild().get(0);

		assertTrue(child.eIsProxy());
		assertSame(root.eResource(), child.eResource());

		EObject resolve = EcoreUtil.resolve(child, resourceSet);
		assertNotSame(resolve.eResource(), root.eResource());
	}

	@Test
	public void testXmi1() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());

		{
			Resource x1 = resourceSet.createResource(URI.createURI("src/test/resources/xmi/test3.xmi"));
			Node n1 = ModelFactory.eINSTANCE.createNode();
			Node n2 = ModelFactory.eINSTANCE.createNode();
			Node n3 = ModelFactory.eINSTANCE.createNode();

			n1.getChild().add(n2);
			n1.getChild().add(n3);

			n2.setTarget(n3);
			n2.getManyRef().add(n3);

			x1.getContents().add(n1);
			x1.save(null);
		}
		{
			Resource x1 = resourceSet.createResource(URI.createFileURI("src/test/resources/xmi/test4.xmi"));
			Resource x2 = resourceSet.createResource(URI.createFileURI("src/test/resources/xmi/test5.xmi"));
			Resource x3 = resourceSet.createResource(URI.createFileURI("src/test/resources/xmi/test6.xmi"));

			User n1 = ModelFactory.eINSTANCE.createUser();
			n1.setUserId("1");

			User n2 = ModelFactory.eINSTANCE.createUser();
			n2.setUserId("2");

			User n3 = ModelFactory.eINSTANCE.createUser();
			n3.setUserId("3");

			n1.setUniqueFriend(n2);
			n1.getFriends().add(n2);
			n1.getFriends().add(n3);

			x1.getContents().add(n1);
			x2.getContents().add(n2);
			x3.getContents().add(n3);

			x1.save(null);
			x2.save(null);
			x3.save(null);
		}
	}

	//	@Test
	public void testXmi() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());

		Resource x1 = resourceSet.createResource(URI.createURI("src/test/resources/xmi/test1.xmi"));
		Resource x2 = resourceSet.createResource(URI.createURI("src/test/resources/xmi/test2.xmi"));

		PhysicalNode p1 = ModelFactory.eINSTANCE.createPhysicalNode();
		p1.setLabel("p1");

		x1.getContents().add(p1);

		PhysicalNode p2 = ModelFactory.eINSTANCE.createPhysicalNode();
		p2.setLabel("p2");

		x2.getContents().add(p2);

		InternalEObject proxy = (InternalEObject) ModelFactory.eINSTANCE.createPhysicalNode();
		proxy.eSetProxyURI(EcoreUtil.getURI(p2));
		p1.getChild().add((AbstractNode) proxy);

		x2.save(null);
		x1.save(null);
	}

	//	@Test
	public void testLoadXmi() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());

		Resource x1 = resourceSet.getResource(URI.createURI("src/test/resources/xmi/test1.xmi"), true);

		assertEquals(1, x1.getContents().size());

		PhysicalNode p1 = (PhysicalNode) x1.getContents().get(0);

		AbstractNode p2 = p1.getChild().get(0);
		assertTrue(p2.eIsProxy());
		assertSame(p2.eResource(), p1.eResource());

		EObject resolve = EcoreUtil.resolve(p2, resourceSet);
		assertNotSame(resolve.eResource(), p1.eResource());
	}

}
