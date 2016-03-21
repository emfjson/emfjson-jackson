package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.emfjson.common.ReferenceEntries.ReferenceEntry;

import java.util.Collection;
import java.util.Map;

public class EcoreType {

	public interface DataType {
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
		final TypeFactory factory = TypeFactory.defaultInstance();
		final EDataType dataType = (EDataType) owner.eClass().getFeatureType(attribute).getEClassifier();
		Class<?> rawType = dataType.getInstanceClass();

		if (rawType == null || dataType == EcorePackage.Literals.EJAVA_CLASS || dataType == EcorePackage.Literals.EJAVA_OBJECT) {
			rawType = DataType.class;
		}

		return attribute.isMany() ?
				factory.constructCollectionLikeType(Collection.class, rawType):
				factory.constructSimpleType(rawType, null);
	}

	private static JavaType constructReference(EReference reference) {
		final TypeFactory factory = TypeFactory.defaultInstance();

		return reference.isMany() ?
				factory.constructCollectionLikeType(EList.class, ReferenceEntry.class):
				factory.constructSimpleType(ReferenceEntry.class, null);
	}

	private static JavaType constructContainment(EObject owner, EReference reference) {
		final EClass eType = (EClass) owner.eClass().getFeatureType(reference).getEClassifier();
		Class<?> rawType = eType.getInstanceClass() == null ? EObject.class: eType.getInstanceClass();

		if ("java.util.Map$Entry".equals(eType.getInstanceClassName()) ||
				"java.util.Map.Entry".equals(eType.getInstanceClassName())) {

			final EStructuralFeature key = eType.getEStructuralFeature("key");
			if (!"java.lang.String".equals(key.getEType().getInstanceClassName())) {
				rawType = EObject.class;
			} else {
				rawType = Map.Entry.class;
			}
		}

		final TypeFactory factory = TypeFactory.defaultInstance();

		return reference.isMany() ?
				factory.constructCollectionLikeType(EList.class, rawType):
				factory.constructSimpleType(rawType, null);
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
