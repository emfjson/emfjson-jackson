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
package org.emfjson.common;

import static org.emfjson.EMFJs.OPTION_INDENT_OUTPUT;
import static org.emfjson.EMFJs.OPTION_PROXY_ATTRIBUTES;
import static org.emfjson.EMFJs.OPTION_RESOLVE_PROXY;
import static org.emfjson.EMFJs.OPTION_ROOT_ELEMENT;
import static org.emfjson.EMFJs.OPTION_SERIALIZE_REF_TYPE;
import static org.emfjson.EMFJs.OPTION_SERIALIZE_TYPE;
import static org.emfjson.EMFJs.OPTION_USE_ID;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

public class Options {

	public final boolean indentOutput;
	public final boolean serializeTypes;
	public final boolean serializeRefTypes;
	public final boolean useProxyAttributes;
	public final boolean resolveProxy;
	public final boolean useId;
	public final EClass rootElement;

	Options(boolean serializeTypes,
			boolean serializeRefTypes,
			boolean useProxyAttributes,
			boolean indentOutput,
			boolean resolveProxy,
			boolean useId,
			EClass rootElement) {
		this.serializeRefTypes = serializeRefTypes;
		this.serializeTypes = serializeTypes;
		this.useProxyAttributes = useProxyAttributes;
		this.indentOutput = indentOutput;
		this.resolveProxy = resolveProxy;
		this.useId = useId;
		this.rootElement = rootElement;
	}

	public static Builder from(Map<?, ?> options) {
		return new Builder(options);
	}

	public static class Builder {

		private final Map<?, ?> options;

		public Builder() {
			this(Collections.emptyMap());
		}

		public Builder(Map<?, ?> options) {
			this.options = options == null ? Collections.emptyMap() : options;
		}

		private boolean booleanValue(Map<?, ?> options, String key, boolean _default) {
			if (options.containsKey(key)) {
				try {
					return (Boolean) options.get(key);
				} catch (ClassCastException e) {
					return _default;
				}
			}
			return _default;
		}

		private EClass objectValue(Map<?, ?> options, String key) {
			Object optionEClass = options.get(key);
			if (optionEClass instanceof EClass) {
				return (EClass) optionEClass;
			}

			return null;
		}

		/**
		 * @return Options setup with clients settings.
		 */
		public Options build() {
			return new Options(
					booleanValue(options, OPTION_SERIALIZE_TYPE, true), 
					booleanValue(options, OPTION_SERIALIZE_REF_TYPE, false), 
					booleanValue(options, OPTION_PROXY_ATTRIBUTES, false),  
					booleanValue(options, OPTION_INDENT_OUTPUT, true),
					booleanValue(options, OPTION_RESOLVE_PROXY, true),
					booleanValue(options, OPTION_USE_ID, false),
					objectValue(options, OPTION_ROOT_ELEMENT));
		}
	}
}
