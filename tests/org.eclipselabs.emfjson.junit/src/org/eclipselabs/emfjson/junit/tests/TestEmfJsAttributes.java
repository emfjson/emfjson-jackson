/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.ETypes;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.Node;
import org.eclipselabs.emfjson.junit.model.ObjectWithMap;
import org.eclipselabs.emfjson.junit.model.PrimaryObject;
import org.eclipselabs.emfjson.junit.model.Sex;
import org.eclipselabs.emfjson.junit.model.User;
import org.eclipselabs.emfjson.junit.support.TestSupport;
import org.junit.Test;

/**
 * 
 * @author guillaume
 * 
 */
public class TestEmfJsAttributes extends TestSupport {

	@Test
	public void testStringValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eString\":\"Hello\",\"eStrings\":[\"Hello\",\"World\"]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEString("Hello");

		String[] arrayValue = new String[] { "Hello", "World" };
		valueObject.getEStrings().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testIntValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eInt\":1,\"eInts\":[1,2]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEInt(1);

		Integer[] arrayValue = new Integer[] { 1, 2 };
		valueObject.getEInts().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadIntValues() throws IOException {
		String inputString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eInt\":1,\"eInts\":[1,2]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		EList<Integer> ints = ((ETypes) root).getEInts();
		assertEquals(2, ints.size());
		assertTrue(1 == ints.get(0));
		assertTrue(2 == ints.get(1));
	}

	@Test
	public void testBooleanValues() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eBoolean\":true,\"eBooleans\":[false,true]}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBoolean(true);

		Boolean[] arrayValue = new Boolean[] { false, true };
		valueObject.getEBooleans().addAll(Arrays.asList(arrayValue));

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testDateValue() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eDate\":\"2011-10-10T00:00:00\"}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		Date value = (Date) EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(), "2011-10-10");

		valueObject.setEDate(value);

		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testBigIntegerValue() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eBigInteger\":\"15\"}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBigInteger(new BigInteger("15"));
		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadBigIntegerValue() throws IOException {
		String inputString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eBigInteger\":\"15\"}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		BigInteger value = ((ETypes) root).getEBigInteger();

		assertEquals(new BigInteger("15"), value);
	}

	@Test
	public void testByteValue() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eByte\":\"1\"}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		byte b = 1;
		valueObject.setEByte(b);
		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testBigDecimalValue() throws IOException {
		String expectedString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eBigDecimal\":\"1.5\"}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		ETypes valueObject = ModelFactory.eINSTANCE.createETypes();
		valueObject.setEBigDecimal(new BigDecimal(1.5));
		resource.getContents().add(valueObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadBigDecimalValue() throws IOException {
		String inputString = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//ETypes\",\"eBigDecimal\":1.5}";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null);

		assertEquals(1, resource.getContents().size());

		EObject root = resource.getContents().get(0);
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass());

		BigDecimal value = ((ETypes) root).getEBigDecimal();

		assertEquals(new BigDecimal(1.5), value);
	}

	@Test
	public void testEnums() throws IOException {
		String expectedString = "["
				+ "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"sex\":\"MALE\"},"
				+ "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"sex\":\"FEMALE\"}]";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		User u1 = ModelFactory.eINSTANCE.createUser();
		u1.setSex(Sex.MALE);

		User u2 = ModelFactory.eINSTANCE.createUser();
		u2.setSex(Sex.FEMALE);

		resource.getContents().add(u1);
		resource.getContents().add(u2);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadEnums() throws IOException {
		String inputString = "[{\"name\":\"A\",\"sex\":\"MALE\"},{\"name\":\"B\",\"sex\":\"FEMALE\"}]";

		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));

		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);
		ByteArrayInputStream inStream = new ByteArrayInputStream(inputString.getBytes());
		resource.load(inStream, options);

