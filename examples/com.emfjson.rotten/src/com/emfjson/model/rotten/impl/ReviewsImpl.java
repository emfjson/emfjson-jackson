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

import com.emfjson.model.rotten.Review;
import com.emfjson.model.rotten.Reviews;
import com.emfjson.model.rotten.RottenPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reviews</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.impl.ReviewsImpl#getReviews <em>Reviews</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReviewsImpl extends EObjectImpl implements Reviews {
	/**
	 * The cached value of the '{@link #getReviews() <em>Reviews</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviews()
	 * @generated
	 * @ordered
	 */
	protected Review reviews;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReviewsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.REVIEWS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Review getReviews() {
		return reviews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReviews(Review newReviews, NotificationChain msgs) {
		Review oldReviews = reviews;
		reviews = newReviews;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEWS__REVIEWS, oldReviews, newReviews);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviews(Review newReviews) {
		if (newReviews != reviews) {
			NotificationChain msgs = null;
			if (reviews != null)
				msgs = ((InternalEObject)reviews).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RottenPackage.REVIEWS__REVIEWS, null, msgs);
			if (newReviews != null)
				msgs = ((InternalEObject)newReviews).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RottenPackage.REVIEWS__REVIEWS, null, msgs);
			msgs = basicSetReviews(newReviews, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEWS__REVIEWS, newReviews, newReviews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RottenPackage.REVIEWS__REVIEWS:
				return basicSetReviews(null, msgs);
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
			case RottenPackage.REVIEWS__REVIEWS:
				return getReviews();
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
			case RottenPackage.REVIEWS__REVIEWS:
				setReviews((Review)newValue);
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
			case RottenPackage.REVIEWS__REVIEWS:
				setReviews((Review)null);
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
			case RottenPackage.REVIEWS__REVIEWS:
				return reviews != null;
		}
		return super.eIsSet(featureID);
	}

} //ReviewsImpl
