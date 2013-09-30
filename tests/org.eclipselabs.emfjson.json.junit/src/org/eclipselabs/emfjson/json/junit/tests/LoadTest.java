package org.eclipselabs.emfjson.json.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JField;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JString;
import org.eclipselabs.emfjson.json.JSONPackage;
import org.eclipselabs.emfjson.json.resource.JSONResourceFactory;
import org.junit.Before;
import org.junit.Test;

public class LoadTest {

	private final Map<String ,Object> options = new HashMap<String, Object>();
	private ResourceSet resourceSet;

	@Before
	public void tearUp() {
		EPackage.Registry.INSTANCE.put(JSONPackage.eNS_URI, JSONPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JSONResourceFactory());		
		resourceSet = new ResourceSetImpl();
		options.clear();
	}

	@Test
	public void testLoadSimpleObject() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-1.json"));
		resource.load(options);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof JObject);

		JObject node = (JObject) root;
		assertEquals(1, node.getFields().size());

		JField field = node.getFields().get(0);
		assertEquals("hello", field.getKey());
		assertTrue(field.getValue() instanceof JString);

		JString value = (JString) field.getValue();
		assertEquals("world", value.getStringValue());
	}

	@Test
	public void testLoadEmptyArray() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-2.json"));
		resource.load(options);

		assertEquals(1, resource.getContents().size());
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof JArray);
		
		JArray node = (JArray) root;
		assertEquals(0, node.getElements().size());
	}

	@Test
	public void testLoadStringArray() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-3.json"));
		resource.load(options);

		assertEquals(1, resource.getContents().size());
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof JArray);

		JArray node = (JArray) root;
		assertEquals(2, node.getElements().size());

		assertTrue(node.getElements().get(0) instanceof JString);
		assertTrue(node.getElements().get(1) instanceof JString);

		JString first = (JString) node.getElements().get(0);
		JString second = (JString) node.getElements().get(1);

		assertEquals("hello", first.getStringValue());
		assertEquals("world", second.getStringValue());
	}

	@Test
	public void testLoadMixArray() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-4.json"));
		resource.load(options);

		assertEquals(1, resource.getContents().size());
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof JArray);
		
		JArray node = (JArray) root;
		assertEquals(4, node.getElements().size());

		assertTrue(node.getElements().get(0) instanceof JNumber);
		JNumber first = (JNumber) node.getElements().get(0);
		assertEquals(1, first.getNumberValue());

		assertTrue(node.getElements().get(1) instanceof JNumber);
		JNumber second = (JNumber) node.getElements().get(1);
		assertEquals(2, second.getNumberValue());

		assertTrue(node.getElements().get(2) instanceof JString);
		JString third = (JString) node.getElements().get(2);
		assertEquals("hello", third.getStringValue());

		assertTrue(node.getElements().get(3) instanceof JObject);
		JObject fourth = (JObject) node.getElements().get(3);
		assertEquals(1, fourth.getFields().size());

		JField field = fourth.getFields().get(0);
		assertEquals("hello", field.getKey());
		assertTrue(field.getValue() instanceof JString);
		
		JString value = (JString) field.getValue();
		assertEquals("world", value.getStringValue());
	}

}
