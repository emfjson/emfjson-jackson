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

import com.google.gwt.storage.client.Storage;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * LocalStorageHandler
 * <p/>
 * URIHandler implementation that uses GWT Storage to store EMF/JSON documents
 * in Browsers' local store.
 *
 * @author ghillairet
 * @since 0.6.1
 */
public class LocalStorageHandler extends URIHandlerImpl {

	private String BASE_KEY = "emfjs:";

	public LocalStorageHandler() {
	}

	public LocalStorageHandler(String baseKey) {
		BASE_KEY = baseKey;
	}

	public static URI getURI(String key) {
		return URI.createURI(key.substring(6));
	}

	public boolean isResource(String key) {
		return key.startsWith(BASE_KEY);
	}

	private Map<String, Object> createInputStreamResult(byte[] data) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> response = new HashMap<String, Object>();
		result.put(URIConverter.OPTION_RESPONSE, response);
		response.put(URIConverter.RESPONSE_RESULT, new ByteArrayInputStream(data));

		return result;
	}

	@Override
	public void createInputStream(URI uri, Map<?, ?> options, Callback<Map<?, ?>> callback) {
		Storage store = Storage.getLocalStorageIfSupported();
		if (store != null) {
			String data = store.getItem(BASE_KEY + uri.toString());

			if (data != null) {
				callback.onSuccess(createInputStreamResult(data.getBytes()));
			} else {
				callback.onFailure(new Error("No Resource found for uri: " + uri));
			}
		} else {
			callback.onFailure(new Error("Browser does not support local storage"));
		}
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		Storage store = Storage.getLocalStorageIfSupported();
		String data = store.getItem(BASE_KEY + uri.toString());

		if (data != null) {
			return new ByteArrayInputStream(data.getBytes());
		} else {
			return null;
		}
	}

	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		return super.createOutputStream(uri, options);
	}

	@Override
	public void store(URI uri, byte[] bytes, Map<?, ?> options, Callback<Map<?, ?>> callback) {
		Storage store = Storage.getLocalStorageIfSupported();
		if (store != null) {
			if (bytes != null) {
				store.setItem(BASE_KEY + uri.toString(), new String(bytes));
				callback.onSuccess(createInputStreamResult(bytes));
			}
		} else {
			callback.onFailure(new Error("Browser does not support local storage"));
		}
	}

	@Override
	public void delete(URI uri, Map<?, ?> options, Callback<Map<?, ?>> callback) {
		Storage store = Storage.getLocalStorageIfSupported();
		if (store != null) {
			store.removeItem(uri.toString());
			callback.onSuccess(createInputStreamResult(null));
		} else {
			callback.onFailure(new Error("Browser does not support local storage"));
		}
	}

	@Override
	public void exists(URI uri, Map<?, ?> options, Callback<Boolean> callback) {
		callback.onSuccess(exists(uri, options));
	}

	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		Storage store = Storage.getLocalStorageIfSupported();
		if (store != null) {
			return store.getItem(uri.toString()) != null;
		}
		return false;
	}
}
