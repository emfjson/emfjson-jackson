/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.emfjson.youtube.VideoItem;
import org.eclipselabs.emfjson.youtube.VideoResult;
import org.eclipselabs.emfjson.youtube.YoutubePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl#getUpdated <em>Updated</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl#getTotalItems <em>Total Items</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl#getItemsPerPage <em>Items Per Page</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.youtube.impl.VideoResultImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VideoResultImpl extends EObjectImpl implements VideoResult {
	/**
	 * The default value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date updated = UPDATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalItems() <em>Total Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalItems()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TOTAL_ITEMS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTotalItems() <em>Total Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalItems()
	 * @generated
	 * @ordered
	 */
	protected Integer totalItems = TOTAL_ITEMS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartIndex() <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIndex()
	 * @generated
	 * @ordered
	 */
	protected static final Integer START_INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartIndex() <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIndex()
	 * @generated
	 * @ordered
	 */
	protected Integer startIndex = START_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getItemsPerPage() <em>Items Per Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemsPerPage()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ITEMS_PER_PAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getItemsPerPage() <em>Items Per Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemsPerPage()
	 * @generated
	 * @ordered
	 */
	protected Integer itemsPerPage = ITEMS_PER_PAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<VideoItem> items;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VideoResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YoutubePackage.Literals.VIDEO_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdated(Date newUpdated) {
		Date oldUpdated = updated;
		updated = newUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_RESULT__UPDATED, oldUpdated, updated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTotalItems() {
		return totalItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalItems(Integer newTotalItems) {
		Integer oldTotalItems = totalItems;
		totalItems = newTotalItems;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_RESULT__TOTAL_ITEMS, oldTotalItems, totalItems));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(Integer newStartIndex) {
		Integer oldStartIndex = startIndex;
		startIndex = newStartIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_RESULT__START_INDEX, oldStartIndex, startIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemsPerPage(Integer newItemsPerPage) {
		Integer oldItemsPerPage = itemsPerPage;
		itemsPerPage = newItemsPerPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YoutubePackage.VIDEO_RESULT__ITEMS_PER_PAGE, oldItemsPerPage, itemsPerPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VideoItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<VideoItem>(VideoItem.class, this, YoutubePackage.VIDEO_RESULT__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YoutubePackage.VIDEO_RESULT__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
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
			case YoutubePackage.VIDEO_RESULT__UPDATED:
				return getUpdated();
			case YoutubePackage.VIDEO_RESULT__TOTAL_ITEMS:
				return getTotalItems();
			case YoutubePackage.VIDEO_RESULT__START_INDEX:
				return getStartIndex();
			case YoutubePackage.VIDEO_RESULT__ITEMS_PER_PAGE:
				return getItemsPerPage();
			case YoutubePackage.VIDEO_RESULT__ITEMS:
				return getItems();
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
			case YoutubePackage.VIDEO_RESULT__UPDATED:
				setUpdated((Date)newValue);
				return;
			case YoutubePackage.VIDEO_RESULT__TOTAL_ITEMS:
				setTotalItems((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_RESULT__START_INDEX:
				setStartIndex((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_RESULT__ITEMS_PER_PAGE:
				setItemsPerPage((Integer)newValue);
				return;
			case YoutubePackage.VIDEO_RESULT__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends VideoItem>)newValue);
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
			case YoutubePackage.VIDEO_RESULT__UPDATED:
				setUpdated(UPDATED_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_RESULT__TOTAL_ITEMS:
				setTotalItems(TOTAL_ITEMS_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_RESULT__START_INDEX:
				setStartIndex(START_INDEX_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_RESULT__ITEMS_PER_PAGE:
				setItemsPerPage(ITEMS_PER_PAGE_EDEFAULT);
				return;
			case YoutubePackage.VIDEO_RESULT__ITEMS:
				getItems().clear();
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
			case YoutubePackage.VIDEO_RESULT__UPDATED:
				return UPDATED_EDEFAULT == null ? updated != null : !UPDATED_EDEFAULT.equals(updated);
			case YoutubePackage.VIDEO_RESULT__TOTAL_ITEMS:
				return TOTAL_ITEMS_EDEFAULT == null ? totalItems != null : !TOTAL_ITEMS_EDEFAULT.equals(totalItems);
			case YoutubePackage.VIDEO_RESULT__START_INDEX:
				return START_INDEX_EDEFAULT == null ? startIndex != null : !START_INDEX_EDEFAULT.equals(startIndex);
			case YoutubePackage.VIDEO_RESULT__ITEMS_PER_PAGE:
				return ITEMS_PER_PAGE_EDEFAULT == null ? itemsPerPage != null : !ITEMS_PER_PAGE_EDEFAULT.equals(itemsPerPage);
			case YoutubePackage.VIDEO_RESULT__ITEMS:
				return items != null && !items.isEmpty();
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
		result.append(" (updated: ");
		result.append(updated);
		result.append(", totalItems: ");
		result.append(totalItems);
		result.append(", startIndex: ");
		result.append(startIndex);
		result.append(", itemsPerPage: ");
		result.append(itemsPerPage);
		result.append(')');
		return result.toString();
	}

} //VideoResultImpl
