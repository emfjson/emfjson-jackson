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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;

import java.net.URL;
import java.text.SimpleDateFormat;
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
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

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

		// classes a, b, c, d
		// a
		// b > a
		// c > b > a

		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A");

		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B");

		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName("C");

		EClass d = EcoreFactory.eINSTANCE.createEClass();
		d.setName("D");

		b.getESuperTypes().add(a);
		c.getESuperTypes().add(b);
		d.getESuperTypes().add(b);

		// dataTypes
		//
		// Kind: Enum
		// - e1
		// - e2: E2

		EEnum kind = EcoreFactory.eINSTANCE.createEEnum();
		kind.setName("Kind");

		EEnumLiteral e1 = EcoreFactory.eINSTANCE.createEEnumLiteral();
		e1.setName("e1");

		EEnumLiteral e2 = EcoreFactory.eINSTANCE.createEEnumLiteral();
		e2.setName("e2");
		e2.setLiteral("E2");

		kind.getELiterals().add(e1);
		kind.getELiterals().add(e2);

		// CustomType
		EDataType customDataType = EcoreFactory.eINSTANCE.createEDataType();
		customDataType.setName("CustomType");
		customDataType.setSerializable(true);

		p.getEClassifiers().add(a);
		p.getEClassifiers().add(b);
		p.getEClassifiers().add(c);
		p.getEClassifiers().add(d);
		p.getEClassifiers().add(kind);
		p.getEClassifiers().add(customDataType);

		// attributes
		//
		// a:
		// 	stringValue: string
		// 	intValue: int
		// 	stringValues: string[]
		// 	intValues: int[]
		// 	dateValue: date
		// 	someKind: kind
		//  custom: CustomType

		EAttribute stringValue = EcoreFactory.eINSTANCE.createEAttribute();
		stringValue.setName("stringValue");
		stringValue.setUnsettable(true);
		stringValue.setEType(EcorePackage.Literals.ESTRING);

		EAttribute stringValues = EcoreFactory.eINSTANCE.createEAttribute();
		stringValues.setName("stringValues");
		stringValues.setUpperBound(-1);
		stringValues.setEType(EcorePackage.Literals.ESTRING);

		EAttribute intValue = EcoreFactory.eINSTANCE.createEAttribute();
		intValue.setName("intValue");
		intValue.setEType(EcorePackage.Literals.EINT);

		EAttribute intValues = EcoreFactory.eINSTANCE.createEAttribute();
		intValues.setName("intValues");
		intValues.setUpperBound(-1);
		intValues.setEType(EcorePackage.Literals.EINT);

		EAttribute dateValue = EcoreFactory.eINSTANCE.createEAttribute();
		dateValue.setName("dateValue");
		dateValue.setEType(EcorePackage.Literals.EDATE);

		EAttribute someKind = EcoreFactory.eINSTANCE.createEAttribute();
		someKind.setName("someKind");
		someKind.setEType(kind);

		EAttribute customValue = EcoreFactory.eINSTANCE.createEAttribute();
		customValue.setName("customValue");
		customValue.setEType(customDataType);

		a.getEStructuralFeatures().add(stringValue);
		a.getEStructuralFeatures().add(stringValues);
		a.getEStructuralFeatures().add(intValue);
		a.getEStructuralFeatures().add(intValues);
		a.getEStructuralFeatures().add(dateValue);
		a.getEStructuralFeatures().add(someKind);
		a.getEStructuralFeatures().add(customValue);

		// references
		// a:
		//  containB: B
		//  containBs: B[]
		//  refTo: A
		//  refToMany: A[]

		EReference containB = EcoreFactory.eINSTANCE.createEReference();
		containB.setName("containB");
		containB.setContainment(true);
		containB.setEType(b);

		EReference containBs = EcoreFactory.eINSTANCE.createEReference();
		containBs.setName("containBs");
		containBs.setContainment(true);
		containBs.setUpperBound(-1);
		containBs.setEType(b);

		EReference refTo = EcoreFactory.eINSTANCE.createEReference();
		refTo.setName("refTo");
		refTo.setEType(a);

		EReference refToMany = EcoreFactory.eINSTANCE.createEReference();
		refToMany.setName("refTo");
		refToMany.setUpperBound(-1);
		refToMany.setEType(a);

		a.getEStructuralFeatures().add(containB);
		a.getEStructuralFeatures().add(containBs);
		a.getEStructuralFeatures().add(refTo);
		a.getEStructuralFeatures().add(refToMany);

		Resource model = resourceSet.createResource(URI.createURI("http://emfjson/dynamic/model"));
		model.getContents().add(p);
	}

}
