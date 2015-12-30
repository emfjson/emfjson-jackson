package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicMapTest {

	private ObjectMapper mapper = new ObjectMapper();

	private EClass eTypesClass, typeClass, valueClass, tmapClass;
	private ResourceSetImpl resourceSet;

	@Before
	public void setUp() {
		URI modelURI = URI.createURI("http://www.emfjson.org/jackson/model");

		resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new JsonResourceFactory());

		resourceSet.getPackageRegistry()
				.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		resourceSet.getURIConverter()
				.getURIMap()
				.put(
						modelURI,
						URI.createURI("src/test/resources/model/dynamic/model-2.json"));

		final Resource resource = resourceSet.getResource(modelURI, true);
		final EPackage ePackage = (EPackage) resource.getContents().get(0);

		resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);

		eTypesClass = (EClass) ePackage.getEClassifier("ETypes");
		tmapClass = (EClass) ePackage.getEClassifier("TMap");
		typeClass = (EClass) ePackage.getEClassifier("Type");
		valueClass = (EClass) ePackage.getEClassifier("Value");

		mapper.registerModule(new EMFModule(resourceSet));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSaveMap() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("test"));

		EObject a1 = EcoreUtil.create(eTypesClass);

		EObject key = EcoreUtil.create(typeClass);
		key.eSet(typeClass.getEStructuralFeature("name"), "t1");

		EObject value = EcoreUtil.create(valueClass);
		value.eSet(valueClass.getEStructuralFeature("value"), 1);

		BasicEMapEntry<EObject, EObject> entry = new BasicEMapEntry<>();
		entry.eSetClass(tmapClass);
		entry.setKey(key);
		entry.setValue(value);

		Collection values = (Collection) a1.eGet(eTypesClass.getEStructuralFeature("values"));
		values.add(entry);

		resource.getContents().add(a1);

		JsonNode actual = mapper.valueToTree(resource);

		assertThat(actual.get("values"))
				.hasSize(1)
				.contains(
						((ObjectNode) mapper.createObjectNode()
								.set("key", mapper.createObjectNode()
										.put("eClass", "http://www.emfjson.org/jackson/model#//Type")
										.put("name", "t1")))
								.set("value", mapper.createObjectNode()
										.put("eClass", "http://www.emfjson.org/jackson/model#//Value")
										.put("value", 1)));
	}

	@Test
	public void testLoadMap() {
		Resource resource = resourceSet.getResource(URI.createURI("src/test/resources/tests/test-map-1.json"), true);

		assertThat(resource.getContents()).hasSize(1);
		assertThat(resource.getContents().get(0).eClass())
				.isSameAs(eTypesClass);

		EObject types = resource.getContents().get(0);

		assertThat((Collection) types.eGet(eTypesClass.getEStructuralFeature("values")))
				.hasSize(2);
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
