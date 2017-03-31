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
package org.emfjson.jackson.annotations;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EClass;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;

public class EcoreTypeInfo {

	public static final String PROPERTY = "eClass";

	public static final ValueReader<String, EClass> defaultValueReader = new ValueReader<String, EClass>() {
		@Override
		public EClass readValue(String value, DeserializationContext context) {
			return EMFContext.findEClass(context, value);
		}
	};

	public static final ValueWriter<EClass, String> defaultValueWriter = new ValueWriter<EClass, String>() {
		@Override
		public String writeValue(EClass value, SerializerProvider context) {
			return EMFContext.getURI(context, value).toString();
		}
	};

	private final String property;
	private final ValueReader<String, EClass> valueReader;
	private final ValueWriter<EClass, String> valueWriter;

	public EcoreTypeInfo() {
		this(null, null, null);
	}

	public EcoreTypeInfo(String property) {
		this(property, null, null);
	}

	public EcoreTypeInfo(String property, ValueReader<String, EClass> valueReader) {
		this(property, valueReader, null);
	}

	public EcoreTypeInfo(String property, ValueWriter<EClass, String> valueWriter) {
		this(property, null, valueWriter);
	}

	public EcoreTypeInfo(String property, ValueReader<String, EClass> valueReader, ValueWriter<EClass, String> valueWriter) {
		this.property = property == null ? PROPERTY: property;
		this.valueReader = valueReader == null ? defaultValueReader: valueReader;
		this.valueWriter = valueWriter == null ? defaultValueWriter: valueWriter;
	}

	public String getProperty() {
		return property;
	}

	public ValueReader<String, EClass> getValueReader() {
		return valueReader;
	}

	public ValueWriter<EClass, String> getValueWriter() {
		return valueWriter;
	}
}
