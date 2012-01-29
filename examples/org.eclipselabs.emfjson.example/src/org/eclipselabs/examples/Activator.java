package org.eclipselabs.examples;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.EJs;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;
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

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());
		
		LibraryShelf aShelf = LibraryFactory.eINSTANCE.createLibraryShelf();
		aShelf.setName("My Shelf");
		
		Book aBook = LibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Oui Oui");
		aBook.setNumPages(234);
		aShelf.getItems().add(aBook);
		
		Resource resource = resourceSet.createResource(URI.createURI("platform:/resource/org.eclipselabs.emfjson.example/model.json"));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EJs.OPTION_INDENT_OUTPUT, true);
		options.put(EJs.OPTION_SERIALIZE_TYPE, false);
		
		resource.getContents().add(aShelf);
		resource.save(options);
	}
	
	public static void main(String[] args) throws IOException {
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());
		
		LibraryShelf aShelf = LibraryFactory.eINSTANCE.createLibraryShelf();
		aShelf.setName("My Shelf");
		
		Book aBook = LibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Oui Oui");
		aBook.setNumPages(234);
		aShelf.getItems().add(aBook);
		
		Resource resource = resourceSet.createResource(URI.createURI("model2.json"));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EJs.OPTION_INDENT_OUTPUT, true);
		options.put(EJs.OPTION_SERIALIZE_TYPE, false);
		
		resource.getContents().add(aShelf);
		resource.save(options);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
