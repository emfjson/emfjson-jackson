package org.emfjson.common;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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

	public void resolve(ResourceSet resourceSet, IDResolver idResolver) {
		final URI ref = idResolver.get(id);
		final EObject target = resourceSet.getEObject(ref, true);

		if (target != null) {
			EObjects.setOrAdd(owner, reference, target);
		}
	}

}
