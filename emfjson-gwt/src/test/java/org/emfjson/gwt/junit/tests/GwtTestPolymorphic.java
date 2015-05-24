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

import com.google.gwt.core.client.JavaScriptObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import org.emfjson.EMFJs;
import org.emfjson.gwt.junit.model.*;
import org.emfjson.gwt.junit.support.TestSupport;

import java.io.IOException;

public class GwtTestPolymorphic extends TestSupport {

	private static native JavaScriptObject firstTest() /*-{
		return {
			"eClass" : "http://www.eclipselabs.org/emfjson/junit#//Container",
			"elements" : [
				{
					"eClass" : "http://www.eclipselabs.org/emfjson/junit#//ConcreteTypeOne",
					"name" : "First"
				},
				{
					"eClass" : "http://www.eclipselabs.org/emfjson/junit#//ConcreteTypeTwo",
					"name" : "Two"
				}
			]
		}
	}-*/;

	@Test
	public void testSaveTwoObjectsWithTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("types.json"));

		Container c = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		one.setName("First");

		ConcreteTypeTwo two = ModelFactory.eINSTANCE.createConcreteTypeTwo();
		two.setName("Two");
		c.getElements().add(one);
		c.getElements().add(two);

		resource.getContents().add(c);

		isSame(firstTest(), resource);
	}

	@Test
	public void testLoadTwoObjectsWithTypeInformation() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());

		delayTestFinish(500);
		asyncLoad("test-load-types.json", new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);
				assertTrue(root instanceof Container);

				Container container = (Container) root;

				assertEquals(2, container.getElements().size());
				AbstractType first = container.getElements().get(0);
				AbstractType second = container.getElements().get(1);

				assertTrue(first instanceof ConcreteTypeOne);
				assertTrue(second instanceof ConcreteTypeTwo);

				assertEquals("First", first.getName());
				assertEquals("one", ((ConcreteTypeOne) first).getPropTypeOne());
				assertEquals("Two", second.getName());
				assertEquals("two", ((ConcreteTypeTwo) second).getPropTypeTwo());

				finishTest();
			}
		});
	}

	@Test
	public void testLoadTwoObjectsWithReferenceAndTypeInformation() throws IOException {
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());

		delayTestFinish(500);
		asyncLoad("test-load-types-2.json", new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);
				assertTrue(root instanceof Container);

				Container container = (Container) root;

				assertEquals(2, container.getElements().size());
				AbstractType first = container.getElements().get(0);
				AbstractType second = container.getElements().get(1);

				assertTrue(first instanceof ConcreteTypeOne);
				assertTrue(second instanceof ConcreteTypeTwo);

				assertEquals(1, first.getRefProperty().size());

				EObject ref = first.getRefProperty().get(0);

				assertSame(second, ref);

				finishTest();
			}
		});
	}

}
