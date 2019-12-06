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

package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;

import java.io.IOException;

import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_TYPE;

public class EObjectTypeProperty extends EObjectProperty {

	private final JsonSerializer<Object> serializer = new StringSerializer();
	private final JsonDeserializer<String> deserializer = StringDeserializer.instance;

	private final ValueReader<String, EClass> valueReader;
	private final ValueWriter<EClass, String> valueWriter;
	private final int features;

	public EObjectTypeProperty(EcoreTypeInfo info, int features) {
		super(info.getProperty());

		this.valueReader = info.getValueReader();
		this.valueWriter = info.getValueWriter();
		this.features = features;
	}

	@Override
	public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (!OPTION_SERIALIZE_TYPE.enabledIn(features)) {
			return;
		}

		EClass objectType = bean.eClass();
		EReference containment = bean.eContainmentFeature();

		if (isRoot(bean) || shouldSaveType(objectType, containment.getEReferenceType(), containment)) {
			String value = valueWriter.writeValue(bean.eClass(), provider);

			jg.writeFieldName(getFieldName());
			serializer.serialize(value, jg, provider);
		}
	}

	private boolean isRoot(EObject bean) {
		EObject container = bean.eContainer();
		Resource.Internal resource = ((InternalEObject) bean).eDirectResource();

		return container == null || resource != null && resource != ((InternalEObject) container).eDirectResource();
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {
			jp.nextToken();
		}

		return create(deserializer.deserialize(jp, ctxt), ctxt);
	}

	public EObject create(String value, DeserializationContext ctxt) {
		EClass eClass = valueReader.readValue(value, ctxt);

		return eClass != null ? EcoreUtil.create(eClass): null;
	}

	@Override
	public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException {
		// do nothing
	}

	private boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature) {
		return objectType != featureType && objectType != EcorePackage.Literals.EOBJECT;
	}
}
