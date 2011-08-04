/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.search;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipselabs.emfjson.search.SearchFactory
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
	SearchPackage eINSTANCE = org.eclipselabs.emfjson.search.impl.SearchPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.impl.ResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.impl.ResultImpl
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getResult()
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
	 * The feature id for the '<em><b>Created At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__CREATED_AT = 2;

	/**
	 * The feature id for the '<em><b>To User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__TO_USER_ID = 3;

	/**
	 * The feature id for the '<em><b>To User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__TO_USER = 4;

	/**
	 * The feature id for the '<em><b>From User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__FROM_USER = 5;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__METADATA = 6;

	/**
	 * The feature id for the '<em><b>Since Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SINCE_ID = 7;

	/**
	 * The feature id for the '<em><b>Profile Image Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__PROFILE_IMAGE_URL = 8;

	/**
	 * The feature id for the '<em><b>From User Id Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__FROM_USER_ID_STR = 9;

	/**
	 * The feature id for the '<em><b>Geo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__GEO = 10;

	/**
	 * The feature id for the '<em><b>Iso Lang Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__ISO_LANG_CODE = 11;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SOURCE = 12;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.impl.MetadataImpl <em>Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.impl.MetadataImpl
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getMetadata()
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
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.ResultType <em>Result Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.ResultType
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getResultType()
	 * @generated
	 */
	int RESULT_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.search.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see org.eclipselabs.emfjson.search.Result
	 * @generated
	 */
	EClass getResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getId()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getText()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getCreatedAt <em>Created At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created At</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getCreatedAt()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_CreatedAt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getToUserId <em>To User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To User Id</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getToUserId()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_ToUserId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getToUser <em>To User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To User</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getToUser()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_ToUser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getFromUser <em>From User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From User</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getFromUser()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_FromUser();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emfjson.search.Result#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadata</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getMetadata()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Metadata();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getSinceId <em>Since Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Since Id</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getSinceId()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_SinceId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getProfileImageUrl <em>Profile Image Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Image Url</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getProfileImageUrl()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_ProfileImageUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getFromUserIdStr <em>From User Id Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From User Id Str</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getFromUserIdStr()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_FromUserIdStr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getGeo <em>Geo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geo</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getGeo()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Geo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getIsoLangCode <em>Iso Lang Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iso Lang Code</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getIsoLangCode()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_IsoLangCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Result#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipselabs.emfjson.search.Result#getSource()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.search.Metadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metadata</em>'.
	 * @see org.eclipselabs.emfjson.search.Metadata
	 * @generated
	 */
	EClass getMetadata();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Metadata#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Type</em>'.
	 * @see org.eclipselabs.emfjson.search.Metadata#getResultType()
	 * @see #getMetadata()
	 * @generated
	 */
	EAttribute getMetadata_ResultType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Metadata#getRecentRetweets <em>Recent Retweets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recent Retweets</em>'.
	 * @see org.eclipselabs.emfjson.search.Metadata#getRecentRetweets()
	 * @see #getMetadata()
	 * @generated
	 */
	EAttribute getMetadata_RecentRetweets();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.emfjson.search.ResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Result Type</em>'.
	 * @see org.eclipselabs.emfjson.search.ResultType
	 * @generated
	 */
	EEnum getResultType();

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
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.search.impl.ResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.search.impl.ResultImpl
		 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getResult()
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
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__TEXT = eINSTANCE.getResult_Text();

		/**
		 * The meta object literal for the '<em><b>Created At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__CREATED_AT = eINSTANCE.getResult_CreatedAt();

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
		 * The meta object literal for the '<em><b>Profile Image Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__PROFILE_IMAGE_URL = eINSTANCE.getResult_ProfileImageUrl();

		/**
		 * The meta object literal for the '<em><b>From User Id Str</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__FROM_USER_ID_STR = eINSTANCE.getResult_FromUserIdStr();

		/**
		 * The meta object literal for the '<em><b>Geo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__GEO = eINSTANCE.getResult_Geo();

		/**
		 * The meta object literal for the '<em><b>Iso Lang Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__ISO_LANG_CODE = eINSTANCE.getResult_IsoLangCode();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__SOURCE = eINSTANCE.getResult_Source();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.search.impl.MetadataImpl <em>Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.search.impl.MetadataImpl
		 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getMetadata()
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
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.search.ResultType <em>Result Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.search.ResultType
		 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getResultType()
		 * @generated
		 */
		EEnum RESULT_TYPE = eINSTANCE.getResultType();

	}

} //SearchPackage
