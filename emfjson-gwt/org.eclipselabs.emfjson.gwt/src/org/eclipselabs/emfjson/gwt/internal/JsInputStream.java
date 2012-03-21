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
package org.eclipselabs.emfjson.gwt.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * 
 * @author ghillairet
 *
 */
public abstract class JsInputStream extends InputStream implements URIConverter.Loadable {

	protected URI uri;
	protected Map<?, ?> options;
	
	public JsInputStream(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options;
	}
	
	@Override
	public abstract void loadResource(Resource resource) throws IOException;
	
	@Override
	public int read() throws IOException {
		return 0;
	}

}
