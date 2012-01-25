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
 * A representation of the model object '<em><b>Review Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.rotten.ReviewLink#getReviewLink <em>Review Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getReviewLink()
 * @model
 * @generated
 */
public interface ReviewLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Review Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Review Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Review Link</em>' attribute.
	 * @see #setReviewLink(String)
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#getReviewLink_ReviewLink()
	 * @model
	 * @generated
	 */
	String getReviewLink();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.rotten.ReviewLink#getReviewLink <em>Review Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Review Link</em>' attribute.
	 * @see #getReviewLink()
	 * @generated
	 */
	void setReviewLink(String value);

} // ReviewLink
