package org.emfjson.gwt.map;

import static com.google.gwt.json.client.JSONParser.parseStrict;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.common.Options;
import org.emfjson.gwt.common.StreamHelper;

import com.google.gwt.json.client.JSONValue;

public class JsonMapper {

	public void parse(Resource resource, String content, Map<?, ?> options, Callback<Resource> callback) {
		parse(resource, parseStrict(content), options, callback);
	}

	public void parse(Resource resource, InputStream inputStream, Map<?, ?> options, Callback<Resource> callback) {
		parse(resource, StreamHelper.toString(inputStream), options, callback);
	}

	public void parse(Resource resource, JSONValue value, Map<?, ?> options, Callback<Resource> callback) {
		if (resource == null || value == null || callback == null) return;

		final JsonReader reader = new JsonReader(resource, Options.from(options).build());
		reader.parse(value, callback);
	}

	public JSONValue write(Resource resource, Map<?, ?> options) {
		if (resource == null) return null;

		final JsonWriter writer = new JsonWriter(resource, Options.from(options).build());
		return writer.toValue();
	}

	public void write(Resource resource, OutputStream stream, Map<?, ?> options) {
		final JSONValue value = write(resource, options);

		if (value != null) {
			String stringValue = value.toString();
			try {
				stream.write(stringValue.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
