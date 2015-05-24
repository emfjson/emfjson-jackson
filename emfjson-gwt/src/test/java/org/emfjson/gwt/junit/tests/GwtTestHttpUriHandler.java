/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.tests;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import org.emfjson.gwt.junit.model.ModelFactory;
import org.emfjson.gwt.junit.model.User;
import org.emfjson.gwt.junit.support.TestSupport;

import java.io.IOException;

public class GwtTestHttpUriHandler extends TestSupport {

	@Test
	public void testPostMethod() throws IOException {
		User u = ModelFactory.eINSTANCE.createUser();
		u.setUserId("1");

		Resource resource = resourceSet.createResource(URI.createURI(BASE_URI).appendSegment("test_post"));
		resource.getContents().add(u);

		delayTestFinish(500);
		resource.save(options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

}
