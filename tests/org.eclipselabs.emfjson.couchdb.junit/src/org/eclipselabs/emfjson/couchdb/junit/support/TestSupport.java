package org.eclipselabs.emfjson.couchdb.junit.support;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipselabs.emfjson.couchdb.CouchDBHandler;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.junit.After;
import org.junit.Before;

public abstract class TestSupport {
	
	protected ResourceSet resourceSet;
	protected final String url = "http://127.0.0.1:5984/emfjson_test";
	protected final URI baseURI = URI.createURI("http://127.0.0.1:5984/");
	
	@Before
	public void tearUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIHandlers().add(0, new CouchDBHandler());
	}
	
	@After
	public void tearDown() {
		
	}
	
}
