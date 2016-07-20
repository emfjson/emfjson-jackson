package org.emfjson.jackson.annotations;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.databind.deser.references.ReferenceEntry;
import org.emfjson.jackson.handlers.URIHandler;

public interface EcoreReferenceInfo {

	String getProperty();

	String getTypeProperty();

	JsonSerializer<Object> getSerializer();

	JsonDeserializer<ReferenceEntry> getDeserializer();

	URIHandler getUriHandler();

}
