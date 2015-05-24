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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	ModelFactory eINSTANCE = org.emfjson.gwt.junit.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Address</em>'.
	 * @generated
	 */
	Address createAddress();

	/**
	 * Returns a new object of class '<em>ETypes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>ETypes</em>'.
	 * @generated
	 */
	ETypes createETypes();

	/**
	 * Returns a new object of class '<em>Primary Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Primary Object</em>'.
	 * @generated
	 */
	PrimaryObject createPrimaryObject();

	/**
	 * Returns a new object of class '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Container</em>'.
	 * @generated
	 */
	Container createContainer();

	/**
	 * Returns a new object of class '<em>Target Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Target Object</em>'.
	 * @generated
	 */
	TargetObject createTargetObject();

	/**
	 * Returns a new object of class '<em>Concrete Type One</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Concrete Type One</em>'.
	 * @generated
	 */
	ConcreteTypeOne createConcreteTypeOne();

	/**
	 * Returns a new object of class '<em>Concrete Type Two</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Concrete Type Two</em>'.
	 * @generated
	 */
	ConcreteTypeTwo createConcreteTypeTwo();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Object With Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Object With Map</em>'.
	 * @generated
	 */
	ObjectWithMap createObjectWithMap();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
