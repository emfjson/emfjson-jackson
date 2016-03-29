/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.handlers;

import org.eclipse.emf.common.util.URI;

/**
 * URIHandler that does not modify uris during resolve and
 * deresolve operations.
 *
 */
public class IdentityURIHandler implements URIHandler {

	@Override
	public URI resolve(URI baseURI, URI uri) {
		return uri;
	}

	@Override
	public URI deresolve(URI baseURI, URI uri) {
		return uri;
	}

}
