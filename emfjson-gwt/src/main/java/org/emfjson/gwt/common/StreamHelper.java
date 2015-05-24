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
package org.emfjson.gwt.common;

import java.io.IOException;
import java.io.InputStream;

public class StreamHelper {

	public static String toString(InputStream inStream) {
		final StringBuilder out = new StringBuilder();
		byte[] b = new byte[4096];
		try {
			for (int n; (n = inStream.read(b)) != -1; ) {
				out.append(new String(b, 0, n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
	}

}
