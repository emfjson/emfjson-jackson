/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.junit.tests;

import org.junit.Test;

import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.deser.FragmentIdDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer;
import org.emfjson.jackson.databind.ser.FragmentIdSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceAsObjectSerializer;
import org.emfjson.jackson.handlers.BaseURIHandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class JacksonOptionTest {

	@Test
	public void testDefaultParameters() {
		JacksonOptions options = new JacksonOptions.Builder().build();

		assertEquals("eClass", options.typeField);
		assertEquals("$ref", options.refField);
		assertEquals("_id", options.idField);

		assertEquals(FragmentIdSerializer.class, options.idSerializer.getClass());
		assertEquals(FragmentIdDeserializer.class, options.idDeserializer.getClass());

		assertEquals(ReferenceAsObjectSerializer.class, options.referenceSerializer.getClass());
		assertEquals(ReferenceAsObjectDeserializer.class, options.referenceDeserializer.getClass());

		assertNull(options.uriHandler);
		assertTrue(options.indentOutput);
		assertNull(options.rootElement);
	}

}
