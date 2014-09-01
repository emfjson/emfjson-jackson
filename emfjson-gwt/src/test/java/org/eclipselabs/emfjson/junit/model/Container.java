/**
 */
package org.eclipselabs.emfjson.junit.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.Container#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emfjson.junit.model.AbstractType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getContainer_Elements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractType> getElements();

} // Container
