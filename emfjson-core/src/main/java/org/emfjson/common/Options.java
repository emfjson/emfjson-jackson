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
package org.emfjson.common;

import org.eclipse.emf.ecore.EClass;
import org.emfjson.handlers.IdentityURIHandler;
import org.emfjson.handlers.URIHandler;

import java.util.Collections;
import java.util.Map;

import static org.emfjson.EMFJs.*;

/**
 * Configuration options for serializers and deserializers.
 */
public class Options {

	public final boolean indentOutput;
	public final boolean serializeTypes;
	public final boolean serializeRefTypes;
	public final boolean serializeDefaultValues;
	public final boolean useProxyAttributes;
	public final boolean useId;
	public final String typeField;
	public final String idField;
	public final String refField;
	public final EClass rootElement;
	public final URIHandler uriHandler;

	protected Options(AbstractBuilder<?, ?> builder) {
		this.serializeTypes = builder.withTypes;
		this.serializeRefTypes = builder.withRefTypes;
		this.useProxyAttributes = builder.withProxyAttributes;
		this.serializeDefaultValues = builder.withDefaultValues;
		this.indentOutput = builder.indentOutput;
		this.useId = builder.withID;
		this.typeField = builder.typeField;
		this.idField = builder.idField;
		this.refField = builder.refField;
		this.rootElement = builder.rootElement;
		this.uriHandler = builder.uriHandler;
	}

	public static Options from(Map<?, ?> options) {
		return new Builder().build(options);
	}

	public static abstract class AbstractBuilder<T extends AbstractBuilder<T, O>, O extends Options> {

		protected boolean indentOutput = true;
		protected boolean withDefaultValues = false;
		protected boolean withTypes = true;
		protected boolean withRefTypes = false;
		protected boolean withProxyAttributes = false;
		protected boolean withID = false;
		protected String typeField = "eClass";
		protected String idField = "_id";
		protected String refField = "$ref";
		protected EClass rootElement = null;
		protected URIHandler uriHandler = new IdentityURIHandler();

		protected void init(Map<?, ?> options) {
			if (options == null) {
				options = Collections.emptyMap();
			}

			withTypes = booleanValue(options, OPTION_SERIALIZE_TYPE, withTypes);
			withRefTypes = booleanValue(options, OPTION_SERIALIZE_REF_TYPE, withRefTypes);
			withProxyAttributes = booleanValue(options, OPTION_PROXY_ATTRIBUTES, withProxyAttributes);
			withDefaultValues = booleanValue(options, OPTION_SERIALIZE_DEFAULT_VALUE, withDefaultValues);
			indentOutput = booleanValue(options, OPTION_INDENT_OUTPUT, indentOutput);
			withID = booleanValue(options, OPTION_USE_ID, withID);
			typeField = stringValue(options, OPTION_TYPE_FIELD, typeField);
			idField = stringValue(options, OPTION_ID_FIELD, idField);
			refField = stringValue(options, OPTION_REF_FIELD, refField);
			rootElement = eClassValue(options, OPTION_ROOT_ELEMENT, rootElement);
			uriHandler = objectValue(options, OPTION_URI_HANDLER, uriHandler);
		}

		protected abstract T getThis();

		protected boolean booleanValue(Map<?, ?> options, String key, boolean _default) {
			if (options.containsKey(key)) {
				try {
					return (Boolean) options.get(key);
				} catch (ClassCastException e) {
					return _default;
				}
			}
			return _default;
		}

		protected String stringValue(Map<?, ?> options, String key, String _default) {
			if (options.containsKey(key)) {
				try {
					return (String) options.get(key);
				} catch (ClassCastException e) {
					return _default;
				}
			}
			return _default;
		}

		protected EClass eClassValue(Map<?, ?> options, String key, EClass _default) {
			Object value = options.get(key);
			if (value instanceof EClass) {
				return (EClass) value;
			}

			return _default;
		}

		@SuppressWarnings("unchecked")
		protected <V> V objectValue(Map<?, ?> options, String key, V _default) {
			V value;
			try {
				value = (V) options.get(key);
			} catch (ClassCastException e) {
				return _default;
			}

			return value != null ? value : _default;
		}

		public abstract O build();

		public abstract O build(Map<?, ?> options);

		public T withTypes(boolean withTypes) {
			this.withTypes = withTypes;
			return getThis();
		}

		public T withID(boolean withID) {
			this.withID = withID;
			return getThis();
		}

		public T withRoot(EClass root) {
			this.rootElement = root;
			return getThis();
		}

		public T withTypeField(String typeField) {
			this.typeField = typeField;
			return getThis();
		}

		public T withIdField(String idField) {
			this.idField = idField;
			return getThis();
		}

		public T withRefField(String refField) {
			this.refField = refField;
			return getThis();
		}

		public T withUriHandler(URIHandler uriHandler) {
			this.uriHandler = uriHandler;
			return getThis();
		}

	}

	public static class Builder extends AbstractBuilder<Builder, Options> {

		@Override
		protected Builder getThis() {
			return this;
		}

		@Override
		public Options build(Map<?, ?> options) {
			init(options);
			return new Options(getThis());
		}

		@Override
		public Options build() {
			return new Options(getThis());
		}

	}

}
