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
package com.emfjson.js;

import java.io.IOException;
import java.io.OutputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * @author guillaume
 *
 */
public interface IJsWriter {

	void writeOutputStream(Resource resource, OutputStream outStream);
	
	void writeResource(Resource resource) throws JsonGenerationException, JsonMappingException, IOException;
	
	void writeResource(Resource resource, URI dest) throws JsonGenerationException, JsonMappingException, IOException;
	
	JsonNode writeEObject(EObject object) throws JsonGenerationException, JsonMappingException, IOException;
	
}
