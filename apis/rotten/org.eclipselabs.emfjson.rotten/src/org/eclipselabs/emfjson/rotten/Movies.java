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
package org.eclipselabs.emfjson.rotten;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movies</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Movies#getTotal <em>Total</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Movies#getMovies <em>Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getMovies()
 * @model annotation="JSON root='true'"
 * @generated
 */
public interface Movies extends EObject {
	/**
	 * Returns the value of the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total</em>' attribute.
	 * @see #setTotal(Integer)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getMovies_Total()
	 * @model
	 * @generated
	 */
	Integer getTotal();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Movies#getTotal <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total</em>' attribute.
	 * @see #getTotal()
	 * @generated
	 */
	void setTotal(Integer value);

	/**
	 * Returns the value of the '<em><b>Movies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.emfjson.rotten.Movie}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movies</em>' containment reference list.
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getMovies_Movies()
	 * @model containment="true"
	 *        annotation="JSON element='movies'"
	 * @generated
	 */
	EList<Movie> getMovies();

} // Movies
