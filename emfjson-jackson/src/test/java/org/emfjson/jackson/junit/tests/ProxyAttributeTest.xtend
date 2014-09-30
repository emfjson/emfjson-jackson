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

import java.io.IOException
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.InternalEList
import org.emfjson.EMFJs
import org.emfjson.jackson.junit.model.ModelPackage
import org.emfjson.jackson.junit.model.Node
import org.emfjson.jackson.junit.model.User
import org.emfjson.jackson.junit.support.TestSupport
import org.junit.Test

import static org.junit.Assert.*

class ProxyAttributeTest extends TestSupport {
	
	@Test
	def testOptionProxyAttributesWithID() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true)
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER)
		
		val resource = resourceSet.createResource(uri("test-proxy-1.json"))
		resource.load(options)

		val u1 = resource.getContents().get(0) as User
		assertNotNull(u1)
		assertFalse(u1.eIsProxy())

		assertEquals(1, u1.getFriends().size())

		val u2 = u1.getFriends().get(0)
		assertFalse(u2.eIsProxy())

		assertEquals("2", u2.getUserId())
		assertEquals("Pierre", u2.getName())

		assertNotNull(u1.getUniqueFriend())
		assertFalse(u1.getUniqueFriend().eIsProxy())

		assertEquals("3", u1.getUniqueFriend().getUserId())
		assertEquals("Paul", u1.getUniqueFriend().getName())
	}

	@Test
	def testOptionProxyAttributes() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true)

		val resource = resourceSet.createResource(uri("test-proxy-3.json"))
		resource.load(options)

		val node = resource.getContents().get(0) as Node
		assertNotNull(node)

		val proxies = node.eGet(ModelPackage.Literals.NODE__MANY_REF, false) as InternalEList<?>
		assertEquals(3, proxies.size())

		assertFalse((proxies.basicGet(0) as InternalEObject).eIsProxy())
		assertFalse((proxies.basicGet(1) as InternalEObject).eIsProxy())
		assertFalse((proxies.basicGet(2) as InternalEObject).eIsProxy())

		assertEquals("2", (proxies.basicGet(0) as Node).getLabel())
		assertEquals("21", (proxies.basicGet(1) as Node).getLabel())
		assertEquals("3", (proxies.basicGet(2) as Node).getLabel())

		assertNotNull(node.getSource())

		assertFalse(node.getSource().eIsProxy())
		assertEquals("2121", node.getSource().getLabel())

		val node2 = resource.getContents().get(1) as Node
		assertNotNull(node2)

		val proxies2 = node2.eGet(ModelPackage.Literals.NODE__MANY_REF, false) as InternalEList<?>
		assertEquals(2, proxies2.size())

		assertFalse((proxies2.basicGet(0) as InternalEObject).eIsProxy())
		assertFalse((proxies2.basicGet(1) as InternalEObject).eIsProxy())

		assertEquals("311", (proxies2.basicGet(0) as Node).getLabel())
		assertEquals("3112", (proxies2.basicGet(1) as Node).getLabel())
	}

}