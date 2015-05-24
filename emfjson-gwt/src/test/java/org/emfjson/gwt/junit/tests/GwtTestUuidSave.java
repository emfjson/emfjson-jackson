/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.tests;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import org.emfjson.gwt.junit.model.ConcreteTypeOne;
import org.emfjson.gwt.junit.model.Container;
import org.emfjson.gwt.junit.model.ModelFactory;
import org.emfjson.gwt.junit.support.UuidTestSupport;

import java.io.IOException;

public class GwtTestUuidSave extends UuidTestSupport {

	@Test
	public void testSerializeOneObjectWithUuid() {
		Resource resource = createUuidResource("test.json");
		Container root = ModelFactory.eINSTANCE.createContainer();
		resource.getContents().add(root);

		// Make sure the fragment identifier is a UUID 
		assertTrue(EcoreUtil.getURI(root).fragment().startsWith("_"));

		JSONValue node = mapper.write(resource, options);

		assertNotNull(node);
		assertNotNull(node.isObject());
		assertNotNull(node.isObject().get("_id"));
		assertEquals(uuid(root), uuid(node.isObject()));
	}

	@Test
	public void testSerializeOneRootWithTwoChildHavingOneReference() throws IOException {
		Resource resource = createUuidResource("test.json");

		Container root = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		ConcreteTypeOne two = ModelFactory.eINSTANCE.createConcreteTypeOne();

		one.setName("one");
		two.setName("two");

		one.getRefProperty().add(two);

		root.getElements().add(one);
		root.getElements().add(two);

		resource.getContents().add(root);

		JSONValue node = mapper.write(resource, options);

		assertNotNull(node);
		assertNotNull(node.isObject());
		assertNotNull(node.isObject().get("_id"));
		assertEquals(uuid(root), uuid(node.isObject()));

		assertNotNull(node.isObject().get("elements").isArray());

		JSONArray elements = node.isObject().get("elements").isArray();
		assertEquals(2, elements.size());
		JSONValue node1 = elements.get(0);
		JSONValue node2 = elements.get(1);

		assertNotNull(node1.isObject());
		assertNotNull(node1.isObject().get("_id"));
		assertEquals(uuid(one), uuid(node1.isObject()));

		assertNotNull(node2.isObject());
		assertNotNull(node2.isObject().get("_id"));
		assertEquals(uuid(two), uuid(node2.isObject()));

		assertNotNull(node1.isObject().get("refProperty"));
		assertNull(node2.isObject().get("refProperty"));
		assertNotNull(node1.isObject().get("refProperty").isArray());

		JSONArray refProperty = node1.isObject().get("refProperty").isArray();
		assertEquals(1, refProperty.size());

		JSONValue ref = refProperty.get(0);
		assertNotNull(ref.isObject());
		assertNotNull(ref.isObject().get("$ref"));

		assertEquals(uuid(two), ref.isObject().get("$ref").isString().stringValue());
	}

}
