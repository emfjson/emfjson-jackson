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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.databind.ser.references.EReferenceSerializer;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.internal.Cache;
import org.emfjson.jackson.internal.ContextUtils;
import org.emfjson.jackson.internal.EObjects;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.emfjson.jackson.annotations.JsonAnnotations.shouldIgnore;
import static org.emfjson.jackson.internal.EObjects.isCandidate;

public class EObjectSerializer extends JsonSerializer<EObject> {

	private IdSerializer idSerializer;
	private ETypeSerializer typeSerializer;
	private EReferenceSerializer refSerializer;

	private boolean writeType;
	private boolean writeId;
	private boolean includeOptional;

	public EObjectSerializer() {

	}

	public void setIdSerializer(IdSerializer idSerializer) {
		this.idSerializer = idSerializer;
	}

	public void setTypeSerializer(ETypeSerializer typeSerializer) {
		this.typeSerializer = typeSerializer;
	}

	public void setReferenceSerializer(EReferenceSerializer refSerializer) {
		this.refSerializer = refSerializer;
	}

	public void setShouldWriteType(boolean value) {
		this.writeType = value;
	}

	public void setShouldWriteId(boolean value) {
		this.writeId = value;
	}

	public void setShouldIncludeDefaults(boolean value) {
		this.includeOptional = value;
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

		final EObject parent = ContextUtils.get(EObject.class, "parent", provider);
		if (parent != null && (object.eIsProxy() || EObjects.isContainmentProxy(parent, object))) {
			refSerializer.serialize(object, jg, provider);
			return;
		}

		final Cache cache = ContextUtils.getCache(provider);
		final EcoreType typeFactory = ContextUtils.getEcoreType(provider);

		jg.writeStartObject();

		if (writeType) {
			typeSerializer.serialize(object.eClass(), jg, provider);
		}

		if (writeId) {
			idSerializer.serialize(object, jg, provider);
		}

		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (!shouldIgnore(feature) && isCandidate(object, feature, includeOptional)) {
				final String field = cache.getKey(feature);
				final JavaType type = typeFactory.construct(object, feature);

				if (type != null) {
					JsonSerializer<Object> serializer = provider.findValueSerializer(type);

					if (serializer != null) {
						provider.setAttribute("parent", object);
						provider.setAttribute("feature", feature);

						if (!FeatureMapUtil.isFeatureMap(feature)) {
							jg.writeFieldName(field);
						}

						serializer.serialize(object.eGet(feature, false), jg, provider);
					}
				}
			}
		}

		for (EOperation operation : object.eClass().getEAllOperations()) {
			EAnnotation annotation = operation.getEAnnotation("JsonProperty");
			if (annotation != null && operation.getEParameters().isEmpty()) {
				String field = operation.getName();
				Object value;
				try {
					value = object.eInvoke(operation, null);
				} catch (InvocationTargetException e) {
					// invocation failed
					value = null;
				}

				if (value != null) {
					jg.writeObjectField(field, value);
				}
			}
		}

		jg.writeEndObject();
	}

//	protected boolean shouldSaveType(EObject object) {
//		if (features.get(OPTION_SERIALIZE_TYPE)) {
//			return true;
//		} else {
//			return false;
//		}

//		final EReference feature = object.eContainmentFeature();
//		if (feature == null) {
//			return true;
//		}
//
//		final EClass type = object.eClass();
//		final EClass featureType = feature.getEReferenceType();
//
//		return type != featureType &&
//				(type.getEAllAttributes().size() > featureType.getEAllAttributes().size() ||
//						featureType.isAbstract() ||
//						feature.getEGenericType().getETypeParameter() != null);
//	}

}
