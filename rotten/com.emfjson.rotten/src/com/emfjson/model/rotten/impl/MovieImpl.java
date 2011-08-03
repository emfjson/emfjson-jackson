/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package com.emfjson.model.rotten.impl;

import com.emfjson.model.rotten.Cast;
import com.emfjson.model.rotten.Movie;
import com.emfjson.model.rotten.Poster;
import com.emfjson.model.rotten.Rating;
import com.emfjson.model.rotten.Release;
import com.emfjson.model.rotten.RottenPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getYear <em>Year</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getRuntime <em>Runtime</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getSynopsis <em>Synopsis</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getReleases <em>Releases</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getRatings <em>Ratings</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getPosters <em>Posters</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.impl.MovieImpl#getCastings <em>Castings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovieImpl extends EObjectImpl implements Movie {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final Integer YEAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected Integer year = YEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuntime() <em>Runtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntime()
	 * @generated
	 * @ordered
	 */
	protected static final Integer RUNTIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuntime() <em>Runtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntime()
	 * @generated
	 * @ordered
	 */
	protected Integer runtime = RUNTIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSynopsis() <em>Synopsis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynopsis()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNOPSIS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSynopsis() <em>Synopsis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynopsis()
	 * @generated
	 * @ordered
	 */
	protected String synopsis = SYNOPSIS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReleases() <em>Releases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleases()
	 * @generated
	 * @ordered
	 */
	protected EList<Release> releases;

	/**
	 * The cached value of the '{@link #getRatings() <em>Ratings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatings()
	 * @generated
	 * @ordered
	 */
	protected EList<Rating> ratings;

	/**
	 * The cached value of the '{@link #getPosters() <em>Posters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosters()
	 * @generated
	 * @ordered
	 */
	protected Poster posters;

	/**
	 * The cached value of the '{@link #getCastings() <em>Castings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCastings()
	 * @generated
	 * @ordered
	 */
	protected EList<Cast> castings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovieImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RottenPackage.Literals.MOVIE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYear(Integer newYear) {
		Integer oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getRuntime() {
		return runtime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntime(Integer newRuntime) {
		Integer oldRuntime = runtime;
		runtime = newRuntime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__RUNTIME, oldRuntime, runtime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynopsis(String newSynopsis) {
		String oldSynopsis = synopsis;
		synopsis = newSynopsis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__SYNOPSIS, oldSynopsis, synopsis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Release> getReleases() {
		if (releases == null) {
			releases = new EObjectContainmentEList<Release>(Release.class, this, RottenPackage.MOVIE__RELEASES);
		}
		return releases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rating> getRatings() {
		if (ratings == null) {
			ratings = new EObjectContainmentEList<Rating>(Rating.class, this, RottenPackage.MOVIE__RATINGS);
		}
		return ratings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Poster getPosters() {
		return posters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPosters(Poster newPosters, NotificationChain msgs) {
		Poster oldPosters = posters;
		posters = newPosters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__POSTERS, oldPosters, newPosters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosters(Poster newPosters) {
		if (newPosters != posters) {
			NotificationChain msgs = null;
			if (posters != null)
				msgs = ((InternalEObject)posters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RottenPackage.MOVIE__POSTERS, null, msgs);
			if (newPosters != null)
				msgs = ((InternalEObject)newPosters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RottenPackage.MOVIE__POSTERS, null, msgs);
			msgs = basicSetPosters(newPosters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RottenPackage.MOVIE__POSTERS, newPosters, newPosters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cast> getCastings() {
		if (castings == null) {
			castings = new EObjectContainmentEList<Cast>(Cast.class, this, RottenPackage.MOVIE__CASTINGS);
		}
		return castings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RottenPackage.MOVIE__RELEASES:
				return ((InternalEList<?>)getReleases()).basicRemove(otherEnd, msgs);
			case RottenPackage.MOVIE__RATINGS:
				return ((InternalEList<?>)getRatings()).basicRemove(otherEnd, msgs);
			case RottenPackage.MOVIE__POSTERS:
				return basicSetPosters(null, msgs);
			case RottenPackage.MOVIE__CASTINGS:
				return ((InternalEList<?>)getCastings()).basicRemove(otherEnd, msgs);
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
			case RottenPackage.MOVIE__ID:
				return getId();
			case RottenPackage.MOVIE__TITLE:
				return getTitle();
			case RottenPackage.MOVIE__YEAR:
				return getYear();
			case RottenPackage.MOVIE__RUNTIME:
				return getRuntime();
			case RottenPackage.MOVIE__SYNOPSIS:
				return getSynopsis();
			case RottenPackage.MOVIE__RELEASES:
				return getReleases();
			case RottenPackage.MOVIE__RATINGS:
				return getRatings();
			case RottenPackage.MOVIE__POSTERS:
				return getPosters();
			case RottenPackage.MOVIE__CASTINGS:
				return getCastings();
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
			case RottenPackage.MOVIE__ID:
				setId((String)newValue);
				return;
			case RottenPackage.MOVIE__TITLE:
				setTitle((String)newValue);
				return;
			case RottenPackage.MOVIE__YEAR:
				setYear((Integer)newValue);
				return;
			case RottenPackage.MOVIE__RUNTIME:
				setRuntime((Integer)newValue);
				return;
			case RottenPackage.MOVIE__SYNOPSIS:
				setSynopsis((String)newValue);
				return;
			case RottenPackage.MOVIE__RELEASES:
				getReleases().clear();
				getReleases().addAll((Collection<? extends Release>)newValue);
				return;
			case RottenPackage.MOVIE__RATINGS:
				getRatings().clear();
				getRatings().addAll((Collection<? extends Rating>)newValue);
				return;
			case RottenPackage.MOVIE__POSTERS:
				setPosters((Poster)newValue);
				return;
			case RottenPackage.MOVIE__CASTINGS:
				getCastings().clear();
				getCastings().addAll((Collection<? extends Cast>)newValue);
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
			case RottenPackage.MOVIE__ID:
				setId(ID_EDEFAULT);
				return;
			case RottenPackage.MOVIE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case RottenPackage.MOVIE__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case RottenPackage.MOVIE__RUNTIME:
				setRuntime(RUNTIME_EDEFAULT);
				return;
			case RottenPackage.MOVIE__SYNOPSIS:
				setSynopsis(SYNOPSIS_EDEFAULT);
				return;
			case RottenPackage.MOVIE__RELEASES:
				getReleases().clear();
				return;
			case RottenPackage.MOVIE__RATINGS:
				getRatings().clear();
				return;
			case RottenPackage.MOVIE__POSTERS:
				setPosters((Poster)null);
				return;
			case RottenPackage.MOVIE__CASTINGS:
				getCastings().clear();
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
			case RottenPackage.MOVIE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case RottenPackage.MOVIE__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case RottenPackage.MOVIE__YEAR:
				return YEAR_EDEFAULT == null ? year != null : !YEAR_EDEFAULT.equals(year);
			case RottenPackage.MOVIE__RUNTIME:
				return RUNTIME_EDEFAULT == null ? runtime != null : !RUNTIME_EDEFAULT.equals(runtime);
			case RottenPackage.MOVIE__SYNOPSIS:
				return SYNOPSIS_EDEFAULT == null ? synopsis != null : !SYNOPSIS_EDEFAULT.equals(synopsis);
			case RottenPackage.MOVIE__RELEASES:
				return releases != null && !releases.isEmpty();
			case RottenPackage.MOVIE__RATINGS:
				return ratings != null && !ratings.isEmpty();
			case RottenPackage.MOVIE__POSTERS:
				return posters != null;
			case RottenPackage.MOVIE__CASTINGS:
				return castings != null && !castings.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", title: ");
		result.append(title);
		result.append(", year: ");
		result.append(year);
		result.append(", runtime: ");
		result.append(runtime);
		result.append(", synopsis: ");
		result.append(synopsis);
		result.append(')');
		return result.toString();
	}

} //MovieImpl
