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
import org.emfjson.jackson.Keywords;
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
	private Keywords keywords = null;

	private final Map<FeatureKind, Boolean> features = new HashMap<>();

	public EMFModule() {
		initFeatures();
	}

	private void initFeatures() {
		for (FeatureKind feature : FeatureKind.values()) {
			features.put(feature, feature.getDefault());
		}
	}

	@Override
	public void setupModule(SetupContext context) {
		if (handler == null)
			handler = new BaseURIHandler();

		if (keywords == null)
			keywords = new Keywords.Builder().build();

		context.addDeserializers(new EMFDeserializers(keywords, features));
		context.addSerializers(new EMFSerializers(keywords, features));

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

	public void setUriHandler(URIHandler handler) {
		this.handler = handler;
	}

	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
	}

	public void configure(FeatureKind feature, Boolean value) {
		this.features.put(feature, value);
	}

	public enum FeatureKind {
		OPTION_SERIALIZE_ID(false),
		OPTION_SERIALIZE_TYPE(true),
		OPTION_SERIALIZE_REF_TYPE(true),
		OPTION_SERIALIZE_DEFAULT_VALUE(false),
		OPTION_SERIALIZE_REF_AS_VALUE(false),
		OPTION_SERIALIZE_CONTAINMENT_AS_HREF(false);

		private final boolean defaultValue;

		FeatureKind(boolean defaultValue) {
			this.defaultValue = defaultValue;
		}

		public boolean getDefault() {
			return defaultValue;
		}
	}

}
