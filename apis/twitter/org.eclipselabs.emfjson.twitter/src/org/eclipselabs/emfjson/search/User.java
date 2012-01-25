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
package org.eclipselabs.emfjson.search;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getExpandedUrl <em>Expanded Url</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getCreatedAt <em>Created At</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getProfileSidebarFillColor <em>Profile Sidebar Fill Color</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getProfileSidebarBorderColor <em>Profile Sidebar Border Color</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getProfileBackgroundTile <em>Profile Background Tile</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.search.User#getProfileImageUrl <em>Profile Image Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
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
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Expanded Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expanded Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expanded Url</em>' attribute.
	 * @see #setExpandedUrl(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_ExpandedUrl()
	 * @model annotation="JSON element='expanded_url'"
	 * @generated
	 */
	String getExpandedUrl();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getExpandedUrl <em>Expanded Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expanded Url</em>' attribute.
	 * @see #getExpandedUrl()
	 * @generated
	 */
	void setExpandedUrl(String value);

	/**
	 * Returns the value of the '<em><b>Created At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created At</em>' attribute.
	 * @see #setCreatedAt(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_CreatedAt()
	 * @model annotation="JSON element='created_at'"
	 * @generated
	 */
	String getCreatedAt();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getCreatedAt <em>Created At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created At</em>' attribute.
	 * @see #getCreatedAt()
	 * @generated
	 */
	void setCreatedAt(String value);

	/**
	 * Returns the value of the '<em><b>Profile Sidebar Fill Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Sidebar Fill Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Sidebar Fill Color</em>' attribute.
	 * @see #setProfileSidebarFillColor(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_ProfileSidebarFillColor()
	 * @model annotation="JSON element='profile_sidebar_fill_color'"
	 * @generated
	 */
	String getProfileSidebarFillColor();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getProfileSidebarFillColor <em>Profile Sidebar Fill Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Sidebar Fill Color</em>' attribute.
	 * @see #getProfileSidebarFillColor()
	 * @generated
	 */
	void setProfileSidebarFillColor(String value);

	/**
	 * Returns the value of the '<em><b>Profile Sidebar Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Sidebar Border Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Sidebar Border Color</em>' attribute.
	 * @see #setProfileSidebarBorderColor(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_ProfileSidebarBorderColor()
	 * @model annotation="JSON element='profile_sidebar_border_color'"
	 * @generated
	 */
	String getProfileSidebarBorderColor();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getProfileSidebarBorderColor <em>Profile Sidebar Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Sidebar Border Color</em>' attribute.
	 * @see #getProfileSidebarBorderColor()
	 * @generated
	 */
	void setProfileSidebarBorderColor(String value);

	/**
	 * Returns the value of the '<em><b>Profile Background Tile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Background Tile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Background Tile</em>' attribute.
	 * @see #setProfileBackgroundTile(Boolean)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_ProfileBackgroundTile()
	 * @model annotation="JSON element='profile_background_tile'"
	 * @generated
	 */
	Boolean getProfileBackgroundTile();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getProfileBackgroundTile <em>Profile Background Tile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Background Tile</em>' attribute.
	 * @see #getProfileBackgroundTile()
	 * @generated
	 */
	void setProfileBackgroundTile(Boolean value);

	/**
	 * Returns the value of the '<em><b>Profile Image Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Image Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Image Url</em>' attribute.
	 * @see #setProfileImageUrl(String)
	 * @see org.eclipselabs.emfjson.search.SearchPackage#getUser_ProfileImageUrl()
	 * @model annotation="JSON element='profile_image_url'"
	 * @generated
	 */
	String getProfileImageUrl();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.search.User#getProfileImageUrl <em>Profile Image Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Image Url</em>' attribute.
	 * @see #getProfileImageUrl()
	 * @generated
	 */
	void setProfileImageUrl(String value);

} // User
