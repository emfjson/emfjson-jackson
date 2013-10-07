package org.eclipselabs.emfjson.json.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipselabs.emfjson.json.map.JSONMapper;

import com.fasterxml.jackson.databind.JsonNode;

public class JSONOutputStream extends ByteArrayOutputStream implements URIConverter.Saveable {

	private Map<?, ?> options;
	protected JsonNode currentRoot;
	protected Resource resource;

	public JSONOutputStream(Map<?, ?> options) {
		this.options = options == null ? Collections.emptyMap() : options;
	}

	@Override
	public void saveResource(Resource resource) throws IOException {
		this.resource = resource;
		this.currentRoot = new JSONMapper().to(resource, options);
	}

}
