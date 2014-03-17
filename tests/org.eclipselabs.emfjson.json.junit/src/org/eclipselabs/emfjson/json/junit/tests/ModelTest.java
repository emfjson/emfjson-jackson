package org.eclipselabs.emfjson.json.junit.tests;

import static org.junit.Assert.assertEquals;

import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JSONFactory;
import org.eclipselabs.emfjson.json.JValue;
import org.junit.Test;

public class ModelTest {

	@Test
	public void testCreateObject() {
		JObject o = JSONFactory.eINSTANCE.createJObject();
		o.put("hello", 0);

		assertEquals("0", ((JValue) o.get("hello")).asText());
	}

}
