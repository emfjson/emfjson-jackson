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
package org.eclipselabs.emfjson.couchdb;

import static org.eclipselabs.emfjson.couchdb.internal.CouchDB.checkDataBase;
import static org.eclipselabs.emfjson.couchdb.internal.CouchDB.createDataBase;
import static org.eclipselabs.emfjson.couchdb.internal.CouchDB.getGetConnection;
import static org.eclipselabs.emfjson.couchdb.internal.CouchDB.isCouchDbService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipselabs.emfjson.couchdb.internal.CouchDB;
import org.eclipselabs.emfjson.internal.JSONLoad;
import org.eclipselabs.emfjson.internal.JsInputStream;
import org.eclipselabs.emfjson.internal.JsOutputStream;

public class CouchDBHandler extends URIHandlerImpl {

	@Override
	public boolean canHandle(URI uri) {
		return isCouchDbService(uri);
	}

	@Override
	public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
		if (checkDataBase(uri) == 0) {
			throw new IllegalArgumentException("DataBase does not exist");
		}
		return new JsInputStream(uri, options) {
			@Override
			public void loadResource(Resource resource) throws IOException {
				final HttpURLConnection connection = getGetConnection(uri);
				final InputStream inStream = connection.getInputStream();
				final JSONLoad loader = new JSONLoad(inStream, options);
				final Collection<EObject> roots = loader.fillResource(resource);

				resource.getContents().addAll(roots);
			}
		};
	}
	
	@Override
	public OutputStream createOutputStream(final URI uri, Map<?, ?> options) throws IOException {
		if (checkDataBase(uri) == 0) {
			createDataBase(uri);
		}
		
		return new JsOutputStream(options) {
			public void close() throws IOException {
				URI documentURI = CouchDB.createOrUpdateDocument(uri, writer, currentRoot);
				if (documentURI != uri) {
					resource.setURI(documentURI);
				}
			}
		};
	}
	
	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		CouchDB.delete(uri);
	}
	
}
