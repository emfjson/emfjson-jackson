package org.emfjson.jackson.databind.deser.collections;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.SimpleType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.common.ContextUtils;
import org.emfjson.jackson.common.ELists;
import org.emfjson.jackson.common.ReferenceEntries;
import org.emfjson.jackson.databind.type.EcoreType;

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

		// clear context
//		ctxt.setAttribute("parent", new Object());
//		ctxt.setAttribute("reference", new Object());

		while (jp.nextToken() != JsonToken.END_ARRAY) {
			if (entries != null) {
//				ctxt.setAttribute("parent", parent);
//				ctxt.setAttribute("reference", reference);

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

		while (jp.nextToken() != JsonToken.END_ARRAY) {
			// reference deserializer will clear context
//			ctxt.setAttribute("parent", parent);
//			ctxt.setAttribute("reference", feature);

			switch (kind) {
				case CONTAINMENT:
					JsonDeserializer<Object> deserializer =
							ctxt.findRootValueDeserializer(SimpleType.construct(EObject.class));

					ctxt.setAttribute("reference", feature);

					EObject value = (EObject) deserializer.deserialize(jp, ctxt);
					if (value != null) {
						intoValue.add(value);
					}
					break;
				case REFERENCE:
					entries.add(refDeserializer.deserialize(jp, ctxt));
					break;
			}
		}

		return intoValue;
	}

}
