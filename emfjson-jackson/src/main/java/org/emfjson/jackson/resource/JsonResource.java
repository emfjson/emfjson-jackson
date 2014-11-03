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
package org.emfjson.jackson.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emfjson.common.Options;
import org.emfjson.jackson.streaming.StreamReader;
import org.emfjson.jackson.streaming.StreamWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

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

	public void configure(StreamWriter writer) {}

	public void configure(StreamReader reader) {}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (inputStream instanceof URIConverter.Loadable) {
			((URIConverter.Loadable) inputStream).loadResource(this);
		} else {
			StreamReader reader = new StreamReader(Options.from(options).build());
			configure(reader);

			JsonFactory factory = new JsonFactory();
			reader.parse(this, factory.createParser(inputStream));
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
			StreamWriter writer = new StreamWriter(Options.from(options).build());
			configure(writer);

			JsonFactory factory = new JsonFactory();
			JsonGenerator generator = factory.createGenerator(outputStream);
			writer.generate(generator, this);
			generator.close();
		}
	}

}
