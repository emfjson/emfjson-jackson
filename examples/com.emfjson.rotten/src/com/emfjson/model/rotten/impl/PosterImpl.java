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
package com.emfjson.model.rotten.impl;

import com.emfjson.model.rotten.Poster;
import com.emfjson.model.rotten.RottenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Poster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.impl.PosterImpl#getThumbnail <em>Thumbnail</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.PosterImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.PosterImpl#getDetailed <em>Detailed</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.PosterImpl#getOriginal <em>Original</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PosterImpl extends EObjectImpl implements Poster {
	/**
	 * The default value of the '{@link #getThumbnail() <em>Thumbnail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnail()
	 * @generated
	 * @ordered
	 */
	protected static final String THUMBNAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThumbnail() <em>Thumbnail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnail()
	 * @generated
	 * @ordered
	 */
	protected String thumbnail = THUMBNAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfile() <em>Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected String profile = PROFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDetailed() <em>Detailed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailed()
	 * @generated
	 * @ordered
	 */
	protected static final String DETAILED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDetailed() <em>Detailed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailed()
	 * @generated
	 * @ordered
	 */
	protected String detailed = DETAILED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginal() <em>Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginal()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginal() <em>Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginal()
	 * @generated
	 * @ordered
	 */
	protected String original = ORIGINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PosterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.POSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThumbnail(String newThumbnail) {
		String oldThumbnail = thumbnail;
		thumbnail = newThumbnail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.POSTER__THUMBNAIL, oldThumbnail, thumbnail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfile(String newProfile) {
		String oldProfile = profile;
		profile = newProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.POSTER__PROFILE, oldProfile, profile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDetailed() {
		return detailed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailed(String newDetailed) {
		String oldDetailed = detailed;
		detailed = newDetailed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.POSTER__DETAILED, oldDetailed, detailed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginal() {
		return original;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginal(String newOriginal) {
		String oldOriginal = original;
		original = newOriginal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.POSTER__ORIGINAL, oldOriginal, original));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RottenPackage.POSTER__THUMBNAIL:
				return getThumbnail();
			case RottenPackage.POSTER__PROFILE:
				return getProfile();
			case RottenPackage.POSTER__DETAILED:
				return getDetailed();
			case RottenPackage.POSTER__ORIGINAL:
				return getOriginal();
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
			case RottenPackage.POSTER__THUMBNAIL:
				setThumbnail((String)newValue);
				return;
			case RottenPackage.POSTER__PROFILE:
				setProfile((String)newValue);
				return;
			case RottenPackage.POSTER__DETAILED:
				setDetailed((String)newValue);
				return;
			case RottenPackage.POSTER__ORIGINAL:
				setOriginal((String)newValue);
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
			case RottenPackage.POSTER__THUMBNAIL:
				setThumbnail(THUMBNAIL_EDEFAULT);
				return;
			case RottenPackage.POSTER__PROFILE:
				setProfile(PROFILE_EDEFAULT);
				return;
			case RottenPackage.POSTER__DETAILED:
				setDetailed(DETAILED_EDEFAULT);
				return;
			case RottenPackage.POSTER__ORIGINAL:
				setOriginal(ORIGINAL_EDEFAULT);
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
			case RottenPackage.POSTER__THUMBNAIL:
				return THUMBNAIL_EDEFAULT == null ? thumbnail != null : !THUMBNAIL_EDEFAULT.equals(thumbnail);
			case RottenPackage.POSTER__PROFILE:
				return PROFILE_EDEFAULT == null ? profile != null : !PROFILE_EDEFAULT.equals(profile);
			case RottenPackage.POSTER__DETAILED:
				return DETAILED_EDEFAULT == null ? detailed != null : !DETAILED_EDEFAULT.equals(detailed);
			case RottenPackage.POSTER__ORIGINAL:
				return ORIGINAL_EDEFAULT == null ? original != null : !ORIGINAL_EDEFAULT.equals(original);
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
		result.append(" (thumbnail: ");
		result.append(thumbnail);
		result.append(", profile: ");
		result.append(profile);
		result.append(", detailed: ");
		result.append(detailed);
		result.append(", original: ");
		result.append(original);
		result.append(')');
		return result.toString();
	}

} //PosterImpl
