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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl.BasicEMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicMapTest {

	private ObjectMapper mapper = new ObjectMapper();

	private EClass eTypesClass, typeClass, valueClass, tmapClass, stringMapClass;
	private ResourceSetImpl resourceSet;

	@Before
	public void setUp() {
		URI modelURI = URI.createURI("http://www.emfjson.org/jackson/model");

		mapper.registerModule(new EMFModule());

		resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory(mapper));

		resourceSet.getPackageRegistry()
				.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		resourceSet.getURIConverter()
				.getURIMap()
				.put(modelURI, URI.createURI("src/test/resources/model/dynamic/model-2.json"));

		final Resource resource = resourceSet.getResource(modelURI, true);
		final EPackage ePackage = (EPackage) resource.getContents().get(0);

		resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);

		eTypesClass = (EClass) ePackage.getEClassifier("ETypes");
		tmapClass = (EClass) ePackage.getEClassifier("TMap");
		stringMapClass = (EClass) ePackage.getEClassifier("StringMap");
		typeClass = (EClass) ePackage.getEClassifier("Type");
		valueClass = (EClass) ePackage.getEClassifier("Value");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSaveMap() throws IOException {
		JsonNode expected = mapper.readTree(
				Paths.get("src/test/resources/tests/test-map-1.json").toFile());

		Resource resource = resourceSet.createResource(URI.createURI("test"));

		EObject a1 = EcoreUtil.create(eTypesClass);
		Collection values = (Collection) a1.eGet(eTypesClass.getEStructuralFeature("values"));

		{
			EObject key = EcoreUtil.create(typeClass);
			key.eSet(typeClass.getEStructuralFeature("name"), "t1");

			EObject value = EcoreUtil.create(valueClass);
			value.eSet(valueClass.getEStructuralFeature("value"), 1);

			BasicEMapEntry<EObject, EObject> entry = new BasicEMapEntry<>();
			entry.eSetClass(tmapClass);
			entry.setKey(key);
			entry.setValue(value);

			values.add(entry);
		}

		{
			EObject key = EcoreUtil.create(typeClass);
			key.eSet(typeClass.getEStructuralFeature("name"), "t2");

			EObject value = EcoreUtil.create(valueClass);
			value.eSet(valueClass.getEStructuralFeature("value"), 2);

			BasicEMapEntry<EObject, EObject> entry = new BasicEMapEntry<>();
			entry.eSetClass(tmapClass);
			entry.setKey(key);
			entry.setValue(value);

			values.add(entry);
		}

		resource.getContents().add(a1);

		assertThat((JsonNode) mapper.valueToTree(resource)).
				isEqualTo(expected);
	}

	@Test
	public void testLoadMap() {
		Resource resource = resourceSet.getResource(
				URI.createURI("src/test/resources/tests/test-map-1.json"), true);

		assertThat(resource.getContents()).hasSize(1);
		assertThat(resource.getContents().get(0).eClass())
				.isSameAs(eTypesClass);

		EObject types = resource.getContents().get(0);

		assertThat((Collection) types.eGet(eTypesClass.getEStructuralFeature("values")))
				.hasSize(2);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSaveMapWithStringKey() throws IOException {
		JsonNode expected = mapper.readTree(
				Paths.get("src/test/resources/tests/test-map-2.json").toFile());

		Resource resource = resourceSet.createResource(URI.createURI("test"));

		EObject a1 = EcoreUtil.create(eTypesClass);
		Collection values = (Collection) a1.eGet(eTypesClass.getEStructuralFeature("stringMapValues"));

		EObject v1 = EcoreUtil.create(valueClass);
		v1.eSet(valueClass.getEStructuralFeature("value"), 1);

		EObject v2 = EcoreUtil.create(valueClass);
		v2.eSet(valueClass.getEStructuralFeature("value"), 2);

		BasicEMapEntry<EObject, EObject> e1 = new BasicEMapEntry<>();
		e1.eSetClass(stringMapClass);
		e1.setKey("Hello");
		e1.setValue(v1);

		BasicEMapEntry<EObject, EObject> e2 = new BasicEMapEntry<>();
		e2.eSetClass(stringMapClass);
		e2.setKey("World");
		e2.setValue(v2);

		values.add(e1);
		values.add(e2);

		resource.getContents().add(a1);

		assertThat((JsonNode) mapper.valueToTree(resource)).
				isEqualTo(expected);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testLoadMapWithStringKey() {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-map-2.json"), true);

		assertThat(resource.getContents()).hasSize(1);
		assertThat(resource.getContents().get(0).eClass())
				.isSameAs(eTypesClass);

		EObject types = resource.getContents().get(0);

		List<BasicEMap.Entry<String, EObject>> mapValues = (List<BasicEMap.Entry<String, EObject>>)
				types.eGet(eTypesClass.getEStructuralFeature("stringMapValues"));

		assertThat(mapValues)
				.hasSize(2);

		assertThat(mapValues.get(0).getKey()).isEqualTo("Hello");
		assertThat(1)
				.isEqualTo(valueOf(mapValues.get(0).getValue()));

		assertThat(mapValues.get(1).getKey()).isEqualTo("World");
		assertThat(2)
				.isEqualTo(valueOf(mapValues.get(1).getValue()));
	}

	private int valueOf(EObject value) {
		return (int) value.eGet(valueClass.getEStructuralFeature("value"));
	}

}
