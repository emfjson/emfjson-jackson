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
package org.emfjson.jackson.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;

public class JsonUuidResource extends JsonResource {

	public JsonUuidResource(URI uri, ObjectMapper mapper) {
		super(uri, mapper);
	}

	public JsonUuidResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

}
