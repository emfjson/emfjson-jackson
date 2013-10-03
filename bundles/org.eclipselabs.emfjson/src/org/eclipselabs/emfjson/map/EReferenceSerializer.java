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
import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;
import static org.eclipselabs.emfjson.common.ModelUtil.getElementName;
import static org.eclipselabs.emfjson.common.ModelUtil.isDynamicMapEntryFeature;
import static org.eclipselabs.emfjson.common.ModelUtil.isMapEntry;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author ghillairet
 * @since 0.6.0
 */
class EReferenceSerializer {

	private Serializer caller;

	EReferenceSerializer(Serializer caller) {
		this.caller = caller;
	}

	void serialize(EObject eObject, ObjectNode node, Resource resource) {
		for (EReference eReference: eObject.eClass().getEAllReferences()) {

			if (isCandidate(eObject, eReference)) {

				if (isMapEntry(eReference.getEType())) {
					serializeMapEntry(eObject, eReference, node);
				}
				else if (eReference.isContainment()) {
					serializeContainments(eObject, eReference, node, resource);
				}
				else {
					serializeReferences(node, eObject, eReference);
				}

			}
		}
	}

	void serializeReferences(ObjectNode target, EObject eObject, EReference reference) {
		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

			final ArrayNode arrayNode = target.arrayNode();
			target.put(getElementName(reference), arrayNode);

			for (EObject value: values) {
				serializeReferenceValue(eObject, value, reference, arrayNode);
			}
		} else {
			EObject value = (EObject) eObject.eGet(reference);
			target.put(reference.getName(), serializeReferenceValue(eObject, value, reference, target));
		}
	}

	ObjectNode serializeReferenceValue(EObject eObject, EObject value, EReference reference, JsonNode parent) {
		final Resource resource = eObject.eResource();

		ObjectNode node;
		if (parent.isArray()) {
			node = ((ArrayNode)parent).addObject();
		} else {
			node = ((ObjectNode)parent).objectNode();
		}

		node.put(EJS_REF_KEYWORD, getReference(value, resource));

		if (caller.serializeRefTypes) {
			node.put(EJS_TYPE_KEYWORD, eClassRef(value.eClass()));
		}

		return node;
	}

	void serializeContainments(EObject eObject, EReference reference, ObjectNode node, Resource resource) {
		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) eObject.eGet(reference);

			final ArrayNode arrayNode = node.arrayNode();
			node.put(getElementName(reference), arrayNode);

			for (EObject value: values) {
				ObjectNode target = arrayNode.addObject();
				serializeContainmentValue(eObject, value, reference, node, target, resource);
			}
		}
		else {
			final EObject value = (EObject) eObject.eGet(reference);
			ObjectNode target = node.objectNode();
			node.put(getElementName(reference), target);

			serializeContainmentValue(eObject, value, reference, node, target, resource);
		}
	}

	void serializeContainmentValue(EObject eObject, EObject value, EReference reference, ObjectNode parent, ObjectNode target, Resource resource) {
		if (value.eIsProxy() || !value.eResource().equals(resource)) {
			target.put(EJS_REF_KEYWORD, getReference(value, resource));
		}
		else {
			caller.to(value, resource, target);	
		}
	}

	void serializeMapEntry(EObject eObject, EReference reference, ObjectNode node) {
		final ObjectNode nodeRef = node.objectNode();

		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Map.Entry<String, String>> entries = (Collection<Entry<String, String>>) eObject.eGet(reference);

			for (Map.Entry<String, String> entry: entries) {
				nodeRef.put(entry.getKey(), entry.getValue());
			}
		}
		else {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> entry = (Entry<String, String>) eObject.eGet(reference);
			nodeRef.put(entry.getKey(), entry.getValue());
		}

		node.put(reference.getName(), nodeRef);
	}

	boolean isCandidate(EObject eObject, EReference eReference) {
		return !eReference.isTransient() && eObject.eIsSet(eReference) && !isDynamicMapEntryFeature(eReference);
	}

	String getReference(EObject obj, Resource resource) {
		URI eObjectURI = EcoreUtil.getURI(obj);
		URI resourceURI = resource.getURI();
		
		if (caller.serializeNamespaces) {
			URI nsURI = eObjectURI.trimFragment();
			String prefix = nsURI.lastSegment();
			caller.getNamespaces().put(prefix, nsURI.toString());

			return prefix + ":" + eObjectURI.fragment();
		} else if (eObjectURI.trimFragment().equals(resourceURI)) {
			return eObjectURI.fragment();
		} else {
			return eObjectURI.toString();
		}
	}
	
	String eClassRef(EClass eClass) {
		URI eClassURI = EcoreUtil.getURI(eClass);

		if (caller.serializeNamespaces) {
			String prefix = eClass.getEPackage().getNsPrefix();
			String nsURI = eClass.getEPackage().getNsURI();
			caller.getNamespaces().put(prefix, nsURI);

			return prefix + ":" + eClassURI.fragment();
		} else {
			return eClassURI.toString();
		}
	}

}
