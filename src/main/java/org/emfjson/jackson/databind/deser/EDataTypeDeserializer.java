/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
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
