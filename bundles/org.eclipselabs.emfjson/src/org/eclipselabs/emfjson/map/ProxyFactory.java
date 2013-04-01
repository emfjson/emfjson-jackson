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

import org.codehaus.jackson.JsonNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

class ProxyFactory {

	private Deserializer deserializer;	

	ProxyFactory(Deserializer deserializer) {
		this.deserializer = deserializer;
	}

	EObject createProxy(Resource resource, EClass eClass, JsonNode node) {
		final URI objectURI = getEObjectURI(node.get(EJS_REF_KEYWORD), 
				resource, 
				deserializer.getNamespaces());

		final EObject proxy = EcoreUtil.create(eClass);
		((InternalEObject) proxy).eSetProxyURI(objectURI);

		if (deserializer.useProxyAttributes()) {
			JsonNode refNode = JSUtil.getNode(resource, objectURI, eClass);

			if (refNode != null) {
				deserializer.geteAtttributeDeserializer().deSerialize(proxy, refNode);
			}
		}

		return proxy;
	}

}
