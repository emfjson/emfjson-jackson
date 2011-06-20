/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.junit.rotten;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.emfjson.junit.rotten.Cast#getName <em>Name</em>}</li>
 *   <li>{@link com.emfjson.junit.rotten.Cast#getCharacters <em>Characters</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.emfjson.junit.rotten.RottenPackage#getCast()
 * @model
 * @generated
 */
public interface Cast extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.emfjson.junit.rotten.RottenPackage#getCast_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.emfjson.junit.rotten.Cast#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Characters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characters</em>' attribute list.
	 * @see com.emfjson.junit.rotten.RottenPackage#getCast_Characters()
	 * @model
	 * @generated
	 */
	EList<String> getCharacters();

} // Cast
