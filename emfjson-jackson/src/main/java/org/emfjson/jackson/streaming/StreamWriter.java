/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.streaming;

import static org.emfjson.common.Constants.EJS_TYPE_KEYWORD;
import static org.emfjson.common.Constants.EJS_UUID_ANNOTATION;
import static org.emfjson.common.EObjects.featureMaps;
import static org.emfjson.common.EObjects.isCandidate;
import static org.emfjson.common.EObjects.isContainmentProxy;
import static org.emfjson.common.EObjects.isFeatureMap;
import static org.emfjson.common.EObjects.isMapEntry;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.common.Cache;
import org.emfjson.common.Options;
import org.emfjson.common.resource.UuidResource;
import org.emfjson.converters.DataTypeConverter;
import org.emfjson.jackson.converters.DefaultDateConverter;
import org.emfjson.jackson.streaming.References.RefAsObjectWriter;
import org.emfjson.jackson.streaming.References.RefWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

public class StreamWriter {

	private final Options options;
	private final Cache cache = new Cache();

	private References referenceWriter;
	private Values values;
	
	private Map<EDataType, DataTypeConverter<?, ?>> converters = new HashMap<>();

	private boolean isPrepared = false;
	private RefWriter refWriter;

	public StreamWriter(Options options) {
		this.options = options;		
	}

	public void setRefWriter(RefWriter refWriter) {
		this.refWriter = refWriter; 
	}

	public void register(DataTypeConverter<?, ?> converter) {
		if (converter != null && converter.getDataType() != null) {
			this.converters.put(converter.getDataType(), converter);
		}
	}

	private void prepare(JsonGenerator generator, Resource resource) {
		if (isPrepared) return;

		if (options.indentOutput) {
			DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
			generator.setPrettyPrinter(printer);
		}

		if (refWriter == null) {
			refWriter = new RefAsObjectWriter();
		}

		if (!converters.containsKey(EcorePackage.Literals.EDATE)) {
			converters.put(EcorePackage.Literals.EDATE, new DefaultDateConverter());
		}

		referenceWriter = new References(cache, resource, refWriter, options);
		values = new Values(converters);

		isPrepared = true;
	}

	public void generate(final JsonGenerator generator, Resource resource) {
		prepare(generator, resource);

		final EList<EObject> contents = resource.getContents();

		if (contents.size() == 1) {
			try {
				generate(generator, contents.get(0));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				generator.writeStartArray();
				for (final EObject current: contents) {
					generate(generator, current);
				}
				generator.writeEndArray();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void generate(final JsonGenerator generator, final EObject object) 
			throws IOException {
		prepare(generator, object.eResource());

		final EClass eClass = object.eClass();
		final List<EAttribute> attributes = cache.getAttributes(eClass);
		final List<EReference> references = cache.getReferences(eClass);

		generator.writeStartObject();

		if (options.serializeTypes) {
			generator.writeStringField(EJS_TYPE_KEYWORD, cache.getHref(null, eClass));	
		}

		if (object.eResource() instanceof UuidResource) {
			String id = ((UuidResource) object.eResource()).getID(object);
			if (id != null) {
				generator.writeStringField(EJS_UUID_ANNOTATION, id);
			}
		} else {
			if (options.useId) {
				String id = object.eResource().getURIFragment(object);
				if (id != null) {
					generator.writeStringField(EJS_UUID_ANNOTATION, id);
				}
			}
		}

		for (final EAttribute attribute: attributes) {
			if (isCandidate(object, attribute)) {
				final String key = cache.getKey(attribute);
				final Object value = object.eGet(attribute);

				if (isFeatureMap(attribute)) {
					serializeFeatureMap(generator, attribute, object);
				} else {
					values.serialize(generator, key, attribute, value);
				}
			}
		}

		for (final EReference reference: references) {
			if (isCandidate(object, reference)) {
				final Object value = object.eGet(reference);
				final String key = cache.getKey(reference);

				if (isMapEntry(reference.getEReferenceType())) {
					serializeMapEntry(generator, key, reference, value);
				} else if (!reference.isContainment()) {
					referenceWriter.serialize(generator, key, reference, value);
				} else {
					serializeContainment(generator, key, reference, object, value);
				}
			}
		}

		generator.writeEndObject();
	}

	private void serializeMapEntry(JsonGenerator generator, String key, EReference reference, Object value) 
			throws IOException {

		generator.writeFieldName(key);
		generator.writeStartObject();

		if (reference.isMany()) {
			@SuppressWarnings("unchecked")
			Collection<Map.Entry<String, String>> entries = (Collection<Entry<String, String>>) value;

			for (Map.Entry<String, String> entry: entries) {
				generator.writeStringField(entry.getKey(), entry.getValue());
			}
		} else {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> entry = (Entry<String, String>) value;
			generator.writeStringField(entry.getKey(), entry.getValue());
		}
		generator.writeEndObject();
	}

	private void serializeFeatureMap(JsonGenerator generator, EAttribute attribute, EObject owner) 
			throws IOException {

		final Set<EStructuralFeature> features = featureMaps(owner, attribute);

		for (EStructuralFeature feature: features) {
			final Object value = owner.eGet(feature);
			final String key = cache.getKey(feature);

			if (feature instanceof EAttribute) {
				values.serialize(generator, key, (EAttribute) feature, value);
			} else {
				final EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					serializeContainment(generator, key, reference, owner, value);
				} else {
					referenceWriter.serialize(generator, key, reference, value);
				}
			}
		}
	}

	private void serializeContainment(JsonGenerator generator, String key, EReference containment, EObject owner, Object value) 
			throws IOException {

		if (containment.isMany()) {
			final Collection<?> values = (Collection<?>) value;

			generator.writeFieldName(key);
			generator.writeStartArray();
			for (Object current: values) {
				EObject target = (EObject) current;

				if (isContainmentProxy(owner, target)) {
					referenceWriter.writeRef(generator, target);
				} else {
					generate(generator, target);
				}

			}
			generator.writeEndArray();

		} else {

			generator.writeFieldName(key);
			if (isContainmentProxy(owner, (EObject) value)) {
				referenceWriter.writeRef(generator, (EObject) value);
			} else {
				generate(generator, (EObject) value);
			}

		}
	}

}
