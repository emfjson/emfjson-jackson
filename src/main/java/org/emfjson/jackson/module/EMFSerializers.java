package org.emfjson.jackson.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.Keywords;
import org.emfjson.jackson.common.ReferenceEntries;
import org.emfjson.jackson.databind.ser.*;
import org.emfjson.jackson.databind.ser.collections.EListSerializer;
import org.emfjson.jackson.databind.ser.collections.EMapStringSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.emfjson.jackson.databind.type.EcoreType;

import java.util.Map;

public class EMFSerializers extends Serializers.Base {

	private final JsonSerializer<? extends Resource> _resourceSerializer = new ResourceSerializer();
	private final JsonSerializer<? extends EObject> _objectSerializer;

	private final JsonSerializer<?> _dataTypeSerializer = new EDataTypeSerializer();
	private final JsonSerializer<?> _mapSerializer = new EMapStringSerializer();
	private final JsonSerializer<?> _listSerializer;
	private final ReferenceSerializer _referenceSerializer;

	public EMFSerializers(Keywords keywords, Map<EMFModule.FeatureKind, Boolean> features) {
		_referenceSerializer = new ReferenceSerializer(keywords, features);
		_listSerializer = new EListSerializer(_referenceSerializer);
		_objectSerializer = new EObjectSerializer(
				new IdSerializer(keywords),
				new org.emfjson.jackson.databind.ser.TypeSerializer(keywords),
				_referenceSerializer,
				features);
	}

	@Override
	public JsonSerializer<?> findReferenceSerializer(SerializationConfig config, ReferenceType type, BeanDescription beanDesc, TypeSerializer contentTypeSerializer, JsonSerializer<Object> contentValueSerializer) {
		return super.findReferenceSerializer(config, type, beanDesc, contentTypeSerializer, contentValueSerializer);
	}

	@Override
	public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
		if (EList.class.isAssignableFrom(type.getRawClass())) {
			return _listSerializer;
		}

		return super.findCollectionSerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
	}

	@Override
	public JsonSerializer<?> findMapLikeSerializer(SerializationConfig config, MapLikeType type, BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
		if (EMap.class.isAssignableFrom(type.getRawClass())) {
			if (type.getKeyType().isTypeOrSubTypeOf(String.class)) {
				return _mapSerializer;
			} else {
				return _listSerializer;
			}
		}

		return super.findMapLikeSerializer(config, type, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
	}

	@Override
	public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) {
		if (Resource.class.isAssignableFrom(type.getRawClass())) {
			return _resourceSerializer;
		}

		if (Enumerator.class.isAssignableFrom(type.getRawClass())) {
			return new EnumeratorSerializer();
		}

		if (EcoreType.EntryType.class.isAssignableFrom(type.getRawClass())) {
			return _objectSerializer;
		}

		if (EcoreType.DataType.class.isAssignableFrom(type.getRawClass())) {
			return _dataTypeSerializer;
		}

		if (EcoreType.FeatureMapType.class.isAssignableFrom(type.getRawClass())) {
			return new FeatureMapSerializer();
		}

		if (ReferenceEntries.ReferenceEntry.class.isAssignableFrom(type.getRawClass())) {
			return _referenceSerializer;
		}

		if (EObject.class.isAssignableFrom(type.getRawClass())) {
			return _objectSerializer;
		}

		return super.findSerializer(config, type, beanDesc);
	}

}
