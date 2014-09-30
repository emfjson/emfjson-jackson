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
package org.emfjson.jackson.junit.tests

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.emfjson.EMFJs
import org.emfjson.jackson.junit.model.ModelFactory
import org.emfjson.jackson.junit.model.ModelPackage
import org.emfjson.jackson.junit.model.Node
import org.emfjson.jackson.junit.model.PrimaryObject
import org.emfjson.jackson.junit.model.User
import org.emfjson.jackson.junit.support.TestSupport
import org.junit.Test

import static org.junit.Assert.*

class ReferenceTest extends TestSupport {

	override setUp() {
		super.setUp()
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true)
	}

	@Test
	def testSaveOneObjectWithAttributesNoReferences() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "1",
			  "name" : "John",
			  "sex" : "MALE"
			}'''

		val user = ModelFactory.eINSTANCE.createUser()
		user.setUserId("1")
		user.setName("John")

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"))
		assertNotNull(resource)

		resource.getContents().add(user)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testSaveTwoObjectsWithAttributesNoReferences() throws IOException {
		val expectedString = '''
			[ {
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "1",
			  "name" : "John",
			  "sex" : "MALE"
			}, {
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "2",
			  "name" : "Paul",
			  "sex" : "MALE"
			} ]'''

		val user1 = ModelFactory.eINSTANCE.createUser()
		user1.setUserId("1")
		user1.setName("John")

		val user2 = ModelFactory.eINSTANCE.createUser()
		user2.setUserId("2")
		user2.setName("Paul")

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-2.json"))
		assertNotNull(resource)

		resource.getContents().add(user1)
		resource.getContents().add(user2)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testSaveTwoObjectsWithAttributesOneReference() throws IOException {
		val expectedString = '''
			[ {
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "1",
			  "name" : "John",
			  "sex" : "MALE",
			  "uniqueFriend" : {
			    "$ref" : "2"
			  }
			}, {
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "2",
			  "name" : "Paul",
			  "sex" : "MALE"
			} ]'''

		val user1 = ModelFactory.eINSTANCE.createUser()
		user1.setUserId("1")
		user1.setName("John")

		val user2 = ModelFactory.eINSTANCE.createUser()
		user2.setUserId("2")
		user2.setName("Paul")

		user1.setUniqueFriend(user2)

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"))
		assertNotNull(resource)

		resource.getContents().add(user1)
		resource.getContents().add(user2)

		val outStream = new ByteArrayOutputStream()
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false)
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testSaveTwoObjectsWithAttributesOneReferenceUsingRefType() throws IOException {
		val expectedString = '''
			[ {
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "1",
			  "name" : "John",
			  "sex" : "MALE",
			  "uniqueFriend" : {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			    "$ref" : "2"
			  }
			}, {
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "2",
			  "name" : "Paul",
			  "sex" : "MALE"
			} ]'''

		val user1 = ModelFactory.eINSTANCE.createUser()
		user1.setUserId("1")
		user1.setName("John")

		val user2 = ModelFactory.eINSTANCE.createUser()
		user2.setUserId("2")
		user2.setName("Paul")

		user1.setUniqueFriend(user2)

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"))
		assertNotNull(resource)

		resource.getContents().add(user1)
		resource.getContents().add(user2)

		val outStream = new ByteArrayOutputStream()
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, true)
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testLoadWithResolveProxies() throws IOException {
		options.put(EMFJs.OPTION_RESOLVE_PROXY, true)

		val data ='''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "2",
			  "uniqueFriend" : {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			    "$ref" : "http://eclipselabs.org/emfjson/tests/test-load-1.json#1"
			  }
			  
			 }
		'''

		val resource = resourceSet.createResource(URI.createURI("http://resources/second"))
		resource.load(new ByteArrayInputStream(data.bytes), options)
		
		assertFalse(resource.contents.empty)

		val u2 = resource.contents.get(0) as User

		assertNotNull(u2.uniqueFriend)
		assertFalse(u2.uniqueFriend.eIsProxy)
	}

	@Test
	def testLoadWithExternalReference() throws IOException {
		val firstResource ='''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "1"
			 }
		'''
		val secondResource ='''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			  "userId" : "2",
			  "uniqueFriend" : {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//User",
			    "$ref" : "http://resources/first#1"
			  }
			  
			 }
		'''

		val first = resourceSet.createResource(URI.createURI("http://resources/first"))
		val second = resourceSet.createResource(URI.createURI("http://resources/second"))

		first.load(new ByteArrayInputStream(firstResource.bytes), options)
		second.load(new ByteArrayInputStream(secondResource.bytes), options)

		assertFalse(first.contents.empty)
		assertFalse(second.contents.empty)

		val u1 = first.contents.get(0) as User
		val u2 = second.contents.get(0) as User

		assertEquals(u1, u2.uniqueFriend)
	}

	@Test
	def testSaveContainmentResolveProxies() throws IOException {
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false)

		val expectedProxyResource = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//Node",
			  "label" : "1"
			}'''

		val expectedProxyLinkResource = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//Node",
			  "label" : "2",
			  "child" : [ {
			    "$ref" : "proxy.json#/"
			  } ]
			}''' 

		val resourceProxy = resourceSet.createResource(URI.createURI("proxy.json"))
		val resourceProxyLink = resourceSet.createResource(URI.createURI("proxyLink.json"))

		val linked = ModelFactory.eINSTANCE.createNode()
		linked.setLabel("1")
		resourceProxy.getContents().add(linked)

		val container = ModelFactory.eINSTANCE.createNode()
		container.setLabel("2")
		resourceProxyLink.getContents().add(container)

		val proxy = ModelFactory.eINSTANCE.createNode()
		(proxy as InternalEObject).eSetProxyURI(EcoreUtil.getURI(linked))

		container.getChild().add(proxy)

		val proxyStream = new ByteArrayOutputStream()
		resourceProxy.save(proxyStream, options)
		assertEquals(expectedProxyResource, new String(proxyStream.toByteArray()))

		val proxyLinkStream = new ByteArrayOutputStream()
		resourceProxyLink.save(proxyLinkStream, options)
		assertEquals(expectedProxyLinkResource, new String(proxyLinkStream.toByteArray()))
	}

	@Test
	def  testLoadContainmentResolveProxies() throws IOException {
		val resource = resourceSet.createResource(uri("test-proxy-5b.json"))
		resource.load(options)

		assertFalse(resource.getContents().isEmpty())
		assertEquals(1, resource.getContents().size())
		val root = resource.getContents().get(0) as Node

		assertEquals("2", root.getLabel())
		assertEquals(1, root.getChild().size())

		val child = root.getChild().get(0)
		// Proxy is resolved because GenModel.ContainmentProxy is true
		assertFalse(child.eIsProxy())
	}

	@Test
	def testLoadFeatureMapReferences() throws IOException {
		val resource = resourceSet.createResource(uri("test-load-feature-map-refs.json"))
		assertNotNull(resource)
		resource.load(options)

		assertEquals(1, resource.getContents().size())
		assertEquals(ModelPackage.Literals.PRIMARY_OBJECT, resource.getContents().get(0).eClass())

		val p = resource.getContents().get(0) as PrimaryObject

		assertEquals(6, p.getFeatureMapReferenceCollection().size())
		assertEquals(2, p.getFeatureMapReferenceType1().size())
		assertEquals(4, p.getFeatureMapReferenceType2().size())

		val t1 = p.getFeatureMapReferenceType2().get(0)
		assertEquals("1", t1.getSingleAttribute())

		val t2 = p.getFeatureMapReferenceType2().get(1) 
		assertEquals("2", t2.getSingleAttribute())
		
		val t3 = p.getFeatureMapReferenceType2().get(2) 
		assertEquals("3", t3.getSingleAttribute())
		
		val t4 = p.getFeatureMapReferenceType2().get(3) 
		assertEquals("4", t4.getSingleAttribute())

		assertEquals(t1, p.getFeatureMapReferenceType1().get(0))
		assertEquals(t2, p.getFeatureMapReferenceType1().get(1))
	}

	@Test
	def testLoadThreeObjectsTwoReferences() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER)

		val resource = resourceSet.createResource(uri("test-load-5.json"))
		assertNotNull(resource)

		resource.load(options)

		assertFalse(resource.getContents().isEmpty())
		assertEquals(3, resource.getContents().size())

		val obj1 = resource.getContents().get(0)
		assertTrue(obj1 instanceof User)
		assertEquals("1", (obj1 as User).getUserId())

		val obj2 = resource.getContents().get(1)
		assertTrue(obj2 instanceof User)
		assertEquals("2", (obj2 as User).getUserId())

		val obj3 = resource.getContents().get(2)
		assertTrue(obj3 instanceof User)
		assertEquals("3", (obj3 as User).getUserId())

		assertFalse((obj1 as User).getFriends().isEmpty())
		assertEquals(2, (obj1 as User).getFriends().size())

		val friend1 = (obj1 as User).getFriends().get(0)
		assertNotNull(friend1)

		val friend2 = (obj1 as User).getFriends().get(1)
		assertNotNull(friend2)

		assertFalse(friend1.eIsProxy())
		assertFalse(friend2.eIsProxy())

		assertEquals(obj2, friend1)
		assertEquals(obj3, friend2)
	}
	

}