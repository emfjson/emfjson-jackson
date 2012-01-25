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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rating</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Rating#getCriticsScore <em>Critics Score</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.rotten.Rating#getAudienceScore <em>Audience Score</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getRating()
 * @model
 * @generated
 */
public interface Rating extends EObject {
	/**
	 * Returns the value of the '<em><b>Critics Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Critics Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Critics Score</em>' attribute.
	 * @see #setCriticsScore(Integer)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getRating_CriticsScore()
	 * @model annotation="JSON element='critics_score'"
	 * @generated
	 */
	Integer getCriticsScore();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Rating#getCriticsScore <em>Critics Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Critics Score</em>' attribute.
	 * @see #getCriticsScore()
	 * @generated
	 */
	void setCriticsScore(Integer value);

	/**
	 * Returns the value of the '<em><b>Audience Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audience Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Audience Score</em>' attribute.
	 * @see #setAudienceScore(Integer)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getRating_AudienceScore()
	 * @model annotation="JSON element='audience_score'"
	 * @generated
	 */
	Integer getAudienceScore();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.Rating#getAudienceScore <em>Audience Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Audience Score</em>' attribute.
	 * @see #getAudienceScore()
	 * @generated
	 */
	void setAudienceScore(Integer value);

} // Rating
