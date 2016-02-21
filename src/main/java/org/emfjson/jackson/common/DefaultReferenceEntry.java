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
package org.emfjson.jackson.common;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.EObjects;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.handlers.URIHandler;

public class DefaultReferenceEntry implements ReferenceEntries.ReferenceEntry {

	private final EObject owner;
	private final EReference reference;
	private final String id;
	private final String type;

	public DefaultReferenceEntry(EObject owner, EReference reference, String id) {
		this(owner, reference, id, null);
	}

	public DefaultReferenceEntry(EObject owner, EReference reference, String id, String type) {
		this.owner = owner;
		this.reference = reference;
		this.id = id;
		this.type = type;
	}

	@Override
	public void resolve(ResourceSet resourceSet, URIHandler handler, ReferenceEntries entries) {
		EObject target = entries.get(id);

		if (target == null) {
			URI uri = URI.createURI(id);

			if (reference.isResolveProxies() && type != null) {

				target = createProxy(resourceSet);

			} else {

				target = owner.eResource().getEObject(id);

				if (target == null) {
					URI baseURI = owner.eResource().getURI().trimFragment();

					if (handler != null) {
						uri = handler.resolve(baseURI, uri);
					} else {
						if (baseURI.isHierarchical() && !baseURI.isRelative()) {
							uri = uri.resolve(baseURI, false);
						}
					}

					target = resourceSet.getEObject(uri, true);
				}
			}

			if (target != null) {
				entries.store(id, target);
			}
		}

		if (target != null) {
			EObjects.setOrAdd(owner, reference, target);
		}
	}

	private EObject createProxy(ResourceSet resourceSet) {
		EClass eClass;
		try {
			eClass = (EClass) resourceSet.getEObject(URI.createURI(type), true);
		} catch (Exception e) {
			return null;
		}

		if (eClass == null)
			return null;

		EObject object = EcoreUtil.create(eClass);
		((InternalEObject) object).eSetProxyURI(URI.createURI(id));

		return object;
	}

}
