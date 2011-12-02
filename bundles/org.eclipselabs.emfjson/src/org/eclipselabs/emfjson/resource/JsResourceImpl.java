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
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipselabs.emfjson.internal.EJsUtil;
import org.eclipselabs.emfjson.internal.JSONSave;

/**
 * 
 * @author ghillairet
 *
 */
public class JsResourceImpl extends ResourceImpl {
	
	public JsResourceImpl() {
		super();
	}
	
	public JsResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		final JSONSave mapper = new JSONSave();
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}
		
//		URL url = null;
//		try {
//			url = EJsUtil.getURL(this.getURI(), options.get(EJs.OPTION_URL_PARAMETERS));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		
		final JsonParser jp = EJsUtil.getJsonParser(inputStream);
		final JsonNode rootNode = jp != null ? mapper.getRootNode(jp) : null;
		
		Collection<EObject> roots = rootNode != null ?
				mapper.getRootEObjects(this, rootNode, options) : Collections.<EObject> emptyList();
		
		this.getContents().addAll(roots);
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}
		final JSONSave writer = new JSONSave();
		final JsonNode rootNode = writer.genJson(this, options);
		writer.getDelegate().writeValue(outputStream, rootNode);
	}
	
	@Override
	protected void doUnload() {
		super.doUnload();
	}
}
