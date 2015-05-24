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
 * A representation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.AbstractType#getName <em>Name</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.AbstractType#getRefProperty <em>Ref Property</em>}</li>
 * </ul>
 * </p>
 *
 * @model abstract="true"
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getAbstractType()
 */
public interface AbstractType extends EObject {
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
	 * @model id="true" required="true"
	 * @generated
	 * @see #setName(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getAbstractType_Name()
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.AbstractType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @generated
	 * @see #getName()
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ref Property</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.AbstractType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Ref Property</em>' reference list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getAbstractType_RefProperty()
	 */
	EList<AbstractType> getRefProperty();

} // AbstractType
