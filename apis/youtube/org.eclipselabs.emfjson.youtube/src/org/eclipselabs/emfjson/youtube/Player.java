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
 * A representation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Player#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Player#getMobile <em>Mobile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getPlayer()
 * @model
 * @generated
 */
public interface Player extends EObject {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getPlayer_Default()
	 * @model
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Player#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mobile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mobile</em>' attribute.
	 * @see #setMobile(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getPlayer_Mobile()
	 * @model
	 * @generated
	 */
	String getMobile();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Player#getMobile <em>Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mobile</em>' attribute.
	 * @see #getMobile()
	 * @generated
	 */
	void setMobile(String value);

} // Player
