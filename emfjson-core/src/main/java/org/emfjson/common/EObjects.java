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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

public class EObjects {

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

	public static void setOrAdd(EObject owner, EAttribute attribute, String value) {
		if (value != null && !value.trim().isEmpty()) {
			Object newValue  = EcoreUtil.createFromString(attribute.getEAttributeType(), value);

			if (attribute.isMany()) {
				@SuppressWarnings("unchecked")
				Collection<Object> values = (Collection<Object>) owner.eGet(attribute);
				if (values != null && newValue != null) {
					values.add(newValue);
				}
			} else {
				owner.eSet(attribute, newValue);
			}
		}
	}

	public static boolean isCandidate(EObject object, EAttribute attribute) {
		return (object.eIsSet(attribute) || attribute.getEType() instanceof EEnum) && 
				!attribute.isDerived() && 
				!attribute.isTransient() && 
				!attribute.isUnsettable();
	}

	public static boolean isFeatureMap(EAttribute eAttribute) {
		return FeatureMapUtil.isFeatureMap(eAttribute);
	}

	public static boolean isCandidate(EObject eObject, EReference eReference) {
		return !eReference.isTransient() && eObject.eIsSet(eReference);
	}

	public static boolean isMapEntry(EClassifier eType) {
        return eType != null && eType.equals(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
    }

	public static boolean isContainmentProxy(EObject owner, EObject contained) {
		return contained.eIsProxy() || owner.eResource() != null ? !owner.eResource().equals(contained.eResource()) : false;
	}

	public static Set<EStructuralFeature> featureMaps(EObject owner, EAttribute attribute) {
		final FeatureMap.Internal featureMap = (FeatureMap.Internal) owner.eGet(attribute);
		final Iterator<FeatureMap.Entry> iterator = featureMap.basicIterator();
		
		final Set<EStructuralFeature> features = new LinkedHashSet<>();
		while (iterator.hasNext()) {
			features.add(iterator.next().getEStructuralFeature());
		}

		return features;
	}

	public static EObject createEntry(String key, String value) {
		EObject eObject = EcoreUtil.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY, key);
		eObject.eSet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, value);
		return eObject;
	}

}
