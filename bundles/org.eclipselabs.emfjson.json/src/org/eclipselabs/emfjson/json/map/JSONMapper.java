package org.eclipselabs.emfjson.json.map;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.json.JNode;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONMapper {

	private ObjectMapper mapper = new ObjectMapper();

	public JNode from(InputStream inputStream, Resource resource, Map<?, ?> options) {
		JsonNode node = null;
		try {
			node = mapper.readTree(inputStream);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return node == null ? null : new Deserializer().from(node, resource, true);
	}

	public JNode from(URL url, Resource resource, Map<?, ?> options) {
		JsonNode node = null;
		try {
			node = mapper.readTree(url);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return node == null ? null : new Deserializer().from(node, resource, true);
	}

	public JNode from(JsonNode node, Resource resource, Map<?, ?> options) {
		return node == null ? null : new Deserializer().from(node, resource, true);
	}

	public JsonNode to(Resource resource, Map<?, ?> options) {
		JsonNode result = null;
		List<EObject> contents = resource.getContents();

		if (contents.size() == 1) {
			EObject root = contents.get(0);

			if (root instanceof JNode) {
				mapper.configure(SerializationFeature.INDENT_OUTPUT, false);

				result = new Serializer().to((JNode) root, mapper);
			}
		}

		return result;
	}

	public void write(OutputStream outputStream, JsonNode node) {
		if (node == null || outputStream == null)
			return;

		try {
			mapper.writeValue(outputStream, node);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
