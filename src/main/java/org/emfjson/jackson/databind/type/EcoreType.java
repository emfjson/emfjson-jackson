package org.emfjson.jackson.databind.type;

import org.eclipse.emf.ecore.EClassifier;

public interface EcoreType {

	EClassifier eClassifier();

	interface DataType {}
	interface EntryType {}
	interface ReferenceType {}

}
