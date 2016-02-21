package org.emfjson.jackson.databind.properties;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.databind.type.EcoreType;

public class ContainmentBeanProperty extends BeanProperty.Std {

	private final EObject parent;
	private final EReference containment;

	public ContainmentBeanProperty(EObject parent, EReference containment) {
		super(new PropertyName(containment.getName()),
				EcoreType.construct(containment),
				null,
				new AnnotationMap(),
				null,
				PropertyMetadata.STD_REQUIRED);

		this.parent = parent;
		this.containment = containment;
	}

	public EObject getParent() {
		return parent;
	}

	public EReference getContainment() {
		return containment;
	}
}
