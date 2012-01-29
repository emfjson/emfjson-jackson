/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.examples.library;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.examples.library.Book#getNumPages <em>Num Pages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.examples.library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends Item {
	/**
	 * Returns the value of the '<em><b>Num Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Pages</em>' attribute.
	 * @see #setNumPages(int)
	 * @see org.eclipselabs.examples.library.LibraryPackage#getBook_NumPages()
	 * @model
	 * @generated
	 */
	int getNumPages();

	/**
	 * Sets the value of the '{@link org.eclipselabs.examples.library.Book#getNumPages <em>Num Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Pages</em>' attribute.
	 * @see #getNumPages()
	 * @generated
	 */
	void setNumPages(int value);

} // Book
