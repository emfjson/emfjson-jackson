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
package org.eclipselabs.emfjson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipselabs.emfjson.internal.JsInputStream;
import org.eclipselabs.emfjson.internal.JsOutputStream;


/**
 * 
 * @author guillaume hillairet
 *
 */
public class JsURIHandlerImpl extends URIHandlerImpl {
	
	public JsURIHandlerImpl() {
		
	}
	
	@Override
	public boolean canHandle(URI uri) {
//		return "json".equalsIgnoreCase(uri.scheme());
		return true;
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
		super.delete(uri, options);
	}
	
	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		return true;
	}
	
	public static final String OPTION_STREAMING_JSON = "OPTION_STREAMING_JSON";
	public static final String OPTION_ROOT_ELEMENT = "OPTION_ROOT_ELEMENT";
	public static final String OPTION_URL_PARAMETERS = "OPTION_URL_PARAMETERS";
}
