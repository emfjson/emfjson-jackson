package org.emfjson.jackson.databind.ser.collections;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.EList;

import java.io.IOException;
import java.util.Map;

public class EMapSerializer extends JsonSerializer<EList<Map.Entry<?, ?>>> {

	@Override
	public void serialize(EList<Map.Entry<?, ?>> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		JsonSerializer<Object> serializer;

		gen.writeStartArray();
		for (Map.Entry<?, ?> entry : value) {
			gen.writeStartObject();

			serializer = serializers.findValueSerializer(entry.getKey().getClass());
			gen.writeFieldName("key");
			serializer.serialize(entry.getKey(), gen, serializers);

			serializers.findValueSerializer(entry.getValue().getClass());
			gen.writeFieldName("value");
			serializer.serialize(entry.getValue(), gen, serializers);
			gen.writeEndObject();
		}
		gen.writeEndArray();
	}

}
