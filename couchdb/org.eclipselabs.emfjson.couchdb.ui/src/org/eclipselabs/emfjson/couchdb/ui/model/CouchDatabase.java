/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
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
