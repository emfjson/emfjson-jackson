package example.server.store;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.resource.JsonResourceFactory;

import example.shared.model.ModelPackage;

public class ModelStore {

	public Resource get(String id) throws IOException {
		Resource resource = resource(id);
		try {
			resource.load(null);
		} catch (IOException e) {
			throw e;
		}

		return resource;
	}

	public java.net.URI save(String id, Resource resource) throws IOException, URISyntaxException {
		if (resource.getResourceSet() == null) {
			createResourceSet().getResources().add(resource);
		}
		resource.setURI(URI.createURI("http://resources/" + id));

		try {
			resource.save(null);
		} catch (IOException e) {
			throw e;
		}

		java.net.URI uri =  null;
		try {
			uri = new java.net.URI(resource.getURI().toString());
		} catch (URISyntaxException e) {
			throw e;
		}

		return uri;
	}

	public void delete(String id) throws Exception {
		Resource resource = resource(id);
		try {
			resource.delete(null);
		} catch (IOException e) {
			throw e;
		}
	}


	private static ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"*", 
				new JsonResourceFactory());

		resourceSet.getURIConverter().getURIMap().put(
				URI.createURI("http://resources/"), 
				URI.createURI("files/"));

		return resourceSet;
	}

	public static Resource resource(String id) {
		ResourceSet resourceSet = createResourceSet();
		return resourceSet.createResource(URI.createURI("http://resources/" + id));
	}

	public java.net.URI create() throws IOException, URISyntaxException {
		String uuid = EcoreUtil.generateUUID();
		Resource resource = resource(uuid);
		try {
			resource.save(null);
		} catch (IOException e) {
			throw e;
		}

		java.net.URI uri =  null;
		try {
			uri = new java.net.URI(resource.getURI().toString());
		} catch (URISyntaxException e) {
			throw e;
		}

		return uri;
	}

}
