package org.eclipselabs.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.AbstractType;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeTwo;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.User;
import org.eclipselabs.emfjson.junit.support.TestSupport;
import org.junit.Test;

public class TestEmfJsNamespaces extends TestSupport {

	@Test
	public void testSaveTypesNamespacesForSingleRoot() throws IOException {
		String expectedString = "{\"@ns\":{"
				+ "\"model\":\"http://www.eclipselabs.org/emfjson/junit\""
				+ "},"
				+ "\"eClass\":\"model://User\","
				+ "\"userId\":\"1\","
				+ "\"sex\":\"MALE\"}";
		Resource resource = resourceSet.createResource(URI.createURI("tests/test_ns_1.json"));

		User user = ModelFactory.eINSTANCE.createUser();
		user.setUserId("1");

		resource.getContents().add(user);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_SERIALIZE_NAMESPACES, true);
		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testSaveTypesNamespacesForManyRoot() throws IOException {
		String expectedString = "[{\"@ns\":{"
				+ "\"model\":\"http://www.eclipselabs.org/emfjson/junit\"}"
				+ "},{"
				+ "\"eClass\":\"model://User\","
				+ "\"userId\":\"1\","
				+ "\"sex\":\"MALE\""
				+ "},{"
				+ "\"eClass\":\"model://User\","
				+ "\"userId\":\"2\","
				+ "\"sex\":\"MALE\""
				+ "}]";
		Resource resource = resourceSet.createResource(URI.createURI("tests/test_ns_2.json"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setUserId("1");

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setUserId("2");

		resource.getContents().add(u1);
		resource.getContents().add(u2);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_SERIALIZE_NAMESPACES, true);
		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testSaveRefNamespaces() throws IOException {
		String expectedString = "{\"@ns\":{" +
				"\"model\":\"http://www.eclipselabs.org/emfjson/junit\"," +
				"\"test_ns_3.json\":\"tests/test_ns_3.json\"},"+
				"\"eClass\":\"model://Container\","+
				"\"elements\":[{" +
				"\"eClass\":\"model://ConcreteTypeOne\","+
				"\"refProperty\":[{"+
				"\"$ref\":\"test_ns_3.json://@elements.1\","+
				"\"eClass\":\"model://ConcreteTypeOne\""+
				"}]},{"+
				"\"eClass\":\"model://ConcreteTypeOne\""+
				"}]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test_ns_3.json"));

		Container root = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne first = ModelFactory.eINSTANCE.createConcreteTypeOne();
		ConcreteTypeOne second = ModelFactory.eINSTANCE.createConcreteTypeOne();
		first.getRefProperty().add(second);
		root.getElements().add(first);
		root.getElements().add(second);

		resource.getContents().add(root);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_SERIALIZE_NAMESPACES, true);
		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadTwoObjectsWithReferenceAndTypeInformationAndNamespace() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-load-ns-types.json"));
		assertNotNull(resource);
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());

		resource.load(options);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);

		Container container = (Container) root;

		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);

		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);

		assertEquals(1, first.getRefProperty().size());

		EObject ref = first.getRefProperty().get(0);

		assertEquals(second, ref);
	}

}
