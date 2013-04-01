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
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.common.ModelUtil;

class Deserializer {

	private Map<EObject, JsonNode> processed;
	private EAtttributeDeserializer eAtttributeDeserializer;
	private EReferenceDeserializer eReferenceDeserializer;
	private EReferenceResolver resolver;
	private NamespaceDeserializer namespaceDeserializer;
	private Map<String, String> namespaces = new HashMap<String, String>();
	private boolean useProxyAttributes;
	private ProxyFactory proxyFactory;

	Deserializer(boolean useProxyAttributes) {
		this.processed = new HashMap<EObject, JsonNode>();
		this.useProxyAttributes = useProxyAttributes;
		this.eAtttributeDeserializer = new EAtttributeDeserializer();

		this.proxyFactory = new ProxyFactory(this);
		this.eReferenceDeserializer = new EReferenceDeserializer(this);
		this.resolver = new EReferenceResolver(this);
		this.namespaceDeserializer = new NamespaceDeserializer();
	}

	EObject from(ObjectNode node, EClass eClass, Resource resource) {
		EObject eObject = null;
		
		namespaces.putAll(namespaceDeserializer.deSerialize(node));

		if (eClass == null) {
			if (node.has(EJS_TYPE_KEYWORD)) {
				URI eClassURI = ModelUtil.getEObjectURI(node.get(EJS_TYPE_KEYWORD), 
						resource,
						getNamespaces());
				eClass = getEClass(eClassURI, resource.getResourceSet());
			}
		}
		
		if (eClass != null && eClass instanceof EClass) {
			eObject = EcoreUtil.create(eClass);
			processed.put(eObject, node);

			eAtttributeDeserializer.deSerialize(eObject, node);
			eReferenceDeserializer.deSerialize(eObject, node, resource);
		}

		return eObject;
	}

	EObject from(ObjectNode node, Resource resource) {		
		return from(node, null, resource);
	}

	EList<EObject> from(ArrayNode node, Resource resource) {
		return from(node, null, resource);
	}
	
	EList<EObject> from(ArrayNode node, EClass rootClass, Resource resource) {
		final EList<EObject> returnList = new BasicEList<EObject>();
		EObject eObject;

		for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
			JsonNode element = it.next();
			if (element.isObject()) {
				eObject = from((ObjectNode) element, rootClass, resource);
				if (eObject != null) {
					returnList.add(eObject);
				}
			}
		}

		return returnList;
	}

	void resolve(Resource resource) {		
		resolver.resolve(processed, resource);
		processed.clear();
	}

	private EClass getEClass(URI uri, ResourceSet resourceSet) {
		return (EClass) resourceSet.getEObject(uri, true);
	}
	
	public EAtttributeDeserializer geteAtttributeDeserializer() {
		return eAtttributeDeserializer;
	}
	
	public EReferenceDeserializer geteReferenceDeserializer() {
		return eReferenceDeserializer;
	}
	
	public NamespaceDeserializer getNamespaceDeserializer() {
		return namespaceDeserializer;
	}
	
	public ProxyFactory getProxyFactory() {
		return proxyFactory;
	}
	
	public Map<String, String> getNamespaces() {
		return namespaces;
	}
	
	public Map<EObject, JsonNode> getProcessed() {
		return processed;
	}

	public boolean useProxyAttributes() {
		return useProxyAttributes;
	}

}
