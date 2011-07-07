package com.emfjson.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Before;
import org.junit.Test;

import com.emfjson.js.base.JsBaseLoader;
import com.emfjson.junit.model.Address;
import com.emfjson.junit.model.ModelPackage;
import com.emfjson.junit.model.User;
import com.emfjson.resource.JsResource;

/**
 * 
 * @author guillaume
 *
 */
public class JsLoaderTest {

	final Map<String ,Object> options = new HashMap<String, Object>();
	
	@Before
	public void tearUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
	}
	
	@Test
	public void testLoadSingleObjectNoReferences() {
		String json = "{\"userId\":\"1\",\"name\":\"Paul\"}";
		
		JsBaseLoader loader = new JsBaseLoader();
		options.put(JsResource.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		Collection<EObject> objects = loader.loadFromInputStream(new ByteArrayInputStream(json.getBytes()), options);
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(1, objects.size());
		
		EObject obj = objects.iterator().next();
		
		assertTrue(obj instanceof User);
		assertEquals("1", ((User) obj).getUserId());
		assertEquals("Paul", ((User) obj).getName());
	}
	
	@Test
	public void testLoadSingleObjectOneContainment() {
		String json = 
				"{" +
					"\"userId\":\"1\"," +
					"\"name\": \"Paul\", " +
					"\"address\" : { " +
						"\"addId\" : \"a1\", " +
						"\"city\" : \"Paris\",  " +
						"\"street\" : \"la rue\", " +
						"\"number\" : 12 " +
					"} " +
				"}";
		
		JsBaseLoader loader = new JsBaseLoader();
		options.put(JsResource.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		Collection<EObject> objects = loader.loadFromInputStream(new ByteArrayInputStream(json.getBytes()), options);
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(1, objects.size());
		
		EObject obj = objects.iterator().next();
		
		assertTrue(obj instanceof User);
		assertEquals("1", ((User) obj).getUserId());
		assertEquals("Paul", ((User) obj).getName());
		
		assertNotNull(((User) obj).getAddress());
		
		Address add = ((User) obj).getAddress();
		assertEquals("a1", add.getAddId());
		assertEquals("Paris", add.getCity());
		assertEquals("la rue", add.getStreet());
		assertEquals(new Integer(12), add.getNumber());
	}
	
	@Test
	public void testLoadObjectsInArray() {
		String json = "[" +
				"{\"userId\":\"1\",\"name\":\"Paul\"}," +
				"{\"userId\":\"2\",\"name\":\"Pierre\"}" +
			"]";
		
		JsBaseLoader loader = new JsBaseLoader();
		options.put(JsResource.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		Collection<EObject> objects = loader.loadFromInputStream(new ByteArrayInputStream(json.getBytes()), options);
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(2, objects.size());
	}
	
	@Test
	public void testLoadObjectsWithReference() {
		String json = "[" +
				"{\"userId\":\"1\",\"name\":\"Paul\", \"friends\" : [{\"$ref\" : \"2\"}] }," +
				"{\"userId\":\"2\",\"name\":\"Pierre\"}" +
			"]";
		
		JsBaseLoader loader = new JsBaseLoader();
		options.put(JsResource.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
		Collection<EObject> objects = loader.loadFromInputStream(new ByteArrayInputStream(json.getBytes()), options);
		
		assertNotNull(objects);
		assertFalse(objects.isEmpty());
		assertEquals(2, objects.size());
		
		EObject obj = objects.iterator().next();
		assertTrue(obj instanceof User);
		assertFalse(((User) obj).getFriends().isEmpty());
	}
}
