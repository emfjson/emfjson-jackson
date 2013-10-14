/**
 */
package org.eclipselabs.emfjson.json.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JSONPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>JBoolean</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipselabs.emfjson.json.impl.JBooleanImpl#isBooleanValue <em>
 * Boolean Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JBooleanImpl extends MinimalEObjectImpl.Container implements JBoolean {
	/**
	 * The default value of the '{@link #isBooleanValue()
	 * <em>Boolean Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBooleanValue() <em>Boolean Value</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected boolean booleanValue = BOOLEAN_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JBooleanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JSONPackage.Literals.JBOOLEAN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBooleanValue(boolean newBooleanValue) {
		boolean oldBooleanValue = booleanValue;
		booleanValue = newBooleanValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JSONPackage.JBOOLEAN__BOOLEAN_VALUE, oldBooleanValue, booleanValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String asText() {
		return Boolean.toString(isBooleanValue());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case JSONPackage.JBOOLEAN__BOOLEAN_VALUE:
			return isBooleanValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case JSONPackage.JBOOLEAN__BOOLEAN_VALUE:
			setBooleanValue((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case JSONPackage.JBOOLEAN__BOOLEAN_VALUE:
			setBooleanValue(BOOLEAN_VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case JSONPackage.JBOOLEAN__BOOLEAN_VALUE:
			return booleanValue != BOOLEAN_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case JSONPackage.JBOOLEAN___AS_TEXT:
			return asText();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (booleanValue: ");
		result.append(booleanValue);
		result.append(')');
		return result.toString();
	}

} // JBooleanImpl
