/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.model.library;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.model.library.Item#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipselabs.model.library.Item#getPubDate <em>Pub Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.model.library.LibraryPackage#getItem()
 * @model abstract="true"
 * @generated
 */
public interface Item extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipselabs.model.library.LibraryPackage#getItem_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipselabs.model.library.Item#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pub Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pub Date</em>' attribute.
	 * @see #setPubDate(Date)
	 * @see org.eclipselabs.model.library.LibraryPackage#getItem_PubDate()
	 * @model
	 * @generated
	 */
	Date getPubDate();

	/**
	 * Sets the value of the '{@link org.eclipselabs.model.library.Item#getPubDate <em>Pub Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pub Date</em>' attribute.
	 * @see #getPubDate()
	 * @generated
	 */
	void setPubDate(Date value);

} // Item
