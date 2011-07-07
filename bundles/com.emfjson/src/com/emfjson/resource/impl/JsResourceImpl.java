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
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.emfjson.js.IJsWriter;
import com.emfjson.js.base.JsBaseLoader;
import com.emfjson.js.base.JsBaseWriter;
import com.emfjson.resource.JsResource;

/**
 * 
 * @author guillaume
 *
 */
public class JsResourceImpl 
	extends ResourceImpl
	implements JsResource {
	
	public JsResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			throw new IllegalArgumentException("Loading options must be set, and must contain the root EClass");
		}
		
		final JsBaseLoader loader = new JsBaseLoader();
		Collection<EObject> roots;
		if (inputStream != null) {
			roots = loader.loadFromInputStream(inputStream, options);
		} else {
			roots = loader.loadResource(this, options);
		}
		
		if (roots != null && !roots.isEmpty()) {
			getContents().addAll(roots);
		}
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		final IJsWriter writer = new JsBaseWriter();
		
		if (outputStream != null) {
			writer.writeOutputStream(this, outputStream);
		} else {
			writer.writeResource(this);	
		}
	}
	
}
