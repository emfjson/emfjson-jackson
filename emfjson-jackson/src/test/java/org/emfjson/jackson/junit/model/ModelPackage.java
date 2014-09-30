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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emfjson.jackson.junit.model.ModelFactory
 * @generated
 */
public class ModelPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipselabs.org/emfjson/junit";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModelPackage eINSTANCE = org.emfjson.jackson.junit.model.ModelPackage.init();

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.User <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.User
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getUser()
	 * @generated
	 */
	public static final int USER = 0;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__USER_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__BIRTH_DATE = 2;

	/**
	 * The feature id for the '<em><b>Sex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__SEX = 3;

	/**
	 * The feature id for the '<em><b>Friends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__FRIENDS = 4;

	/**
	 * The feature id for the '<em><b>Unique Friend</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__UNIQUE_FRIEND = 5;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER__ADDRESS = 6;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.Address <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.Address
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getAddress()
	 * @generated
	 */
	public static final int ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Add Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS__ADD_ID = 0;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS__CITY = 1;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS__STREET = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS__NUMBER = 3;

	/**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.ETypes <em>ETypes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.ETypes
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getETypes()
	 * @generated
	 */
	public static final int ETYPES = 2;

	/**
	 * The feature id for the '<em><b>EString</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ESTRING = 0;

	/**
	 * The feature id for the '<em><b>EStrings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ESTRINGS = 1;

	/**
	 * The feature id for the '<em><b>EBoolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>EBooleans</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBOOLEANS = 3;

	/**
	 * The feature id for the '<em><b>EInt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EINT = 4;

	/**
	 * The feature id for the '<em><b>EInts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EINTS = 5;

	/**
	 * The feature id for the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__DOUBLE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>EDouble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EDOUBLE = 7;

	/**
	 * The feature id for the '<em><b>EDoubles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EDOUBLES = 8;

	/**
	 * The feature id for the '<em><b>EBig Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBIG_DECIMAL = 9;

	/**
	 * The feature id for the '<em><b>EBig Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBIG_INTEGER = 10;

	/**
	 * The feature id for the '<em><b>EByte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBYTE = 11;

	/**
	 * The feature id for the '<em><b>EByte Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EBYTE_ARRAY = 12;

	/**
	 * The feature id for the '<em><b>EChar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ECHAR = 13;

	/**
	 * The feature id for the '<em><b>EDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EDATE = 14;

	/**
	 * The feature id for the '<em><b>EFloat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__EFLOAT = 15;

	/**
	 * The feature id for the '<em><b>ELong</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ELONG = 16;

	/**
	 * The feature id for the '<em><b>EShort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__ESHORT = 17;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES__URIS = 18;

	/**
	 * The number of structural features of the '<em>ETypes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES_FEATURE_COUNT = 19;

	/**
	 * The number of operations of the '<em>ETypes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ETYPES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.PrimaryObject <em>Primary Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.PrimaryObject
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getPrimaryObject()
	 * @generated
	 */
	public static final int PRIMARY_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__ID_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Unsettable Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT = 3;

	/**
	 * The feature id for the '<em><b>Unsettable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__UNSETTABLE_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN = 5;

	/**
	 * The feature id for the '<em><b>Single Non Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES = 8;

	/**
	 * The feature id for the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES = 9;

	/**
	 * The feature id for the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES = 10;

	/**
	 * The feature id for the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES = 11;

	/**
	 * The feature id for the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES = 12;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Type1</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1 = 13;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Type2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2 = 14;

	/**
	 * The feature id for the '<em><b>Feature Map Reference Collection</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION = 15;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Type1</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1 = 16;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Type2</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2 = 17;

	/**
	 * The feature id for the '<em><b>Feature Map Attribute Collection</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION = 18;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT__KIND = 19;

	/**
	 * The number of structural features of the '<em>Primary Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT_FEATURE_COUNT = 20;

	/**
	 * The number of operations of the '<em>Primary Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.Container <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.Container
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getContainer()
	 * @generated
	 */
	public static final int CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINER__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.TargetObject <em>Target Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.TargetObject
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getTargetObject()
	 * @generated
	 */
	public static final int TARGET_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Single Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT__SINGLE_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Array Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT__ARRAY_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Target Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Target Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.AbstractType <em>Abstract Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.AbstractType
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getAbstractType()
	 * @generated
	 */
	public static final int ABSTRACT_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ref Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_TYPE__REF_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Abstract Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Abstract Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.ConcreteTypeOne <em>Concrete Type One</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.ConcreteTypeOne
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getConcreteTypeOne()
	 * @generated
	 */
	public static final int CONCRETE_TYPE_ONE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_ONE__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Ref Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_ONE__REF_PROPERTY = ABSTRACT_TYPE__REF_PROPERTY;

	/**
	 * The feature id for the '<em><b>Prop Type One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_ONE__PROP_TYPE_ONE = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concrete Type One</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_ONE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Concrete Type One</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_ONE_OPERATION_COUNT = ABSTRACT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.ConcreteTypeTwo <em>Concrete Type Two</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.ConcreteTypeTwo
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getConcreteTypeTwo()
	 * @generated
	 */
	public static final int CONCRETE_TYPE_TWO = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_TWO__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Ref Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_TWO__REF_PROPERTY = ABSTRACT_TYPE__REF_PROPERTY;

	/**
	 * The feature id for the '<em><b>Prop Type Two</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_TWO__PROP_TYPE_TWO = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concrete Type Two</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_TWO_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Concrete Type Two</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONCRETE_TYPE_TWO_OPERATION_COUNT = ABSTRACT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.Node
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getNode()
	 * @generated
	 */
	public static final int NODE = 9;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Many Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__MANY_REF = 3;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__CHILD = 4;

	/**
	 * The feature id for the '<em><b>Unique Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__UNIQUE_CHILD = 5;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.ObjectWithMap <em>Object With Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.ObjectWithMap
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getObjectWithMap()
	 * @generated
	 */
	public static final int OBJECT_WITH_MAP = 10;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_WITH_MAP__ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_WITH_MAP__DEPENDENCIES = 1;

	/**
	 * The number of structural features of the '<em>Object With Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_WITH_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Object With Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_WITH_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.Sex <em>Sex</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.Sex
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getSex()
	 * @generated
	 */
	public static final int SEX = 11;

	/**
	 * The meta object id for the '{@link org.emfjson.jackson.junit.model.SomeKind <em>Some Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emfjson.jackson.junit.model.SomeKind
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getSomeKind()
	 * @generated
	 */
	public static final int SOME_KIND = 12;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.emfjson.jackson.junit.model.ModelPackage#getURI()
	 * @generated
	 */
	public static final int URI = 13;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteTypeOneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteTypeTwoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectWithMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sexEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum someKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emfjson.jackson.junit.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackage() {
		super(eNS_URI, ModelFactory.INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackage theModelPackage = (ModelPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackage());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.emfjson.jackson.junit.model.User
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.User#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getUserId()
	 * @see #getUser()
	 * @generated
	 */
	public EAttribute getUser_UserId() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	public EAttribute getUser_Name() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.User#getBirthDate <em>Birth Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Birth Date</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getBirthDate()
	 * @see #getUser()
	 * @generated
	 */
	public EAttribute getUser_BirthDate() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.User#getSex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sex</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getSex()
	 * @see #getUser()
	 * @generated
	 */
	public EAttribute getUser_Sex() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.emfjson.jackson.junit.model.User#getFriends <em>Friends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Friends</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getFriends()
	 * @see #getUser()
	 * @generated
	 */
	public EReference getUser_Friends() {
		return (EReference)userEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the reference '{@link org.emfjson.jackson.junit.model.User#getUniqueFriend <em>Unique Friend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unique Friend</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getUniqueFriend()
	 * @see #getUser()
	 * @generated
	 */
	public EReference getUser_UniqueFriend() {
		return (EReference)userEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.emfjson.jackson.junit.model.User#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.emfjson.jackson.junit.model.User#getAddress()
	 * @see #getUser()
	 * @generated
	 */
	public EReference getUser_Address() {
		return (EReference)userEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see org.emfjson.jackson.junit.model.Address
	 * @generated
	 */
	public EClass getAddress() {
		return addressEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.Address#getAddId <em>Add Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Id</em>'.
	 * @see org.emfjson.jackson.junit.model.Address#getAddId()
	 * @see #getAddress()
	 * @generated
	 */
	public EAttribute getAddress_AddId() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.Address#getCity <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see org.emfjson.jackson.junit.model.Address#getCity()
	 * @see #getAddress()
	 * @generated
	 */
	public EAttribute getAddress_City() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.Address#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see org.emfjson.jackson.junit.model.Address#getStreet()
	 * @see #getAddress()
	 * @generated
	 */
	public EAttribute getAddress_Street() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.Address#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.emfjson.jackson.junit.model.Address#getNumber()
	 * @see #getAddress()
	 * @generated
	 */
	public EAttribute getAddress_Number() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.ETypes <em>ETypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETypes</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes
	 * @generated
	 */
	public EClass getETypes() {
		return eTypesEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEString <em>EString</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EString</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEString()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EString() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.ETypes#getEStrings <em>EStrings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>EStrings</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEStrings()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EStrings() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#isEBoolean <em>EBoolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBoolean</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#isEBoolean()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBoolean() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.ETypes#getEBooleans <em>EBooleans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>EBooleans</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEBooleans()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBooleans() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEInt <em>EInt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EInt</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEInt()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EInt() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.ETypes#getEInts <em>EInts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>EInts</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEInts()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EInts() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getDoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Value</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getDoubleValue()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_DoubleValue() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEDouble <em>EDouble</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EDouble</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEDouble()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EDouble() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.ETypes#getEDoubles <em>EDoubles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>EDoubles</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEDoubles()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EDoubles() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEBigDecimal <em>EBig Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBig Decimal</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEBigDecimal()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBigDecimal() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEBigInteger <em>EBig Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EBig Integer</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEBigInteger()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EBigInteger() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEByte <em>EByte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EByte</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEByte()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EByte() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEByteArray <em>EByte Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EByte Array</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEByteArray()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EByteArray() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEChar <em>EChar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EChar</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEChar()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EChar() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEDate <em>EDate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EDate</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEDate()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EDate() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEFloat <em>EFloat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EFloat</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEFloat()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EFloat() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getELong <em>ELong</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ELong</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getELong()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_ELong() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ETypes#getEShort <em>EShort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EShort</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getEShort()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_EShort() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.ETypes#getUris <em>Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Uris</em>'.
	 * @see org.emfjson.jackson.junit.model.ETypes#getUris()
	 * @see #getETypes()
	 * @generated
	 */
	public EAttribute getETypes_Uris() {
		return (EAttribute)eTypesEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.PrimaryObject <em>Primary Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Object</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject
	 * @generated
	 */
	public EClass getPrimaryObject() {
		return primaryObjectEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.PrimaryObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getName()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_Name() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Attribute</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getIdAttribute()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_IdAttribute() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable Attribute</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttribute()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_UnsettableAttribute() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable Attribute With Non Null Default</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_UnsettableAttributeWithNonNullDefault() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the reference '{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unsettable Reference</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_UnsettableReference() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.emfjson.jackson.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Containment Reference Same Collectioin</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_ContainmentReferenceSameCollectioin() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the reference '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Non Containment Reference</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleNonContainmentReference() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multiple Non Containment Reference</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getMultipleNonContainmentReference()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleNonContainmentReference() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Containment Reference No Proxies</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleContainmentReferenceNoProxies() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiple Containment Reference No Proxies</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleContainmentReferenceNoProxies() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Containment Reference Proxies</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleContainmentReferenceProxies() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiple Containment Reference Proxies</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleContainmentReferenceProxies() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * Returns the meta object for the reference '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Non Containment Reference No Proxies</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_SingleNonContainmentReferenceNoProxies() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feature Map Reference Type1</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceType1()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_FeatureMapReferenceType1() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Map Reference Type2</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceType2()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EReference getPrimaryObject_FeatureMapReferenceType2() {
		return (EReference)primaryObjectEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Reference Collection</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceCollection()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapReferenceCollection() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Type1</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeType1()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeType1() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Type2</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeType2()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeType2() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Map Attribute Collection</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeCollection()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeCollection() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.PrimaryObject#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.emfjson.jackson.junit.model.PrimaryObject#getKind()
	 * @see #getPrimaryObject()
	 * @generated
	 */
	public EAttribute getPrimaryObject_Kind() {
		return (EAttribute)primaryObjectEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.emfjson.jackson.junit.model.Container
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.emfjson.jackson.junit.model.Container#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.emfjson.jackson.junit.model.Container#getElements()
	 * @see #getContainer()
	 * @generated
	 */
	public EReference getContainer_Elements() {
		return (EReference)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.TargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Object</em>'.
	 * @see org.emfjson.jackson.junit.model.TargetObject
	 * @generated
	 */
	public EClass getTargetObject() {
		return targetObjectEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.TargetObject#getSingleAttribute <em>Single Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Single Attribute</em>'.
	 * @see org.emfjson.jackson.junit.model.TargetObject#getSingleAttribute()
	 * @see #getTargetObject()
	 * @generated
	 */
	public EAttribute getTargetObject_SingleAttribute() {
		return (EAttribute)targetObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.emfjson.jackson.junit.model.TargetObject#getArrayAttribute <em>Array Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Array Attribute</em>'.
	 * @see org.emfjson.jackson.junit.model.TargetObject#getArrayAttribute()
	 * @see #getTargetObject()
	 * @generated
	 */
	public EAttribute getTargetObject_ArrayAttribute() {
		return (EAttribute)targetObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.AbstractType <em>Abstract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Type</em>'.
	 * @see org.emfjson.jackson.junit.model.AbstractType
	 * @generated
	 */
	public EClass getAbstractType() {
		return abstractTypeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.AbstractType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emfjson.jackson.junit.model.AbstractType#getName()
	 * @see #getAbstractType()
	 * @generated
	 */
	public EAttribute getAbstractType_Name() {
		return (EAttribute)abstractTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.emfjson.jackson.junit.model.AbstractType#getRefProperty <em>Ref Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref Property</em>'.
	 * @see org.emfjson.jackson.junit.model.AbstractType#getRefProperty()
	 * @see #getAbstractType()
	 * @generated
	 */
	public EReference getAbstractType_RefProperty() {
		return (EReference)abstractTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.ConcreteTypeOne <em>Concrete Type One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Type One</em>'.
	 * @see org.emfjson.jackson.junit.model.ConcreteTypeOne
	 * @generated
	 */
	public EClass getConcreteTypeOne() {
		return concreteTypeOneEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ConcreteTypeOne#getPropTypeOne <em>Prop Type One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prop Type One</em>'.
	 * @see org.emfjson.jackson.junit.model.ConcreteTypeOne#getPropTypeOne()
	 * @see #getConcreteTypeOne()
	 * @generated
	 */
	public EAttribute getConcreteTypeOne_PropTypeOne() {
		return (EAttribute)concreteTypeOneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.ConcreteTypeTwo <em>Concrete Type Two</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Type Two</em>'.
	 * @see org.emfjson.jackson.junit.model.ConcreteTypeTwo
	 * @generated
	 */
	public EClass getConcreteTypeTwo() {
		return concreteTypeTwoEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.ConcreteTypeTwo#getPropTypeTwo <em>Prop Type Two</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prop Type Two</em>'.
	 * @see org.emfjson.jackson.junit.model.ConcreteTypeTwo#getPropTypeTwo()
	 * @see #getConcreteTypeTwo()
	 * @generated
	 */
	public EAttribute getConcreteTypeTwo_PropTypeTwo() {
		return (EAttribute)concreteTypeTwoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.emfjson.jackson.junit.model.Node
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.emfjson.jackson.junit.model.Node#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.emfjson.jackson.junit.model.Node#getLabel()
	 * @see #getNode()
	 * @generated
	 */
	public EAttribute getNode_Label() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.emfjson.jackson.junit.model.Node#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.emfjson.jackson.junit.model.Node#getTarget()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_Target() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.emfjson.jackson.junit.model.Node#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.emfjson.jackson.junit.model.Node#getSource()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_Source() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.emfjson.jackson.junit.model.Node#getManyRef <em>Many Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Many Ref</em>'.
	 * @see org.emfjson.jackson.junit.model.Node#getManyRef()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_ManyRef() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.emfjson.jackson.junit.model.Node#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child</em>'.
	 * @see org.emfjson.jackson.junit.model.Node#getChild()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_Child() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.emfjson.jackson.junit.model.Node#getUniqueChild <em>Unique Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unique Child</em>'.
	 * @see org.emfjson.jackson.junit.model.Node#getUniqueChild()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_UniqueChild() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for class '{@link org.emfjson.jackson.junit.model.ObjectWithMap <em>Object With Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object With Map</em>'.
	 * @see org.emfjson.jackson.junit.model.ObjectWithMap
	 * @generated
	 */
	public EClass getObjectWithMap() {
		return objectWithMapEClass;
	}

	/**
	 * Returns the meta object for the map '{@link org.emfjson.jackson.junit.model.ObjectWithMap#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Entries</em>'.
	 * @see org.emfjson.jackson.junit.model.ObjectWithMap#getEntries()
	 * @see #getObjectWithMap()
	 * @generated
	 */
	public EReference getObjectWithMap_Entries() {
		return (EReference)objectWithMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the map '{@link org.emfjson.jackson.junit.model.ObjectWithMap#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Dependencies</em>'.
	 * @see org.emfjson.jackson.junit.model.ObjectWithMap#getDependencies()
	 * @see #getObjectWithMap()
	 * @generated
	 */
	public EReference getObjectWithMap_Dependencies() {
		return (EReference)objectWithMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for enum '{@link org.emfjson.jackson.junit.model.Sex <em>Sex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sex</em>'.
	 * @see org.emfjson.jackson.junit.model.Sex
	 * @generated
	 */
	public EEnum getSex() {
		return sexEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.emfjson.jackson.junit.model.SomeKind <em>Some Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Some Kind</em>'.
	 * @see org.emfjson.jackson.junit.model.SomeKind
	 * @generated
	 */
	public EEnum getSomeKind() {
		return someKindEEnum;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__USER_ID);
		createEAttribute(userEClass, USER__NAME);
		createEAttribute(userEClass, USER__BIRTH_DATE);
		createEAttribute(userEClass, USER__SEX);
		createEReference(userEClass, USER__FRIENDS);
		createEReference(userEClass, USER__UNIQUE_FRIEND);
		createEReference(userEClass, USER__ADDRESS);

		addressEClass = createEClass(ADDRESS);
		createEAttribute(addressEClass, ADDRESS__ADD_ID);
		createEAttribute(addressEClass, ADDRESS__CITY);
		createEAttribute(addressEClass, ADDRESS__STREET);
		createEAttribute(addressEClass, ADDRESS__NUMBER);

		eTypesEClass = createEClass(ETYPES);
		createEAttribute(eTypesEClass, ETYPES__ESTRING);
		createEAttribute(eTypesEClass, ETYPES__ESTRINGS);
		createEAttribute(eTypesEClass, ETYPES__EBOOLEAN);
		createEAttribute(eTypesEClass, ETYPES__EBOOLEANS);
		createEAttribute(eTypesEClass, ETYPES__EINT);
		createEAttribute(eTypesEClass, ETYPES__EINTS);
		createEAttribute(eTypesEClass, ETYPES__DOUBLE_VALUE);
		createEAttribute(eTypesEClass, ETYPES__EDOUBLE);
		createEAttribute(eTypesEClass, ETYPES__EDOUBLES);
		createEAttribute(eTypesEClass, ETYPES__EBIG_DECIMAL);
		createEAttribute(eTypesEClass, ETYPES__EBIG_INTEGER);
		createEAttribute(eTypesEClass, ETYPES__EBYTE);
		createEAttribute(eTypesEClass, ETYPES__EBYTE_ARRAY);
		createEAttribute(eTypesEClass, ETYPES__ECHAR);
		createEAttribute(eTypesEClass, ETYPES__EDATE);
		createEAttribute(eTypesEClass, ETYPES__EFLOAT);
		createEAttribute(eTypesEClass, ETYPES__ELONG);
		createEAttribute(eTypesEClass, ETYPES__ESHORT);
		createEAttribute(eTypesEClass, ETYPES__URIS);

		primaryObjectEClass = createEClass(PRIMARY_OBJECT);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__NAME);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__ID_ATTRIBUTE);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__UNSETTABLE_REFERENCE);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1);
		createEReference(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);
		createEAttribute(primaryObjectEClass, PRIMARY_OBJECT__KIND);

		containerEClass = createEClass(CONTAINER);
		createEReference(containerEClass, CONTAINER__ELEMENTS);

		targetObjectEClass = createEClass(TARGET_OBJECT);
		createEAttribute(targetObjectEClass, TARGET_OBJECT__SINGLE_ATTRIBUTE);
		createEAttribute(targetObjectEClass, TARGET_OBJECT__ARRAY_ATTRIBUTE);

		abstractTypeEClass = createEClass(ABSTRACT_TYPE);
		createEAttribute(abstractTypeEClass, ABSTRACT_TYPE__NAME);
		createEReference(abstractTypeEClass, ABSTRACT_TYPE__REF_PROPERTY);

		concreteTypeOneEClass = createEClass(CONCRETE_TYPE_ONE);
		createEAttribute(concreteTypeOneEClass, CONCRETE_TYPE_ONE__PROP_TYPE_ONE);

		concreteTypeTwoEClass = createEClass(CONCRETE_TYPE_TWO);
		createEAttribute(concreteTypeTwoEClass, CONCRETE_TYPE_TWO__PROP_TYPE_TWO);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__LABEL);
		createEReference(nodeEClass, NODE__TARGET);
		createEReference(nodeEClass, NODE__SOURCE);
		createEReference(nodeEClass, NODE__MANY_REF);
		createEReference(nodeEClass, NODE__CHILD);
		createEReference(nodeEClass, NODE__UNIQUE_CHILD);

		objectWithMapEClass = createEClass(OBJECT_WITH_MAP);
		createEReference(objectWithMapEClass, OBJECT_WITH_MAP__ENTRIES);
		createEReference(objectWithMapEClass, OBJECT_WITH_MAP__DEPENDENCIES);

		// Create enums
		sexEEnum = createEEnum(SEX);
		someKindEEnum = createEEnum(SOME_KIND);

		// Create data types
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		concreteTypeOneEClass.getESuperTypes().add(this.getAbstractType());
		concreteTypeTwoEClass.getESuperTypes().add(this.getAbstractType());

		// Initialize classes, features, and operations; add parameters
		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Name(), ecorePackage.getEString(), "name", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_BirthDate(), ecorePackage.getEDate(), "birthDate", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Sex(), this.getSex(), "sex", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Friends(), this.getUser(), null, "friends", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_UniqueFriend(), this.getUser(), null, "uniqueFriend", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Address(), this.getAddress(), null, "address", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddress_AddId(), ecorePackage.getEString(), "addId", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_City(), ecorePackage.getEString(), "city", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_Street(), ecorePackage.getEString(), "street", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_Number(), ecorePackage.getEIntegerObject(), "number", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTypesEClass, ETypes.class, "ETypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETypes_EString(), ecorePackage.getEString(), "eString", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EStrings(), ecorePackage.getEString(), "eStrings", null, 0, -1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EBoolean(), ecorePackage.getEBoolean(), "eBoolean", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EBooleans(), ecorePackage.getEBooleanObject(), "eBooleans", null, 0, -1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EInt(), ecorePackage.getEInt(), "eInt", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EInts(), ecorePackage.getEInt(), "eInts", null, 0, -1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_DoubleValue(), ecorePackage.getEDoubleObject(), "doubleValue", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EDouble(), ecorePackage.getEDouble(), "eDouble", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EDoubles(), ecorePackage.getEDoubleObject(), "eDoubles", null, 0, -1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EBigDecimal(), ecorePackage.getEBigDecimal(), "eBigDecimal", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EBigInteger(), ecorePackage.getEBigInteger(), "eBigInteger", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EByte(), ecorePackage.getEByte(), "eByte", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EByteArray(), ecorePackage.getEByteArray(), "eByteArray", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EChar(), ecorePackage.getEChar(), "eChar", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EDate(), ecorePackage.getEDate(), "eDate", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EFloat(), ecorePackage.getEFloat(), "eFloat", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_ELong(), ecorePackage.getELong(), "eLong", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_EShort(), ecorePackage.getEShort(), "eShort", null, 0, 1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETypes_Uris(), this.getURI(), "uris", null, 0, -1, ETypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primaryObjectEClass, PrimaryObject.class, "PrimaryObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimaryObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_IdAttribute(), ecorePackage.getEString(), "idAttribute", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_UnsettableAttribute(), ecorePackage.getEString(), "unsettableAttribute", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_UnsettableAttributeWithNonNullDefault(), ecorePackage.getEString(), "unsettableAttributeWithNonNullDefault", "junit", 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_UnsettableReference(), this.getTargetObject(), null, "unsettableReference", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_ContainmentReferenceSameCollectioin(), this.getPrimaryObject(), null, "containmentReferenceSameCollectioin", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleNonContainmentReference(), this.getTargetObject(), null, "singleNonContainmentReference", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleNonContainmentReference(), this.getTargetObject(), null, "multipleNonContainmentReference", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleContainmentReferenceNoProxies(), this.getTargetObject(), null, "singleContainmentReferenceNoProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleContainmentReferenceNoProxies(), this.getTargetObject(), null, "multipleContainmentReferenceNoProxies", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleContainmentReferenceProxies(), this.getTargetObject(), null, "singleContainmentReferenceProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleContainmentReferenceProxies(), this.getTargetObject(), null, "multipleContainmentReferenceProxies", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleNonContainmentReferenceNoProxies(), this.getTargetObject(), null, "singleNonContainmentReferenceNoProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_FeatureMapReferenceType1(), this.getTargetObject(), null, "featureMapReferenceType1", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_FeatureMapReferenceType2(), this.getTargetObject(), null, "featureMapReferenceType2", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapReferenceCollection(), ecorePackage.getEFeatureMapEntry(), "featureMapReferenceCollection", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeType1(), ecorePackage.getEString(), "featureMapAttributeType1", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeType2(), ecorePackage.getEString(), "featureMapAttributeType2", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeCollection(), ecorePackage.getEFeatureMapEntry(), "featureMapAttributeCollection", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_Kind(), this.getSomeKind(), "kind", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, org.emfjson.jackson.junit.model.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Elements(), this.getAbstractType(), null, "elements", null, 0, -1, org.emfjson.jackson.junit.model.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetObjectEClass, TargetObject.class, "TargetObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetObject_SingleAttribute(), ecorePackage.getEString(), "singleAttribute", null, 0, 1, TargetObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTargetObject_ArrayAttribute(), ecorePackage.getEString(), "arrayAttribute", null, 0, -1, TargetObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTypeEClass, AbstractType.class, "AbstractType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractType_Name(), ecorePackage.getEString(), "name", null, 1, 1, AbstractType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractType_RefProperty(), this.getAbstractType(), null, "refProperty", null, 0, -1, AbstractType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteTypeOneEClass, ConcreteTypeOne.class, "ConcreteTypeOne", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcreteTypeOne_PropTypeOne(), ecorePackage.getEString(), "propTypeOne", null, 0, 1, ConcreteTypeOne.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteTypeTwoEClass, ConcreteTypeTwo.class, "ConcreteTypeTwo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcreteTypeTwo_PropTypeTwo(), ecorePackage.getEString(), "propTypeTwo", null, 0, 1, ConcreteTypeTwo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Label(), ecorePackage.getEString(), "label", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Target(), this.getNode(), this.getNode_Source(), "target", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Source(), this.getNode(), this.getNode_Target(), "source", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_ManyRef(), this.getNode(), null, "manyRef", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Child(), this.getNode(), null, "child", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_UniqueChild(), this.getNode(), null, "uniqueChild", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectWithMapEClass, ObjectWithMap.class, "ObjectWithMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectWithMap_Entries(), ecorePackage.getEStringToStringMapEntry(), null, "entries", null, 0, -1, ObjectWithMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectWithMap_Dependencies(), ecorePackage.getEStringToStringMapEntry(), null, "dependencies", null, 0, -1, ObjectWithMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sexEEnum, Sex.class, "Sex");
		addEEnumLiteral(sexEEnum, Sex.MALE);
		addEEnumLiteral(sexEEnum, Sex.FEMALE);

		initEEnum(someKindEEnum, SomeKind.class, "SomeKind");
		addEEnumLiteral(someKindEEnum, SomeKind.ONE);
		addEEnumLiteral(someKindEEnum, SomeKind.TWO);
		addEEnumLiteral(someKindEEnum, SomeKind.THREE);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// JSON
		createJSONAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>JSON</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createJSONAnnotations() {
		String source = "JSON";	
		addAnnotation
		  (userEClass, 
		   source, 
		   new String[] {
			 "root", "true"
		   });	
		addAnnotation
		  (getObjectWithMap_Entries(), 
		   source, 
		   new String[] {
			 "dynamicMap", "true"
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (getPrimaryObject_FeatureMapReferenceType1(), 
		   source, 
		   new String[] {
			 "group", "#featureMapReferenceCollection"
		   });	
		addAnnotation
		  (getPrimaryObject_FeatureMapReferenceType2(), 
		   source, 
		   new String[] {
			 "group", "#featureMapReferenceCollection"
		   });	
		addAnnotation
		  (getPrimaryObject_FeatureMapReferenceCollection(), 
		   source, 
		   new String[] {
			 "kind", "group"
		   });	
		addAnnotation
		  (getPrimaryObject_FeatureMapAttributeType1(), 
		   source, 
		   new String[] {
			 "group", "#featureMapAttributeCollection"
		   });	
		addAnnotation
		  (getPrimaryObject_FeatureMapAttributeType2(), 
		   source, 
		   new String[] {
			 "group", "#featureMapAttributeCollection"
		   });	
		addAnnotation
		  (getPrimaryObject_FeatureMapAttributeCollection(), 
		   source, 
		   new String[] {
			 "kind", "group"
		   });
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.User <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.User
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getUser()
		 * @generated
		 */
		public static final EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute USER__USER_ID = eINSTANCE.getUser_UserId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Birth Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute USER__BIRTH_DATE = eINSTANCE.getUser_BirthDate();

		/**
		 * The meta object literal for the '<em><b>Sex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute USER__SEX = eINSTANCE.getUser_Sex();

		/**
		 * The meta object literal for the '<em><b>Friends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference USER__FRIENDS = eINSTANCE.getUser_Friends();

		/**
		 * The meta object literal for the '<em><b>Unique Friend</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference USER__UNIQUE_FRIEND = eINSTANCE.getUser_UniqueFriend();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference USER__ADDRESS = eINSTANCE.getUser_Address();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.Address <em>Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.Address
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getAddress()
		 * @generated
		 */
		public static final EClass ADDRESS = eINSTANCE.getAddress();

		/**
		 * The meta object literal for the '<em><b>Add Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ADDRESS__ADD_ID = eINSTANCE.getAddress_AddId();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ADDRESS__CITY = eINSTANCE.getAddress_City();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ADDRESS__STREET = eINSTANCE.getAddress_Street();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ADDRESS__NUMBER = eINSTANCE.getAddress_Number();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.ETypes <em>ETypes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.ETypes
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getETypes()
		 * @generated
		 */
		public static final EClass ETYPES = eINSTANCE.getETypes();

		/**
		 * The meta object literal for the '<em><b>EString</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ESTRING = eINSTANCE.getETypes_EString();

		/**
		 * The meta object literal for the '<em><b>EStrings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ESTRINGS = eINSTANCE.getETypes_EStrings();

		/**
		 * The meta object literal for the '<em><b>EBoolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBOOLEAN = eINSTANCE.getETypes_EBoolean();

		/**
		 * The meta object literal for the '<em><b>EBooleans</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBOOLEANS = eINSTANCE.getETypes_EBooleans();

		/**
		 * The meta object literal for the '<em><b>EInt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EINT = eINSTANCE.getETypes_EInt();

		/**
		 * The meta object literal for the '<em><b>EInts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EINTS = eINSTANCE.getETypes_EInts();

		/**
		 * The meta object literal for the '<em><b>Double Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__DOUBLE_VALUE = eINSTANCE.getETypes_DoubleValue();

		/**
		 * The meta object literal for the '<em><b>EDouble</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EDOUBLE = eINSTANCE.getETypes_EDouble();

		/**
		 * The meta object literal for the '<em><b>EDoubles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EDOUBLES = eINSTANCE.getETypes_EDoubles();

		/**
		 * The meta object literal for the '<em><b>EBig Decimal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBIG_DECIMAL = eINSTANCE.getETypes_EBigDecimal();

		/**
		 * The meta object literal for the '<em><b>EBig Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBIG_INTEGER = eINSTANCE.getETypes_EBigInteger();

		/**
		 * The meta object literal for the '<em><b>EByte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBYTE = eINSTANCE.getETypes_EByte();

		/**
		 * The meta object literal for the '<em><b>EByte Array</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EBYTE_ARRAY = eINSTANCE.getETypes_EByteArray();

		/**
		 * The meta object literal for the '<em><b>EChar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ECHAR = eINSTANCE.getETypes_EChar();

		/**
		 * The meta object literal for the '<em><b>EDate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EDATE = eINSTANCE.getETypes_EDate();

		/**
		 * The meta object literal for the '<em><b>EFloat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__EFLOAT = eINSTANCE.getETypes_EFloat();

		/**
		 * The meta object literal for the '<em><b>ELong</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ELONG = eINSTANCE.getETypes_ELong();

		/**
		 * The meta object literal for the '<em><b>EShort</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__ESHORT = eINSTANCE.getETypes_EShort();

		/**
		 * The meta object literal for the '<em><b>Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ETYPES__URIS = eINSTANCE.getETypes_Uris();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.PrimaryObject <em>Primary Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.PrimaryObject
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getPrimaryObject()
		 * @generated
		 */
		public static final EClass PRIMARY_OBJECT = eINSTANCE.getPrimaryObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__NAME = eINSTANCE.getPrimaryObject_Name();

		/**
		 * The meta object literal for the '<em><b>Id Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__ID_ATTRIBUTE = eINSTANCE.getPrimaryObject_IdAttribute();

		/**
		 * The meta object literal for the '<em><b>Unsettable Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE = eINSTANCE.getPrimaryObject_UnsettableAttribute();

		/**
		 * The meta object literal for the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT = eINSTANCE.getPrimaryObject_UnsettableAttributeWithNonNullDefault();

		/**
		 * The meta object literal for the '<em><b>Unsettable Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__UNSETTABLE_REFERENCE = eINSTANCE.getPrimaryObject_UnsettableReference();

		/**
		 * The meta object literal for the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN = eINSTANCE.getPrimaryObject_ContainmentReferenceSameCollectioin();

		/**
		 * The meta object literal for the '<em><b>Single Non Containment Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE = eINSTANCE.getPrimaryObject_SingleNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Multiple Non Containment Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE = eINSTANCE.getPrimaryObject_MultipleNonContainmentReference();

		/**
		 * The meta object literal for the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_SingleContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_MultipleContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Single Containment Reference Proxies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES = eINSTANCE.getPrimaryObject_SingleContainmentReferenceProxies();

		/**
		 * The meta object literal for the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES = eINSTANCE.getPrimaryObject_MultipleContainmentReferenceProxies();

		/**
		 * The meta object literal for the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES = eINSTANCE.getPrimaryObject_SingleNonContainmentReferenceNoProxies();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Type1</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1 = eINSTANCE.getPrimaryObject_FeatureMapReferenceType1();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Type2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2 = eINSTANCE.getPrimaryObject_FeatureMapReferenceType2();

		/**
		 * The meta object literal for the '<em><b>Feature Map Reference Collection</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION = eINSTANCE.getPrimaryObject_FeatureMapReferenceCollection();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Type1</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1 = eINSTANCE.getPrimaryObject_FeatureMapAttributeType1();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Type2</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2 = eINSTANCE.getPrimaryObject_FeatureMapAttributeType2();

		/**
		 * The meta object literal for the '<em><b>Feature Map Attribute Collection</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION = eINSTANCE.getPrimaryObject_FeatureMapAttributeCollection();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PRIMARY_OBJECT__KIND = eINSTANCE.getPrimaryObject_Kind();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.Container <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.Container
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getContainer()
		 * @generated
		 */
		public static final EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CONTAINER__ELEMENTS = eINSTANCE.getContainer_Elements();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.TargetObject <em>Target Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.TargetObject
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getTargetObject()
		 * @generated
		 */
		public static final EClass TARGET_OBJECT = eINSTANCE.getTargetObject();

		/**
		 * The meta object literal for the '<em><b>Single Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TARGET_OBJECT__SINGLE_ATTRIBUTE = eINSTANCE.getTargetObject_SingleAttribute();

		/**
		 * The meta object literal for the '<em><b>Array Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TARGET_OBJECT__ARRAY_ATTRIBUTE = eINSTANCE.getTargetObject_ArrayAttribute();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.AbstractType <em>Abstract Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.AbstractType
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getAbstractType()
		 * @generated
		 */
		public static final EClass ABSTRACT_TYPE = eINSTANCE.getAbstractType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ABSTRACT_TYPE__NAME = eINSTANCE.getAbstractType_Name();

		/**
		 * The meta object literal for the '<em><b>Ref Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ABSTRACT_TYPE__REF_PROPERTY = eINSTANCE.getAbstractType_RefProperty();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.ConcreteTypeOne <em>Concrete Type One</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.ConcreteTypeOne
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getConcreteTypeOne()
		 * @generated
		 */
		public static final EClass CONCRETE_TYPE_ONE = eINSTANCE.getConcreteTypeOne();

		/**
		 * The meta object literal for the '<em><b>Prop Type One</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONCRETE_TYPE_ONE__PROP_TYPE_ONE = eINSTANCE.getConcreteTypeOne_PropTypeOne();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.ConcreteTypeTwo <em>Concrete Type Two</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.ConcreteTypeTwo
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getConcreteTypeTwo()
		 * @generated
		 */
		public static final EClass CONCRETE_TYPE_TWO = eINSTANCE.getConcreteTypeTwo();

		/**
		 * The meta object literal for the '<em><b>Prop Type Two</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONCRETE_TYPE_TWO__PROP_TYPE_TWO = eINSTANCE.getConcreteTypeTwo_PropTypeTwo();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.Node
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getNode()
		 * @generated
		 */
		public static final EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute NODE__LABEL = eINSTANCE.getNode_Label();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__TARGET = eINSTANCE.getNode_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__SOURCE = eINSTANCE.getNode_Source();

		/**
		 * The meta object literal for the '<em><b>Many Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__MANY_REF = eINSTANCE.getNode_ManyRef();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__CHILD = eINSTANCE.getNode_Child();

		/**
		 * The meta object literal for the '<em><b>Unique Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__UNIQUE_CHILD = eINSTANCE.getNode_UniqueChild();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.ObjectWithMap <em>Object With Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.ObjectWithMap
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getObjectWithMap()
		 * @generated
		 */
		public static final EClass OBJECT_WITH_MAP = eINSTANCE.getObjectWithMap();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OBJECT_WITH_MAP__ENTRIES = eINSTANCE.getObjectWithMap_Entries();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OBJECT_WITH_MAP__DEPENDENCIES = eINSTANCE.getObjectWithMap_Dependencies();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.Sex <em>Sex</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.Sex
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getSex()
		 * @generated
		 */
		public static final EEnum SEX = eINSTANCE.getSex();

		/**
		 * The meta object literal for the '{@link org.emfjson.jackson.junit.model.SomeKind <em>Some Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emfjson.jackson.junit.model.SomeKind
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getSomeKind()
		 * @generated
		 */
		public static final EEnum SOME_KIND = eINSTANCE.getSomeKind();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.emfjson.jackson.junit.model.ModelPackage#getURI()
		 * @generated
		 */
		public static final EDataType URI = eINSTANCE.getURI();

	}

} //ModelPackage
