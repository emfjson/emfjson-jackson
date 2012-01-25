/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipselabs.emfjson.youtube.Access;
import org.eclipselabs.emfjson.youtube.AccessControl;
import org.eclipselabs.emfjson.youtube.AspectRatio;
import org.eclipselabs.emfjson.youtube.Content;
import org.eclipselabs.emfjson.youtube.Player;
import org.eclipselabs.emfjson.youtube.Status;
import org.eclipselabs.emfjson.youtube.Thumbnail;
import org.eclipselabs.emfjson.youtube.VideoItem;
import org.eclipselabs.emfjson.youtube.VideoResult;
import org.eclipselabs.emfjson.youtube.YoutubeFactory;
import org.eclipselabs.emfjson.youtube.YoutubePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class YoutubePackageImpl extends EPackageImpl implements YoutubePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass videoResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass videoItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thumbnailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aspectRatioEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private YoutubePackageImpl() {
		super(eNS_URI, YoutubeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link YoutubePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static YoutubePackage init() {
		if (isInited) return (YoutubePackage)EPackage.Registry.INSTANCE.getEPackage(YoutubePackage.eNS_URI);

		// Obtain or create and register package
		YoutubePackageImpl theYoutubePackage = (YoutubePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof YoutubePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new YoutubePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theYoutubePackage.createPackageContents();

		// Initialize created meta-data
		theYoutubePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theYoutubePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(YoutubePackage.eNS_URI, theYoutubePackage);
		return theYoutubePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVideoResult() {
		return videoResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoResult_Updated() {
		return (EAttribute)videoResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoResult_TotalItems() {
		return (EAttribute)videoResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoResult_StartIndex() {
		return (EAttribute)videoResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoResult_ItemsPerPage() {
		return (EAttribute)videoResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVideoResult_Items() {
		return (EReference)videoResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVideoItem() {
		return videoItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Id() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Uploaded() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Updated() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Uploader() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Category() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Title() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Description() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Tags() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Duration() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_AspectRatio() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_LikeCount() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_Rating() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_RatingCount() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_ViewCount() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_FavoriteCount() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVideoItem_CommentCount() {
		return (EAttribute)videoItemEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVideoItem_Status() {
		return (EReference)videoItemEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVideoItem_AccessControl() {
		return (EReference)videoItemEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVideoItem_Thumbnail() {
		return (EReference)videoItemEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVideoItem_Player() {
		return (EReference)videoItemEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVideoItem_Content() {
		return (EReference)videoItemEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccessControl() {
		return accessControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_Syndicate() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_CommentVote() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_Rate() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_List() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_Comment() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_Embed() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessControl_VideoRespond() {
		return (EAttribute)accessControlEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatus() {
		return statusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatus_Value() {
		return (EAttribute)statusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatus_Reason() {
		return (EAttribute)statusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThumbnail() {
		return thumbnailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThumbnail_Default() {
		return (EAttribute)thumbnailEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThumbnail_HqDefault() {
		return (EAttribute)thumbnailEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlayer() {
		return playerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Default() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Mobile() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContent() {
		return contentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContent_Rtsp() {
		return (EAttribute)contentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContent_Http() {
		return (EAttribute)contentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContent_RtspMpeg() {
		return (EAttribute)contentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAspectRatio() {
		return aspectRatioEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccess() {
		return accessEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YoutubeFactory getYoutubeFactory() {
		return (YoutubeFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		videoResultEClass = createEClass(VIDEO_RESULT);
		createEAttribute(videoResultEClass, VIDEO_RESULT__UPDATED);
		createEAttribute(videoResultEClass, VIDEO_RESULT__TOTAL_ITEMS);
		createEAttribute(videoResultEClass, VIDEO_RESULT__START_INDEX);
		createEAttribute(videoResultEClass, VIDEO_RESULT__ITEMS_PER_PAGE);
		createEReference(videoResultEClass, VIDEO_RESULT__ITEMS);

		videoItemEClass = createEClass(VIDEO_ITEM);
		createEAttribute(videoItemEClass, VIDEO_ITEM__ID);
		createEAttribute(videoItemEClass, VIDEO_ITEM__UPLOADED);
		createEAttribute(videoItemEClass, VIDEO_ITEM__UPDATED);
		createEAttribute(videoItemEClass, VIDEO_ITEM__UPLOADER);
		createEAttribute(videoItemEClass, VIDEO_ITEM__CATEGORY);
		createEAttribute(videoItemEClass, VIDEO_ITEM__TITLE);
		createEAttribute(videoItemEClass, VIDEO_ITEM__DESCRIPTION);
		createEAttribute(videoItemEClass, VIDEO_ITEM__TAGS);
		createEAttribute(videoItemEClass, VIDEO_ITEM__DURATION);
		createEAttribute(videoItemEClass, VIDEO_ITEM__ASPECT_RATIO);
		createEAttribute(videoItemEClass, VIDEO_ITEM__LIKE_COUNT);
		createEAttribute(videoItemEClass, VIDEO_ITEM__RATING);
		createEAttribute(videoItemEClass, VIDEO_ITEM__RATING_COUNT);
		createEAttribute(videoItemEClass, VIDEO_ITEM__VIEW_COUNT);
		createEAttribute(videoItemEClass, VIDEO_ITEM__FAVORITE_COUNT);
		createEAttribute(videoItemEClass, VIDEO_ITEM__COMMENT_COUNT);
		createEReference(videoItemEClass, VIDEO_ITEM__STATUS);
		createEReference(videoItemEClass, VIDEO_ITEM__ACCESS_CONTROL);
		createEReference(videoItemEClass, VIDEO_ITEM__THUMBNAIL);
		createEReference(videoItemEClass, VIDEO_ITEM__PLAYER);
		createEReference(videoItemEClass, VIDEO_ITEM__CONTENT);

		accessControlEClass = createEClass(ACCESS_CONTROL);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__SYNDICATE);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__COMMENT_VOTE);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__RATE);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__LIST);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__COMMENT);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__EMBED);
		createEAttribute(accessControlEClass, ACCESS_CONTROL__VIDEO_RESPOND);

		statusEClass = createEClass(STATUS);
		createEAttribute(statusEClass, STATUS__VALUE);
		createEAttribute(statusEClass, STATUS__REASON);

		thumbnailEClass = createEClass(THUMBNAIL);
		createEAttribute(thumbnailEClass, THUMBNAIL__DEFAULT);
		createEAttribute(thumbnailEClass, THUMBNAIL__HQ_DEFAULT);

		playerEClass = createEClass(PLAYER);
		createEAttribute(playerEClass, PLAYER__DEFAULT);
		createEAttribute(playerEClass, PLAYER__MOBILE);

		contentEClass = createEClass(CONTENT);
		createEAttribute(contentEClass, CONTENT__RTSP);
		createEAttribute(contentEClass, CONTENT__HTTP);
		createEAttribute(contentEClass, CONTENT__RTSP_MPEG);

		// Create enums
		aspectRatioEEnum = createEEnum(ASPECT_RATIO);
		accessEEnum = createEEnum(ACCESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(videoResultEClass, VideoResult.class, "VideoResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVideoResult_Updated(), ecorePackage.getEDate(), "updated", null, 0, 1, VideoResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoResult_TotalItems(), ecorePackage.getEIntegerObject(), "totalItems", null, 0, 1, VideoResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoResult_StartIndex(), ecorePackage.getEIntegerObject(), "startIndex", null, 0, 1, VideoResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoResult_ItemsPerPage(), ecorePackage.getEIntegerObject(), "itemsPerPage", null, 0, 1, VideoResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVideoResult_Items(), this.getVideoItem(), null, "items", null, 0, -1, VideoResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(videoItemEClass, VideoItem.class, "VideoItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVideoItem_Id(), ecorePackage.getEString(), "id", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Uploaded(), ecorePackage.getEDate(), "uploaded", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Updated(), ecorePackage.getEDate(), "updated", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Uploader(), ecorePackage.getEString(), "uploader", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Category(), ecorePackage.getEString(), "category", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Title(), ecorePackage.getEString(), "title", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Tags(), ecorePackage.getEString(), "tags", null, 0, -1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Duration(), ecorePackage.getEIntegerObject(), "duration", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_AspectRatio(), this.getAspectRatio(), "aspectRatio", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_LikeCount(), ecorePackage.getEIntegerObject(), "likeCount", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_Rating(), ecorePackage.getEDoubleObject(), "rating", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_RatingCount(), ecorePackage.getEIntegerObject(), "ratingCount", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_ViewCount(), ecorePackage.getEIntegerObject(), "viewCount", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_FavoriteCount(), ecorePackage.getEIntegerObject(), "favoriteCount", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVideoItem_CommentCount(), ecorePackage.getEIntegerObject(), "commentCount", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVideoItem_Status(), this.getStatus(), null, "status", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVideoItem_AccessControl(), this.getAccessControl(), null, "accessControl", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVideoItem_Thumbnail(), this.getThumbnail(), null, "thumbnail", null, 1, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVideoItem_Player(), this.getPlayer(), null, "player", null, 1, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVideoItem_Content(), this.getContent(), null, "content", null, 0, 1, VideoItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessControlEClass, AccessControl.class, "AccessControl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAccessControl_Syndicate(), this.getAccess(), "syndicate", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessControl_CommentVote(), this.getAccess(), "commentVote", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessControl_Rate(), this.getAccess(), "rate", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessControl_List(), this.getAccess(), "list", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessControl_Comment(), this.getAccess(), "comment", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessControl_Embed(), this.getAccess(), "embed", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessControl_VideoRespond(), this.getAccess(), "videoRespond", null, 0, 1, AccessControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statusEClass, Status.class, "Status", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatus_Value(), ecorePackage.getEString(), "value", null, 0, 1, Status.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatus_Reason(), ecorePackage.getEString(), "reason", null, 0, 1, Status.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thumbnailEClass, Thumbnail.class, "Thumbnail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThumbnail_Default(), ecorePackage.getEString(), "default", null, 0, 1, Thumbnail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThumbnail_HqDefault(), ecorePackage.getEString(), "hqDefault", null, 0, 1, Thumbnail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playerEClass, Player.class, "Player", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlayer_Default(), ecorePackage.getEString(), "default", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlayer_Mobile(), ecorePackage.getEString(), "mobile", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contentEClass, Content.class, "Content", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContent_Rtsp(), ecorePackage.getEString(), "rtsp", null, 0, 1, Content.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContent_Http(), ecorePackage.getEString(), "http", null, 0, 1, Content.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContent_RtspMpeg(), ecorePackage.getEString(), "rtspMpeg", null, 0, 1, Content.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(aspectRatioEEnum, AspectRatio.class, "AspectRatio");
		addEEnumLiteral(aspectRatioEEnum, AspectRatio.WIDESCREEN);

		initEEnum(accessEEnum, Access.class, "Access");
		addEEnumLiteral(accessEEnum, Access.ALLOWED);
		addEEnumLiteral(accessEEnum, Access.MODERATED);
		addEEnumLiteral(accessEEnum, Access.DENIED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// JSON
		createJSONAnnotations();
	}

	/**
	 * Initializes the annotations for <b>JSON</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createJSONAnnotations() {
		String source = "JSON";		
		addAnnotation
		  (videoResultEClass, 
		   source, 
		   new String[] {
			 "root", "true",
			 "element", "data"
		   });		
		addAnnotation
		  (getContent_Rtsp(), 
		   source, 
		   new String[] {
			 "element", "1"
		   });		
		addAnnotation
		  (getContent_Http(), 
		   source, 
		   new String[] {
			 "element", "5"
		   });		
		addAnnotation
		  (getContent_RtspMpeg(), 
		   source, 
		   new String[] {
			 "element", "6"
		   });
	}

} //YoutubePackageImpl
