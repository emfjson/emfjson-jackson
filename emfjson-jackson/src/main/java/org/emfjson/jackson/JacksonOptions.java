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
import org.emfjson.common.Options;
import org.emfjson.handlers.URIHandler;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Map;

import static org.emfjson.EMFJs.*;

public class JacksonOptions extends Options {

	public final ReferenceSerializer referenceSerializer;
	public final ReferenceDeserializer referenceDeserializer;
	public final IdSerializer idSerializer;
	public final IdDeserializer idDeserializer;
	public final TypeSerializer typeSerializer;
	public final TypeDeserializer typeDeserializer;
	public final DateFormat dateFormat;

	protected JacksonOptions(JacksonOptions.Builder builder) {
		super(builder);

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

	public static final class Builder extends Options.Builder {

		protected ReferenceSerializer referenceSerializer = new ReferenceAsObjectSerializer();
		protected ReferenceDeserializer referenceDeserializer = new ReferenceAsObjectDeserializer();
		protected IdSerializer idSerializer = new FragmentIdSerializer();
		protected IdDeserializer idDeserializer = new FragmentIdDeserializer();
		protected TypeSerializer typeSerializer = new DefaultTypeSerializer();
		protected TypeDeserializer typeDeserializer = new DefaultTypeDeserializer();
		protected DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		@Override
		public JacksonOptions build(Map<?, ?> options) {
			init(options);
			return new JacksonOptions(this);
		}

		@Override
		public JacksonOptions build() {
			return build(Collections.emptyMap());
		}

		@Override
		protected void init(Map<?, ?> options) {
			super.init(options);

			uriHandler = objectValue(options, OPTION_URI_HANDLER, null);
			referenceSerializer = objectValue(options, OPTION_REF_SERIALIZER, referenceSerializer);
			referenceDeserializer = objectValue(options, OPTION_REF_DESERIALIZER, referenceDeserializer);
			idSerializer = objectValue(options, OPTION_ID_SERIALIZER, idSerializer);
			idDeserializer = objectValue(options, OPTION_ID_DESERIALIZER, idDeserializer);
			dateFormat = objectValue(options, EMFJs.OPTION_DATE_FORMAT, dateFormat);
		}

		@Override
		public Builder withTypes(boolean withTypes) {
			return (Builder) super.withTypes(withTypes);
		}

		@Override
		public Builder withID(boolean withID) {
			return (Builder) super.withID(withID);
		}

		@Override
		public Builder withRoot(EClass root) {
			return (Builder) super.withRoot(root);
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

		public Builder withUriHandler(URIHandler uriHandler) {
			this.uriHandler = uriHandler;
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

	}

}
