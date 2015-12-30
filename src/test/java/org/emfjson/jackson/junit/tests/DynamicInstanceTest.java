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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;

import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.Assert.*;

public class DynamicInstanceTest {

	private ObjectMapper mapper = new ObjectMapper();

	private EClass a;
	private EClass b;

	@Before
	public void setUp() {
		final ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry()
			.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory());

		resourceSet.getPackageRegistry()
				.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		resourceSet.getURIConverter()
				.getURIMap()
				.put(
						URI.createURI("http://foo.org/p"),
						URI.createURI("src/test/resources/model/dynamic/model-1.json"));

		final Resource resource = resourceSet.getResource(URI.createURI("http://foo.org/p"), true);
		final EPackage ePackage = (EPackage) resource.getContents().get(0);

		resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);

		a = (EClass) ePackage.getEClassifier("A");
		b = (EClass) ePackage.getEClassifier("B");

		mapper.registerModule(new EMFModule(resourceSet));
	}

	@Test
	public void testSaveOneObject() {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://foo.org/p#//A")
			.put("label", "1");

		EObject o = EcoreUtil.create(a);
		o.eSet(a.getEStructuralFeature("label"), "1");

		assertEquals(expected, mapper.valueToTree(o));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSaveOneRootWithChildren() {
		JsonNode expected = mapper.createObjectNode()
			.put("eClass", "http://foo.org/p#//A")
			.put("label", "1")
			.set("bs", mapper.createArrayNode()
				.add(mapper.createObjectNode().put("eClass", "http://foo.org/p#//B"))
				.add(mapper.createObjectNode().put("eClass", "http://foo.org/p#//B")));

		EObject o = EcoreUtil.create(a);
		o.eSet(a.getEStructuralFeature("label"), "1");

		EObject o1 = EcoreUtil.create(b);
		EObject o2 = EcoreUtil.create(b);

		((List) o.eGet(a.getEStructuralFeature("bs"))).add(o1);
		((List) o.eGet(a.getEStructuralFeature("bs"))).add(o2);

		assertEquals(expected, mapper.valueToTree(o));
	}

	@Test
	public void testLoadOneRootWithChildren() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
			.put("eClass", "http://foo.org/p#//A")
			.put("label", "1")
			.set("bs", mapper.createArrayNode()
				.add(mapper.createObjectNode().put("eClass", "http://foo.org/p#//B"))
				.add(mapper.createObjectNode().put("eClass", "http://foo.org/p#//B")));

		Resource resource = mapper.treeToValue(data, Resource.class);

		assertNotNull(resource);

		assertEquals(0, resource.getErrors().size());
		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);

		assertSame(a, root.eClass());

		assertEquals(2, ((List) root.eGet(a.getEStructuralFeature("bs"))).size());
	}

}
