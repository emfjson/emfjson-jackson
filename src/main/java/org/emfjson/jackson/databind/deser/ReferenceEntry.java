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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.databind.DatabindContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.handlers.URIHandler;
import org.emfjson.jackson.utils.EObjects;

public interface ReferenceEntry {

	void resolve(DatabindContext context, URIHandler handler);

	class Base implements ReferenceEntry {

		private final EObject owner;
		private final EReference reference;
		private final String id;
		private final String type;

		public Base(EObject owner, EReference reference, String id) {
			this(owner, reference, id, null);
		}

		public Base(EObject owner, EReference reference, String id, String type) {
			this.owner = owner;
			this.reference = reference;
			this.id = id;
			this.type = type;
		}

		@Override
		public void resolve(DatabindContext context, URIHandler handler) {
			if (id == null) {
				return;
			}

			ReferenceEntries entries = EMFContext.getEntries(context);
			ResourceSet resourceSet = EMFContext.getResourceSet(context);
			EObject target = entries.get(id);

			if (target == null) {
				Resource resource = EMFContext.getResource(context, owner);
				target = resource.getEObject(id);

				if (target == null) {

					URI baseURI = resource.getURI().trimFragment();
					URI uri = handler.resolve(baseURI, URI.createURI(id));

					if (reference.isResolveProxies() && type != null) {
						target = createProxy(resourceSet, uri);
					} else {
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

		private EObject createProxy(ResourceSet resourceSet, URI uri) {
			EClass eClass;
			try {
				eClass = (EClass) resourceSet.getEObject(URI.createURI(type), true);
			} catch (Exception e) {
				return null;
			}

			if (eClass == null) {
				return null;
			}

			EObject object = EcoreUtil.create(eClass);
			if (object instanceof InternalEObject) {
				((InternalEObject) object).eSetProxyURI(uri);
			}

			return object;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Base that = (Base) o;

			if (!owner.equals(that.owner)) return false;
			if (!reference.equals(that.reference)) return false;
			if (!id.equals(that.id)) return false;
			return type != null ? type.equals(that.type): that.type == null;

		}

		@Override
		public int hashCode() {
			int result = owner.hashCode();
			result = 31 * result + reference.hashCode();
			result = 31 * result + id.hashCode();
			result = 31 * result + (type != null ? type.hashCode(): 0);
			return result;
		}
	}
}
