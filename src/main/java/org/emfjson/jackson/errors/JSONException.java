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
package org.emfjson.jackson.errors;

import org.eclipse.emf.ecore.resource.Resource;

import com.fasterxml.jackson.core.JsonLocation;

public class JSONException extends Exception implements Resource.Diagnostic {

	private final String location;
	private final int line;
	private final int column;

	public JSONException(String message, JsonLocation location) {
		super(message);
		this.location = location.toString();
		this.line = location.getLineNr();
		this.column = location.getColumnNr();
	}

	public JSONException(Exception e, JsonLocation location) {
		super(e);
		this.location = location.toString();
		this.line = location.getLineNr();
		this.column = location.getColumnNr();
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		return column;
	}

}
