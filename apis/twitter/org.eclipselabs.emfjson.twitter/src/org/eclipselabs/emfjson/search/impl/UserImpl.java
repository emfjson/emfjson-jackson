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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipselabs.emfjson.search.SearchPackage;
import org.eclipselabs.emfjson.search.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getExpandedUrl <em>Expanded Url</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getCreatedAt <em>Created At</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getProfileSidebarFillColor <em>Profile Sidebar Fill Color</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getProfileSidebarBorderColor <em>Profile Sidebar Border Color</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getProfileBackgroundTile <em>Profile Background Tile</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.UserImpl#getProfileImageUrl <em>Profile Image Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpandedUrl() <em>Expanded Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandedUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPANDED_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpandedUrl() <em>Expanded Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandedUrl()
	 * @generated
	 * @ordered
	 */
	protected String expandedUrl = EXPANDED_URL_EDEFAULT;

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
	 * The default value of the '{@link #getProfileSidebarFillColor() <em>Profile Sidebar Fill Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileSidebarFillColor()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_SIDEBAR_FILL_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileSidebarFillColor() <em>Profile Sidebar Fill Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileSidebarFillColor()
	 * @generated
	 * @ordered
	 */
	protected String profileSidebarFillColor = PROFILE_SIDEBAR_FILL_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileSidebarBorderColor() <em>Profile Sidebar Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileSidebarBorderColor()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_SIDEBAR_BORDER_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileSidebarBorderColor() <em>Profile Sidebar Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileSidebarBorderColor()
	 * @generated
	 * @ordered
	 */
	protected String profileSidebarBorderColor = PROFILE_SIDEBAR_BORDER_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileBackgroundTile() <em>Profile Background Tile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileBackgroundTile()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PROFILE_BACKGROUND_TILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileBackgroundTile() <em>Profile Background Tile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileBackgroundTile()
	 * @generated
	 * @ordered
	 */
	protected Boolean profileBackgroundTile = PROFILE_BACKGROUND_TILE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchPackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpandedUrl() {
		return expandedUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandedUrl(String newExpandedUrl) {
		String oldExpandedUrl = expandedUrl;
		expandedUrl = newExpandedUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__EXPANDED_URL, oldExpandedUrl, expandedUrl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__CREATED_AT, oldCreatedAt, createdAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileSidebarFillColor() {
		return profileSidebarFillColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileSidebarFillColor(String newProfileSidebarFillColor) {
		String oldProfileSidebarFillColor = profileSidebarFillColor;
		profileSidebarFillColor = newProfileSidebarFillColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__PROFILE_SIDEBAR_FILL_COLOR, oldProfileSidebarFillColor, profileSidebarFillColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileSidebarBorderColor() {
		return profileSidebarBorderColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileSidebarBorderColor(String newProfileSidebarBorderColor) {
		String oldProfileSidebarBorderColor = profileSidebarBorderColor;
		profileSidebarBorderColor = newProfileSidebarBorderColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__PROFILE_SIDEBAR_BORDER_COLOR, oldProfileSidebarBorderColor, profileSidebarBorderColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getProfileBackgroundTile() {
		return profileBackgroundTile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileBackgroundTile(Boolean newProfileBackgroundTile) {
		Boolean oldProfileBackgroundTile = profileBackgroundTile;
		profileBackgroundTile = newProfileBackgroundTile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__PROFILE_BACKGROUND_TILE, oldProfileBackgroundTile, profileBackgroundTile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.USER__PROFILE_IMAGE_URL, oldProfileImageUrl, profileImageUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchPackage.USER__NAME:
				return getName();
			case SearchPackage.USER__LOCATION:
				return getLocation();
			case SearchPackage.USER__EXPANDED_URL:
				return getExpandedUrl();
			case SearchPackage.USER__CREATED_AT:
				return getCreatedAt();
			case SearchPackage.USER__PROFILE_SIDEBAR_FILL_COLOR:
				return getProfileSidebarFillColor();
			case SearchPackage.USER__PROFILE_SIDEBAR_BORDER_COLOR:
				return getProfileSidebarBorderColor();
			case SearchPackage.USER__PROFILE_BACKGROUND_TILE:
				return getProfileBackgroundTile();
			case SearchPackage.USER__PROFILE_IMAGE_URL:
				return getProfileImageUrl();
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
			case SearchPackage.USER__NAME:
				setName((String)newValue);
				return;
			case SearchPackage.USER__LOCATION:
				setLocation((String)newValue);
				return;
			case SearchPackage.USER__EXPANDED_URL:
				setExpandedUrl((String)newValue);
				return;
			case SearchPackage.USER__CREATED_AT:
				setCreatedAt((String)newValue);
				return;
			case SearchPackage.USER__PROFILE_SIDEBAR_FILL_COLOR:
				setProfileSidebarFillColor((String)newValue);
				return;
			case SearchPackage.USER__PROFILE_SIDEBAR_BORDER_COLOR:
				setProfileSidebarBorderColor((String)newValue);
				return;
			case SearchPackage.USER__PROFILE_BACKGROUND_TILE:
				setProfileBackgroundTile((Boolean)newValue);
				return;
			case SearchPackage.USER__PROFILE_IMAGE_URL:
				setProfileImageUrl((String)newValue);
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
			case SearchPackage.USER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SearchPackage.USER__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case SearchPackage.USER__EXPANDED_URL:
				setExpandedUrl(EXPANDED_URL_EDEFAULT);
				return;
			case SearchPackage.USER__CREATED_AT:
				setCreatedAt(CREATED_AT_EDEFAULT);
				return;
			case SearchPackage.USER__PROFILE_SIDEBAR_FILL_COLOR:
				setProfileSidebarFillColor(PROFILE_SIDEBAR_FILL_COLOR_EDEFAULT);
				return;
			case SearchPackage.USER__PROFILE_SIDEBAR_BORDER_COLOR:
				setProfileSidebarBorderColor(PROFILE_SIDEBAR_BORDER_COLOR_EDEFAULT);
				return;
			case SearchPackage.USER__PROFILE_BACKGROUND_TILE:
				setProfileBackgroundTile(PROFILE_BACKGROUND_TILE_EDEFAULT);
				return;
			case SearchPackage.USER__PROFILE_IMAGE_URL:
				setProfileImageUrl(PROFILE_IMAGE_URL_EDEFAULT);
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
			case SearchPackage.USER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SearchPackage.USER__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case SearchPackage.USER__EXPANDED_URL:
				return EXPANDED_URL_EDEFAULT == null ? expandedUrl != null : !EXPANDED_URL_EDEFAULT.equals(expandedUrl);
			case SearchPackage.USER__CREATED_AT:
				return CREATED_AT_EDEFAULT == null ? createdAt != null : !CREATED_AT_EDEFAULT.equals(createdAt);
			case SearchPackage.USER__PROFILE_SIDEBAR_FILL_COLOR:
				return PROFILE_SIDEBAR_FILL_COLOR_EDEFAULT == null ? profileSidebarFillColor != null : !PROFILE_SIDEBAR_FILL_COLOR_EDEFAULT.equals(profileSidebarFillColor);
			case SearchPackage.USER__PROFILE_SIDEBAR_BORDER_COLOR:
				return PROFILE_SIDEBAR_BORDER_COLOR_EDEFAULT == null ? profileSidebarBorderColor != null : !PROFILE_SIDEBAR_BORDER_COLOR_EDEFAULT.equals(profileSidebarBorderColor);
			case SearchPackage.USER__PROFILE_BACKGROUND_TILE:
				return PROFILE_BACKGROUND_TILE_EDEFAULT == null ? profileBackgroundTile != null : !PROFILE_BACKGROUND_TILE_EDEFAULT.equals(profileBackgroundTile);
			case SearchPackage.USER__PROFILE_IMAGE_URL:
				return PROFILE_IMAGE_URL_EDEFAULT == null ? profileImageUrl != null : !PROFILE_IMAGE_URL_EDEFAULT.equals(profileImageUrl);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", location: ");
		result.append(location);
		result.append(", expandedUrl: ");
		result.append(expandedUrl);
		result.append(", createdAt: ");
		result.append(createdAt);
		result.append(", profileSidebarFillColor: ");
		result.append(profileSidebarFillColor);
		result.append(", profileSidebarBorderColor: ");
		result.append(profileSidebarBorderColor);
		result.append(", profileBackgroundTile: ");
		result.append(profileBackgroundTile);
		result.append(", profileImageUrl: ");
		result.append(profileImageUrl);
		result.append(')');
		return result.toString();
	}

} //UserImpl
