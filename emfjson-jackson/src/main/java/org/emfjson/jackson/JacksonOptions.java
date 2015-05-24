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

import org.emfjson.common.Options;
import org.emfjson.jackson.databind.deser.FragmentIdDeserializer;
import org.emfjson.jackson.databind.deser.IdDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer;
import org.emfjson.jackson.databind.deser.references.ReferenceDeserializer;
import org.emfjson.jackson.databind.ser.FragmentIdSerializer;
import org.emfjson.jackson.databind.ser.IdSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceAsObjectSerializer;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.emfjson.jackson.handlers.BaseURIHandler;

import java.util.Collections;
import java.util.Map;

import static org.emfjson.EMFJs.*;

public class JacksonOptions extends Options {

	public final ReferenceSerializer referenceSerializer;
	public final ReferenceDeserializer referenceDeserializer;
	public final IdSerializer idSerializer;
	public final IdDeserializer idDeserializer;

	protected JacksonOptions(JacksonOptions.Builder builder) {
		super(builder);

		this.referenceSerializer = builder.referenceSerializer;
		this.referenceDeserializer = builder.referenceDeserializer;
		this.idSerializer = builder.idSerializer;
		this.idDeserializer = builder.idDeserializer;
	}

	public static JacksonOptions from(Map<?, ?> options) {
		return new Builder().build(options);
	}

	public static final class Builder extends Options.Builder {

		protected ReferenceSerializer referenceSerializer = new ReferenceAsObjectSerializer();
		protected ReferenceDeserializer referenceDeserializer = new ReferenceAsObjectDeserializer();
		protected IdSerializer idSerializer = new FragmentIdSerializer();
		protected IdDeserializer idDeserializer = new FragmentIdDeserializer();

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

			uriHandler = objectValue(options, OPTION_URI_HANDLER, new BaseURIHandler());
			referenceSerializer = objectValue(options, OPTION_REF_SERIALIZER, referenceSerializer);
			referenceDeserializer = objectValue(options, OPTION_REF_DESERIALIZER, referenceDeserializer);
			idSerializer = objectValue(options, OPTION_ID_SERIALIZER, idSerializer);
			idDeserializer = objectValue(options, OPTION_ID_DESERIALIZER, idDeserializer);
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

	}

}
