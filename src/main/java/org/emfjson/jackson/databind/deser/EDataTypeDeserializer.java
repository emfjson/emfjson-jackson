package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.io.IOException;

import static org.emfjson.jackson.internal.ContextUtils.get;

public class EDataTypeDeserializer extends JsonDeserializer<Object> {

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final EDataType dataType = get(EDataType.class, "datatype", ctxt);

		if (dataType == null) {
			return null;
		} else {
			return EcoreUtil.createFromString(dataType, jp.getText());
		}
	}

}
