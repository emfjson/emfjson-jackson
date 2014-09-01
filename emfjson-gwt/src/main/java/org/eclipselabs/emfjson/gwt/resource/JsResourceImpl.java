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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipselabs.emfjson.gwt.map.JsonMapper;

import com.google.gwt.core.shared.GWT;

/**
 * {@link Resource} implementation meant to be used on the client side of a 
 * GWT application.
 * 
 * @author ghillairet
 * @since 0.4.0
 */
public class JsResourceImpl extends ResourceImpl {

	public JsResourceImpl() {
		super();
	}

	public JsResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void load(final Map<?, ?> options, final Callback<Resource> callback) throws IOException {
		if (!isLoaded) {
			Map<?, ?> response = options == null ? null : (Map<?, ?>) options.get(URIConverter.OPTION_RESPONSE);
			if (response == null) {
				response = new HashMap<Object, Object>();
			}

			if (GWT.isClient()) {
				loadOnClient(options, response, callback);
				return;
			}

			// If an input stream can't be created, ensure that the resource is still considered loaded after the failure,
			// and do all the same processing we'd do if we actually were able to create a valid input stream.
			//

			URIConverter uriConverter = getURIConverter();
			InputStream inputStream = null;
			Map<Object, Object> effectiveOptions = new HashMap<Object, Object>();
			effectiveOptions.put(URIConverter.OPTION_RESPONSE, response);
			try {
				inputStream = uriConverter.createInputStream(getURI(), effectiveOptions);
			}
			catch (IOException exception) {
				Notification notification = setLoaded(true);
				isLoading = true;
				if (errors != null) {
					errors.clear();
				}
				if (warnings != null) {
					warnings.clear();
				}
				isLoading = false;
				if (notification != null) {
					eNotify(notification);
				}
				setModified(false);

				throw exception;
			}

			try {
				load(inputStream, options);
			}
			finally {
				inputStream.close();
				handleLoadResponse(response, effectiveOptions);
			}
		} else {
			callback.onSuccess(this);
		}
	}

	protected void loadOnClient(final Map<?, ?> options, Map<?, ?> response, final Callback<Resource> callback) {
		URIConverter uriConverter = getURIConverter();
		isLoading = true;
		final Map<Object, Object> effectiveOptions = new HashMap<Object, Object>();
		effectiveOptions.put(URIConverter.OPTION_RESPONSE, response);

		uriConverter.createInputStream(getURI(), effectiveOptions, new Callback<Map<?,?>>() {

			public void onFailure(Throwable caught) {
				isLoading = false;
				Notification notification = setLoaded(true);
				if (errors != null) errors.clear();
				if (warnings != null) warnings.clear();
				if (notification != null) eNotify(notification);
				setModified(false);
				callback.onFailure(caught);
			}

			public void onSuccess(Map<?, ?> result) {
				final Map<?, ?> response = (Map<?, ?>) result.get(URIConverter.OPTION_RESPONSE);
				final InputStream inputStream = (InputStream) response.get(URIConverter.RESPONSE_RESULT);

				final Notification notification = setLoaded(true);
				if (errors != null) errors.clear();
				if (warnings != null) warnings.clear();

				doLoad(inputStream, options, new Callback<Resource>() {
					@Override
					public void onFailure(Throwable caught) {
						isLoading = false;
						setModified(false);
						if (notification != null) eNotify(notification);
						handleLoadResponse(response, effectiveOptions);

						try {
							if (inputStream != null) inputStream.close();
						}
						catch (IOException exception) {
							callback.onFailure(exception);
							return;
						}
						callback.onFailure(caught);
					}
					@Override
					public void onSuccess(Resource result) {
						isLoading = false;
						setModified(false);
						if (notification != null) eNotify(notification);
						handleLoadResponse(response, effectiveOptions);

						try {
							if (inputStream != null) inputStream.close();
						}
						catch (IOException exception) {
							callback.onFailure(exception);
							return;
						}

						callback.onSuccess(result);
					}
				});
			}
		});
	}

	protected void doLoad(InputStream inputStream, Map<?, ?> options, final Callback<Resource> callback) {		
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		final JsonMapper mapper = new JsonMapper();
		mapper.parse(this, inputStream, options, new Callback<Resource>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
			@Override
			public void onSuccess(Resource result) {
				callback.onSuccess(result);
			}
		});
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		final JsonMapper mapper = new JsonMapper();
		mapper.write(this, outputStream, options);
	}
}
