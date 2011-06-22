/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package com.emfjson.model.rotten;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reviews</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.Reviews#getReviews <em>Reviews</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.emfjson.model.rotten.RottenPackage#getReviews()
 * @model annotation="JSON root='true'"
 * @generated
 */
public interface Reviews extends EObject {
	/**
	 * Returns the value of the '<em><b>Reviews</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reviews</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reviews</em>' containment reference.
	 * @see #setReviews(Review)
	 * @see com.emfjson.model.rotten.RottenPackage#getReviews_Reviews()
	 * @model containment="true"
	 *        annotation="JSON element='reviews'"
	 * @generated
	 */
	Review getReviews();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Reviews#getReviews <em>Reviews</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reviews</em>' containment reference.
	 * @see #getReviews()
	 * @generated
	 */
	void setReviews(Review value);

} // Reviews
