package org.emfjson.jackson.annotations.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.databind.deser.references.EcoreReferenceDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceEntry;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.databind.ser.references.EcoreReferenceSerializer;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;

public class EcoreReferenceInfoImpl implements EcoreReferenceInfo {

	private final String property;
	private final String typeProperty;
	private final URIHandler handler;
	private final JsonSerializer<Object> serializer;
	private final JsonDeserializer<ReferenceEntry> deserializer;

	public EcoreReferenceInfoImpl() {
		this(null, null, null);
	}

	public EcoreReferenceInfoImpl(URIHandler handler) {
		this(null, null, handler);
	}

	public EcoreReferenceInfoImpl(String property, String typeProperty, URIHandler handler) {
		this.property = property != null ? property: "$ref";
		this.typeProperty = typeProperty != null ? typeProperty: "eClass";
		this.handler = handler != null ? handler: new BaseURIHandler();
		this.serializer = new EcoreReferenceSerializer(this);
		this.deserializer = new EcoreReferenceDeserializer(this);
	}

	@Override
	public String getProperty() {
		return property;
	}

	@Override
	public String getTypeProperty() {
		return typeProperty;
	}

	@Override
	public JsonSerializer<Object> getSerializer() {
		return serializer;
	}

	@Override
	public JsonDeserializer<ReferenceEntry> getDeserializer() {
		return deserializer;
	}

	@Override
	public URIHandler getUriHandler() {
		return handler;
	}

}
