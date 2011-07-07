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
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.emfjson.js.IJsWriter;
import com.emfjson.js.base.JsBaseWriter;

public class JsOutputStream extends OutputStream implements URIConverter.Saveable {

	public JsOutputStream(URI uri, Map<?, ?> options) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveResource(Resource resource) throws IOException {
		final IJsWriter writer = new JsBaseWriter();
		
		writer.writeResource(resource);
	}

	@Override
	public void write(int b) throws IOException {
		// TODO ??
	}

}
