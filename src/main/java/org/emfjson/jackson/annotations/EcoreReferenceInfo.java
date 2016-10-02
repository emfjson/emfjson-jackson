package org.emfjson.jackson.annotations;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.databind.deser.EcoreReferenceDeserializer;
import org.emfjson.jackson.databind.deser.ReferenceEntry;
import org.emfjson.jackson.databind.ser.EcoreReferenceSerializer;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;

public class EcoreReferenceInfo {

	private final URIHandler handler;

	protected JsonSerializer<EObject> serializer;
	protected JsonDeserializer<ReferenceEntry> deserializer;

	EcoreReferenceInfo(URIHandler handler) {
		this(null, null, handler);
	}

	public EcoreReferenceInfo(JsonSerializer<EObject> serializer, JsonDeserializer<ReferenceEntry> deserializer, URIHandler handler) {
		this.serializer = serializer;
		this.deserializer = deserializer;
		this.handler = handler;
	}

	public JsonSerializer<EObject> getSerializer() {
		return serializer;
	}

	public JsonDeserializer<ReferenceEntry> getDeserializer() {
		return deserializer;
	}

	public URIHandler getHandler() {
		return handler;
	}

	public static class Base extends EcoreReferenceInfo {
		public static final String PROPERTY = "$ref";
		public static final String TYPE_PROPERTY = "eClass";

		private final String property;
		private final String typeProperty;

		public Base() {
			this(PROPERTY, TYPE_PROPERTY, new BaseURIHandler());
		}

		public Base(URIHandler handler) {
			this(PROPERTY, TYPE_PROPERTY, handler);
		}

		public Base(String property) {
			this(property, TYPE_PROPERTY, null);
		}

		public Base(String property, String typeProperty) {
			this(property, typeProperty, new BaseURIHandler());
		}

		public Base(String property, String typeProperty, URIHandler handler) {
			super(handler);

			this.property = property == null ? PROPERTY: property;
			this.typeProperty = typeProperty == null ? TYPE_PROPERTY: typeProperty;
			this.serializer = new EcoreReferenceSerializer(this, handler);
			this.deserializer = new EcoreReferenceDeserializer(this);
		}

		public String getProperty() {
			return property;
		}

		public String getTypeProperty() {
			return typeProperty;
		}
	}
}
