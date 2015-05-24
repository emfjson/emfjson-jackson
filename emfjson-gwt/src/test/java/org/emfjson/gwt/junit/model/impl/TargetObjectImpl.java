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

import com.google.gwt.user.client.rpc.GwtTransient;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.emfjson.gwt.junit.model.ModelPackage;
import org.emfjson.gwt.junit.model.TargetObject;

import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.impl.TargetObjectImpl#getSingleAttribute <em>Single Attribute</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.TargetObjectImpl#getArrayAttribute <em>Array Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetObjectImpl extends EObjectImpl implements TargetObject {
	/**
	 * The default value of the '{@link #getSingleAttribute() <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSingleAttribute()
	 */
	protected static final String SINGLE_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSingleAttribute() <em>Single Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSingleAttribute()
	 */
	@GwtTransient
	protected String singleAttribute = SINGLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArrayAttribute() <em>Array Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getArrayAttribute()
	 */
	@GwtTransient
	protected EList<String> arrayAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TargetObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TARGET_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getSingleAttribute() {
		return singleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setSingleAttribute(String newSingleAttribute) {
		String oldSingleAttribute = singleAttribute;
		singleAttribute = newSingleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE, oldSingleAttribute, singleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getArrayAttribute() {
		if (arrayAttribute == null) {
			arrayAttribute = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE);
		}
		return arrayAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				return getSingleAttribute();
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				return getArrayAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				setSingleAttribute((String) newValue);
				return;
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				getArrayAttribute().clear();
				getArrayAttribute().addAll((Collection<? extends String>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				setSingleAttribute(SINGLE_ATTRIBUTE_EDEFAULT);
				return;
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				getArrayAttribute().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.TARGET_OBJECT__SINGLE_ATTRIBUTE:
				return SINGLE_ATTRIBUTE_EDEFAULT == null ? singleAttribute != null : !SINGLE_ATTRIBUTE_EDEFAULT.equals(singleAttribute);
			case ModelPackage.TARGET_OBJECT__ARRAY_ATTRIBUTE:
				return arrayAttribute != null && !arrayAttribute.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (singleAttribute: ");
		result.append(singleAttribute);
		result.append(", arrayAttribute: ");
		result.append(arrayAttribute);
		result.append(')');
		return result.toString();
	}

} //TargetObjectImpl
