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
package org.emfjson.jackson.module;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.deser.EMFDeserializers;
import org.emfjson.jackson.databind.deser.EcoreReferenceDeserializer;
import org.emfjson.jackson.databind.deser.ReferenceEntry;
import org.emfjson.jackson.databind.ser.EMFSerializers;
import org.emfjson.jackson.databind.ser.EcoreReferenceSerializer;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.handlers.URIHandler;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Module implementation that allows serialization and deserialization of
 * EMF objects (EObject and Resource).
 */
public class EMFModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	private EcoreReferenceInfo referenceInfo;
	private EcoreTypeInfo typeInfo;
	private EcoreIdentityInfo identityInfo;

	private JsonSerializer<EObject> referenceSerializer;
	private JsonDeserializer<ReferenceEntry> referenceDeserializer;

	public void setTypeInfo(EcoreTypeInfo info) {
		this.typeInfo = info;
	}

	public void setIdentityInfo(EcoreIdentityInfo identityInfo) {
		this.identityInfo = identityInfo;
	}

	public void setReferenceInfo(EcoreReferenceInfo referenceInfo) {
		this.referenceInfo = referenceInfo;
	}

	public void setReferenceSerializer(JsonSerializer<EObject> serializer) {
		this.referenceSerializer = serializer;
	}

	public JsonSerializer<EObject> getReferenceSerializer() {
		return referenceSerializer;
	}

	public void setReferenceDeserializer(JsonDeserializer<ReferenceEntry> deserializer) {
		this.referenceDeserializer = deserializer;
	}

	public JsonDeserializer<ReferenceEntry> getReferenceDeserializer() {
		return referenceDeserializer;
	}

	/**
	 * Enumeration that defines all possible options that can be used
	 * to customize the behaviour of the EMF Module.
	 */
	public enum Feature {

		/**
		 * Option used to indicate the module to use the default ID serializer if
		 * none are provided. The ID serializer used by default is IdSerializer.
		 */
		OPTION_USE_ID(false),

		/**
		 * Option used to indicate the module to use the default type serializer if
		 * none are provided. The type serializer used by default is ETypeSerializer.
		 */
		OPTION_SERIALIZE_TYPE(true),

		/**
		 * Option used to indicate the module to serialize default attributes values.
		 * Default values are not serialized by default.
		 */
		OPTION_SERIALIZE_DEFAULT_VALUE(false),

		/**
		 * Option used to indicate the module to serialize containments as references.
		 */
		OPTION_SERIALIZE_CONTAINMENT_AS_HREF(false);

		final boolean _defaultState;
		final int _mask;

		public static int collectDefaults() {
			int flags = 0;
			for (Feature f : values()) {
				if (f.enabledByDefault()) {
					flags |= f.getMask();
				}
			}
			return flags;
		}

		Feature(Boolean defaultState) {
			_defaultState = defaultState;
			_mask = (1 << ordinal());
		}

		public boolean enabledIn(int flags) {
			return (flags & _mask) != 0;
		}

		public boolean enabledByDefault() {
			return _defaultState;
		}

		public int getMask() {
			return _mask;
		}
	}

	protected final static int DEFAULT_FEATURES = Feature.collectDefaults();

	/**
	 * Returns a pre configured mapper with the EMF module.
	 *
	 * @return mapper
	 */
	public static ObjectMapper setupDefaultMapper() {
		return setupDefaultMapper(null);
	}

	/**
	 * Returns a pre configured mapper using the EMF module and the specified jackson factory.
	 * This method can be used to work with formats others than JSON (such as YAML).
	 *
	 * @param factory
	 * @return mapper
	 */
	public static ObjectMapper setupDefaultMapper(JsonFactory factory) {
		final ObjectMapper mapper = new ObjectMapper(factory);
		// same as emf
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getDefault());

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.setDateFormat(dateFormat);
		mapper.setTimeZone(TimeZone.getDefault());
		mapper.registerModule(new EMFModule());

		return mapper;
	}

	protected int _moduleFeatures = DEFAULT_FEATURES;

	private URIHandler handler;

	public EMFModule() {
	}

	@Override
	public void setupModule(SetupContext context) {
		if (handler == null) {
			handler = new BaseURIHandler();
		}

		if (typeInfo == null) {
			typeInfo = new EcoreTypeInfo();
		}

		if (identityInfo == null) {
			identityInfo = new EcoreIdentityInfo();
		}

		if (referenceInfo == null) {
			referenceInfo = new EcoreReferenceInfo(handler);
		}

		if (referenceSerializer == null) {
			referenceSerializer = new EcoreReferenceSerializer(referenceInfo, typeInfo);
		}

		if (referenceDeserializer == null) {
			referenceDeserializer = new EcoreReferenceDeserializer(referenceInfo, typeInfo);
		}

		EMFDeserializers deserializers = new EMFDeserializers(this);
		EMFSerializers serializers = new EMFSerializers(this);

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

	private EMFModule enable(Feature f) {
		_moduleFeatures |= f.getMask();
		return this;
	}

	private EMFModule disable(Feature f) {
		_moduleFeatures &= ~f.getMask();
		return this;
	}

	/**
	 * Returns true if the current feature is used by the module.
	 *
	 * @param f feature
	 * @return true if used
	 */
	public final boolean isEnabled(Feature f) {
		return (_moduleFeatures & f.getMask()) != 0;
	}

	public int getFeatures() {
		return _moduleFeatures;
	}

	/**
	 * Configures the module with one of possible Feature.
	 *
	 * @param feature feature
	 * @param state   of feature
	 * @return EMFModule
	 */
	public EMFModule configure(Feature feature, boolean state) {
		if (state) {
			enable(feature);
		} else {
			disable(feature);
		}
		return this;
	}

	/**
	 * Tells the module which URIHandler to use to de/resolve URIs during
	 * de/serialization.
	 *
	 * @param handler use for de/serialization
	 */
	public void setUriHandler(URIHandler handler) {
		this.handler = handler;
	}

	/**
	 * Returns the URIHandler that will be used to de/resolve URIs during
	 * de/serialization.
	 *
	 * @return handler
	 */
	public URIHandler getUriHandler() {
		return handler;
	}

	public EcoreIdentityInfo getIdentityInfo() {
		return identityInfo;
	}

	public EcoreTypeInfo getTypeInfo() {
		return typeInfo;
	}

	public EcoreReferenceInfo getReferenceInfo() {
		return referenceInfo;
	}

}
