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
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.common.Cache;
import org.emfjson.handlers.URIHandler;
import org.emfjson.jackson.handlers.BaseURIHandler;

public abstract class AbstractReferenceSerializer implements ReferenceSerializer {

	public boolean isExternal(EObject source, EObject target) {
		Resource sourceResource = source.eResource();
		Resource targetResource = target.eResource();

		return sourceResource == null || !sourceResource.equals(targetResource);
	}

	protected URI deresolve(URIHandler handler, URI targetURI, Cache cache, EObject source) {
		URI sourceURI = cache.getURI(source);
		if (handler == null) {
			handler = new BaseURIHandler();
		}

		return handler.deresolve(sourceURI, targetURI);
	}

}
