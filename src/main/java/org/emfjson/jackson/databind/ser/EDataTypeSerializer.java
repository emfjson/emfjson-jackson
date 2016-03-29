package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.common.ContextUtils;

import java.io.IOException;

public class EDataTypeSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		EAttribute feature = ContextUtils.get(EAttribute.class, "feature", serializers);

		if (feature != null) {
			gen.writeString(EcoreUtil.convertToString(feature.getEAttributeType(), value));
		} else {
			gen.writeNull();
		}
	}

}
