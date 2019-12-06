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
package org.emfjson.jackson.tests.dynamic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.emfjson.jackson.databind.EMFContext.Attributes.RESOURCE_SET;
import static org.junit.Assert.*;

public class DynamicInstanceTest {

	private EClass a;
	private EClass b;
	private ResourceSetImpl resourceSet;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		resourceSet = new ResourceSetImpl();
		mapper.registerModule(new EMFModule());

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));

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
						.add(mapper.createObjectNode())
						.add(mapper.createObjectNode()));

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
						.add(mapper.createObjectNode())
						.add(mapper.createObjectNode()));

		Resource resource = mapper
				.reader()
				.withAttribute(RESOURCE_SET, resourceSet)
				.treeToValue(data, Resource.class);

		assertNotNull(resource);

		assertEquals(0, resource.getErrors().size());
		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);

		assertSame(a, root.eClass());

		assertEquals(2, ((List) root.eGet(a.getEStructuralFeature("bs"))).size());
	}

}
