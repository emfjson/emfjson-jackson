package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.*;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import static org.eclipse.emf.ecore.EcorePackage.Literals.EJAVA_CLASS;
import static org.eclipse.emf.ecore.EcorePackage.Literals.EJAVA_OBJECT;

public class EcoreTypeFactory {

	private final TypeFactory typeFactory = TypeFactory.defaultInstance();
	private final Map<Pair<EClass, EStructuralFeature>, JavaType> cache = new WeakHashMap<>();

	private static class Pair<A, B> {
		final A _1;
		final B _2;

		Pair(A _1, B _2) {
			this._1 = _1;
			this._2 = _2;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair<?, ?> pair = (Pair<?, ?>) o;
			return Objects.equals(_1, pair._1) &&
					Objects.equals(_2, pair._2);
		}

		@Override
		public int hashCode() {
			return Objects.hash(_1, _2);
		}

		public static <A, B> Pair<A, B> of(A _1, B _2) {
			return new Pair<>(_1, _2);
		}
	}

	public JavaType typeOf(EClass type, EStructuralFeature feature) {
		Pair<EClass, EStructuralFeature> pair = Pair.of(type, feature);

		if (cache.containsKey(pair)) {
			return cache.get(pair);
		}

		EGenericType genericType = type.getFeatureType(feature);
		EClassifier realType = genericType.getEClassifier();

		JavaType javaType;
		if (realType != null) {
			javaType = typeOf(FeatureKind.get(feature), realType);
		} else {
			javaType = null;
		}

		if (javaType != null) {
			cache.put(pair, javaType);
		}

		return javaType;
	}

	protected JavaType typeOf(FeatureKind kind, EClassifier type) {
		switch (kind) {
			case SINGLE_ATTRIBUTE:
			case SINGLE_CONTAINMENT:
				return constructSimpleType(type);
			case SINGLE_REFERENCE:
				return constructReferenceType(type);
			case MANY_ATTRIBUTE:
			case MANY_CONTAINMENT:
				return constructCollectionType(constructSimpleType(type));
			case MANY_REFERENCE:
				return constructCollectionType(constructReferenceType(type));
			case MAP:
				return constructMapType((EClass) type);
			default:
				return constructSimpleType(type);
		}
	}

	public JavaType constructSimpleType(EClassifier type) {
//		return new EcoreSimpleType(type, rawType(type));
		return SimpleType.construct(rawType(type));
	}

	public JavaType constructReferenceType(EClassifier type) {
		Class<?> rawType = rawType(type);

//		return new EcoreReferenceType(type, rawType, typeFactory.constructType(EcoreType.ReferenceType.class));
		return typeFactory.constructReferenceType(rawType, typeFactory.constructType(EcoreType.ReferenceType.class));
	}

	public JavaType constructCollectionType(JavaType type) {
		return typeFactory.constructCollectionType(Collection.class, type);
	}

	public JavaType constructMapType(EClass type) {
		final EStructuralFeature key = type.getEStructuralFeature("key");
		final EStructuralFeature value = type.getEStructuralFeature("value");

		if (key == null || value == null) {
			return null;
		}

		EClassifier keyType = key.getEType();
		EClassifier valueType = value.getEType();

		Class<?> keyClass = rawType(keyType);
		if (String.class.isAssignableFrom(keyClass)) {
			return typeFactory.constructMapLikeType(EMap.class, keyClass, rawType(valueType));
		} else {
			return typeFactory.constructCollectionType(Collection.class,
					typeFactory.constructType(EObject.class));
		}
	}

	private Class<?> rawType(EClassifier classifier) {
		Class<?> rawType = classifier.getInstanceClass();

		if (classifier instanceof EDataType) {
			if (rawType == null || classifier == EJAVA_CLASS || classifier == EJAVA_OBJECT) {
				rawType = EcoreType.DataType.class;
			} else {
				// handle e.g. EByteArray byte[]
				if (rawType.isArray()) {
					rawType = EcoreType.DataType.class;
				}
			}
		} else if (rawType == null) {
			rawType = EObject.class;
		}

		return rawType;
	}

}
