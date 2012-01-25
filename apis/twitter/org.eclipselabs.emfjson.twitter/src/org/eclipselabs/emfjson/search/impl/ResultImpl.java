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
package org.eclipselabs.emfjson.search.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.emfjson.search.Metadata;
import org.eclipselabs.emfjson.search.Result;
import org.eclipselabs.emfjson.search.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getCreatedAt <em>Created At</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getToUserId <em>To User Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getToUser <em>To User</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getFromUser <em>From User</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getMetadata <em>Metadata</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getSinceId <em>Since Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getProfileImageUrl <em>Profile Image Url</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getFromUserIdStr <em>From User Id Str</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getGeo <em>Geo</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getIsoLangCode <em>Iso Lang Code</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.ResultImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultImpl extends EObjectImpl implements Result {
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
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatedAt() <em>Created At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedAt()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_AT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatedAt() <em>Created At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedAt()
	 * @generated
	 * @ordered
	 */
	protected String createdAt = CREATED_AT_EDEFAULT;

	/**
	 * The default value of the '{@link #getToUserId() <em>To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToUserId() <em>To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUserId()
	 * @generated
	 * @ordered
	 */
	protected String toUserId = TO_USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getToUser() <em>To User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUser()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToUser() <em>To User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUser()
	 * @generated
	 * @ordered
	 */
	protected String toUser = TO_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromUser() <em>From User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromUser()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromUser() <em>From User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromUser()
	 * @generated
	 * @ordered
	 */
	protected String fromUser = FROM_USER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetadata() <em>Metadata</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadata()
	 * @generated
	 * @ordered
	 */
	protected EList<Metadata> metadata;

	/**
	 * The default value of the '{@link #getSinceId() <em>Since Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SINCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSinceId() <em>Since Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinceId()
	 * @generated
	 * @ordered
	 */
	protected String sinceId = SINCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileImageUrl() <em>Profile Image Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileImageUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_IMAGE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileImageUrl() <em>Profile Image Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileImageUrl()
	 * @generated
	 * @ordered
	 */
	protected String profileImageUrl = PROFILE_IMAGE_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromUserIdStr() <em>From User Id Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromUserIdStr()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_USER_ID_STR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromUserIdStr() <em>From User Id Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromUserIdStr()
	 * @generated
	 * @ordered
	 */
	protected String fromUserIdStr = FROM_USER_ID_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeo() <em>Geo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeo()
	 * @generated
	 * @ordered
	 */
	protected static final String GEO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeo() <em>Geo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeo()
	 * @generated
	 * @ordered
	 */
	protected String geo = GEO_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsoLangCode() <em>Iso Lang Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsoLangCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ISO_LANG_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsoLangCode() <em>Iso Lang Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsoLangCode()
	 * @generated
	 * @ordered
	 */
	protected String isoLangCode = ISO_LANG_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchPackage.Literals.RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedAt(String newCreatedAt) {
		String oldCreatedAt = createdAt;
		createdAt = newCreatedAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__CREATED_AT, oldCreatedAt, createdAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToUserId() {
		return toUserId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToUserId(String newToUserId) {
		String oldToUserId = toUserId;
		toUserId = newToUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__TO_USER_ID, oldToUserId, toUserId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToUser() {
		return toUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToUser(String newToUser) {
		String oldToUser = toUser;
		toUser = newToUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__TO_USER, oldToUser, toUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFromUser() {
		return fromUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromUser(String newFromUser) {
		String oldFromUser = fromUser;
		fromUser = newFromUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__FROM_USER, oldFromUser, fromUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metadata> getMetadata() {
		if (metadata == null) {
			metadata = new EObjectContainmentEList<Metadata>(Metadata.class, this, SearchPackage.RESULT__METADATA);
		}
		return metadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSinceId() {
		return sinceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSinceId(String newSinceId) {
		String oldSinceId = sinceId;
		sinceId = newSinceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__SINCE_ID, oldSinceId, sinceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileImageUrl(String newProfileImageUrl) {
		String oldProfileImageUrl = profileImageUrl;
		profileImageUrl = newProfileImageUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__PROFILE_IMAGE_URL, oldProfileImageUrl, profileImageUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFromUserIdStr() {
		return fromUserIdStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromUserIdStr(String newFromUserIdStr) {
		String oldFromUserIdStr = fromUserIdStr;
		fromUserIdStr = newFromUserIdStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__FROM_USER_ID_STR, oldFromUserIdStr, fromUserIdStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeo() {
		return geo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeo(String newGeo) {
		String oldGeo = geo;
		geo = newGeo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__GEO, oldGeo, geo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsoLangCode() {
		return isoLangCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsoLangCode(String newIsoLangCode) {
		String oldIsoLangCode = isoLangCode;
		isoLangCode = newIsoLangCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__ISO_LANG_CODE, oldIsoLangCode, isoLangCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchPackage.RESULT__METADATA:
				return ((InternalEList<?>)getMetadata()).basicRemove(otherEnd, msgs);
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
			case SearchPackage.RESULT__ID:
				return getId();
			case SearchPackage.RESULT__TEXT:
				return getText();
			case SearchPackage.RESULT__CREATED_AT:
				return getCreatedAt();
			case SearchPackage.RESULT__TO_USER_ID:
				return getToUserId();
			case SearchPackage.RESULT__TO_USER:
				return getToUser();
			case SearchPackage.RESULT__FROM_USER:
				return getFromUser();
			case SearchPackage.RESULT__METADATA:
				return getMetadata();
			case SearchPackage.RESULT__SINCE_ID:
				return getSinceId();
			case SearchPackage.RESULT__PROFILE_IMAGE_URL:
				return getProfileImageUrl();
			case SearchPackage.RESULT__FROM_USER_ID_STR:
				return getFromUserIdStr();
			case SearchPackage.RESULT__GEO:
				return getGeo();
			case SearchPackage.RESULT__ISO_LANG_CODE:
				return getIsoLangCode();
			case SearchPackage.RESULT__SOURCE:
				return getSource();
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
			case SearchPackage.RESULT__ID:
				setId((String)newValue);
				return;
			case SearchPackage.RESULT__TEXT:
				setText((String)newValue);
				return;
			case SearchPackage.RESULT__CREATED_AT:
				setCreatedAt((String)newValue);
				return;
			case SearchPackage.RESULT__TO_USER_ID:
				setToUserId((String)newValue);
				return;
			case SearchPackage.RESULT__TO_USER:
				setToUser((String)newValue);
				return;
			case SearchPackage.RESULT__FROM_USER:
				setFromUser((String)newValue);
				return;
			case SearchPackage.RESULT__METADATA:
				getMetadata().clear();
				getMetadata().addAll((Collection<? extends Metadata>)newValue);
				return;
			case SearchPackage.RESULT__SINCE_ID:
				setSinceId((String)newValue);
				return;
			case SearchPackage.RESULT__PROFILE_IMAGE_URL:
				setProfileImageUrl((String)newValue);
				return;
			case SearchPackage.RESULT__FROM_USER_ID_STR:
				setFromUserIdStr((String)newValue);
				return;
			case SearchPackage.RESULT__GEO:
				setGeo((String)newValue);
				return;
			case SearchPackage.RESULT__ISO_LANG_CODE:
				setIsoLangCode((String)newValue);
				return;
			case SearchPackage.RESULT__SOURCE:
				setSource((String)newValue);
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
			case SearchPackage.RESULT__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchPackage.RESULT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case SearchPackage.RESULT__CREATED_AT:
				setCreatedAt(CREATED_AT_EDEFAULT);
				return;
			case SearchPackage.RESULT__TO_USER_ID:
				setToUserId(TO_USER_ID_EDEFAULT);
				return;
			case SearchPackage.RESULT__TO_USER:
				setToUser(TO_USER_EDEFAULT);
				return;
			case SearchPackage.RESULT__FROM_USER:
				setFromUser(FROM_USER_EDEFAULT);
				return;
			case SearchPackage.RESULT__METADATA:
				getMetadata().clear();
				return;
			case SearchPackage.RESULT__SINCE_ID:
				setSinceId(SINCE_ID_EDEFAULT);
				return;
			case SearchPackage.RESULT__PROFILE_IMAGE_URL:
				setProfileImageUrl(PROFILE_IMAGE_URL_EDEFAULT);
				return;
			case SearchPackage.RESULT__FROM_USER_ID_STR:
				setFromUserIdStr(FROM_USER_ID_STR_EDEFAULT);
				return;
			case SearchPackage.RESULT__GEO:
				setGeo(GEO_EDEFAULT);
				return;
			case SearchPackage.RESULT__ISO_LANG_CODE:
				setIsoLangCode(ISO_LANG_CODE_EDEFAULT);
				return;
			case SearchPackage.RESULT__SOURCE:
				setSource(SOURCE_EDEFAULT);
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
			case SearchPackage.RESULT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchPackage.RESULT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case SearchPackage.RESULT__CREATED_AT:
				return CREATED_AT_EDEFAULT == null ? createdAt != null : !CREATED_AT_EDEFAULT.equals(createdAt);
			case SearchPackage.RESULT__TO_USER_ID:
				return TO_USER_ID_EDEFAULT == null ? toUserId != null : !TO_USER_ID_EDEFAULT.equals(toUserId);
			case SearchPackage.RESULT__TO_USER:
				return TO_USER_EDEFAULT == null ? toUser != null : !TO_USER_EDEFAULT.equals(toUser);
			case SearchPackage.RESULT__FROM_USER:
				return FROM_USER_EDEFAULT == null ? fromUser != null : !FROM_USER_EDEFAULT.equals(fromUser);
			case SearchPackage.RESULT__METADATA:
				return metadata != null && !metadata.isEmpty();
			case SearchPackage.RESULT__SINCE_ID:
				return SINCE_ID_EDEFAULT == null ? sinceId != null : !SINCE_ID_EDEFAULT.equals(sinceId);
			case SearchPackage.RESULT__PROFILE_IMAGE_URL:
				return PROFILE_IMAGE_URL_EDEFAULT == null ? profileImageUrl != null : !PROFILE_IMAGE_URL_EDEFAULT.equals(profileImageUrl);
			case SearchPackage.RESULT__FROM_USER_ID_STR:
				return FROM_USER_ID_STR_EDEFAULT == null ? fromUserIdStr != null : !FROM_USER_ID_STR_EDEFAULT.equals(fromUserIdStr);
			case SearchPackage.RESULT__GEO:
				return GEO_EDEFAULT == null ? geo != null : !GEO_EDEFAULT.equals(geo);
			case SearchPackage.RESULT__ISO_LANG_CODE:
				return ISO_LANG_CODE_EDEFAULT == null ? isoLangCode != null : !ISO_LANG_CODE_EDEFAULT.equals(isoLangCode);
			case SearchPackage.RESULT__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
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
		result.append(", text: ");
		result.append(text);
		result.append(", createdAt: ");
		result.append(createdAt);
		result.append(", toUserId: ");
		result.append(toUserId);
		result.append(", toUser: ");
		result.append(toUser);
		result.append(", fromUser: ");
		result.append(fromUser);
		result.append(", sinceId: ");
		result.append(sinceId);
		result.append(", profileImageUrl: ");
		result.append(profileImageUrl);
		result.append(", fromUserIdStr: ");
		result.append(fromUserIdStr);
		result.append(", geo: ");
		result.append(geo);
		result.append(", isoLangCode: ");
		result.append(isoLangCode);
		result.append(", source: ");
		result.append(source);
		result.append(')');
		return result.toString();
	}

} //ResultImpl
