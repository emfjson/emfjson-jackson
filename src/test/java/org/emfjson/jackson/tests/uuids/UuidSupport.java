/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */
package org.emfjson.jackson.tests.uuids;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.resource.JsonUuidResource;

import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;

public abstract class UuidSupport {

	protected ResourceSet resourceSet = new ResourceSetImpl();

	protected String uuid(EObject object) {
		return getURI(object).fragment();
	}

	protected String uuid(JsonNode node) {
		return node.get("@id").asText();
	}

	protected Resource createUuidResource(String name, ObjectMapper mapper) {
		JsonResource resource = new JsonUuidResource(URI.createURI(name));
		resource.setObjectMapper(mapper);
		resourceSet.getResources().add(resource);
		return resource;
	}

}
