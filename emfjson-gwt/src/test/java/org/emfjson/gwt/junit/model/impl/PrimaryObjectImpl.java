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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.*;

import org.emfjson.gwt.junit.model.ModelPackage;
import org.emfjson.gwt.junit.model.PrimaryObject;
import org.emfjson.gwt.junit.model.TargetObject;

import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getName <em>Name</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getIdAttribute <em>Id Attribute</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getUnsettableAttribute <em>Unsettable Attribute</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getUnsettableAttributeWithNonNullDefault <em>Unsettable Attribute With Non Null Default</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getUnsettableReference <em>Unsettable Reference</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getContainmentReferenceSameCollectioin <em>Containment Reference Same Collectioin</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getSingleNonContainmentReference <em>Single Non Containment Reference</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getMultipleNonContainmentReference <em>Multiple Non Containment Reference</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getSingleContainmentReferenceNoProxies <em>Single Containment Reference No Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getMultipleContainmentReferenceNoProxies <em>Multiple Containment Reference No Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getSingleContainmentReferenceProxies <em>Single Containment Reference Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getMultipleContainmentReferenceProxies <em>Multiple Containment Reference Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getSingleNonContainmentReferenceNoProxies <em>Single Non Containment Reference No Proxies</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getFeatureMapReferenceType1 <em>Feature Map Reference Type1</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getFeatureMapReferenceType2 <em>Feature Map Reference Type2</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getFeatureMapReferenceCollection <em>Feature Map Reference Collection</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getFeatureMapAttributeType1 <em>Feature Map Attribute Type1</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getFeatureMapAttributeType2 <em>Feature Map Attribute Type2</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.PrimaryObjectImpl#getFeatureMapAttributeCollection <em>Feature Map Attribute Collection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryObjectImpl extends EObjectImpl implements PrimaryObject {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getName()
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getIdAttribute() <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getIdAttribute()
	 */
	protected static final String ID_ATTRIBUTE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getUnsettableAttribute() <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUnsettableAttribute()
	 */
	protected static final String UNSETTABLE_ATTRIBUTE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getUnsettableAttributeWithNonNullDefault() <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 */
	protected static final String UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT = "junit";
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getName()
	 */
	@GwtTransient
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getIdAttribute() <em>Id Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getIdAttribute()
	 */
	@GwtTransient
	protected String idAttribute = ID_ATTRIBUTE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getUnsettableAttribute() <em>Unsettable Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUnsettableAttribute()
	 */
	@GwtTransient
	protected String unsettableAttribute = UNSETTABLE_ATTRIBUTE_EDEFAULT;
	/**
	 * This is true if the Unsettable Attribute attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	@GwtTransient
	protected boolean unsettableAttributeESet;
	/**
	 * The cached value of the '{@link #getUnsettableAttributeWithNonNullDefault() <em>Unsettable Attribute With Non Null Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUnsettableAttributeWithNonNullDefault()
	 */
	@GwtTransient
	protected String unsettableAttributeWithNonNullDefault = UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT;

	/**
	 * This is true if the Unsettable Attribute With Non Null Default attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	@GwtTransient
	protected boolean unsettableAttributeWithNonNullDefaultESet;

	/**
	 * The cached value of the '{@link #getUnsettableReference() <em>Unsettable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUnsettableReference()
	 */
	@GwtTransient
	protected TargetObject unsettableReference;

	/**
	 * This is true if the Unsettable Reference reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	@GwtTransient
	protected boolean unsettableReferenceESet;

	/**
	 * The cached value of the '{@link #getContainmentReferenceSameCollectioin() <em>Containment Reference Same Collectioin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getContainmentReferenceSameCollectioin()
	 */
	@GwtTransient
	protected PrimaryObject containmentReferenceSameCollectioin;

	/**
	 * The cached value of the '{@link #getSingleNonContainmentReference() <em>Single Non Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSingleNonContainmentReference()
	 */
	@GwtTransient
	protected TargetObject singleNonContainmentReference;

	/**
	 * The cached value of the '{@link #getMultipleNonContainmentReference() <em>Multiple Non Containment Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getMultipleNonContainmentReference()
	 */
	@GwtTransient
	protected EList<TargetObject> multipleNonContainmentReference;

	/**
	 * The cached value of the '{@link #getSingleContainmentReferenceNoProxies() <em>Single Containment Reference No Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSingleContainmentReferenceNoProxies()
	 */
	@GwtTransient
	protected TargetObject singleContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getMultipleContainmentReferenceNoProxies() <em>Multiple Containment Reference No Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getMultipleContainmentReferenceNoProxies()
	 */
	@GwtTransient
	protected EList<TargetObject> multipleContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getSingleContainmentReferenceProxies() <em>Single Containment Reference Proxies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSingleContainmentReferenceProxies()
	 */
	@GwtTransient
	protected TargetObject singleContainmentReferenceProxies;

	/**
	 * The cached value of the '{@link #getMultipleContainmentReferenceProxies() <em>Multiple Containment Reference Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getMultipleContainmentReferenceProxies()
	 */
	@GwtTransient
	protected EList<TargetObject> multipleContainmentReferenceProxies;

	/**
	 * The cached value of the '{@link #getSingleNonContainmentReferenceNoProxies() <em>Single Non Containment Reference No Proxies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getSingleNonContainmentReferenceNoProxies()
	 */
	@GwtTransient
	protected TargetObject singleNonContainmentReferenceNoProxies;

	/**
	 * The cached value of the '{@link #getFeatureMapReferenceCollection() <em>Feature Map Reference Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getFeatureMapReferenceCollection()
	 */
	@GwtTransient
	protected FeatureMap featureMapReferenceCollection;

	/**
	 * The cached value of the '{@link #getFeatureMapAttributeCollection() <em>Feature Map Attribute Collection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getFeatureMapAttributeCollection()
	 */
	@GwtTransient
	protected FeatureMap featureMapAttributeCollection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PrimaryObjectImpl() {
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
		return ModelPackage.Literals.PRIMARY_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getIdAttribute() {
		return idAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setIdAttribute(String newIdAttribute) {
		String oldIdAttribute = idAttribute;
		idAttribute = newIdAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE, oldIdAttribute, idAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getUnsettableAttribute() {
		return unsettableAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setUnsettableAttribute(String newUnsettableAttribute) {
		String oldUnsettableAttribute = unsettableAttribute;
		unsettableAttribute = newUnsettableAttribute;
		boolean oldUnsettableAttributeESet = unsettableAttributeESet;
		unsettableAttributeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE, oldUnsettableAttribute, unsettableAttribute, !oldUnsettableAttributeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void unsetUnsettableAttribute() {
		String oldUnsettableAttribute = unsettableAttribute;
		boolean oldUnsettableAttributeESet = unsettableAttributeESet;
		unsettableAttribute = UNSETTABLE_ATTRIBUTE_EDEFAULT;
		unsettableAttributeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE, oldUnsettableAttribute, UNSETTABLE_ATTRIBUTE_EDEFAULT, oldUnsettableAttributeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isSetUnsettableAttribute() {
		return unsettableAttributeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getUnsettableAttributeWithNonNullDefault() {
		return unsettableAttributeWithNonNullDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setUnsettableAttributeWithNonNullDefault(String newUnsettableAttributeWithNonNullDefault) {
		String oldUnsettableAttributeWithNonNullDefault = unsettableAttributeWithNonNullDefault;
		unsettableAttributeWithNonNullDefault = newUnsettableAttributeWithNonNullDefault;
		boolean oldUnsettableAttributeWithNonNullDefaultESet = unsettableAttributeWithNonNullDefaultESet;
		unsettableAttributeWithNonNullDefaultESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT, oldUnsettableAttributeWithNonNullDefault, unsettableAttributeWithNonNullDefault, !oldUnsettableAttributeWithNonNullDefaultESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void unsetUnsettableAttributeWithNonNullDefault() {
		String oldUnsettableAttributeWithNonNullDefault = unsettableAttributeWithNonNullDefault;
		boolean oldUnsettableAttributeWithNonNullDefaultESet = unsettableAttributeWithNonNullDefaultESet;
		unsettableAttributeWithNonNullDefault = UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT;
		unsettableAttributeWithNonNullDefaultESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT, oldUnsettableAttributeWithNonNullDefault, UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT_EDEFAULT, oldUnsettableAttributeWithNonNullDefaultESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isSetUnsettableAttributeWithNonNullDefault() {
		return unsettableAttributeWithNonNullDefaultESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject getUnsettableReference() {
		if (unsettableReference != null && unsettableReference.eIsProxy()) {
			InternalEObject oldUnsettableReference = (InternalEObject) unsettableReference;
			unsettableReference = (TargetObject) eResolveProxy(oldUnsettableReference);
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
	 *
	 * @generated
	 */
	public void setUnsettableReference(TargetObject newUnsettableReference) {
		TargetObject oldUnsettableReference = unsettableReference;
		unsettableReference = newUnsettableReference;
		boolean oldUnsettableReferenceESet = unsettableReferenceESet;
		unsettableReferenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, unsettableReference, !oldUnsettableReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject basicGetUnsettableReference() {
		return unsettableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void unsetUnsettableReference() {
		TargetObject oldUnsettableReference = unsettableReference;
		boolean oldUnsettableReferenceESet = unsettableReferenceESet;
		unsettableReference = null;
		unsettableReferenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE, oldUnsettableReference, null, oldUnsettableReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isSetUnsettableReference() {
		return unsettableReferenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PrimaryObject getContainmentReferenceSameCollectioin() {
		if (containmentReferenceSameCollectioin != null && containmentReferenceSameCollectioin.eIsProxy()) {
			InternalEObject oldContainmentReferenceSameCollectioin = (InternalEObject) containmentReferenceSameCollectioin;
			containmentReferenceSameCollectioin = (PrimaryObject) eResolveProxy(oldContainmentReferenceSameCollectioin);
			if (containmentReferenceSameCollectioin != oldContainmentReferenceSameCollectioin) {
				InternalEObject newContainmentReferenceSameCollectioin = (InternalEObject) containmentReferenceSameCollectioin;
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
	 *
	 * @generated
	 */
	public void setContainmentReferenceSameCollectioin(PrimaryObject newContainmentReferenceSameCollectioin) {
		if (newContainmentReferenceSameCollectioin != containmentReferenceSameCollectioin) {
			NotificationChain msgs = null;
			if (containmentReferenceSameCollectioin != null)
				msgs = ((InternalEObject) containmentReferenceSameCollectioin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
			if (newContainmentReferenceSameCollectioin != null)
				msgs = ((InternalEObject) newContainmentReferenceSameCollectioin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, null, msgs);
			msgs = basicSetContainmentReferenceSameCollectioin(newContainmentReferenceSameCollectioin, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, newContainmentReferenceSameCollectioin, newContainmentReferenceSameCollectioin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PrimaryObject basicGetContainmentReferenceSameCollectioin() {
		return containmentReferenceSameCollectioin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetContainmentReferenceSameCollectioin(PrimaryObject newContainmentReferenceSameCollectioin, NotificationChain msgs) {
		PrimaryObject oldContainmentReferenceSameCollectioin = containmentReferenceSameCollectioin;
		containmentReferenceSameCollectioin = newContainmentReferenceSameCollectioin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN, oldContainmentReferenceSameCollectioin, newContainmentReferenceSameCollectioin);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject getSingleNonContainmentReference() {
		if (singleNonContainmentReference != null && singleNonContainmentReference.eIsProxy()) {
			InternalEObject oldSingleNonContainmentReference = (InternalEObject) singleNonContainmentReference;
			singleNonContainmentReference = (TargetObject) eResolveProxy(oldSingleNonContainmentReference);
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
	 *
	 * @generated
	 */
	public void setSingleNonContainmentReference(TargetObject newSingleNonContainmentReference) {
		TargetObject oldSingleNonContainmentReference = singleNonContainmentReference;
		singleNonContainmentReference = newSingleNonContainmentReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE, oldSingleNonContainmentReference, singleNonContainmentReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject basicGetSingleNonContainmentReference() {
		return singleNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<TargetObject> getMultipleNonContainmentReference() {
		if (multipleNonContainmentReference == null) {
			multipleNonContainmentReference = new EObjectResolvingEList<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE);
		}
		return multipleNonContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject getSingleContainmentReferenceNoProxies() {
		return singleContainmentReferenceNoProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setSingleContainmentReferenceNoProxies(TargetObject newSingleContainmentReferenceNoProxies) {
		if (newSingleContainmentReferenceNoProxies != singleContainmentReferenceNoProxies) {
			NotificationChain msgs = null;
			if (singleContainmentReferenceNoProxies != null)
				msgs = ((InternalEObject) singleContainmentReferenceNoProxies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, null, msgs);
			if (newSingleContainmentReferenceNoProxies != null)
				msgs = ((InternalEObject) newSingleContainmentReferenceNoProxies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, null, msgs);
			msgs = basicSetSingleContainmentReferenceNoProxies(newSingleContainmentReferenceNoProxies, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, newSingleContainmentReferenceNoProxies, newSingleContainmentReferenceNoProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSingleContainmentReferenceNoProxies(TargetObject newSingleContainmentReferenceNoProxies, NotificationChain msgs) {
		TargetObject oldSingleContainmentReferenceNoProxies = singleContainmentReferenceNoProxies;
		singleContainmentReferenceNoProxies = newSingleContainmentReferenceNoProxies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES, oldSingleContainmentReferenceNoProxies, newSingleContainmentReferenceNoProxies);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<TargetObject> getMultipleContainmentReferenceNoProxies() {
		if (multipleContainmentReferenceNoProxies == null) {
			multipleContainmentReferenceNoProxies = new EObjectContainmentEList<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES);
		}
		return multipleContainmentReferenceNoProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject getSingleContainmentReferenceProxies() {
		if (singleContainmentReferenceProxies != null && singleContainmentReferenceProxies.eIsProxy()) {
			InternalEObject oldSingleContainmentReferenceProxies = (InternalEObject) singleContainmentReferenceProxies;
			singleContainmentReferenceProxies = (TargetObject) eResolveProxy(oldSingleContainmentReferenceProxies);
			if (singleContainmentReferenceProxies != oldSingleContainmentReferenceProxies) {
				InternalEObject newSingleContainmentReferenceProxies = (InternalEObject) singleContainmentReferenceProxies;
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
	 *
	 * @generated
	 */
	public void setSingleContainmentReferenceProxies(TargetObject newSingleContainmentReferenceProxies) {
		if (newSingleContainmentReferenceProxies != singleContainmentReferenceProxies) {
			NotificationChain msgs = null;
			if (singleContainmentReferenceProxies != null)
				msgs = ((InternalEObject) singleContainmentReferenceProxies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
			if (newSingleContainmentReferenceProxies != null)
				msgs = ((InternalEObject) newSingleContainmentReferenceProxies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, null, msgs);
			msgs = basicSetSingleContainmentReferenceProxies(newSingleContainmentReferenceProxies, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, newSingleContainmentReferenceProxies, newSingleContainmentReferenceProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject basicGetSingleContainmentReferenceProxies() {
		return singleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSingleContainmentReferenceProxies(TargetObject newSingleContainmentReferenceProxies, NotificationChain msgs) {
		TargetObject oldSingleContainmentReferenceProxies = singleContainmentReferenceProxies;
		singleContainmentReferenceProxies = newSingleContainmentReferenceProxies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES, oldSingleContainmentReferenceProxies, newSingleContainmentReferenceProxies);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<TargetObject> getMultipleContainmentReferenceProxies() {
		if (multipleContainmentReferenceProxies == null) {
			multipleContainmentReferenceProxies = new EObjectContainmentEList.Resolving<TargetObject>(TargetObject.class, this, ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES);
		}
		return multipleContainmentReferenceProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TargetObject getSingleNonContainmentReferenceNoProxies() {
		return singleNonContainmentReferenceNoProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setSingleNonContainmentReferenceNoProxies(TargetObject newSingleNonContainmentReferenceNoProxies) {
		TargetObject oldSingleNonContainmentReferenceNoProxies = singleNonContainmentReferenceNoProxies;
		singleNonContainmentReferenceNoProxies = newSingleNonContainmentReferenceNoProxies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES, oldSingleNonContainmentReferenceNoProxies, singleNonContainmentReferenceNoProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<TargetObject> getFeatureMapReferenceType1() {
		return getFeatureMapReferenceCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<TargetObject> getFeatureMapReferenceType2() {
		return getFeatureMapReferenceCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public FeatureMap getFeatureMapReferenceCollection() {
		if (featureMapReferenceCollection == null) {
			featureMapReferenceCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION);
		}
		return featureMapReferenceCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getFeatureMapAttributeType1() {
		return getFeatureMapAttributeCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getFeatureMapAttributeType2() {
		return getFeatureMapAttributeCollection().list(ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public FeatureMap getFeatureMapAttributeCollection() {
		if (featureMapAttributeCollection == null) {
			featureMapAttributeCollection = new BasicFeatureMap(this, ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION);
		}
		return featureMapAttributeCollection;
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
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				return basicSetContainmentReferenceSameCollectioin(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return basicSetSingleContainmentReferenceNoProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				return ((InternalEList<?>) getMultipleContainmentReferenceNoProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				return basicSetSingleContainmentReferenceProxies(null, msgs);
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				return ((InternalEList<?>) getMultipleContainmentReferenceProxies()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				return ((InternalEList<?>) getFeatureMapReferenceType1()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				return ((InternalEList<?>) getFeatureMapReferenceType2()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				return ((InternalEList<?>) getFeatureMapReferenceCollection()).basicRemove(otherEnd, msgs);
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				return ((InternalEList<?>) getFeatureMapAttributeCollection()).basicRemove(otherEnd, msgs);
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
				return ((FeatureMap.Internal) getFeatureMapReferenceCollection()).getWrapper();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				return getFeatureMapAttributeType1();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				return getFeatureMapAttributeType2();
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				if (coreType) return getFeatureMapAttributeCollection();
				return ((FeatureMap.Internal) getFeatureMapAttributeCollection()).getWrapper();
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				setName((String) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				setIdAttribute((String) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				setUnsettableAttribute((String) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				setUnsettableAttributeWithNonNullDefault((String) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				setUnsettableReference((TargetObject) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				setContainmentReferenceSameCollectioin((PrimaryObject) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				setSingleNonContainmentReference((TargetObject) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				getMultipleNonContainmentReference().clear();
				getMultipleNonContainmentReference().addAll((Collection<? extends TargetObject>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleContainmentReferenceNoProxies((TargetObject) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				getMultipleContainmentReferenceNoProxies().clear();
				getMultipleContainmentReferenceNoProxies().addAll((Collection<? extends TargetObject>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				setSingleContainmentReferenceProxies((TargetObject) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				getMultipleContainmentReferenceProxies().clear();
				getMultipleContainmentReferenceProxies().addAll((Collection<? extends TargetObject>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleNonContainmentReferenceNoProxies((TargetObject) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1:
				getFeatureMapReferenceType1().clear();
				getFeatureMapReferenceType1().addAll((Collection<? extends TargetObject>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE2:
				getFeatureMapReferenceType2().clear();
				getFeatureMapReferenceType2().addAll((Collection<? extends TargetObject>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_COLLECTION:
				((FeatureMap.Internal) getFeatureMapReferenceCollection()).set(newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE1:
				getFeatureMapAttributeType1().clear();
				getFeatureMapAttributeType1().addAll((Collection<? extends String>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_TYPE2:
				getFeatureMapAttributeType2().clear();
				getFeatureMapAttributeType2().addAll((Collection<? extends String>) newValue);
				return;
			case ModelPackage.PRIMARY_OBJECT__FEATURE_MAP_ATTRIBUTE_COLLECTION:
				((FeatureMap.Internal) getFeatureMapAttributeCollection()).set(newValue);
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				setIdAttribute(ID_ATTRIBUTE_EDEFAULT);
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				unsetUnsettableAttribute();
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				unsetUnsettableAttributeWithNonNullDefault();
				return;
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				unsetUnsettableReference();
				return;
			case ModelPackage.PRIMARY_OBJECT__CONTAINMENT_REFERENCE_SAME_COLLECTIOIN:
				setContainmentReferenceSameCollectioin((PrimaryObject) null);
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE:
				setSingleNonContainmentReference((TargetObject) null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_NON_CONTAINMENT_REFERENCE:
				getMultipleNonContainmentReference().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleContainmentReferenceNoProxies((TargetObject) null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_NO_PROXIES:
				getMultipleContainmentReferenceNoProxies().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES:
				setSingleContainmentReferenceProxies((TargetObject) null);
				return;
			case ModelPackage.PRIMARY_OBJECT__MULTIPLE_CONTAINMENT_REFERENCE_PROXIES:
				getMultipleContainmentReferenceProxies().clear();
				return;
			case ModelPackage.PRIMARY_OBJECT__SINGLE_NON_CONTAINMENT_REFERENCE_NO_PROXIES:
				setSingleNonContainmentReferenceNoProxies((TargetObject) null);
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
			case ModelPackage.PRIMARY_OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PRIMARY_OBJECT__ID_ATTRIBUTE:
				return ID_ATTRIBUTE_EDEFAULT == null ? idAttribute != null : !ID_ATTRIBUTE_EDEFAULT.equals(idAttribute);
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE:
				return isSetUnsettableAttribute();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_ATTRIBUTE_WITH_NON_NULL_DEFAULT:
				return isSetUnsettableAttributeWithNonNullDefault();
			case ModelPackage.PRIMARY_OBJECT__UNSETTABLE_REFERENCE:
				return isSetUnsettableReference();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", idAttribute: ");
		result.append(idAttribute);
		result.append(", unsettableAttribute: ");
		if (unsettableAttributeESet) result.append(unsettableAttribute);
		else result.append("<unset>");
		result.append(", unsettableAttributeWithNonNullDefault: ");
		if (unsettableAttributeWithNonNullDefaultESet) result.append(unsettableAttributeWithNonNullDefault);
		else result.append("<unset>");
		result.append(", featureMapReferenceCollection: ");
		result.append(featureMapReferenceCollection);
		result.append(", featureMapAttributeCollection: ");
		result.append(featureMapAttributeCollection);
		result.append(')');
		return result.toString();
	}

} //PrimaryObjectImpl
