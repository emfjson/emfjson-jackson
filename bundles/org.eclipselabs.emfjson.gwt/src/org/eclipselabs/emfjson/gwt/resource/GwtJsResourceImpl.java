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
package org.eclipselabs.emfjson.gwt.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipselabs.emfjson.common.JsonLoad;
import org.eclipselabs.emfjson.common.JsonSave;
import org.eclipselabs.emfjson.gwt.internal.GwtJsonLoad;
import org.eclipselabs.emfjson.gwt.internal.GwtJsonSave;

/**
 * {@link Resource} implementation meant to be used on the client side of a 
 * GWT application.
 * 
 * @author ghillairet
 * @since 0.4.0
 */
public class GwtJsResourceImpl extends ResourceImpl {
	public GwtJsResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}
		
		JsonLoad loader = new GwtJsonLoad(inputStream);
		loader.fillResource(this);
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}
		
		JsonSave saver = new GwtJsonSave(options);
		saver.write(outputStream, this);
	}
}
