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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.Node;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ProxyAttributeTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testOptionProxyAttributesWithID() throws IOException {
		Resource resource = resourceSet.getResource(URI.createURI("test-proxy-1.json"), true);

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
//		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true);

		Resource resource = resourceSet.createResource(URI.createURI("src/test/resources/tests/test-proxy-3.json"));
//		resource.load(options);

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