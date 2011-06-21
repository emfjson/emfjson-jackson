/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.model.search;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadata</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.emfjson.model.search.Metadata#getResultType <em>Result Type</em>}</li>
 *   <li>{@link com.emfjson.model.search.Metadata#getRecentRetweets <em>Recent Retweets</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.emfjson.model.search.SearchPackage#getMetadata()
 * @model
 * @generated
 */
public interface Metadata extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see #setResultType(String)
	 * @see com.emfjson.model.search.SearchPackage#getMetadata_ResultType()
	 * @model annotation="JSON element='result_type'"
	 * @generated
	 */
	String getResultType();

	/**
	 * Sets the value of the '{@link com.emfjson.model.search.Metadata#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(String value);

	/**
	 * Returns the value of the '<em><b>Recent Retweets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recent Retweets</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recent Retweets</em>' attribute.
	 * @see #setRecentRetweets(Integer)
	 * @see com.emfjson.model.search.SearchPackage#getMetadata_RecentRetweets()
	 * @model annotation="JSON element='recent_retweets'"
	 * @generated
	 */
	Integer getRecentRetweets();

	/**
	 * Sets the value of the '{@link com.emfjson.model.search.Metadata#getRecentRetweets <em>Recent Retweets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recent Retweets</em>' attribute.
	 * @see #getRecentRetweets()
	 * @generated
	 */
	void setRecentRetweets(Integer value);

} // Metadata
