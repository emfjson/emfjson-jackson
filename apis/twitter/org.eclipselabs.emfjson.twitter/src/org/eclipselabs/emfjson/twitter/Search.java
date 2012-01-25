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
import org.eclipselabs.emfjson.search.ResultType;

public class Search {

	private static final String host = "http://search.twitter.com/search.json";
	private String query;
	private int count = 0;
	private ResultType resultType;

	public Search(String query) {
		this.query = query;
	}
	
	public Search geoCode(String latitude, String longitude, String radius) {
		// TODO
		return this;
	}
	
	public Search lang(String lang) {
		// TODO
		return this;		
	}

	public Search page(int page) {
		// TODO
		return this;		
	}
	
	public Search resultType(ResultType type) {
		this.resultType = type;
		return this;
	}

	public Search count(int count) {
		this.count = count;
		return this;
	}

	public URI getURI() {
		String uriQuery = host;
		if (query != null) {
			uriQuery += "?q="+query.replaceAll(" ", "%20");
			if (count != 0) {
				uriQuery += "&count="+count;
			}
			if (resultType != null) {
				uriQuery += "&result_type"+resultType.getName();
			}
		}
		return URI.createURI(uriQuery);
	}
}
