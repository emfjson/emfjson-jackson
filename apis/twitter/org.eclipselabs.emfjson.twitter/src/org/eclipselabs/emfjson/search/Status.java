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
package org.eclipselabs.emfjson.search;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getFavorited <em>Favorited</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getCreatedAt <em>Created At</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getTruncated <em>Truncated</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getInReplyToUserId <em>In Reply To User Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.Status#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus()
 * @model annotation="JSON root='true'"
 * @generated
 */
public interface Status extends EObject {
	/**
	 * Returns the value of the '<em><b>Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' attribute.
	 * @see #setCoordinates(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_Coordinates()
	 * @model
	 * @generated
	 */
	String getCoordinates();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.Status#getCoordinates <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinates</em>' attribute.
	 * @see #getCoordinates()
	 * @generated
	 */
	void setCoordinates(String value);

	/**
	 * Returns the value of the '<em><b>Favorited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favorited</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favorited</em>' attribute.
	 * @see #setFavorited(Boolean)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_Favorited()
	 * @model
	 * @generated
	 */
	Boolean getFavorited();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.Status#getFavorited <em>Favorited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favorited</em>' attribute.
	 * @see #getFavorited()
	 * @generated
	 */
	void setFavorited(Boolean value);

	/**
	 * Returns the value of the '<em><b>Created At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created At</em>' attribute.
	 * @see #setCreatedAt(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_CreatedAt()
	 * @model annotation="JSON element='created_at'"
	 * @generated
	 */
	String getCreatedAt();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.Status#getCreatedAt <em>Created At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created At</em>' attribute.
	 * @see #getCreatedAt()
	 * @generated
	 */
	void setCreatedAt(String value);

	/**
	 * Returns the value of the '<em><b>Truncated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Truncated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Truncated</em>' attribute.
	 * @see #setTruncated(Boolean)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_Truncated()
	 * @model
	 * @generated
	 */
	Boolean getTruncated();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.Status#getTruncated <em>Truncated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Truncated</em>' attribute.
	 * @see #getTruncated()
	 * @generated
	 */
	void setTruncated(Boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_Id()
	 * @model annotation="JSON element='id_str'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.Status#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>In Reply To User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Reply To User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Reply To User Id</em>' attribute.
	 * @see #setInReplyToUserId(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_InReplyToUserId()
	 * @model annotation="JSON element='in_reply_to_user_id_str'"
	 * @generated
	 */
	String getInReplyToUserId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.Status#getInReplyToUserId <em>In Reply To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Reply To User Id</em>' attribute.
	 * @see #getInReplyToUserId()
	 * @generated
	 */
	void setInReplyToUserId(String value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emfjson.search.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getStatus_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

} // Status
