package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.deser.references.ReferenceEntry;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.handlers.URIHandler;

import java.io.IOException;

public class EObjectReferenceProperty extends EObjectProperty {

	private final JsonDeserializer<ReferenceEntry> deserializer;
	private final URIHandler uriHandler;

	public EObjectReferenceProperty(EcoreReferenceInfo referenceInfo) {
		super(referenceInfo.getProperty());

		this.deserializer = referenceInfo.getDeserializer();
		this.uriHandler = referenceInfo.getUriHandler();
	}

	@Override
	public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return null;
	}

	@Override
	public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException {
		String value = jp.nextTextValue();
		if (value != null) {
			((InternalEObject) current).eSetProxyURI(URI.createURI(value));
		}
	}
}
