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
package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.common.ContextUtils;
import org.emfjson.jackson.common.EObjects;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.module.EMFModule;

import java.io.IOException;
import java.util.Map;

import static org.emfjson.jackson.module.EMFModule.FeatureKind.*;

public class EObjectSerializer extends JsonSerializer<EObject> {

	private final IdSerializer idSerializer;
	private final TypeSerializer typeSerializer;
	private final ReferenceSerializer refSerializer;
	private final Map<EMFModule.FeatureKind, Boolean> features;

	public EObjectSerializer(IdSerializer idSerializer, TypeSerializer typeSerializer, ReferenceSerializer refSerializer, Map<EMFModule.FeatureKind, Boolean> features) {
		this.idSerializer = idSerializer;
		this.typeSerializer = typeSerializer;
		this.refSerializer = refSerializer;
		this.features = features;
	}

	@Override
	public Class<EObject> handledType() {
		return EObject.class;
	}

	@Override
	public void serialize(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (object == null) {
			jg.writeNull();
			return;
		}

		Cache cache = ContextUtils.get(Cache.class, "cache", provider);
		if (cache == null) {
			provider.setAttribute("cache", cache = new Cache());
		}

		{
			final EObject parent = ContextUtils.get(EObject.class, "parent", provider);
			if (parent != null && (object.eIsProxy() || EObjects.isContainmentProxy(parent, object))) {
				refSerializer.serialize(object, jg, provider);
				return;
			}
		}

		jg.writeStartObject();

		writeType(object, jg, provider);
		writeId(object, jg, provider);

		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (EObjects.isCandidate(object, feature, features.get(OPTION_SERIALIZE_DEFAULT_VALUE))) {
				final String field = cache.getKey(feature);
				final JavaType type = EcoreType.construct(object, feature);

				if (type != null) {
					JsonSerializer<Object> serializer = provider.findValueSerializer(type);

					if (serializer != null) {

						if (!FeatureMapUtil.isFeatureMap(feature)) {
							jg.writeFieldName(field);
						}

						provider.setAttribute("parent", object);
						provider.setAttribute("feature", feature);

						serializer.serialize(object.eGet(feature, false), jg, provider);
					}
				}
			}
		}
		jg.writeEndObject();
	}

	protected void writeId(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (features.get(OPTION_SERIALIZE_ID)) {
			idSerializer.serialize(object, jg, provider);
		}
	}

	protected void writeType(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		if (shouldSaveType(object)) {
			typeSerializer.serialize(object.eClass(), jg, provider);
		}
	}

	protected boolean shouldSaveType(EObject object) {
		if (features.get(OPTION_SERIALIZE_TYPE)) {
			return true;
		}

		final EReference feature = object.eContainmentFeature();
		if (feature == null) {
			return true;
		}

		final EClass type = object.eClass();
		final EClass featureType = feature.getEReferenceType();

		return type != featureType &&
				(type.getEAllAttributes().size() > featureType.getEAllAttributes().size() ||
						featureType.isAbstract() ||
						feature.getEGenericType().getETypeParameter() != null);
	}

}
