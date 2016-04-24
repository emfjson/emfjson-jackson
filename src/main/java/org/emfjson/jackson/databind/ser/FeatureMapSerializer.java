package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.internal.Cache;
import org.emfjson.jackson.internal.ContextUtils;
import org.emfjson.jackson.databind.type.EcoreType;

import java.io.IOException;
import java.util.Set;

import static org.emfjson.jackson.internal.EObjects.featureMaps;

public class FeatureMapSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		final Cache cache = ContextUtils.getCache(serializers);
		final EcoreType typeFactory = ContextUtils.getEcoreType(serializers);

		final EObject parent = ContextUtils.get(EObject.class, "parent", serializers);
		final EAttribute attribute = ContextUtils.get(EAttribute.class, "feature", serializers);

		final Set<EStructuralFeature> features = featureMaps(parent, attribute);

		for (EStructuralFeature feature : features) {
			final Object realValue = parent.eGet(feature);
			final String key = cache.getKey(feature);

			JavaType type = typeFactory.construct(parent, feature);
			if (type != null) {
				JsonSerializer<Object> serializer = serializers.findValueSerializer(type);

				if (serializer != null) {

					serializers.setAttribute("parent", parent);
					serializers.setAttribute("feature", feature);

					gen.writeFieldName(key);
					serializer.serialize(realValue, gen, serializers);
				}
			}
		}
	}

}
