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
import org.eclipselabs.emfjson.rotten.Release;
import org.eclipselabs.emfjson.rotten.RottenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReleaseImpl#getTheater <em>Theater</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReleaseImpl#getDvd <em>Dvd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReleaseImpl extends EObjectImpl implements Release {
	/**
	 * The default value of the '{@link #getTheater() <em>Theater</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheater()
	 * @generated
	 * @ordered
	 */
	protected static final String THEATER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTheater() <em>Theater</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheater()
	 * @generated
	 * @ordered
	 */
	protected String theater = THEATER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDvd() <em>Dvd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDvd()
	 * @generated
	 * @ordered
	 */
	protected static final String DVD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDvd() <em>Dvd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDvd()
	 * @generated
	 * @ordered
	 */
	protected String dvd = DVD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTheater() {
		return theater;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheater(String newTheater) {
		String oldTheater = theater;
		theater = newTheater;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.RELEASE__THEATER, oldTheater, theater));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDvd() {
		return dvd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDvd(String newDvd) {
		String oldDvd = dvd;
		dvd = newDvd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.RELEASE__DVD, oldDvd, dvd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RottenPackage.RELEASE__THEATER:
				return getTheater();
			case RottenPackage.RELEASE__DVD:
				return getDvd();
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
			case RottenPackage.RELEASE__THEATER:
				setTheater((String)newValue);
				return;
			case RottenPackage.RELEASE__DVD:
				setDvd((String)newValue);
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
			case RottenPackage.RELEASE__THEATER:
				setTheater(THEATER_EDEFAULT);
				return;
			case RottenPackage.RELEASE__DVD:
				setDvd(DVD_EDEFAULT);
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
			case RottenPackage.RELEASE__THEATER:
				return THEATER_EDEFAULT == null ? theater != null : !THEATER_EDEFAULT.equals(theater);
			case RottenPackage.RELEASE__DVD:
				return DVD_EDEFAULT == null ? dvd != null : !DVD_EDEFAULT.equals(dvd);
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
		result.append(" (theater: ");
		result.append(theater);
		result.append(", dvd: ");
		result.append(dvd);
		result.append(')');
		return result.toString();
	}

} //ReleaseImpl
