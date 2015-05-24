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
package org.emfjson.gwt.junit.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import org.emfjson.gwt.junit.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static ModelPackage modelPackage;
	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseUser(User object) {
				return createUserAdapter();
			}

			@Override
			public Adapter caseAddress(Address object) {
				return createAddressAdapter();
			}

			@Override
			public Adapter caseETypes(ETypes object) {
				return createETypesAdapter();
			}

			@Override
			public Adapter casePrimaryObject(PrimaryObject object) {
				return createPrimaryObjectAdapter();
			}

			@Override
			public Adapter caseContainer(Container object) {
				return createContainerAdapter();
			}

			@Override
			public Adapter caseTargetObject(TargetObject object) {
				return createTargetObjectAdapter();
			}

			@Override
			public Adapter caseAbstractType(AbstractType object) {
				return createAbstractTypeAdapter();
			}

			@Override
			public Adapter caseConcreteTypeOne(ConcreteTypeOne object) {
				return createConcreteTypeOneAdapter();
			}

			@Override
			public Adapter caseConcreteTypeTwo(ConcreteTypeTwo object) {
				return createConcreteTypeTwoAdapter();
			}

			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}

			@Override
			public Adapter caseObjectWithMap(ObjectWithMap object) {
				return createObjectWithMapAdapter();
			}

			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.User
	 */
	public Adapter createUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.Address
	 */
	public Adapter createAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.ETypes <em>ETypes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ETypes
	 */
	public Adapter createETypesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.PrimaryObject <em>Primary Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.PrimaryObject
	 */
	public Adapter createPrimaryObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.Container
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.TargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.TargetObject
	 */
	public Adapter createTargetObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.AbstractType <em>Abstract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.AbstractType
	 */
	public Adapter createAbstractTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.ConcreteTypeOne <em>Concrete Type One</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ConcreteTypeOne
	 */
	public Adapter createConcreteTypeOneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.ConcreteTypeTwo <em>Concrete Type Two</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ConcreteTypeTwo
	 */
	public Adapter createConcreteTypeTwoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.Node
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emfjson.gwt.junit.model.ObjectWithMap <em>Object With Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ObjectWithMap
	 */
	public Adapter createObjectWithMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
