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
package org.emfjson.common;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.JacksonOptions;

import java.util.*;

/**
 * Utility class to facilitate access or modification of eObjects.
 *
 */
public class EObjects {

	/**
	 * Set or add a value to an object reference. The value must be
	 * an EObject.
	 *
	 * @param owner
	 * @param reference
	 * @param value
	 */
	public static void setOrAdd(EObject owner, EReference reference, Object value) {
		if (value != null) {
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				Collection<EObject> values = (Collection<EObject>) owner.eGet(reference);
				if (values != null && value instanceof EObject) {
					values.add((EObject) value);
				}
			} else {
				owner.eSet(reference, value);
			}
		}
	}

	/**
	 * Set or add a value to an object attribute.
	 *
	 * @param owner
	 * @param attribute
	 * @param value
	 */
	public static void setOrAdd(EObject owner, EAttribute attribute, Object value) {
		if (attribute.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Object> values = (Collection<Object>) owner.eGet(attribute);
			if (values != null && value != null) {
				values.add(value);
			}
		} else {
			owner.eSet(attribute, value);
		}
	}

	/**
	 * Checks that the attribute should be serialize.
	 *
	 * @param object
	 * @param attribute
	 * @return true if serializable
	 */
	public static boolean isCandidate(EObject object, EAttribute attribute, JacksonOptions options) {
		if (attribute.isDerived() || attribute.isTransient())
			return false;

		if (object.eIsSet(attribute)) {
			return true;
		}

		final Object value = object.eGet(attribute);
		final boolean isDefault = value != null && value.equals(attribute.getDefaultValue());

		return options.serializeDefaultValues && isDefault;
	}

	/**
	 * Checks that the reference should be serialize.
	 *
	 * @param eObject
	 * @param eReference
	 * @return true if serializable
	 */
	public static boolean isCandidate(EObject eObject, EReference eReference) {
		if (eReference.isTransient()) {
			return false;
		}

		EReference opposite = eReference.getEOpposite();
		return !(opposite != null && opposite.isContainment()) && eObject.eIsSet(eReference);
	}

	/**
	 * Checks that the attribute is a feature map.
	 *
	 * @param eAttribute
	 * @return true if feature map
	 */
	public static boolean isFeatureMap(EAttribute eAttribute) {
		return FeatureMapUtil.isFeatureMap(eAttribute);
	}

	/**
	 * Checks that the eClassifier is a map entry.
	 *
	 * @param eType
	 * @return true if map entry
	 */
	public static boolean isMapEntry(EClassifier eType) {
		return eType != null && eType.equals(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
	}

	/**
	 * Checks that the contained object is in a different resource than it's owner, making
	 * it a contained proxy.
	 *
	 * @param owner
	 * @param contained
	 * @return true if proxy
	 */
	public static boolean isContainmentProxy(EObject owner, EObject contained) {
		return contained.eIsProxy() || (owner.eResource() != null && !owner.eResource().equals(contained.eResource()));
	}

	/**
	 * Returns set of structural features being part of a feature map.
	 *
	 * @param owner
	 * @param attribute
	 * @return set of features
	 */
	public static Set<EStructuralFeature> featureMaps(EObject owner, EAttribute attribute) {
		final FeatureMap.Internal featureMap = (FeatureMap.Internal) owner.eGet(attribute);
		final Iterator<FeatureMap.Entry> iterator = featureMap.basicIterator();

		final Set<EStructuralFeature> features = new LinkedHashSet<>();
		while (iterator.hasNext()) {
			features.add(iterator.next().getEStructuralFeature());
		}

		return features;
	}

	/**
	 * Creates a map entry of type string, string.
	 *
	 * @param key
	 * @param value
	 * @return entry
	 */
	public static EObject createEntry(String key, String value) {
		EObject eObject = EcoreUtil.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY, key);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, value);
		return eObject;
	}

}
