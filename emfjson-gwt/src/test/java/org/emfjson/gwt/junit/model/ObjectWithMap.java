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

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object With Map</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.ObjectWithMap#getEntries <em>Entries</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ObjectWithMap#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getObjectWithMap()
 */
public interface ObjectWithMap extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Entries</em>' map.
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * annotation="JSON dynamicMap='true'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getObjectWithMap_Entries()
	 */
	EMap<String, String> getEntries();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Dependencies</em>' map.
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getObjectWithMap_Dependencies()
	 */
	EMap<String, String> getDependencies();

} // ObjectWithMap
