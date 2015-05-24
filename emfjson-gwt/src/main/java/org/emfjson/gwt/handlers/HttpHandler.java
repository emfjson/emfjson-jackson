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
package org.emfjson.gwt.handlers;

import com.google.gwt.http.client.*;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * URIHandler implementation that uses RequestBuilder to communicate with
 * an HTTP server in JSON format.
 *
 * @author ghillairet
 * @since 0.6.0
 */
public class HttpHandler extends URIHandlerImpl implements URIHandler {

	public static void create(final ResourceSet resourceSet, URI createService, final Callback<Resource> callback) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, URL.encode(createService.toString()));
		builder.setHeader("Content-Type", "application/json");
		builder.setCallback(new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				if (response.getStatusCode() == 201) {
					String location = response.getHeader("Location");
					Resource resource = resourceSet.createResource(URI.createURI(location));
					callback.onSuccess(resource);
				} else {
					callback.onFailure(new Exception("Resource has not been created"));
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onFailure(exception);
			}
		});

		try {
			builder.send();
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void createInputStream(final URI uri, Map<?, ?> options, final Callback<Map<?, ?>> callback) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(uri.toString()));
		builder.setHeader("Content-Type", "application/json");
		builder.setCallback(new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				Map<String, Object> responseMap = new HashMap<String, Object>();
				resultMap.put(URIConverter.OPTION_RESPONSE, responseMap);

				if (200 == response.getStatusCode()) {
					String responseText = response.getText();
					if (responseText != null) {
						InputStream stream = new ByteArrayInputStream(responseText.getBytes());
						responseMap.put(URIConverter.RESPONSE_RESULT, stream);
					}
					callback.onSuccess(resultMap);
				} else {
					callback.onFailure(new Exception("Error " + response.getStatusCode()));
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onFailure(exception);
			}
		});

		try {
			builder.send();
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void delete(URI uri, Map<?, ?> options, final Callback<Map<?, ?>> callback) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.DELETE, URL.encode(uri.toString()));
		builder.setHeader("Content-Type", "application/json");
		builder.setCallback(new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				Map<String, Object> responseMap = new HashMap<String, Object>();
				resultMap.put(URIConverter.OPTION_RESPONSE, responseMap);

				int code = response.getStatusCode();
				if (code >= 200 && code < 300) {
					responseMap.put(URIConverter.RESPONSE_RESULT, null);
					responseMap.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, null);
					responseMap.put(URIConverter.RESPONSE_URI, null);
					callback.onSuccess(resultMap);
				} else {
					callback.onFailure(new Exception(response.getStatusText()));
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onFailure(exception);
			}
		});

		try {
			builder.send();
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void store(URI uri, byte[] bytes, Map<?, ?> options, final Callback<Map<?, ?>> callback) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.PUT, URL.encode(uri.toString()));
		builder.setHeader("Content-Type", "application/json");
		builder.setRequestData(new String(bytes));
		builder.setCallback(new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				Map<String, Object> responseMap = new HashMap<String, Object>();
				resultMap.put(URIConverter.OPTION_RESPONSE, responseMap);

				int code = response.getStatusCode();
				if (code >= 200 && code < 300) {
					responseMap.put(URIConverter.RESPONSE_RESULT,
						new ByteArrayInputStream(response.getText().getBytes()));
					responseMap.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, null);
					responseMap.put(URIConverter.RESPONSE_URI, null);
					callback.onSuccess(resultMap);
				} else {
					callback.onFailure(new Exception("Error " + response.getStatusCode()));
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onFailure(exception);
			}
		});

		try {
			builder.send();
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void exists(URI uri, Map<?, ?> options, final Callback<Boolean> callback) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.HEAD, URL.encode(uri.toString()));
		builder.setHeader("Content-Type", "application/json");
		builder.setCallback(new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				int code = response.getStatusCode();
				if (code >= 200 && code < 300) {
					callback.onSuccess(true);
				} else {
					callback.onSuccess(false);
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				callback.onFailure(exception);
			}
		});

		try {
			builder.send();
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}

}