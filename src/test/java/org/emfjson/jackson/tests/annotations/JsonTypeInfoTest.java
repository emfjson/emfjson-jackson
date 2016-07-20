package org.emfjson.jackson.tests.annotations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.annotations.AnnotationsFactory;
import org.emfjson.jackson.junit.annotations.Foo;
import org.emfjson.jackson.junit.annotations.TestA;
import org.emfjson.jackson.module.EMFModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTypeInfoTest {

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE
				.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());
	}

	@After
	public void tearDown() {
		EPackage.Registry.INSTANCE.clear();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
	}

	@Test
	public void test() {
		JsonNode expected = mapper.createObjectNode()
				.put("@type", "Foo");

		Foo f = AnnotationsFactory.eINSTANCE.createFoo();

		assertThat(mapper.valueToTree(f))
				.isEqualTo(expected);
	}

}
