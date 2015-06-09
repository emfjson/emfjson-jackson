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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.emfjson.handlers.URIHandler;

public class ReferenceEntry {

	public final EObject owner;
	public final EReference reference;
	public final String id;

	public ReferenceEntry(EObject owner, EReference reference, String id) {
		this.owner = owner;
		this.reference = reference;
		this.id = id;
	}

	public void resolve(ResourceSet resourceSet, URIHandler handler) {
		EObject target = owner.eResource().getEObject(id);

		if (target != null) {
			EObjects.setOrAdd(owner, reference, target);
		} else {
			URI baseURI = owner.eResource().getURI().trimFragment();
            URI uri = URI.createURI(id);

			if (handler != null) {
                uri = handler.resolve(baseURI, uri);
            } else {
                uri = uri.resolve(baseURI, false);
            }

			target = resourceSet.getEObject(uri, true);

			if (target != null) {
				EObjects.setOrAdd(owner, reference, target);
			}
		}
	}

}
