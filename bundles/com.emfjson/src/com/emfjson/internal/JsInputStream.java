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
package com.emfjson.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.emfjson.js.base.JsBaseLoader;

/**
 * 
 * @author guillaume
 *
 */
public class JsInputStream extends InputStream implements URIConverter.Loadable {

	@SuppressWarnings("unused")
	private URI uri;
	private Map<?, ?> options;

	public JsInputStream(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options;
	}

	@Override
	public void loadResource(Resource resource) throws IOException {
		JsBaseLoader loader = new JsBaseLoader();
		
		loader.loadResource(resource, options);
	}

	@Override
	public int read() throws IOException {
		return 0;
	}

}
