/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipselabs.emfjson.youtube.Access;
import org.eclipselabs.emfjson.youtube.AccessControl;
import org.eclipselabs.emfjson.youtube.YoutubePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getSyndicate <em>Syndicate</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getCommentVote <em>Comment Vote</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getRate <em>Rate</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getList <em>List</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getEmbed <em>Embed</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.AccessControlImpl#getVideoRespond <em>Video Respond</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccessControlImpl extends EObjectImpl implements AccessControl {
	/**
	 * The default value of the '{@link #getSyndicate() <em>Syndicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyndicate()
	 * @generated
	 * @ordered
	 */
	protected static final Access SYNDICATE_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getSyndicate() <em>Syndicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyndicate()
	 * @generated
	 * @ordered
	 */
	protected Access syndicate = SYNDICATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommentVote() <em>Comment Vote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentVote()
	 * @generated
	 * @ordered
	 */
	protected static final Access COMMENT_VOTE_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getCommentVote() <em>Comment Vote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentVote()
	 * @generated
	 * @ordered
	 */
	protected Access commentVote = COMMENT_VOTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRate() <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRate()
	 * @generated
	 * @ordered
	 */
	protected static final Access RATE_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getRate() <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRate()
	 * @generated
	 * @ordered
	 */
	protected Access rate = RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getList()
	 * @generated
	 * @ordered
	 */
	protected static final Access LIST_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getList()
	 * @generated
	 * @ordered
	 */
	protected Access list = LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final Access COMMENT_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected Access comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmbed() <em>Embed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmbed()
	 * @generated
	 * @ordered
	 */
	protected static final Access EMBED_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getEmbed() <em>Embed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmbed()
	 * @generated
	 * @ordered
	 */
	protected Access embed = EMBED_EDEFAULT;

	/**
	 * The default value of the '{@link #getVideoRespond() <em>Video Respond</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVideoRespond()
	 * @generated
	 * @ordered
	 */
	protected static final Access VIDEO_RESPOND_EDEFAULT = Access.ALLOWED;

	/**
	 * The cached value of the '{@link #getVideoRespond() <em>Video Respond</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVideoRespond()
	 * @generated
	 * @ordered
	 */
	protected Access videoRespond = VIDEO_RESPOND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YoutubePackage.Literals.ACCESS_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getSyndicate() {
		return syndicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyndicate(Access newSyndicate) {
		Access oldSyndicate = syndicate;
		syndicate = newSyndicate == null ? SYNDICATE_EDEFAULT : newSyndicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__SYNDICATE, oldSyndicate, syndicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getCommentVote() {
		return commentVote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommentVote(Access newCommentVote) {
		Access oldCommentVote = commentVote;
		commentVote = newCommentVote == null ? COMMENT_VOTE_EDEFAULT : newCommentVote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__COMMENT_VOTE, oldCommentVote, commentVote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getRate() {
		return rate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRate(Access newRate) {
		Access oldRate = rate;
		rate = newRate == null ? RATE_EDEFAULT : newRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__RATE, oldRate, rate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getList() {
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(Access newList) {
		Access oldList = list;
		list = newList == null ? LIST_EDEFAULT : newList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__LIST, oldList, list));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(Access newComment) {
		Access oldComment = comment;
		comment = newComment == null ? COMMENT_EDEFAULT : newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getEmbed() {
		return embed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmbed(Access newEmbed) {
		Access oldEmbed = embed;
		embed = newEmbed == null ? EMBED_EDEFAULT : newEmbed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__EMBED, oldEmbed, embed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getVideoRespond() {
		return videoRespond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVideoRespond(Access newVideoRespond) {
		Access oldVideoRespond = videoRespond;
		videoRespond = newVideoRespond == null ? VIDEO_RESPOND_EDEFAULT : newVideoRespond;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.ACCESS_CONTROL__VIDEO_RESPOND, oldVideoRespond, videoRespond));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YoutubePackage.ACCESS_CONTROL__SYNDICATE:
				return getSyndicate();
			case YoutubePackage.ACCESS_CONTROL__COMMENT_VOTE:
				return getCommentVote();
			case YoutubePackage.ACCESS_CONTROL__RATE:
				return getRate();
			case YoutubePackage.ACCESS_CONTROL__LIST:
				return getList();
			case YoutubePackage.ACCESS_CONTROL__COMMENT:
				return getComment();
			case YoutubePackage.ACCESS_CONTROL__EMBED:
				return getEmbed();
			case YoutubePackage.ACCESS_CONTROL__VIDEO_RESPOND:
				return getVideoRespond();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YoutubePackage.ACCESS_CONTROL__SYNDICATE:
				setSyndicate((Access)newValue);
				return;
			case YoutubePackage.ACCESS_CONTROL__COMMENT_VOTE:
				setCommentVote((Access)newValue);
				return;
			case YoutubePackage.ACCESS_CONTROL__RATE:
				setRate((Access)newValue);
				return;
			case YoutubePackage.ACCESS_CONTROL__LIST:
				setList((Access)newValue);
				return;
			case YoutubePackage.ACCESS_CONTROL__COMMENT:
				setComment((Access)newValue);
				return;
			case YoutubePackage.ACCESS_CONTROL__EMBED:
				setEmbed((Access)newValue);
				return;
			case YoutubePackage.ACCESS_CONTROL__VIDEO_RESPOND:
				setVideoRespond((Access)newValue);
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
			case YoutubePackage.ACCESS_CONTROL__SYNDICATE:
				setSyndicate(SYNDICATE_EDEFAULT);
				return;
			case YoutubePackage.ACCESS_CONTROL__COMMENT_VOTE:
				setCommentVote(COMMENT_VOTE_EDEFAULT);
				return;
			case YoutubePackage.ACCESS_CONTROL__RATE:
				setRate(RATE_EDEFAULT);
				return;
			case YoutubePackage.ACCESS_CONTROL__LIST:
				setList(LIST_EDEFAULT);
				return;
			case YoutubePackage.ACCESS_CONTROL__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case YoutubePackage.ACCESS_CONTROL__EMBED:
				setEmbed(EMBED_EDEFAULT);
				return;
			case YoutubePackage.ACCESS_CONTROL__VIDEO_RESPOND:
				setVideoRespond(VIDEO_RESPOND_EDEFAULT);
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
			case YoutubePackage.ACCESS_CONTROL__SYNDICATE:
				return syndicate != SYNDICATE_EDEFAULT;
			case YoutubePackage.ACCESS_CONTROL__COMMENT_VOTE:
				return commentVote != COMMENT_VOTE_EDEFAULT;
			case YoutubePackage.ACCESS_CONTROL__RATE:
				return rate != RATE_EDEFAULT;
			case YoutubePackage.ACCESS_CONTROL__LIST:
				return list != LIST_EDEFAULT;
			case YoutubePackage.ACCESS_CONTROL__COMMENT:
				return comment != COMMENT_EDEFAULT;
			case YoutubePackage.ACCESS_CONTROL__EMBED:
				return embed != EMBED_EDEFAULT;
			case YoutubePackage.ACCESS_CONTROL__VIDEO_RESPOND:
				return videoRespond != VIDEO_RESPOND_EDEFAULT;
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
		result.append(" (syndicate: ");
		result.append(syndicate);
		result.append(", commentVote: ");
		result.append(commentVote);
		result.append(", rate: ");
		result.append(rate);
		result.append(", list: ");
		result.append(list);
		result.append(", comment: ");
		result.append(comment);
		result.append(", embed: ");
		result.append(embed);
		result.append(", videoRespond: ");
		result.append(videoRespond);
		result.append(')');
		return result.toString();
	}

} //AccessControlImpl
