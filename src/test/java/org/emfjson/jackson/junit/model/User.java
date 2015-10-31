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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectEList;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.jackson.junit.model.User#getUserId <em>User Id</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.User#getName <em>Name</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.User#getBirthDate <em>Birth Date</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.User#getSex <em>Sex</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.User#getFriends <em>Friends</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.User#getUniqueFriend <em>Unique Friend</em>}</li>
 * <li>{@link org.emfjson.jackson.junit.model.User#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class User extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUserId()
	 */
	protected static final String USER_ID_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getName()
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getBirthDate()
	 */
	protected static final Date BIRTH_DATE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSex()
	 */
	protected static final Sex SEX_EDEFAULT = Sex.MALE;
	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUserId()
	 */
	protected String userId = USER_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getName()
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getBirthDate()
	 */
	protected Date birthDate = BIRTH_DATE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSex()
	 */
	protected Sex sex = SEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFriends() <em>Friends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getFriends()
	 */
	protected EList<User> friends;

	/**
	 * The cached value of the '{@link #getUniqueFriend() <em>Unique Friend</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUniqueFriend()
	 */
	protected User uniqueFriend;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getAddress()
	 */
	protected Address address;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected User() {
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
		return ModelPackage.Literals.USER;
	}

	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @generated
	 * @see #setUserId(String)
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @generated
	 * @see #getUserId()
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER__USER_ID, oldUserId, userId));
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @generated
	 * @see #setName(String)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @generated
	 * @see #getName()
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER__NAME, oldName, name));
	}

	/**
	 * Returns the value of the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Birth Date</em>' attribute.
	 * @generated
	 * @see #setBirthDate(Date)
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.User#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @generated
	 * @see #getBirthDate()
	 */
	public void setBirthDate(Date newBirthDate) {
		Date oldBirthDate = birthDate;
		birthDate = newBirthDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER__BIRTH_DATE, oldBirthDate, birthDate));
	}

	/**
	 * Returns the value of the '<em><b>Sex</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emfjson.jackson.junit.model.Sex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Sex</em>' attribute.
	 * @generated
	 * @see org.emfjson.jackson.junit.model.Sex
	 * @see #setSex(Sex)
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.User#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Sex</em>' attribute.
	 * @generated
	 * @see org.emfjson.jackson.junit.model.Sex
	 * @see #getSex()
	 */
	public void setSex(Sex newSex) {
		Sex oldSex = sex;
		sex = newSex == null ? SEX_EDEFAULT : newSex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER__SEX, oldSex, sex));
	}

	/**
	 * Returns the value of the '<em><b>Friends</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.jackson.junit.model.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Friends</em>' reference list.
	 * @generated
	 */
	public List<User> getFriends() {
		if (friends == null) {
			friends = new EObjectEList<User>(User.class, this, ModelPackage.USER__FRIENDS);
		}
		return friends;
	}

	/**
	 * Returns the value of the '<em><b>Unique Friend</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Friend</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Unique Friend</em>' reference.
	 * @generated
	 * @see #setUniqueFriend(User)
	 */
	public User getUniqueFriend() {
		return uniqueFriend;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.User#getUniqueFriend <em>Unique Friend</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Unique Friend</em>' reference.
	 * @generated
	 * @see #getUniqueFriend()
	 */
	public void setUniqueFriend(User newUniqueFriend) {
		User oldUniqueFriend = uniqueFriend;
		uniqueFriend = newUniqueFriend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER__UNIQUE_FRIEND, oldUniqueFriend, uniqueFriend));
	}

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @generated
	 * @see #setAddress(Address)
	 */
	public Address getAddress() {
		if (address != null && address.eIsProxy()) {
			InternalEObject oldAddress = (InternalEObject) address;
			address = (Address) eResolveProxy(oldAddress);
			if (address != oldAddress) {
				InternalEObject newAddress = (InternalEObject) address;
				NotificationChain msgs = oldAddress.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER__ADDRESS, null, null);
				if (newAddress.eInternalContainer() == null) {
					msgs = newAddress.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER__ADDRESS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.USER__ADDRESS, oldAddress, address));
			}
		}
		return address;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.User#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @generated
	 * @see #getAddress()
	 */
	public void setAddress(Address newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject) address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject) newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.USER__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.USER__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Address basicGetAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetAddress(Address newAddress, NotificationChain msgs) {
		Address oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.USER__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.USER__ADDRESS:
				return basicSetAddress(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ModelPackage.USER__USER_ID:
				return getUserId();
			case ModelPackage.USER__NAME:
				return getName();
			case ModelPackage.USER__BIRTH_DATE:
				return getBirthDate();
			case ModelPackage.USER__SEX:
				return getSex();
			case ModelPackage.USER__FRIENDS:
				return getFriends();
			case ModelPackage.USER__UNIQUE_FRIEND:
				return getUniqueFriend();
			case ModelPackage.USER__ADDRESS:
				if (resolve) return getAddress();
				return basicGetAddress();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.USER__USER_ID:
				setUserId((String) newValue);
				return;
			case ModelPackage.USER__NAME:
				setName((String) newValue);
				return;
			case ModelPackage.USER__BIRTH_DATE:
				setBirthDate((Date) newValue);
				return;
			case ModelPackage.USER__SEX:
				setSex((Sex) newValue);
				return;
			case ModelPackage.USER__FRIENDS:
				getFriends().clear();
				getFriends().addAll((Collection<? extends User>) newValue);
				return;
			case ModelPackage.USER__UNIQUE_FRIEND:
				setUniqueFriend((User) newValue);
				return;
			case ModelPackage.USER__ADDRESS:
				setAddress((Address) newValue);
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
			case ModelPackage.USER__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case ModelPackage.USER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.USER__BIRTH_DATE:
				setBirthDate(BIRTH_DATE_EDEFAULT);
				return;
			case ModelPackage.USER__SEX:
				setSex(SEX_EDEFAULT);
				return;
			case ModelPackage.USER__FRIENDS:
				getFriends().clear();
				return;
			case ModelPackage.USER__UNIQUE_FRIEND:
				setUniqueFriend((User) null);
				return;
			case ModelPackage.USER__ADDRESS:
				setAddress((Address) null);
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
			case ModelPackage.USER__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case ModelPackage.USER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.USER__BIRTH_DATE:
				return BIRTH_DATE_EDEFAULT == null ? birthDate != null : !BIRTH_DATE_EDEFAULT.equals(birthDate);
			case ModelPackage.USER__SEX:
				return sex != SEX_EDEFAULT;
			case ModelPackage.USER__FRIENDS:
				return friends != null && !friends.isEmpty();
			case ModelPackage.USER__UNIQUE_FRIEND:
				return uniqueFriend != null;
			case ModelPackage.USER__ADDRESS:
				return address != null;
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
		result.append(" (userId: ");
		result.append(userId);
		result.append(", name: ");
		result.append(name);
		result.append(", birthDate: ");
		result.append(birthDate);
		result.append(", sex: ");
		result.append(sex);
		result.append(')');
		return result.toString();
	}

} // User
