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

package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
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

	public JavaType typeOf(DatabindContext ctxt, EClass type, EStructuralFeature feature) {
		Pair<EClass, EStructuralFeature> pair = Pair.of(type, feature);

		if (cache.containsKey(pair)) {
			return cache.get(pair);
		}

		EGenericType genericType = type.getFeatureType(feature);
		EClassifier realType = genericType.getERawType();

		JavaType javaType;
		if (realType != null) {
			javaType = typeOf(ctxt.getTypeFactory(), FeatureKind.get(feature), realType);
		} else {
			javaType = null;
		}

		if (javaType != null) {
			cache.put(pair, javaType);
		}

		return javaType;
	}

	private JavaType typeOf(TypeFactory factory, FeatureKind kind, EClassifier type) {
		switch (kind) {
			case SINGLE_ATTRIBUTE:
			case SINGLE_CONTAINMENT:
				return constructSimpleType(factory, type);
			case SINGLE_REFERENCE:
				return constructReferenceType(factory, type);
			case MANY_ATTRIBUTE:
			case MANY_CONTAINMENT:
				return constructCollectionType(factory, constructSimpleType(factory, type));
			case MANY_REFERENCE:
				return constructCollectionType(factory, constructReferenceType(factory, type));
			case MAP:
				return constructMapType(factory, (EClass) type);
			default:
				return constructSimpleType(factory, type);
		}
	}

	JavaType constructSimpleType(TypeFactory factory, EClassifier type) {
		return factory.constructType(rawType(type));
	}

	JavaType constructReferenceType(TypeFactory factory, EClassifier type) {
		Class<?> rawType = rawType(type);

		return factory.constructReferenceType(rawType, factory.constructType(EcoreType.ReferenceType.class));
	}

	JavaType constructCollectionType(TypeFactory factory, JavaType type) {
		return factory.constructCollectionType(Collection.class, type);
	}

	JavaType constructMapType(TypeFactory factory, EClass type) {
		EStructuralFeature key = type.getEStructuralFeature("key");
		EStructuralFeature value = type.getEStructuralFeature("value");

		if (key == null || value == null) {
			return null;
		}

		EClassifier keyType = key.getEType();
		EClassifier valueType = value.getEType();

		Class<?> keyClass = rawType(keyType);
		if (String.class.isAssignableFrom(keyClass)) {
			return factory.constructMapLikeType(EMap.class, keyClass, rawType(valueType));
		} else {
			return factory.constructCollectionType(Collection.class, factory.constructType(EObject.class));
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
