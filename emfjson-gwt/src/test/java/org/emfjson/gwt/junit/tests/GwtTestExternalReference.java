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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import org.emfjson.gwt.junit.support.TestSupport;

import java.util.Collection;
import java.util.Iterator;

public class GwtTestExternalReference extends TestSupport {

	@Test
	public void testLoadSingleInstance() {
		resourceSet.getURIConverter().getURIMap().put(
			URI.createURI("http://www.example.org/model"),
			URI.createURI(baseURI + "/model.json"));

		delayTestFinish(500);
		asyncLoad("instances-library-1.json", new TestCallback() {
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
		});
	}

	@Test
	public void testLoadSingleInstanceContainer() {
		resourceSet.getURIConverter().getURIMap().put(
			URI.createURI("http://www.example.org/model"),
			URI.createURI(baseURI + "/model.json"));

		delayTestFinish(500);
		asyncLoad("instances-library-2.json", new TestCallback() {
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
		});
	}
}