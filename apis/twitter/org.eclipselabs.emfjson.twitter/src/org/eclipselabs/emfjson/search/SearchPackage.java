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
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.impl.StatusImpl
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 2;

	/**
	 * The feature id for the '<em><b>Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__COORDINATES = 0;

	/**
	 * The feature id for the '<em><b>Favorited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__FAVORITED = 1;

	/**
	 * The feature id for the '<em><b>Created At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__CREATED_AT = 2;

	/**
	 * The feature id for the '<em><b>Truncated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__TRUNCATED = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__ID = 4;

	/**
	 * The feature id for the '<em><b>In Reply To User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__IN_REPLY_TO_USER_ID = 5;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__ENTITIES = 6;

	/**
	 * The number of structural features of the '<em>Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.impl.EntityImpl
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 3;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.impl.UserImpl
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getUser()
	 * @generated
	 */
	int USER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Expanded Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EXPANDED_URL = 2;

	/**
	 * The feature id for the '<em><b>Created At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__CREATED_AT = 3;

	/**
	 * The feature id for the '<em><b>Profile Sidebar Fill Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PROFILE_SIDEBAR_FILL_COLOR = 4;

	/**
	 * The feature id for the '<em><b>Profile Sidebar Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PROFILE_SIDEBAR_BORDER_COLOR = 5;

	/**
	 * The feature id for the '<em><b>Profile Background Tile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PROFILE_BACKGROUND_TILE = 6;

	/**
	 * The feature id for the '<em><b>Profile Image Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PROFILE_IMAGE_URL = 7;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.search.ResultType <em>Result Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.search.ResultType
	 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getResultType()
	 * @generated
	 */
	int RESULT_TYPE = 5;


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
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.search.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status</em>'.
	 * @see org.eclipselabs.emfjson.search.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Status#getCoordinates <em>Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coordinates</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getCoordinates()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Coordinates();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Status#getFavorited <em>Favorited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favorited</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getFavorited()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Favorited();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Status#getCreatedAt <em>Created At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created At</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getCreatedAt()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_CreatedAt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Status#getTruncated <em>Truncated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Truncated</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getTruncated()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Truncated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Status#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getId()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.Status#getInReplyToUserId <em>In Reply To User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Reply To User Id</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getInReplyToUserId()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_InReplyToUserId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emfjson.search.Status#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see org.eclipselabs.emfjson.search.Status#getEntities()
	 * @see #getStatus()
	 * @generated
	 */
	EReference getStatus_Entities();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.search.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.eclipselabs.emfjson.search.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.search.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.eclipselabs.emfjson.search.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getLocation()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getExpandedUrl <em>Expanded Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expanded Url</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getExpandedUrl()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ExpandedUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getCreatedAt <em>Created At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created At</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getCreatedAt()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_CreatedAt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getProfileSidebarFillColor <em>Profile Sidebar Fill Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Sidebar Fill Color</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getProfileSidebarFillColor()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ProfileSidebarFillColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getProfileSidebarBorderColor <em>Profile Sidebar Border Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Sidebar Border Color</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getProfileSidebarBorderColor()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ProfileSidebarBorderColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getProfileBackgroundTile <em>Profile Background Tile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Background Tile</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getProfileBackgroundTile()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ProfileBackgroundTile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.search.User#getProfileImageUrl <em>Profile Image Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Image Url</em>'.
	 * @see org.eclipselabs.emfjson.search.User#getProfileImageUrl()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ProfileImageUrl();

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
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.search.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.search.impl.StatusImpl
		 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getStatus()
		 * @generated
		 */
		EClass STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '<em><b>Coordinates</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__COORDINATES = eINSTANCE.getStatus_Coordinates();

		/**
		 * The meta object literal for the '<em><b>Favorited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__FAVORITED = eINSTANCE.getStatus_Favorited();

		/**
		 * The meta object literal for the '<em><b>Created At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__CREATED_AT = eINSTANCE.getStatus_CreatedAt();

		/**
		 * The meta object literal for the '<em><b>Truncated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__TRUNCATED = eINSTANCE.getStatus_Truncated();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__ID = eINSTANCE.getStatus_Id();

		/**
		 * The meta object literal for the '<em><b>In Reply To User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__IN_REPLY_TO_USER_ID = eINSTANCE.getStatus_InReplyToUserId();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATUS__ENTITIES = eINSTANCE.getStatus_Entities();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.search.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.search.impl.EntityImpl
		 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.search.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.search.impl.UserImpl
		 * @see org.eclipselabs.emfjson.search.impl.SearchPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LOCATION = eINSTANCE.getUser_Location();

		/**
		 * The meta object literal for the '<em><b>Expanded Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__EXPANDED_URL = eINSTANCE.getUser_ExpandedUrl();

		/**
		 * The meta object literal for the '<em><b>Created At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__CREATED_AT = eINSTANCE.getUser_CreatedAt();

		/**
		 * The meta object literal for the '<em><b>Profile Sidebar Fill Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PROFILE_SIDEBAR_FILL_COLOR = eINSTANCE.getUser_ProfileSidebarFillColor();

		/**
		 * The meta object literal for the '<em><b>Profile Sidebar Border Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PROFILE_SIDEBAR_BORDER_COLOR = eINSTANCE.getUser_ProfileSidebarBorderColor();

		/**
		 * The meta object literal for the '<em><b>Profile Background Tile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PROFILE_BACKGROUND_TILE = eINSTANCE.getUser_ProfileBackgroundTile();

		/**
		 * The meta object literal for the '<em><b>Profile Image Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PROFILE_IMAGE_URL = eINSTANCE.getUser_ProfileImageUrl();

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
