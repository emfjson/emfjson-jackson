/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
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
