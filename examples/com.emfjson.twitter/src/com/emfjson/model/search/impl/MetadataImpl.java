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
package com.emfjson.model.search.impl;

import com.emfjson.model.search.Metadata;
import com.emfjson.model.search.SearchPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metadata</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emfjson.model.search.impl.MetadataImpl#getResultType <em>Result Type</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.MetadataImpl#getRecentRetweets <em>Recent Retweets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetadataImpl extends EObjectImpl implements Metadata {
	/**
	 * The default value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected String resultType = RESULT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecentRetweets() <em>Recent Retweets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecentRetweets()
	 * @generated
	 * @ordered
	 */
	protected static final Integer RECENT_RETWEETS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecentRetweets() <em>Recent Retweets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecentRetweets()
	 * @generated
	 * @ordered
	 */
	protected Integer recentRetweets = RECENT_RETWEETS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetadataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchPackage.Literals.METADATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(String newResultType) {
		String oldResultType = resultType;
		resultType = newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.METADATA__RESULT_TYPE, oldResultType, resultType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getRecentRetweets() {
		return recentRetweets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecentRetweets(Integer newRecentRetweets) {
		Integer oldRecentRetweets = recentRetweets;
		recentRetweets = newRecentRetweets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.METADATA__RECENT_RETWEETS, oldRecentRetweets, recentRetweets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchPackage.METADATA__RESULT_TYPE:
				return getResultType();
			case SearchPackage.METADATA__RECENT_RETWEETS:
				return getRecentRetweets();
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
			case SearchPackage.METADATA__RESULT_TYPE:
				setResultType((String)newValue);
				return;
			case SearchPackage.METADATA__RECENT_RETWEETS:
				setRecentRetweets((Integer)newValue);
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
			case SearchPackage.METADATA__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
				return;
			case SearchPackage.METADATA__RECENT_RETWEETS:
				setRecentRetweets(RECENT_RETWEETS_EDEFAULT);
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
			case SearchPackage.METADATA__RESULT_TYPE:
				return RESULT_TYPE_EDEFAULT == null ? resultType != null : !RESULT_TYPE_EDEFAULT.equals(resultType);
			case SearchPackage.METADATA__RECENT_RETWEETS:
				return RECENT_RETWEETS_EDEFAULT == null ? recentRetweets != null : !RECENT_RETWEETS_EDEFAULT.equals(recentRetweets);
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
		result.append(" (resultType: ");
		result.append(resultType);
		result.append(", recentRetweets: ");
		result.append(recentRetweets);
		result.append(')');
		return result.toString();
	}

} //MetadataImpl
