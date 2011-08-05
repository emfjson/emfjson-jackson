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
package org.eclipselabs.emfjson.internal;

import static org.eclipselabs.emfjson.internal.EJsUtil.getElementName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * 	@author ghillairet
 *	
 */
public class JsOutputStream extends ByteArrayOutputStream implements URIConverter.Saveable {
	
	@SuppressWarnings("unused")
	private Map<?, ?> options;
	
	protected final ObjectMapper mapper;
	
	protected JsonNode rootNode;
	
	public JsOutputStream() {
		this.mapper = new ObjectMapper();
	}

	public JsOutputStream(Map<?, ?> options) {
		this.options = options;
		this.mapper = new ObjectMapper();
	}
	
	@Override
	public void saveResource(Resource resource) throws IOException {
		rootNode = writeRootNode(resource);
		mapper.writeValue(this, rootNode);		
	}
	
	public JsonNode writeRootNode(Resource resource) 
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonNode rootNode;

		if (resource.getContents().size() == 1) {

			EObject rootObject = resource.getContents().get(0);
			rootNode = writeEObject(rootObject);

		} else {

			final Collection<JsonNode> nodes = new ArrayList<JsonNode>();
			rootNode = mapper.createArrayNode();

			for (EObject obj: resource.getContents()) {
				JsonNode node = writeEObject(obj);
				if (node != null) {
					nodes.add(node);
				}
			}

			((ArrayNode)rootNode).addAll(nodes);
		}

		return rootNode;
	}

	protected JsonNode writeEObject(EObject object) 
			throws JsonGenerationException, JsonMappingException, IOException {

		ObjectNode node = mapper.createObjectNode();

		writeEObjectAttributes(object, node);
		writeEObjectReferences(object, node);

		return node;
	}

	protected void writeEObjectAttributes(EObject object, ObjectNode node) {

		for (EAttribute attribute: object.eClass().getEAllAttributes()) {

			if (!attribute.isMany()) {
				setJsonValue(node, object, attribute);
			} else {
				// TODO
			}

		}

	}

	private void setJsonValue(ObjectNode node, EObject object, EAttribute attribute) {
		final Object value = object.eGet(attribute);
		final EDataType dataType = attribute.getEAttributeType();

		if (value != null) {
			if (dataType.getName().contains("Integer")) {
				node.put(getElementName(attribute), (Integer)value);	
			} else if (dataType.getName().contains("Boolean")) {
				node.put(getElementName(attribute), (Boolean)value);
			} else if (dataType.getName().contains("Double")) {
				node.put(getElementName(attribute), (Double)value);
			} else {
				node.put(getElementName(attribute), value.toString());
			}

		}
	}

	// if reference is non containment, objects are referenced thanks to their ids.
	protected void writeEObjectReferences(EObject object, ObjectNode node) {

		for (EReference reference: object.eClass().getEAllReferences()) {

			if (reference.isContainment()) {
				writeEObjectContainments(object, reference, node);
			} else {

				if (!reference.isMany()) {
					Object value = object.eGet(reference);
					if (value != null) {
						node.put(reference.getName(), EcoreUtil.getID((EObject) value));
					}
				}

			}

		}
	}

	// if reference is containment, then objects are put in an ArrayNode
	protected void writeEObjectContainments(EObject object, EReference reference, ObjectNode node) {

		if (reference.isMany()) {

			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) object.eGet(reference);

			if (!values.isEmpty()) {
				final ArrayNode arrayNode = mapper.createArrayNode();
				node.put(getElementName(reference), arrayNode);

				for (EObject obj: values) {
					ObjectNode subNode = arrayNode.addObject();
					writeEObjectAttributes(obj, subNode);
					writeEObjectReferences(obj, subNode);
				}
			}
		} else {

			final Object value = object.eGet(reference);

			if (value != null) {
				final ObjectNode subNode = node.objectNode();

				node.put(getElementName(reference), subNode);
				writeEObjectAttributes((EObject) value, subNode);
				writeEObjectReferences((EObject) value, subNode);
			}
		}

	}
	
}
