package org.eclipselabs.emfjson.map.streaming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.common.Options;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

public class JacksonStreamMapper {

	public void parse(Resource resource, String content, Map<?, ?> options) throws IOException {
		if (resource == null || content == null) return;

		final JsonFactory factory = new JsonFactory();
		try {
			doParse(factory.createParser(content), resource, options);
		} catch (IOException e) {
			throw e;
		}
	}

	public void parse(Resource resource, InputStream inputStream, Map<?, ?> options) throws IOException {
		if (resource == null || inputStream == null) return;

		final JsonFactory factory = new JsonFactory();
		try {
			doParse(factory.createParser(inputStream), resource, options);
		} catch (IOException e) {
			throw e;
		}
	}

	private void doParse(JsonParser parser, Resource resource, Map<?, ?> options) throws IOException {
		if (parser == null) return;

		final StreamReader reader = new StreamReader(resource, new Options.Builder(options).build());
		try {
			reader.parse(parser);
		} catch (IOException e) {
			throw e;
		}
		try {
			parser.close();
		} catch (IOException e) {
			throw e;
		}
	}

	public void write(Resource resource, OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (resource == null || outputStream == null) return;

		final JsonFactory factory = new JsonFactory();
		try {
			doWrite(factory.createGenerator(outputStream), resource, options);
		} catch (IOException e) {
			throw e;
		}
	}

	private void doWrite(JsonGenerator generator, Resource resource, Map<?, ?> options) throws IOException {
		if (generator == null) return;

		Options ops = new Options.Builder(options).build();
	
		if (ops.indentOutput) {
			DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
			generator.setPrettyPrinter(printer);
		}

		final StreamWriter writer = new StreamWriter(resource.getURI(), ops);
		writer.generate(generator, resource.getContents());
		try {
			generator.close();
		} catch (IOException e) {
			throw e;
		}
	}

}
