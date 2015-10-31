/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson.junit.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.jackson.junit.model.Address#getAddId <em>Add Id</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.Address#getCity <em>City</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.Address#getStreet <em>Street</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.Address#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Address extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getAddId() <em>Add Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getAddId()
	 */
	protected static final String ADD_ID_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getCity()
	 */
	protected static final String CITY_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getStreet()
	 */
	protected static final String STREET_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getNumber()
	 */
	protected static final Integer NUMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAddId() <em>Add Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getAddId()
	 */
	protected String addId = ADD_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getCity()
	 */
	protected String city = CITY_EDEFAULT;
	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getStreet()
	 */
	protected String street = STREET_EDEFAULT;
	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getNumber()
	 */
	protected Integer number = NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Address() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ADDRESS;
	}

	/**
	 * Returns the value of the '<em><b>Add Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Add Id</em>' attribute.
	 * @generated
	 * @see #setAddId(String)
	 */
	public String getAddId() {
		return addId;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.Address#getAddId <em>Add Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Add Id</em>' attribute.
	 * @generated
	 * @see #getAddId()
	 */
	public void setAddId(String newAddId) {
		String oldAddId = addId;
		addId = newAddId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ADDRESS__ADD_ID, oldAddId, addId));
	}

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>City</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>City</em>' attribute.
	 * @generated
	 * @see #setCity(String)
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.Address#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @generated
	 * @see #getCity()
	 */
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ADDRESS__CITY, oldCity, city));
	}

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Street</em>' attribute.
	 * @generated
	 * @see #setStreet(String)
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.Address#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @generated
	 * @see #getStreet()
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ADDRESS__STREET, oldStreet, street));
	}

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Number</em>' attribute.
	 * @generated
	 * @see #setNumber(Integer)
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.Address#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @generated
	 * @see #getNumber()
	 */
	public void setNumber(Integer newNumber) {
		Integer oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ADDRESS__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ADDRESS__ADD_ID:
				return getAddId();
			case ModelPackage.ADDRESS__CITY:
				return getCity();
			case ModelPackage.ADDRESS__STREET:
				return getStreet();
			case ModelPackage.ADDRESS__NUMBER:
				return getNumber();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ADDRESS__ADD_ID:
				setAddId((String) newValue);
				return;
			case ModelPackage.ADDRESS__CITY:
				setCity((String) newValue);
				return;
			case ModelPackage.ADDRESS__STREET:
				setStreet((String) newValue);
				return;
			case ModelPackage.ADDRESS__NUMBER:
				setNumber((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.ADDRESS__ADD_ID:
				setAddId(ADD_ID_EDEFAULT);
				return;
			case ModelPackage.ADDRESS__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case ModelPackage.ADDRESS__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case ModelPackage.ADDRESS__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.ADDRESS__ADD_ID:
				return ADD_ID_EDEFAULT == null ? addId != null : !ADD_ID_EDEFAULT.equals(addId);
			case ModelPackage.ADDRESS__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case ModelPackage.ADDRESS__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case ModelPackage.ADDRESS__NUMBER:
				return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (addId: ");
		result.append(addId);
		result.append(", city: ");
		result.append(city);
		result.append(", street: ");
		result.append(street);
		result.append(", number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} // Address
