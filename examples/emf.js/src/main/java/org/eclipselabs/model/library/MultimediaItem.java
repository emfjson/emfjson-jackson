/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.model.library;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multimedia Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.model.library.MultimediaItem#getLength <em>Length</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.model.library.LibraryPackage#getMultimediaItem()
 * @model abstract="true"
 * @generated
 */
public interface MultimediaItem extends Item {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(double)
	 * @see org.eclipselabs.model.library.LibraryPackage#getMultimediaItem_Length()
	 * @model
	 * @generated
	 */
	double getLength();

	/**
	 * Sets the value of the '{@link org.eclipselabs.model.library.MultimediaItem#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(double value);

} // MultimediaItem
