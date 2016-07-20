package org.emfjson.jackson.annotations.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EClass;
import org.emfjson.jackson.databind.deser.EcoreTypeDeserializer;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.ser.EcoreTypeSerializer;

public class EcoreTypeInfoImpl implements EcoreTypeInfo {

	private final String property;
	private final JsonSerializer<EClass> serializer;
	private final JsonDeserializer<EClass> deserializer;

	public EcoreTypeInfoImpl() {
		this(null);
	}

	public EcoreTypeInfoImpl(String property) {
		this.property = property != null ? property: "eClass";
		this.serializer = new EcoreTypeSerializer(this);
		this.deserializer = new EcoreTypeDeserializer(this);
	}

	@Override
	public String getProperty() {
		return property;
	}

	@Override
	public JsonSerializer<EClass> getSerializer() {
		return serializer;
	}

	@Override
	public JsonDeserializer<EClass> getDeserializer() {
		return deserializer;
	}

}
