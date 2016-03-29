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

import org.emfjson.EMFJs;
import org.emfjson.jackson.JacksonOptions;
import org.junit.Test;

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

//		assertEquals(FragmentIdSerializer.class, options.idSerializer.getClass());
//		assertEquals(FragmentIdDeserializer.class, options.idDeserializer.getClass());
//
//		assertEquals(ReferenceAsObjectSerializer.class, options.referenceSerializer.getClass());
//		assertEquals(ReferenceAsObjectDeserializer.class, options.referenceDeserializer.getClass());
//
//		assertEquals(DefaultTypeSerializer.class, options.typeSerializer.getClass());
//		assertEquals(DefaultTypeDeserializer.class, options.typeDeserializer.getClass());

		assertNull(options.uriHandler);
		assertTrue(options.indentOutput);
		assertNull(options.rootElement);
	}

	@Test
	public void testCustomSerializer() {
//		JsonSerializer<EObject> idSerializer = new JsonSerializer<EObject>() {
//			@Override
//			public void serialize(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {}
//		};
//		ReferenceSerializer referenceSerializer = new ReferenceSerializer() {
//			@Override
//			public void serialize(EObject source, EObject value, JsonGenerator jg, SerializerProvider provider) throws IOException {}
//		};
//
//		JacksonOptions jacksonOptions = new JacksonOptions.Builder()
//				.withIdSerializer(idSerializer)
//				.withReferenceSerializer(referenceSerializer)
//				.build();
//
//		assertSame(idSerializer, jacksonOptions.idSerializer);
//		assertSame(referenceSerializer, jacksonOptions.referenceSerializer);
	}

	@Test
	public void testCustomSerializerFromMap() {
//		Map<String, Object> options = new HashMap<>();
//		IdSerializer idSerializer = new IdSerializer() {
//			@Override
//			public void serialize(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {}
//		};
//		ReferenceSerializer referenceSerializer = new ReferenceSerializer() {
//			@Override
//			public void serialize(EObject source, EObject value, JsonGenerator jg, SerializerProvider provider) throws IOException {}
//		};
//		options.put(EMFJs.OPTION_ID_SERIALIZER, idSerializer);
//		options.put(EMFJs.OPTION_REF_SERIALIZER, referenceSerializer);
//
//		JacksonOptions jacksonOptions = JacksonOptions.from(options);
//
//		assertSame(idSerializer, jacksonOptions.idSerializer);
//		assertSame(referenceSerializer, jacksonOptions.referenceSerializer);
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
