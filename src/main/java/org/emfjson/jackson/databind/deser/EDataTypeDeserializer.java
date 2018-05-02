/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.databind.EMFContext;

import java.io.IOException;

import static org.eclipse.emf.ecore.EcorePackage.Literals.EJAVA_CLASS;
import static org.eclipse.emf.ecore.EcorePackage.Literals.EJAVA_OBJECT;

public class EDataTypeDeserializer extends JsonDeserializer<Object> {

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final EDataType dataType = EMFContext.getDataType(ctxt);

		if (dataType == null) {
			return null;
		} else {
			Class<?> type = dataType.getInstanceClass();

			if (type == null || dataType instanceof EEnum || EJAVA_CLASS.equals(dataType) || EJAVA_OBJECT.equals(dataType)) {
				return EcoreUtil.createFromString(dataType, jp.getText());
			} else {
				return ctxt.readValue(jp, type);
			}
		}
	}

}
