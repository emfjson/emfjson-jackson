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
