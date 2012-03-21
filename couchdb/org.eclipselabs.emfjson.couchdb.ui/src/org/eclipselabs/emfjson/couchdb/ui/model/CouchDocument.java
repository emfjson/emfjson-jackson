package org.eclipselabs.emfjson.couchdb.ui.model;

import org.codehaus.jackson.JsonNode;

public class CouchDocument {

	private String id;
	private String key;
	private JsonNode revisions;
	private CouchDatabase db;

	public CouchDocument(CouchDatabase db, String id, String key, JsonNode revisions) {
		this.db = db;
		this.id = id;
		this.key = key;
		this.revisions = revisions;
	}
	
	public CouchDatabase getDb() {
		return db;
	}
	
	public String getURL() {
		return db.getURL() + "/" + this.id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getKey() {
		return key;
	}
	
	public JsonNode getRevisions() {
		return revisions;
	}
}