		assertEquals(2, resource.getContents().size());

		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(0).eClass());
		assertEquals(ModelPackage.Literals.USER, resource.getContents().get(1).eClass());

		User u1 = (User) resource.getContents().get(0);
		User u2 = (User) resource.getContents().get(1);

		assertEquals("A", u1.getName());
		assertEquals(Sex.MALE, u1.getSex());
		assertEquals("B", u2.getName());
		assertEquals(Sex.FEMALE, u2.getSex());
	}

	@Test
	public void testSaveFeatureMap() throws IOException {
		String expectedString = 
				"{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//PrimaryObject\","
				+ "\"name\":\"junit\","
				+ "\"featureMapAttributeType1\":\"Hello\","
				+ "\"featureMapAttributeType2\":\"World\"}";

		PrimaryObject primaryObject = ModelFactory.eINSTANCE.createPrimaryObject();
		primaryObject.setName("junit");

		primaryObject.getFeatureMapAttributeType1().add("Hello");
		primaryObject.getFeatureMapAttributeType2().add("World");

		assertEquals(2, primaryObject.getFeatureMapAttributeCollection().size());
		assertEquals(1, primaryObject.getFeatureMapAttributeType1().size());
		assertEquals(1, primaryObject.getFeatureMapAttributeType2().size());

		Resource resource = resourceSet.createResource(URI.createURI("test.json"));
		resource.getContents().add(primaryObject);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadFeatureMap() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-load-feature-map.json"));
		resource.load(null);
		
		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof PrimaryObject);
		
		PrimaryObject o = (PrimaryObject) resource.getContents().get(0);
		assertEquals("junit", o.getName());
		assertEquals("Hello", o.getFeatureMapAttributeType1().get(0));
		assertEquals("World", o.getFeatureMapAttributeType2().get(0));
		assertEquals(2, o.getFeatureMapAttributeCollection().size());
	}

	@Test
	public void testLoadOneObjectWithTypeFromFile() throws IOException {
		Resource resource = resourceSet.createResource(uri("test-load-1.json"));
		assertNotNull(resource);
		resource.load(null);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof User);

		User user = (User) resource.getContents().get(0);
		assertEquals("1", user.getUserId());
		assertEquals("Paul", user.getName());
	}

	@Test
	public void testLoadOneObjectWithTypeFromInputStream() throws IOException {
		String data = "{\"eClass\":\"http://www.eclipselabs.org/emfjson/junit#//User\",\"userId\":\"1\",\"name\":\"Paul\"}";
		ByteArrayInputStream inStream = new ByteArrayInputStream(data.getBytes());
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		assertNotNull(resource);
		resource.load(inStream, null);

		assertEquals(1, resource.getContents().size());
		assertTrue(resource.getContents().get(0) instanceof User);

		User user = (User) resource.getContents().get(0);
		assertEquals("1", user.getUserId());
		assertEquals("Paul", user.getName());
	}

	@Test
	public void testOptionProxyAttributesWithID() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true);
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);
		Resource resource = resourceSet.createResource(uri("test-proxy-1.json"));
		resource.load(options);

		User u1 = (User) resource.getContents().get(0);
		assertNotNull(u1);
		assertFalse(u1.eIsProxy());

		assertEquals(1, u1.getFriends().size());

		User u2 = u1.getFriends().get(0);
		assertTrue(u2.eIsProxy());

		assertEquals("2", u2.getUserId());
		assertEquals("Pierre", u2.getName());

		assertNotNull(u1.getUniqueFriend());
		assertTrue(u1.getUniqueFriend().eIsProxy());

		assertEquals("3", u1.getUniqueFriend().getUserId());
		assertEquals("Paul", u1.getUniqueFriend().getName());
	}

	@Test
	public void testOptionProxyAttributes() throws IOException {
		options.put(EMFJs.OPTION_PROXY_ATTRIBUTES, true);

		Resource resource = resourceSet.createResource(uri("test-proxy-3.json"));
		resource.load(options);

		Node node = (Node) resource.getContents().get(0);
		assertNotNull(node);

		InternalEList<?> proxies = (InternalEList<?>) node.eGet(ModelPackage.Literals.NODE__MANY_REF, false);
		assertEquals(3, proxies.size());

		assertTrue(((InternalEObject) proxies.basicGet(0)).eIsProxy());
		assertTrue(((InternalEObject) proxies.basicGet(1)).eIsProxy());
		assertTrue(((InternalEObject) proxies.basicGet(2)).eIsProxy());

		assertEquals("2", ((Node) proxies.basicGet(0)).getLabel());
		assertEquals("21", ((Node) proxies.basicGet(1)).getLabel());
		assertEquals("3", ((Node) proxies.basicGet(2)).getLabel());

		assertNotNull(node.getSource());

		assertTrue(node.getSource().eIsProxy());
		assertEquals("2121", node.getSource().getLabel());

		Node node2 = (Node) resource.getContents().get(1);
		assertNotNull(node2);

		InternalEList<?> proxies2 = (InternalEList<?>) node2.eGet(ModelPackage.Literals.NODE__MANY_REF, false);
		assertEquals(2, proxies2.size());

		assertTrue(((InternalEObject) proxies2.basicGet(0)).eIsProxy());
		assertTrue(((InternalEObject) proxies2.basicGet(1)).eIsProxy());

		assertEquals("311", ((Node) proxies2.basicGet(0)).getLabel());
		assertEquals("3112", ((Node) proxies2.basicGet(1)).getLabel());
	}

	@Test
	public void testLoadRootObjectMap() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.OBJECT_WITH_MAP);
		Resource resource = resourceSet.createResource(uri("test-map-anon-root.json"));
		resource.load(options);

		ObjectWithMap root = (ObjectWithMap) resource.getContents().get(0);

		assertEquals("https://api.opscode.com/organizations/chefclipse/nodes/server-64668.novalocal", root.getEntries().get("server-64668.novalocal"));
		assertEquals("https://api.opscode.com/organizations/chefclipse/nodes/server-64642.novalocal", root.getEntries().get("server-64642.novalocal"));
		assertEquals("https://api.opscode.com/organizations/chefclipse/nodes/server-253389.novalocal", root.getEntries().get("server-253389.novalocal"));
	}

	@Test
	public void testSaveRootObjectMap() throws IOException {
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);
		Resource resource = resourceSet.createResource(uri("test-map.json"));

		ObjectWithMap root = ModelFactory.eINSTANCE.createObjectWithMap();
		root.getEntries().put("one", "1");
		root.getEntries().put("two", "2");
		root.getEntries().put("three", "3");

		resource.getContents().add(root);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		resource.save(outStream, options);
		assertEquals("{\"one\":\"1\",\"two\":\"2\",\"three\":\"3\"}", new String(outStream.toByteArray()));
	}

}
