package org.eclipselabs.emfjson.json.junit.tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JField;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JSONFactory;
import org.eclipselabs.emfjson.json.JSONPackage;
import org.eclipselabs.emfjson.json.JString;
import org.eclipselabs.emfjson.json.resource.JSONResourceFactory;
import org.junit.Before;
import org.junit.Test;

public class SaveTest {


	private final Map<String ,Object> options = new HashMap<String, Object>();
	private ResourceSet resourceSet;
	private JSONFactory factory = JSONFactory.eINSTANCE;


	@Before
	public void tearUp() {
		EPackage.Registry.INSTANCE.put(JSONPackage.eNS_URI, JSONPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JSONResourceFactory());		
		resourceSet = new ResourceSetImpl();
		options.clear();
	}


	@Test
	public void testSaveSingleEmptyObject() throws IOException {
		String expected = "{}";

		Resource js = resourceSet.createResource(URI.createURI("test.json"));

		JObject o = factory.createJObject();

		js.getContents().add(o);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		js.save(out, options);

		assertEquals(expected, new String(out.toByteArray()));
	}


	@Test
	public void testSaveSingleObjectWithFields() throws IOException {
		String expected = "{\"hello\":\"world\",\"two\":1,\"three\":true,\"four\":false}";

		Resource js = resourceSet.createResource(URI.createURI("test.json"));

		JObject o = factory.createJObject();

		{
			JField field = factory.createJField();
			field.setKey("hello");
			JString value = factory.createJString();
			value.setStringValue("world");
			field.setValue(value);
			o.getFields().add(field);
		}
		{
			JField field = factory.createJField();
			field.setKey("two");
			JNumber value = factory.createJNumber();
			value.setNumberValue(1);
			field.setValue(value);
			o.getFields().add(field);
		}
		{
			JField field = factory.createJField();
			field.setKey("three");
			JBoolean value = factory.createJBoolean();
			value.setBooleanValue(true);
			field.setValue(value);
			o.getFields().add(field);
		}
		{
			JField field = factory.createJField();
			field.setKey("four");
			JBoolean value = factory.createJBoolean();
			value.setBooleanValue(false);
			field.setValue(value);
			o.getFields().add(field);
		}

		js.getContents().add(o);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		js.save(out, options);

		assertEquals(expected, new String(out.toByteArray()));
	}


	@Test
	public void testSaveEmptyArray() throws IOException {
		String expected = "[]";

		Resource js = resourceSet.createResource(URI.createURI("test.json"));

		JArray a = factory.createJArray();

		js.getContents().add(a);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		js.save(out, options);

		assertEquals(expected, new String(out.toByteArray()));
	}


}
