/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.examples.library;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.examples.library.LibraryPackage
 * @generated
 */
public interface LibraryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryFactory eINSTANCE = org.eclipselabs.examples.library.impl.LibraryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Shelf</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shelf</em>'.
	 * @generated
	 */
	LibraryShelf createLibraryShelf();

	/**
	 * Returns a new object of class '<em>Book</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Book</em>'.
	 * @generated
	 */
	Book createBook();

	/**
	 * Returns a new object of class '<em>DVD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DVD</em>'.
	 * @generated
	 */
	DVD createDVD();

	/**
	 * Returns a new object of class '<em>Blue Ray</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blue Ray</em>'.
	 * @generated
	 */
	BlueRay createBlueRay();

	/**
	 * Returns a new object of class '<em>CD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CD</em>'.
	 * @generated
	 */
	CD createCD();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LibraryPackage getLibraryPackage();

} //LibraryFactory
