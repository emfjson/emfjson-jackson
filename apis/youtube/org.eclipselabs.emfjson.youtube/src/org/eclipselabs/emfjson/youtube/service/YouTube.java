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
package org.eclipselabs.emfjson.youtube.service;

import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author guillaume
 *
 */
public class YouTube {

	private static final String host = "https://gdata.youtube.com/feeds/api/videos";
	
	private final String query;

	private int maxResults = 0;
	
	public YouTube(String query) {
		this.query = query;
	}
	
	public YouTube maxResults(int maxResults) {
		this.maxResults = maxResults;
		return this;
	}
	
	public URI getURI() {
		String uriQuery = host;
		if (query != null) {
			uriQuery += "?q="+query.replaceAll(" ", "%20");
			if (maxResults != 0) {
				uriQuery += "&max_results="+maxResults;
			}
			uriQuery += "&v=2&alt=jsonc";
		}
		return URI.createURI(uriQuery);
	}
}
