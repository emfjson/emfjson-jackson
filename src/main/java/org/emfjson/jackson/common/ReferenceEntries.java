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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.handlers.URIHandler;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ReferenceEntries {

	private final Set<ReferenceEntry> entries = new LinkedHashSet<>();
	private final Map<String, EObject> mapOfObjects = new HashMap<>();

	public void resolve(ResourceSet resourceSet, URIHandler handler) {
		for (ReferenceEntry entry: all()) {
			entry.resolve(resourceSet, handler, this);
		}
		mapOfObjects.clear();
	}

	public void add(ReferenceEntries.ReferenceEntry entry) {
		if (entry != null) {
			entries.add(entry);
		}
	}

	public Set<ReferenceEntries.ReferenceEntry> all() {
		return entries;
	}

	public void store(Resource resource, EObject value) {
		String fragment = resource.getURIFragment(value);
		mapOfObjects.put(fragment, value);
	}

	public void store(String id, EObject value) {
		mapOfObjects.put(id, value);
	}

	public EObject get(String id) {
		return mapOfObjects.get(id);
	}

	public interface ReferenceEntry {

		void resolve(ResourceSet resourceSet, URIHandler handler, ReferenceEntries entries);

	}

}
