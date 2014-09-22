/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.tests.others;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.Node;
import org.eclipselabs.emfjson.junit.model.User;
import org.eclipselabs.emfjson.junit.support.TestSupport;
import org.junit.Test;


public class TestEmfJsAttributes extends TestSupport {

	@Test
	public void testLoadOneObjectWithTypeFromFile() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-load-1.json"));
		assertNotNull(resource);
		resource.load(null);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof User);

		User user = (User) resource.getContents().get(0);
		assertEquals("1", user.getUserId());
		assertEquals("Paul", user.getName());
	}

	@Test
	public void testLoadOneObjectWithTypeFromInputStream() throws IOException {
		String data = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"1\",\"name\":\"Paul\"}";
		ByteArrayInputStream inStream = new ByteArrayInputStream(data.getBytes());
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		assertNotNull(resource);
		resource.load(inStream, null);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof User);

		User user = (User) resource.getContents().get(0);
		assertEquals("1", user.getUserId());
		assertEquals("Paul", user.getName());
	}

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
	public void testOptionProxyAttributes() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true);

		Resource resource = resourceSet.createResource(uri("test-proxy-3.json"));
		resource.load(options);

		Node node = (Node) resource.getContents().get(0);
		assertNotNull(node);

		InternalEList<?> proxies = (InternalEList<?>) node.eGet(ModelPackage.Literals.NODE__MANY_REF, false);
		assertEquals(3, proxies.size());

		assertFalse(((InternalEObject) proxies.basicGet(0)).eIsProxy());
		assertFalse(((InternalEObject) proxies.basicGet(1)).eIsProxy());
		assertFalse(((InternalEObject) proxies.basicGet(2)).eIsProxy());

		assertEquals("2", ((Node) proxies.basicGet(0)).getLabel());
		assertEquals("21", ((Node) proxies.basicGet(1)).getLabel());
		assertEquals("3", ((Node) proxies.basicGet(2)).getLabel());

		assertNotNull(node.getSource());

		assertFalse(node.getSource().eIsProxy());
		assertEquals("2121", node.getSource().getLabel());

		Node node2 = (Node) resource.getContents().get(1);
		assertNotNull(node2);

		InternalEList<?> proxies2 = (InternalEList<?>) node2.eGet(ModelPackage.Literals.NODE__MANY_REF, false);
		assertEquals(2, proxies2.size());

		assertFalse(((InternalEObject) proxies2.basicGet(0)).eIsProxy());
		assertFalse(((InternalEObject) proxies2.basicGet(1)).eIsProxy());

		assertEquals("311", ((Node) proxies2.basicGet(0)).getLabel());
		assertEquals("3112", ((Node) proxies2.basicGet(1)).getLabel());
	}

}
