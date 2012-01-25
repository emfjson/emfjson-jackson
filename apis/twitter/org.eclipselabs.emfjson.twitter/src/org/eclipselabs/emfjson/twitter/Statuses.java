/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.twitter;

import org.eclipse.emf.common.util.URI;

public class Statuses {
	
	private static final String host = "http://api.twitter.com/1/statuses/show.json";
	private final String id;
	private boolean includeEntities = false;
	
	public Statuses(String id) {
		this.id = id;
	}
	
	public Statuses includeEntities() {
		this.includeEntities = true;
		return this;
	}
	
	public URI getURI() {
		String uriQuery = host;
		if (id != null) {
			uriQuery += "?id="+id;
			if (includeEntities) {
				uriQuery+="&include_entities=true";
			}
		}
		return URI.createURI(uriQuery);
	}
	
}
