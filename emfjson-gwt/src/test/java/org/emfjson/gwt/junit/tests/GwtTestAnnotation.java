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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import org.emfjson.gwt.junit.support.TestSupport;

import java.io.IOException;

public class GwtTestAnnotation extends TestSupport {

	private native JavaScriptObject annotationOne() /*-{
		return {
			"eClass":"http://www.eclipse.org/emf/2002/Ecore#//EClass",
			"name":"Foo", 
			"eAnnotations":[ {
				"eClass":"http://www.eclipse.org/emf/2002/Ecore#//EAnnotation",
				"source":"source", 
				"details": { 
					"displayName" : "bar"
				}
			} ]
		}
	}-*/;

	@Test
	public void testSaveAnnotation() throws IOException {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Foo");

		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setEModelElement(eClass);
		eAnnotation.setSource("source");
		eAnnotation.getDetails().put("displayName", "bar");
		eClass.getEAnnotations().add(eAnnotation);

		Resource resource = resourceSet.createResource(URI.createURI("test.json"));
		resource.getContents().add(eClass);

		isSame(annotationOne(), resource);
	}

	@Test
	public void testLoadAnnotation() throws IOException {
		delayTestFinish(200);

		parse(annotationOne(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);

				assertEquals(EcorePackage.Literals.ECLASS, root.eClass());

				EList<EAnnotation> annotations = ((EClass) root).getEAnnotations();

				assertEquals(1, annotations.size());

				EAnnotation annotation = annotations.get(0);
				assertEquals(1, annotation.getDetails().size());
				assertEquals("displayName", annotation.getDetails().get(0).getKey());

				assertEquals("bar", annotation.getDetails().get(0).getValue());

				finishTest();
			}
		});
	}

	private native JavaScriptObject annotationMany() /*-{
		return {
			"eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			"name" : "Foo", 
			"eAnnotations" : [
				{
					"eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EAnnotation",
					"source" : "source", 
					"details" : {
						"displayName":"bar"
					}
				},
				{
					"eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EAnnotation",
					"source":"source2", 
					"details" : {
						"displayName":"bar2",
						"displayName2":"bar3"
					}
				}
			]
		}
	}-*/;

	@Test
	public void testSaveManyAnnotations() throws IOException {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Foo");

		EAnnotation annotation1 = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation1.setEModelElement(eClass);
		annotation1.setSource("source");
		annotation1.getDetails().put("displayName", "bar");
		eClass.getEAnnotations().add(annotation1);

		EAnnotation annotation2 = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation2.setEModelElement(eClass);
		annotation2.setSource("source2");
		annotation2.getDetails().put("displayName", "bar2");
		annotation2.getDetails().put("displayName2", "bar3");
		eClass.getEAnnotations().add(annotation2);

		Resource resource = resourceSet.createResource(URI.createURI("test.json"));
		resource.getContents().add(eClass);

		isSame(annotationMany(), resource);
	}

	@Test
	public void testLoadManyAnnotations() throws IOException {
		delayTestFinish(200);

		parse(annotationMany(), new TestCallback() {
			@Override
			public void onSuccess(Resource resource) {
				assertEquals(1, resource.getContents().size());

				EObject root = resource.getContents().get(0);

				assertEquals(EcorePackage.Literals.ECLASS, root.eClass());

				EList<EAnnotation> annotations = ((EClass) root).getEAnnotations();

				assertEquals(2, annotations.size());

				EAnnotation firstAnnotation = annotations.get(0);
				assertEquals(1, firstAnnotation.getDetails().size());
				assertEquals("displayName", firstAnnotation.getDetails().get(0).getKey());
				assertEquals("bar", firstAnnotation.getDetails().get(0).getValue());

				EAnnotation secondAnnotation = annotations.get(1);
				assertEquals(2, secondAnnotation.getDetails().size());
				assertEquals("displayName", secondAnnotation.getDetails().get(0).getKey());
				assertEquals("bar2", secondAnnotation.getDetails().get(0).getValue());
				assertEquals("displayName2", secondAnnotation.getDetails().get(1).getKey());
				assertEquals("bar3", secondAnnotation.getDetails().get(1).getValue());

				finishTest();
			}
		});
	}

}
