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

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.deser.references.ReferenceEntry;
import org.emfjson.jackson.databind.property.EObjectPropertyMap;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.module.EMFModule;

public class EMFSerializers extends Serializers.Base {

	private final EObjectPropertyMap.Builder propertiesBuilder;
	private final JsonSerializer<Object> _referenceSerializer;
	private final JsonSerializer<Resource> _resourceSerializer = new ResourceSerializer();
	private final JsonSerializer<?> _dataTypeSerializer = new EDataTypeSerializer();
	private final JsonSerializer<?> _mapSerializer = new EMapStringSerializer();
	private final JsonSerializer<?> _enumeratorSerializer = new EnumeratorSerializer();

	public EMFSerializers(EMFModule module) {
		this.propertiesBuilder = EObjectPropertyMap.Builder.from(module, module.getFeatures());
		this._referenceSerializer = module.getReferenceInfo().getSerializer();
	}

	@Override
	public JsonSerializer<?> findMapLikeSerializer(SerializationConfig config, MapLikeType type, BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
		if (EMap.class.isAssignableFrom(type.getRawClass())) {
			if (type.getKeyType().isTypeOrSubTypeOf(String.class)) {
				return _mapSerializer;
			}
		}

		return super.findMapLikeSerializer(config, type, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
	}

	@Override
	public JsonSerializer<?> findReferenceSerializer(SerializationConfig config, ReferenceType type, BeanDescription beanDesc, TypeSerializer contentTypeSerializer, JsonSerializer<Object> contentValueSerializer) {
		return _referenceSerializer;
	}

	@Override
	public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
		if (type.getContentType().isReferenceType()) {
			return new CollectionSerializer(type.getContentType(), false, null, _referenceSerializer);
		}
		return super.findCollectionSerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
	}

	@Override
	public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) {
		if (Resource.class.isAssignableFrom(type.getRawClass())) {
			return _resourceSerializer;
		}

		if (Enumerator.class.isAssignableFrom(type.getRawClass())) {
			return _enumeratorSerializer;
		}

		if (type.isReferenceType()) {
			return _referenceSerializer;
		}

		if (EcoreType.EntryType.class.isAssignableFrom(type.getRawClass())) {
			return null;
		}

		if (EcoreType.DataType.class.isAssignableFrom(type.getRawClass())) {
			return _dataTypeSerializer;
		}

		if (ReferenceEntry.class.isAssignableFrom(type.getRawClass())) {
			return _referenceSerializer;
		}

		if (EObject.class.isAssignableFrom(type.getRawClass())) {
			if (type instanceof EcoreType) {
				return new EObjectSerializer(propertiesBuilder, propertiesBuilder.construct((EcoreType) type), _referenceSerializer);
			} else {
				return new EObjectSerializer(propertiesBuilder, null, _referenceSerializer);
			}
		}

		return super.findSerializer(config, type, beanDesc);
	}

}
