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
import static org.emfjson.common.EObjects.createEntry;
import static org.emfjson.common.EObjects.isMapEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.Cache;
import org.emfjson.common.Constants;
import org.emfjson.common.EObjects;
import org.emfjson.common.Options;
import org.emfjson.common.ReferenceEntry;
import org.emfjson.common.resource.UuidResource;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.util.TokenBuffer;

public class StreamReader {

	protected final Options options;
	protected final List<ReferenceEntry> entries = new ArrayList<>();
	protected final Cache cache = new Cache();

	private Resource resource;
	private ResourceSet resourceSet;

	public StreamReader(Options options) {
		this.options = options;
	}

	private void prepare(Resource resource) {
		this.resource = resource;

		if (this.resource == null || this.resource.getResourceSet() == null) {
			resourceSet = new ResourceSetImpl();
		} else {
			resourceSet = this.resource.getResourceSet();
		}
	}

	public void parse(Resource resource, JsonParser parser) throws IOException {
		prepare(resource);

		if (parser.getCurrentToken() == null) {
			parser.nextToken();
		}

		switch (parser.getCurrentToken()) {
		case START_OBJECT:
			EObject result = parseObject(parser, null, null, options.rootElement);
			if (result != null) {
				resource.getContents().add(result);
			}
			break;
		case START_ARRAY:
			parseArray(parser);
			break;
		default:
			break;
		}

		resolve();
		entries.clear();
	}

	private void parseArray(JsonParser parser) throws IOException {
		while (parser.nextToken() != JsonToken.END_ARRAY) {
			if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
				EObject result = parseObject(parser, null, null, options.rootElement);
				if (result != null) {
					resource.getContents().add(result);
				}
			}
		}
	}

	protected EObject parseObject(JsonParser parser, EReference containment, EObject owner, EClass currentClass) 
			throws IOException {

		EObject current = null;

		if (currentClass != null) {
			current = EcoreUtil.create(currentClass);
		}
		
		final TokenBuffer buffer = new TokenBuffer(parser);

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			final String fieldName = parser.getCurrentName();

			switch (fieldName) {
			case EJS_TYPE_KEYWORD:
				current = create(parser.nextTextValue());
				break;
			case EJS_UUID_ANNOTATION:
				if (resource instanceof UuidResource) {
					if (current != null) {
						((UuidResource) resource).setID(current, parser.nextTextValue());
					}
				}
				break;
			default:
				if (current == null && containment != null) {
					final EClass defaultType = containment.getEReferenceType();

					if (!defaultType.isAbstract()) {
						current = EcoreUtil.create(defaultType);
					}
				}

				if (current != null) {
					readFeature(parser, current, fieldName);
				} else {
					buffer.copyCurrentStructure(parser);
				}
				break;
			}
		}

		buffer.close();

		if (current != null) {
			final JsonParser bufferedParser = buffer.asParser();
	
			while(bufferedParser.nextToken() != null) {
				readFeature(bufferedParser, current, bufferedParser.getCurrentName());
			}

			bufferedParser.close();
		}

		if (current != null && containment != null && owner != null) {
			EObjects.setOrAdd(owner, containment, current);
		}

		return current;
	}

	private void readFeature(JsonParser parser, EObject current, final String fieldName) 
			throws IOException {

		final EClass eClass = current.eClass();
		final EStructuralFeature feature = cache.getEStructuralFeature(eClass, fieldName);

		if (feature != null) {
			if (feature instanceof EAttribute) {
				readAttribute(parser, (EAttribute) feature, current);
			} else {
				readReference(parser, (EReference) feature, current);
			}
		}
	}

	protected  void readAttribute(JsonParser parser, EAttribute attribute, EObject owner) 
			throws IOException {

		final JsonToken token = parser.nextToken();

		if (token == JsonToken.START_ARRAY) {
			while (parser.nextToken() != JsonToken.END_ARRAY) {
				EObjects.setOrAdd(owner, attribute, parser.getText());
			}
		} else {
			EObjects.setOrAdd(owner, attribute, parser.getText());
		}
	}

	protected  void readReference(JsonParser parser, EReference reference, EObject owner) 
			throws IOException {

		JsonToken token = parser.nextToken();

		if (reference.isContainment()) {

			if (isMapEntry(reference.getEReferenceType())) {
				if (token == JsonToken.START_OBJECT) {
					token = parseEntry(parser, reference, owner);
				}
			}

			if (token == JsonToken.START_ARRAY) {
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					parseObject(parser, reference, owner, null);
				}
			} else if (token == JsonToken.START_OBJECT) {
				parseObject(parser, reference, owner, null);
			}

		} else {

			if (token == JsonToken.START_ARRAY) {
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					entries.add(createReferenceEntry(parser, reference, owner));
				}
			} else {
				entries.add(createReferenceEntry(parser, reference, owner));
			}
		}

	}

	@SuppressWarnings("unchecked")
	protected  JsonToken parseEntry(JsonParser parser, EReference reference, EObject owner) 
			throws IOException {

		EList<EObject> values = null;
		if (reference.isMany()) {
			values = (EList<EObject>) owner.eGet(reference);
		}

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			final String field = parser.getCurrentName();
			final String value = parser.nextTextValue();

			if (reference.isMany() && values != null) {
				values.add(createEntry(field, value));
			} else {
				owner.eSet(reference, createEntry(field, value));
			}
		}

		return parser.getCurrentToken();
	}

	protected ReferenceEntry createReferenceEntry(JsonParser parser, EReference reference, EObject owner) 
			throws IOException {

		String id = null;

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String field = parser.getCurrentName();
			if (field.equalsIgnoreCase(Constants.EJS_REF_KEYWORD)) {
				id = parser.nextTextValue();
			}
		}

		return new ReferenceEntry(owner, reference, id);
	}

	protected EObject create(String type) {
		EClass eClass = cache.getEClass(resourceSet, type);
		if (eClass != null) {
			return EcoreUtil.create(eClass);
		}
		return null;
	}

	protected void resolve() {
		for (ReferenceEntry entry: entries) {
			entry.resolve(resourceSet, options);
		}
	}

}
