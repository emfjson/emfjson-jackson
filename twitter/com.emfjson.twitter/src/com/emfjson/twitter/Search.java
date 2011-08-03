package com.emfjson.twitter;

import org.eclipse.emf.common.util.URI;

import com.emfjson.model.search.ResultType;

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
