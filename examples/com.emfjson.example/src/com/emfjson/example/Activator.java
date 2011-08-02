/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package com.emfjson.example;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.emfjson.emf.JsURIHandlerImpl;
import com.emfjson.example.model.Child;
import com.emfjson.example.model.ModelFactory;
import com.emfjson.example.model.ModelPackage;
import com.emfjson.example.model.Parent;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting EMFJs example");
		
		ResourceSet resourceSet = new ResourceSetImpl();
	
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new JsURIHandlerImpl());
		
		Resource resource = resourceSet.createResource(URI.createURI("file:/C:/model/out.json"));
		
		Parent parent = ModelFactory.eINSTANCE.createParent();
		parent.setId("1");
		
		Child c1 = ModelFactory.eINSTANCE.createChild();
		c1.setId("11");
		Child c2 = ModelFactory.eINSTANCE.createChild();
		c2.setId("12");
		Child c3 = ModelFactory.eINSTANCE.createChild();
		c3.setId("13");
		
		parent.getChildren().add(c1);
		parent.getChildren().add(c2);
		parent.getChildren().add(c3);
		
		resource.getContents().add(parent);

		System.out.println("saving json to file: "+resource.getURI());
		resource.save(null);

		Resource load = resourceSet.createResource(URI.createURI("file:/C:/model/out.json"));
		Map<String ,Object> options = new HashMap<String, Object>();
		options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getParent());
		
		System.out.println("loading json from file: "+load.getURI());
		load.load(options);
		
		Parent p = (Parent) load.getContents().get(0);
		
		System.out.println(p);
		
		for (Child c: p.getChildren())
			System.out.println("    "+c);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
