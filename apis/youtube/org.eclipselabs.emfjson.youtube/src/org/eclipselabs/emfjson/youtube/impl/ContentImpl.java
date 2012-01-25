/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipselabs.emfjson.youtube.Content;
import org.eclipselabs.emfjson.youtube.YoutubePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.ContentImpl#getRtsp <em>Rtsp</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.ContentImpl#getHttp <em>Http</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.ContentImpl#getRtspMpeg <em>Rtsp Mpeg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContentImpl extends EObjectImpl implements Content {
	/**
	 * The default value of the '{@link #getRtsp() <em>Rtsp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtsp()
	 * @generated
	 * @ordered
	 */
	protected static final String RTSP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRtsp() <em>Rtsp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtsp()
	 * @generated
	 * @ordered
	 */
	protected String rtsp = RTSP_EDEFAULT;

	/**
	 * The default value of the '{@link #getHttp() <em>Http</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttp()
	 * @generated
	 * @ordered
	 */
	protected static final String HTTP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHttp() <em>Http</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttp()
	 * @generated
	 * @ordered
	 */
	protected String http = HTTP_EDEFAULT;

	/**
	 * The default value of the '{@link #getRtspMpeg() <em>Rtsp Mpeg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtspMpeg()
	 * @generated
	 * @ordered
	 */
	protected static final String RTSP_MPEG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRtspMpeg() <em>Rtsp Mpeg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtspMpeg()
	 * @generated
	 * @ordered
	 */
	protected String rtspMpeg = RTSP_MPEG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YoutubePackage.Literals.CONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRtsp() {
		return rtsp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRtsp(String newRtsp) {
		String oldRtsp = rtsp;
		rtsp = newRtsp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.CONTENT__RTSP, oldRtsp, rtsp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHttp() {
		return http;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHttp(String newHttp) {
		String oldHttp = http;
		http = newHttp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.CONTENT__HTTP, oldHttp, http));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRtspMpeg() {
		return rtspMpeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRtspMpeg(String newRtspMpeg) {
		String oldRtspMpeg = rtspMpeg;
		rtspMpeg = newRtspMpeg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.CONTENT__RTSP_MPEG, oldRtspMpeg, rtspMpeg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YoutubePackage.CONTENT__RTSP:
				return getRtsp();
			case YoutubePackage.CONTENT__HTTP:
				return getHttp();
			case YoutubePackage.CONTENT__RTSP_MPEG:
				return getRtspMpeg();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YoutubePackage.CONTENT__RTSP:
				setRtsp((String)newValue);
				return;
			case YoutubePackage.CONTENT__HTTP:
				setHttp((String)newValue);
				return;
			case YoutubePackage.CONTENT__RTSP_MPEG:
				setRtspMpeg((String)newValue);
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
			case YoutubePackage.CONTENT__RTSP:
				setRtsp(RTSP_EDEFAULT);
				return;
			case YoutubePackage.CONTENT__HTTP:
				setHttp(HTTP_EDEFAULT);
				return;
			case YoutubePackage.CONTENT__RTSP_MPEG:
				setRtspMpeg(RTSP_MPEG_EDEFAULT);
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
			case YoutubePackage.CONTENT__RTSP:
				return RTSP_EDEFAULT == null ? rtsp != null : !RTSP_EDEFAULT.equals(rtsp);
			case YoutubePackage.CONTENT__HTTP:
				return HTTP_EDEFAULT == null ? http != null : !HTTP_EDEFAULT.equals(http);
			case YoutubePackage.CONTENT__RTSP_MPEG:
				return RTSP_MPEG_EDEFAULT == null ? rtspMpeg != null : !RTSP_MPEG_EDEFAULT.equals(rtspMpeg);
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
		result.append(" (rtsp: ");
		result.append(rtsp);
		result.append(", http: ");
		result.append(http);
		result.append(", rtspMpeg: ");
		result.append(rtspMpeg);
		result.append(')');
		return result.toString();
	}

} //ContentImpl
