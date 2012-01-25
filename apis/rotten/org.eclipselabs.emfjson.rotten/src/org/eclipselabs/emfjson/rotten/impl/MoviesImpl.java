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

import org.eclipselabs.emfjson.rotten.Movie;
import org.eclipselabs.emfjson.rotten.Movies;
import org.eclipselabs.emfjson.rotten.RottenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Movies</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.MoviesImpl#getTotal <em>Total</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.impl.MoviesImpl#getMovies <em>Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MoviesImpl extends EObjectImpl implements Movies {
	/**
	 * The default value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TOTAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected Integer total = TOTAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMovies() <em>Movies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovies()
	 * @generated
	 * @ordered
	 */
	protected EList<Movie> movies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoviesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.MOVIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotal(Integer newTotal) {
		Integer oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIES__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Movie> getMovies() {
		if (movies == null) {
			movies = new EObjectContainmentEList<Movie>(Movie.class, this, RottenPackage.MOVIES__MOVIES);
		}
		return movies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RottenPackage.MOVIES__MOVIES:
				return ((InternalEList<?>)getMovies()).basicRemove(otherEnd, msgs);
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
			case RottenPackage.MOVIES__TOTAL:
				return getTotal();
			case RottenPackage.MOVIES__MOVIES:
				return getMovies();
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
			case RottenPackage.MOVIES__TOTAL:
				setTotal((Integer)newValue);
				return;
			case RottenPackage.MOVIES__MOVIES:
				getMovies().clear();
				getMovies().addAll((Collection<? extends Movie>)newValue);
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
			case RottenPackage.MOVIES__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case RottenPackage.MOVIES__MOVIES:
				getMovies().clear();
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
			case RottenPackage.MOVIES__TOTAL:
				return TOTAL_EDEFAULT == null ? total != null : !TOTAL_EDEFAULT.equals(total);
			case RottenPackage.MOVIES__MOVIES:
				return movies != null && !movies.isEmpty();
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
		result.append(" (total: ");
		result.append(total);
		result.append(')');
		return result.toString();
	}

} //MoviesImpl
