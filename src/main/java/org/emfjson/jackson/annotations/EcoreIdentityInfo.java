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
package org.emfjson.jackson.annotations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.resource.JsonResource;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;

public class EcoreIdentityInfo {

	public static final String PROPERTY = "@id";
	private static final ValueReader<Object, String> defaultValueReader = (value, context) -> value.toString();
	private static final ValueWriter<EObject, Object> defaultValueWriter = (object, context) -> {
		Resource resource = EMFContext.getResource(context, object);
		Object id;
		if (resource instanceof JsonResource) {
			id = ((JsonResource) resource).getID(object);
		} else {
			id = EMFContext.getURI(context, object).fragment();
		}
		return id;
	};

	private final String property;
	private final ValueReader<Object, String> valueReader;
	private final ValueWriter<EObject, Object> valueWriter;

	public EcoreIdentityInfo() {
		this(null, null, null);
	}

	public EcoreIdentityInfo(String property) {
		this(property, null, null);
	}

	public EcoreIdentityInfo(String property, ValueReader<Object, String> valueReader) {
		this(property, valueReader, null);
	}

	public EcoreIdentityInfo(String property, ValueWriter<EObject, Object> valueWriter) {
		this(property, null, valueWriter);
	}

	public EcoreIdentityInfo(String property, ValueReader<Object, String> valueReader, ValueWriter<EObject, Object> valueWriter) {
		this.property = property == null ? PROPERTY: property;
		this.valueReader = valueReader == null ? defaultValueReader: valueReader;
		this.valueWriter = valueWriter == null ? defaultValueWriter: valueWriter;
	}

	public String getProperty() {
		return property;
	}

	public ValueReader<Object, String> getValueReader() {
		return valueReader;
	}

	public ValueWriter<EObject, Object> getValueWriter() {
		return valueWriter;
	}
}
