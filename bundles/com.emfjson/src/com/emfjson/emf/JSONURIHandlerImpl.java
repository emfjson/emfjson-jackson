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
package com.emfjson.emf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.emfjson.internal.JSONInputStream;

/**
 * 
 * @author guillaume
 *
 */
public class JSONURIHandlerImpl extends URIHandlerImpl {
	
	public JSONURIHandlerImpl() {
		super();
	}
	
	@Override
	public boolean canHandle(URI uri) {
		System.out.println("here");
		return uri.scheme().equalsIgnoreCase("json");
//		return true;
	}
	
	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		System.out.println("create input");
		return new JSONInputStream(uri, options);
	}
	
	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		System.out.println("create output");
		// TODO Auto-generated method stub
		return super.createOutputStream(uri, options);
	}
	
	@Override
	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		System.out.println("content");
		return super.contentDescription(uri, options);
	}
	
	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		System.out.println("delete");
		// TODO Auto-generated method stub
		super.delete(uri, options);
	}
	
	@Override
	protected Map<Object, Object> getResponse(Map<?, ?> options) {
	System.out.println("get response");
		// TODO Auto-generated method stub
		return super.getResponse(options);
	}
	
	@Override
	protected URIConverter getURIConverter(Map<?, ?> options) {
		System.out.println("get URi");
		// TODO Auto-generated method stub
		return super.getURIConverter(options);
	}
	
	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		System.out.println("return true");
		return true;
	}
}
