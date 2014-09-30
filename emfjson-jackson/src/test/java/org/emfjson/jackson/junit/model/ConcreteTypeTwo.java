/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.junit.model;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Type Two</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emfjson.jackson.junit.model.ConcreteTypeTwo#getPropTypeTwo <em>Prop Type Two</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteTypeTwo extends AbstractType {
	/**
	 * The default value of the '{@link #getPropTypeTwo() <em>Prop Type Two</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropTypeTwo()
	 * @generated
	 * @ordered
	 */
	protected static final String PROP_TYPE_TWO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropTypeTwo() <em>Prop Type Two</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropTypeTwo()
	 * @generated
	 * @ordered
	 */
	protected String propTypeTwo = PROP_TYPE_TWO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteTypeTwo() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONCRETE_TYPE_TWO;
	}

	/**
	 * Returns the value of the '<em><b>Prop Type Two</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop Type Two</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop Type Two</em>' attribute.
	 * @see #setPropTypeTwo(String)
	 * @generated
	 */
	public String getPropTypeTwo() {
		return propTypeTwo;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ConcreteTypeTwo#getPropTypeTwo <em>Prop Type Two</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop Type Two</em>' attribute.
	 * @see #getPropTypeTwo()
	 * @generated
	 */
	public void setPropTypeTwo(String newPropTypeTwo) {
		String oldPropTypeTwo = propTypeTwo;
		propTypeTwo = newPropTypeTwo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONCRETE_TYPE_TWO__PROP_TYPE_TWO, oldPropTypeTwo, propTypeTwo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CONCRETE_TYPE_TWO__PROP_TYPE_TWO:
				return getPropTypeTwo();
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
			case ModelPackage.CONCRETE_TYPE_TWO__PROP_TYPE_TWO:
				setPropTypeTwo((String)newValue);
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
			case ModelPackage.CONCRETE_TYPE_TWO__PROP_TYPE_TWO:
				setPropTypeTwo(PROP_TYPE_TWO_EDEFAULT);
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
			case ModelPackage.CONCRETE_TYPE_TWO__PROP_TYPE_TWO:
				return PROP_TYPE_TWO_EDEFAULT == null ? propTypeTwo != null : !PROP_TYPE_TWO_EDEFAULT.equals(propTypeTwo);
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
		result.append(" (propTypeTwo: ");
		result.append(propTypeTwo);
		result.append(')');
		return result.toString();
	}

} // ConcreteTypeTwo
