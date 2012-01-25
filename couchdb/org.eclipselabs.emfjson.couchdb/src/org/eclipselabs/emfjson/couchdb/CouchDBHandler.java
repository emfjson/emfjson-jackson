package org.eclipselabs.emfjson.couchdb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipselabs.emfjson.internal.JsOutputStream;

public class CouchDBHandler extends URIHandlerImpl {

	@Override
	public boolean canHandle(URI uri) {
		return super.canHandle(uri);
	}

	@Override
	public InputStream createInputStream(final URI uri, Map<?, ?> options) throws IOException {
		return null;
	}

	@Override
	public OutputStream createOutputStream(final URI uri, Map<?, ?> options) throws IOException {
		return new JsOutputStream(options) {
			
			public void close() throws IOException {
				HttpURLConnection connection = (HttpURLConnection) new URL(uri.toString()).openConnection();

				connection.setDoOutput(true);
				connection.setRequestMethod("PUT");
				connection.setRequestProperty("Content-Type", "application/json");
				OutputStream output = null;

				try {
					output = connection.getOutputStream();
					writer.getDelegate().writeValue(output, this.currentRoot);
				} finally {
					if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
				}

				InputStream response = connection.getInputStream();
				System.out.println(response);
			};
		};
	}


}
