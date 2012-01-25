/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Video Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getUploaded <em>Uploaded</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getUpdated <em>Updated</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getUploader <em>Uploader</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getAspectRatio <em>Aspect Ratio</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getLikeCount <em>Like Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getRating <em>Rating</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getRatingCount <em>Rating Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getViewCount <em>View Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getFavoriteCount <em>Favorite Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getCommentCount <em>Comment Count</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getAccessControl <em>Access Control</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getThumbnail <em>Thumbnail</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getPlayer <em>Player</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.VideoItem#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem()
 * @model
 * @generated
 */
public interface VideoItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Uploaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uploaded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uploaded</em>' attribute.
	 * @see #setUploaded(Date)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Uploaded()
	 * @model
	 * @generated
	 */
	Date getUploaded();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getUploaded <em>Uploaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uploaded</em>' attribute.
	 * @see #getUploaded()
	 * @generated
	 */
	void setUploaded(Date value);

	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(Date)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Updated()
	 * @model
	 * @generated
	 */
	Date getUpdated();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #getUpdated()
	 * @generated
	 */
	void setUpdated(Date value);

	/**
	 * Returns the value of the '<em><b>Uploader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uploader</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uploader</em>' attribute.
	 * @see #setUploader(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Uploader()
	 * @model
	 * @generated
	 */
	String getUploader();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getUploader <em>Uploader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uploader</em>' attribute.
	 * @see #getUploader()
	 * @generated
	 */
	void setUploader(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Category()
	 * @model
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' attribute list.
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Tags()
	 * @model
	 * @generated
	 */
	EList<String> getTags();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Duration()
	 * @model
	 * @generated
	 */
	Integer getDuration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Integer value);

	/**
	 * Returns the value of the '<em><b>Aspect Ratio</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.emfjson.youtube.AspectRatio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspect Ratio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect Ratio</em>' attribute.
	 * @see org.eclipselabs.emfjson.youtube.AspectRatio
	 * @see #setAspectRatio(AspectRatio)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_AspectRatio()
	 * @model
	 * @generated
	 */
	AspectRatio getAspectRatio();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getAspectRatio <em>Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect Ratio</em>' attribute.
	 * @see org.eclipselabs.emfjson.youtube.AspectRatio
	 * @see #getAspectRatio()
	 * @generated
	 */
	void setAspectRatio(AspectRatio value);

	/**
	 * Returns the value of the '<em><b>Like Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Like Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Like Count</em>' attribute.
	 * @see #setLikeCount(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_LikeCount()
	 * @model
	 * @generated
	 */
	Integer getLikeCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getLikeCount <em>Like Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Like Count</em>' attribute.
	 * @see #getLikeCount()
	 * @generated
	 */
	void setLikeCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating</em>' attribute.
	 * @see #setRating(Double)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Rating()
	 * @model
	 * @generated
	 */
	Double getRating();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see #getRating()
	 * @generated
	 */
	void setRating(Double value);

	/**
	 * Returns the value of the '<em><b>Rating Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating Count</em>' attribute.
	 * @see #setRatingCount(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_RatingCount()
	 * @model
	 * @generated
	 */
	Integer getRatingCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getRatingCount <em>Rating Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating Count</em>' attribute.
	 * @see #getRatingCount()
	 * @generated
	 */
	void setRatingCount(Integer value);

	/**
	 * Returns the value of the '<em><b>View Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Count</em>' attribute.
	 * @see #setViewCount(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_ViewCount()
	 * @model
	 * @generated
	 */
	Integer getViewCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getViewCount <em>View Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Count</em>' attribute.
	 * @see #getViewCount()
	 * @generated
	 */
	void setViewCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Favorite Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favorite Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favorite Count</em>' attribute.
	 * @see #setFavoriteCount(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_FavoriteCount()
	 * @model
	 * @generated
	 */
	Integer getFavoriteCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getFavoriteCount <em>Favorite Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favorite Count</em>' attribute.
	 * @see #getFavoriteCount()
	 * @generated
	 */
	void setFavoriteCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Comment Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment Count</em>' attribute.
	 * @see #setCommentCount(Integer)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_CommentCount()
	 * @model
	 * @generated
	 */
	Integer getCommentCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getCommentCount <em>Comment Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment Count</em>' attribute.
	 * @see #getCommentCount()
	 * @generated
	 */
	void setCommentCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' containment reference.
	 * @see #setStatus(Status)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Status()
	 * @model containment="true"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getStatus <em>Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' containment reference.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

	/**
	 * Returns the value of the '<em><b>Access Control</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Control</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Control</em>' containment reference.
	 * @see #setAccessControl(AccessControl)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_AccessControl()
	 * @model containment="true"
	 * @generated
	 */
	AccessControl getAccessControl();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getAccessControl <em>Access Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Control</em>' containment reference.
	 * @see #getAccessControl()
	 * @generated
	 */
	void setAccessControl(AccessControl value);

	/**
	 * Returns the value of the '<em><b>Thumbnail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thumbnail</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thumbnail</em>' containment reference.
	 * @see #setThumbnail(Thumbnail)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Thumbnail()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Thumbnail getThumbnail();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getThumbnail <em>Thumbnail</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thumbnail</em>' containment reference.
	 * @see #getThumbnail()
	 * @generated
	 */
	void setThumbnail(Thumbnail value);

	/**
	 * Returns the value of the '<em><b>Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Player</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' containment reference.
	 * @see #setPlayer(Player)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Player()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Player getPlayer();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getPlayer <em>Player</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player</em>' containment reference.
	 * @see #getPlayer()
	 * @generated
	 */
	void setPlayer(Player value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference.
	 * @see #setContent(Content)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getVideoItem_Content()
	 * @model containment="true"
	 * @generated
	 */
	Content getContent();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.VideoItem#getContent <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' containment reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(Content value);

} // VideoItem
