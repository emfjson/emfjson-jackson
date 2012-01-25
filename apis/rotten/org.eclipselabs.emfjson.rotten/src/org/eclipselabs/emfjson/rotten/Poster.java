/**
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 * 
 */
package org.eclipselabs.emfjson.rotten;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Poster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Poster#getThumbnail <em>Thumbnail</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Poster#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Poster#getDetailed <em>Detailed</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Poster#getOriginal <em>Original</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getPoster()
 * @model
 * @generated
 */
public interface Poster extends EObject {
	/**
	 * Returns the value of the '<em><b>Thumbnail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thumbnail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thumbnail</em>' attribute.
	 * @see #setThumbnail(String)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getPoster_Thumbnail()
	 * @model
	 * @generated
	 */
	String getThumbnail();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Poster#getThumbnail <em>Thumbnail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thumbnail</em>' attribute.
	 * @see #getThumbnail()
	 * @generated
	 */
	void setThumbnail(String value);

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' attribute.
	 * @see #setProfile(String)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getPoster_Profile()
	 * @model
	 * @generated
	 */
	String getProfile();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Poster#getProfile <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' attribute.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(String value);

	/**
	 * Returns the value of the '<em><b>Detailed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailed</em>' attribute.
	 * @see #setDetailed(String)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getPoster_Detailed()
	 * @model
	 * @generated
	 */
	String getDetailed();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Poster#getDetailed <em>Detailed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detailed</em>' attribute.
	 * @see #getDetailed()
	 * @generated
	 */
	void setDetailed(String value);

	/**
	 * Returns the value of the '<em><b>Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original</em>' attribute.
	 * @see #setOriginal(String)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getPoster_Original()
	 * @model
	 * @generated
	 */
	String getOriginal();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Poster#getOriginal <em>Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original</em>' attribute.
	 * @see #getOriginal()
	 * @generated
	 */
	void setOriginal(String value);

} // Poster
