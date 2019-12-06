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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.property.EObjectPropertyMap;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.module.EMFModule;

import java.util.Map;

public class EMFDeserializers extends Deserializers.Base {

	private final ResourceDeserializer _resourceDeserializer;
	private final JsonDeserializer<EList<Map.Entry<?, ?>>> _mapDeserializer;
	private final JsonDeserializer<Object> _dataTypeDeserializer;
	private final JsonDeserializer<ReferenceEntry> _referenceDeserializer;
	private final EObjectPropertyMap.Builder builder;

	public EMFDeserializers(EMFModule module) {
		this.builder = new EObjectPropertyMap.Builder(
				module.getIdentityInfo(),
				module.getTypeInfo(),
				module.getReferenceInfo(),
				module.getFeatures());
		this._resourceDeserializer = new ResourceDeserializer(module.getUriHandler());
		this._referenceDeserializer = module.getReferenceDeserializer();
		this._mapDeserializer = new EMapDeserializer();
		this._dataTypeDeserializer = new EDataTypeDeserializer();
	}

	@Override
	public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType type,
													   DeserializationConfig config,
													   BeanDescription beanDesc,
													   KeyDeserializer keyDeserializer,
													   TypeDeserializer elementTypeDeserializer,
													   JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		if (type.isTypeOrSubTypeOf(EMap.class)) {
			return _mapDeserializer;
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
	public JsonDeserializer<?> findCollectionDeserializer(CollectionType type,
														  DeserializationConfig config,
														  BeanDescription beanDesc,
														  TypeDeserializer elementTypeDeserializer,
														  JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		if (type.getContentType().isTypeOrSubTypeOf(EObject.class)) {
			return new CollectionDeserializer(type, new EObjectDeserializer(builder, type.getContentType().getRawClass()), _referenceDeserializer);
		}
		return super.findCollectionDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
	}

	@Override
	public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
		if (type.isTypeOrSubTypeOf(Resource.class)) {
			return _resourceDeserializer;
		}

		if (type.isReferenceType()) {
			return _referenceDeserializer;
		}

		if (type.isTypeOrSubTypeOf(EcoreType.DataType.class)) {
			return _dataTypeDeserializer;
		}

		if (type.isTypeOrSubTypeOf(EObject.class)) {
			return new EObjectDeserializer(builder, type.getRawClass());
		}

		return super.findBeanDeserializer(type, config, beanDesc);
	}
}
