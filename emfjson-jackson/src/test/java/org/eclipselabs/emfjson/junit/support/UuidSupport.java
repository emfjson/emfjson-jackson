package org.eclipselabs.emfjson.junit.support;

import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;
import static org.eclipselabs.emfjson.common.Constants.EJS_UUID_ANNOTATION;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.resource.JsonResource;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class UuidSupport {

	private ResourceSet resourceSet = new ResourceSetImpl();

	protected String uuid(EObject object) {
		return getURI(object).fragment();
	}

	protected String uuid(JsonNode node) {
		return node.get(EJS_UUID_ANNOTATION).asText();
	}
	
	protected Resource createUuidResource(String name) {
		Resource resource = new JsonResource(URI.createURI(name)) {
			@Override
			protected boolean useUUIDs() {
				return true;
			}
		};
		resourceSet.getResources().add(resource);
		return resource;
	}

	protected Resource createJsUuidResource(String name) {
		Resource resource = new JsonResource(URI.createURI(name)) {
			@Override
			protected boolean useUUIDs() {
				return true;
			}
		};
		resourceSet.getResources().add(resource);
		return resource;
	}

}
