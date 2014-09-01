package org.eclipselabs.emfjson.junit.tests

import java.io.ByteArrayOutputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipselabs.emfjson.EMFJs
import org.eclipselabs.emfjson.junit.model.ModelFactory
import org.eclipselabs.emfjson.junit.support.TestSupport
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

		val user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");
		user.setName("John");

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-1.json"));
		assertNotNull(resource);

		resource.getContents().add(user);

		val outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
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

		val user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		val user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-2.json"));
		assertNotNull(resource);

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		val outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
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

		val user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		val user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");

		user1.setUniqueFriend(user2);

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));
		assertNotNull(resource);

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		val outStream = new ByteArrayOutputStream();
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
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

		val user1 = ModelFactory.eINSTANCE.createUser();
		user1.setUserId("1");
		user1.setName("John");

		val user2 = ModelFactory.eINSTANCE.createUser();
		user2.setUserId("2");
		user2.setName("Paul");

		user1.setUniqueFriend(user2);

		val resource = resourceSet.createResource(URI.createURI("tests/test-save-3.json"));
		assertNotNull(resource);

		resource.getContents().add(user1);
		resource.getContents().add(user2);

		val outStream = new ByteArrayOutputStream();
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, true);
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	def testSaveContainmentResolveProxies() throws IOException {
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);

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

		val resourceProxy = resourceSet.createResource(URI.createURI("proxy.json"));
		val resourceProxyLink = resourceSet.createResource(URI.createURI("proxyLink.json"));

		val linked = ModelFactory.eINSTANCE.createNode();
		linked.setLabel("1");
		resourceProxy.getContents().add(linked);

		val container = ModelFactory.eINSTANCE.createNode();
		container.setLabel("2");
		resourceProxyLink.getContents().add(container);

		val proxy = ModelFactory.eINSTANCE.createNode();
		(proxy as InternalEObject).eSetProxyURI(EcoreUtil.getURI(linked));

		container.getChild().add(proxy);

		val proxyStream = new ByteArrayOutputStream();
		resourceProxy.save(proxyStream, options);
		assertEquals(expectedProxyResource, new String(proxyStream.toByteArray()));

		val proxyLinkStream = new ByteArrayOutputStream();
		resourceProxyLink.save(proxyLinkStream, options);
		assertEquals(expectedProxyLinkResource, new String(proxyLinkStream.toByteArray()));
	}

}