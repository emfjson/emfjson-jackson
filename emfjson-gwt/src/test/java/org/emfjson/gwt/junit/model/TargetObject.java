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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Object</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.TargetObject#getArrayAttribute <em>Array Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getTargetObject()
 */
public interface TargetObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Single Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Single Attribute</em>' attribute.
	 * @model
	 * @generated
	 * @see #setSingleAttribute(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getTargetObject_SingleAttribute()
	 */
	String getSingleAttribute();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Single Attribute</em>' attribute.
	 * @generated
	 * @see #getSingleAttribute()
	 */
	void setSingleAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Array Attribute</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Array Attribute</em>' attribute list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getTargetObject_ArrayAttribute()
	 */
	EList<String> getArrayAttribute();

} // TargetObject
