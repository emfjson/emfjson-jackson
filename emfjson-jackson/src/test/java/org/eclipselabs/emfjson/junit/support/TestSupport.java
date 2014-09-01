/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.support;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;
import org.junit.Before;

public abstract class TestSupport {

	protected final URL testURI = getClass().getResource("/tests");
	protected URI baseTestFilesFileDirectory = URI.createFileURI(testURI.getFile()).appendSegment("");
	protected String baseURI = "http://eclipselabs.org/emfjson/tests/";

	protected final Map<String, Object> options = new HashMap<String, Object>();
	protected ResourceSet resourceSet;

	@Before
	public void setUp() {
		URI baseURI = URI.createURI("http://eclipselabs.org/emfjson/tests/");

		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new JsResourceFactoryImpl());

		options.clear();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);

		resourceSet = new ResourceSetImpl();		
		resourceSet.getURIConverter().getURIMap().put(baseURI, baseTestFilesFileDirectory);
	}

	protected URI uri(String fileName) {
		return URI.createURI(baseURI + fileName, true);
	}
}
