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
package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.Cache;
import org.emfjson.common.Options;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.ser.IdSerializer;
import org.emfjson.jackson.databind.ser.TypeSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CustomSerializersTest {

	private IdSerializer serializer = new IdSerializer() {
		@Override
		public void serialize(EObject object, JsonGenerator jg, Options options) throws IOException {}
	};

	private ReferenceSerializer referenceSerializer = new ReferenceSerializer() {
		@Override
		public void serialize(EObject source, EObject value, JsonGenerator jg, JacksonOptions options) throws IOException {
			jg.writeString(EcoreUtil.getID(value));
		}
	};

	private TypeSerializer typeSerializer = new TypeSerializer() {
		@Override
		public void serialize(EClass eClass, JsonGenerator jg, Cache cache, JacksonOptions options) throws IOException {
			jg.writeStringField("type", eClass.getName());
		}
	};

	private ResourceSet resourceSet;
	private ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory());

		EMFModule module = new EMFModule(resourceSet, new JacksonOptions
				.Builder()
				.withIdSerializer(serializer)
				.withReferenceSerializer(referenceSerializer)
				.withTypeSerializer(typeSerializer)
				.build());

		mapper.registerModule(module);
	}

	@Test
	public void testSerializers() {
		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("type", "User")
						.put("userId", "u1")
						.put("sex", "MALE")
						.put("uniqueFriend", "u2"))
				.add(mapper.createObjectNode()
						.put("type", "User")
						.put("userId", "u2")
						.put("sex", "MALE")
						.set("friends", mapper.createArrayNode().add("u1").add("u3")))
				.add(mapper.createObjectNode()
						.put("type", "User")
						.put("userId", "u3")
						.put("sex", "MALE")
						.set("friends", mapper.createArrayNode().add("u1").add("u2")));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("u1");
		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setUserId("u2");
		User u3 = ModelFactory.eINSTANCE.createUser();
		u3.setUserId("u3");

		u1.setUniqueFriend(u2);
		u2.getFriends().add(u1);
		u2.getFriends().add(u3);
		u3.getFriends().add(u1);
		u3.getFriends().add(u2);

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);
		resource.getContents().add(u2);
		resource.getContents().add(u3);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

}
