package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.internal.ContextUtils;

import java.io.IOException;

public class EDataTypeDeserializer extends JsonDeserializer<Object> {

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final EDataType dataType = ContextUtils.get(EDataType.class, "datatype", ctxt);

		System.out.println(dataType);
		if (dataType instanceof EEnum) {
			System.out.println(((EEnum) dataType).getEEnumLiteral("E2"));
			System.out.println("size " + ((EEnum) dataType).getELiterals().size());
			for (EEnumLiteral literal : ((EEnum) dataType).getELiterals()) {
				System.out.println(literal.getName());
				System.out.println(literal.getLiteral());
			}

		}
		if (dataType == null) {
			return null;
		} else {
			String text = jp.getText();
			System.out.println(text);
			return EcoreUtil.createFromString(dataType, text);
		}
	}

}
