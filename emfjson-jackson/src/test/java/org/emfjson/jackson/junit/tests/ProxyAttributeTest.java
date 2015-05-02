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

import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.util.*;
import org.emfjson.*;
import org.emfjson.jackson.junit.model.*;
import org.emfjson.jackson.junit.support.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class ProxyAttributeTest extends TestSupport {
	
	@Test
	public void testOptionProxyAttributesWithID() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true);
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);
		
		Resource resource = resourceSet.createResource(uri("test-proxy-1.json"));
		resource.load(options);

		User u1 = (User) resource.getContents().get(0);
		assertNotNull(u1);
		assertFalse(u1.eIsProxy());

		assertEquals(1, u1.getFriends().size());

		User u2 = u1.getFriends().get(0);
		assertFalse(u2.eIsProxy());

		assertEquals("2", u2.getUserId());
		assertEquals("Pierre", u2.getName());

		assertNotNull(u1.getUniqueFriend());
		assertFalse(u1.getUniqueFriend().eIsProxy());

		assertEquals("3", u1.getUniqueFriend().getUserId());
		assertEquals("Paul", u1.getUniqueFriend().getName());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testOptionProxyAttributes() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true);

		Resource resource = resourceSet.createResource(uri("test-proxy-3.json"));
		resource.load(options);

		Node node = (Node) resource.getContents().get(0);
		assertNotNull(node);

		InternalEList<Node> proxies = (InternalEList<Node>) node.eGet(ModelPackage.Literals.NODE__MANY_REF, false);
		assertEquals(3, proxies.size());

		assertFalse(proxies.basicGet(0).eIsProxy());
		assertFalse(proxies.basicGet(1).eIsProxy());
		assertFalse(proxies.basicGet(2).eIsProxy());

		assertEquals("2", proxies.basicGet(0).getLabel());
		assertEquals("21", proxies.basicGet(1).getLabel());
		assertEquals("3", proxies.basicGet(2).getLabel());

		assertNotNull(node.getSource());

		assertFalse(node.getSource().eIsProxy());
		assertEquals("2121", node.getSource().getLabel());

		Node node2 = (Node) resource.getContents().get(1);
		assertNotNull(node2);

		InternalEList<Node> proxies2 = (InternalEList<Node>) node2.eGet(ModelPackage.Literals.NODE__MANY_REF, false);
		assertEquals(2, proxies2.size());

		assertFalse(proxies2.basicGet(0).eIsProxy());
		assertFalse(proxies2.basicGet(1).eIsProxy());

		assertEquals("311", proxies2.basicGet(0).getLabel());
		assertEquals("3112", proxies2.basicGet(1).getLabel());
	}

}