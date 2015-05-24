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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.Address#getAddId <em>Add Id</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Address#getCity <em>City</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Address#getStreet <em>Street</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Address#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getAddress()
 */
public interface Address extends EObject {
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
	 * @model id="true"
	 * @generated
	 * @see #setAddId(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getAddress_AddId()
	 */
	String getAddId();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Address#getAddId <em>Add Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Add Id</em>' attribute.
	 * @generated
	 * @see #getAddId()
	 */
	void setAddId(String value);

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
	 * @model
	 * @generated
	 * @see #setCity(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getAddress_City()
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Address#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @generated
	 * @see #getCity()
	 */
	void setCity(String value);

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
	 * @model
	 * @generated
	 * @see #setStreet(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getAddress_Street()
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Address#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @generated
	 * @see #getStreet()
	 */
	void setStreet(String value);

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
	 * @model
	 * @generated
	 * @see #setNumber(Integer)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getAddress_Number()
	 */
	Integer getNumber();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Address#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @generated
	 * @see #getNumber()
	 */
	void setNumber(Integer value);

} // Address
