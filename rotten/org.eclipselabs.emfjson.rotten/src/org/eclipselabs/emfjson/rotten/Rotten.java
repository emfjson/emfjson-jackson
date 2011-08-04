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
package org.eclipselabs.emfjson.rotten;

import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author guillaume hillairet
 *
 */
public class Rotten {

	private static final String host = "http://api.rottentomatoes.com/api/public/v1.0/";
	private final String service;
	private String apiKey;
	private String query;
	private Integer pageLimit;
	
	public Rotten(String service) {
		this.service = service;
	}
	
	public Rotten key(Object apiKey) {
		this.apiKey = apiKey.toString();
		return this;
	}
	
	public Rotten query(String query) {
		this.query = query;
		return this;
	}
	
	public Rotten pageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
		return this;
	}
	
	public URI getURI() {
		String uriQuery = "?apikey="+apiKey;
		if (query != null) {
			uriQuery += "&q="+query;
		}
		if (pageLimit != null) {
			uriQuery += "&page_limit="+pageLimit;
		}
		return URI.createURI(host+service+".json"+uriQuery);
	}
}
