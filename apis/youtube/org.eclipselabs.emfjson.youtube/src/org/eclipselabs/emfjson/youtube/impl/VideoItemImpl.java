/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipselabs.emfjson.youtube.AccessControl;
import org.eclipselabs.emfjson.youtube.AspectRatio;
import org.eclipselabs.emfjson.youtube.Content;
import org.eclipselabs.emfjson.youtube.Player;
import org.eclipselabs.emfjson.youtube.Status;
import org.eclipselabs.emfjson.youtube.Thumbnail;
import org.eclipselabs.emfjson.youtube.VideoItem;
import org.eclipselabs.emfjson.youtube.YoutubePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getUploaded <em>Uploaded</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getUpdated <em>Updated</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getUploader <em>Uploader</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getAspectRatio <em>Aspect Ratio</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getLikeCount <em>Like Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getRatingCount <em>Rating Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getViewCount <em>View Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getFavoriteCount <em>Favorite Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getCommentCount <em>Comment Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getAccessControl <em>Access Control</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getThumbnail <em>Thumbnail</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoItemImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VideoItemImpl extends EObjectImpl implements VideoItem {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUploaded() <em>Uploaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUploaded()
	 * @generated
	 * @ordered
	 */
	protected static final Date UPLOADED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUploaded() <em>Uploaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUploaded()
	 * @generated
	 * @ordered
	 */
	protected Date uploaded = UPLOADED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date updated = UPDATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUploader() <em>Uploader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUploader()
	 * @generated
	 * @ordered
	 */
	protected static final String UPLOADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUploader() <em>Uploader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUploader()
	 * @generated
	 * @ordered
	 */
	protected String uploader = UPLOADER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tags;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected Integer duration = DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAspectRatio() <em>Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectRatio()
	 * @generated
	 * @ordered
	 */
	protected static final AspectRatio ASPECT_RATIO_EDEFAULT = AspectRatio.WIDESCREEN;

	/**
	 * The cached value of the '{@link #getAspectRatio() <em>Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectRatio()
	 * @generated
	 * @ordered
	 */
	protected AspectRatio aspectRatio = ASPECT_RATIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getLikeCount() <em>Like Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikeCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LIKE_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLikeCount() <em>Like Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikeCount()
	 * @generated
	 * @ordered
	 */
	protected Integer likeCount = LIKE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected static final Double RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected Double rating = RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRatingCount() <em>Rating Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatingCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer RATING_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRatingCount() <em>Rating Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatingCount()
	 * @generated
	 * @ordered
	 */
	protected Integer ratingCount = RATING_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getViewCount() <em>View Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer VIEW_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewCount() <em>View Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewCount()
	 * @generated
	 * @ordered
	 */
	protected Integer viewCount = VIEW_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFavoriteCount() <em>Favorite Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavoriteCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer FAVORITE_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFavoriteCount() <em>Favorite Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavoriteCount()
	 * @generated
	 * @ordered
	 */
	protected Integer favoriteCount = FAVORITE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommentCount() <em>Comment Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer COMMENT_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommentCount() <em>Comment Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentCount()
	 * @generated
	 * @ordered
	 */
	protected Integer commentCount = COMMENT_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Status status;

	/**
	 * The cached value of the '{@link #getAccessControl() <em>Access Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessControl()
	 * @generated
	 * @ordered
	 */
	protected AccessControl accessControl;

	/**
	 * The cached value of the '{@link #getThumbnail() <em>Thumbnail</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnail()
	 * @generated
	 * @ordered
	 */
	protected Thumbnail thumbnail;

	/**
	 * The cached value of the '{@link #getPlayer() <em>Player</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayer()
	 * @generated
	 * @ordered
	 */
	protected Player player;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected Content content;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VideoItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YoutubePackage.Literals.VIDEO_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getUploaded() {
		return uploaded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUploaded(Date newUploaded) {
		Date oldUploaded = uploaded;
		uploaded = newUploaded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__UPLOADED, oldUploaded, uploaded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdated(Date newUpdated) {
		Date oldUpdated = updated;
		updated = newUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__UPDATED, oldUpdated, updated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUploader() {
		return uploader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUploader(String newUploader) {
		String oldUploader = uploader;
		uploader = newUploader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__UPLOADER, oldUploader, uploader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<String>(String.class, this, YoutubePackage.VIDEO_ITEM__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(Integer newDuration) {
		Integer oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectRatio getAspectRatio() {
		return aspectRatio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAspectRatio(AspectRatio newAspectRatio) {
		AspectRatio oldAspectRatio = aspectRatio;
		aspectRatio = newAspectRatio == null ? ASPECT_RATIO_EDEFAULT : newAspectRatio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__ASPECT_RATIO, oldAspectRatio, aspectRatio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLikeCount() {
		return likeCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLikeCount(Integer newLikeCount) {
		Integer oldLikeCount = likeCount;
		likeCount = newLikeCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__LIKE_COUNT, oldLikeCount, likeCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRating(Double newRating) {
		Double oldRating = rating;
		rating = newRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__RATING, oldRating, rating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getRatingCount() {
		return ratingCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatingCount(Integer newRatingCount) {
		Integer oldRatingCount = ratingCount;
		ratingCount = newRatingCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__RATING_COUNT, oldRatingCount, ratingCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewCount(Integer newViewCount) {
		Integer oldViewCount = viewCount;
		viewCount = newViewCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__VIEW_COUNT, oldViewCount, viewCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFavoriteCount(Integer newFavoriteCount) {
		Integer oldFavoriteCount = favoriteCount;
		favoriteCount = newFavoriteCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__FAVORITE_COUNT, oldFavoriteCount, favoriteCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommentCount(Integer newCommentCount) {
		Integer oldCommentCount = commentCount;
		commentCount = newCommentCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__COMMENT_COUNT, oldCommentCount, commentCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatus(Status newStatus, NotificationChain msgs) {
		Status oldStatus = status;
		status = newStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__STATUS, oldStatus, newStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Status newStatus) {
		if (newStatus != status) {
			NotificationChain msgs = null;
			if (status != null)
				msgs = ((InternalEObject)status).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__STATUS, null, msgs);
			if (newStatus != null)
				msgs = ((InternalEObject)newStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__STATUS, null, msgs);
			msgs = basicSetStatus(newStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__STATUS, newStatus, newStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControl getAccessControl() {
		return accessControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessControl(AccessControl newAccessControl, NotificationChain msgs) {
		AccessControl oldAccessControl = accessControl;
		accessControl = newAccessControl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL, oldAccessControl, newAccessControl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessControl(AccessControl newAccessControl) {
		if (newAccessControl != accessControl) {
			NotificationChain msgs = null;
			if (accessControl != null)
				msgs = ((InternalEObject)accessControl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL, null, msgs);
			if (newAccessControl != null)
				msgs = ((InternalEObject)newAccessControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL, null, msgs);
			msgs = basicSetAccessControl(newAccessControl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL, newAccessControl, newAccessControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThumbnail(Thumbnail newThumbnail, NotificationChain msgs) {
		Thumbnail oldThumbnail = thumbnail;
		thumbnail = newThumbnail;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__THUMBNAIL, oldThumbnail, newThumbnail);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThumbnail(Thumbnail newThumbnail) {
		if (newThumbnail != thumbnail) {
			NotificationChain msgs = null;
			if (thumbnail != null)
				msgs = ((InternalEObject)thumbnail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__THUMBNAIL, null, msgs);
			if (newThumbnail != null)
				msgs = ((InternalEObject)newThumbnail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__THUMBNAIL, null, msgs);
			msgs = basicSetThumbnail(newThumbnail, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__THUMBNAIL, newThumbnail, newThumbnail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayer(Player newPlayer, NotificationChain msgs) {
		Player oldPlayer = player;
		player = newPlayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__PLAYER, oldPlayer, newPlayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayer(Player newPlayer) {
		if (newPlayer != player) {
			NotificationChain msgs = null;
			if (player != null)
				msgs = ((InternalEObject)player).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__PLAYER, null, msgs);
			if (newPlayer != null)
				msgs = ((InternalEObject)newPlayer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__PLAYER, null, msgs);
			msgs = basicSetPlayer(newPlayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__PLAYER, newPlayer, newPlayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Content getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContent(Content newContent, NotificationChain msgs) {
		Content oldContent = content;
		content = newContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__CONTENT, oldContent, newContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(Content newContent) {
		if (newContent != content) {
			NotificationChain msgs = null;
			if (content != null)
				msgs = ((InternalEObject)content).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__CONTENT, null, msgs);
			if (newContent != null)
				msgs = ((InternalEObject)newContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YoutubePackage.VIDEO_ITEM__CONTENT, null, msgs);
			msgs = basicSetContent(newContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_ITEM__CONTENT, newContent, newContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YoutubePackage.VIDEO_ITEM__STATUS:
				return basicSetStatus(null, msgs);
			case YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL:
				return basicSetAccessControl(null, msgs);
			case YoutubePackage.VIDEO_ITEM__THUMBNAIL:
				return basicSetThumbnail(null, msgs);
			case YoutubePackage.VIDEO_ITEM__PLAYER:
				return basicSetPlayer(null, msgs);
			case YoutubePackage.VIDEO_ITEM__CONTENT:
				return basicSetContent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YoutubePackage.VIDEO_ITEM__ID:
				return getId();
			case YoutubePackage.VIDEO_ITEM__UPLOADED:
				return getUploaded();
			case YoutubePackage.VIDEO_ITEM__UPDATED:
				return getUpdated();
			case YoutubePackage.VIDEO_ITEM__UPLOADER:
				return getUploader();
			case YoutubePackage.VIDEO_ITEM__CATEGORY:
				return getCategory();
			case YoutubePackage.VIDEO_ITEM__TITLE:
				return getTitle();
			case YoutubePackage.VIDEO_ITEM__DESCRIPTION:
				return getDescription();
			case YoutubePackage.VIDEO_ITEM__TAGS:
				return getTags();
			case YoutubePackage.VIDEO_ITEM__DURATION:
				return getDuration();
			case YoutubePackage.VIDEO_ITEM__ASPECT_RATIO:
				return getAspectRatio();
			case YoutubePackage.VIDEO_ITEM__LIKE_COUNT:
				return getLikeCount();
			case YoutubePackage.VIDEO_ITEM__RATING:
				return getRating();
			case YoutubePackage.VIDEO_ITEM__RATING_COUNT:
				return getRatingCount();
			case YoutubePackage.VIDEO_ITEM__VIEW_COUNT:
				return getViewCount();
			case YoutubePackage.VIDEO_ITEM__FAVORITE_COUNT:
				return getFavoriteCount();
			case YoutubePackage.VIDEO_ITEM__COMMENT_COUNT:
				return getCommentCount();
			case YoutubePackage.VIDEO_ITEM__STATUS:
				return getStatus();
			case YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL:
				return getAccessControl();
			case YoutubePackage.VIDEO_ITEM__THUMBNAIL:
				return getThumbnail();
			case YoutubePackage.VIDEO_ITEM__PLAYER:
				return getPlayer();
			case YoutubePackage.VIDEO_ITEM__CONTENT:
				return getContent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YoutubePackage.VIDEO_ITEM__ID:
				setId((String)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__UPLOADED:
				setUploaded((Date)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__UPDATED:
				setUpdated((Date)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__UPLOADER:
				setUploader((String)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__CATEGORY:
				setCategory((String)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__TITLE:
				setTitle((String)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__DURATION:
				setDuration((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__ASPECT_RATIO:
				setAspectRatio((AspectRatio)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__LIKE_COUNT:
				setLikeCount((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__RATING:
				setRating((Double)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__RATING_COUNT:
				setRatingCount((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__VIEW_COUNT:
				setViewCount((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__FAVORITE_COUNT:
				setFavoriteCount((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__COMMENT_COUNT:
				setCommentCount((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__STATUS:
				setStatus((Status)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL:
				setAccessControl((AccessControl)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__THUMBNAIL:
				setThumbnail((Thumbnail)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__PLAYER:
				setPlayer((Player)newValue);
				return;
			case YoutubePackage.VIDEO_ITEM__CONTENT:
				setContent((Content)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case YoutubePackage.VIDEO_ITEM__ID:
				setId(ID_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__UPLOADED:
				setUploaded(UPLOADED_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__UPDATED:
				setUpdated(UPDATED_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__UPLOADER:
				setUploader(UPLOADER_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__TAGS:
				getTags().clear();
				return;
			case YoutubePackage.VIDEO_ITEM__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__ASPECT_RATIO:
				setAspectRatio(ASPECT_RATIO_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__LIKE_COUNT:
				setLikeCount(LIKE_COUNT_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__RATING:
				setRating(RATING_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__RATING_COUNT:
				setRatingCount(RATING_COUNT_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__VIEW_COUNT:
				setViewCount(VIEW_COUNT_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__FAVORITE_COUNT:
				setFavoriteCount(FAVORITE_COUNT_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__COMMENT_COUNT:
				setCommentCount(COMMENT_COUNT_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_ITEM__STATUS:
				setStatus((Status)null);
				return;
			case YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL:
				setAccessControl((AccessControl)null);
				return;
			case YoutubePackage.VIDEO_ITEM__THUMBNAIL:
				setThumbnail((Thumbnail)null);
				return;
			case YoutubePackage.VIDEO_ITEM__PLAYER:
				setPlayer((Player)null);
				return;
			case YoutubePackage.VIDEO_ITEM__CONTENT:
				setContent((Content)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YoutubePackage.VIDEO_ITEM__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case YoutubePackage.VIDEO_ITEM__UPLOADED:
				return UPLOADED_EDEFAULT == null ? uploaded != null : !UPLOADED_EDEFAULT.equals(uploaded);
			case YoutubePackage.VIDEO_ITEM__UPDATED:
				return UPDATED_EDEFAULT == null ? updated != null : !UPDATED_EDEFAULT.equals(updated);
			case YoutubePackage.VIDEO_ITEM__UPLOADER:
				return UPLOADER_EDEFAULT == null ? uploader != null : !UPLOADER_EDEFAULT.equals(uploader);
			case YoutubePackage.VIDEO_ITEM__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case YoutubePackage.VIDEO_ITEM__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case YoutubePackage.VIDEO_ITEM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case YoutubePackage.VIDEO_ITEM__TAGS:
				return tags != null && !tags.isEmpty();
			case YoutubePackage.VIDEO_ITEM__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case YoutubePackage.VIDEO_ITEM__ASPECT_RATIO:
				return aspectRatio != ASPECT_RATIO_EDEFAULT;
			case YoutubePackage.VIDEO_ITEM__LIKE_COUNT:
				return LIKE_COUNT_EDEFAULT == null ? likeCount != null : !LIKE_COUNT_EDEFAULT.equals(likeCount);
			case YoutubePackage.VIDEO_ITEM__RATING:
				return RATING_EDEFAULT == null ? rating != null : !RATING_EDEFAULT.equals(rating);
			case YoutubePackage.VIDEO_ITEM__RATING_COUNT:
				return RATING_COUNT_EDEFAULT == null ? ratingCount != null : !RATING_COUNT_EDEFAULT.equals(ratingCount);
			case YoutubePackage.VIDEO_ITEM__VIEW_COUNT:
				return VIEW_COUNT_EDEFAULT == null ? viewCount != null : !VIEW_COUNT_EDEFAULT.equals(viewCount);
			case YoutubePackage.VIDEO_ITEM__FAVORITE_COUNT:
				return FAVORITE_COUNT_EDEFAULT == null ? favoriteCount != null : !FAVORITE_COUNT_EDEFAULT.equals(favoriteCount);
			case YoutubePackage.VIDEO_ITEM__COMMENT_COUNT:
				return COMMENT_COUNT_EDEFAULT == null ? commentCount != null : !COMMENT_COUNT_EDEFAULT.equals(commentCount);
			case YoutubePackage.VIDEO_ITEM__STATUS:
				return status != null;
			case YoutubePackage.VIDEO_ITEM__ACCESS_CONTROL:
				return accessControl != null;
			case YoutubePackage.VIDEO_ITEM__THUMBNAIL:
				return thumbnail != null;
			case YoutubePackage.VIDEO_ITEM__PLAYER:
				return player != null;
			case YoutubePackage.VIDEO_ITEM__CONTENT:
				return content != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", uploaded: ");
		result.append(uploaded);
		result.append(", updated: ");
		result.append(updated);
		result.append(", uploader: ");
		result.append(uploader);
		result.append(", category: ");
		result.append(category);
		result.append(", title: ");
		result.append(title);
		result.append(", description: ");
		result.append(description);
		result.append(", tags: ");
		result.append(tags);
		result.append(", duration: ");
		result.append(duration);
		result.append(", aspectRatio: ");
		result.append(aspectRatio);
		result.append(", likeCount: ");
		result.append(likeCount);
		result.append(", rating: ");
		result.append(rating);
		result.append(", ratingCount: ");
		result.append(ratingCount);
		result.append(", viewCount: ");
		result.append(viewCount);
		result.append(", favoriteCount: ");
		result.append(favoriteCount);
		result.append(", commentCount: ");
		result.append(commentCount);
		result.append(')');
		return result.toString();
	}

} //VideoItemImpl
