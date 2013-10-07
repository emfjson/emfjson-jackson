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

import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author ghillairet
 * @since 0.6.0
 */
class Serializer {

	boolean serializeTypes = true;
	boolean serializeRefTypes = true;
	boolean serializeNamespaces = false;
	private EAttributeSerializer eAttributeSerializer;
	private EReferenceSerializer eReferenceSerializer;
	private MapSerializer mapSerializer;
	private NamespaceSerializer nsSerializer;

	private Map<String, String> namespaces = new HashMap<String, String>();

	Serializer() {
		this.eAttributeSerializer = new EAttributeSerializer();
		this.eReferenceSerializer = new EReferenceSerializer(this);
		this.mapSerializer = new MapSerializer();
		this.nsSerializer = new NamespaceSerializer();
	}

	JsonNode to(Resource resource, ObjectMapper mapper) {
		final EList<EObject> contents = resource.getContents();
		
		if (contents.size() == 1) {
			ObjectNode result = mapper.createObjectNode();

			if (serializeNamespaces) {
				nsSerializer.createNamespaceNode(result);
			}

			to(contents.get(0), resource, result);

			if (serializeNamespaces) {
				nsSerializer.serialize(result, getNamespaces());
			}

			return result;
		}
		else {
			ArrayNode result = mapper.createArrayNode();
			
			if (serializeNamespaces) {
				nsSerializer.createNamespaceNode(result);
			}

			for (EObject obj: contents) {
				JsonNode node = to(obj, resource, mapper);
				if (node != null) result.add(node);
			}
			
			if (serializeNamespaces) {
				nsSerializer.serialize(result, getNamespaces());
			}

			return result;
		}
	}

	ObjectNode to(EObject eObject, Resource resource, ObjectMapper mapper) {
		return to(eObject, resource, mapper.createObjectNode());
	}

	ObjectNode to(EObject eObject, Resource resource, ObjectNode target) {
		if (serializeTypes) {
			target.put(EJS_TYPE_KEYWORD, eClassRef(eObject.eClass()));	
		}

		eAttributeSerializer.serialize(eObject, target);
		eReferenceSerializer.serialize(eObject, target, resource);
		mapSerializer.serialize(eObject, target);

		return target;
	}

	void setSerializeRefTypes(boolean serializeRefTypes) {
		this.serializeRefTypes = serializeRefTypes;
	}

	void setSerializeTypes(boolean serializeTypes) {
		this.serializeTypes = serializeTypes;
	}

	void setSerializeNamespaces(boolean serializeNamespaces) {
		this.serializeNamespaces = serializeNamespaces;
	}
	
	Map<String, String> getNamespaces() {
		return namespaces;
	}

	String eClassRef(EClass eClass) {
		URI eClassURI = EcoreUtil.getURI(eClass);

		if (serializeNamespaces) {
			String prefix = eClass.getEPackage().getNsPrefix();
			String nsURI = eClass.getEPackage().getNsURI();
			getNamespaces().put(prefix, nsURI);
			return prefix + ":" + eClassURI.fragment();
		} else {
			return eClassURI.toString();
		}
	}

}
