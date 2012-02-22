/**
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 * 
 */
package org.eclipselabs.emfjson.rotten.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.emfjson.rotten.Review;
import org.eclipselabs.emfjson.rotten.ReviewLink;
import org.eclipselabs.emfjson.rotten.RottenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Review</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReviewImpl#getCritic <em>Critic</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReviewImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReviewImpl#getPublication <em>Publication</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReviewImpl#getQuote <em>Quote</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.ReviewImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReviewImpl extends EObjectImpl implements Review {
	/**
	 * The default value of the '{@link #getCritic() <em>Critic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCritic()
	 * @generated
	 * @ordered
	 */
	protected static final String CRITIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCritic() <em>Critic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCritic()
	 * @generated
	 * @ordered
	 */
	protected String critic = CRITIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublication() <em>Publication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublication()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublication() <em>Publication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublication()
	 * @generated
	 * @ordered
	 */
	protected String publication = PUBLICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuote() <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuote()
	 * @generated
	 * @ordered
	 */
	protected static final String QUOTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuote() <em>Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuote()
	 * @generated
	 * @ordered
	 */
	protected String quote = QUOTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ReviewLink> links;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReviewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.REVIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCritic() {
		return critic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCritic(String newCritic) {
		String oldCritic = critic;
		critic = newCritic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEW__CRITIC, oldCritic, critic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEW__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublication() {
		return publication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublication(String newPublication) {
		String oldPublication = publication;
		publication = newPublication;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEW__PUBLICATION, oldPublication, publication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuote() {
		return quote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuote(String newQuote) {
		String oldQuote = quote;
		quote = newQuote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.REVIEW__QUOTE, oldQuote, quote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReviewLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<ReviewLink>(ReviewLink.class, this, RottenPackage.REVIEW__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RottenPackage.REVIEW__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case RottenPackage.REVIEW__CRITIC:
				return getCritic();
			case RottenPackage.REVIEW__DATE:
				return getDate();
			case RottenPackage.REVIEW__PUBLICATION:
				return getPublication();
			case RottenPackage.REVIEW__QUOTE:
				return getQuote();
			case RottenPackage.REVIEW__LINKS:
				return getLinks();
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
			case RottenPackage.REVIEW__CRITIC:
				setCritic((String)newValue);
				return;
			case RottenPackage.REVIEW__DATE:
				setDate((String)newValue);
				return;
			case RottenPackage.REVIEW__PUBLICATION:
				setPublication((String)newValue);
				return;
			case RottenPackage.REVIEW__QUOTE:
				setQuote((String)newValue);
				return;
			case RottenPackage.REVIEW__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends ReviewLink>)newValue);
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
			case RottenPackage.REVIEW__CRITIC:
				setCritic(CRITIC_EDEFAULT);
				return;
			case RottenPackage.REVIEW__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case RottenPackage.REVIEW__PUBLICATION:
				setPublication(PUBLICATION_EDEFAULT);
				return;
			case RottenPackage.REVIEW__QUOTE:
				setQuote(QUOTE_EDEFAULT);
				return;
			case RottenPackage.REVIEW__LINKS:
				getLinks().clear();
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
			case RottenPackage.REVIEW__CRITIC:
				return CRITIC_EDEFAULT == null ? critic != null : !CRITIC_EDEFAULT.equals(critic);
			case RottenPackage.REVIEW__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case RottenPackage.REVIEW__PUBLICATION:
				return PUBLICATION_EDEFAULT == null ? publication != null : !PUBLICATION_EDEFAULT.equals(publication);
			case RottenPackage.REVIEW__QUOTE:
				return QUOTE_EDEFAULT == null ? quote != null : !QUOTE_EDEFAULT.equals(quote);
			case RottenPackage.REVIEW__LINKS:
				return links != null && !links.isEmpty();
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
		result.append(" (critic: ");
		result.append(critic);
		result.append(", date: ");
		result.append(date);
		result.append(", publication: ");
		result.append(publication);
		result.append(", quote: ");
		result.append(quote);
		result.append(')');
		return result.toString();
	}

} //ReviewImpl
