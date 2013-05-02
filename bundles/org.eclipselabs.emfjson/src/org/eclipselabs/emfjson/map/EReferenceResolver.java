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

import static org.eclipselabs.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.common.ModelUtil.getEObjectURI;
import static org.eclipselabs.emfjson.common.ModelUtil.getEReference;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.InternalEList;

class EReferenceResolver {

	private Deserializer deserializer;

	EReferenceResolver(Deserializer deserializer) {
		this.deserializer = deserializer;
	}

	void resolve(Map<EObject, JsonNode> processed, Resource resource) {
		for (EObject eObject: processed.keySet()) {
			resolve(eObject, processed.get(eObject), resource, processed);
		}
	}

	void resolve(EObject eObject, JsonNode node, Resource resource, Map<EObject, JsonNode> processed) {

		if (!node.isObject()) return;

		final EClass eClass = eObject.eClass();
		final ObjectNode root = (ObjectNode) node;

		for (Iterator<Entry<String, JsonNode>> it = root.getFields(); it.hasNext();) {
			Entry<String, JsonNode> field = it.next();

			String key = field.getKey();
			JsonNode value = field.getValue();

			EReference reference = getEReference(eClass, key);
			if (reference != null && !reference.isContainment() && 
					!reference.isDerived() && !reference.isTransient()) {

				if (value.isArray()) {
					for (Iterator<JsonNode> itEl = value.getElements(); itEl.hasNext();) {
						JsonNode current = itEl.next();
						createProxyReference(eObject, root, current, reference, resource);
					}
				} else {
					createProxyReference(eObject, root, value, reference, resource);
				}
			}
		}
	}

	EObject getOrCreateProxyReference(EReference reference, JsonNode root, JsonNode node, Resource resource) {
		EObject obj = findEObject(resource, node);
		if (obj == null) {
			EClass refClass = JSUtil.findEClass(reference.getEReferenceType(), node, root, resource, deserializer.getNamespaces());
			if (refClass != null) {
				obj = deserializer.getProxyFactory().createProxy(resource, refClass, node);
			}
		}
		return obj;
	}

	void createProxyReference(EObject eObject, JsonNode root, JsonNode node, EReference reference, Resource resource) {
		EObject proxy = getOrCreateProxyReference(reference, root, node, resource);
		if (proxy != null && reference.isMany()) {
			@SuppressWarnings("unchecked")
			InternalEList<EObject> values = (InternalEList<EObject>) eObject.eGet(reference);
			values.addUnique(proxy);
		} else if (proxy != null) {
			eObject.eSet(reference, proxy);
		}
	}

	EObject findEObject(Resource resource, JsonNode node) {
		EObject eObject = null;
		if (node.isObject()) {
			final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), 
					resource, 
					deserializer.getNamespaces());

			eObject = resource.getResourceSet().getEObject(objectURI, false);
		}
		return eObject;
	}
}
