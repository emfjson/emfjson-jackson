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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import org.emfjson.gwt.junit.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage
 */
public class ModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return whether this is a switch for the given package.
	 * @parameter ePackage the package in question.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.USER: {
				User user = (User) theEObject;
				T result = caseUser(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ADDRESS: {
				Address address = (Address) theEObject;
				T result = caseAddress(address);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ETYPES: {
				ETypes eTypes = (ETypes) theEObject;
				T result = caseETypes(eTypes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRIMARY_OBJECT: {
				PrimaryObject primaryObject = (PrimaryObject) theEObject;
				T result = casePrimaryObject(primaryObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONTAINER: {
				Container container = (Container) theEObject;
				T result = caseContainer(container);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TARGET_OBJECT: {
				TargetObject targetObject = (TargetObject) theEObject;
				T result = caseTargetObject(targetObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_TYPE: {
				AbstractType abstractType = (AbstractType) theEObject;
				T result = caseAbstractType(abstractType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONCRETE_TYPE_ONE: {
				ConcreteTypeOne concreteTypeOne = (ConcreteTypeOne) theEObject;
				T result = caseConcreteTypeOne(concreteTypeOne);
				if (result == null) result = caseAbstractType(concreteTypeOne);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONCRETE_TYPE_TWO: {
				ConcreteTypeTwo concreteTypeTwo = (ConcreteTypeTwo) theEObject;
				T result = caseConcreteTypeTwo(concreteTypeTwo);
				if (result == null) result = caseAbstractType(concreteTypeTwo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.NODE: {
				Node node = (Node) theEObject;
				T result = caseNode(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OBJECT_WITH_MAP: {
				ObjectWithMap objectWithMap = (ObjectWithMap) theEObject;
				T result = caseObjectWithMap(objectWithMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseAddress(Address object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETypes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETypes</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseETypes(ETypes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Object</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T casePrimaryObject(PrimaryObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseContainer(Container object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Object</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseTargetObject(TargetObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseAbstractType(AbstractType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Type One</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Type One</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseConcreteTypeOne(ConcreteTypeOne object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Type Two</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Type Two</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseConcreteTypeTwo(ConcreteTypeTwo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object With Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object With Map</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 */
	public T caseObjectWithMap(ObjectWithMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @generated
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
