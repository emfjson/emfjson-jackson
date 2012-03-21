package org.eclipselabs.emfjson.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtil {

	public static JsonParser getJsonParser(URL url) {
		final JsonFactory jsonFactory = new JsonFactory();  
		JsonParser jp = null;
		try {
			jp = jsonFactory.createJsonParser(url);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return jp;
	}

	public static JsonParser getJsonParser(InputStream inStream) {
		final JsonFactory jsonFactory = new JsonFactory();  
		JsonParser jp = null;
		try {
			jp = jsonFactory.createJsonParser(inStream);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return jp;
	}

	public static JsonNode getRootNode(JsonParser jp) {
		final ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
	
		if (jp != null) {
			try {
				rootNode = mapper.readValue(jp, JsonNode.class);
			} catch (JsonParseException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
		return rootNode;
	}

}
