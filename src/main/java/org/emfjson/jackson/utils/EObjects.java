/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */
package org.emfjson.jackson.utils;

import com.fasterxml.jackson.databind.DatabindContext;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl.BasicEMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.databind.EMFContext;

import java.util.Collection;

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
	 * Checks that the contained object is in a different resource than it's owner, making
	 * it a contained proxy.
	 *
	 * @param owner
	 * @param contained
	 * @return true if proxy
	 */
	public static boolean isContainmentProxy(DatabindContext ctxt, EObject owner, EObject contained) {
		if (contained.eIsProxy())
			return true;

		Resource ownerResource = EMFContext.getResource(ctxt, owner);
		Resource containedResource = EMFContext.getResource(ctxt, contained);

		return ownerResource != null && ownerResource != containedResource;
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

}
