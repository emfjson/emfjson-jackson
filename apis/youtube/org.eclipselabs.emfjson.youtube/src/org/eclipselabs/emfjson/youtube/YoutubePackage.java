/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube;

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
 * @see org.eclipselabs.emfjson.youtube.YoutubeFactory
 * @model kind="package"
 * @generated
 */
public interface YoutubePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "youtube";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/youtube";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "youtube";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	YoutubePackage eINSTANCE = org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl <em>Video Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.VideoResultImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getVideoResult()
	 * @generated
	 */
	int VIDEO_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_RESULT__UPDATED = 0;

	/**
	 * The feature id for the '<em><b>Total Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_RESULT__TOTAL_ITEMS = 1;

	/**
	 * The feature id for the '<em><b>Start Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_RESULT__START_INDEX = 2;

	/**
	 * The feature id for the '<em><b>Items Per Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_RESULT__ITEMS_PER_PAGE = 3;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_RESULT__ITEMS = 4;

	/**
	 * The number of structural features of the '<em>Video Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_RESULT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl <em>Video Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.VideoItemImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getVideoItem()
	 * @generated
	 */
	int VIDEO_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__ID = 0;

	/**
	 * The feature id for the '<em><b>Uploaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__UPLOADED = 1;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__UPDATED = 2;

	/**
	 * The feature id for the '<em><b>Uploader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__UPLOADER = 3;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__CATEGORY = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__TITLE = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__TAGS = 7;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__DURATION = 8;

	/**
	 * The feature id for the '<em><b>Aspect Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__ASPECT_RATIO = 9;

	/**
	 * The feature id for the '<em><b>Like Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__LIKE_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__RATING = 11;

	/**
	 * The feature id for the '<em><b>Rating Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__RATING_COUNT = 12;

	/**
	 * The feature id for the '<em><b>View Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__VIEW_COUNT = 13;

	/**
	 * The feature id for the '<em><b>Favorite Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__FAVORITE_COUNT = 14;

	/**
	 * The feature id for the '<em><b>Comment Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__COMMENT_COUNT = 15;

	/**
	 * The feature id for the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__STATUS = 16;

	/**
	 * The feature id for the '<em><b>Access Control</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__ACCESS_CONTROL = 17;

	/**
	 * The feature id for the '<em><b>Thumbnail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__THUMBNAIL = 18;

	/**
	 * The feature id for the '<em><b>Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__PLAYER = 19;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM__CONTENT = 20;

	/**
	 * The number of structural features of the '<em>Video Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_ITEM_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl <em>Access Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.AccessControlImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getAccessControl()
	 * @generated
	 */
	int ACCESS_CONTROL = 2;

	/**
	 * The feature id for the '<em><b>Syndicate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__SYNDICATE = 0;

	/**
	 * The feature id for the '<em><b>Comment Vote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__COMMENT_VOTE = 1;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__RATE = 2;

	/**
	 * The feature id for the '<em><b>List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__LIST = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Embed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__EMBED = 5;

	/**
	 * The feature id for the '<em><b>Video Respond</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL__VIDEO_RESPOND = 6;

	/**
	 * The number of structural features of the '<em>Access Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.StatusImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__REASON = 1;

	/**
	 * The number of structural features of the '<em>Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.ThumbnailImpl <em>Thumbnail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.ThumbnailImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getThumbnail()
	 * @generated
	 */
	int THUMBNAIL = 4;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMBNAIL__DEFAULT = 0;

	/**
	 * The feature id for the '<em><b>Hq Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMBNAIL__HQ_DEFAULT = 1;

	/**
	 * The number of structural features of the '<em>Thumbnail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMBNAIL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.PlayerImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 5;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__DEFAULT = 0;

	/**
	 * The feature id for the '<em><b>Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__MOBILE = 1;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.impl.ContentImpl
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 6;

	/**
	 * The feature id for the '<em><b>Rtsp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__RTSP = 0;

	/**
	 * The feature id for the '<em><b>Http</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__HTTP = 1;

	/**
	 * The feature id for the '<em><b>Rtsp Mpeg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__RTSP_MPEG = 2;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.AspectRatio <em>Aspect Ratio</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.AspectRatio
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getAspectRatio()
	 * @generated
	 */
	int ASPECT_RATIO = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.youtube.Access <em>Access</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.youtube.Access
	 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getAccess()
	 * @generated
	 */
	int ACCESS = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.VideoResult <em>Video Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Result</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoResult
	 * @generated
	 */
	EClass getVideoResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoResult#getUpdated <em>Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoResult#getUpdated()
	 * @see #getVideoResult()
	 * @generated
	 */
	EAttribute getVideoResult_Updated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoResult#getTotalItems <em>Total Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Items</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoResult#getTotalItems()
	 * @see #getVideoResult()
	 * @generated
	 */
	EAttribute getVideoResult_TotalItems();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoResult#getStartIndex <em>Start Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Index</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoResult#getStartIndex()
	 * @see #getVideoResult()
	 * @generated
	 */
	EAttribute getVideoResult_StartIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoResult#getItemsPerPage <em>Items Per Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Items Per Page</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoResult#getItemsPerPage()
	 * @see #getVideoResult()
	 * @generated
	 */
	EAttribute getVideoResult_ItemsPerPage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emfjson.youtube.VideoResult#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoResult#getItems()
	 * @see #getVideoResult()
	 * @generated
	 */
	EReference getVideoResult_Items();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.VideoItem <em>Video Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Item</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem
	 * @generated
	 */
	EClass getVideoItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getId()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getUploaded <em>Uploaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uploaded</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getUploaded()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Uploaded();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getUpdated <em>Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getUpdated()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Updated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getUploader <em>Uploader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uploader</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getUploader()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Uploader();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getCategory()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Category();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getTitle()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getDescription()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Description();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipselabs.emfjson.youtube.VideoItem#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getTags()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Tags();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getDuration()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getAspectRatio <em>Aspect Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aspect Ratio</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getAspectRatio()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_AspectRatio();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getLikeCount <em>Like Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Like Count</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getLikeCount()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_LikeCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getRating()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_Rating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getRatingCount <em>Rating Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating Count</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getRatingCount()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_RatingCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getViewCount <em>View Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Count</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getViewCount()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_ViewCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getFavoriteCount <em>Favorite Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favorite Count</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getFavoriteCount()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_FavoriteCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.VideoItem#getCommentCount <em>Comment Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment Count</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getCommentCount()
	 * @see #getVideoItem()
	 * @generated
	 */
	EAttribute getVideoItem_CommentCount();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emfjson.youtube.VideoItem#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Status</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getStatus()
	 * @see #getVideoItem()
	 * @generated
	 */
	EReference getVideoItem_Status();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emfjson.youtube.VideoItem#getAccessControl <em>Access Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Access Control</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getAccessControl()
	 * @see #getVideoItem()
	 * @generated
	 */
	EReference getVideoItem_AccessControl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emfjson.youtube.VideoItem#getThumbnail <em>Thumbnail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thumbnail</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getThumbnail()
	 * @see #getVideoItem()
	 * @generated
	 */
	EReference getVideoItem_Thumbnail();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emfjson.youtube.VideoItem#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Player</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getPlayer()
	 * @see #getVideoItem()
	 * @generated
	 */
	EReference getVideoItem_Player();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emfjson.youtube.VideoItem#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see org.eclipselabs.emfjson.youtube.VideoItem#getContent()
	 * @see #getVideoItem()
	 * @generated
	 */
	EReference getVideoItem_Content();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.AccessControl <em>Access Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl
	 * @generated
	 */
	EClass getAccessControl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getSyndicate <em>Syndicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Syndicate</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getSyndicate()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_Syndicate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getCommentVote <em>Comment Vote</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment Vote</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getCommentVote()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_CommentVote();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getRate()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_Rate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getList()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_List();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getComment()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getEmbed <em>Embed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Embed</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getEmbed()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_Embed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.AccessControl#getVideoRespond <em>Video Respond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Video Respond</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AccessControl#getVideoRespond()
	 * @see #getAccessControl()
	 * @generated
	 */
	EAttribute getAccessControl_VideoRespond();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Status#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Status#getValue()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Status#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Status#getReason()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Reason();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.Thumbnail <em>Thumbnail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thumbnail</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Thumbnail
	 * @generated
	 */
	EClass getThumbnail();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Thumbnail#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Thumbnail#getDefault()
	 * @see #getThumbnail()
	 * @generated
	 */
	EAttribute getThumbnail_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Thumbnail#getHqDefault <em>Hq Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hq Default</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Thumbnail#getHqDefault()
	 * @see #getThumbnail()
	 * @generated
	 */
	EAttribute getThumbnail_HqDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Player#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Player#getDefault()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Player#getMobile <em>Mobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mobile</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Player#getMobile()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Mobile();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.youtube.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Content#getRtsp <em>Rtsp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rtsp</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Content#getRtsp()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Rtsp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Content#getHttp <em>Http</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Content#getHttp()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Http();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.youtube.Content#getRtspMpeg <em>Rtsp Mpeg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rtsp Mpeg</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Content#getRtspMpeg()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_RtspMpeg();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.emfjson.youtube.AspectRatio <em>Aspect Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aspect Ratio</em>'.
	 * @see org.eclipselabs.emfjson.youtube.AspectRatio
	 * @generated
	 */
	EEnum getAspectRatio();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.emfjson.youtube.Access <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access</em>'.
	 * @see org.eclipselabs.emfjson.youtube.Access
	 * @generated
	 */
	EEnum getAccess();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	YoutubeFactory getYoutubeFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl <em>Video Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.VideoResultImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getVideoResult()
		 * @generated
		 */
		EClass VIDEO_RESULT = eINSTANCE.getVideoResult();

		/**
		 * The meta object literal for the '<em><b>Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_RESULT__UPDATED = eINSTANCE.getVideoResult_Updated();

		/**
		 * The meta object literal for the '<em><b>Total Items</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_RESULT__TOTAL_ITEMS = eINSTANCE.getVideoResult_TotalItems();

		/**
		 * The meta object literal for the '<em><b>Start Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_RESULT__START_INDEX = eINSTANCE.getVideoResult_StartIndex();

		/**
		 * The meta object literal for the '<em><b>Items Per Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_RESULT__ITEMS_PER_PAGE = eINSTANCE.getVideoResult_ItemsPerPage();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO_RESULT__ITEMS = eINSTANCE.getVideoResult_Items();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl <em>Video Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.VideoItemImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getVideoItem()
		 * @generated
		 */
		EClass VIDEO_ITEM = eINSTANCE.getVideoItem();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__ID = eINSTANCE.getVideoItem_Id();

		/**
		 * The meta object literal for the '<em><b>Uploaded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__UPLOADED = eINSTANCE.getVideoItem_Uploaded();

		/**
		 * The meta object literal for the '<em><b>Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__UPDATED = eINSTANCE.getVideoItem_Updated();

		/**
		 * The meta object literal for the '<em><b>Uploader</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__UPLOADER = eINSTANCE.getVideoItem_Uploader();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__CATEGORY = eINSTANCE.getVideoItem_Category();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__TITLE = eINSTANCE.getVideoItem_Title();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__DESCRIPTION = eINSTANCE.getVideoItem_Description();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__TAGS = eINSTANCE.getVideoItem_Tags();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__DURATION = eINSTANCE.getVideoItem_Duration();

		/**
		 * The meta object literal for the '<em><b>Aspect Ratio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__ASPECT_RATIO = eINSTANCE.getVideoItem_AspectRatio();

		/**
		 * The meta object literal for the '<em><b>Like Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__LIKE_COUNT = eINSTANCE.getVideoItem_LikeCount();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__RATING = eINSTANCE.getVideoItem_Rating();

		/**
		 * The meta object literal for the '<em><b>Rating Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__RATING_COUNT = eINSTANCE.getVideoItem_RatingCount();

		/**
		 * The meta object literal for the '<em><b>View Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__VIEW_COUNT = eINSTANCE.getVideoItem_ViewCount();

		/**
		 * The meta object literal for the '<em><b>Favorite Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__FAVORITE_COUNT = eINSTANCE.getVideoItem_FavoriteCount();

		/**
		 * The meta object literal for the '<em><b>Comment Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_ITEM__COMMENT_COUNT = eINSTANCE.getVideoItem_CommentCount();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO_ITEM__STATUS = eINSTANCE.getVideoItem_Status();

		/**
		 * The meta object literal for the '<em><b>Access Control</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO_ITEM__ACCESS_CONTROL = eINSTANCE.getVideoItem_AccessControl();

		/**
		 * The meta object literal for the '<em><b>Thumbnail</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO_ITEM__THUMBNAIL = eINSTANCE.getVideoItem_Thumbnail();

		/**
		 * The meta object literal for the '<em><b>Player</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO_ITEM__PLAYER = eINSTANCE.getVideoItem_Player();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO_ITEM__CONTENT = eINSTANCE.getVideoItem_Content();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl <em>Access Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.AccessControlImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getAccessControl()
		 * @generated
		 */
		EClass ACCESS_CONTROL = eINSTANCE.getAccessControl();

		/**
		 * The meta object literal for the '<em><b>Syndicate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__SYNDICATE = eINSTANCE.getAccessControl_Syndicate();

		/**
		 * The meta object literal for the '<em><b>Comment Vote</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__COMMENT_VOTE = eINSTANCE.getAccessControl_CommentVote();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__RATE = eINSTANCE.getAccessControl_Rate();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__LIST = eINSTANCE.getAccessControl_List();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__COMMENT = eINSTANCE.getAccessControl_Comment();

		/**
		 * The meta object literal for the '<em><b>Embed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__EMBED = eINSTANCE.getAccessControl_Embed();

		/**
		 * The meta object literal for the '<em><b>Video Respond</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_CONTROL__VIDEO_RESPOND = eINSTANCE.getAccessControl_VideoRespond();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.StatusImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getStatus()
		 * @generated
		 */
		EClass STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__VALUE = eINSTANCE.getStatus_Value();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__REASON = eINSTANCE.getStatus_Reason();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.ThumbnailImpl <em>Thumbnail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.ThumbnailImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getThumbnail()
		 * @generated
		 */
		EClass THUMBNAIL = eINSTANCE.getThumbnail();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THUMBNAIL__DEFAULT = eINSTANCE.getThumbnail_Default();

		/**
		 * The meta object literal for the '<em><b>Hq Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THUMBNAIL__HQ_DEFAULT = eINSTANCE.getThumbnail_HqDefault();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.PlayerImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__DEFAULT = eINSTANCE.getPlayer_Default();

		/**
		 * The meta object literal for the '<em><b>Mobile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__MOBILE = eINSTANCE.getPlayer_Mobile();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.impl.ContentImpl
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Rtsp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__RTSP = eINSTANCE.getContent_Rtsp();

		/**
		 * The meta object literal for the '<em><b>Http</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__HTTP = eINSTANCE.getContent_Http();

		/**
		 * The meta object literal for the '<em><b>Rtsp Mpeg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__RTSP_MPEG = eINSTANCE.getContent_RtspMpeg();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.AspectRatio <em>Aspect Ratio</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.AspectRatio
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getAspectRatio()
		 * @generated
		 */
		EEnum ASPECT_RATIO = eINSTANCE.getAspectRatio();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.youtube.Access <em>Access</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.youtube.Access
		 * @see org.eclipselabs.emfjson.youtube.impl.YoutubePackageImpl#getAccess()
		 * @generated
		 */
		EEnum ACCESS = eINSTANCE.getAccess();

	}

} //YoutubePackage
