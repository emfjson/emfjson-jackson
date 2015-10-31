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
