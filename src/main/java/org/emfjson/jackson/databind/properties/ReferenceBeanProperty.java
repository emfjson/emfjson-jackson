package org.emfjson.jackson.databind.properties;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.databind.type.EcoreType;

public class ReferenceBeanProperty extends BeanProperty.Std {

	private final EObject parent;
	private final EReference reference;

	public ReferenceBeanProperty(EObject parent, EReference reference) {
		super(new PropertyName(reference.getName()),
				EcoreType.construct(parent, reference),
				null,
				new AnnotationMap(),
				null,
				PropertyMetadata.STD_REQUIRED);

		this.parent = parent;
		this.reference = reference;
	}

	public EObject getParent() {
		return parent;
	}

	public EReference getReference() {
		return reference;
	}
}
