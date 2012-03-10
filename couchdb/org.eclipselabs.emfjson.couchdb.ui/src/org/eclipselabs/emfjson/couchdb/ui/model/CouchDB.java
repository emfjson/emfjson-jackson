package org.eclipselabs.emfjson.couchdb.ui.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;

public class CouchDB {
	
	private String url;
	private ResourceSet resourceSet;
	
	public CouchDB(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		this.url = "http://127.0.0.1:5984/";
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public String getURL() {
		return url;
	}
	
	public CouchDB(String url) {
		this.url = url;
	}
	
	public List<CouchDatabase> getDataBases() {
		List<CouchDatabase> databases = new ArrayList<CouchDatabase>();	
		String[] dbs = org.eclipselabs.emfjson.couchdb.internal.CouchDB.getListOfDatabases(getURL());
		for (String db: dbs){
			databases.add(new CouchDatabase(this, db));
		}
		return databases;
	}
}
