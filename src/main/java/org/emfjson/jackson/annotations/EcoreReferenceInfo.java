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
package org.emfjson.jackson.annotations;

import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;

public class EcoreReferenceInfo {

	public static final String PROPERTY = "$ref";

	private final URIHandler handler;
	private final String property;

	public EcoreReferenceInfo(String property) {
		this(property, new BaseURIHandler());
	}

	public EcoreReferenceInfo(URIHandler handler) {
		this(PROPERTY, handler);
	}

	public EcoreReferenceInfo(String property, URIHandler handler) {
		this.property = property;
		this.handler = handler;
	}

	public String getProperty() {
		return property;
	}

	public URIHandler getHandler() {
		return handler;
	}
}
