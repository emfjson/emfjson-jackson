/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */

package org.emfjson.jackson.databind.property;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;
import static org.emfjson.jackson.annotations.JsonAnnotations.getAliases;
import static org.emfjson.jackson.annotations.JsonAnnotations.getElementName;
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
				buildCache(ctxt);
			}

			EObjectPropertyMap propertyMap = type == null ? null: cache.get(type);

			if (propertyMap == null) {
				propertyMap = createPropertyMap(ctxt, type);
				if (type != null) {
					cache.put(type, propertyMap);
				}
			}
			return propertyMap;
		}

		private void buildCache(DatabindContext ctxt) {
			ResourceSet resourceSet = EMFContext.getResourceSet(ctxt);

			Set<EClass> types = resourceSet.getPackageRegistry().values().stream()
					.flatMap(model -> stream(spliteratorUnknownSize(((EPackage) model).eAllContents(), ORDERED), false))
					.filter(e -> e instanceof EClass)
					.map(e -> (EClass) e)
					.collect(Collectors.toSet());

			types.forEach(type -> cache.put(type, construct(ctxt, type)));
		}

		private EObjectPropertyMap createPropertyMap(DatabindContext ctxt, EClass type) {
			EcoreTypeFactory factory = EMFContext.getTypeFactory(ctxt);
			HashMap<String, EObjectProperty> propertiesMap = new HashMap<>();
			Set<EObjectProperty> properties = new LinkedHashSet<>();

			Consumer<EObjectProperty> add = p -> {
				properties.add(p);
				propertiesMap.put(p.getFieldName(), p);
			};

			add.accept(new EObjectReferenceProperty(referenceInfo));
			add.accept(getTypeProperty(type, features));

			if (OPTION_USE_ID.enabledIn(features)) {
				add.accept(new EObjectIdentityProperty(identityInfo));
			}

			if (type != null) {
				for (EStructuralFeature feature : type.getEAllStructuralFeatures()) {
					createFeatureProperty(ctxt, factory, type, feature).ifPresent(property -> {
						add.accept(property);

						for (String alias : getAliases(feature)) {
							propertiesMap.put(alias, property);
						}
					});
				}

				for (EOperation operation : type.getEAllOperations()) {
					EAnnotation annotation = operation.getEAnnotation("JsonProperty");

					if (annotation != null && operation.getEParameters().isEmpty()) {
						add.accept(new EObjectOperationProperty(getElementName(operation), operation));
					}
				}
			}

			return new EObjectPropertyMap(type, propertiesMap, properties);
		}

		private Optional<EObjectFeatureProperty> createFeatureProperty(DatabindContext ctxt, EcoreTypeFactory factory,
		                                                               EClass type, EStructuralFeature feature) {
			if (isCandidate(feature)) {
				JavaType javaType = factory.typeOf(ctxt, type, feature);
				if (javaType != null) {
					return Optional.of(new EObjectFeatureProperty(feature, javaType, features));
				}
			}

			return Optional.empty();
		}

		boolean isFeatureMapEntry(EStructuralFeature feature) {
			EAnnotation annotation = feature.getEAnnotation(ExtendedMetaData.ANNOTATION_URI);

			return annotation != null && annotation.getDetails().containsKey("group");
		}

		boolean isCandidate(EStructuralFeature feature) {
			if (feature instanceof EAttribute) {
				return isCandidate((EAttribute) feature);
			} else {
				return isCandidate((EReference) feature);
			}
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

		private EObjectProperty getTypeProperty(EClass type, int features) {
			EcoreTypeInfo currentTypeInfo = null;

			if (type != null && !JsonAnnotations.shouldIgnoreType(type)) {
				currentTypeInfo = JsonAnnotations.getTypeProperty(type);
			}

			if (currentTypeInfo == null) {
				currentTypeInfo = typeInfo;
			}

			return new EObjectTypeProperty(currentTypeInfo, features);
		}

		public EObjectPropertyMap constructDefault(DatabindContext ctxt) {
			return construct(ctxt, null);
		}

		public EObjectPropertyMap find(DeserializationContext ctxt, EClass defaultType, Iterator<String> fields) {
			List<EClass> types = EMFContext.allSubTypes(ctxt, defaultType);
			Map<String, EClass> properties = new HashMap<>();
			for (EClass type : types) {
				EObjectProperty p = getTypeProperty(type, features);
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

	private final Map<String, EObjectProperty> propertiesMap;
	private final Set<EObjectProperty> properties;
	private final EClass type;

	private EObjectTypeProperty typeProperty;

	private EObjectPropertyMap(EClass type, Map<String, EObjectProperty> propertiesMap, Set<EObjectProperty> properties) {
		this.type = type;
		this.propertiesMap = propertiesMap;
		this.properties = properties;
	}

	public EObjectProperty findProperty(String field) {
		return propertiesMap.get(field);
	}

	public Iterable<EObjectProperty> getProperties() {
		return properties;
	}

	public EObjectTypeProperty getTypeProperty() {
		if (typeProperty == null) {
			for (EObjectProperty property : properties) {
				if (property instanceof EObjectTypeProperty) {
					typeProperty = (EObjectTypeProperty) property;
				}
			}
		}
		return typeProperty;
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
