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
package com.emfjson.internal;

import static com.emfjson.internal.JSONEcoreUtil.getElementName;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * 
 * @author guillaume
 *
 */
public class JSONStreamWriter implements JsonWriter {

	final JsonFactory factory;
	JsonGenerator generator;

	public JSONStreamWriter() {
		factory = new JsonFactory();
		try {
			generator = factory.createJsonGenerator(new File("user.json"), JsonEncoding.UTF8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeResource(Resource resource)
			throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void writeResource(Resource resource, URI dest)
			throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void writeOutputStream(Resource resource, OutputStream outStream) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public JsonNode writeEObject(EObject object) 
			throws JsonGenerationException, IOException {

		generator.writeStartObject();

		try {
			writeEObjectAttributes(object, generator);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		}

		try {
			writeEObjectContainment(object, generator);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		}

		generator.writeEndObject();
		generator.close();
		
		return null;
	}

	protected void writeEObjectAttributes(EObject object, JsonGenerator generator) 
			throws JsonGenerationException, IOException {

		for (EAttribute attribute: object.eClass().getEAllAttributes()) {
			if (!attribute.isMany()) {
				Object value = object.eGet(attribute);
				if (value != null) {
					String attrName = attribute.getName();
					System.out.println("writing "+attrName+" "+value);
					try {
						generator.writeStringField(attribute.getName(), value.toString());
					} catch (JsonGenerationException e) {
						e.printStackTrace();
						System.out.println("fail "+attrName);
					}
				}
			}
		}
	}

	protected void writeEObjectContainment(EObject object, JsonGenerator generator) 
			throws JsonGenerationException, IOException {

		for (EReference reference: object.eClass().getEAllContainments()) {
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> values = (EList<EObject>) object.eGet(reference);
				if (values != null && !values.isEmpty()) {
					for (EObject obj: values) {
						generator.writeArrayFieldStart(getElementName(reference));

						try {
							writeEObjectAttributes(obj, generator);
						} catch (JsonGenerationException e) {
							e.printStackTrace();
						}

						generator.writeEndArray();
					}
				}
			}
		}
	}
}
