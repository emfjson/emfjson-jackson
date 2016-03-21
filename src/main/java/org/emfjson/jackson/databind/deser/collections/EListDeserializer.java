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
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.common.ReferenceEntries;
import org.emfjson.jackson.common.ContextUtils;
import org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer;
import org.emfjson.jackson.databind.type.EcoreType;

import java.io.IOException;

public class EListDeserializer extends JsonDeserializer<EList<EObject>> {

	ReferenceAsObjectDeserializer dd = new ReferenceAsObjectDeserializer();

	@Override
	public EList<EObject> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		EStructuralFeature feature = ContextUtils.get(EReference.class, "reference", ctxt);
		EObject container = ContextUtils.get(EObject.class, "parent", ctxt);
		ReferenceEntries entries = ContextUtils.get(ReferenceEntries.class, "entries", ctxt);

		while (jp.nextToken() != JsonToken.END_ARRAY) {
			entries.add(dd.deserialize(jp, container, (EReference) feature, ctxt));
		}

		return null;
	}

	@Override
	public EList<EObject> deserialize(JsonParser jp, DeserializationContext ctxt, EList<EObject> intoValue) throws IOException {
		EStructuralFeature feature = getFeature(intoValue);
		EObject container = getObject(intoValue);

		EcoreType.FeatureKind kind = EcoreType.FeatureKind.get(feature);
		ReferenceEntries entries = (ReferenceEntries) ctxt.getAttribute("entries");

		while (jp.nextToken() != JsonToken.END_ARRAY) {
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
					entries.add(dd.deserialize(jp, container, (EReference) feature, ctxt));
					break;
			}
		}

		return intoValue;
	}

	private EObject getObject(EList<EObject> list) {
		if (list instanceof EcoreEList) {
			return ((EcoreEList) list).getEObject();
		} else if (list instanceof EcoreEMap) {
			return ((EcoreEMap) list).getEObject();
		} else if (list instanceof FeatureMapUtil.FeatureEList) {
			return ((FeatureMapUtil.FeatureEList) list).getEObject();
		}

		return null;
	}

	protected EStructuralFeature getFeature(EList<EObject> list) {
		if (list instanceof EcoreEList) {
			return ((EcoreEList) list).getEStructuralFeature();
		} else if (list instanceof EcoreEMap) {
			return ((EcoreEMap) list).getEStructuralFeature();
		} else if (list instanceof FeatureMapUtil.FeatureEList) {
			return ((FeatureMapUtil.FeatureEList) list).getEStructuralFeature();
		}

		return null;
	}

}
