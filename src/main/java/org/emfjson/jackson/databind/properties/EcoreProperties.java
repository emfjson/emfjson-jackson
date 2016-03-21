package org.emfjson.jackson.databind.properties;

import com.fasterxml.jackson.databind.BeanProperty;
import org.eclipse.emf.ecore.*;

public class EcoreProperties {

	public static BeanProperty create(EObject object, EStructuralFeature feature) {
		if (feature instanceof EReference) {

			if (((EReference) feature).isContainment()) {

				return new ContainmentBeanProperty(object, (EReference) feature);

			} else {

				return new ReferenceBeanProperty(object, (EReference) feature);

			}

		} else {

			final EClassifier eType = object.eClass().getFeatureType(feature).getEClassifier();

			if (eType instanceof EEnum ||
					EcorePackage.Literals.EJAVA_CLASS.equals(eType) ||
					EcorePackage.Literals.EJAVA_OBJECT.equals(eType)) {

				return new EDataTypeProperty(object, feature, eType);

			} else {

				return null;

			}
		}
	}

}
