package com.emfjson.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.emfjson.resource.internal.JSONInputStream;

public class JSONURIHandlerImpl 
	extends URIHandlerImpl {
	
	@Override
	public boolean canHandle(URI uri) {
		System.out.println("here");
		return "json".equalsIgnoreCase(uri.scheme());
	}
	
	
	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		return new JSONInputStream(options);
	}
}
