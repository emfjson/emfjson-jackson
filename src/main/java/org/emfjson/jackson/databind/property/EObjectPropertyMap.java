package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.annotations.JsonAnnotations;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.databind.type.EcoreTypeFactory;
import org.emfjson.jackson.module.EMFModule;

import java.util.*;

import static org.emfjson.jackson.annotations.JsonAnnotations.getAliasName;
import static org.emfjson.jackson.annotations.JsonAnnotations.getElementName;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_TYPE;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_USE_ID;

public class EObjectPropertyMap {

	public static class Builder {

		private final Map<EClass, EObjectPropertyMap> cache = new WeakHashMap<>();

		private final EcoreIdentityInfo identityInfo;
		private final EcoreTypeInfo typeInfo;
		private final EcoreReferenceInfo referenceInfo;
		private final int features;

		public Builder(EcoreIdentityInfo identityInfo, EcoreTypeInfo typeInfo, EcoreReferenceInfo referenceInfo, int features) {
			this.identityInfo = identityInfo;
			this.typeInfo = typeInfo;
			this.referenceInfo = referenceInfo;
			this.features = features;
		}

		public static Builder from(EMFModule module, int features) {
			return new Builder(module.getIdentityInfo(), module.getTypeInfo(), module.getReferenceInfo(), features);
		}

		public EObjectPropertyMap construct(DatabindContext ctxt, EClass type) {
			if (type == null) {
				return new EObjectPropertyMap(null, collectProperties(ctxt, null));
			}

			EObjectPropertyMap propertyMap = cache.get(type);
			if (propertyMap == null) {
				cache.put(type, propertyMap = new EObjectPropertyMap(type, collectProperties(ctxt, type)));
			}
			return propertyMap;
		}

		boolean isFeatureMapEntry(EStructuralFeature feature) {
			EAnnotation annotation = feature.getEAnnotation(ExtendedMetaData.ANNOTATION_URI);

			return annotation != null && annotation.getDetails().containsKey("group");
		}

		boolean isCandidate(EAttribute attribute) {
			return isFeatureMapEntry(attribute) || (
					!FeatureMapUtil.isFeatureMap(attribute) &&
							!(attribute.isDerived() || attribute.isTransient()) &&
							!JsonAnnotations.shouldIgnore(attribute));
		}

		boolean isCandidate(EReference eReference) {
			if (isFeatureMapEntry(eReference)) {
				return true;
			}
			if (FeatureMapUtil.isFeatureMap(eReference)) {
				return false;
			}
			if (eReference.isTransient() || JsonAnnotations.shouldIgnore(eReference)) {
				return false;
			}

			EReference opposite = eReference.getEOpposite();
			return !(opposite != null && opposite.isContainment());
		}

		Map<String, EObjectProperty> collectProperties(DatabindContext ctxt, EClass type) {
			final EcoreTypeFactory factory = EMFContext.getTypeFactory(ctxt);
			final Map<String, EObjectProperty> properties = new LinkedHashMap<>();

			if (OPTION_USE_ID.enabledIn(features)) {
				properties.put(identityInfo.getProperty(), new EObjectIdentityProperty(identityInfo));
			}

			if (OPTION_SERIALIZE_TYPE.enabledIn(features)) {
				EObjectProperty property = getTypeProperty(type);
				properties.put(property.getFieldName(), property);
			}

			properties.put(referenceInfo.getProperty(), new EObjectReferenceProperty(referenceInfo));

			if (type != null) {
				for (EStructuralFeature feature: type.getEAllStructuralFeatures()) {
					final boolean isCandidate;
					if (feature instanceof EAttribute) {
						isCandidate = isCandidate((EAttribute) feature);
					} else {
						isCandidate = isCandidate((EReference) feature);
					}
					if (isCandidate) {
						JavaType javaType = factory.typeOf(ctxt, type, feature);
						if (javaType != null) {
							final EObjectFeatureProperty featureProperty = new EObjectFeatureProperty(feature, javaType, features);
							properties.put(getElementName(feature), featureProperty);
							final String aliasName = getAliasName(feature);
							if (aliasName != null) {
								properties.put(aliasName, featureProperty);
							}
						}
					}
				}

				for (EOperation operation : type.getEAllOperations()) {
					EAnnotation annotation = operation.getEAnnotation("JsonProperty");
					if (annotation != null && operation.getEParameters().isEmpty()) {
						properties.put(getElementName(operation), new EObjectOperationProperty(getElementName(operation), operation));
					}
				}
			}

			return properties;
		}

		private EObjectProperty getTypeProperty(EClass type) {
			if (type != null && !JsonAnnotations.shouldIgnoreType(type)) {
				String property = JsonAnnotations.getTypeProperty(type);
				if (property != null) {
					return new EObjectTypeProperty(new EcoreTypeInfo(property));
				} else {
					return new EObjectTypeProperty(typeInfo);
				}
			} else {
				return new EObjectTypeProperty(typeInfo);
			}
		}

		public EObjectPropertyMap constructDefault(DatabindContext ctxt) {
			return construct(ctxt, null);
		}

		public EObjectPropertyMap find(DeserializationContext ctxt, EClass defaultType, Iterator<String> fields) {
			List<EClass> types = EMFContext.allSubTypes(ctxt, defaultType);
			Map<String, EClass> properties = new HashMap<>();
			for (EClass type : types) {
				EObjectProperty p = getTypeProperty(type);
				properties.put(p.getFieldName(), type);
			}

			while (fields.hasNext()) {
				String field = fields.next();

				if (properties.containsKey(field)) {
					return construct(ctxt, properties.get(field));
				}
			}

			return construct(ctxt, defaultType);
		}

	}

	private final Map<String, EObjectProperty> properties;
	private final EClass type;

	EObjectPropertyMap(EClass type, Map<String, EObjectProperty> properties) {
		this.type = type;
		this.properties = properties;
	}

	public EObjectProperty findProperty(String field) {
		return properties.get(field);
	}

	public Iterable<EObjectProperty> getProperties() {
		return properties.values();
	}

	public EObjectTypeProperty getTypeProperty() {
		for (EObjectProperty property : properties.values()) {
			if (property instanceof EObjectTypeProperty) {
				return (EObjectTypeProperty) property;
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EObjectPropertyMap that = (EObjectPropertyMap) o;
		return Objects.equals(properties, that.properties) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(properties, type);
	}
}
