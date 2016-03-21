package org.emfjson.jackson.databind.properties;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.databind.type.EcoreType;

public class EDataTypeProperty extends BeanProperty.Std {

	private final EClassifier eType;

	public EDataTypeProperty(EObject object, EStructuralFeature feature, EClassifier eType) {
		super(new PropertyName(feature.getName()),
				EcoreType.construct(object, feature),
				null,
				new AnnotationMap(),
				null,
				PropertyMetadata.STD_REQUIRED);

		this.eType = eType;
	}

	public EClassifier getEType() {
		return eType;
	}
}
