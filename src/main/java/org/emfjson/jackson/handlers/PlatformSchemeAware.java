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
 * A URI handler that will avoid creating relative references between platform:/resource and platform:/plugin.
 */
public class PlatformSchemeAware extends BaseURIHandler {

	@Override
	public URI deresolve(URI baseURI, URI uri) {
		return !uri.isPlatform() ||
			(uri.segmentCount() > 0 &&
				baseURI.segmentCount() > 0 && uri.segment(0).equals(baseURI.segment(0))) ?
			super.deresolve(baseURI, uri) : uri;
	}

}
