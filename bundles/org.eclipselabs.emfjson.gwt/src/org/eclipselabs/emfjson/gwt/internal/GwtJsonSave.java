package org.eclipselabs.emfjson.gwt.internal;

import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.common.JsonSave;

import com.google.gwt.json.client.JSONValue;

public class GwtJsonSave implements JsonSave {
	
	public JSONValue genJson(Resource resource, Map<?,?> options) {
		
		return null;
	}
	
	@Override
	public void write(OutputStream outputStream, Resource resource) {
		// TODO Auto-generated method stub
		
	}

}
