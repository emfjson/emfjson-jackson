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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.junit.model.support.TestSupport;
import org.junit.Test;

public class TestEmfJsExternalReferences extends TestSupport {

	@Test
	public void testLoadSingleInstance() {
		resourceSet.getURIConverter().getURIMap().put(
				URI.createURI("http://www.example.org/model"),
				URI.createURI(baseURI+"/model.json"));

		asyncLoad("instances-library-1.json", new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertEquals(1, result.getContents().size());

				EObject root = result.getContents().get(0);

				assertEquals("Library", root.eClass().getName());

				EAttribute attrName = (EAttribute) root.eClass().getEStructuralFeature("name");
				assertNotNull(attrName);

				assertEquals("My Library", root.eGet(attrName));

				finishTest();
			}
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
		});
		delayTestFinish(500);
	}
	
	@Test
	public void testLoadSingleInstanceContainer() {
		resourceSet.getURIConverter().getURIMap().put(
				URI.createURI("http://www.example.org/model"),
				URI.createURI(baseURI+"/model.json"));

		asyncLoad("instances-library-2.json", new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertEquals(1, result.getContents().size());

				EObject root = result.getContents().get(0);

				assertEquals("Library", root.eClass().getName());

				EAttribute attrName = (EAttribute) root.eClass().getEStructuralFeature("name");
				assertNotNull(attrName);

				assertEquals("My Library", root.eGet(attrName));
				
				EReference refBooks = (EReference) root.eClass().getEStructuralFeature("books");
				assertNotNull(refBooks);

				Collection<?> values = (Collection<?>) root.eGet(refBooks);
				assertNotNull(values);

				assertEquals(2, values.size());
				
				Iterator<?> it = values.iterator();
				
				EObject first = (EObject) it.next();
				EObject second = (EObject) it.next();

				assertEquals("Book", first.eClass().getName());
				assertEquals("Book", second.eClass().getName());

				EAttribute attrTitle = (EAttribute) first.eClass().getEStructuralFeature("title");

				assertEquals("Hobbit", first.eGet(attrTitle));
				assertEquals("Foundation", second.eGet(attrTitle));

				finishTest();
			}
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				finishTest();
			}
		});
		delayTestFinish(500);
	}
}