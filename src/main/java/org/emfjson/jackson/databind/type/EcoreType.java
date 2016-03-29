package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import java.util.*;

public class EcoreType {

	public interface EntryType<K, V> {
	}

	public interface DataType {
	}

	public interface FeatureMapType {
	}

	private final Map<EClass, Map<EStructuralFeature, JavaType>> mapOfTypes = new HashMap<>();

	private final TypeFactory factory = TypeFactory.defaultInstance();

	public JavaType constructSimple(EObject owner, EStructuralFeature feature) {
		if (owner == null) {
			return factory.constructSimpleType(EObject.class, null);
		}

		JavaType resultType = null;
		if (mapOfTypes.containsKey(owner.eClass())) {
			resultType = mapOfTypes.get(owner.eClass()).get(feature);
		} else {
			mapOfTypes.put(owner.eClass(), new HashMap<EStructuralFeature, JavaType>());
		}

		if (resultType != null) {
			return resultType;
		}

		final FeatureKind kind = FeatureKind.get(feature);
		final EClassifier type = owner.eClass().getFeatureType(feature).getEClassifier();
		final Class<?> rawType = rawType(type);

		switch (kind) {
			case SINGLE_ATTRIBUTE:
			case MANY_ATTRIBUTE:
				resultType = constructAttribute(owner, (EAttribute) feature);
				break;
			case SINGLE_REFERENCE:
			case MANY_REFERENCE:
				resultType = constructReference((EReference) feature);
				break;
			case SINGLE_CONTAINMENT:
			case MANY_CONTAINMENT:
				resultType = constructContainment(owner, (EReference) feature);
				break;
			case FEATURE_MAP:
				resultType = factory.constructSimpleType(FeatureMapType.class, null);
				break;
			case MAP:
				resultType = constructEntryType((EClass) type);
				break;
			default:
				resultType = rawType == null ?
						factory.constructSimpleType(EObject.class, null):
						factory.constructSimpleType(rawType, constructTypeParameters(rawType));
		}

		mapOfTypes.get(owner.eClass()).put(feature, resultType);

		return resultType;
	}

	public JavaType construct(EObject owner, EStructuralFeature feature) {
		final FeatureKind kind = FeatureKind.get(feature);

		if (kind == FeatureKind.MAP) {
			return constructMapType((EClass) feature.getEType());
		}

		final JavaType simpleType = constructSimple(owner, feature);
		if (simpleType.isTypeOrSubTypeOf(FeatureMapType.class)) {
			return simpleType;
		}

		if (feature.isMany()) {
			return factory.constructCollectionType(feature instanceof EReference ?
					EList.class: Collection.class, simpleType);
		} else {
			return simpleType;
		}
	}

	private JavaType constructAttribute(EObject owner, EAttribute attribute) {
		final EDataType dataType = (EDataType) owner.eClass().getFeatureType(attribute).getEClassifier();
		final Class<?> rawType = rawType(dataType);

		return factory.constructSimpleType(rawType, constructTypeParameters(rawType));
	}

	private JavaType constructReference(EReference reference) {
		final EClass type = reference.getEReferenceType();
		final Class<?> rawType = rawType(type);

		return factory.constructReferenceType(rawType,
				factory.constructSimpleType(rawType, constructTypeParameters(rawType)));
	}

	private JavaType constructContainment(EObject owner, EReference reference) {
		final EClass eType = (EClass) owner.eClass().getFeatureType(reference).getEClassifier();
		final Class<?> rawType = rawType(eType);

		return factory.constructSimpleType(rawType,
				constructTypeParameters(rawType));
	}

	private JavaType constructMapType(EClass type) {
		final EStructuralFeature key = type.getEStructuralFeature("key");
		final EStructuralFeature value = type.getEStructuralFeature("value");

		if (key == null || value == null)
			return null;

		EClassifier keyType = key.getEType();
		EClassifier valueType = value.getEType();

		return factory.constructMapLikeType(EMap.class, rawType(keyType), rawType(valueType));
	}

	private JavaType constructEntryType(EClass type) {
		final EStructuralFeature key = type.getEStructuralFeature("key");
		final EStructuralFeature value = type.getEStructuralFeature("value");

		if (key == null || value == null)
			return null;

		EClassifier keyType = key.getEType();
		EClassifier valueType = value.getEType();

		return factory.constructSimpleType(EntryType.class, new JavaType[]{
				factory.constructSimpleType(rawType(keyType), null),
				factory.constructSimpleType(rawType(valueType), null)
		});
	}

	private JavaType[] constructTypeParameters(Class<?> rawType) {
		final List<JavaType> types = new ArrayList<>();
		if (rawType != null && rawType != EObject.class) {
			for (int i = 0; i < rawType.getTypeParameters().length; i++) {
				types.add(factory.constructSimpleType(Object.class, null));
			}
		}

		return types.toArray(new JavaType[types.size()]);
	}

	private Class<?> rawType(EClassifier classifier) {
		Class<?> rawType = classifier.getInstanceClass();

		if (classifier instanceof EDataType) {
			if (rawType == null || classifier == EcorePackage.Literals.EJAVA_CLASS || classifier == EcorePackage.Literals.EJAVA_OBJECT) {
				rawType = DataType.class;
			}
		} else if (rawType == null) {
			rawType = EObject.class;
		}

		return rawType;
	}

	private static boolean isMap(EClassifier type) {
		return "java.util.Map$Entry".equals(type.getInstanceClassName()) ||
				"java.util.Map.Entry".equals(type.getInstanceClassName());
	}

	public enum FeatureKind {
		SINGLE_ATTRIBUTE,
		MANY_ATTRIBUTE,
		SINGLE_REFERENCE,
		MANY_REFERENCE,
		SINGLE_CONTAINMENT,
		MANY_CONTAINMENT,
		FEATURE_MAP,
		MAP,
		UNKNOWN;

		public static FeatureKind get(EStructuralFeature feature) {
			if (feature == null)
				return UNKNOWN;

			if (isMap(feature.getEType()))
				return MAP;

			if (FeatureMapUtil.isFeatureMap(feature))
				return FEATURE_MAP;

			if (feature instanceof EAttribute)
				return feature.isMany() ? MANY_ATTRIBUTE: SINGLE_ATTRIBUTE;

			return ((EReference) feature).isContainment() ?
					feature.isMany() ?
							MANY_CONTAINMENT: SINGLE_CONTAINMENT:
					feature.isMany() ?
							MANY_REFERENCE: SINGLE_REFERENCE;
		}
	}
}
