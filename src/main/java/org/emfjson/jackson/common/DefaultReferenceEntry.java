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

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.common.EObjects;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.handlers.URIHandler;

public class DefaultReferenceEntry implements ReferenceEntries.ReferenceEntry {

	private final EObject owner;
	private final EReference reference;
	private final String id;

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

			// look for it in local resource first
			target = owner.eResource().getEObject(id);
			
			// then look for in the other resource
			if (target == null) {
				for (Iterator<Resource> iterator = resourceSet.getResources().iterator(); iterator.hasNext() && target == null;) {
					Resource res = (Resource) iterator.next();
					// skip current resource because we already treat it
					
					//TODO
					/*
					
					 URI Hierarchical vs URI$Fragment

					 archive:file://C:\Users\gdufour\AppData\Local\Temp\.metaxserver_test\database\filesystem\root\resource_datas\roots\documents\0\30\1\0--130_1.metax!/root.metax#/

					 archive:file://C:\Users\gdufour\AppData\Local\Temp\.metaxserver_test\database\filesystem\root\resource_datas\roots\documents\0\30\1\0--130_1.metax!/root.metax
					*/
					if(res !=  owner.eResource() && uri.equals(res.getURI()))
						target = res.getContents().get(0);
				}
			}

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
