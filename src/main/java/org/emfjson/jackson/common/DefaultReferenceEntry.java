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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.handlers.URIHandler;

public class DefaultReferenceEntry implements ReferenceEntries.ReferenceEntry {

	public final EObject owner;
	public final EReference reference;
	public final String id;

	public DefaultReferenceEntry(EObject owner, EReference reference, String id) {
		this.owner = owner;
		this.reference = reference;
		this.id = id;
	}

	@Override
	public void resolve(ResourceSet resourceSet, URIHandler handler, ReferenceEntries entries) {
		EObject target = entries.get(id);

		if (target == null) {
			URI uri = URI.createURI(id);

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

			if (target != null) {
				entries.store(id, target);
			}
		}

		if (target != null) {
			EObjects.setOrAdd(owner, reference, target);
		}
	}

}
