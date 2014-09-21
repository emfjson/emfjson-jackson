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
package org.eclipselabs.emfjson.gwt.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipselabs.emfjson.gwt.map.JsonMapper;

import com.google.gwt.json.client.JSONValue;

/**
 * 
 * 	@author ghillairet
 *	
 */
public abstract class JsonOutputStream extends ByteArrayOutputStream implements URIConverter.Saveable {

	private Map<?, ?> options;
	protected JSONValue currentRoot;
	protected Resource resource;

	public JsonOutputStream(Map<?, ?> options) {
		this.options = options == null ? Collections.emptyMap() : options;
	}

	@Override
	public void saveResource(Resource resource) throws IOException {
		this.resource = resource;
		this.currentRoot = new JsonMapper().write(resource, options);
	}

}
