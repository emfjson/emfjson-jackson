package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.databind.JavaType;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.annotations.JsonAnnotations;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.databind.type.EcoreTypeFactory;
import org.emfjson.jackson.module.EMFModule;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.emfjson.jackson.annotations.JsonAnnotations.getElementName;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_ID;
import static org.emfjson.jackson.module.EMFModule.Feature.OPTION_SERIALIZE_TYPE;

public class EObjectPropertyMap {

	public static class Builder {

		private final EcoreTypeFactory factory = new EcoreTypeFactory();

		EcoreIdentityInfo identityInfo;
		EcoreTypeInfo typeInfo;
		EcoreReferenceInfo referenceInfo;
		int features;

		public Builder(EcoreIdentityInfo identityInfo, EcoreTypeInfo typeInfo, EcoreReferenceInfo referenceInfo, int features) {
			this.identityInfo = identityInfo;
			this.typeInfo = typeInfo;
			this.referenceInfo = referenceInfo;
			this.features = features;
		}

		public static Builder from(EMFModule module, int features) {
			return new Builder(module.getIdentityInfo(), module.getTypeInfo(), module.getReferenceInfo(), features);
		}

		public EObjectPropertyMap construct(EcoreType type) {
			return new EObjectPropertyMap(this, (EClass) type.eClassifier(), collectProperties((EClass) type.eClassifier()));
		}

		public EObjectPropertyMap construct(EClass type) {
			return new EObjectPropertyMap(this, type, collectProperties(type));
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

		protected Map<String, EObjectProperty> collectProperties(EClass type) {
			final Map<String, EObjectProperty> properties = new LinkedHashMap<>();

			if (OPTION_SERIALIZE_ID.enabledIn(features)) {
				properties.put(
						identityInfo.getProperty(),
						new EObjectIdentityProperty(
								identityInfo.getProperty(),
								identityInfo.getSerializer(),
								identityInfo.getDeserializer()));
			}

			if (OPTION_SERIALIZE_TYPE.enabledIn(features)) {
				properties.put(
						typeInfo.getProperty(),
						new EObjectTypeProperty(
								typeInfo.getProperty(),
								typeInfo.getSerializer(),
								typeInfo.getDeserializer()));
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
//						System.out.println(reference.getName() + " " + javaType);
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
			return construct((EClass) null);
		}
	}

	private final Builder builder;
	private final Map<String, EObjectProperty> properties;
	private EClass type;

	EObjectPropertyMap(Builder builder, EClass type, Map<String, EObjectProperty> properties) {
		this.builder = builder;
		this.type = type;
		this.properties = properties;
	}

	public EObjectProperty findProperty(String field) {
		return properties.get(field);
	}

	public void update(EClass eClass) {
		if (eClass != type) {
			type = eClass;
			properties.putAll(builder.collectProperties(eClass));
		}
	}

	public Iterable<EObjectProperty> getProperties() {
		return properties.values();
	}

}
