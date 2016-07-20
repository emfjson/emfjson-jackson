package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.eclipse.emf.ecore.EClassifier;

import java.util.Objects;

public class EcoreSimpleType extends SimpleType implements EcoreType {

	private final EClassifier eClassifier;

	EcoreSimpleType(EClassifier eClassifier, Class<?> rawType) {
		super(rawType);
		this.eClassifier = eClassifier;
	}

	@Override
	public EClassifier eClassifier() {
		return eClassifier;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		EcoreSimpleType that = (EcoreSimpleType) o;
		return Objects.equals(eClassifier, that.eClassifier);
	}

}
