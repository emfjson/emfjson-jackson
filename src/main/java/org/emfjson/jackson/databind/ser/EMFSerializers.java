package org.emfjson.jackson.databind.ser;

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
import org.emfjson.jackson.databind.deser.references.ReferenceEntries;
import org.emfjson.jackson.databind.ser.collections.EListSerializer;
import org.emfjson.jackson.databind.ser.collections.EMapStringSerializer;
import org.emfjson.jackson.databind.ser.references.EReferenceSerializer;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.module.EMFModule;

import java.util.Map;

import static org.emfjson.jackson.module.EMFModule.ModuleFeature.*;

import java.util.Map;

public class EMFSerializers extends Serializers.Base {

	private EObjectSerializer _objectSerializer;
	private EReferenceSerializer _referenceSerializer;
	private JsonSerializer<?> _listSerializer;

	private ResourceSerializer _resourceSerializer = new ResourceSerializer();
	private JsonSerializer<?> _dataTypeSerializer = new EDataTypeSerializer();
	private JsonSerializer<?> _mapSerializer = new EMapStringSerializer();
	private JsonSerializer<?> _featureMapSerializer = new FeatureMapSerializer();
	private JsonSerializer<?> _enumeratorSerializer = new EnumeratorSerializer();

	public EMFSerializers() {

	}

	public void configure(EMFModule module, Map<EMFModule.ModuleFeature, Boolean> features) {
		_referenceSerializer = module.getReferenceSerializer();

		_listSerializer = new EListSerializer();
		_objectSerializer = new EObjectSerializer();

		_objectSerializer.setIdSerializer(module.getIdSerializer());
		_objectSerializer.setTypeSerializer(module.getTypeSerializer());
		_objectSerializer.setReferenceSerializer(_referenceSerializer);

		_objectSerializer.setShouldWriteId(features.get(OPTION_SERIALIZE_ID));
		_objectSerializer.setShouldWriteType(features.get(OPTION_SERIALIZE_TYPE));
		_objectSerializer.setShouldIncludeDefaults(features.get(OPTION_SERIALIZE_DEFAULT_VALUE));
	}

	@Override
	public JsonSerializer<?> findReferenceSerializer(SerializationConfig config, ReferenceType type, BeanDescription beanDesc, TypeSerializer contentTypeSerializer, JsonSerializer<Object> contentValueSerializer) {
		return _referenceSerializer;
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
			return _enumeratorSerializer;
		}

		if (EcoreType.EntryType.class.isAssignableFrom(type.getRawClass())) {
			return _objectSerializer;
		}

		if (EcoreType.DataType.class.isAssignableFrom(type.getRawClass())) {
			return _dataTypeSerializer;
		}

		if (EcoreType.FeatureMapType.class.isAssignableFrom(type.getRawClass())) {
			return _featureMapSerializer;
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
