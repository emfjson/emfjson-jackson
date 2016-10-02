/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.emfjson.jackson.annotations.JsonAnnotations.getElementName;

/**
 * Basic cache implemented with maps to store objects that are frequently used during
 * serialization and deserialization operations.
 * <p/>
 * Objects that are cached include URIs, IDs, EClasses and EStructuralFeatures.
 */
public class Cache {

	private final Map<EObject, URI> mapOfID = new HashMap<>();
	private final Map<String, EClass> mapOfClasses = new HashMap<>();
	private final Map<String, URI> mapOfURIs = new HashMap<>();
	private final Map<EClass, String> mapOfTypes = new HashMap<>();

	/**
	 * Returns a eClass by it's full URI.
	 * <p/>
	 * If the eClass has not yet been cached, the method will cache it's
	 * URI object created from the string parameter, retrieve the eClass
	 * and cache it.
	 *
	 * @param resourceSet
	 * @param uri
	 * @return eClass
	 */
	public EClass getEClass(ResourceSet resourceSet, String uri) {
		EClass eClass = mapOfClasses.get(uri);
		if (eClass == null) {
			URI realURI = mapOfURIs.get(uri);
			if (realURI == null) {
				realURI = URI.createURI(uri);
				mapOfURIs.put(uri, realURI);
			}
			eClass = (EClass) resourceSet.getEObject(realURI, true);
			if (eClass != null) {
				mapOfClasses.put(uri, eClass);
			}
		}
		return eClass;
	}

	/**
	 * Returns the uri of a eClass.
	 *
	 * @param eClass
	 * @return uri
	 */
	public String getURI(EClass eClass) {
		if (eClass == null) {
			return null;
		}

		if (mapOfTypes.containsKey(eClass)) {
			return mapOfTypes.get(eClass);
		}

		final URI uri = EcoreUtil.getURI(eClass);
		mapOfTypes.put(eClass, uri.toString());

		return uri.toString();
	}

	public URI getURI(EObject object) {
		if (object == null) {
			return null;
		}

		URI uri = mapOfID.get(object);
		if (uri == null) {
			mapOfID.put(object, uri = EcoreUtil.getURI(object));
		}

		return uri;
	}

}
