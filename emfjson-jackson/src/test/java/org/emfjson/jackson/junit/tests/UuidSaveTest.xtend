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

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import java.io.IOException
import java.util.HashMap
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.emfjson.EMFJs
import org.emfjson.common.Constants
import org.emfjson.jackson.junit.model.ModelFactory
import org.emfjson.jackson.junit.model.ModelPackage
import org.emfjson.jackson.junit.support.UuidSupport
import org.emfjson.jackson.module.EMFModule
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

class UuidSaveTest extends UuidSupport {
	
	val ObjectMapper mapper = new ObjectMapper
	var options = new HashMap()

	@Before
	def void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE)
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true)
		mapper.registerModule(new EMFModule(options))
	}
	
	@Test
	def testSerializeOneObjectWithUuid() {
		val resource = createUuidResource("test.xmi")
		val root = ModelFactory.eINSTANCE.createContainer()
		resource.getContents().add(root)

		// Make sure the fragment identifier is a UUID 
		assertTrue(EcoreUtil.getURI(root).fragment().startsWith("_"))

		val node = mapper.valueToTree(root)

		assertNotNull(node)
		assertNotNull(node.get(Constants.EJS_UUID_ANNOTATION))
		assertEquals(uuid(root), uuid(node))
	}

	@Test
	def testSerializeOneRootWithTwoChildHavingOneReference() throws IOException {
		val resource = createUuidResource("test.xmi")

		val root = ModelFactory.eINSTANCE.createContainer()		
		val one = ModelFactory.eINSTANCE.createConcreteTypeOne()
		val two = ModelFactory.eINSTANCE.createConcreteTypeOne()

		one.setName("one")
		two.setName("two")

		one.getRefProperty().add(two)

		root.getElements().add(one)
		root.getElements().add(two)

		resource.getContents().add(root)

		val node = mapper.valueToTree(root)

		assertNotNull(node)
		assertNotNull(node.get(Constants.EJS_UUID_ANNOTATION))
		assertEquals(uuid(root), uuid(node))

		assertTrue(node.get("elements").isArray())

		val elements = node.get("elements") as ArrayNode 
		assertEquals(2, elements.size())
		val node1 = elements.get(0)
		val node2 = elements.get(1)

		assertNotNull(node1.get(Constants.EJS_UUID_ANNOTATION))
		assertEquals(uuid(one), uuid(node1))

		assertNotNull(node2.get(Constants.EJS_UUID_ANNOTATION))
		assertEquals(uuid(two), uuid(node2))

		assertNotNull(node1.get("refProperty"))
		assertNull(node2.get("refProperty"))
		assertTrue(node1.get("refProperty").isArray())

		val refProperty = node1.get("refProperty") as ArrayNode
		assertEquals(1, refProperty.size())

		val ref = refProperty.get(0)
		assertNotNull(ref.get(Constants.EJS_REF_KEYWORD))

		assertEquals(uuid(two), ref.get(Constants.EJS_REF_KEYWORD).asText())
	}

}