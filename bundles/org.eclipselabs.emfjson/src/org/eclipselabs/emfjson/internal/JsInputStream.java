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
package org.eclipselabs.emfjson.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipselabs.emfjson.EJs;

/**
 * 
 * @author ghillairet
 *
 */
public abstract class JsInputStream extends InputStream implements URIConverter.Loadable {

	@SuppressWarnings("unused")
	private URI uri;
	private Map<?, ?> options;
	
	public JsInputStream(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options;
	}
	
	@Override
	public void loadResource(Resource resource) throws IOException {
		URL url = null;
		try {
			url = EJsUtil.getURL(resource.getURI(), options.get(EJs.OPTION_URL_PARAMETERS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		final JSONLoad loader = new JSONLoad(url, options);
		final Collection<EObject> roots = loader.getRootEObjects(resource);
		
		resource.getContents().addAll(roots);
	}
	
	@Override
	public int read() throws IOException {
		return 0;
	}

}
