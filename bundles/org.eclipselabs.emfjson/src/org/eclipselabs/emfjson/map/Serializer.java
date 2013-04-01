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

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * @author ghillairet
 * @since 0.6.0
 */
class Serializer {

	boolean serializeTypes;
	boolean serializeRefTypes;
	private EAttributeSerializer eAttributeSerializer;
	private EReferenceSerializer eReferenceSerializer;
	private MapSerializer mapSerializer;

	Serializer(boolean serializeTypes, boolean serializeRefTypes) {
		this.serializeTypes = serializeTypes;
		this.serializeRefTypes = serializeRefTypes;
		this.eAttributeSerializer = new EAttributeSerializer();
		this.eReferenceSerializer = new EReferenceSerializer(this);
		this.mapSerializer = new MapSerializer();
	}

	ObjectNode to(EObject eObject, Resource resource, ObjectMapper mapper) {
		return to(eObject, resource, mapper.createObjectNode());
	}

	ObjectNode to(EObject eObject, Resource resource, ObjectNode target) {
		final URI eClassURI = EcoreUtil.getURI(eObject.eClass());
		if (serializeTypes) {
			target.put(EJS_TYPE_KEYWORD, eClassURI.toString());
		}

		eAttributeSerializer.serialize(eObject, target);
		eReferenceSerializer.serialize(eObject, target, resource);
		mapSerializer.serialize(eObject, target);

		return target;
	}

}
