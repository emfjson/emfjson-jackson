/**
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 * 
 */
package org.eclipselabs.emfjson.rotten.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipselabs.emfjson.rotten.ReviewLink;
import org.eclipselabs.emfjson.rotten.RottenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Review Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReviewLinkImpl#getReviewLink <em>Review Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReviewLinkImpl extends EObjectImpl implements ReviewLink {
	/**
	 * The default value of the '{@link #getReviewLink() <em>Review Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewLink()
	 * @generated
	 * @ordered
	 */
	protected static final String REVIEW_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReviewLink() <em>Review Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewLink()
	 * @generated
	 * @ordered
	 */
	protected String reviewLink = REVIEW_LINK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReviewLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.REVIEW_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReviewLink() {
		return reviewLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewLink(String newReviewLink) {
		String oldReviewLink = reviewLink;
		reviewLink = newReviewLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEW_LINK__REVIEW_LINK, oldReviewLink, reviewLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RottenPackage.REVIEW_LINK__REVIEW_LINK:
				return getReviewLink();
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
			case RottenPackage.REVIEW_LINK__REVIEW_LINK:
				setReviewLink((String)newValue);
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
			case RottenPackage.REVIEW_LINK__REVIEW_LINK:
				setReviewLink(REVIEW_LINK_EDEFAULT);
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
			case RottenPackage.REVIEW_LINK__REVIEW_LINK:
				return REVIEW_LINK_EDEFAULT == null ? reviewLink != null : !REVIEW_LINK_EDEFAULT.equals(reviewLink);
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
		result.append(" (reviewLink: ");
		result.append(reviewLink);
		result.append(')');
		return result.toString();
	}

} //ReviewLinkImpl
