/**
 */
package org.eclipselabs.emfjson.json.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JSONPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JNumber</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.json.impl.JNumberImpl#getNumberValue <em>Number Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JNumberImpl extends JValueImpl implements JNumber {
	/**
	 * The default value of the '{@link #getNumberValue() <em>Number Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberValue()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberValue() <em>Number Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberValue()
	 * @generated
	 * @ordered
	 */
	protected int numberValue = NUMBER_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JNumberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JSONPackage.Literals.JNUMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberValue() {
		return numberValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberValue(int newNumberValue) {
		int oldNumberValue = numberValue;
		numberValue = newNumberValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JSONPackage.JNUMBER__NUMBER_VALUE, oldNumberValue, numberValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JSONPackage.JNUMBER__NUMBER_VALUE:
				return getNumberValue();
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
			case JSONPackage.JNUMBER__NUMBER_VALUE:
				setNumberValue((Integer)newValue);
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
			case JSONPackage.JNUMBER__NUMBER_VALUE:
				setNumberValue(NUMBER_VALUE_EDEFAULT);
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
			case JSONPackage.JNUMBER__NUMBER_VALUE:
				return numberValue != NUMBER_VALUE_EDEFAULT;
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
		result.append(" (numberValue: ");
		result.append(numberValue);
		result.append(')');
		return result.toString();
	}

} //JNumberImpl
