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

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.*;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.common.Cache;
import org.emfjson.common.EObjects;
import org.emfjson.jackson.JacksonOptions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.emfjson.common.EObjects.featureMaps;

public class EObjectSerializer extends JsonSerializer<EObject> {

	private final JacksonOptions options;

	public EObjectSerializer(JacksonOptions options) {
		this.options = options;
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

		provider.setAttribute("options", options);

		Cache cache = (Cache) provider.getAttribute("cache");
		if (cache == null) {
			provider.setAttribute("cache", cache = new Cache());
		}

		if (
				// Just dump ref in case of container have not the same resource
				object.eContainer() != null && EObjects.isContainmentProxy(object.eContainer(), object) 
				// But don't do this if we are the root (manual splitting)
				&& ! isResourceRoot(object)
			) {
			options.referenceSerializer.serialize(object.eContainer(), object, jg, provider);
			return;
		}

		final EClass eClass = object.eClass();
		final List<EAttribute> attributes = cache.getAttributes(eClass);
		final List<EReference> references = cache.getReferences(eClass);
		final List<EReference> containments = cache.getContainments(eClass);

		jg.writeStartObject();

		writeType(eClass, jg, provider);
		writeId(object, jg, provider);

		for (EAttribute attribute : attributes) {
			if (EObjects.isCandidate(object, attribute, options)) {
				final String field = cache.getKey(attribute);
				final Object value = object.eGet(attribute);

				if (EObjects.isFeatureMap(attribute)) {
					writeFeatureMap(object, attribute, jg, provider);
				} else {
					writeAttribute(jg, (EDataType) object.eClass().getFeatureType(attribute).getEClassifier(), field, value);
				}
			}
		}

		for (EReference reference : references) {
			if (EObjects.isCandidate(object, reference)) {
				final String field = cache.getKey(reference);
				final Object value = object.eGet(reference);

				writeRef(object, field, value, jg, provider);
			}
		}
		
		if(isResourceRoot(object))
		{
			writeTopElements(object, cache, jg, provider);
		}
		

		for (EReference containment : containments) {
			if (EObjects.isCandidate(object, containment)) {
				final String field = cache.getKey(containment);
				final Object value = object.eGet(containment);

				writeContainment(object, field, value, jg, provider);
			}
		}
		jg.writeEndObject();
	}

	/**
	 * @see "org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl#writeTopElement(EObject)"
	 * @param object
	 * @throws IOException 
	 */
	 private boolean writeTopElements(EObject top, Cache cache, JsonGenerator jg, SerializerProvider provider) throws IOException
	  {
		InternalEObject container = ((InternalEObject) top).eInternalContainer();
		if (container != null) {
			EReference containmentReference = top.eContainmentFeature();
			EReference containerReference = containmentReference.getEOpposite();
			if (containerReference != null && !containerReference.isTransient()) {
				final String field = cache.getKey(containerReference);
				writeRef(top, field, container, jg, provider);
				//saveHref(container, containerReference);
				return true;
			}
		  }
	    return false;
	  }

	private boolean isResourceRoot(EObject object) {
		if(object == null || object.eResource() == null || object.eResource().getContents() == null || object.eResource().getContents().size() == 0)
			return false;
		return object.eResource().getContents().get(0) == object;
	}

	private void writeAttribute(JsonGenerator jg, EDataType type, String key, Object value) throws IOException {
		if (EcorePackage.Literals.EJAVA_OBJECT.equals(type) || EcorePackage.Literals.EJAVA_CLASS.equals(type)) {
			jg.writeStringField(key, EcoreUtil.convertToString(type, value));
		} else {
			jg.writeObjectField(key, value);
		}
	}

	protected void writeId(EObject object, JsonGenerator jg, SerializerProvider provider) throws IOException {
		options.idSerializer.serialize(object, jg, provider);
	}

	protected void writeType(EClass eClass, JsonGenerator jg, SerializerProvider provider) throws IOException {
		options.typeSerializer.serialize(eClass, jg, provider);
	}
	
	private void writeContainment(EObject object, final String field,
			final Object value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		
			if (EMap.class.isAssignableFrom(value.getClass())) {
				jg.writeFieldName(field);
				jg.writeObject(value);
			} else if (value instanceof Iterable<?>) {
			jg.writeFieldName(field);
			Iterable<?> values = (Iterable<?>) value;
			
			//Avoid ConcurrentModificationException du to call to eContainer.
			ArrayList<Object> valuesCopiedList = new ArrayList<Object>();
			for (Object current : values) {
				valuesCopiedList.add(current);	
			}
			
			jg.writeStartArray();
			for (Object current : valuesCopiedList) {
				EObject eValue = (EObject) current;
				if (EObjects.isContainmentProxy(object, eValue)) {
					options.referenceSerializer.serialize(object, eValue, jg, provider);
				} else {
					jg.writeObject(eValue);
				}
			}
			jg.writeEndArray();
		} else
		{
			EObject eValue = (EObject) value;
			if (EObjects.isContainmentProxy(object, eValue)) {
				jg.writeFieldName(field);
				options.referenceSerializer.serialize(object, eValue, jg, provider);
			} else {
				jg.writeObjectField(field, eValue);
			}
		}
	}

	private void writeRef(EObject source, String field, Object value, JsonGenerator jg, SerializerProvider provider) throws IOException {
		jg.writeFieldName(field);

		if (value instanceof Iterable<?>) {
			Iterable<?> values = (Iterable<?>) value;

			jg.writeStartArray();
			for (Object current : values) {
				options.referenceSerializer.serialize(source, (EObject) current, jg, provider);
			}
			jg.writeEndArray();

		} else {
			options.referenceSerializer.serialize(source, (EObject) value, jg, provider);
		}
	}

	private void writeFeatureMap(EObject owner, EAttribute attribute, JsonGenerator jg, SerializerProvider provider) throws IOException {
		final Set<EStructuralFeature> features = featureMaps(owner, attribute);
		final Cache cache = (Cache) provider.getAttribute("cache");

		for (EStructuralFeature feature : features) {
			final Object value = owner.eGet(feature);
			final String key = cache.getKey(feature);

			if (feature instanceof EAttribute) {

				writeAttribute(jg, ((EAttribute) feature).getEAttributeType(), key, value);

			} else {
				final EReference reference = (EReference) feature;

				if (reference.isContainment()) {
					jg.writeObjectField(key, value);
				} else {
					writeRef(owner, key, value, jg, provider);
				}
			}
		}
	}

}
