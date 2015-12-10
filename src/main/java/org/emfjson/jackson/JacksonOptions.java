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
package org.emfjson.jackson;

import org.eclipse.emf.ecore.EClass;
import org.emfjson.EMFJs;
import org.emfjson.jackson.databind.deser.DefaultTypeDeserializer;
import org.emfjson.jackson.databind.deser.FragmentIdDeserializer;
import org.emfjson.jackson.databind.deser.IdDeserializer;
import org.emfjson.jackson.databind.deser.TypeDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceDeserializer;
import org.emfjson.jackson.databind.ser.DefaultTypeSerializer;
import org.emfjson.jackson.databind.ser.FragmentIdSerializer;
import org.emfjson.jackson.databind.ser.IdSerializer;
import org.emfjson.jackson.databind.ser.TypeSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceAsObjectSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.emfjson.handlers.IdentityURIHandler;
import org.emfjson.handlers.URIHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Map;

import static org.emfjson.EMFJs.*;

public class JacksonOptions {

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
	public final ReferenceSerializer referenceSerializer;
	public final ReferenceDeserializer referenceDeserializer;
	public final IdSerializer idSerializer;
	public final IdDeserializer idDeserializer;
	public final TypeSerializer typeSerializer;
	public final TypeDeserializer typeDeserializer;
	public final DateFormat dateFormat;

	protected JacksonOptions(JacksonOptions.Builder builder) {
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
		this.referenceSerializer = builder.referenceSerializer;
		this.referenceDeserializer = builder.referenceDeserializer;
		this.idSerializer = builder.idSerializer;
		this.idDeserializer = builder.idDeserializer;
		this.typeSerializer = builder.typeSerializer;
		this.typeDeserializer = builder.typeDeserializer;
		this.dateFormat = builder.dateFormat;
	}

	public static JacksonOptions from(Map<?, ?> options) {
		return new Builder().build(options);
	}

	public static final class Builder {

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
		protected ReferenceSerializer referenceSerializer = new ReferenceAsObjectSerializer();
		protected ReferenceDeserializer referenceDeserializer = new ReferenceAsObjectDeserializer();
		protected IdSerializer idSerializer = new FragmentIdSerializer();
		protected IdDeserializer idDeserializer = new FragmentIdDeserializer();
		protected TypeSerializer typeSerializer = new DefaultTypeSerializer();
		protected TypeDeserializer typeDeserializer = new DefaultTypeDeserializer();
		protected DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		public JacksonOptions build(Map<?, ?> options) {
			init(options);
			return new JacksonOptions(this);
		}

		public JacksonOptions build() {
			return build(Collections.emptyMap());
		}

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

			uriHandler = objectValue(options, OPTION_URI_HANDLER, null);
			referenceSerializer = objectValue(options, OPTION_REF_SERIALIZER, referenceSerializer);
			referenceDeserializer = objectValue(options, OPTION_REF_DESERIALIZER, referenceDeserializer);
			idSerializer = objectValue(options, OPTION_ID_SERIALIZER, idSerializer);
			idDeserializer = objectValue(options, OPTION_ID_DESERIALIZER, idDeserializer);
			dateFormat = objectValue(options, EMFJs.OPTION_DATE_FORMAT, dateFormat);
		}

		public Builder withTypes(boolean withTypes) {
			this.withTypes = withTypes;
			return this;
		}

		public Builder withID(boolean withID) {
			this.withID = withID;
			return this;
		}

		public Builder withRoot(EClass root) {
			this.rootElement = root;
			return this;
		}

		public Builder withTypeField(String typeField) {
			this.typeField = typeField;
			return this;
		}

		public Builder withIdField(String idField) {
			this.idField = idField;
			return this;
		}

		public Builder withRefField(String refField) {
			this.refField = refField;
			return this;
		}

		public Builder withUriHandler(URIHandler uriHandler) {
			this.uriHandler = uriHandler;
			return this;
		}

		public Builder withReferenceSerializer(ReferenceSerializer serializer) {
			this.referenceSerializer = serializer;
			return this;
		}

		public Builder withReferenceDeserializer(ReferenceDeserializer deserializer) {
			this.referenceDeserializer = deserializer;
			return this;
		}

		public Builder withIdSerializer(IdSerializer serializer) {
			this.idSerializer = serializer;
			return this;
		}

		public Builder withIdDeserializer(IdDeserializer deserializer) {
			this.idDeserializer = deserializer;
			return this;
		}

		public Builder withTypeSerializer(TypeSerializer typeSerializer) {
			this.typeSerializer = typeSerializer;
			return this;
		}

		public Builder withTypeDeserializer(TypeDeserializer typeDeserializer) {
			this.typeDeserializer = typeDeserializer;
			return this;
		}

		public Builder withDateFormat(DateFormat dateFormat) {
			this.dateFormat = dateFormat;
			return this;
		}

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
	}

}
