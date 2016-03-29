package org.emfjson.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.common.Cache;
import org.emfjson.jackson.common.ContextUtils;
import org.emfjson.jackson.databind.type.EcoreType;

import java.io.IOException;
import java.util.Set;

import static org.emfjson.jackson.common.EObjects.featureMaps;

public class FeatureMapSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		final EObject parent = ContextUtils.get(EObject.class, "parent", serializers);
		final EAttribute attribute = ContextUtils.get(EAttribute.class, "feature", serializers);
		final Cache cache = ContextUtils.get(Cache.class, "cache", serializers);
		final Set<EStructuralFeature> features = featureMaps(parent, attribute);

		for (EStructuralFeature feature : features) {
			final Object realValue = parent.eGet(feature);
			final String key = cache.getKey(feature);

			JavaType type = EcoreType.construct(parent, feature);
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
