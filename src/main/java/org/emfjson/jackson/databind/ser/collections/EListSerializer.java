package org.emfjson.jackson.databind.ser.collections;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.internal.ContextUtils;
import org.emfjson.jackson.internal.ELists;
import org.emfjson.jackson.internal.EObjects;

import java.io.IOException;

public class EListSerializer extends JsonSerializer<EList<?>> {

	@Override
	public void serialize(EList<?> values, JsonGenerator jg, SerializerProvider serializers) throws IOException {
		final EcoreType typeFactory = ContextUtils.getEcoreType(serializers);

		jg.writeStartArray();

		if (values != null) {
			EObject container = ELists.getEObject(values);
			EStructuralFeature feature = ELists.getFeature(values);
			JavaType type = typeFactory.constructSimple(container, feature);
			JsonSerializer<Object> serializer = serializers.findValueSerializer(type);

			if (serializer != null) {
				for (Object value : values) {
					serializers.setAttribute("parent", container);
					serializers.setAttribute("feature", feature);

					serializer.serialize(value, jg, serializers);
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
