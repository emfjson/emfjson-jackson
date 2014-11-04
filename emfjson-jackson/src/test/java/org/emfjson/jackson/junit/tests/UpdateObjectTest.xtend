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
import org.eclipse.emf.ecore.EcoreFactory
import org.emfjson.jackson.update.ObjectUpdater
import org.junit.Test

import static org.junit.Assert.*
import org.emfjson.jackson.resource.JsonResource

class UpdateObjectTest {

	@Test
	def testUpdateSingleObject() throws JsonProcessingException {
		val data = '''
			{
			  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			  "name" : "B"
			}'''

		val r = new JsonResource
		val c = EcoreFactory.eINSTANCE.createEClass()
		c.setName("A")
		r.contents.add(c)

		new ObjectUpdater().update(c, data, null)

		assertEquals("B", c.name)
	}

}