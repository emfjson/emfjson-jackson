package org.emfjson.jackson.databind.deser.collections;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.internal.EObjects;

import java.io.IOException;
import java.util.Map;

import static org.emfjson.jackson.internal.ContextUtils.get;

public class EMapDeserializer extends JsonDeserializer<EList<Map.Entry<?, ?>>> {

	@Override
	public EList<Map.Entry<?, ?>> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public EList<Map.Entry<?, ?>> deserialize(JsonParser jp, DeserializationContext ctxt, EList<Map.Entry<?, ?>> intoValue) throws IOException {
		final EReference reference = get(EReference.class, "reference", ctxt);
		if (jp.getCurrentToken() == JsonToken.START_OBJECT) {

			while (jp.nextToken() != JsonToken.END_OBJECT) {
				final String key = jp.getCurrentName();
				jp.nextToken();

				final Object value;
				if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
					value = ctxt.readValue(jp, EObject.class);
				} else {
					value = ctxt.readValue(jp, Object.class);
				}

				// Dynamic objects do not use the EMap interface
				// but store entries in a DynamicEList instead.
				if (intoValue instanceof EMap) {
					((EMap) intoValue).put(key, value);
				} else if (reference != null) {
					intoValue.add((Map.Entry<?, ?>) EObjects.createEntry(key, value, reference.getEReferenceType()));
				}
			}
		}

		return intoValue;
	}

}
