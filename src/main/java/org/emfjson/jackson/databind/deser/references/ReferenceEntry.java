package org.emfjson.jackson.databind.deser.references;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.handlers.URIHandler;
import org.emfjson.jackson.utils.EObjects;

public interface ReferenceEntry {

	void resolve(ResourceSet resourceSet, URIHandler handler, ReferenceEntries entries);

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
		public void resolve(ResourceSet resourceSet, URIHandler handler, ReferenceEntries entries) {
			if (id == null)
				return;

			EObject target = entries.get(id);

			if (target == null) {
				Resource resource = owner.eResource();
				target = resource.getEObject(id);

				if (target == null) {

					if (reference.isResolveProxies() && type != null) {
						target = createProxy(resourceSet, URI.createURI(id));
					} else {
						URI baseURI = owner.eResource().getURI().trimFragment();
						URI uri = handler.resolve(baseURI, URI.createURI(id));
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

			if (eClass == null)
				return null;

			EObject object = EcoreUtil.create(eClass);
			((InternalEObject) object).eSetProxyURI(uri);

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
