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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Review</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.Review#getCritic <em>Critic</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Review#getDate <em>Date</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Review#getPublication <em>Publication</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Review#getQuote <em>Quote</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Review#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.emfjson.model.rotten.RottenPackage#getReview()
 * @model
 * @generated
 */
public interface Review extends EObject {
	/**
	 * Returns the value of the '<em><b>Critic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Critic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Critic</em>' attribute.
	 * @see #setCritic(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getReview_Critic()
	 * @model
	 * @generated
	 */
	String getCritic();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Review#getCritic <em>Critic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Critic</em>' attribute.
	 * @see #getCritic()
	 * @generated
	 */
	void setCritic(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getReview_Date()
	 * @model
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Review#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>Publication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publication</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publication</em>' attribute.
	 * @see #setPublication(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getReview_Publication()
	 * @model
	 * @generated
	 */
	String getPublication();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Review#getPublication <em>Publication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publication</em>' attribute.
	 * @see #getPublication()
	 * @generated
	 */
	void setPublication(String value);

	/**
	 * Returns the value of the '<em><b>Quote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quote</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quote</em>' attribute.
	 * @see #setQuote(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getReview_Quote()
	 * @model
	 * @generated
	 */
	String getQuote();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Review#getQuote <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quote</em>' attribute.
	 * @see #getQuote()
	 * @generated
	 */
	void setQuote(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link com.emfjson.model.rotten.ReviewLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see com.emfjson.model.rotten.RottenPackage#getReview_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReviewLink> getLinks();

} // Review
