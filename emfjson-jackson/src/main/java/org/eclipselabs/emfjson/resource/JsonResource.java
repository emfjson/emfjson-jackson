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
package org.eclipselabs.emfjson.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipselabs.emfjson.map.streaming.JacksonStreamMapper;

/**
 * A {@link Resource} implementation that read and write it's content in JSON.
 */
public class JsonResource extends AbstractUuidResource {

	public JsonResource() {
		super();
	}

	public JsonResource(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (inputStream instanceof URIConverter.Loadable) {
			((URIConverter.Loadable) inputStream).loadResource(this);
		} else {
			new JacksonStreamMapper().parse(this, inputStream, options);
		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (outputStream instanceof URIConverter.Saveable) {
			((URIConverter.Saveable) outputStream).saveResource(this);
		} else {
			new JacksonStreamMapper().write(this, outputStream, options);
		}
	}

}
