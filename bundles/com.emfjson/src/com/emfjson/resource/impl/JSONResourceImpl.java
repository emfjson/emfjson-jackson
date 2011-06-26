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
package com.emfjson.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.emfjson.internal.JSONBaseWriter;
import com.emfjson.internal.JSONLoader;
import com.emfjson.internal.JsonWriter;
import com.emfjson.resource.JSONResource;

/**
 * 
 * @author guillaume
 *
 */
public class JSONResourceImpl 
	extends ResourceImpl
	implements JSONResource {
	
	public JSONResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			throw new IllegalArgumentException("Loading options must be set, and must contain the root EClass");
		}
		
		final JSONLoader loader = new JSONLoader();
		EObject rootObject;
		if (inputStream != null) {
			rootObject = loader.loadFromInputStream(inputStream, options);
		} else {
			rootObject = loader.loadResource(this, options);
		}
		
		if (rootObject != null) {
			getContents().add(rootObject);
		}
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		final JsonWriter writer = new JSONBaseWriter();
		
		if (outputStream != null) {
			writer.writeOutputStream(this, outputStream);
		} else {
			writer.writeResource(this);	
		}
	}
	
}
