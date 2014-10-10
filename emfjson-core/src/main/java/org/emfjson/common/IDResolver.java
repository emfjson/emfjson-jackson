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
	private final Options options;
	
	private final Map<EObject, String> mapOfID = new HashMap<>();

	public IDResolver(URI resourceURI) {
		this(resourceURI, null);
	}
	
	public IDResolver(URI resourceURI, Options options) {
		this.resourceURI = resourceURI;
		this.options = options;
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public String getValue(EObject object) {
		String key = mapOfID.get(object);
		if (key != null) {
			return key;
		}

		final URI eObjectURI = EcoreUtil.getURI(object);
		final String fragment = eObjectURI.fragment();
		final String query = eObjectURI.query();

		URI baseURI = eObjectURI.trimFragment().trimQuery();
		if (options != null && options.uriHandler != null) {
			baseURI = options.uriHandler.dereseolve(baseURI);
		}

		if (baseURI.equals(resourceURI)) {
			key = fragment;
		} else {
			baseURI = baseURI.appendFragment(fragment).appendQuery(query);
			key = baseURI.toString();
		}

		mapOfID.put(object, key);

		return key;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public URI createFromValue(String value) {
		if (value == null) {
			return null;
		}

		if (value.contains(":")) {
            // is full
            URI uri = URI.createURI(value);
            if (options != null && options.uriHandler != null) {
            	uri = options.uriHandler.resolve(uri);
            }
            return uri;
        } else { 
        	// is fragment
            return resourceURI.appendFragment(value.startsWith("#") ? value.substring(1) : value);
        }
	}

}
