/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.examples.library;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.examples.library.LibraryFactory
 * @model kind="package"
 * @generated
 */
public interface LibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "library";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/examples/library";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "library";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryPackage eINSTANCE = org.eclipselabs.examples.library.impl.LibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.LibraryShelfImpl <em>Shelf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.LibraryShelfImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getLibraryShelf()
	 * @generated
	 */
	int LIBRARY_SHELF = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_SHELF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_SHELF__ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Shelf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_SHELF_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.ItemImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__PUB_DATE = 1;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.BookImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = ITEM__TITLE;

	/**
	 * The feature id for the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__PUB_DATE = ITEM__PUB_DATE;

	/**
	 * The feature id for the '<em><b>Num Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__NUM_PAGES = ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.MultimediaItemImpl <em>Multimedia Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.MultimediaItemImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getMultimediaItem()
	 * @generated
	 */
	int MULTIMEDIA_ITEM = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIMEDIA_ITEM__TITLE = ITEM__TITLE;

	/**
	 * The feature id for the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIMEDIA_ITEM__PUB_DATE = ITEM__PUB_DATE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIMEDIA_ITEM__LENGTH = ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multimedia Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIMEDIA_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.DVDImpl <em>DVD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.DVDImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getDVD()
	 * @generated
	 */
	int DVD = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVD__TITLE = MULTIMEDIA_ITEM__TITLE;

	/**
	 * The feature id for the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVD__PUB_DATE = MULTIMEDIA_ITEM__PUB_DATE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVD__LENGTH = MULTIMEDIA_ITEM__LENGTH;

	/**
	 * The number of structural features of the '<em>DVD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVD_FEATURE_COUNT = MULTIMEDIA_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.BlueRayImpl <em>Blue Ray</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.BlueRayImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getBlueRay()
	 * @generated
	 */
	int BLUE_RAY = 5;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLUE_RAY__TITLE = MULTIMEDIA_ITEM__TITLE;

	/**
	 * The feature id for the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLUE_RAY__PUB_DATE = MULTIMEDIA_ITEM__PUB_DATE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLUE_RAY__LENGTH = MULTIMEDIA_ITEM__LENGTH;

	/**
	 * The number of structural features of the '<em>Blue Ray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLUE_RAY_FEATURE_COUNT = MULTIMEDIA_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.examples.library.impl.CDImpl <em>CD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.examples.library.impl.CDImpl
	 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getCD()
	 * @generated
	 */
	int CD = 6;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD__TITLE = MULTIMEDIA_ITEM__TITLE;

	/**
	 * The feature id for the '<em><b>Pub Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD__PUB_DATE = MULTIMEDIA_ITEM__PUB_DATE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD__LENGTH = MULTIMEDIA_ITEM__LENGTH;

	/**
	 * The number of structural features of the '<em>CD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD_FEATURE_COUNT = MULTIMEDIA_ITEM_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.LibraryShelf <em>Shelf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shelf</em>'.
	 * @see org.eclipselabs.examples.library.LibraryShelf
	 * @generated
	 */
	EClass getLibraryShelf();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.examples.library.LibraryShelf#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.examples.library.LibraryShelf#getName()
	 * @see #getLibraryShelf()
	 * @generated
	 */
	EAttribute getLibraryShelf_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.examples.library.LibraryShelf#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipselabs.examples.library.LibraryShelf#getItems()
	 * @see #getLibraryShelf()
	 * @generated
	 */
	EReference getLibraryShelf_Items();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see org.eclipselabs.examples.library.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.examples.library.Item#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipselabs.examples.library.Item#getTitle()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.examples.library.Item#getPubDate <em>Pub Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pub Date</em>'.
	 * @see org.eclipselabs.examples.library.Item#getPubDate()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_PubDate();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see org.eclipselabs.examples.library.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.examples.library.Book#getNumPages <em>Num Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Pages</em>'.
	 * @see org.eclipselabs.examples.library.Book#getNumPages()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_NumPages();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.MultimediaItem <em>Multimedia Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multimedia Item</em>'.
	 * @see org.eclipselabs.examples.library.MultimediaItem
	 * @generated
	 */
	EClass getMultimediaItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.examples.library.MultimediaItem#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipselabs.examples.library.MultimediaItem#getLength()
	 * @see #getMultimediaItem()
	 * @generated
	 */
	EAttribute getMultimediaItem_Length();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.DVD <em>DVD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DVD</em>'.
	 * @see org.eclipselabs.examples.library.DVD
	 * @generated
	 */
	EClass getDVD();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.BlueRay <em>Blue Ray</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blue Ray</em>'.
	 * @see org.eclipselabs.examples.library.BlueRay
	 * @generated
	 */
	EClass getBlueRay();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.examples.library.CD <em>CD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CD</em>'.
	 * @see org.eclipselabs.examples.library.CD
	 * @generated
	 */
	EClass getCD();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LibraryFactory getLibraryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.LibraryShelfImpl <em>Shelf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.LibraryShelfImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getLibraryShelf()
		 * @generated
		 */
		EClass LIBRARY_SHELF = eINSTANCE.getLibraryShelf();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_SHELF__NAME = eINSTANCE.getLibraryShelf_Name();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_SHELF__ITEMS = eINSTANCE.getLibraryShelf_Items();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.ItemImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__TITLE = eINSTANCE.getItem_Title();

		/**
		 * The meta object literal for the '<em><b>Pub Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__PUB_DATE = eINSTANCE.getItem_PubDate();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.BookImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Num Pages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__NUM_PAGES = eINSTANCE.getBook_NumPages();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.MultimediaItemImpl <em>Multimedia Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.MultimediaItemImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getMultimediaItem()
		 * @generated
		 */
		EClass MULTIMEDIA_ITEM = eINSTANCE.getMultimediaItem();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIMEDIA_ITEM__LENGTH = eINSTANCE.getMultimediaItem_Length();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.DVDImpl <em>DVD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.DVDImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getDVD()
		 * @generated
		 */
		EClass DVD = eINSTANCE.getDVD();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.BlueRayImpl <em>Blue Ray</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.BlueRayImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getBlueRay()
		 * @generated
		 */
		EClass BLUE_RAY = eINSTANCE.getBlueRay();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.examples.library.impl.CDImpl <em>CD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.examples.library.impl.CDImpl
		 * @see org.eclipselabs.examples.library.impl.LibraryPackageImpl#getCD()
		 * @generated
		 */
		EClass CD = eINSTANCE.getCD();

	}

} //LibraryPackage
