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
package org.emfjson.gwt.junit.support;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.junit.client.GWTTestCase;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.emfjson.EMFJs;
import org.emfjson.gwt.handlers.HttpHandler;
import org.emfjson.gwt.junit.model.ModelPackage;
import org.emfjson.gwt.map.JsonMapper;
import org.emfjson.gwt.resource.JsonResourceFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.emfjson.gwt.junit.support.JsonHelper.stringify;

public abstract class TestSupport extends GWTTestCase {

	protected final Map<String, Object> options = new HashMap<>();
	protected String baseURI = "http://eclipselabs.org/emfjson/tests/";
	protected String BASE_URI = "http://eclipselabs.org/emfjson/tests";
	protected ResourceSet resourceSet;

	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);
		resourceSet = new ResourceSetImpl();

		resourceSet.getURIConverter().getURIHandlers().add(0, new HttpHandler());
		resourceSet.getURIConverter().getURIMap().put(
			URI.createURI(baseURI),
			URI.createURI(GWT.getHostPageBaseURL() + "model/"));
	}

	protected void asyncLoad(String resource, Callback<Resource> callback) {
		URI uri = URI.createURI(baseURI + resource);
		try {
			resourceSet.createResource(uri).load(options, callback);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void asyncLoad(URI uri, Callback<Resource> callback) {
		try {
			resourceSet.createResource(uri).load(options, callback);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected URI uri(String fileName) {
		return URI.createURI(baseURI + fileName, true);
	}

	protected void isSame(JavaScriptObject expected, Resource actual) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			actual.save(outStream, options);
		} catch (IOException e) {
			e.printStackTrace();
			assertNull(e);
		}

		assertEquals(
			stringify(expected).replaceAll("(\\s|\\t)", ""),
			new String(outStream.toByteArray()).replaceAll("\\s", ""));
	}

	protected void parse(JavaScriptObject js, TestCallback callback) {
		delayTestFinish(100);
		Resource resource = resourceSet.createResource(URI.createURI("tests/test.json"));
		JsonMapper mapper = new JsonMapper();
		mapper.parse(resource, new ByteArrayInputStream(stringify(js).getBytes()), options, callback);
	}

	@Override
	public String getModuleName() {
		return "org.emfjson.gwt.junit.Model";
	}

	protected static abstract class TestCallback implements Callback<Resource> {
		@Override
		public void onFailure(Throwable caught) {
			assertNull(caught);
		}
	}
}
