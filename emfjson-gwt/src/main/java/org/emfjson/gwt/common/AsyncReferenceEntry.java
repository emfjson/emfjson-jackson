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
package org.emfjson.gwt.common;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import org.emfjson.common.EObjects;
import org.emfjson.common.DefaultReferenceEntry;

public class AsyncReferenceEntry extends DefaultReferenceEntry {

	public AsyncReferenceEntry(EObject owner, EReference reference, String id) {
		super(owner, reference, id);
	}

	public void resolve(final Resource resource, final Callback<Resource> callback) {
		EObject target = owner.eResource().getEObject(id);

		if (target != null) {
			EObjects.setOrAdd(owner, reference, target);
			callback.onSuccess(resource);
		} else {
			URI ref = URI.createURI(id);

			resource.getResourceSet().getEObject(ref, new Callback<EObject>() {
				@Override
				public void onSuccess(EObject result) {
					if (result != null) {
						EObjects.setOrAdd(owner, reference, result);
					}
					callback.onSuccess(resource);
				}

				@Override
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
			});
		}
	}
}
