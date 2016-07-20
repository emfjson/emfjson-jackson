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
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.utils.Cache;

import java.io.IOException;

public class EcoreReferenceSerializer extends JsonSerializer<Object> {

	private final EcoreReferenceInfo info;

	public EcoreReferenceSerializer(EcoreReferenceInfo info) {
		this.info = info;
	}

	@Override
	public void serialize(Object value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final EObject parent = EMFContext.getParent(serializers);
		final Cache cache = EMFContext.getCache(serializers);

		if (value == null) {
			jg.writeNull();
		} else {
			String href = getHRef(cache, parent, (EObject) value);

			jg.writeStartObject();
			jg.writeStringField(info.getTypeProperty(), cache.getURI(((EObject) value).eClass()).toString());
			if (href == null) {
				jg.writeNullField(info.getProperty());
			} else {
				jg.writeStringField(info.getProperty(), href);
			}
			jg.writeEndObject();
		}
	}

	protected boolean isExternal(EObject source, EObject target) {
		final Resource sourceResource = ((InternalEObject) source).eInternalResource();
		if (target.eIsProxy()) {
			final URI uri = ((InternalEObject) target).eProxyURI();

			return sourceResource != null &&
					sourceResource.getURI() != null &&
					!sourceResource.getURI().equals(uri.trimFragment());
		}

		return sourceResource == null || sourceResource != ((InternalEObject) target).eInternalResource();
	}

	protected String getHRef(Cache cache, EObject parent, EObject value) {
		if (isExternal(parent, value)) {
			final URI targetURI = cache.getURI(value);
			final URI sourceURI = cache.getURI(parent);
			final URI deresolved = info.getUriHandler().deresolve(sourceURI, targetURI);

			return deresolved == null ? null: deresolved.toString();
		} else {
			return value.eResource().getURIFragment(value);
		}
	}
}
