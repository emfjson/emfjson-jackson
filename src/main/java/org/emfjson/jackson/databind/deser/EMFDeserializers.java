package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.deser.collections.EListDeserializer;
import org.emfjson.jackson.databind.deser.collections.EMapDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceEntries;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.module.EMFModule;

import java.util.Map;

public class EMFDeserializers extends Deserializers.Base {

	private EObjectDeserializer _objectDeserializer;
	private ResourceDeserializer _resourceDeserializer = new ResourceDeserializer();

	private JsonDeserializer<EList<Map.Entry<?, ?>>> _mapDeserializer;
	private JsonDeserializer<EList<EObject>> _listDeserializer;
	private JsonDeserializer<Object> _dataTypeDeserializer;
	private JsonDeserializer<ReferenceEntries.ReferenceEntry> _referenceDeserializer;

	public EMFDeserializers() {
	}

	public void configure(EMFModule module, Map<EMFModule.ModuleFeature, Boolean> features) {
		_objectDeserializer = new EObjectDeserializer();
		_objectDeserializer.setIdDeserializer(module.getIdDeserializer());
		_objectDeserializer.setTypeDeserializer(module.getTypeDeserializer());

		_referenceDeserializer = module.getReferenceDeserializer();
		_mapDeserializer = new EMapDeserializer();
		_listDeserializer = new EListDeserializer(_referenceDeserializer);
		_dataTypeDeserializer = new EDataTypeDeserializer();
	}

	@Override
	public JsonDeserializer<?> findReferenceDeserializer(ReferenceType refType, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer contentTypeDeserializer, JsonDeserializer<?> contentDeserializer) throws JsonMappingException {
		return _referenceDeserializer;
	}

	@Override
	public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		if (type.isTypeOrSubTypeOf(EMap.class)) {
			if (type.getKeyType().isTypeOrSubTypeOf(String.class)) {
				return _mapDeserializer;
			} else {
				return _listDeserializer;
			}
		}

		return super.findMapLikeDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
	}

	@Override
	public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
		if (Enumerator.class.isAssignableFrom(type)) {
			return _dataTypeDeserializer;
		}

		return super.findEnumDeserializer(type, config, beanDesc);
	}

	@Override
	public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		if (EList.class.isAssignableFrom(type.getRawClass())) {
			return _listDeserializer;
		}

		return super.findCollectionDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
	}

	@Override
	public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
		if (Resource.class.isAssignableFrom(type.getRawClass())) {
			return _resourceDeserializer;
		}

		if (ReferenceEntries.ReferenceEntry.class.isAssignableFrom(type.getRawClass())) {
			return _referenceDeserializer;
		}

		if (EcoreType.EntryType.class.isAssignableFrom(type.getRawClass())) {
			return _objectDeserializer;
		}

		if (EcoreType.DataType.class.isAssignableFrom(type.getRawClass())) {
			return _dataTypeDeserializer;
		}

		if (EObject.class.isAssignableFrom(type.getRawClass())) {
			return _objectDeserializer;
		}

		return super.findBeanDeserializer(type, config, beanDesc);
	}
}
