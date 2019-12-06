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
 * URIHandler is used during serialization/deserialization
 * of external references.
 */
public interface URIHandler {

	/**
	 * Returns the URI {@link URI#resolve(URI) resolved} against the base URI.
	 *
	 * @param uri the URI to resolve.
	 * @return the URI resolved against the base URI.
	 * @see URI#resolve(URI)
	 */
	URI resolve(URI baseURI, URI uri);

	/**
	 * Returns the URI {@link URI#deresolve(URI) deresolved} against the base URI.
	 *
	 * @param uri the URI to resolve.
	 * @return the URI resolved against the base URI.
	 * @see URI#deresolve(URI)
	 */
	URI deresolve(URI baseURI, URI uri);

}
