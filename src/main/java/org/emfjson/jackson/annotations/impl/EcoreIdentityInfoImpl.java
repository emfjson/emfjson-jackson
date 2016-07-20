package org.emfjson.jackson.annotations.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.databind.deser.EcoreIdentityDeserializer;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.databind.ser.EcoreIdentitySerializer;

public class EcoreIdentityInfoImpl implements EcoreIdentityInfo {

	private final String property;
	private final JsonSerializer<EObject> serializer;
	private final JsonDeserializer<? extends Object> deserializer;

	public EcoreIdentityInfoImpl() {
		this(null);
	}

	public EcoreIdentityInfoImpl(String property) {
		this.property = property != null ? property: "@id";
		this.serializer = new EcoreIdentitySerializer(this);
		this.deserializer = new EcoreIdentityDeserializer(this);
	}

	@Override
	public String getProperty() {
		return property;
	}

	@Override
	public JsonSerializer<EObject> getSerializer() {
		return serializer;
	}

	@Override
	public JsonDeserializer<? extends Object> getDeserializer() {
		return deserializer;
	}

}
