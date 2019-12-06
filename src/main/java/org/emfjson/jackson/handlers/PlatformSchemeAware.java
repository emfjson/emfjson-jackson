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
