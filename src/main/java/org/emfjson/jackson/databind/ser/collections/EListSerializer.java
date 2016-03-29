package org.emfjson.jackson.databind.ser.collections;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.common.ELists;
import org.emfjson.jackson.common.EObjects;
import org.emfjson.jackson.databind.ser.references.ReferenceSerializer;
import org.emfjson.jackson.databind.type.EcoreType;

import java.io.IOException;

public class EListSerializer extends JsonSerializer<EList<?>> {

	private final ReferenceSerializer refSerializer;

	public EListSerializer(ReferenceSerializer refSerializer) {
		this.refSerializer = refSerializer;
	}

	@Override
	public void serialize(EList<?> values, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		jg.writeStartArray();

		if (values != null) {
			EObject container = ELists.getEObject(values);
			EStructuralFeature feature = ELists.getFeature(values);

			for (Object value : values) {
				if (isReference(container, feature, value)) {
					refSerializer.serialize((EObject) value, jg, serializers);
				} else {
					JavaType type = EcoreType.constructSimple(container, value, feature);
					JsonSerializer<Object> serializer = serializers.findValueSerializer(type);

					if (serializer != null) {
						serializers.setAttribute("parent", container);
						serializers.setAttribute("feature", feature);

						serializer.serialize(value, jg, serializers);
					}
				}
			}
		}

		jg.writeEndArray();
	}

	protected boolean isReference(EObject container, EStructuralFeature feature, Object value) {
		if (value instanceof EObject && feature instanceof EReference) {
			EObject eObject = (EObject) value;
			EReference reference = (EReference) feature;

			return eObject.eIsProxy() || !reference.isContainment() || EObjects.isContainmentProxy(container, eObject);
		}

		return false;
	}

}
