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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.Sex;
import org.emfjson.jackson.junit.model.User;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomDeserializersTest {

//	private IdDeserializer idDeserializer = new IdDeserializer() {
//		@Override
//		public void deserialize(JsonParser jp, EObject object, DeserializationContext ctxt) throws IOException {
//			Resource resource = (Resource) ctxt.getAttribute("resource");
//			String text = jp.nextTextValue();
//
//			if (resource instanceof JsonResource) {
//				object.eSet(ModelPackage.Literals.USER__USER_ID, text);
//				((JsonResource) resource).setID(object, text);
//			}
//		}
//	};
//
//	private TypeDeserializer typeDeserializer = new TypeDeserializer() {
//		@Override
//		public EClass deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
//			return ModelPackage.Literals.USER;
//		}
//	};
//
//	private ReferenceDeserializer referenceDeserializer = new ReferenceDeserializer() {
//		@Override
//		public ReferenceEntries.ReferenceEntry deserialize(JsonParser jp, EObject owner, EReference reference, DeserializationContext ctxt)
//				throws IOException {
//
//			if (JsonToken.VALUE_STRING.equals(jp.getCurrentToken())) {
//				return new DefaultReferenceEntry(owner, reference, jp.getText());
//			}
//
//			return null;
//		}
//	};

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));

//		resourceSet, new JacksonOptions
//				.Builder()
//				.withIdField("userId")
//				.withTypeField("type")
//				.withIdDeserializer(idDeserializer)
//				.withReferenceDeserializer(referenceDeserializer)
//				.withTypeDeserializer(typeDeserializer)
//				.build()
		EMFModule module = new EMFModule();

		mapper.registerModule(module);
	}

	@Test
	public void testDeserializers() throws JsonProcessingException {
		JsonNode data = mapper.createArrayNode()
				.add(mapper.createObjectNode()
						.put("type", "User")
						.put("userId", "u1")
						.put("sex", "MALE")
						.put("uniqueFriend", "u2"))
				.add(mapper.createObjectNode()
						.put("type", "User")
						.put("userId", "u2")
						.put("sex", "MALE")
						.set("friends", mapper.createArrayNode()
								.add("u1")
								.add("u3")))
				.add(mapper.createObjectNode()
						.put("type", "User")
						.put("userId", "u3")
						.put("sex", "MALE")
						.set("friends", mapper.createArrayNode()
								.add("u1")
								.add("u2")));

		Resource resource = mapper.treeToValue(data, Resource.class);

		assertEquals(3, resource.getContents().size());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());

		User u = (User) resource.getContents().get(0);

		assertEquals("u1", u.getUserId());
		assertEquals(Sex.MALE, u.getSex());
		assertEquals(0, u.getFriends().size());
		assertNotNull(u.getUniqueFriend());
		assertSame(resource.getContents().get(1), u.getUniqueFriend());

		u = (User) resource.getContents().get(1);

		assertEquals("u2", u.getUserId());
		assertEquals(Sex.MALE, u.getSex());
		assertEquals(2, u.getFriends().size());
		assertSame(resource.getContents().get(0), u.getFriends().get(0));
		assertSame(resource.getContents().get(2), u.getFriends().get(1));

		u = (User) resource.getContents().get(2);

		assertEquals("u3", u.getUserId());
		assertEquals(Sex.MALE, u.getSex());
		assertEquals(2, u.getFriends().size());
		assertSame(resource.getContents().get(0), u.getFriends().get(0));
		assertSame(resource.getContents().get(1), u.getFriends().get(1));
	}

}
