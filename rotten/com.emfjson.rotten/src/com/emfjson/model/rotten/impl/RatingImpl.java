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

import com.emfjson.model.rotten.Rating;
import com.emfjson.model.rotten.RottenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rating</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.impl.RatingImpl#getCriticsScore <em>Critics Score</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.RatingImpl#getAudienceScore <em>Audience Score</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RatingImpl extends EObjectImpl implements Rating {
	/**
	 * The default value of the '{@link #getCriticsScore() <em>Critics Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCriticsScore()
	 * @generated
	 * @ordered
	 */
	protected static final Integer CRITICS_SCORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCriticsScore() <em>Critics Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCriticsScore()
	 * @generated
	 * @ordered
	 */
	protected Integer criticsScore = CRITICS_SCORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAudienceScore() <em>Audience Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudienceScore()
	 * @generated
	 * @ordered
	 */
	protected static final Integer AUDIENCE_SCORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAudienceScore() <em>Audience Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudienceScore()
	 * @generated
	 * @ordered
	 */
	protected Integer audienceScore = AUDIENCE_SCORE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RatingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.RATING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getCriticsScore() {
		return criticsScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCriticsScore(Integer newCriticsScore) {
		Integer oldCriticsScore = criticsScore;
		criticsScore = newCriticsScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.RATING__CRITICS_SCORE, oldCriticsScore, criticsScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getAudienceScore() {
		return audienceScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudienceScore(Integer newAudienceScore) {
		Integer oldAudienceScore = audienceScore;
		audienceScore = newAudienceScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.RATING__AUDIENCE_SCORE, oldAudienceScore, audienceScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RottenPackage.RATING__CRITICS_SCORE:
				return getCriticsScore();
			case RottenPackage.RATING__AUDIENCE_SCORE:
				return getAudienceScore();
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
			case RottenPackage.RATING__CRITICS_SCORE:
				setCriticsScore((Integer)newValue);
				return;
			case RottenPackage.RATING__AUDIENCE_SCORE:
				setAudienceScore((Integer)newValue);
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
			case RottenPackage.RATING__CRITICS_SCORE:
				setCriticsScore(CRITICS_SCORE_EDEFAULT);
				return;
			case RottenPackage.RATING__AUDIENCE_SCORE:
				setAudienceScore(AUDIENCE_SCORE_EDEFAULT);
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
			case RottenPackage.RATING__CRITICS_SCORE:
				return CRITICS_SCORE_EDEFAULT == null ? criticsScore != null : !CRITICS_SCORE_EDEFAULT.equals(criticsScore);
			case RottenPackage.RATING__AUDIENCE_SCORE:
				return AUDIENCE_SCORE_EDEFAULT == null ? audienceScore != null : !AUDIENCE_SCORE_EDEFAULT.equals(audienceScore);
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
		result.append(" (criticsScore: ");
		result.append(criticsScore);
		result.append(", audienceScore: ");
		result.append(audienceScore);
		result.append(')');
		return result.toString();
	}

} //RatingImpl
