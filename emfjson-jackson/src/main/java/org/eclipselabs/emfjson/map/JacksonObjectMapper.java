package org.eclipselabs.emfjson.map;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.common.Options;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonObjectMapper {

	public List<EObject> fromArray(ArrayNode array, Resource resource, Map<?, ?> options) {
		if (resource == null) return Collections.emptyList();

		final EList<EObject> contents = resource.getContents();
		if (array == null || array.size() == 0) return contents;

		if (!contents.isEmpty()) {
			contents.clear();
		}

		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			resourceSet.getResources().add(resource);
		}

		final ObjectReader reader = new ObjectReader(resource, resourceSet, Options.from(options).build());
		for (Iterator<JsonNode> it = array.elements(); it.hasNext();) {
			JsonNode node = it.next();
			EObject object = reader.from(node);
			if (object != null) {
				contents.add(object);
			}
		} 
		reader.resolveEntries();

		return contents;
	}

	public EObject fromObject(ObjectNode node, Resource resource, Map<?, ?> options) {
		if (resource == null || node == null) return null;

		final EList<EObject> contents = resource.getContents();
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			resourceSet.getResources().add(resource);
		}

		final ObjectReader reader = new ObjectReader(resource, resourceSet, Options.from(options).build());
		final EObject result = reader.from(node);

		if (result != null) {
			if (!contents.isEmpty()) {
				contents.clear();
			}
			contents.add(result);
			reader.resolveEntries();
		}

		return result;
	}

	public ObjectNode toObject(EObject object, Map<?, ?> options) {
		if (object == null) return null;
		if (object.eResource() == null) throw new IllegalArgumentException("EObject must be contained in a resource");

		final ObjectMapper mapper = new ObjectMapper();
		final ObjectWriter writer = new ObjectWriter(mapper, object.eResource(), Options.from(options).build());

		return writer.generate(object);
	}

	public JsonNode toNode(Resource resource, Map<?, ?> options) {
		if (resource == null) return null;

		final ObjectMapper mapper = new ObjectMapper();
		final ObjectWriter writer = new ObjectWriter(mapper, resource, Options.from(options).build());

		return writer.toNode();
	}

	public void write(Resource resource, OutputStream stream, Map<?, ?> options) {
		if (resource == null) return;

		final ObjectMapper mapper = new ObjectMapper();
		final ObjectWriter writer = new ObjectWriter(mapper, resource, Options.from(options).build());

		try {
			mapper.writeValue(stream, writer.toNode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
