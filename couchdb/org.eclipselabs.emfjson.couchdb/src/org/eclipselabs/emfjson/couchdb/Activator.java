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
package org.eclipselabs.emfjson.couchdb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipselabs.emfjson.EJs;
import org.eclipselabs.examples.library.Book;
import org.eclipselabs.examples.library.LibraryFactory;
import org.eclipselabs.examples.library.LibraryPackage;
import org.eclipselabs.examples.library.LibraryShelf;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIHandlers().add(0, new CouchDBHandler());
		
		LibraryShelf aShelf = LibraryFactory.eINSTANCE.createLibraryShelf();
		aShelf.setName("My Shelf");
		
		Book aBook = LibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Oui Oui");
		aBook.setNumPages(235);
		aShelf.getItems().add(aBook);
		
		Resource resource = resourceSet.createResource(URI.createURI("http://127.0.0.1:5984/emfjson_test"));
		System.out.println(resource);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EJs.OPTION_INDENT_OUTPUT, true);
		options.put(EJs.OPTION_SERIALIZE_TYPE, true);
		
//		resource.delete(options);

		resource.getContents().add(aShelf);
		resource.save(options);
		
		resource.getContents().clear();
		
		resource.unload();
		System.out.println("reload "+resource.getURI());
		options.put(EJs.OPTION_ROOT_ELEMENT, LibraryPackage.eINSTANCE.getLibraryShelf());
		resource.load(options);
		
		System.out.println("loaded "+resource.getContents());
		
		LibraryShelf shelf = (LibraryShelf) resource.getContents().get(0);
		shelf.setName("UpdateShelf");
		System.out.println(shelf.getName());
		System.out.println(shelf.getItems());
		resource.save(options);
		
		shelf.setName("OtherShelf");
		resource.save(options);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
