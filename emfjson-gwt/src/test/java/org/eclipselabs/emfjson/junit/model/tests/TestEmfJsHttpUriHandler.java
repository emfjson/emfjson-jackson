/*******************************************************************************
 * Copyright (c) 2013 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.model.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.User;
import org.eclipselabs.emfjson.junit.model.support.TestSupport;
import org.junit.Test;

public class TestEmfJsHttpUriHandler extends TestSupport {

	@Test
	public void testPostMethod() throws IOException {
		User u = ModelFactory.eINSTANCE.createUser();
		u.setUserId("1");

		Resource resource = resourceSet.createResource(URI.createURI(BASE_URI).appendSegment("test_post"));
		resource.getContents().add(u);

		resource.save(options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				System.out.println("posted");
				finishTest();
			}
			@Override
			public void onFailure(Throwable caught) {
				finishTest();
			}
		});

		delayTestFinish(500);
	}

}
