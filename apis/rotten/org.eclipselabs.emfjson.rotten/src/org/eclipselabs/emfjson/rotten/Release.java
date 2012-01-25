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
 * A representation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Release#getTheater <em>Theater</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Release#getDvd <em>Dvd</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getRelease()
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
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getRelease_Theater()
	 * @model
	 * @generated
	 */
	String getTheater();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Release#getTheater <em>Theater</em>}' attribute.
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
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getRelease_Dvd()
	 * @model
	 * @generated
	 */
	String getDvd();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Release#getDvd <em>Dvd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dvd</em>' attribute.
	 * @see #getDvd()
	 * @generated
	 */
	void setDvd(String value);

} // Release
