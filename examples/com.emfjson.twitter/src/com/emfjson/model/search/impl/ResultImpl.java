/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.model.search.impl;

import com.emfjson.model.search.Metadata;
import com.emfjson.model.search.Result;
import com.emfjson.model.search.SearchPackage;

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
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getText <em>Text</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getToUserId <em>To User Id</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getToUser <em>To User</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getFromUser <em>From User</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getMetadata <em>Metadata</em>}</li>
 *   <li>{@link com.emfjson.model.search.impl.ResultImpl#getSinceId <em>Since Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultImpl extends EObjectImpl implements Result {
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
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getToUserId() <em>To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToUserId() <em>To User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUserId()
	 * @generated
	 * @ordered
	 */
	protected String toUserId = TO_USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getToUser() <em>To User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUser()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToUser() <em>To User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToUser()
	 * @generated
	 * @ordered
	 */
	protected String toUser = TO_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromUser() <em>From User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromUser()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromUser() <em>From User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromUser()
	 * @generated
	 * @ordered
	 */
	protected String fromUser = FROM_USER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetadata() <em>Metadata</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadata()
	 * @generated
	 * @ordered
	 */
	protected EList<Metadata> metadata;

	/**
	 * The default value of the '{@link #getSinceId() <em>Since Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SINCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSinceId() <em>Since Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinceId()
	 * @generated
	 * @ordered
	 */
	protected String sinceId = SINCE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchPackage.Literals.RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToUserId() {
		return toUserId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToUserId(String newToUserId) {
		String oldToUserId = toUserId;
		toUserId = newToUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__TO_USER_ID, oldToUserId, toUserId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToUser() {
		return toUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToUser(String newToUser) {
		String oldToUser = toUser;
		toUser = newToUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__TO_USER, oldToUser, toUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFromUser() {
		return fromUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromUser(String newFromUser) {
		String oldFromUser = fromUser;
		fromUser = newFromUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__FROM_USER, oldFromUser, fromUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metadata> getMetadata() {
		if (metadata == null) {
			metadata = new EObjectContainmentEList<Metadata>(Metadata.class, this, SearchPackage.RESULT__METADATA);
		}
		return metadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSinceId() {
		return sinceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSinceId(String newSinceId) {
		String oldSinceId = sinceId;
		sinceId = newSinceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__SINCE_ID, oldSinceId, sinceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchPackage.RESULT__METADATA:
				return ((InternalEList<?>)getMetadata()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.RESULT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchPackage.RESULT__ID:
				return getId();
			case SearchPackage.RESULT__TEXT:
				return getText();
			case SearchPackage.RESULT__TO_USER_ID:
				return getToUserId();
			case SearchPackage.RESULT__TO_USER:
				return getToUser();
			case SearchPackage.RESULT__FROM_USER:
				return getFromUser();
			case SearchPackage.RESULT__METADATA:
				return getMetadata();
			case SearchPackage.RESULT__SINCE_ID:
				return getSinceId();
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
			case SearchPackage.RESULT__ID:
				setId((String)newValue);
				return;
			case SearchPackage.RESULT__TEXT:
				setText((String)newValue);
				return;
			case SearchPackage.RESULT__TO_USER_ID:
				setToUserId((String)newValue);
				return;
			case SearchPackage.RESULT__TO_USER:
				setToUser((String)newValue);
				return;
			case SearchPackage.RESULT__FROM_USER:
				setFromUser((String)newValue);
				return;
			case SearchPackage.RESULT__METADATA:
				getMetadata().clear();
				getMetadata().addAll((Collection<? extends Metadata>)newValue);
				return;
			case SearchPackage.RESULT__SINCE_ID:
				setSinceId((String)newValue);
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
			case SearchPackage.RESULT__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchPackage.RESULT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case SearchPackage.RESULT__TO_USER_ID:
				setToUserId(TO_USER_ID_EDEFAULT);
				return;
			case SearchPackage.RESULT__TO_USER:
				setToUser(TO_USER_EDEFAULT);
				return;
			case SearchPackage.RESULT__FROM_USER:
				setFromUser(FROM_USER_EDEFAULT);
				return;
			case SearchPackage.RESULT__METADATA:
				getMetadata().clear();
				return;
			case SearchPackage.RESULT__SINCE_ID:
				setSinceId(SINCE_ID_EDEFAULT);
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
			case SearchPackage.RESULT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchPackage.RESULT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case SearchPackage.RESULT__TO_USER_ID:
				return TO_USER_ID_EDEFAULT == null ? toUserId != null : !TO_USER_ID_EDEFAULT.equals(toUserId);
			case SearchPackage.RESULT__TO_USER:
				return TO_USER_EDEFAULT == null ? toUser != null : !TO_USER_EDEFAULT.equals(toUser);
			case SearchPackage.RESULT__FROM_USER:
				return FROM_USER_EDEFAULT == null ? fromUser != null : !FROM_USER_EDEFAULT.equals(fromUser);
			case SearchPackage.RESULT__METADATA:
				return metadata != null && !metadata.isEmpty();
			case SearchPackage.RESULT__SINCE_ID:
				return SINCE_ID_EDEFAULT == null ? sinceId != null : !SINCE_ID_EDEFAULT.equals(sinceId);
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
		result.append(", text: ");
		result.append(text);
		result.append(", toUserId: ");
		result.append(toUserId);
		result.append(", toUser: ");
		result.append(toUser);
		result.append(", fromUser: ");
		result.append(fromUser);
		result.append(", sinceId: ");
		result.append(sinceId);
		result.append(')');
		return result.toString();
	}

} //ResultImpl
