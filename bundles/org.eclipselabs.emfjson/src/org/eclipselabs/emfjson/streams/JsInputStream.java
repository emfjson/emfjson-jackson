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
package org.eclipselabs.emfjson.streams;

import static org.eclipselabs.emfjson.EMFJs.OPTION_URL_PARAMETERS;
import static org.eclipselabs.emfjson.common.ModelUtil.getURL;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIConverter.Loadable;
import org.eclipselabs.emfjson.map.EObjectMapper;

/**
 * 
 * Abstract implementation of {@link Loadable} for JSON input.
 *
 */
public class JsInputStream extends InputStream implements URIConverter.Loadable {

	protected URI uri;
	protected Map<?, ?> options;

	public JsInputStream(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options == null ? Collections.emptyMap() : options;
	}

	@Override
	public void loadResource(Resource resource) throws IOException {
		URL url = null;
		try {
			url = getURL(resource.getURI(), options.get(OPTION_URL_PARAMETERS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		final EObjectMapper mapper = new EObjectMapper();
		mapper.from(url, resource, options);
	}

	@Override
	public int read() throws IOException {
		return 0;
	}

}
