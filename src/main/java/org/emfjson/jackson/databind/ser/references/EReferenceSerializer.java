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
package org.emfjson.jackson.databind.ser.references;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;
import org.emfjson.jackson.internal.Cache;
import org.emfjson.jackson.internal.ContextUtils;

import java.io.IOException;

public abstract class EReferenceSerializer extends JsonSerializer<EObject> {

	public static final String PROPERTY = "$ref";
	public static final String PROPERTY_TYPE = "eClass";

	protected boolean isExternal(EObject source, EObject target) {
		final Resource sourceResource = ((InternalEObject) source).eInternalResource();
		if (target.eIsProxy()) {
			final URI uri = ((InternalEObject) target).eProxyURI();

			return sourceResource != null &&
					sourceResource.getURI() != null &&
					!sourceResource.getURI().equals(uri.trimFragment());
		}

		final Resource targetResource = ((InternalEObject) target).eInternalResource();

		return sourceResource == null || sourceResource != targetResource;
	}

	protected URI deresolve(URIHandler handler, URI targetURI, Cache cache, EObject source) {
		URI sourceURI = cache.getURI(source);
		if (handler == null) {
			handler = new BaseURIHandler();
		}

		return handler.deresolve(sourceURI, targetURI);
	}

	public abstract void serialize(EObject value, JsonGenerator jg, EObject parent, Cache cache, URIHandler handler) throws IOException;

	@Override
	public void serialize(EObject value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final EObject parent = ContextUtils.get(EObject.class, "parent", serializers);
		final Cache cache = ContextUtils.getCache(serializers);
		final URIHandler handler = ContextUtils.getHandler(serializers);

		serialize(value, jg, parent, cache, handler);
	}

	public String getProperty() {
		return PROPERTY;
	}

	public String getPropertyType() {
		return PROPERTY_TYPE;
	}

}
