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

import org.eclipselabs.emfjson.youtube.Thumbnail;
import org.eclipselabs.emfjson.youtube.YoutubePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thumbnail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.ThumbnailImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.ThumbnailImpl#getHqDefault <em>Hq Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThumbnailImpl extends EObjectImpl implements Thumbnail {
	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHqDefault() <em>Hq Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHqDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String HQ_DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHqDefault() <em>Hq Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHqDefault()
	 * @generated
	 * @ordered
	 */
	protected String hqDefault = HQ_DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThumbnailImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YoutubePackage.Literals.THUMBNAIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.THUMBNAIL__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHqDefault() {
		return hqDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHqDefault(String newHqDefault) {
		String oldHqDefault = hqDefault;
		hqDefault = newHqDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.THUMBNAIL__HQ_DEFAULT, oldHqDefault, hqDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YoutubePackage.THUMBNAIL__DEFAULT:
				return getDefault();
			case YoutubePackage.THUMBNAIL__HQ_DEFAULT:
				return getHqDefault();
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
			case YoutubePackage.THUMBNAIL__DEFAULT:
				setDefault((String)newValue);
				return;
			case YoutubePackage.THUMBNAIL__HQ_DEFAULT:
				setHqDefault((String)newValue);
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
			case YoutubePackage.THUMBNAIL__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case YoutubePackage.THUMBNAIL__HQ_DEFAULT:
				setHqDefault(HQ_DEFAULT_EDEFAULT);
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
			case YoutubePackage.THUMBNAIL__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case YoutubePackage.THUMBNAIL__HQ_DEFAULT:
				return HQ_DEFAULT_EDEFAULT == null ? hqDefault != null : !HQ_DEFAULT_EDEFAULT.equals(hqDefault);
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
		result.append(" (default: ");
		result.append(default_);
		result.append(", hqDefault: ");
		result.append(hqDefault);
		result.append(')');
		return result.toString();
	}

} //ThumbnailImpl
