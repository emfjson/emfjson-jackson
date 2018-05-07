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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.databind.DatabindContext;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.handlers.URIHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReferenceEntries {

	private final Collection<ReferenceEntry> entries = new ArrayList<>();
	private final Map<String, EObject> mapOfObjects = new HashMap<>();

	/**
	 * Resolves all reference entries that have been collected during deserialization.
	 *
	 * @param context current deserialization context
	 * @param handler use for resolution of URIs
	 */
	public void resolve(DatabindContext context, URIHandler handler) {
		for (ReferenceEntry entry : entries()) {
			entry.resolve(context, handler);
		}
		mapOfObjects.clear();
	}

	public Collection<ReferenceEntry> entries() {
		return entries;
	}

	public void store(String id, EObject value) {
		mapOfObjects.put(id, value);
	}

	public EObject get(String id) {
		return mapOfObjects.get(id);
	}

}
