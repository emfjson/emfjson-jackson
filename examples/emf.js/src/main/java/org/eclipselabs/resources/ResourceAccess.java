package org.eclipselabs.resources;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipselabs.emfjson.couchdb.CouchDBHandler;
import org.eclipselabs.emfjson.couchdb.internal.CouchDB;
import org.eclipselabs.emfjson.resource.JsResourceImpl;
import org.eclipselabs.model.library.Book;
import org.eclipselabs.model.library.LibraryFactory;
import org.eclipselabs.model.library.LibraryPackage;
import org.eclipselabs.model.library.LibraryShelf;

public class ResourceAccess {

	private static final ResourceSet resourceSet = new ResourceSetImpl();
	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
		resourceSet.getURIConverter().getURIHandlers().add(0, new CouchDBHandler());
	}
	protected static final String url = "http://127.0.0.1:5984/libraries";

	/**
	 * {"total_rows":9,"offset":0,"rows":[
	 *		{"id":"ee16fdb915274370e9976fc1fd00ad6f","key":"ee16fdb915274370e9976fc1fd00ad6f",
	 *		"value":{"rev":"1-967a00dff5e02add41819138abb3284d"}}
	 *
	 * @return
	 */
	public synchronized static String getListOfResources() {
		JsonNode node = CouchDB.getContent(URI.createURI(url).appendSegment("_all_docs"));
//		JsonNode rows = node.get("rows");
		
		return node.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, LibraryPackage.eINSTANCE);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIHandlers().add(0, new CouchDBHandler());
		
		URI url = URI.createURI("http://127.0.0.1:5984/libraries");
		
		Resource res = resourceSet.createResource(url);
		
		LibraryShelf shelf = LibraryFactory.eINSTANCE.createLibraryShelf();
		shelf.setName("My Comics Library");
		
		Book b1 = LibraryFactory.eINSTANCE.createBook();
		b1.setTitle("Watchmen");
		b1.setNumPages(400);
//		b1.setPubDate((Date) EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(), "1980-01-01"));
		
		shelf.getItems().add(b1);
		
		res.getContents().add(shelf);
		
		res.save(null);
	}


	public static EObject getResourceById(String id) {
		URI docURI = URI.createURI(url).appendSegment(id);
		Resource resource = resourceSet.createResource(docURI);
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (resource != null && resource.getContents().size() == 1) {
			EObject root = resource.getContents().get(0);
			new JsResourceImpl().getContents().add(root);
			
			return root;
		}
		
		return null;
	}
}
