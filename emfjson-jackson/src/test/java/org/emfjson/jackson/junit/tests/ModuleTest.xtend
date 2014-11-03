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

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.io.IOException
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.emfjson.jackson.module.EMFModule
import org.emfjson.jackson.resource.JsonResource
import org.junit.Test

import static org.junit.Assert.*

class ModuleTest {

	@Test
	def testSaveWithModule() throws JsonProcessingException {
		val expected = '''
			{
			  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			  "name" : "A"
			}'''

		val mapper = new ObjectMapper()
		mapper.registerModule(new EMFModule())
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true)

		val c = EcoreFactory.eINSTANCE.createEClass()
		c.setName("A")

		assertEquals(expected, mapper.writer().writeValueAsString(c))
	}

	@Test
	def testReadWithModule() throws JsonProcessingException, IOException {
		val data = '''
			{
				"eClass":"http://www.eclipse.org/emf/2002/Ecore#//EClass",
				"name":"A"
			}
		'''

		val mapper = new ObjectMapper()
		mapper.registerModule(new EMFModule())
		val result = mapper.readValue(data, typeof(EObject)) as EClass

		assertEquals("A", result.getName())
	}

	@Test
	def testSaveResourceWithModule() throws JsonProcessingException {
		val expected = '''
			{
			  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			  "name" : "A"
			}'''

		val mapper = new ObjectMapper()
		mapper.registerModule(new EMFModule())
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true)

		val r = new JsonResource
		val c = EcoreFactory.eINSTANCE.createEClass()
		c.setName("A")
		r.contents.add(c)

		assertEquals(expected, mapper.writer().writeValueAsString(r))
	}
	
	@Test
	def void testSaveResourceWithModuleAsTree() throws JsonProcessingException {
		val expected = '''{"eClass":"http://www.eclipse.org/emf/2002/Ecore#//EClass","name":"A"}'''

		val mapper = new ObjectMapper()
		mapper.registerModule(new EMFModule())
		
		val r = new JsonResource
		val c = EcoreFactory.eINSTANCE.createEClass()
		c.setName("A")
		r.contents.add(c)

		val o = mapper.valueToTree(r)
		assertEquals(expected, mapper.writeValueAsString(o))
	}

	@Test
	def testReadResourceWithModule() throws JsonProcessingException, IOException {
		val data = '''
			{
			  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			  "name" : "A"
			}'''

		val mapper = new ObjectMapper()
		mapper.registerModule(new EMFModule())
		val result = mapper.readValue(data, typeof(Resource))

		assertEquals(1, result.contents.size)
		assertEquals(EcorePackage.Literals.ECLASS, result.contents.get(0).eClass)
		assertEquals("A", (result.contents.get(0) as EClass).getName())
	}

}
