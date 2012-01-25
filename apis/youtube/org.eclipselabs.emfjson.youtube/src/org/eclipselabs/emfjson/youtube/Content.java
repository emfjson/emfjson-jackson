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
 * A representation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Content#getRtsp <em>Rtsp</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Content#getHttp <em>Http</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.Content#getRtspMpeg <em>Rtsp Mpeg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getContent()
 * @model
 * @generated
 */
public interface Content extends EObject {
	/**
	 * Returns the value of the '<em><b>Rtsp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtsp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtsp</em>' attribute.
	 * @see #setRtsp(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getContent_Rtsp()
	 * @model annotation="JSON element='1'"
	 * @generated
	 */
	String getRtsp();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Content#getRtsp <em>Rtsp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rtsp</em>' attribute.
	 * @see #getRtsp()
	 * @generated
	 */
	void setRtsp(String value);

	/**
	 * Returns the value of the '<em><b>Http</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http</em>' attribute.
	 * @see #setHttp(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getContent_Http()
	 * @model annotation="JSON element='5'"
	 * @generated
	 */
	String getHttp();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Content#getHttp <em>Http</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http</em>' attribute.
	 * @see #getHttp()
	 * @generated
	 */
	void setHttp(String value);

	/**
	 * Returns the value of the '<em><b>Rtsp Mpeg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtsp Mpeg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtsp Mpeg</em>' attribute.
	 * @see #setRtspMpeg(String)
	 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getContent_RtspMpeg()
	 * @model annotation="JSON element='6'"
	 * @generated
	 */
	String getRtspMpeg();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.youtube.Content#getRtspMpeg <em>Rtsp Mpeg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rtsp Mpeg</em>' attribute.
	 * @see #getRtspMpeg()
	 * @generated
	 */
	void setRtspMpeg(String value);

} // Content
