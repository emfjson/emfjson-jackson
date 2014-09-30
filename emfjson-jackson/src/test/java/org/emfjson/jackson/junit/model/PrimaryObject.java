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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getName <em>Name</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.PrimaryObject#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryObject extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdAttribute() <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdAttribute() <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdAttribute()
	 * @generated
	 * @ordered
	 */
	protected String idAttribute = ID_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnsettableAttribute() <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String UNSETTABLE_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnsettableAttribute() <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttribute()
	 * @generated
	 * @ordered
	 */
	protected String unsettableAttribute = UNSETTABLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnsettableAttributeWithNonNullDefault() <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT = "junit";

	/**
	 * The cached value of the '{@link #getUnsettableAttributeWithNonNullDefault() <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @generated
	 * @ordered
	 */
	protected String unsettableAttributeWithNonNullDefault = UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnsettableReference() <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsettableReference()
	 * @generated
	 * @ordered
	 */
	protected TargetObject unsettableReference;

	/**
	 * The cached value of the '{@link #getContainmentReferenceSameCollectioin() <em>Containment Reference Same Collectioin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainmentReferenceSameCollectioin()
	 * @generated
	 * @ordered
	 */
	protected PrimaryObject containmentReferenceSameCollectioin;

	/**
	 * The cached value of the '{@link #getSingleNonContainmentReference() <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleNonContainmentReference()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleNonContainmentReference;

	/**
	 * The cached value of the '{@link #getMultipleNonContainmentReference() <em>Multiple Non Containment Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleNonContainmentReference()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetObject> multipleNonContainmentReference;

	/**
	 * The cached value of the '{@link #getSingleContainmentReferenceNoProxies() <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleContainmentReferenceNoProxies()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getMultipleContainmentReferenceNoProxies() <em>Multiple Containment Reference No Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleContainmentReferenceNoProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetObject> multipleContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getSingleContainmentReferenceProxies() <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleContainmentReferenceProxies()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleContainmentReferenceProxies;

	/**
	 * The cached value of the '{@link #getMultipleContainmentReferenceProxies() <em>Multiple Containment Reference Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleContainmentReferenceProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetObject> multipleContainmentReferenceProxies;

	/**
	 * The cached value of the '{@link #getSingleNonContainmentReferenceNoProxies() <em>Single Non Containment Reference No Proxies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleNonContainmentReferenceNoProxies()
	 * @generated
	 * @ordered
	 */
	protected TargetObject singleNonContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getFeatureMapReferenceCollection() <em>Feature Map Reference Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapReferenceCollection()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap featureMapReferenceCollection;

	/**
	 * The cached value of the '{@link #getFeatureMapAttributeCollection() <em>Feature Map Attribute Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureMapAttributeCollection()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap featureMapAttributeCollection;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final SomeKind KIND_EDEFAULT = SomeKind.ONE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected SomeKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimaryObject() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PRIMARY_OBJECT;
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__NAME, oldName, name));
	}

	/**
	 * Returns the value of the '<em><b>Id Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Attribute</em>' attribute.
	 * @see #setIdAttribute(String)
	 * @generated
	 */
	public String getIdAttribute() {
		return idAttribute;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getIdAttribute <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Attribute</em>' attribute.
	 * @see #getIdAttribute()
	 * @generated
	 */
	public void setIdAttribute(String newIdAttribute) {
		String oldIdAttribute = idAttribute;
		idAttribute = newIdAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE, oldIdAttribute, idAttribute));
	}

	/**
	 * Returns the value of the '<em><b>Unsettable Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsettable Attribute</em>' attribute.
	 * @see #setUnsettableAttribute(String)
	 * @generated
	 */
	public String getUnsettableAttribute() {
		return unsettableAttribute;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttribute <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsettable Attribute</em>' attribute.
	 * @see #getUnsettableAttribute()
	 * @generated
	 */
	public void setUnsettableAttribute(String newUnsettableAttribute) {
		String oldUnsettableAttribute = unsettableAttribute;
		unsettableAttribute = newUnsettableAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE, oldUnsettableAttribute, unsettableAttribute));
	}

	/**
	 * Returns the value of the '<em><b>Unsettable Attribute With Non Null Default</b></em>' attribute.
	 * The default value is <code>"junit"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Attribute With Non Null Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute.
	 * @see #setUnsettableAttributeWithNonNullDefault(String)
	 * @generated
	 */
	public String getUnsettableAttributeWithNonNullDefault() {
		return unsettableAttributeWithNonNullDefault;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsettable Attribute With Non Null Default</em>' attribute.
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 * @generated
	 */
	public void setUnsettableAttributeWithNonNullDefault(String newUnsettableAttributeWithNonNullDefault) {
		String oldUnsettableAttributeWithNonNullDefault = unsettableAttributeWithNonNullDefault;
		unsettableAttributeWithNonNullDefault = newUnsettableAttributeWithNonNullDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT, oldUnsettableAttributeWithNonNullDefault, unsettableAttributeWithNonNullDefault));
	}

	/**
	 * Returns the value of the '<em><b>Unsettable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsettable Reference</em>' reference.
	 * @see #setUnsettableReference(TargetObject)
	 * @generated
	 */
	public TargetObject getUnsettableReference() {
		if (unsettableReference != null && unsettableReference.eIsProxy()) {
			InternalEObject oldUnsettableReference = (InternalEObject)unsettableReference;
			unsettableReference = (TargetObject)eResolveProxy(oldUnsettableReference);
			if (unsettableReference != oldUnsettableReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, unsettableReference));
			}
		}
		return unsettableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject basicGetUnsettableReference() {
		return unsettableReference;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getUnsettableReference <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsettable Reference</em>' reference.
	 * @see #getUnsettableReference()
	 * @generated
	 */
	public void setUnsettableReference(TargetObject newUnsettableReference) {
		TargetObject oldUnsettableReference = unsettableReference;
		unsettableReference = newUnsettableReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, unsettableReference));
	}

	/**
	 * Returns the value of the '<em><b>Containment Reference Same Collectioin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Reference Same Collectioin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Reference Same Collectioin</em>' containment reference.
	 * @see #setContainmentReferenceSameCollectioin(PrimaryObject)
	 * @generated
	 */
	public PrimaryObject getContainmentReferenceSameCollectioin() {
		if (containmentReferenceSameCollectioin != null && containmentReferenceSameCollectioin.eIsProxy()) {
			InternalEObject oldContainmentReferenceSameCollectioin = (InternalEObject)containmentReferenceSameCollectioin;
			containmentReferenceSameCollectioin = (PrimaryObject)eResolveProxy(oldContainmentReferenceSameCollectioin);
			if (containmentReferenceSameCollectioin != oldContainmentReferenceSameCollectioin) {
				InternalEObject newContainmentReferenceSameCollectioin = (InternalEObject)containmentReferenceSameCollectioin;
				NotificationChain msgs = oldContainmentReferenceSameCollectioin.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, null);
				if (newContainmentReferenceSameCollectioin.eInternalContainer() == null) {
					msgs = newContainmentReferenceSameCollectioin.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, oldContainmentReferenceSameCollectioin, containmentReferenceSameCollectioin));
			}
		}
		return containmentReferenceSameCollectioin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryObject basicGetContainmentReferenceSameCollectioin() {
		return containmentReferenceSameCollectioin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainmentReferenceSameCollectioin(PrimaryObject newContainmentReferenceSameCollectioin, NotificationChain msgs) {
		PrimaryObject oldContainmentReferenceSameCollectioin = containmentReferenceSameCollectioin;
		containmentReferenceSameCollectioin = newContainmentReferenceSameCollectioin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, oldContainmentReferenceSameCollectioin, newContainmentReferenceSameCollectioin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Reference Same Collectioin</em>' containment reference.
	 * @see #getContainmentReferenceSameCollectioin()
	 * @generated
	 */
	public void setContainmentReferenceSameCollectioin(PrimaryObject newContainmentReferenceSameCollectioin) {
		if (newContainmentReferenceSameCollectioin != containmentReferenceSameCollectioin) {
			NotificationChain msgs = null;
			if (containmentReferenceSameCollectioin != null)
				msgs = ((InternalEObject)containmentReferenceSameCollectioin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
			if (newContainmentReferenceSameCollectioin != null)
				msgs = ((InternalEObject)newContainmentReferenceSameCollectioin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
			msgs = basicSetContainmentReferenceSameCollectioin(newContainmentReferenceSameCollectioin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, newContainmentReferenceSameCollectioin, newContainmentReferenceSameCollectioin));
	}

	/**
	 * Returns the value of the '<em><b>Single Non Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Non Containment Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Non Containment Reference</em>' reference.
	 * @see #setSingleNonContainmentReference(TargetObject)
	 * @generated
	 */
	public TargetObject getSingleNonContainmentReference() {
		if (singleNonContainmentReference != null && singleNonContainmentReference.eIsProxy()) {
			InternalEObject oldSingleNonContainmentReference = (InternalEObject)singleNonContainmentReference;
			singleNonContainmentReference = (TargetObject)eResolveProxy(oldSingleNonContainmentReference);
			if (singleNonContainmentReference != oldSingleNonContainmentReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, oldSingleNonContainmentReference, singleNonContainmentReference));
			}
		}
		return singleNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject basicGetSingleNonContainmentReference() {
		return singleNonContainmentReference;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Non Containment Reference</em>' reference.
	 * @see #getSingleNonContainmentReference()
	 * @generated
	 */
	public void setSingleNonContainmentReference(TargetObject newSingleNonContainmentReference) {
		TargetObject oldSingleNonContainmentReference = singleNonContainmentReference;
		singleNonContainmentReference = newSingleNonContainmentReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, oldSingleNonContainmentReference, singleNonContainmentReference));
	}

	/**
	 * Returns the value of the '<em><b>Multiple Non Containment Reference</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.jackson.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Non Containment Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Non Containment Reference</em>' reference list.
	 * @generated
	 */
	public List<TargetObject> getMultipleNonContainmentReference() {
		if (multipleNonContainmentReference == null) {
			multipleNonContainmentReference = new EObjectResolvingEList<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE);
		}
		return multipleNonContainmentReference;
	}

	/**
	 * Returns the value of the '<em><b>Single Containment Reference No Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference No Proxies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @see #setSingleContainmentReferenceNoProxies(TargetObject)
	 * @generated
	 */
	public TargetObject getSingleContainmentReferenceNoProxies() {
		return singleContainmentReferenceNoProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleContainmentReferenceNoProxies(TargetObject newSingleContainmentReferenceNoProxies, NotificationChain msgs) {
		TargetObject oldSingleContainmentReferenceNoProxies = singleContainmentReferenceNoProxies;
		singleContainmentReferenceNoProxies = newSingleContainmentReferenceNoProxies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, oldSingleContainmentReferenceNoProxies, newSingleContainmentReferenceNoProxies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Containment Reference No Proxies</em>' containment reference.
	 * @see #getSingleContainmentReferenceNoProxies()
	 * @generated
	 */
	public void setSingleContainmentReferenceNoProxies(TargetObject newSingleContainmentReferenceNoProxies) {
		if (newSingleContainmentReferenceNoProxies != singleContainmentReferenceNoProxies) {
			NotificationChain msgs = null;
			if (singleContainmentReferenceNoProxies != null)
				msgs = ((InternalEObject)singleContainmentReferenceNoProxies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, null, msgs);
			if (newSingleContainmentReferenceNoProxies != null)
				msgs = ((InternalEObject)newSingleContainmentReferenceNoProxies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, null, msgs);
			msgs = basicSetSingleContainmentReferenceNoProxies(newSingleContainmentReferenceNoProxies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, newSingleContainmentReferenceNoProxies, newSingleContainmentReferenceNoProxies));
	}

	/**
	 * Returns the value of the '<em><b>Multiple Containment Reference No Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.jackson.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Containment Reference No Proxies</em>' containment reference list.
	 * @generated
	 */
	public List<TargetObject> getMultipleContainmentReferenceNoProxies() {
		if (multipleContainmentReferenceNoProxies == null) {
			multipleContainmentReferenceNoProxies = new EObjectContainmentEList<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		}
		return multipleContainmentReferenceNoProxies;
	}

	/**
	 * Returns the value of the '<em><b>Single Containment Reference Proxies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Containment Reference Proxies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @see #setSingleContainmentReferenceProxies(TargetObject)
	 * @generated
	 */
	public TargetObject getSingleContainmentReferenceProxies() {
		if (singleContainmentReferenceProxies != null && singleContainmentReferenceProxies.eIsProxy()) {
			InternalEObject oldSingleContainmentReferenceProxies = (InternalEObject)singleContainmentReferenceProxies;
			singleContainmentReferenceProxies = (TargetObject)eResolveProxy(oldSingleContainmentReferenceProxies);
			if (singleContainmentReferenceProxies != oldSingleContainmentReferenceProxies) {
				InternalEObject newSingleContainmentReferenceProxies = (InternalEObject)singleContainmentReferenceProxies;
				NotificationChain msgs = oldSingleContainmentReferenceProxies.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, null);
				if (newSingleContainmentReferenceProxies.eInternalContainer() == null) {
					msgs = newSingleContainmentReferenceProxies.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, oldSingleContainmentReferenceProxies, singleContainmentReferenceProxies));
			}
		}
		return singleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetObject basicGetSingleContainmentReferenceProxies() {
		return singleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleContainmentReferenceProxies(TargetObject newSingleContainmentReferenceProxies, NotificationChain msgs) {
		TargetObject oldSingleContainmentReferenceProxies = singleContainmentReferenceProxies;
		singleContainmentReferenceProxies = newSingleContainmentReferenceProxies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, oldSingleContainmentReferenceProxies, newSingleContainmentReferenceProxies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Containment Reference Proxies</em>' containment reference.
	 * @see #getSingleContainmentReferenceProxies()
	 * @generated
	 */
	public void setSingleContainmentReferenceProxies(TargetObject newSingleContainmentReferenceProxies) {
		if (newSingleContainmentReferenceProxies != singleContainmentReferenceProxies) {
			NotificationChain msgs = null;
			if (singleContainmentReferenceProxies != null)
				msgs = ((InternalEObject)singleContainmentReferenceProxies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
			if (newSingleContainmentReferenceProxies != null)
				msgs = ((InternalEObject)newSingleContainmentReferenceProxies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
			msgs = basicSetSingleContainmentReferenceProxies(newSingleContainmentReferenceProxies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, newSingleContainmentReferenceProxies, newSingleContainmentReferenceProxies));
	}

	/**
	 * Returns the value of the '<em><b>Multiple Containment Reference Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.jackson.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple Containment Reference Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple Containment Reference Proxies</em>' containment reference list.
	 * @generated
	 */
	public List<TargetObject> getMultipleContainmentReferenceProxies() {
		if (multipleContainmentReferenceProxies == null) {
			multipleContainmentReferenceProxies = new EObjectContainmentEList.Resolving<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES);
		}
		return multipleContainmentReferenceProxies;
	}

	/**
	 * Returns the value of the '<em><b>Single Non Containment Reference No Proxies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Non Containment Reference No Proxies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Non Containment Reference No Proxies</em>' reference.
	 * @see #setSingleNonContainmentReferenceNoProxies(TargetObject)
	 * @generated
	 */
	public TargetObject getSingleNonContainmentReferenceNoProxies() {
		return singleNonContainmentReferenceNoProxies;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Non Containment Reference No Proxies</em>' reference.
	 * @see #getSingleNonContainmentReferenceNoProxies()
	 * @generated
	 */
	public void setSingleNonContainmentReferenceNoProxies(TargetObject newSingleNonContainmentReferenceNoProxies) {
		TargetObject oldSingleNonContainmentReferenceNoProxies = singleNonContainmentReferenceNoProxies;
		singleNonContainmentReferenceNoProxies = newSingleNonContainmentReferenceNoProxies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES, oldSingleNonContainmentReferenceNoProxies, singleNonContainmentReferenceNoProxies));
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Type1</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.jackson.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Type1</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Reference Type1</em>' reference list.
	 * @generated
	 */
	public List<TargetObject> getFeatureMapReferenceType1() {
		return getFeatureMapReferenceCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Type2</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.jackson.junit.model.TargetObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Type2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Reference Type2</em>' containment reference list.
	 * @generated
	 */
	public List<TargetObject> getFeatureMapReferenceType2() {
		return getFeatureMapReferenceCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Reference Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Reference Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Reference Collection</em>' attribute list.
	 * @generated
	 */
	public FeatureMap getFeatureMapReferenceCollection() {
		if (featureMapReferenceCollection == null) {
			featureMapReferenceCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION);
		}
		return featureMapReferenceCollection;
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Type1</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Type1</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Attribute Type1</em>' attribute list.
	 * @generated
	 */
	public List<String> getFeatureMapAttributeType1() {
		return getFeatureMapAttributeCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Type2</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Type2</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Attribute Type2</em>' attribute list.
	 * @generated
	 */
	public List<String> getFeatureMapAttributeType2() {
		return getFeatureMapAttributeCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2);
	}

	/**
	 * Returns the value of the '<em><b>Feature Map Attribute Collection</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Map Attribute Collection</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Map Attribute Collection</em>' attribute list.
	 * @generated
	 */
	public FeatureMap getFeatureMapAttributeCollection() {
		if (featureMapAttributeCollection == null) {
			featureMapAttributeCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);
		}
		return featureMapAttributeCollection;
	}

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emfjson.jackson.junit.model.SomeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.emfjson.jackson.junit.model.SomeKind
	 * @see #setKind(SomeKind)
	 * @generated
	 */
	public SomeKind getKind() {
		return kind;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.PrimaryObject#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.emfjson.jackson.junit.model.SomeKind
	 * @see #getKind()
	 * @generated
	 */
	public void setKind(SomeKind newKind) {
		SomeKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				return basicSetContainmentReferenceSameCollectioin(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return basicSetSingleContainmentReferenceNoProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return ((InternalEList<?>)getMultipleContainmentReferenceNoProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				return basicSetSingleContainmentReferenceProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return ((InternalEList<?>)getMultipleContainmentReferenceProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return ((InternalEList<?>)getFeatureMapReferenceType2()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				return ((InternalEList<?>)getFeatureMapReferenceCollection()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				return ((InternalEList<?>)getFeatureMapAttributeCollection()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PRIMARY_OBJECT__NAME:
				return getName();
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				return getIdAttribute();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				return getUnsettableAttribute();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				return getUnsettableAttributeWithNonNullDefault();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				if (resolve) return getUnsettableReference();
				return basicGetUnsettableReference();
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				if (resolve) return getContainmentReferenceSameCollectioin();
				return basicGetContainmentReferenceSameCollectioin();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				if (resolve) return getSingleNonContainmentReference();
				return basicGetSingleNonContainmentReference();
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				return getMultipleNonContainmentReference();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return getSingleContainmentReferenceNoProxies();
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return getMultipleContainmentReferenceNoProxies();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				if (resolve) return getSingleContainmentReferenceProxies();
				return basicGetSingleContainmentReferenceProxies();
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return getMultipleContainmentReferenceProxies();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				return getSingleNonContainmentReferenceNoProxies();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				return getFeatureMapReferenceType1();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return getFeatureMapReferenceType2();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				if (coreType) return getFeatureMapReferenceCollection();
				return ((FeatureMap.Internal)getFeatureMapReferenceCollection()).getWrapper();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				return getFeatureMapAttributeType1();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				return getFeatureMapAttributeType2();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				if (coreType) return getFeatureMapAttributeCollection();
				return ((FeatureMap.Internal)getFeatureMapAttributeCollection()).getWrapper();
			case ModelPackage.PRIMARY_OBJECT__KIND:
				return getKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.PRIMARY_OBJECT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				setIdAttribute((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				setUnsettableAttribute((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				setUnsettableAttributeWithNonNullDefault((String)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				setUnsettableReference((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				setContainmentReferenceSameCollectioin((PrimaryObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				setSingleNonContainmentReference((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				getMultipleNonContainmentReference().clear();
				getMultipleNonContainmentReference().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleContainmentReferenceNoProxies((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				getMultipleContainmentReferenceNoProxies().clear();
				getMultipleContainmentReferenceNoProxies().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				setSingleContainmentReferenceProxies((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				getMultipleContainmentReferenceProxies().clear();
				getMultipleContainmentReferenceProxies().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleNonContainmentReferenceNoProxies((TargetObject)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				getFeatureMapReferenceType1().clear();
				getFeatureMapReferenceType1().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				getFeatureMapReferenceType2().clear();
				getFeatureMapReferenceType2().addAll((Collection<? extends TargetObject>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				((FeatureMap.Internal)getFeatureMapReferenceCollection()).set(newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				getFeatureMapAttributeType1().clear();
				getFeatureMapAttributeType1().addAll((Collection<? extends String>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				getFeatureMapAttributeType2().clear();
				getFeatureMapAttributeType2().addAll((Collection<? extends String>)newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				((FeatureMap.Internal)getFeatureMapAttributeCollection()).set(newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__KIND:
				setKind((SomeKind)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.PRIMARY_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				setIdAttribute(ID_ATTRIBUTE_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				setUnsettableAttribute(UNSETTABLE_ATTRIBUTE_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				setUnsettableAttributeWithNonNullDefault(UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				setUnsettableReference((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				setContainmentReferenceSameCollectioin((PrimaryObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				setSingleNonContainmentReference((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				getMultipleNonContainmentReference().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleContainmentReferenceNoProxies((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				getMultipleContainmentReferenceNoProxies().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				setSingleContainmentReferenceProxies((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				getMultipleContainmentReferenceProxies().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleNonContainmentReferenceNoProxies((TargetObject)null);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				getFeatureMapReferenceType1().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				getFeatureMapReferenceType2().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				getFeatureMapReferenceCollection().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				getFeatureMapAttributeType1().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				getFeatureMapAttributeType2().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				getFeatureMapAttributeCollection().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__KIND:
				setKind(KIND_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.PRIMARY_OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				return ID_ATTRIBUTE_EDEFAULT == null ? idAttribute != null : !ID_ATTRIBUTE_EDEFAULT.equals(idAttribute);
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				return UNSETTABLE_ATTRIBUTE_EDEFAULT == null ? unsettableAttribute != null : !UNSETTABLE_ATTRIBUTE_EDEFAULT.equals(unsettableAttribute);
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				return UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT == null ? unsettableAttributeWithNonNullDefault != null : !UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT.equals(unsettableAttributeWithNonNullDefault);
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				return unsettableReference != null;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				return containmentReferenceSameCollectioin != null;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				return singleNonContainmentReference != null;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				return multipleNonContainmentReference != null && !multipleNonContainmentReference.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return singleContainmentReferenceNoProxies != null;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return multipleContainmentReferenceNoProxies != null && !multipleContainmentReferenceNoProxies.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				return singleContainmentReferenceProxies != null;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return multipleContainmentReferenceProxies != null && !multipleContainmentReferenceProxies.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				return singleNonContainmentReferenceNoProxies != null;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				return !getFeatureMapReferenceType1().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return !getFeatureMapReferenceType2().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				return featureMapReferenceCollection != null && !featureMapReferenceCollection.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				return !getFeatureMapAttributeType1().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				return !getFeatureMapAttributeType2().isEmpty();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				return featureMapAttributeCollection != null && !featureMapAttributeCollection.isEmpty();
			case ModelPackage.PRIMARY_OBJECT__KIND:
				return kind != KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", idAttribute: ");
		result.append(idAttribute);
		result.append(", unsettableAttribute: ");
		result.append(unsettableAttribute);
		result.append(", unsettableAttributeWithNonNullDefault: ");
		result.append(unsettableAttributeWithNonNullDefault);
		result.append(", featureMapReferenceCollection: ");
		result.append(featureMapReferenceCollection);
		result.append(", featureMapAttributeCollection: ");
		result.append(featureMapAttributeCollection);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} // PrimaryObject
