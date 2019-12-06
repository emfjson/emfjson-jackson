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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.Node;
import org.emfjson.jackson.support.StandardFixture;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.IOException;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_URI;
import static org.junit.Assert.*;

public class ExternalReferencesTest {

	@ClassRule
	public static StandardFixture fixture = new StandardFixture();

	private ObjectMapper mapper = fixture.mapper();
	private ResourceSet resourceSet = fixture.getResourceSet();

	@Test
	public void testSaveExternalReferenceOnSameBaseURI() throws IOException {
		Resource first = resourceSet.createResource(URI.createURI("file://folder/first.json"));
		Resource second = resourceSet.createResource(URI.createURI("file://folder/second.json"));

		Node n1 = ModelFactory.eINSTANCE.createNode();
		Node n2 = ModelFactory.eINSTANCE.createNode();
		n2.setTarget(n1);

		first.getContents().add(n1);
		second.getContents().add(n2);

		JsonNode result = mapper.valueToTree(second);

		assertEquals("first.json#/", result.get("target").get("$ref").asText());
	}

	@Test
	public void testSaveExternalReferenceWithDifferentBaseURI() throws IOException {
		Resource first = resourceSet.createResource(URI.createURI("file://folder/first.json"));
		Resource second = resourceSet.createResource(URI.createURI("file://folder/other/second.json"));

		Node n1 = ModelFactory.eINSTANCE.createNode();
		Node n2 = ModelFactory.eINSTANCE.createNode();
		n2.setTarget(n1);

		first.getContents().add(n1);
		second.getContents().add(n2);

		JsonNode result = mapper.valueToTree(second);

		assertEquals("../first.json#/", result.get("target").get("$ref").asText());
	}

	@Test
	public void testLoadExternalReferenceOnSameBaseURI() throws JsonProcessingException {
		JsonNode first = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//Node");

		JsonNode second = mapper.createObjectNode()
				.put("eClass", "http://www.emfjson.org/jackson/model#//Node")
				.set("target", mapper.createObjectNode()
						.put("$ref", "../first.json#/"));

		Resource r1 = mapper.reader()
				.withAttribute(RESOURCE_URI, URI.createURI("file://folder/first.json"))
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(first, Resource.class);

		Resource r2 = mapper.reader()
				.withAttribute(RESOURCE_URI, URI.createURI("file://folder/second.json"))
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(second, Resource.class);

		assertNotNull(r1);
		assertNotNull(r2);

		assertEquals("file://folder/first.json", r1.getURI().toString());
		assertEquals("file://folder/second.json", r2.getURI().toString());

		assertEquals(1, r1.getContents().size());
		assertEquals(1, r2.getContents().size());

		Node n1 = (Node) r1.getContents().get(0);
		Node n2 = (Node) r2.getContents().get(0);

		assertSame(n2.getTarget(), n1);
	}

}
