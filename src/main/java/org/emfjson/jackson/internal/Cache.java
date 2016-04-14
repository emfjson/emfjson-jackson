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
package org.emfjson.jackson.internal;

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

	public final Map<EObject, URI> mapOfID = new HashMap<>();
	protected final Map<String, EClass> mapOfClasses = new HashMap<>();
	protected final Map<String, URI> mapOfURIs = new HashMap<>();

	private final Map<EStructuralFeature, String> mapOfNames = new HashMap<>();
	private final Map<EClass, Map<String, EStructuralFeature>> mapOfFeatures = new HashMap<>();
	private final Map<EClass, String> mapOfTypes = new HashMap<>();

	/**
	 * Returns the field name to be used by a structural feature.
	 * <p/>
	 * Custom names can be defined by using an eAnnotation on a eStructuralFeature with
	 * a source named JSON and a value being the field name.
	 *
	 * @param feature
	 * @return field name
	 */
	public String getKey(EStructuralFeature feature) {
		String key = mapOfNames.get(feature);
		if (key == null) {
			key = getElementName(feature);
			mapOfNames.put(feature, key);
		}
		return key;
	}

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
	 * Returns the eStructuralFeature of a given eClass from a key. The key
	 * corresponds to a field name.
	 *
	 * @param eClass
	 * @param key
	 * @return eStructuralFeature
	 */
	public EStructuralFeature getEStructuralFeature(EClass eClass, String key) {
		Map<String, EStructuralFeature> featureByKey = mapOfFeatures.get(eClass);

		if (featureByKey == null) {
			featureByKey = new HashMap<>();
			mapOfFeatures.put(eClass, featureByKey);
		}

		EStructuralFeature feature = featureByKey.get(key);
		if (feature == null) {
			feature = findEStructuralFeature(eClass, key);
			if (feature != null) {
				featureByKey.put(key, feature);
			}
		}

		return feature;
	}

	private EStructuralFeature findEStructuralFeature(EClass eClass, String key) {
		if (eClass == null || key == null)
			return null;

		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(key);

		if (eStructuralFeature == null) {
			int i = 0;
			List<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
			while (i < features.size() && eStructuralFeature == null) {
				EStructuralFeature current = features.get(i);
				if (key.equals(getKey(current))) {
					eStructuralFeature = current;
				}
				i++;
			}
		}

		return eStructuralFeature;
	}

	/**
	 * Returns the uri of a eClass.
	 *
	 * @param eClass
	 * @return uri
	 */
	public String getType(EClass eClass) {
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
