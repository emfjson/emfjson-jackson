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

import org.eclipselabs.emfjson.search.Entity;
import org.eclipselabs.emfjson.search.SearchPackage;
import org.eclipselabs.emfjson.search.Status;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getFavorited <em>Favorited</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getCreatedAt <em>Created At</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getTruncated <em>Truncated</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getInReplyToUserId <em>In Reply To User Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.impl.StatusImpl#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusImpl extends EObjectImpl implements Status {
	/**
	 * The default value of the '{@link #getCoordinates() <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
	protected static final String COORDINATES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoordinates() <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
	protected String coordinates = COORDINATES_EDEFAULT;

	/**
	 * The default value of the '{@link #getFavorited() <em>Favorited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavorited()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean FAVORITED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFavorited() <em>Favorited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavorited()
	 * @generated
	 * @ordered
	 */
	protected Boolean favorited = FAVORITED_EDEFAULT;

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
	 * The default value of the '{@link #getTruncated() <em>Truncated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTruncated()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean TRUNCATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTruncated() <em>Truncated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTruncated()
	 * @generated
	 * @ordered
	 */
	protected Boolean truncated = TRUNCATED_EDEFAULT;

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
	 * The default value of the '{@link #getInReplyToUserId() <em>In Reply To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInReplyToUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_REPLY_TO_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInReplyToUserId() <em>In Reply To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInReplyToUserId()
	 * @generated
	 * @ordered
	 */
	protected String inReplyToUserId = IN_REPLY_TO_USER_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> entities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchPackage.Literals.STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoordinates() {
		return coordinates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoordinates(String newCoordinates) {
		String oldCoordinates = coordinates;
		coordinates = newCoordinates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.STATUS__COORDINATES, oldCoordinates, coordinates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getFavorited() {
		return favorited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFavorited(Boolean newFavorited) {
		Boolean oldFavorited = favorited;
		favorited = newFavorited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.STATUS__FAVORITED, oldFavorited, favorited));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.STATUS__CREATED_AT, oldCreatedAt, createdAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getTruncated() {
		return truncated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTruncated(Boolean newTruncated) {
		Boolean oldTruncated = truncated;
		truncated = newTruncated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.STATUS__TRUNCATED, oldTruncated, truncated));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.STATUS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInReplyToUserId() {
		return inReplyToUserId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInReplyToUserId(String newInReplyToUserId) {
		String oldInReplyToUserId = inReplyToUserId;
		inReplyToUserId = newInReplyToUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.STATUS__IN_REPLY_TO_USER_ID, oldInReplyToUserId, inReplyToUserId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity> getEntities() {
		if (entities == null) {
			entities = new EObjectContainmentEList<Entity>(Entity.class, this, SearchPackage.STATUS__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchPackage.STATUS__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
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
			case SearchPackage.STATUS__COORDINATES:
				return getCoordinates();
			case SearchPackage.STATUS__FAVORITED:
				return getFavorited();
			case SearchPackage.STATUS__CREATED_AT:
				return getCreatedAt();
			case SearchPackage.STATUS__TRUNCATED:
				return getTruncated();
			case SearchPackage.STATUS__ID:
				return getId();
			case SearchPackage.STATUS__IN_REPLY_TO_USER_ID:
				return getInReplyToUserId();
			case SearchPackage.STATUS__ENTITIES:
				return getEntities();
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
			case SearchPackage.STATUS__COORDINATES:
				setCoordinates((String)newValue);
				return;
			case SearchPackage.STATUS__FAVORITED:
				setFavorited((Boolean)newValue);
				return;
			case SearchPackage.STATUS__CREATED_AT:
				setCreatedAt((String)newValue);
				return;
			case SearchPackage.STATUS__TRUNCATED:
				setTruncated((Boolean)newValue);
				return;
			case SearchPackage.STATUS__ID:
				setId((String)newValue);
				return;
			case SearchPackage.STATUS__IN_REPLY_TO_USER_ID:
				setInReplyToUserId((String)newValue);
				return;
			case SearchPackage.STATUS__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity>)newValue);
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
			case SearchPackage.STATUS__COORDINATES:
				setCoordinates(COORDINATES_EDEFAULT);
				return;
			case SearchPackage.STATUS__FAVORITED:
				setFavorited(FAVORITED_EDEFAULT);
				return;
			case SearchPackage.STATUS__CREATED_AT:
				setCreatedAt(CREATED_AT_EDEFAULT);
				return;
			case SearchPackage.STATUS__TRUNCATED:
				setTruncated(TRUNCATED_EDEFAULT);
				return;
			case SearchPackage.STATUS__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchPackage.STATUS__IN_REPLY_TO_USER_ID:
				setInReplyToUserId(IN_REPLY_TO_USER_ID_EDEFAULT);
				return;
			case SearchPackage.STATUS__ENTITIES:
				getEntities().clear();
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
			case SearchPackage.STATUS__COORDINATES:
				return COORDINATES_EDEFAULT == null ? coordinates != null : !COORDINATES_EDEFAULT.equals(coordinates);
			case SearchPackage.STATUS__FAVORITED:
				return FAVORITED_EDEFAULT == null ? favorited != null : !FAVORITED_EDEFAULT.equals(favorited);
			case SearchPackage.STATUS__CREATED_AT:
				return CREATED_AT_EDEFAULT == null ? createdAt != null : !CREATED_AT_EDEFAULT.equals(createdAt);
			case SearchPackage.STATUS__TRUNCATED:
				return TRUNCATED_EDEFAULT == null ? truncated != null : !TRUNCATED_EDEFAULT.equals(truncated);
			case SearchPackage.STATUS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchPackage.STATUS__IN_REPLY_TO_USER_ID:
				return IN_REPLY_TO_USER_ID_EDEFAULT == null ? inReplyToUserId != null : !IN_REPLY_TO_USER_ID_EDEFAULT.equals(inReplyToUserId);
			case SearchPackage.STATUS__ENTITIES:
				return entities != null && !entities.isEmpty();
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
		result.append(" (coordinates: ");
		result.append(coordinates);
		result.append(", favorited: ");
		result.append(favorited);
		result.append(", createdAt: ");
		result.append(createdAt);
		result.append(", truncated: ");
		result.append(truncated);
		result.append(", id: ");
		result.append(id);
		result.append(", inReplyToUserId: ");
		result.append(inReplyToUserId);
		result.append(')');
		return result.toString();
	}

} //StatusImpl
