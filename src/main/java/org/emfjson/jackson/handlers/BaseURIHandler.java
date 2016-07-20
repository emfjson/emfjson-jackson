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

/**
 * This is the basic implementation of the {@link URIHandler} interface.
 * Implementations should extend this class to implement a specialized URI handler.
 */
public class BaseURIHandler implements URIHandler {

    protected boolean resolve(URI baseURI) {
        return baseURI != null && baseURI.isHierarchical() && !baseURI.isRelative();
    }

	@Override
	public URI resolve(URI baseURI, URI uri) {
		return resolve(baseURI) && uri.isRelative() && uri.hasRelativePath() ?
				uri.resolve(baseURI, false) :
				uri;
	}

	@Override
	public URI deresolve(URI baseURI, URI uri) {
		if (resolve(baseURI) && !uri.isRelative()) {
			URI deresolvedURI = uri.deresolve(baseURI, true, true, false);
			if (deresolvedURI.hasRelativePath()) {
				uri = deresolvedURI;
			}
		}
		return uri;
	}

}
