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
package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.handlers.URIHandler;

import java.io.IOException;

public class EcoreReferenceSerializer extends JsonSerializer<EObject> {

	private final EcoreReferenceInfo info;
	private final EcoreTypeInfo typeInfo;
	private final URIHandler handler;

	public EcoreReferenceSerializer(EcoreReferenceInfo info, EcoreTypeInfo typeInfo) {
		this.info = info;
		this.typeInfo = typeInfo;
		this.handler = info.getHandler();
	}

	@Override
	public void serialize(EObject value, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final EObject parent = EMFContext.getParent(serializers);
		final String href = getHRef(serializers, parent, value);

		jg.writeStartObject();
		jg.writeStringField(typeInfo.getProperty(), typeInfo.getValueWriter().writeValue(value.eClass(), serializers));
		if (href == null) {
			jg.writeNullField(info.getProperty());
		} else {
			jg.writeStringField(info.getProperty(), href);
		}
		jg.writeEndObject();
	}

	private boolean isExternal(DatabindContext ctxt, EObject source, EObject target) {
		Resource sourceResource = EMFContext.getResource(ctxt, source);

		if (target.eIsProxy() && target instanceof InternalEObject) {
			URI uri = ((InternalEObject) target).eProxyURI();

			return sourceResource != null
					&& sourceResource.getURI() != null
					&& !sourceResource.getURI().equals(uri.trimFragment());
		}

		return sourceResource == null || sourceResource != EMFContext.getResource(ctxt, target);
	}

	private String getHRef(SerializerProvider ctxt, EObject parent, EObject value) {
		if (isExternal(ctxt, parent, value)) {

			URI targetURI = EMFContext.getURI(ctxt, value);
			URI sourceURI = EMFContext.getURI(ctxt, parent);
			URI deresolved = handler != null ? handler.deresolve(sourceURI, targetURI): targetURI;

			return deresolved == null ? null: deresolved.toString();

		} else {

			Resource resource = EMFContext.getResource(ctxt, value);
			if (resource != null) {
				return resource.getURIFragment(value);
			}

			return null;
		}
	}
}
