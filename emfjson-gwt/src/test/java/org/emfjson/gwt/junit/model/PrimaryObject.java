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
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Object</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getName <em>Name</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.PrimaryObject#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject()
 */
public interface PrimaryObject extends EObject {
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
	 * @model
	 * @generated
	 * @see #setName(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_Name()
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @generated
	 * @see #getName()
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Id Attribute</em>' attribute.
	 * @model id="true"
	 * @generated
	 * @see #setIdAttribute(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_IdAttribute()
	 */
	String getIdAttribute();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Id Attribute</em>' attribute.
	 * @generated
	 * @see #getIdAttribute()
	 */
	void setIdAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Unsettable Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Unsettable Attribute</em>' attribute.
	 * @model unsettable="true"
	 * @generated
	 * @see #isSetUnsettableAttribute()
	 * @see #unsetUnsettableAttribute()
	 * @see #setUnsettableAttribute(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_UnsettableAttribute()
	 */
	String getUnsettableAttribute();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Unsettable Attribute</em>' attribute.
	 * @generated
	 * @see #isSetUnsettableAttribute()
	 * @see #unsetUnsettableAttribute()
	 * @see #getUnsettableAttribute()
	 */
	void setUnsettableAttribute(String value);

	/**
	 * Unsets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @see #isSetUnsettableAttribute()
	 * @see #getUnsettableAttribute()
	 * @see #setUnsettableAttribute(String)
	 */
	void unsetUnsettableAttribute();

	/**
	 * Returns whether the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return whether the value of the '<em>Unsettable Attribute</em>' attribute is set.
	 * @generated
	 * @see #unsetUnsettableAttribute()
	 * @see #getUnsettableAttribute()
	 * @see #setUnsettableAttribute(String)
	 */
	boolean isSetUnsettableAttribute();

	/**
	 * Returns the value of the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute.
	 * The default value is <code>"junit"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Attribute With Non Null Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute.
	 * @model default="junit" unsettable="true"
	 * @generated
	 * @see #isSetUnsettableAttributeWithNonNullDefault()
	 * @see #unsetUnsettableAttributeWithNonNullDefault()
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_UnsettableAttributeWithNonNullDefault()
	 */
	String getUnsettableAttributeWithNonNullDefault();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute.
	 * @generated
	 * @see #isSetUnsettableAttributeWithNonNullDefault()
	 * @see #unsetUnsettableAttributeWithNonNullDefault()
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 */
	void setUnsettableAttributeWithNonNullDefault(String value);

	/**
	 * Unsets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @see #isSetUnsettableAttributeWithNonNullDefault()
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 */
	void unsetUnsettableAttributeWithNonNullDefault();

	/**
	 * Returns whether the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return whether the value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute is set.
	 * @generated
	 * @see #unsetUnsettableAttributeWithNonNullDefault()
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 */
	boolean isSetUnsettableAttributeWithNonNullDefault();

	/**
	 * Returns the value of the '<em><b>Unsettable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Unsettable Reference</em>' reference.
	 * @model unsettable="true"
	 * @generated
	 * @see #isSetUnsettableReference()
	 * @see #unsetUnsettableReference()
	 * @see #setUnsettableReference(TargetObject)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_UnsettableReference()
	 */
	TargetObject getUnsettableReference();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Unsettable Reference</em>' reference.
	 * @generated
	 * @see #isSetUnsettableReference()
	 * @see #unsetUnsettableReference()
	 * @see #getUnsettableReference()
	 */
	void setUnsettableReference(TargetObject value);

	/**
	 * Unsets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @see #isSetUnsettableReference()
	 * @see #getUnsettableReference()
	 * @see #setUnsettableReference(TargetObject)
	 */
	void unsetUnsettableReference();

	/**
	 * Returns whether the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return whether the value of the '<em>Unsettable Reference</em>' reference is set.
	 * @generated
	 * @see #unsetUnsettableReference()
	 * @see #getUnsettableReference()
	 * @see #setUnsettableReference(TargetObject)
	 */
	boolean isSetUnsettableReference();

