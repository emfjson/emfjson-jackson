/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Status#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Status#getReason <em>Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getStatus()
 * @model
 * @generated
 */
public interface Status extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getStatus_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Status#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getStatus_Reason()
	 * @model
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Status#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

} // Status
