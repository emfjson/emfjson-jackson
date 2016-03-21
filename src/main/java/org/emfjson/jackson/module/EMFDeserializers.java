package org.emfjson.jackson.module;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.deser.*;
import org.emfjson.jackson.databind.deser.collections.EListDeserializer;
import org.emfjson.jackson.databind.type.EcoreType;

import java.util.Map;

public class EMFDeserializers extends Deserializers.Base {

	private final JsonDeserializer<? extends EObject> _objectDeserializer;
	private final JsonDeserializer<? extends Resource> _resourceDeserializer;
	private final EMapDeserializer _mapDeserializer;
	private final EListDeserializer _listDeserializer;

	public EMFDeserializers(ResourceSet resourceSet, JacksonOptions options) {
		_resourceDeserializer = new ResourceDeserializer(resourceSet, options);
		_objectDeserializer = new EObjectDeserializer(resourceSet, options);
		_mapDeserializer = new EMapDeserializer();
		_listDeserializer = new EListDeserializer();
	}

	@Override
	public JsonDeserializer<?> findMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		return super.findMapDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
	}

	@Override
	public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
		if (Enumerator.class.isAssignableFrom(type)) {
			return new EDataTypeDeserializer();
		}

		return super.findEnumDeserializer(type, config, beanDesc);
	}

	@Override
	public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		if (Map.Entry.class.isAssignableFrom(type.getContentType().getRawClass())) {
			return _mapDeserializer;
		}

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
			return new ReferenceDeserializer2();
		}

		if (EcoreType.DataType.class.isAssignableFrom(type.getRawClass())) {
			return new EDataTypeDeserializer();
		}

		if (EObject.class.isAssignableFrom(type.getRawClass())) {
			return _objectDeserializer;
		}

		return super.findBeanDeserializer(type, config, beanDesc);
	}
}
