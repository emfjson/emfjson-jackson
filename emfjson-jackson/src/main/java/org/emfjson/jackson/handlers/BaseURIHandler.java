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
package org.emfjson.jackson.handlers;

import org.eclipse.emf.common.util.URI;

import org.emfjson.handlers.URIHandler;

/**
 * This is the basic implementation of the {@link URIHandler} interface.
 * Implementations should extend this class to implement a specialized URI handler.
 */
public class BaseURIHandler implements URIHandler {

	private URI baseURI;
	private boolean resolve;

	@Override
	public URI getBaseURI() {
		return baseURI;
	}

	@Override
	public void setBaseURI(URI uri) {
		baseURI = uri;
		resolve = uri != null && uri.isHierarchical() && !uri.isRelative();
	}

	@Override
	public URI resolve(URI uri) {
		return resolve && uri.isRelative() && uri.hasRelativePath() ? uri.resolve(baseURI) : uri;
	}

	@Override
	public URI deresolve(URI uri) {
		if (resolve && !uri.isRelative()) {
			URI deresolvedURI = uri.deresolve(baseURI, true, true, false);
			if (deresolvedURI.hasRelativePath()) {
				uri = deresolvedURI;
			}
		}
		return uri;
	}

}
