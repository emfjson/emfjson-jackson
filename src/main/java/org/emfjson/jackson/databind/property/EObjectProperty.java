package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.IOException;

public abstract class EObjectProperty {

	private final String fieldName;

	protected EObjectProperty(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public abstract void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException;

	public abstract EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException;

	public abstract void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException;

}
