/**
 */
package org.eclipselabs.emfjson.junit.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.TargetObject#getArrayAttribute <em>Array Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getTargetObject()
 * @model
 * @generated
 */
public interface TargetObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Single Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Attribute</em>' attribute.
	 * @see #setSingleAttribute(String)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getTargetObject_SingleAttribute()
	 * @model
	 * @generated
	 */
	String getSingleAttribute();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Attribute</em>' attribute.
	 * @see #getSingleAttribute()
	 * @generated
	 */
	void setSingleAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Array Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Attribute</em>' attribute list.
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getTargetObject_ArrayAttribute()
	 * @model
	 * @generated
	 */
	EList<String> getArrayAttribute();

} // TargetObject
