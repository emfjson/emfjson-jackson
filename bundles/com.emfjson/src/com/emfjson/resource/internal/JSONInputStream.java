package com.emfjson.resource.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

public class JSONInputStream 
extends InputStream 
implements URIConverter.Loadable {

	public JSONInputStream(Map<?, ?> options) {
		
	}

	@Override
	public void loadResource(Resource resource) throws IOException {
		URI uri = resource.getURI();
		if (uri != null) {
			JsonFactory jsonFactory = new JsonFactory();  
			JsonParser jp = jsonFactory.createJsonParser(new URL(uri.toString()));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(jp, JsonNode.class);
			rootNode = mapper.readTree(jp);
			
			System.out.println(rootNode);
		}
	}

	@Override
	public int read() throws IOException {

		return 0;
	}

}
