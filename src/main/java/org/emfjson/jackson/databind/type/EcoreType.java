package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import java.util.Collection;

public class EcoreType {

	public static JavaType construct(EObject object) {
		return SimpleType.construct(object.getClass());
	}

	public static JavaType construct(EReference reference) {
		return construct(Collection.class, reference);
	}

	public static JavaType construct(Class<?> rawClass, EReference reference) {
		EClass type = reference.getEReferenceType();
		Class<?> instanceClass;
		if (type.getInstanceClass() != null) {
			instanceClass = type.getInstanceClass();
		} else {
			instanceClass = EObject.class;
		}

		return reference.isMany() ?
				CollectionType.construct(rawClass, SimpleType.construct(instanceClass)):
				SimpleType.construct(instanceClass);
	}
}
