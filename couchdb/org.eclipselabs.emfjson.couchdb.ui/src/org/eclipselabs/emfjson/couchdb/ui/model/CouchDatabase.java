package org.eclipselabs.emfjson.couchdb.ui.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;

public class CouchDatabase {
	
	private String name;
	private CouchDB couchDB;

	public CouchDatabase(CouchDB couchDB, String name) {
		this.couchDB = couchDB;
		this.name  = name;
	}
	
	public String getURL() {
		return this.couchDB.getURL() + this.name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<CouchDocument> getDocuments() {
		List<CouchDocument> documents = new ArrayList<CouchDocument>();
		JsonNode rows = org.eclipselabs.emfjson.couchdb.internal.CouchDB.getListOfDocuments(couchDB.getURL() + "/" + name);
		if (rows != null && rows.isArray()) {
			for (Iterator<JsonNode> it = rows.getElements(); it.hasNext();){
				JsonNode node = it.next();
				documents.add(new CouchDocument(this,
						node.get("id").getTextValue(), 
						node.get("key").getTextValue(), 
						node.get("revisions")));
			}
		}
		
		return documents;
	}
}
