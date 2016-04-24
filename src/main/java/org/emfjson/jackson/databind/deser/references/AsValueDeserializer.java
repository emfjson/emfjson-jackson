package org.emfjson.jackson.databind.deser.references;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import java.io.IOException;

public class AsValueDeserializer extends EReferenceDeserializer {

	@Override
	public ReferenceEntries.ReferenceEntry deserialize(JsonParser jp, EObject parent, EReference reference, DeserializationContext context) throws IOException {
		String id = null;

		if (JsonToken.VALUE_STRING.equals(jp.getCurrentToken())) {
			id = jp.getText();
		}

		return id == null ? null : new DefaultReferenceEntry(parent, reference, id, null);
	}

}
