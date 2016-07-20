package org.emfjson.jackson.annotations;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface EcoreIdentityInfo {

	String getProperty();

	JsonSerializer<EObject> getSerializer();

	JsonDeserializer<? extends Object> getDeserializer();

}
