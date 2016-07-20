package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.resource.JsonResource;

import java.io.IOException;

public class EObjectIdentityProperty extends EObjectProperty {

	private final JsonSerializer<EObject> serializer;
	private final JsonDeserializer<?> deserializer;

	public EObjectIdentityProperty(String fieldName, JsonSerializer<EObject> serializer, JsonDeserializer<?> deserializer) {
		super(fieldName);
		this.serializer = serializer;
		this.deserializer = deserializer;
	}

	public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
		serializer.serialize(bean, jg, provider);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return null;
	}

	@Override
	public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException {
		final Object id = deserializer.deserialize(jp, ctxt);
		if (resource instanceof JsonResource && id != null) {
			((JsonResource) resource).setID(current, id.toString());
		}
	}

}
