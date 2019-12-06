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
package org.emfjson.jackson.tests.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.emfjson.jackson.utils.ValueWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CustomSerializersTest {

	private ResourceSet resourceSet;
	private ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory(mapper));
	}

	@Test
	public void testSerializeTypeWithOtherFieldName() {
		EMFModule module = new EMFModule();
		module.setTypeInfo(new EcoreTypeInfo("type"));
		mapper.registerModule(module);

		JsonNode expected = mapper.createObjectNode()
				.put("type", "http://www.emfjson.org/jackson/model#//User")
				.put("userId", "u1");

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("u1");

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

	@Test
	public void testSerializeType() {
		EMFModule module = new EMFModule();
		module.setTypeInfo(new EcoreTypeInfo("type", new ValueWriter<EClass, String>() {
			@Override
			public String writeValue(EClass value, SerializerProvider context) {
				return value.getName();
			}
		}));
		mapper.registerModule(module);

		JsonNode expected = mapper.createObjectNode()
				.put("type", "User")
				.put("userId", "u1");

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("u1");

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

	@Test
	public void testSerializeIdWithOtherFieldName() {
		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_USE_ID, true);
		module.configure(EMFModule.Feature.OPTION_SERIALIZE_TYPE, false);

		module.setIdentityInfo(new EcoreIdentityInfo("_id"));
		mapper.registerModule(module);

		JsonNode expected = mapper.createObjectNode()
				.put("_id", "1")
				.put("userId", "u1");

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("u1");

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);
		((JsonResource) resource).setID(u1, "1");

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

	@Test
	public void testSerializeId() {
		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_USE_ID, true);
		module.configure(EMFModule.Feature.OPTION_SERIALIZE_TYPE, false);

		module.setIdentityInfo(new EcoreIdentityInfo("_id", new ValueWriter<EObject, Object>() {
			@Override
			public Object writeValue(EObject value, SerializerProvider context) {
				return 1;
			}
		}));
		mapper.registerModule(module);

		JsonNode expected = mapper.createObjectNode()
				.put("_id", 1)
				.put("userId", "u1");

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("u1");

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

	@Test
	public void testSerializeReferenceWithOtherFieldNames() {
		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_SERIALIZE_TYPE, false);
		module.setTypeInfo(new EcoreTypeInfo("my_type"));
		module.setReferenceInfo(new EcoreReferenceInfo("my_ref"));

		mapper.registerModule(module);

		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("name", "Paul")
						.set("uniqueFriend", mapper.createObjectNode()
								.put("my_type", "http://www.emfjson.org/jackson/model#//User")
								.put("my_ref", "/1")))
				.add(mapper.createObjectNode()
						.put("name", "Franck"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setName("Paul");

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setName("Franck");

		u1.setUniqueFriend(u2);

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);
		resource.getContents().add(u2);

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}

	@Test
	public void testSerializeReferenceAsStrings() {
		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_USE_ID, true);
		module.configure(EMFModule.Feature.OPTION_SERIALIZE_TYPE, false);

		module.setReferenceSerializer(new JsonSerializer<EObject>() {
			@Override
			public void serialize(EObject value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				gen.writeString(((JsonResource) value.eResource()).getID(value));
			}
		});

		mapper.registerModule(module);

		JsonNode expected = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("@id", "1")
						.put("name", "Paul")
						.put("uniqueFriend", "2"))
				.add(mapper.createObjectNode()
						.put("@id", "2")
						.put("name", "Franck"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setName("Paul");

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setName("Franck");

		u1.setUniqueFriend(u2);

		Resource resource = resourceSet.createResource(URI.createURI("test"));
		resource.getContents().add(u1);
		resource.getContents().add(u2);

		((JsonResource) resource).setID(u1, "1");
		((JsonResource) resource).setID(u2, "2");

		JsonNode result = mapper.valueToTree(resource);

		assertEquals(expected, result);
	}
}
