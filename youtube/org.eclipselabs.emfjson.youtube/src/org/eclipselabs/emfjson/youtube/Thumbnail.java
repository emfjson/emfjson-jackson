/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thumbnail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Thumbnail#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Thumbnail#getHqDefault <em>Hq Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getThumbnail()
 * @model
 * @generated
 */
public interface Thumbnail extends EObject {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getThumbnail_Default()
	 * @model
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Thumbnail#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Hq Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hq Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hq Default</em>' attribute.
	 * @see #setHqDefault(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getThumbnail_HqDefault()
	 * @model
	 * @generated
	 */
	String getHqDefault();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Thumbnail#getHqDefault <em>Hq Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hq Default</em>' attribute.
	 * @see #getHqDefault()
	 * @generated
	 */
	void setHqDefault(String value);

} // Thumbnail
