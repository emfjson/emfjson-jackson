/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emfjson.EMFJs;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.module.EMFModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

/**
 * A Resource implementation that read and write it's content in JSON.
 */
public class JsonResource extends AbstractUuidResource {

	public JsonResource() {
		super();
	}

	public JsonResource(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (inputStream instanceof URIConverter.Loadable) {

			((URIConverter.Loadable) inputStream).loadResource(this);

		} else {

			final ObjectMapper mapper = new ObjectMapper();
			final JacksonOptions jacksonOptions = getOptions(options);
			mapper.setDateFormat(jacksonOptions.dateFormat);
			mapper.registerModule(new EMFModule(this.getResourceSet(), jacksonOptions));

			ContextAttributes attributes = ContextAttributes
				.getEmpty()
				.withSharedAttribute("resource", this);

			mapper.reader()
				.with(attributes)
				.forType(Resource.class)
				.readValue(inputStream);

		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (outputStream instanceof URIConverter.Saveable) {

			((URIConverter.Saveable) outputStream).saveResource(this);

		} else {

			final ObjectMapper mapper = new ObjectMapper();
			final JacksonOptions jacksonOptions = getOptions(options);
			mapper.setDateFormat(jacksonOptions.dateFormat);
			mapper.configure(SerializationFeature.INDENT_OUTPUT, jacksonOptions.indentOutput);
			mapper.registerModule(new EMFModule(this.getResourceSet(), jacksonOptions));

			outputStream.write(mapper.writeValueAsBytes(this));
		}
	}

	private JacksonOptions getOptions(Map<?, ?> options) {
		if (options.containsKey(EMFJs.OPTIONS_OBJECT)) {
			Object value = options.get(EMFJs.OPTIONS_OBJECT);

			if (value instanceof JacksonOptions) {
				return (JacksonOptions) value;
			}
		}

		return JacksonOptions.from(options);
	}

}
