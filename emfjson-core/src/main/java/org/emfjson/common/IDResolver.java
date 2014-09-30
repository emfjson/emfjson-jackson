/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.common;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class IDResolver {

	private final URI resourceURI;
	
	private final Map<EObject, String> mapOfID = new HashMap<>();

	public IDResolver(URI resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String get(EObject object) {
		String key = mapOfID.get(object);
		if (key != null) {
			return key;
		}

		final URI eObjectURI = EcoreUtil.getURI(object);
		final String fragment = eObjectURI.fragment();
		final URI baseURI = eObjectURI.trimFragment().trimQuery();

		if (baseURI.equals(resourceURI)) {
			key = fragment;
		} else {
			key = eObjectURI.toString();
		}

		mapOfID.put(object, key);

		return key;
	}

	public URI get(String value) {
		if (value == null) {
			return null;
		}
		if (value.contains(":")) {
            // is full
            return URI.createURI(value);
        } else { 
        	// is fragment
            return resourceURI.appendFragment(value.startsWith("#") ? value.substring(1) : value);
        }
	}

}
