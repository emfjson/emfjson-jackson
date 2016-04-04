package org.emfjson.jackson.databind.deser.collections;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.databind.deser.references.ReferenceEntries;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.internal.ContextUtils;
import org.emfjson.jackson.internal.ELists;

import java.io.IOException;

public class EListDeserializer extends JsonDeserializer<EList<EObject>> {

	private final JsonDeserializer<ReferenceEntries.ReferenceEntry> refDeserializer;

	public EListDeserializer(JsonDeserializer<ReferenceEntries.ReferenceEntry> refDeserializer) {
		this.refDeserializer = refDeserializer;
	}

	@Override
	public EList<EObject> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		final ReferenceEntries entries = ContextUtils.get(ReferenceEntries.class, "entries", ctxt);
		final EObject parent = ContextUtils.get(EObject.class, "parent", ctxt);
		final EReference reference = ContextUtils.get(EReference.class, "reference", ctxt);

		while (jp.nextToken() != JsonToken.END_ARRAY) {
			if (entries != null) {
				entries.add(refDeserializer.deserialize(jp, ctxt));
			}
		}

		return null;
	}

	@Override
	public EList<EObject> deserialize(JsonParser jp, DeserializationContext ctxt, EList<EObject> intoValue) throws IOException {
		final EStructuralFeature feature = ELists.getFeature(intoValue);
		final EcoreType.FeatureKind kind = EcoreType.FeatureKind.get(feature);
		final ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");
		final EObject parent = ContextUtils.get(EObject.class, "parent", ctxt);
		final EcoreType typeFactory = ContextUtils.get(EcoreType.class, "typeFactory", ctxt);

		JavaType type = typeFactory.constructSimple(parent, feature);
		JsonDeserializer<Object> deserializer = ctxt.findRootValueDeserializer(type);

		while (jp.nextToken() != JsonToken.END_ARRAY) {
			switch (kind) {
				case MAP:
				case FEATURE_MAP:
				case MANY_ATTRIBUTE:
				case MANY_CONTAINMENT:

					ctxt.setAttribute("reference", feature);

					EObject value = (EObject) deserializer.deserialize(jp, ctxt);
					if (value != null) {
						intoValue.add(value);
					}
					break;
				case MANY_REFERENCE:
					entries.add(refDeserializer.deserialize(jp, ctxt));
					break;
			}
		}

		return intoValue;
	}

}
