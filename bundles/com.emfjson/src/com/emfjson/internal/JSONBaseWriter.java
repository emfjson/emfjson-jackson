/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package com.emfjson.internal;

import static com.emfjson.internal.JSONEcoreUtil.getElementName;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * @author guillaume
 *
 */
public class JSONBaseWriter implements JsonWriter {

	private final ObjectMapper mapper;
	
	public JSONBaseWriter() {
		mapper = new ObjectMapper();
	}
	
	@Override
	public void writeResource(Resource resource) throws JsonGenerationException, JsonMappingException, IOException {
		writeResource(resource, resource.getURI());
	}
	
	@Override
	public void writeResource(Resource resource, URI dest) throws JsonGenerationException, JsonMappingException, IOException {
		JsonNode rootNode;
		if (resource.getContents().size() == 1) {
			EObject rootObject = resource.getContents().get(0);
			rootNode = writeEObject(rootObject);
		} else {
			Collection<JsonNode> nodes = new ArrayList<JsonNode>();
			rootNode = mapper.createArrayNode();
			for (EObject obj: resource.getContents()) {
				JsonNode node = writeEObject(obj);
				if (node != null) {
					nodes.add(node);
				}
			}
			((ArrayNode)rootNode).addAll(nodes);
		}
		
		mapper.writeValue(new File(dest.toFileString()), rootNode);
	}
	
	@Override
	public JsonNode writeEObject(EObject object) 
			throws JsonGenerationException, JsonMappingException, IOException {
	
		ObjectNode node = mapper.createObjectNode();

		writeEObjectAttributes(object, node);
		writeEObejctContainments(object, node);
		
		return node;
	}

	protected void writeEObjectAttributes(EObject object, ObjectNode node) {
		for (EAttribute attribute: object.eClass().getEAllAttributes()) {
			if (!attribute.isMany()) {
				Object value = object.eGet(attribute);
				if (value != null) {
					node.put(getElementName(attribute), value.toString());
				}
			}
		}
	}

	protected void writeEObejctContainments(EObject object, ObjectNode node) {
		for (EReference reference: object.eClass().getEAllContainments()) {
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) object.eGet(reference);
				if (!values.isEmpty()) {
					ArrayNode arrayNode = mapper.createArrayNode();
					node.put(getElementName(reference), arrayNode);
					
					for (EObject obj: values) {
						ObjectNode subNode = arrayNode.addObject();
						writeEObjectAttributes(obj, subNode);
					}
				}
			} else {
				Object value = object.eGet(reference);
				if (value != null) {
					ObjectNode subNode = node.objectNode();
					node.put(getElementName(reference), subNode);
					writeEObjectAttributes((EObject) value, subNode);
				}
			}
		}
	}
}
