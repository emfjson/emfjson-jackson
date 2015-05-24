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
import com.google.gwt.junit.client.GWTTestCase;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import org.emfjson.gwt.junit.model.ModelPackage;
import org.emfjson.gwt.junit.model.Node;
import org.emfjson.gwt.junit.model.User;
import org.emfjson.gwt.map.JsonMapper;
import org.emfjson.gwt.resource.JsonResourceFactory;

import java.util.Map;

import static org.emfjson.gwt.junit.support.JsonHelper.stringify;

public class GwtTestSimple extends GWTTestCase {

	private Map<?, ?> options = null;
	private Resource resource;
	private JsonMapper mapper;

	public static native JavaScriptObject oneObject() /*-{
	  return {
	  	'eClass':'http://www.eclipselabs.org/emfjson/junit#//User',
	  	'userId':'1',
	  	'name':'Paul'
	  };
	}-*/;

	public static native JavaScriptObject twoObject() /*-{
	  return [
	  	{
	  		'eClass':'http://www.eclipselabs.org/emfjson/junit#//User'
	  	},
	  	{
	  		'eClass':'http://www.eclipselabs.org/emfjson/junit#//User'
	  	}
	  ]
	}-*/;

	public static native JavaScriptObject oneObjectWithOneChild() /*-{
	  return {
	  	'eClass':'http://www.eclipselabs.org/emfjson/junit#//User',
	  	'userId':'1',
	  	'name':'Paul',
	  	'address' : {
	  		'eClass':'http://www.eclipselabs.org/emfjson/junit#//Address',
			'addId': 'a1',
			'city': 'Paris',
			'street': 'la rue',
			'number': 12
		}
	  };
	}-*/;

	public static native JavaScriptObject oneObjectWithTwoChild() /*-{
	  return {
	  	'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
	  	'label':'1',
	  	'child' : [
	  		{
	  			'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
				'label': '2'
			},
			{
	  			'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
				'label': '3'
			}
		]
	  };
	}-*/;

	public static native JavaScriptObject oneObjectWithDeepChild() /*-{
	  return {
	  	'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
	  	'label':'1',
	  	'child' : [
	  		{
	  			'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
				'label': '2',
				'child' : [
					{
	  					'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
						'label': '21',
						'child' : [
							{
	  							'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
								'label': '211'
							},
							{
	  							'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
								'label': '212'
							}
						]
					},
					{
	  					'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
						'label': '22'
					}
				]
			},
			{
	  			'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
				'label': '3',
	  			'child' : [
	  				{
	  					'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
						'label': '31'
					},
					{
	  					'eClass':'http://www.eclipselabs.org/emfjson/junit#//Node',
						'label': '32'
					}
				]
			}
		]
	  };
	}-*/;

	public static native JavaScriptObject oneObjectWithReference() /*-{
		return {
			"eClass" : "http://www.eclipselabs.org/emfjson/junit#//Node",
			"manyRef" : [
				{
					"$ref" : "//@child.0"
				}
			],
			"child" : [
				{
					"eClass" : "http://www.eclipselabs.org/emfjson/junit#//Node",
					"label" : "Child 1"
				}
			]
		};
	}-*/;

	@Override
	protected void gwtSetUp() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

		resource = resourceSet.createResource(URI.createURI("test"));
		mapper = new JsonMapper();
	}

	@Test
	public void testOneObject() {
		assertNotNull(resource);

		delayTestFinish(100);

		mapper.parse(resource, stringify(oneObject()), options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				assertEquals(1, result.getContents().size());
				assertEquals(ModelPackage.Literals.USER, result.getContents().get(0).eClass());

				User user = (User) result.getContents().get(0);
				assertEquals("1", user.getUserId());
				assertEquals("Paul", user.getName());
				assertNull(user.getAddress());

				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

	@Test
	public void testTwoObject() {
		assertNotNull(resource);

		delayTestFinish(100);

		mapper.parse(resource, stringify(twoObject()), options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				assertEquals(2, result.getContents().size());
				assertEquals(ModelPackage.Literals.USER, result.getContents().get(0).eClass());
				assertEquals(ModelPackage.Literals.USER, result.getContents().get(1).eClass());

				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

	@Test
	public void testOneObjectOneContainment() {
		assertNotNull(resource);

		delayTestFinish(100);

		mapper.parse(resource, stringify(oneObjectWithOneChild()), options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				assertEquals(1, result.getContents().size());
				assertEquals(ModelPackage.Literals.USER, result.getContents().get(0).eClass());

				User user = (User) result.getContents().get(0);
				assertEquals("1", user.getUserId());
				assertEquals("Paul", user.getName());
				assertNotNull(user.getAddress());
				assertEquals("a1", user.getAddress().getAddId());
				assertEquals("Paris", user.getAddress().getCity());
				assertEquals("la rue", user.getAddress().getStreet());
				assertEquals(12, (int) user.getAddress().getNumber());

				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

	@Test
	public void testOneObjectTwoChild() {
		assertNotNull(resource);

		delayTestFinish(100);

		mapper.parse(resource, stringify(oneObjectWithTwoChild()), options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				assertEquals(1, result.getContents().size());
				assertEquals(ModelPackage.Literals.NODE, result.getContents().get(0).eClass());

				Node n1 = (Node) result.getContents().get(0);
				assertEquals("1", n1.getLabel());
				assertEquals(2, n1.getChild().size());
				assertEquals("2", n1.getChild().get(0).getLabel());
				assertEquals("3", n1.getChild().get(1).getLabel());

				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

	@Test
	public void testOneObjectDeepChild() {
		assertNotNull(resource);

		delayTestFinish(100);

		mapper.parse(resource, stringify(oneObjectWithDeepChild()), options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				assertEquals(1, result.getContents().size());
				assertEquals(ModelPackage.Literals.NODE, result.getContents().get(0).eClass());

				Node n1 = (Node) result.getContents().get(0);
				assertEquals("1", n1.getLabel());
				assertEquals(2, n1.getChild().size());

				Node n2 = n1.getChild().get(0);
				assertEquals("2", n2.getLabel());
				assertEquals(2, n2.getChild().size());

				Node n21 = n2.getChild().get(0);
				assertEquals(2, n21.getChild().size());

				Node n3 = n1.getChild().get(1);
				assertEquals("3", n3.getLabel());
				assertEquals(2, n3.getChild().size());

				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

	@Test
	public void testOneObjectWithOneRef() {
		assertNotNull(resource);

		delayTestFinish(100);

		mapper.parse(resource, stringify(oneObjectWithReference()), options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);
				assertEquals(1, result.getContents().size());
				assertEquals(ModelPackage.Literals.NODE, result.getContents().get(0).eClass());

				Node n1 = (Node) result.getContents().get(0);
				assertEquals(1, n1.getChild().size());
				assertEquals(1, n1.getManyRef().size());

				Node n2 = n1.getChild().get(0);
				Node n2ref = n1.getManyRef().get(0);

				assertEquals(n2, n2ref);

				finishTest();
			}

			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
				finishTest();
			}
		});
	}

	@Override
	public String getModuleName() {
		return "org.emfjson.gwt.junit.Model";
	}

}