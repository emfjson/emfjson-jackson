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

import com.fasterxml.jackson.core.JsonGenerator;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.EMFJs;
import org.emfjson.common.Options;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.deser.DefaultTypeDeserializer;
import org.emfjson.jackson.databind.deser.FragmentIdDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer;
import org.emfjson.jackson.databind.ser.DefaultTypeSerializer;
import org.emfjson.jackson.databind.ser.FragmentIdSerializer;
import org.emfjson.jackson.databind.ser.IdSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceAsObjectSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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

		assertEquals(DefaultTypeSerializer.class, options.typeSerializer.getClass());
		assertEquals(DefaultTypeDeserializer.class, options.typeDeserializer.getClass());

		assertNull(options.uriHandler);
		assertTrue(options.indentOutput);
		assertNull(options.rootElement);
	}

	@Test
	public void testCustomSerializer() {
		IdSerializer idSerializer = new IdSerializer() {
			@Override
			public void serialize(EObject object, JsonGenerator jg, Options options) throws IOException {}
		};
		ReferenceSerializer referenceSerializer = new ReferenceSerializer() {
			@Override
			public void serialize(EObject source, EObject value, JsonGenerator jg, JacksonOptions options) throws IOException {}
		};

		JacksonOptions jacksonOptions = new JacksonOptions.Builder()
				.withIdSerializer(idSerializer)
				.withReferenceSerializer(referenceSerializer)
				.build();

		assertSame(idSerializer, jacksonOptions.idSerializer);
		assertSame(referenceSerializer, jacksonOptions.referenceSerializer);
	}

	@Test
	public void testCustomSerializerFromMap() {
		Map<String, Object> options = new HashMap<>();
		IdSerializer idSerializer = new IdSerializer() {
			@Override
			public void serialize(EObject object, JsonGenerator jg, Options options) throws IOException {}
		};
		ReferenceSerializer referenceSerializer = new ReferenceSerializer() {
			@Override
			public void serialize(EObject source, EObject value, JsonGenerator jg, JacksonOptions options) throws IOException {}
		};
		options.put(EMFJs.OPTION_ID_SERIALIZER, idSerializer);
		options.put(EMFJs.OPTION_REF_SERIALIZER, referenceSerializer);

		JacksonOptions jacksonOptions = JacksonOptions.from(options);

		assertSame(idSerializer, jacksonOptions.idSerializer);
		assertSame(referenceSerializer, jacksonOptions.referenceSerializer);
	}

	@Test
	public void testSettingCustomFields() {
		JacksonOptions options = new JacksonOptions
				.Builder()
				.withTypeField("type")
				.withIdField("id")
				.withRefField("ref")
				.build();

		assertEquals("id", options.idField);
		assertEquals("ref", options.refField);
		assertEquals("type", options.typeField);
	}

	@Test
	public void testSettingCustomFieldsFromMap() {
		Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_REF_FIELD, "ref");
		options.put(EMFJs.OPTION_TYPE_FIELD, "type");
		options.put(EMFJs.OPTION_ID_FIELD, "id");

		JacksonOptions jacksonOptions = JacksonOptions.from(options);

		assertEquals("id", jacksonOptions.idField);
		assertEquals("ref", jacksonOptions.refField);
		assertEquals("type", jacksonOptions.typeField);
	}

}
