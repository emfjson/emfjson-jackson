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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emfjson.gwt.junit.model.ModelPackage;
import org.emfjson.gwt.junit.model.ObjectWithMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object With Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ObjectWithMapImpl#getEntries <em>Entries</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ObjectWithMapImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectWithMapImpl extends EObjectImpl implements ObjectWithMap {
	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEntries()
	 */
	@GwtTransient
	protected EMap<String, String> entries;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getDependencies()
	 */
	@GwtTransient
	protected EMap<String, String> dependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ObjectWithMapImpl() {
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
		return ModelPackage.Literals.OBJECT_WITH_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EMap<String, String> getEntries() {
		if (entries == null) {
			entries = new EcoreEMap<String, String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ModelPackage.OBJECT_WITH_MAP__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EMap<String, String> getDependencies() {
		if (dependencies == null) {
			dependencies = new EcoreEMap<String, String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ModelPackage.OBJECT_WITH_MAP__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.OBJECT_WITH_MAP__ENTRIES:
				return ((InternalEList<?>) getEntries()).basicRemove(otherEnd, msgs);
			case ModelPackage.OBJECT_WITH_MAP__DEPENDENCIES:
				return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ModelPackage.OBJECT_WITH_MAP__ENTRIES:
				if (coreType) return getEntries();
				else return getEntries().map();
			case ModelPackage.OBJECT_WITH_MAP__DEPENDENCIES:
				if (coreType) return getDependencies();
				else return getDependencies().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.OBJECT_WITH_MAP__ENTRIES:
				((EStructuralFeature.Setting) getEntries()).set(newValue);
				return;
			case ModelPackage.OBJECT_WITH_MAP__DEPENDENCIES:
				((EStructuralFeature.Setting) getDependencies()).set(newValue);
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
			case ModelPackage.OBJECT_WITH_MAP__ENTRIES:
				getEntries().clear();
				return;
			case ModelPackage.OBJECT_WITH_MAP__DEPENDENCIES:
				getDependencies().clear();
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
			case ModelPackage.OBJECT_WITH_MAP__ENTRIES:
				return entries != null && !entries.isEmpty();
			case ModelPackage.OBJECT_WITH_MAP__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectWithMapImpl
