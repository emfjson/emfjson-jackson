/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.junit.tests;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.emfjson.jackson.resource.*;
import org.emfjson.jackson.update.*;
import org.junit.*;

import static org.junit.Assert.*;

public class UpdateObjectTest {

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testUpdateSingleObject() throws JsonProcessingException {
		JsonNode data = mapper.createObjectNode()
				.put("eClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass")
				.put("name", "B");

		Resource r = new JsonResource();
		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName("A");
		r.getContents().add(c);

		new ObjectUpdater().update(c, data, null);

		assertEquals("B", c.getName());
	}

}