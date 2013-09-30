package org.eclipselabs.emfjson.json.streams;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipselabs.emfjson.json.map.JSONMapper;

public class JSONInputStream extends InputStream implements URIConverter.Loadable {

	protected URI uri;
	protected Map<?, ?> options;

	public JSONInputStream(URI uri, Map<?, ?> options) {
		this.uri = uri;
		this.options = options == null ? Collections.emptyMap() : options;
	}

	@Override
	public void loadResource(Resource resource) throws IOException {
		URL url = null;
		try {
			url = new URL(resource.getURI().toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		new JSONMapper().from(url, resource, options);
	}

	@Override
	public int read() throws IOException {
		return 0;
	}

}
