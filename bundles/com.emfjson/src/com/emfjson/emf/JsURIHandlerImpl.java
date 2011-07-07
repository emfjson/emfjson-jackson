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
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.emfjson.internal.JsInputStream;
import com.emfjson.internal.JsOutputStream;

/**
 * 
 * @author guillaume
 *
 */
public class JsURIHandlerImpl extends URIHandlerImpl {
	
	public JsURIHandlerImpl() {
//		super();
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return "json".equalsIgnoreCase(uri.scheme());
	}
	
	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		return new JsInputStream(uri, options);
	}
	
	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		return new JsOutputStream(uri, options);
	}
	
	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		super.delete(uri, options);
	}
	
	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		// TODO Auto-generated method stub
		return true;
	}
}
