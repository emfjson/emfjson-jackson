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
package org.emfjson.jackson.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.emfjson.jackson.databind.deser.EMFDeserializers;
import org.emfjson.jackson.databind.deser.ETypeDeserializer;
import org.emfjson.jackson.databind.deser.IdDeserializer;
import org.emfjson.jackson.databind.deser.references.AsObjectDeserializer;
import org.emfjson.jackson.databind.deser.references.AsValueDeserializer;
import org.emfjson.jackson.databind.deser.references.EReferenceDeserializer;
import org.emfjson.jackson.databind.ser.EMFSerializers;
import org.emfjson.jackson.databind.ser.ETypeSerializer;
import org.emfjson.jackson.databind.ser.IdSerializer;
import org.emfjson.jackson.databind.ser.references.AsObjectSerializer;
import org.emfjson.jackson.databind.ser.references.AsValueSerializer;
import org.emfjson.jackson.databind.ser.references.EReferenceSerializer;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Module implementation that allows serialization and deserialization of
 * EMF objects (EObject and Resource).
 */
public class EMFModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	private URIHandler handler = null;

	private final Map<ModuleFeature, Boolean> features = new HashMap<>();

	private IdSerializer idSerializer;
	private IdDeserializer idDeserializer;

	private ETypeSerializer typeSerializer;
	private ETypeDeserializer typeDeserializer;

	private EReferenceSerializer referenceSerializer;
	private EReferenceDeserializer referenceDeserializer;

	public EMFModule() {
		initFeatures();
	}

	@Override
	public void setupModule(SetupContext context) {
		if (handler == null)
			handler = new BaseURIHandler();

		if (idSerializer == null)
			idSerializer = new IdSerializer();

		if (idDeserializer == null)
			idDeserializer = new IdDeserializer();

		if (typeSerializer == null)
			typeSerializer = new ETypeSerializer();

		if (typeDeserializer == null)
			typeDeserializer = new ETypeDeserializer();

		if (referenceSerializer == null) {
			referenceSerializer = features.get(ModuleFeature.OPTION_SERIALIZE_REF_AS_VALUE) ?
					new AsValueSerializer():
					new AsObjectSerializer();
		}

		if (referenceDeserializer == null)
			referenceDeserializer = features.get(ModuleFeature.OPTION_SERIALIZE_REF_AS_VALUE) ?
					new AsValueDeserializer():
					new AsObjectDeserializer();

		EMFDeserializers deserializers = new EMFDeserializers();
		deserializers.configure(this, features);

		EMFSerializers serializers = new EMFSerializers();
		serializers.configure(this, features);

		context.addDeserializers(deserializers);
		context.addSerializers(serializers);

		super.setupModule(context);
	}

	@Override
	public String getModuleName() {
		return "emfjson-module";
	}

	@Override
	public Version version() {
		return new Version(1, 0, 0, "rc1", "org.emfjson", "emfjson-jackson");
	}

	public void configure(ModuleFeature feature, Boolean value) {
		this.features.put(feature, value);
	}

	// options

	public void setUriHandler(URIHandler handler) {
		this.handler = handler;
	}

	public URIHandler getHandler() {
		return handler;
	}

	// serializers

	public void setIdSerializer(IdSerializer idSerializer) {
		this.idSerializer = idSerializer;
	}

	public IdSerializer getIdSerializer() {
		return idSerializer;
	}

	public void setTypeSerializer(ETypeSerializer typeSerializer) {
		this.typeSerializer = typeSerializer;
	}

	public ETypeSerializer getTypeSerializer() {
		return typeSerializer;
	}

	public void setReferenceSerializer(EReferenceSerializer referenceSerializer) {
		this.referenceSerializer = referenceSerializer;
	}

	public EReferenceSerializer getReferenceSerializer() {
		return referenceSerializer;
	}

	// deserializers

	public void setIdDeserializer(IdDeserializer idDeserializer) {
		this.idDeserializer = idDeserializer;
	}

	public IdDeserializer getIdDeserializer() {
		return idDeserializer;
	}

	public void setTypeDeserializer(ETypeDeserializer typeDeserializer) {
		this.typeDeserializer = typeDeserializer;
	}

	public ETypeDeserializer getTypeDeserializer() {
		return typeDeserializer;
	}

	public void setReferenceDeserializer(EReferenceDeserializer referenceDeserializer) {
		this.referenceDeserializer = referenceDeserializer;
	}

	public EReferenceDeserializer getReferenceDeserializer() {
		return referenceDeserializer;
	}

	private void initFeatures() {
		for (ModuleFeature feature : ModuleFeature.values()) {
			features.put(feature, feature.getDefaultValue());
		}
	}

	public enum ModuleFeature {

		OPTION_SERIALIZE_ID(false),

		OPTION_SERIALIZE_TYPE(true),

		OPTION_SERIALIZE_REF_TYPE(true),

		OPTION_SERIALIZE_DEFAULT_VALUE(false),

		OPTION_SERIALIZE_REF_AS_VALUE(false),

		OPTION_SERIALIZE_CONTAINMENT_AS_HREF(false);

		private final Boolean defaultValue;

		ModuleFeature(Boolean defaultValue) {
			this.defaultValue = defaultValue;
		}

		public Boolean getDefaultValue() {
			return defaultValue;
		}
	}

	public enum ContextFeature {
		OPTION_URI_HANDLER,
		OPTION_ROOT_ELEMENT
	}

}
