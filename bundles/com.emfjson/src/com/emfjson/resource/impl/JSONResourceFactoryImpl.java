package com.emfjson.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class JSONResourceFactoryImpl
	extends ResourceFactoryImpl {

	public Resource createResource(URI uri) {
		return new JSONResourceImpl(uri);
	};
}
