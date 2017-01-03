package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.databind.JavaType;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.annotations.JsonAnnotations;
import org.emfjson.jackson.databind.type.EcoreTypeFactory;
import org.emfjson.jackson.module.EMFModule;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import static org.emfjson.jackson.annotations.JsonAnnotations.getElementName;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_TYPE;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_USE_ID;

public class EObjectPropertyMap {

	public static class Builder {

		private final EcoreTypeFactory factory = new EcoreTypeFactory();
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

		public EObjectPropertyMap construct(EClass type) {
			if (type == null) {
				return new EObjectPropertyMap(null, collectProperties(null));
			}

			EObjectPropertyMap propertyMap = cache.get(type);
			if (propertyMap == null) {
				cache.put(type, propertyMap = new EObjectPropertyMap(type, collectProperties(type)));
			}
			return propertyMap;
		}

		protected boolean isFeatureMapEntry(EStructuralFeature feature) {
			EAnnotation annotation = feature.getEAnnotation(ExtendedMetaData.ANNOTATION_URI);

			return annotation != null && annotation.getDetails().containsKey("group");
		}

		protected boolean isCandidate(EAttribute attribute) {
			return isFeatureMapEntry(attribute) || (
					!FeatureMapUtil.isFeatureMap(attribute) &&
							!(attribute.isDerived() || attribute.isTransient()) &&
							!JsonAnnotations.shouldIgnore(attribute));
		}

		protected boolean isCandidate(EReference eReference) {
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

		protected Map<String, EObjectProperty> collectProperties(final EClass type) {
			final Map<String, EObjectProperty> properties = new LinkedHashMap<>();

			if (OPTION_USE_ID.enabledIn(features)) {
				properties.put(identityInfo.getProperty(), new EObjectIdentityProperty(identityInfo));
			}

			if (OPTION_SERIALIZE_TYPE.enabledIn(features)) {
				properties.put(typeInfo.getProperty(), new EObjectTypeProperty(typeInfo));
			}

			properties.put(referenceInfo.getProperty(), new EObjectReferenceProperty(referenceInfo));

			if (type != null) {
				for (EAttribute attribute : type.getEAllAttributes()) {
					if (isCandidate(attribute)) {
						JavaType javaType = factory.typeOf(type, attribute);
						if (javaType != null) {
							properties.put(getElementName(attribute), new EObjectFeatureProperty(attribute, javaType, features));
						}
					}
				}

				for (EReference reference : type.getEAllReferences()) {
					if (isCandidate(reference)) {
						JavaType javaType = factory.typeOf(type, reference);
						if (javaType != null) {
							properties.put(getElementName(reference), new EObjectFeatureProperty(reference, javaType, features));
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

		public EObjectPropertyMap constructDefault() {
			return construct(null);
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
