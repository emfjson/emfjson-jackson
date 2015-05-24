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

import com.google.gwt.user.client.rpc.IsSerializable;
import org.eclipse.emf.common.util.Reflect;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emfjson.gwt.junit.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass userEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass addressEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass eTypesEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass primaryObjectEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass containerEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass targetObjectEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass abstractTypeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass concreteTypeOneEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass concreteTypeTwoEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass nodeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass objectWithMapEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum sexEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType uriEDataType = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

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
	 *
	 * @generated
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emfjson.gwt.junit.model.ModelPackage#eNS_URI
	 * @see #init()
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * <p/>
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		initializeRegistryHelpers();

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void initializeRegistryHelpers() {
		Reflect.register
			(User.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof User;
					}

					public Object newArrayInstance(int size) {
						return new User[size];
					}
				});
		Reflect.register
			(Address.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof Address;
					}

					public Object newArrayInstance(int size) {
						return new Address[size];
					}
				});
		Reflect.register
			(ETypes.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof ETypes;
					}

					public Object newArrayInstance(int size) {
						return new ETypes[size];
					}
				});
		Reflect.register
			(PrimaryObject.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof PrimaryObject;
					}

					public Object newArrayInstance(int size) {
						return new PrimaryObject[size];
					}
				});
		Reflect.register
			(org.emfjson.gwt.junit.model.Container.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof org.emfjson.gwt.junit.model.Container;
					}

					public Object newArrayInstance(int size) {
						return new org.emfjson.gwt.junit.model.Container[size];
					}
				});
		Reflect.register
			(TargetObject.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof TargetObject;
					}

					public Object newArrayInstance(int size) {
						return new TargetObject[size];
					}
				});
		Reflect.register
			(AbstractType.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof AbstractType;
					}

					public Object newArrayInstance(int size) {
						return new AbstractType[size];
					}
				});
		Reflect.register
			(ConcreteTypeOne.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof ConcreteTypeOne;
					}

					public Object newArrayInstance(int size) {
						return new ConcreteTypeOne[size];
					}
				});
		Reflect.register
			(ConcreteTypeTwo.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof ConcreteTypeTwo;
					}

					public Object newArrayInstance(int size) {
						return new ConcreteTypeTwo[size];
					}
				});
		Reflect.register
			(Node.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof Node;
					}

					public Object newArrayInstance(int size) {
						return new Node[size];
					}
				});
		Reflect.register
			(ObjectWithMap.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof ObjectWithMap;
					}

					public Object newArrayInstance(int size) {
						return new ObjectWithMap[size];
					}
				});
		Reflect.register
			(Sex.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof Sex;
					}

					public Object newArrayInstance(int size) {
						return new Sex[size];
					}
				});
		Reflect.register
			(org.eclipse.emf.common.util.URI.class,
				new Reflect.Helper() {
					public boolean isInstance(Object instance) {
						return instance instanceof org.eclipse.emf.common.util.URI;
					}

					public Object newArrayInstance(int size) {
						return new org.eclipse.emf.common.util.URI[size];
					}
				});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUser_UserId() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUser_Name() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUser_BirthDate() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUser_Sex() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getUser_Friends() {
		return (EReference) userEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getUser_UniqueFriend() {
		return (EReference) userEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getUser_Address() {
		return (EReference) userEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getAddress() {
		return addressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getAddress_AddId() {
		return (EAttribute) addressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getAddress_City() {
		return (EAttribute) addressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getAddress_Street() {
		return (EAttribute) addressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getAddress_Number() {
		return (EAttribute) addressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getETypes() {
		return eTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EString() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EStrings() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EBoolean() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EBooleans() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EInt() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EInts() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_DoubleValue() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EDouble() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EDoubles() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EByte() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EByteArray() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EChar() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EDate() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EFloat() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_ELong() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_EShort() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getETypes_Uris() {
		return (EAttribute) eTypesEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getPrimaryObject() {
		return primaryObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_Name() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_IdAttribute() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_UnsettableAttribute() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_UnsettableAttributeWithNonNullDefault() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_UnsettableReference() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_ContainmentReferenceSameCollectioin() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_SingleNonContainmentReference() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleNonContainmentReference() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_SingleContainmentReferenceNoProxies() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleContainmentReferenceNoProxies() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_SingleContainmentReferenceProxies() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_MultipleContainmentReferenceProxies() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_SingleNonContainmentReferenceNoProxies() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_FeatureMapReferenceType1() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getPrimaryObject_FeatureMapReferenceType2() {
		return (EReference) primaryObjectEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapReferenceCollection() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeType1() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeType2() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getPrimaryObject_FeatureMapAttributeCollection() {
		return (EAttribute) primaryObjectEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getContainer_Elements() {
		return (EReference) containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getTargetObject() {
		return targetObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getTargetObject_SingleAttribute() {
		return (EAttribute) targetObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getTargetObject_ArrayAttribute() {
		return (EAttribute) targetObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getAbstractType() {
		return abstractTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getAbstractType_Name() {
		return (EAttribute) abstractTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getAbstractType_RefProperty() {
		return (EReference) abstractTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getConcreteTypeOne() {
		return concreteTypeOneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getConcreteTypeOne_PropTypeOne() {
		return (EAttribute) concreteTypeOneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getConcreteTypeTwo() {
		return concreteTypeTwoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getConcreteTypeTwo_PropTypeTwo() {
		return (EAttribute) concreteTypeTwoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getNode_Label() {
		return (EAttribute) nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getNode_Target() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getNode_Source() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getNode_ManyRef() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getNode_Child() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getNode_UniqueChild() {
		return (EReference) nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getObjectWithMap() {
		return objectWithMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getObjectWithMap_Entries() {
		return (EReference) objectWithMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getObjectWithMap_Dependencies() {
		return (EReference) objectWithMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EEnum getSex() {
		return sexEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory) getEFactoryInstance();
	}

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
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

		// Create data types
		uriEDataType = createEDataType(URI);
	}

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
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

		// Initialize classes and features; add operations and parameters
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
		initEAttribute(getPrimaryObject_UnsettableAttribute(), ecorePackage.getEString(), "unsettableAttribute", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_UnsettableAttributeWithNonNullDefault(), ecorePackage.getEString(), "unsettableAttributeWithNonNullDefault", "junit", 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_UnsettableReference(), this.getTargetObject(), null, "unsettableReference", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_ContainmentReferenceSameCollectioin(), this.getPrimaryObject(), null, "containmentReferenceSameCollectioin", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleNonContainmentReference(), this.getTargetObject(), null, "singleNonContainmentReference", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleNonContainmentReference(), this.getTargetObject(), null, "multipleNonContainmentReference", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleContainmentReferenceNoProxies(), this.getTargetObject(), null, "singleContainmentReferenceNoProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleContainmentReferenceNoProxies(), this.getTargetObject(), null, "multipleContainmentReferenceNoProxies", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleContainmentReferenceProxies(), this.getTargetObject(), null, "singleContainmentReferenceProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_MultipleContainmentReferenceProxies(), this.getTargetObject(), null, "multipleContainmentReferenceProxies", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_SingleNonContainmentReferenceNoProxies(), this.getTargetObject(), null, "singleNonContainmentReferenceNoProxies", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_FeatureMapReferenceType1(), this.getTargetObject(), null, "featureMapReferenceType1", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryObject_FeatureMapReferenceType2(), this.getTargetObject(), null, "featureMapReferenceType2", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapReferenceCollection(), ecorePackage.getEFeatureMapEntry(), "featureMapReferenceCollection", null, 0, 1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeType1(), ecorePackage.getEString(), "featureMapAttributeType1", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeType2(), ecorePackage.getEString(), "featureMapAttributeType2", null, 0, -1, PrimaryObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimaryObject_FeatureMapAttributeCollection(), ecorePackage.getEFeatureMapEntry(), "featureMapAttributeCollection", null, 0, -1, PrimaryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, org.emfjson.gwt.junit.model.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Elements(), this.getAbstractType(), null, "elements", null, 0, -1, org.emfjson.gwt.junit.model.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
	 *
	 * @generated
	 */
	protected void createJSONAnnotations() {
		String source = "JSON";
		addAnnotation
			(userEClass,
				source,
				new String[]{
					"root", "true"
				});
		addAnnotation
			(getObjectWithMap_Entries(),
				source,
				new String[]{
					"dynamicMap", "true"
				});
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
			(getPrimaryObject_FeatureMapReferenceType1(),
				source,
				new String[]{
					"group", "#featureMapReferenceCollection"
				});
		addAnnotation
			(getPrimaryObject_FeatureMapReferenceType2(),
				source,
				new String[]{
					"group", "#featureMapReferenceCollection"
				});
		addAnnotation
			(getPrimaryObject_FeatureMapReferenceCollection(),
				source,
				new String[]{
					"kind", "group"
				});
		addAnnotation
			(getPrimaryObject_FeatureMapAttributeType1(),
				source,
				new String[]{
					"group", "#featureMapAttributeCollection"
				});
		addAnnotation
			(getPrimaryObject_FeatureMapAttributeType2(),
				source,
				new String[]{
					"group", "#featureMapAttributeCollection"
				});
		addAnnotation
			(getPrimaryObject_FeatureMapAttributeCollection(),
				source,
				new String[]{
					"kind", "group"
				});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static class WhiteList implements IsSerializable, EBasicWhiteList {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected User user;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected Address address;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected ETypes eTypes;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected PrimaryObject primaryObject;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected org.emfjson.gwt.junit.model.Container container;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected TargetObject targetObject;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected AbstractType abstractType;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected ConcreteTypeOne concreteTypeOne;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected ConcreteTypeTwo concreteTypeTwo;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected Node node;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected ObjectWithMap objectWithMap;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected Sex sex;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		protected org.eclipse.emf.common.util.URI uri;

	}

} //ModelPackageImpl
