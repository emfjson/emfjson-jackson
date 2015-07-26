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
package org.emfjson.jackson.junit.support;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Before;

import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.emfjson.jackson.JacksonOptions.from;

public abstract class TestSupport {

	protected final URL testURI = getClass().getResource("/tests");
	protected final Map<String, Object> options = new HashMap<>();
	protected URI baseTestFilesFileDirectory = URI.createFileURI(testURI.getFile()).appendSegment("");
	protected String baseURI = "http://eclipselabs.org/emfjson/tests/";
	protected ResourceSet resourceSet;
	protected ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		URI baseURI = URI.createURI("http://eclipselabs.org/emfjson/tests/");

		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIMap().put(baseURI, baseTestFilesFileDirectory);

		mapper.registerModule(new EMFModule(resourceSet, from(options)));

		createDynamicModel();
	}

	protected URI uri(String fileName) {
		return URI.createURI(baseURI + fileName, true);
	}

	protected void createDynamicModel() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName("model");
		p.setNsPrefix("model");
		p.setNsURI("http://emfjson/dynamic/model");

		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A");

		EEnum ee = EcoreFactory.eINSTANCE.createEEnum();
		ee.setName("Kind");

		EEnumLiteral e1 = EcoreFactory.eINSTANCE.createEEnumLiteral();
		e1.setName("e1");

		EEnumLiteral e2 = EcoreFactory.eINSTANCE.createEEnumLiteral();
		e2.setName("e2");
		e2.setLiteral("E2");

		ee.getELiterals().add(e1);
		ee.getELiterals().add(e2);

		EAttribute ae = EcoreFactory.eINSTANCE.createEAttribute();
		ae.setName("singleKind");
		ae.setEType(ee);

		a.getEStructuralFeatures().add(ae);

		p.getEClassifiers().add(a);
		p.getEClassifiers().add(ee);

		Resource model = resourceSet.createResource(URI.createURI("http://emfjson/dynamic/model"));
		model.getContents().add(p);
	}

}
