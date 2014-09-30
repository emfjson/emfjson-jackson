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
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EPackage
import org.emfjson.EMFJs
import org.emfjson.jackson.junit.model.Container
import org.emfjson.jackson.junit.model.ModelFactory
import org.emfjson.jackson.junit.model.ModelPackage
import org.emfjson.jackson.junit.support.UuidSupport
import org.emfjson.jackson.map.JacksonObjectMapper
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

class UuidLoadTest extends UuidSupport {
	
	var JacksonObjectMapper mapper
	var Map<Object, Object> options = new HashMap()

	@Before
	def void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE)

		mapper = new JacksonObjectMapper()
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true)
		options.put(EMFJs.OPTION_USE_UUID, true)
	}

	@Test
	def testUuidBehavior() throws IOException {
		val in = createUuidResource("in.xmi")
		val root = ModelFactory.eINSTANCE.createContainer()
		in.getContents().add(root)
		val outStream = new ByteArrayOutputStream()
		in.save(outStream, options)

		val inStream = new ByteArrayInputStream(outStream.toByteArray())
		val out = createUuidResource("out.xmi")
		out.load(inStream, options)

		assertEquals(1, out.getContents().size())
		val output = out.getContents().get(0)

		assertEquals(uuid(root), uuid(output))
	}

	@Test
	def testDeserializeOneObject() {
		val resource = createUuidResource("test.xmi")
		val root = ModelFactory.eINSTANCE.createContainer()
		resource.getContents().add(root)

		val node = mapper.toObject(root, options)
		val result = mapper.fromObject(node, createJsUuidResource("result.json"), options)

		assertNotNull(result)
		assertEquals(uuid(root), uuid(result))
	}

	@Test
	def testDeserializeOneObjectWithTwoChildHavingOneReference() {
		val resource = createUuidResource("test.xmi")
		val root = ModelFactory.eINSTANCE.createContainer()
		val one = ModelFactory.eINSTANCE.createConcreteTypeOne()
		one.setName("one")
		val two = ModelFactory.eINSTANCE.createConcreteTypeOne()
		two.setName("two")

		one.getRefProperty().add(two)
		root.getElements().add(one)
		root.getElements().add(two)
		resource.getContents().add(root)

		val node = mapper.toObject(root, options)
		val result = mapper.fromObject(node, createJsUuidResource("result.json"), options)

		assertNotNull(result)
		assertEquals(uuid(root), uuid(result))
		assertEquals(ModelPackage.Literals.CONTAINER, result.eClass())

		val resultContainer = result as Container
		assertEquals(2, resultContainer.getElements().size())

		val firstResult = resultContainer.getElements().get(0)
		val secondResult = resultContainer.getElements().get(1)

		assertEquals("one", firstResult.getName())
		assertEquals(uuid(one), uuid(firstResult))
		assertEquals("two", secondResult.getName())
		assertEquals(uuid(two), uuid(secondResult))

		assertEquals(1, firstResult.getRefProperty().size())
		assertEquals(uuid(secondResult), uuid(firstResult.getRefProperty().get(0)))
		assertEquals(secondResult, firstResult.getRefProperty().get(0))
	}

}