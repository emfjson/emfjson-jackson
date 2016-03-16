/*
 * Copyright (c) 2016 Data In Motion UG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Juergen Albert - initial API and implementation
 *
 */
package org.emfjson.jackson.junit.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.junit.model.PrimaryObject;
import org.emfjson.jackson.junit.support.TestSupport;
import org.junit.Test;

public class NullValueInBetweenTest extends TestSupport {

	@Test
	public void testSaveOneRootObjectWithAttributes() throws IOException {
		
		Resource resource = resourceSet.createResource(URI.createURI("src/test/resources/tests/test-load-null-value-in-between.json"));
		assertNotNull(resource);

		resource.load(null);
		
		assertTrue(!resource.getContents().isEmpty());
		PrimaryObject type = (PrimaryObject) resource.getContents().get(0);
		
		assertNull(type.getName());
		assertNotNull(type.getFeatureMapAttributeType1());
		assertNotNull(type.getFeatureMapAttributeType2());
	}

}
