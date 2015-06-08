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
package org.emfjson.gwt.map;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import org.emfjson.common.Cache;
import org.emfjson.common.Options;

import java.util.Collection;

public class ReferenceSerializer {

	private final Options options;
	private final Cache cache;
	private final Resource resource;

	public ReferenceSerializer(Cache cache, Resource resource, Options options) {
		this.cache = cache;
		this.resource = resource;
		this.options = options;
	}

	public void serialize(JSONObject parent, String key, EReference reference, Object value) {
		if (reference.isMany()) {
			serializeMany(parent, key, (Collection<?>) value);
		} else {
			serializeOne(parent, key, (EObject) value);
		}
	}

	public void serializeMany(JSONObject parent, String key, Collection<?> values) {
		if (values == null || values.isEmpty()) return;

		JSONArray arrayNode = new JSONArray();
		parent.put(key, arrayNode);

		int i = 0;
		for (Object current : values) {
			if (current instanceof EObject) {
				EObject value = (EObject) current;
				arrayNode.set(i, createObjectRef(new JSONObject(), value));
				i++;
			}
		}
	}

	public void serializeOne(JSONObject parent, String key, EObject value) {
		if (value != null) {
			parent.put(key, createObjectRef(new JSONObject(), value));
		}
	}

	public JSONObject createObjectRef(JSONObject node, EObject object) {
		final URI uri = cache.getURI(object);
		String ref;
		if (isExternal(object)) {
			ref = uri.toString();
		} else {
			ref = uri.fragment();
		}

		final String type = cache.getType(object.eClass());
		if (options.serializeRefTypes) {
			node.put(options.typeField, new JSONString(type));
		}
		node.put(options.refField, new JSONString(ref));
		return node;
	}

	public boolean isExternal(EObject target) {
		return resource != null && target != null && !resource.equals(target.eResource());
	}

}