	/**
	 * Returns the value of the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Reference Same Collectioin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Containment Reference Same Collectioin</em>' containment reference.
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 * @see #setContainmentReferenceSameCollectioin(PrimaryObject)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_ContainmentReferenceSameCollectioin()
	 */
	PrimaryObject getContainmentReferenceSameCollectioin();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Containment Reference Same Collectioin</em>' containment reference.
	 * @generated
	 * @see #getContainmentReferenceSameCollectioin()
	 */
	void setContainmentReferenceSameCollectioin(PrimaryObject value);

	/**
	 * Returns the value of the '<em><b>Single Non Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Non Containment Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Single Non Containment Reference</em>' reference.
	 * @model
	 * @generated
	 * @see #setSingleNonContainmentReference(TargetObject)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_SingleNonContainmentReference()
	 */
	TargetObject getSingleNonContainmentReference();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Single Non Containment Reference</em>' reference.
	 * @generated
	 * @see #getSingleNonContainmentReference()
	 */
	void setSingleNonContainmentReference(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Non Containment Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Multiple Non Containment Reference</em>' reference list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_MultipleNonContainmentReference()
	 */
	EList<TargetObject> getMultipleNonContainmentReference();

	/**
	 * Returns the value of the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference No Proxies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @model containment="true"
	 * @generated
	 * @see #setSingleContainmentReferenceNoProxies(TargetObject)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_SingleContainmentReferenceNoProxies()
	 */
	TargetObject getSingleContainmentReferenceNoProxies();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @generated
	 * @see #getSingleContainmentReferenceNoProxies()
	 */
	void setSingleContainmentReferenceNoProxies(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list.
	 * @model containment="true"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_MultipleContainmentReferenceNoProxies()
	 */
	EList<TargetObject> getMultipleContainmentReferenceNoProxies();

	/**
	 * Returns the value of the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference Proxies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 * @see #setSingleContainmentReferenceProxies(TargetObject)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_SingleContainmentReferenceProxies()
	 */
	TargetObject getSingleContainmentReferenceProxies();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @generated
	 * @see #getSingleContainmentReferenceProxies()
	 */
	void setSingleContainmentReferenceProxies(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Multiple Containment Reference Proxies</em>' containment reference list.
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_MultipleContainmentReferenceProxies()
	 */
	EList<TargetObject> getMultipleContainmentReferenceProxies();

	/**
	 * Returns the value of the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Non Containment Reference No Proxies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Single Non Containment Reference No Proxies</em>' reference.
	 * @model resolveProxies="false"
	 * @generated
	 * @see #setSingleNonContainmentReferenceNoProxies(TargetObject)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_SingleNonContainmentReferenceNoProxies()
	 */
	TargetObject getSingleNonContainmentReferenceNoProxies();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Single Non Containment Reference No Proxies</em>' reference.
	 * @generated
	 * @see #getSingleNonContainmentReferenceNoProxies()
	 */
	void setSingleNonContainmentReferenceNoProxies(TargetObject value);

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Type1</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Type1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Map Reference Type1</em>' containment reference list.
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * extendedMetaData="group='#featureMapReferenceCollection'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_FeatureMapReferenceType1()
	 */
	EList<TargetObject> getFeatureMapReferenceType1();

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Type2</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Type2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Map Reference Type2</em>' containment reference list.
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * extendedMetaData="group='#featureMapReferenceCollection'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_FeatureMapReferenceType2()
	 */
	EList<TargetObject> getFeatureMapReferenceType2();

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Map Reference Collection</em>' attribute list.
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
	 * extendedMetaData="kind='group'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_FeatureMapReferenceCollection()
	 */
	FeatureMap getFeatureMapReferenceCollection();

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Type1</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Type1</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Map Attribute Type1</em>' attribute list.
	 * @model transient="true" volatile="true" derived="true"
	 * extendedMetaData="group='#featureMapAttributeCollection'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_FeatureMapAttributeType1()
	 */
	EList<String> getFeatureMapAttributeType1();

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Type2</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Type2</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Map Attribute Type2</em>' attribute list.
	 * @model transient="true" volatile="true" derived="true"
	 * extendedMetaData="group='#featureMapAttributeCollection'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_FeatureMapAttributeType2()
	 */
	EList<String> getFeatureMapAttributeType2();

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Map Attribute Collection</em>' attribute list.
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 * extendedMetaData="kind='group'"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getPrimaryObject_FeatureMapAttributeCollection()
	 */
	FeatureMap getFeatureMapAttributeCollection();

} // PrimaryObject
