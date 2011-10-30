/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Video Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoResult#getUpdated <em>Updated</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoResult#getTotalItems <em>Total Items</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoResult#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoResult#getItemsPerPage <em>Items Per Page</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoResult#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoResult()
 * @model annotation="JSON root='true' element='data'"
 * @generated
 */
public interface VideoResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(Date)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoResult_Updated()
	 * @model
	 * @generated
	 */
	Date getUpdated();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoResult#getUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #getUpdated()
	 * @generated
	 */
	void setUpdated(Date value);

	/**
	 * Returns the value of the '<em><b>Total Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Items</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Items</em>' attribute.
	 * @see #setTotalItems(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoResult_TotalItems()
	 * @model
	 * @generated
	 */
	Integer getTotalItems();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoResult#getTotalItems <em>Total Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Items</em>' attribute.
	 * @see #getTotalItems()
	 * @generated
	 */
	void setTotalItems(Integer value);

	/**
	 * Returns the value of the '<em><b>Start Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Index</em>' attribute.
	 * @see #setStartIndex(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoResult_StartIndex()
	 * @model
	 * @generated
	 */
	Integer getStartIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoResult#getStartIndex <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Index</em>' attribute.
	 * @see #getStartIndex()
	 * @generated
	 */
	void setStartIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Items Per Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items Per Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items Per Page</em>' attribute.
	 * @see #setItemsPerPage(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoResult_ItemsPerPage()
	 * @model
	 * @generated
	 */
	Integer getItemsPerPage();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoResult#getItemsPerPage <em>Items Per Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Items Per Page</em>' attribute.
	 * @see #getItemsPerPage()
	 * @generated
	 */
	void setItemsPerPage(Integer value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emfjson.youtube.VideoItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoResult_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<VideoItem> getItems();

} // VideoResult
