package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emfjson.jackson.common.ReferenceEntries.ReferenceEntry;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EcoreType {

	private static final TypeFactory factory = TypeFactory.defaultInstance();

	public static JavaType constructSimple(EObject owner, Object value, EStructuralFeature feature) {
		if (owner == null) {
			return value == null ?
					factory.constructSimpleType(EObject.class, null):
					factory.constructSimpleType(value.getClass(), null);
		}

		final FeatureKind kind = FeatureKind.get(feature);
		final EClassifier type = owner.eClass().getFeatureType(feature).getEClassifier();
		final Class<?> rawType = type != null ? type.getInstanceClass(): null;

		if (FeatureMapUtil.isFeatureMap(feature)) {
			return factory.constructSimpleType(FeatureMapType.class, null);
		}

		switch (kind) {
			case ATTRIBUTE: {
				if (rawType == null || type == EcorePackage.Literals.EJAVA_CLASS || type == EcorePackage.Literals.EJAVA_OBJECT) {
					return factory.constructSimpleType(DataType.class, null);
				} else {
					return factory.constructSimpleType(rawType, null);
				}
			}
			case REFERENCE:
				return rawType == null ?
						factory.constructReferenceType(EObject.class,
								factory.constructSimpleType(EObject.class, null)):
						factory.constructReferenceType(EObject.class,
								factory.constructSimpleType(rawType, constructTypeParameters(rawType.getTypeParameters())));
			default:
				if (isMap((EClass) type)) {
					return constructEntryType((EClass) type);
				}

				return rawType == null ?
						factory.constructSimpleType(EObject.class, null):
						factory.constructSimpleType(rawType, constructTypeParameters(rawType.getTypeParameters()));
		}
	}

	private static JavaType[] constructTypeParameters(TypeVariable<? extends Class<?>>[] parameters) {
		final List<JavaType> types = new ArrayList<>();
		for (TypeVariable<? extends Class<?>> parameter : parameters) {
			types.add(factory.constructSimpleType(Object.class, null));
		}

		return types.toArray(new JavaType[types.size()]);
	}

	public interface EntryType<K, V> {
	}

	public interface DataType {
	}

	public interface FeatureMapType {
	}

	public static JavaType construct(EObject owner, EStructuralFeature feature) {
		switch (FeatureKind.get(feature)) {
			case ATTRIBUTE:
				return construct(owner, (EAttribute) feature);
			case REFERENCE:
				return constructReference((EReference) feature);
			case CONTAINMENT:
				return constructContainment(owner, (EReference) feature);
			default:
				return null;
		}
	}

	private static JavaType construct(EObject owner, EAttribute attribute) {
		final EDataType dataType = (EDataType) owner.eClass().getFeatureType(attribute).getEClassifier();
		Class<?> rawType = dataType.getInstanceClass();

		if (FeatureMapUtil.isFeatureMap(attribute)) {
			return factory.constructSimpleType(FeatureMapType.class, null);
		}

		if (rawType == null || dataType == EcorePackage.Literals.EJAVA_CLASS ||
				dataType == EcorePackage.Literals.EJAVA_OBJECT) {

			rawType = DataType.class;
		}

		return attribute.isMany() ?
				factory.constructCollectionLikeType(Collection.class, rawType):
				factory.constructSimpleType(rawType, null);
	}

	private static JavaType constructReference(EReference reference) {
		return reference.isMany() ?
				factory.constructCollectionLikeType(EList.class, ReferenceEntry.class):
				factory.constructSimpleType(ReferenceEntry.class, null);
	}

	private static JavaType constructContainment(EObject owner, EReference reference) {
		final EClass eType = (EClass) owner.eClass().getFeatureType(reference).getEClassifier();
		Class<?> rawType = eType.getInstanceClass() == null ? EObject.class: eType.getInstanceClass();

		if (isMap(eType)) {
			return constructMapType(eType);
		}

		return reference.isMany() ?
				factory.constructCollectionLikeType(EList.class, rawType):
				factory.constructSimpleType(rawType, null);
	}

	private static boolean isMap(EClass type) {
		return "java.util.Map$Entry".equals(type.getInstanceClassName()) ||
				"java.util.Map.Entry".equals(type.getInstanceClassName());
	}

	private static JavaType constructMapType(EClass type) {
		EStructuralFeature key = type.getEStructuralFeature("key");
		EStructuralFeature value = type.getEStructuralFeature("value");

		EClassifier keyType = key.getEType();
		EClassifier valueType = value.getEType();

		Class mapClass = EMap.class;
		Class<?> keyClass = keyType.getInstanceClass() == null ?
				EObject.class: keyType.getInstanceClass();
		Class<?> valueClass = valueType.getInstanceClass() == null ?
				EObject.class: valueType.getInstanceClass();

		return factory.constructMapLikeType(mapClass, keyClass, valueClass);
	}

	private static JavaType constructEntryType(EClass type) {
		EStructuralFeature key = type.getEStructuralFeature("key");
		EStructuralFeature value = type.getEStructuralFeature("value");

		EClassifier keyType = key.getEType();
		EClassifier valueType = value.getEType();

		Class<?> keyClass = keyType.getInstanceClass() == null ?
				EObject.class: keyType.getInstanceClass();
		Class<?> valueClass = valueType.getInstanceClass() == null ?
				EObject.class: valueType.getInstanceClass();

		return factory.constructSimpleType(EntryType.class, new JavaType[]{
				factory.constructSimpleType(keyClass, null),
				factory.constructSimpleType(valueClass, null)});
	}

	public enum FeatureKind {
		ATTRIBUTE,
		REFERENCE,
		CONTAINMENT,
		UNKNOWN;

		public static FeatureKind get(EStructuralFeature feature) {
			if (feature == null)
				return UNKNOWN;

			if (feature instanceof EAttribute)
				return ATTRIBUTE;

			return ((EReference) feature).isContainment() ? CONTAINMENT: REFERENCE;
		}
	}
}
