package org.emfjson.jackson.databind.deser.references;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import java.io.IOException;

public class AsObjectDeserializer extends EReferenceDeserializer {

	@Override
	public ReferenceEntries.ReferenceEntry deserialize(JsonParser jp, EObject parent, EReference reference, DeserializationContext context) throws IOException {
		String id = null;
		String type = null;

		while (jp.nextToken() != JsonToken.END_OBJECT) {
			final String field = jp.getCurrentName();

			if (field.equalsIgnoreCase(getProperty())) {
				id = jp.nextTextValue();
			} else if (field.equalsIgnoreCase(getPropertyType())) {
				type = jp.nextTextValue();
			}
		}

		return id == null ?
				null:
				new DefaultReferenceEntry(parent, reference, id, type);
	}

}
