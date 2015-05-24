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
	private ResourceSet resourceSet;

	private EClass a;
	private EClass b;

	@Before
	public void setUp() {
		resourceSet = new ResourceSetImpl();

		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setNsURI("http://foo.org/p");
		p.setName("p");

		a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A");

		b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B");
		b.getESuperTypes().add(a);

		EAttribute label = EcoreFactory.eINSTANCE.createEAttribute();
		label.setName("label");
		label.setEType(EcorePackage.Literals.ESTRING);

		EReference bs = EcoreFactory.eINSTANCE.createEReference();
		bs.setName("bs");
		bs.setContainment(true);
		bs.setUpperBound(-1);
		bs.setEType(b);

		a.getEStructuralFeatures().add(label);
		a.getEStructuralFeatures().add(bs);

		p.getEClassifiers().add(a);
		p.getEClassifiers().add(b);

		resourceSet.getResourceFactoryRegistry()
			.getExtensionToFactoryMap().put("*", new JsonResourceFactory());

		Resource r = resourceSet.createResource(URI.createURI("http://foo.org/p"));
		r.getContents().add(p);

		resourceSet.getPackageRegistry().put(p.getNsURI(), p);

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
