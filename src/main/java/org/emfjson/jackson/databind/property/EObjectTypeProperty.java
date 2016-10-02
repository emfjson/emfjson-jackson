package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;
import org.emfjson.jackson.annotations.EcoreTypeInfo;

import java.io.IOException;

public class EObjectTypeProperty extends EObjectProperty {

	private final JsonSerializer<Object> serializer = new StringSerializer();
	private final JsonDeserializer<String> deserializer = StringDeserializer.instance;

	private final ValueReader<String, EClass> valueReader;
	private final ValueWriter<EClass, String> valueWriter;

	public EObjectTypeProperty(EcoreTypeInfo info) {
		super(info.getProperty());

		this.valueReader = info.getValueReader();
		this.valueWriter = info.getValueWriter();
	}

	@Override
	public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
		String value = valueWriter.writeValue(bean.eClass(), provider);

		jg.writeFieldName(getFieldName());
		serializer.serialize(value, jg, provider);
	}

	@Override
	public EObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {
			jp.nextToken();
		}

		final String value = deserializer.deserialize(jp, ctxt);
		final EClass eClass = valueReader.readValue(value, ctxt);

		return eClass != null ? EcoreUtil.create(eClass): null;
	}

	@Override
	public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource) throws IOException {
		// do nothing
	}

}
