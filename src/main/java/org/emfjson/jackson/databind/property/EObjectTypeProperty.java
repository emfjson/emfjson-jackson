package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.io.IOException;

public class EObjectTypeProperty extends EObjectProperty {

	private final JsonSerializer<EClass> serializer;
	private final JsonDeserializer<EClass> deserializer;

	public EObjectTypeProperty(String fieldName, JsonSerializer<EClass> serializer, JsonDeserializer<EClass> deserializer) {
		super(fieldName);
		this.serializer = serializer;
		this.deserializer = deserializer;
	}

	@Override
	public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
		serializer.serialize(bean.eClass(), jg, provider);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return EcoreUtil.create(deserializer.deserialize(jp, ctxt));
	}

	@Override
	public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException {
		// do nothing
	}

}
