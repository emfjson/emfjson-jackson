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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.EMFJs;
import org.emfjson.common.EObjects;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.errors.JSONException;
import org.emfjson.jackson.resource.JsonResource;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class EObjectDeserializer extends JsonDeserializer<EObject> implements ContextualDeserializer {

	private final Cache cache = new Cache();
	private final ResourceSet resourceSet;
	private final JacksonOptions options;

	public EObjectDeserializer(ResourceSet resourceSet, JacksonOptions options) {
		this.resourceSet = resourceSet;
		this.options = options;
	}

	@Override
	public boolean isCachable() {
		return true;
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		prepareContext(ctxt, null);

		return doDeserialize(jp, findRoot(ctxt), ctxt);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt, EObject intoValue) throws IOException {
		if (intoValue == null) {
			return null;
		}

		prepareContext(ctxt, null);

		final Resource resource = (Resource) ctxt.getAttribute("resource");
		final ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String fieldName = jp.getCurrentName();

			if (options.idField.equalsIgnoreCase(fieldName)) {
				options.idDeserializer.deserialize(jp, intoValue, ctxt);
			} else {
				readFeature(jp, intoValue, fieldName, ctxt, resource, entries);
			}
		}

		return postDeserialize(null, intoValue, null, ctxt);
	}

	public EObject deserialize(JsonParser jp, DeserializationContext ctxt, EReference containment) throws IOException {
		EClass defaultType = null;

		if (containment != null) {
			defaultType = containment.getEReferenceType();

			if (defaultType.isAbstract()) {
				defaultType = null;
			}
		}

		return doDeserialize(jp, defaultType, ctxt);
	}

	protected EObject doDeserialize(JsonParser jp, EClass defaultType, DeserializationContext ctxt) throws IOException {
		EObject current = null;
		final Resource resource = (Resource) ctxt.getAttribute("resource");
		final ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");
		final TokenBuffer buffer = new TokenBuffer(jp);

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String fieldName = jp.getCurrentName();

			if (options.typeField.equalsIgnoreCase(fieldName)) {

				if (current == null) {
					current = create(jp, ctxt);
				}

			} else if (options.idField.equalsIgnoreCase(fieldName)) {

				if (current != null) {
					options.idDeserializer.deserialize(jp, current, ctxt);
				} else {
					buffer.copyCurrentStructure(jp);
				}

			} else {

				if (current != null) {
					readFeature(jp, current, fieldName, ctxt, resource, entries);
				} else {
					buffer.copyCurrentStructure(jp);
				}

			}
		}

		return postDeserialize(buffer, current, defaultType, ctxt);
	}

	protected EObject postDeserialize(TokenBuffer buffer,
									  EObject object,
									  EClass defaultType,
									  DeserializationContext ctxt) throws IOException {

		if (object == null && defaultType == null) {
			return null;
		}

		if (object == null) {
			object = EcoreUtil.create(defaultType);
		}

		if (buffer != null) {
			final Resource resource = (Resource) ctxt.getAttribute("resource");
			final ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");
			final JsonParser bufferedParser = buffer.asParser();

			while (bufferedParser.nextToken() != null) {
				if (options.idField.equals(bufferedParser.getCurrentName())) {
					options.idDeserializer.deserialize(bufferedParser, object, ctxt);
				} else {
					readFeature(bufferedParser, object, bufferedParser.getCurrentName(), ctxt, resource, entries);
				}
			}

			bufferedParser.close();
			buffer.close();
		}

		return object;
	}

	private EClass findRoot(DeserializationContext ctxt) {
		Object root = ctxt.getAttribute(EMFJs.OPTION_ROOT_ELEMENT);
		if (root instanceof EClass) {
			return (EClass) root;
		}

		return options.rootElement;
	}

	private void readFeature(JsonParser jp,
							 EObject current,
							 String fieldName,
							 DeserializationContext ctxt,
							 Resource resource,
							 ReferenceEntries entries) throws IOException {

		final EClass eClass = current.eClass();
		final EStructuralFeature feature = cache.getEStructuralFeature(eClass, fieldName);

		if (feature != null) {

			if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {
				jp.nextToken();
			}

			if (feature instanceof EAttribute) {
				readAttribute(jp, current, (EAttribute) feature, resource, ctxt);
			} else {
				EReference reference = (EReference) feature;

				if (reference.isContainment()) {
					readContainment(jp, current, ctxt, reference, resource, entries);
				} else {
					readReference(jp, current, reference, entries, ctxt);
				}
			}

		} else {
			if (resource != null) {
				resource.getErrors().add(new JSONException(
						"Unknown feature " + fieldName,
						jp.getCurrentLocation()));
			}
			// we didn't find a feature so consume
			// the field and move on
			jp.nextToken();
			jp.skipChildren();
		}
	}

	@SuppressWarnings("unchecked")
	private void readContainment(JsonParser jp,
								 EObject owner,
								 DeserializationContext ctxt,
								 EReference reference,
								 Resource resource,
								 ReferenceEntries entries) throws IOException {

		final EClass eType = (EClass) owner.eClass().getFeatureType(reference).getEClassifier();
		final Class<?> type = eType.getInstanceClass();

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {

			while (jp.nextToken() != JsonToken.END_ARRAY) {

				try {
					EObject value = deserialize(jp, ctxt, reference);
					if (value != null) {
						EObjects.setOrAdd(owner, reference, value);
						entries.store(resource, value);
					}
				} catch (Exception e) {
					if (resource != null) {
						resource.getErrors().add(new JSONException(e, jp.getCurrentLocation()));
					}
				}
			}

		} else {

			// if the type is a Map.Entry but the current values are not serialized
			// in an array, then it must be a map with string keys that was serialized
			// as a JSON object.
			if ((type != null && Map.Entry.class.isAssignableFrom(type)) || "java.util.Map.Entry".equals(eType.getInstanceClassName())) {

				readMap(jp, owner, ctxt, reference);

			} else {
				// otherwise it's a normal object.
				try {
					EObject value = deserialize(jp, ctxt, reference);
					if (value != null) {
						entries.store(resource, value);
						EObjects.setOrAdd(owner, reference, value);
					}
				} catch (Exception e) {
					if (resource != null) {
						resource.getErrors().add(new JSONException(e, jp.getCurrentLocation()));
					}
				}
			}
		}
	}

	/*
		Read the key-values pair of a JSON object and put it in a Map.
	 */
	@SuppressWarnings("unchecked")
	private void readMap(JsonParser jp,
						 EObject owner,
						 DeserializationContext ctxt,
						 EReference reference) throws IOException {

		final Collection map = (Collection) owner.eGet(reference);

		if (jp.getCurrentToken() == JsonToken.START_OBJECT) {

			while (jp.nextToken() != JsonToken.END_OBJECT) {
				final String key = jp.getCurrentName();
				jp.nextToken();

				final Object value;
				if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
					value = deserialize(jp, ctxt, reference);
				} else {
					value = ctxt.readValue(jp, Object.class);
				}

				// Dynamic objects do not use the EMap interface
				// but store entries in a DynamicEList instead.
				if (map instanceof EMap) {
					((EMap) map).put(key, value);
				} else {
					map.add(EObjects.createEntry(key, value, reference.getEReferenceType()));
				}
			}
		}
	}

	private void readReference(JsonParser jp,
							   EObject owner,
							   EReference reference,
							   ReferenceEntries entries,
							   DeserializationContext context) throws IOException {

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
			while (jp.nextToken() != JsonToken.END_ARRAY) {
				entries.add(options.referenceDeserializer.deserialize(jp, owner, reference, context));
			}
		} else {
			entries.add(options.referenceDeserializer.deserialize(jp, owner, reference, context));
		}
	}

	private void readAttribute(JsonParser jp,
							   EObject owner,
							   EAttribute attribute,
							   Resource resource,
							   DeserializationContext ctxt) throws IOException {

		final EDataType dataType = (EDataType) owner.eClass().getFeatureType(attribute).getEClassifier();
		if (dataType == null) {
			resource.getErrors().add(new JSONException("Missing feature type", jp.getCurrentLocation()));
			jp.nextToken();
			return;
		}

		if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
			while (jp.nextToken() != JsonToken.END_ARRAY) {
				readSingleAttribute(jp, owner, attribute, resource, dataType, ctxt);
			}
		} else {
			readSingleAttribute(jp, owner, attribute, resource, dataType, ctxt);
		}
	}

	private void readSingleAttribute(JsonParser jp,
									 EObject owner,
									 EAttribute attribute,
									 Resource resource,
									 EDataType dataType,
									 DeserializationContext ctxt) throws IOException {

		final Class<?> type = dataType.getInstanceClass();

		Object value;
		if (type == null || dataType instanceof EEnum ||
				EcorePackage.Literals.EJAVA_CLASS.equals(dataType) ||
				EcorePackage.Literals.EJAVA_OBJECT.equals(dataType)) {

			value = EcoreUtil.createFromString(dataType, jp.getText());

		} else {

			value = ctxt.readValue(jp, type);

		}

		try {
			EObjects.setOrAdd(owner, attribute, value);
		} catch (Exception e) {
			if (resource != null) {
				resource.getErrors().add(new JSONException(e, jp.getCurrentLocation()));
			}
		}
	}

	protected EObject create(JsonParser jp, DeserializationContext context) throws IOException {
		EClass eClass = options.typeDeserializer.deserialize(jp, context);
		if (eClass != null) {
			return EcoreUtil.create(eClass);
		}
		return null;
	}

	@Override
	public Class<?> handledType() {
		return EObject.class;
	}

	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
		prepareContext(ctxt, property);
		return this;
	}

	protected void prepareContext(DeserializationContext ctxt, BeanProperty property) {
		ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");
		Resource resource = (Resource) ctxt.getAttribute("resource");

		if (property instanceof ResourceProperty) {
			ResourceProperty p = (ResourceProperty) property;
			resource = p.getResource();
			entries = p.getEntries();
		}

		if (resource == null) {
			resource = new JsonResource(URI.createURI("default"));
			resourceSet.getResources().add(resource);
		}

		if (entries == null) {
			entries = new ReferenceEntries();
		}

		ctxt.setAttribute("entries", entries);
		ctxt.setAttribute("resource", resource);
		ctxt.setAttribute("cache", cache);
		ctxt.setAttribute("resourceSet", resourceSet);
		ctxt.setAttribute("options", options);
	}

}
