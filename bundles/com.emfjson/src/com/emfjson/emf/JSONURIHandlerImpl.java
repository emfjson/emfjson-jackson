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
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.emfjson.internal.JSONInputStream;

/**
 * 
 * @author guillaume
 *
 */
public class JSONURIHandlerImpl extends URIHandlerImpl {
	
	@Override
	public boolean canHandle(URI uri) {
//		return uri.scheme().equalsIgnoreCase("json");
		return true;
	}
	
	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		return new JSONInputStream(uri, options);
	}
}
