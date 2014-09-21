package org.eclipselabs.emfjson.gwt.common;

import java.io.IOException;
import java.io.InputStream;

public class StreamHelper {

	public static String toString(InputStream inStream) {
		final StringBuilder out = new StringBuilder();
		byte[] b = new byte[4096];
		try {
			for (int n; (n = inStream.read(b)) != -1;) {
				out.append(new String(b, 0, n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
	}

}
