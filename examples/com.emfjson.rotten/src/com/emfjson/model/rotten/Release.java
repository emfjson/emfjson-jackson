/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.model.rotten;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.Release#getTheater <em>Theater</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Release#getDvd <em>Dvd</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.emfjson.model.rotten.RottenPackage#getRelease()
 * @model
 * @generated
 */
public interface Release extends EObject {
	/**
	 * Returns the value of the '<em><b>Theater</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Theater</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Theater</em>' attribute.
	 * @see #setTheater(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getRelease_Theater()
	 * @model
	 * @generated
	 */
	String getTheater();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Release#getTheater <em>Theater</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Theater</em>' attribute.
	 * @see #getTheater()
	 * @generated
	 */
	void setTheater(String value);

	/**
	 * Returns the value of the '<em><b>Dvd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dvd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dvd</em>' attribute.
	 * @see #setDvd(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getRelease_Dvd()
	 * @model
	 * @generated
	 */
	String getDvd();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Release#getDvd <em>Dvd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dvd</em>' attribute.
	 * @see #getDvd()
	 * @generated
	 */
	void setDvd(String value);

} // Release
