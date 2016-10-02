package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.eclipse.emf.ecore.EClassifier;

import java.util.Objects;

public class EcoreReferenceType extends ReferenceType implements EcoreType {

	private final EClassifier classifier;

	EcoreReferenceType(EClassifier classifier, Class<?> rawType, JavaType refType) {
		super(rawType, refType, null, null, false);

		this.classifier = classifier;
	}

	@Override
	public EClassifier eClassifier() {
		return classifier;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		EcoreReferenceType that = (EcoreReferenceType) o;
		return Objects.equals(classifier, that.classifier);
	}

}
