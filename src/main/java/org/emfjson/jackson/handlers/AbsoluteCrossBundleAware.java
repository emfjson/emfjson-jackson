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
 * A URI handler that will avoid creating relative references between different platform:/resource/project-name or
 * platform/plugin/bundle-name, i.e., it will produce relative references only within projects or bundles
 * and will use absolute URIs for references outside of that project or bundle.
 */
public class AbsoluteCrossBundleAware extends BaseURIHandler {

	@Override
	public URI deresolve(URI baseURI, URI uri) {
		return !uri.isPlatform() ||
			(uri.segmentCount() > 1 && baseURI.segmentCount() > 1 &&
				uri.segment(0).equals(baseURI.segment(0)) &&
				uri.segment(1).equals(baseURI.segment(1))) ?
			super.deresolve(baseURI, uri) : uri;
	}

}
