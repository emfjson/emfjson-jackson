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
package org.emfjson.gwt.junit.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.User#getUserId <em>User Id</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.User#getName <em>Name</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.User#getBirthDate <em>Birth Date</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.User#getSex <em>Sex</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.User#getFriends <em>Friends</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.User#getUniqueFriend <em>Unique Friend</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.User#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @model annotation="JSON root='true'"
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser()
 */
public interface User extends EObject {
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
	 * @model id="true"
	 * @generated
	 * @see #setUserId(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_UserId()
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @generated
	 * @see #getUserId()
	 */
	void setUserId(String value);

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
	 * @model
	 * @generated
	 * @see #setName(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_Name()
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @generated
	 * @see #getName()
	 */
	void setName(String value);

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
	 * @model
	 * @generated
	 * @see #setBirthDate(Date)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_BirthDate()
	 */
	Date getBirthDate();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.User#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @generated
	 * @see #getBirthDate()
	 */
	void setBirthDate(Date value);

	/**
	 * Returns the value of the '<em><b>Sex</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emfjson.gwt.junit.model.Sex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Sex</em>' attribute.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.Sex
	 * @see #setSex(Sex)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_Sex()
	 */
	Sex getSex();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.User#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Sex</em>' attribute.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.Sex
	 * @see #getSex()
	 */
	void setSex(Sex value);

	/**
	 * Returns the value of the '<em><b>Friends</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Friends</em>' reference list.
	 * @model resolveProxies="false"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_Friends()
	 */
	EList<User> getFriends();

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
	 * @model resolveProxies="false"
	 * @generated
	 * @see #setUniqueFriend(User)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_UniqueFriend()
	 */
	User getUniqueFriend();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.User#getUniqueFriend <em>Unique Friend</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Unique Friend</em>' reference.
	 * @generated
	 * @see #getUniqueFriend()
	 */
	void setUniqueFriend(User value);

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
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 * @see #setAddress(Address)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getUser_Address()
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.User#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @generated
	 * @see #getAddress()
	 */
	void setAddress(Address value);

} // User
