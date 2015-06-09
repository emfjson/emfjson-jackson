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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.emfjson.jackson.JacksonOptions;
import org.emfjson.handlers.URIHandler;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class ReferenceAsValueSerializer extends AbstractReferenceSerializer {

	@Override
	public void serialize(EObject source, EObject target, JsonGenerator jg, JacksonOptions options) throws IOException {
		URIHandler handler = options.uriHandler;

		if (target == null) {
			jg.writeNull();
		} else {
			URI targetURI = EcoreUtil.getURI(target);

			if (isExternal(source, target)) {
				targetURI = deresolve(handler, targetURI, source);

				if (targetURI == null) {
					jg.writeNull();
				} else {
					jg.writeString(targetURI.toString());
				}
			} else {
				jg.writeString(targetURI.fragment());
			}
		}
	}

}
