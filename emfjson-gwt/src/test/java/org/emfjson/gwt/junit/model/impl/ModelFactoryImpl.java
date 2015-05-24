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
package org.emfjson.gwt.junit.model.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emfjson.gwt.junit.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/emfjson/junit");
			if (theModelFactory != null) {
				return theModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @deprecated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.USER:
				return createUser();
			case ModelPackage.ADDRESS:
				return createAddress();
			case ModelPackage.ETYPES:
				return createETypes();
			case ModelPackage.PRIMARY_OBJECT:
				return createPrimaryObject();
			case ModelPackage.CONTAINER:
				return createContainer();
			case ModelPackage.TARGET_OBJECT:
				return createTargetObject();
			case ModelPackage.CONCRETE_TYPE_ONE:
				return createConcreteTypeOne();
			case ModelPackage.CONCRETE_TYPE_TWO:
				return createConcreteTypeTwo();
			case ModelPackage.NODE:
				return createNode();
			case ModelPackage.OBJECT_WITH_MAP:
				return createObjectWithMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.SEX:
				return createSexFromString(eDataType, initialValue);
			case ModelPackage.URI:
				return createURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.SEX:
				return convertSexToString(eDataType, instanceValue);
			case ModelPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Address createAddress() {
		AddressImpl address = new AddressImpl();
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ETypes createETypes() {
		ETypesImpl eTypes = new ETypesImpl();
		return eTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PrimaryObject createPrimaryObject() {
		PrimaryObjectImpl primaryObject = new PrimaryObjectImpl();
		return primaryObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public org.emfjson.gwt.junit.model.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject createTargetObject() {
		TargetObjectImpl targetObject = new TargetObjectImpl();
		return targetObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConcreteTypeOne createConcreteTypeOne() {
		ConcreteTypeOneImpl concreteTypeOne = new ConcreteTypeOneImpl();
		return concreteTypeOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConcreteTypeTwo createConcreteTypeTwo() {
		ConcreteTypeTwoImpl concreteTypeTwo = new ConcreteTypeTwoImpl();
		return concreteTypeTwo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ObjectWithMap createObjectWithMap() {
		ObjectWithMapImpl objectWithMap = new ObjectWithMapImpl();
		return objectWithMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Sex createSexFromString(EDataType eDataType, String initialValue) {
		Sex result = Sex.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertSexToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage) getEPackage();
	}

} //ModelFactoryImpl
