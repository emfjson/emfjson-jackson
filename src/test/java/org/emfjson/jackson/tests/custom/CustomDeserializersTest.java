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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.databind.deser.ReferenceEntry;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.Sex;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.emfjson.jackson.databind.EMFContext.Attributes.ROOT_ELEMENT;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_USE_ID;
import static org.junit.Assert.*;

public class CustomDeserializersTest {

	private ObjectMapper mapper;
	private ResourceSetImpl resourceSet;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory(mapper));
	}

	@Test
	public void testDeserializeTypeValueWithOtherFieldName() throws JsonProcessingException {
		EMFModule module = new EMFModule();
		module.setTypeInfo(new EcoreTypeInfo("type"));
		mapper.registerModule(module);

		JsonNode data = mapper.createObjectNode()
				.put("type", "http://www.emfjson.org/jackson/model#//User")
				.put("userId", "u1");

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());

		User u = (User) resource.getContents().get(0);

		assertEquals("u1", u.getUserId());
		assertEquals(0, u.getFriends().size());
		assertNull(u.getUniqueFriend());
		assertNull(u.getAddress());
	}

	@Test
	public void testDeserializeTypeValue() throws JsonProcessingException {
		EMFModule module = new EMFModule();
		module.setTypeInfo(new EcoreTypeInfo("type", new ValueReader<String, EClass>() {
			public EClass readValue(String value, DeserializationContext context) {
				return (EClass) ModelPackage.eINSTANCE.getEClassifier(value);
			}
		}));
		mapper.registerModule(module);

		JsonNode data = mapper.createObjectNode()
				.put("type", "User")
				.put("userId", "u1");

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());

		User u = (User) resource.getContents().get(0);

		assertEquals("u1", u.getUserId());
		assertEquals(Sex.MALE, u.getSex());
		assertEquals(0, u.getFriends().size());
		assertNull(u.getUniqueFriend());
		assertNull(u.getAddress());
	}

	@Test
	public void testDeserializeIdValueWithOtherFieldName() throws JsonProcessingException {
		EMFModule module = new EMFModule();
		module.configure(OPTION_USE_ID, true);
		module.setIdentityInfo(new EcoreIdentityInfo("_id"));
		mapper.registerModule(module);

		JsonNode data = mapper.createObjectNode()
				.put("_id", "1")
				.put("userId", "u1");

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());

		User u = (User) resource.getContents().get(0);

		assertEquals("u1", u.getUserId());
		assertSame(u, resource.getEObject("1"));
	}

	@Test
	public void testDeserializeIdValue() throws JsonProcessingException {
		EMFModule module = new EMFModule();
		module.configure(OPTION_USE_ID, true);
		module.setIdentityInfo(new EcoreIdentityInfo("_id", new ValueReader<Object, String>() {
			@Override
			public String readValue(Object value, DeserializationContext context) {
				return value.toString();
			}
		}));
		mapper.registerModule(module);

		JsonNode data = mapper.createObjectNode()
				.put("_id", 1)
				.put("userId", "u1");

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, Resource.class);

		assertEquals(1, resource.getContents().size());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());

		User u = (User) resource.getContents().get(0);

		assertEquals("u1", u.getUserId());
		assertSame(u, resource.getEObject("1"));
	}

	@Test
	public void testDeserializeReferenceAsStrings() throws JsonProcessingException {
		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_USE_ID, true);
		module.configure(EMFModule.Feature.OPTION_SERIALIZE_TYPE, false);

		module.setReferenceDeserializer(new JsonDeserializer<ReferenceEntry>() {
			@Override
			public ReferenceEntry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
				final EObject parent = EMFContext.getParent(ctxt);
				final EReference reference = EMFContext.getReference(ctxt);

				if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
					p.nextToken();
				}

				return new ReferenceEntry.Base(parent, reference, p.getText());
			}
		});

		mapper.registerModule(module);

		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("@id", "1")
						.put("name", "Paul")
						.put("uniqueFriend", "2"))
				.add(mapper.createObjectNode()
						.put("@id", "2")
						.put("name", "Franck"));

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, Resource.class);

		assertEquals(2, resource.getContents().size());

		User u1 = (User) resource.getContents().get(0);
		User u2 = (User) resource.getContents().get(1);

		assertSame(u2, u1.getUniqueFriend());
	}

	@Test
	public void testDeserializeReferenceWithOtherFieldNames() throws JsonProcessingException {
		EMFModule module = new EMFModule();
		module.setTypeInfo(new EcoreTypeInfo("my_type"));
		module.setReferenceInfo(new EcoreReferenceInfo("my_ref"));
		mapper.registerModule(module);

		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("name", "Paul")
						.set("uniqueFriend", mapper.createObjectNode()
								.put("my_type", "http://www.emfjson.org/jackson/model#//User")
								.put("my_ref", "/1")))
				.add(mapper.createObjectNode()
						.put("name", "Franck"));

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.withAttribute(ROOT_ELEMENT, ModelPackage.Literals.USER)
				.treeToValue(data, Resource.class);

		assertEquals(2, resource.getContents().size());

		User u1 = (User) resource.getContents().get(0);
		User u2 = (User) resource.getContents().get(1);

		assertSame(u2, u1.getUniqueFriend());
	}
}
