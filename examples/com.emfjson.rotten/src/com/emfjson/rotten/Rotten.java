package com.emfjson.rotten;

import org.eclipse.emf.common.util.URI;

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
