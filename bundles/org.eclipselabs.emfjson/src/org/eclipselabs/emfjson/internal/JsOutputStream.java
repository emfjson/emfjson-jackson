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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * 
 * 	@author ghillairet
 *	
 */
public abstract class JsOutputStream extends ByteArrayOutputStream implements URIConverter.Saveable {
	
	@SuppressWarnings("unused")
	private Map<?, ?> options;
	
	protected final JSONSave writer;
	protected JsonNode currentRoot;
	protected Resource resource;
	
	public JsOutputStream(Map<?, ?> options) {
		this.options = options;
		this.writer = new JSONSave(options);
	}
	
	@Override
	public void saveResource(Resource resource) throws IOException {
		this.resource = resource;
		this.currentRoot = writer.genJson(resource);
	}
	
}
