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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ReferenceEntry {

	public final EObject owner;
	public final EReference reference;
	public final String id;

	public ReferenceEntry(EObject owner, EReference reference, String id) {
		this.owner = owner;
		this.reference = reference;
		this.id = id;
	}

	public void resolve(ResourceSet resourceSet, Options options) {
		final URI ref = createURIFromID(owner.eResource(), id);

		EObject target;
		if (ref == null) {
			target = owner.eResource().getEObject(id);
		} else {
			target = resourceSet.getEObject(ref, options.resolveProxy);
		}

		if (target != null) {
			EObjects.setOrAdd(owner, reference, target);
		}
	}

	protected URI createURIFromID(Resource current, String value) {
		if (value == null) {
			return null;
		}

		if (value.contains(":")) { // is full
            return URI.createURI(value);
        } else { // is fragment
        	if (current == null || current.getURI() == null) {
        		return null;
        	} else {
        		return current.getURI().appendFragment(value.startsWith("#") ? value.substring(1) : value);
        	}
        }
	}

}
