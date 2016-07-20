package org.emfjson.jackson.annotations;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.eclipse.emf.ecore.EClass;

public interface EcoreTypeInfo {

	String getProperty();

	JsonSerializer<EClass> getSerializer();

	JsonDeserializer<EClass> getDeserializer();

}
