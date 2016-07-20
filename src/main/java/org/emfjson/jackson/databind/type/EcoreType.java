package org.emfjson.jackson.databind.type;

import org.eclipse.emf.ecore.EClassifier;

public interface EcoreType {

	EClassifier eClassifier();

//	interface FeatureMap {}
	interface DataType {}
	interface EntryType {}
	interface ReferenceType {}

}
