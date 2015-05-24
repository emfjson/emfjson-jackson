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
package org.emfjson.gwt.junit.support;

import com.google.gwt.core.client.JavaScriptObject;

public class JsonHelper {

	public static native String stringify(JavaScriptObject object) /*-{
		return JSON.stringify(object, null, '\t');
	}-*/;

}
