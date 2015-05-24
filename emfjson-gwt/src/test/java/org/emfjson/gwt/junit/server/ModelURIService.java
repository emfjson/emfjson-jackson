/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIService;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.server.ecore.resource.URIHandlerImpl;

import org.emfjson.gwt.junit.model.ModelPackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class ModelURIService extends RemoteServiceServlet implements URIService {

	static {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
	}

	@Override
	public Map<?, ?> fetch(String uri, Map<?, ?> options) {
		URI aURI = URI.createURI(uri);
		String path = aURI.path();

		ResourceSet resourceSet = getResourceSet();
		Resource resource = resourceSet.createResource(URI.createURI("result.json"));

		@SuppressWarnings("unchecked")
		final Map<Object, Object> result = (Map<Object, Object>) options.get(URIConverter.OPTION_RESPONSE);
		final Map<String, Object> response = new HashMap<String, Object>();
		URL url = ModelURIService.class.getResource("tests" + path);

		InputStream stream = null;
		try {
			stream = url.openStream();
			resource.load(stream, null);

			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			resource.save(outputStream, null);
			response.put(URIConverter.RESPONSE_RESULT, outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null)
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		result.put(URIConverter.OPTION_RESPONSE, response);

		return result;
	}

	@Override
	public Map<?, ?> store(String uri, byte[] bytes, Map<?, ?> options) {

		return null;
	}

	@Override
	public Map<?, ?> delete(String uri, Map<?, ?> options) {

		return null;
	}

	@Override
	public boolean exists(String uri, Map<?, ?> options) {

		return false;
	}

	@Override
	public WhiteList whiteList(WhiteList whiteList) {
		return null;
	}

	private ResourceSet getResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		initResourceSet(resourceSet);
		return resourceSet;
	}

	private void initResourceSet(ResourceSet resourceSet) {
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new ResourceFactoryImpl(){
//			@Override
//			public Resource createResource(URI uri) {				
//				return new JsResourceImpl(uri) {
//					@Override
//					protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
//						if (inputStream instanceof URIConverter.Loadable) {
//							((URIConverter.Loadable)inputStream).loadResource(this);
//						} else {
//							if (options == null) {
//								options = Collections.<String, Object> emptyMap();
//							}
//							JSONLoad loader = new JSONLoad(inputStream, options);
//							loader.fillResource(this);
//						}
//					}
//					@Override
//					protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
//						if (outputStream instanceof URIConverter.Saveable) {
//							((Saveable)outputStream).saveResource(this);
//						} else {
//							if (options == null) {
//								options = Collections.<String, Object> emptyMap();
//							}
//							JSONSave saver = new JSONSave(options);
//							JsonNode node = saver.genJson(this);
//							saver.writeValue(outputStream, node);
//						}
//					}
//				};
//			}
//		});
		resourceSet.getURIConverter().getURIHandlers().add(new URIHandlerImpl());
	}

}
