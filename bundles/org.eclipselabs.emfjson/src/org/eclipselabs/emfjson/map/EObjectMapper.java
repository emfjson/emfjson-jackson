/*******************************************************************************
 * Copyright (c) 2013 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.map;

import static java.lang.Boolean.TRUE;
import static org.eclipselabs.emfjson.EMFJs.OPTION_INDENT_OUTPUT;
import static org.eclipselabs.emfjson.EMFJs.OPTION_PROXY_ATTRIBUTES;
import static org.eclipselabs.emfjson.EMFJs.OPTION_ROOT_ELEMENT;
import static org.eclipselabs.emfjson.EMFJs.OPTION_SERIALIZE_NAMESPACES;
import static org.eclipselabs.emfjson.EMFJs.OPTION_SERIALIZE_REF_TYPE;
import static org.eclipselabs.emfjson.EMFJs.OPTION_SERIALIZE_TYPE;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * @author ghillairet
 * @since 0.6.0
 */
public class EObjectMapper {

	private boolean serializeTypes = true;
	private boolean serializeRefTypes = true;
	private boolean useProxyAttributes = false;
	private boolean serializeNamespaces = false;
	private EClass rootClass = null;

	private final ObjectMapper objectMapper = new ObjectMapper();	
	
	public EObjectMapper() {}

	public Object from(InputStream inputStream, Resource resource, Map<?, ?> options) {		
		JsonNode node = null;
		try {
			node = objectMapper.readTree(inputStream);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return node == null ? null : from(node, resource, options);
	}

	public Object from(URL url, Resource resource, Map<?, ?> options) {
		JsonNode node = null;
		try {
			node = objectMapper.readTree(url);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return node == null ? null : from(node, resource, options);
	}

	public Object from(JsonNode node, Resource resource, Map<?, ?> options) {
		if (node == null) return null;

		configureDeserializer(options);

		if (node.isArray()) {
			return from((ArrayNode) node, resource);
		}
		else if (node.isObject()) {
			return from((ObjectNode) node, resource);
		} else {
			return null;
		}
	}

	public EObject from(ObjectNode node, Resource resource) {
		final EList<EObject> contents = resource.getContents();
		Deserializer from = new Deserializer(useProxyAttributes);
		EObject result = from.from(node, rootClass, resource);
		if (result != null) {
			contents.add(result);
			from.resolve(resource);
		}

		return result;
	}

	public EList<EObject> from(ArrayNode node, Resource resource) {
		final EList<EObject> contents = resource.getContents();
		
		Deserializer from = new Deserializer(useProxyAttributes);
		EList<EObject> result = from.from(node, rootClass, resource);
		contents.addAll(result);
		from.resolve(resource);

		return result;
	}
	
	public JsonNode to(Resource resource, Map<?, ?> options) {
		configureSerializer(options);

		Serializer to = new Serializer();
		to.setSerializeNamespaces(serializeNamespaces);
		to.setSerializeRefTypes(serializeRefTypes);
		to.setSerializeTypes(serializeTypes);

		return to.to(resource, objectMapper);
	}

	public ObjectNode to(EObject eObject, Resource resource) {
		Serializer to = new Serializer();
		to.setSerializeNamespaces(serializeNamespaces);
		to.setSerializeRefTypes(serializeRefTypes);
		to.setSerializeTypes(serializeTypes);

		return to.to(eObject, resource, objectMapper);
	}

	public ObjectNode to(EObject eObject, Resource resource, Map<?, ?> options) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.INDENT_OUTPUT, false);

		return to(eObject, resource);
	}
	
	public void write(OutputStream outStream, Resource resource, Map<?, ?> options) {
		write(outStream, to(resource, options));
	}

	public void write(OutputStream output, JsonNode current) {
		try {
			objectMapper.writeValue(output, current);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void configureDeserializer(Map<?, ?> options) {
		if (options == null) {
			options = Collections.emptyMap();
		}

		if (options.containsKey(OPTION_ROOT_ELEMENT)) {
			Object optionEClass = options.get(OPTION_ROOT_ELEMENT);
			if (optionEClass instanceof EClass) {
				configure(OPTION_ROOT_ELEMENT, (EClass) optionEClass);
			}
		}

		configure(OPTION_PROXY_ATTRIBUTES, TRUE.equals(options.get(OPTION_PROXY_ATTRIBUTES)));
	}

	private void configureSerializer(Map<?, ?> options) {
		if (options == null) {
			options = Collections.emptyMap();
		}

		boolean serializeTypes = true;
		boolean serializeRefTypes = true;
		boolean serializeNamespaces = false;
		boolean indent = true;

		if (options.containsKey(OPTION_INDENT_OUTPUT)) {
			try {
				indent = (Boolean) options.get(OPTION_INDENT_OUTPUT);
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
		if (options.containsKey(OPTION_SERIALIZE_TYPE)) {
			try {
				serializeTypes = (Boolean) options.get(OPTION_SERIALIZE_TYPE);
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
		if (options.containsKey(OPTION_SERIALIZE_REF_TYPE)) {
			try {
				serializeRefTypes = (Boolean) options.get(OPTION_SERIALIZE_REF_TYPE);
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
		if (options.containsKey(OPTION_SERIALIZE_NAMESPACES)) {
			try {
				serializeNamespaces = (Boolean) options.get(OPTION_SERIALIZE_NAMESPACES);
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
		
		configure(OPTION_SERIALIZE_TYPE, serializeTypes);
		configure(OPTION_SERIALIZE_REF_TYPE, serializeRefTypes);
		configure(OPTION_SERIALIZE_NAMESPACES, serializeNamespaces);
		objectMapper.configure(Feature.INDENT_OUTPUT, indent);
	}

	public void configure(String key, Object value) {		
		if (OPTION_SERIALIZE_TYPE.equals(key)) {
			serializeTypes = (Boolean) value;
		}
		if (OPTION_SERIALIZE_REF_TYPE.equals(key)) {
			serializeRefTypes = (Boolean) value;
		}
		if (OPTION_SERIALIZE_NAMESPACES.equals(key)) {
			serializeNamespaces = (Boolean) value;
		}
		if (OPTION_ROOT_ELEMENT.equals(key)) {
			rootClass = (EClass) value;
		}
		if (OPTION_PROXY_ATTRIBUTES.equals(key)) {
			useProxyAttributes = (Boolean) value;
		}
	}

}
