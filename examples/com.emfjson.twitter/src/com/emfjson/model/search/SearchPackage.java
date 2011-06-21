/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.model.search;

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
 * @see com.emfjson.model.search.SearchFactory
 * @model kind="package"
 * @generated
 */
public interface SearchPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "search";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/twitter/search";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "search";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SearchPackage eINSTANCE = com.emfjson.model.search.impl.SearchPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.emfjson.model.search.impl.ResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.search.impl.ResultImpl
	 * @see com.emfjson.model.search.impl.SearchPackageImpl#getResult()
	 * @generated
	 */
	int RESULT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__ID = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__TEXT = 1;

	/**
	 * The feature id for the '<em><b>To User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__TO_USER_ID = 2;

	/**
	 * The feature id for the '<em><b>To User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__TO_USER = 3;

	/**
	 * The feature id for the '<em><b>From User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__FROM_USER = 4;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__METADATA = 5;

	/**
	 * The feature id for the '<em><b>Since Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SINCE_ID = 6;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FEATURE_COUNT = 7;


	/**
	 * The meta object id for the '{@link com.emfjson.model.search.impl.MetadataImpl <em>Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.search.impl.MetadataImpl
	 * @see com.emfjson.model.search.impl.SearchPackageImpl#getMetadata()
	 * @generated
	 */
	int METADATA = 1;

	/**
	 * The feature id for the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA__RESULT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Recent Retweets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA__RECENT_RETWEETS = 1;

	/**
	 * The number of structural features of the '<em>Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.emfjson.model.search.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see com.emfjson.model.search.Result
	 * @generated
	 */
	EClass getResult();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Result#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.emfjson.model.search.Result#getId()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Result#getToUserId <em>To User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To User Id</em>'.
	 * @see com.emfjson.model.search.Result#getToUserId()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_ToUserId();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Result#getToUser <em>To User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To User</em>'.
	 * @see com.emfjson.model.search.Result#getToUser()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_ToUser();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Result#getFromUser <em>From User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From User</em>'.
	 * @see com.emfjson.model.search.Result#getFromUser()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_FromUser();

	/**
	 * Returns the meta object for the containment reference list '{@link com.emfjson.model.search.Result#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadata</em>'.
	 * @see com.emfjson.model.search.Result#getMetadata()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Metadata();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Result#getSinceId <em>Since Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Since Id</em>'.
	 * @see com.emfjson.model.search.Result#getSinceId()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_SinceId();

	/**
	 * Returns the meta object for class '{@link com.emfjson.model.search.Metadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metadata</em>'.
	 * @see com.emfjson.model.search.Metadata
	 * @generated
	 */
	EClass getMetadata();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Metadata#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Type</em>'.
	 * @see com.emfjson.model.search.Metadata#getResultType()
	 * @see #getMetadata()
	 * @generated
	 */
	EAttribute getMetadata_ResultType();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Metadata#getRecentRetweets <em>Recent Retweets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recent Retweets</em>'.
	 * @see com.emfjson.model.search.Metadata#getRecentRetweets()
	 * @see #getMetadata()
	 * @generated
	 */
	EAttribute getMetadata_RecentRetweets();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.search.Result#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.emfjson.model.search.Result#getText()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SearchFactory getSearchFactory();

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
		 * The meta object literal for the '{@link com.emfjson.model.search.impl.ResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.search.impl.ResultImpl
		 * @see com.emfjson.model.search.impl.SearchPackageImpl#getResult()
		 * @generated
		 */
		EClass RESULT = eINSTANCE.getResult();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__ID = eINSTANCE.getResult_Id();

		/**
		 * The meta object literal for the '<em><b>To User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__TO_USER_ID = eINSTANCE.getResult_ToUserId();

		/**
		 * The meta object literal for the '<em><b>To User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__TO_USER = eINSTANCE.getResult_ToUser();

		/**
		 * The meta object literal for the '<em><b>From User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__FROM_USER = eINSTANCE.getResult_FromUser();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__METADATA = eINSTANCE.getResult_Metadata();

		/**
		 * The meta object literal for the '<em><b>Since Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__SINCE_ID = eINSTANCE.getResult_SinceId();

		/**
		 * The meta object literal for the '{@link com.emfjson.model.search.impl.MetadataImpl <em>Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.search.impl.MetadataImpl
		 * @see com.emfjson.model.search.impl.SearchPackageImpl#getMetadata()
		 * @generated
		 */
		EClass METADATA = eINSTANCE.getMetadata();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METADATA__RESULT_TYPE = eINSTANCE.getMetadata_ResultType();

		/**
		 * The meta object literal for the '<em><b>Recent Retweets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METADATA__RECENT_RETWEETS = eINSTANCE.getMetadata_RecentRetweets();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__TEXT = eINSTANCE.getResult_Text();

	}

} //SearchPackage
