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

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl.BasicEMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Utility class to facilitate access or modification of eObjects.
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
				Collection<EObject> values = (Collection<EObject>) owner.eGet(reference, false);
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
			Collection<Object> values = (Collection<Object>) owner.eGet(attribute, false);
			if (values != null && value != null) {
				values.add(value);
			}
		} else {
			owner.eSet(attribute, value);
		}
	}

	public static boolean isCandidate(EObject object, EStructuralFeature feature, boolean serializeDefaultValues) {
		return feature != null && (feature instanceof EAttribute ?
				isCandidate(object, (EAttribute) feature, serializeDefaultValues):
				isCandidate(object, (EReference) feature));
	}

	/**
	 * Checks that the attribute should be serialize.
	 *
	 * @param object
	 * @param attribute
	 * @return true if serializable
	 */
	public static boolean isCandidate(EObject object, EAttribute attribute, boolean serializeDefaultValues) {
		if (attribute.isDerived() || attribute.isTransient())
			return false;

		if (object.eIsSet(attribute)) {
			return true;
		}

		final Object value = object.eGet(attribute, false);
		final boolean isDefault = value != null && value.equals(attribute.getDefaultValue());

		return serializeDefaultValues && isDefault;
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
	 * Checks that the contained object is in a different resource than it's owner, making
	 * it a contained proxy.
	 *
	 * @param owner
	 * @param contained
	 * @return true if proxy
	 */
	public static boolean isContainmentProxy(EObject owner, EObject contained) {
		if (contained.eIsProxy())
			return true;

		Resource ownerResource = ((InternalEObject) owner).eInternalResource();
		Resource containedResource = ((InternalEObject) contained).eInternalResource();

		return ownerResource != null && ownerResource != containedResource;
	}

	/**
	 * Returns set of structural features being part of a feature map.
	 *
	 * @param owner     of feature
	 * @param attribute feature map
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
	 * @param key   of entry
	 * @param value of entry
	 * @return entry
	 */
	@SuppressWarnings("unchecked")
	public static EObject createEntry(String key, Object value, EClass type) {
		if (type == EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY) {

			final EObject entry = EcoreUtil.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
			entry.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY, key);
			entry.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, value);

			return entry;

		} else {

			final BasicEMapEntry entry = new BasicEMapEntry<>();
			entry.eSetClass(type);
			entry.setKey(key);
			entry.setValue(value);

			return entry;

		}
	}

	public static boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature) {
		return objectType != featureType && (featureType.isAbstract() || feature.getEGenericType().getETypeParameter() != null);
	}
}
