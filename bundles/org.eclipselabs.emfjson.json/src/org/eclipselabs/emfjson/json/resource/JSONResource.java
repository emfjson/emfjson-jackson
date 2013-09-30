package org.eclipselabs.emfjson.json.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipselabs.emfjson.json.map.JSONMapper;

public class JSONResource extends ResourceImpl {

	private JSONMapper mapper = new JSONMapper();

	public JSONResource() {
		super();
	}

	public JSONResource(URI uri) {
		super(uri);
	}

	protected void doLoad(InputStream inputStream, Map<?,?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}
		
		if (inputStream instanceof URIConverter.Loadable) {
			((URIConverter.Loadable) inputStream).loadResource(this);
		} else {
			mapper.from(inputStream, this, options);
		}
	};

	protected void doSave(OutputStream outputStream, Map<?,?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (outputStream instanceof URIConverter.Saveable) {
			((URIConverter.Saveable) outputStream).saveResource(this);
		} else {
			mapper.write(outputStream, mapper.to(this, options));	
		}
	};

}
