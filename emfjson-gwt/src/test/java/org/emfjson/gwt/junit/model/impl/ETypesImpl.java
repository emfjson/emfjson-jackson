/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.model.impl;

import com.google.gwt.user.client.rpc.GwtTransient;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.emfjson.gwt.junit.model.ETypes;
import org.emfjson.gwt.junit.model.ModelPackage;

import java.util.Collection;
import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ETypes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEString <em>EString</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEStrings <em>EStrings</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#isEBoolean <em>EBoolean</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEBooleans <em>EBooleans</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEInt <em>EInt</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEInts <em>EInts</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getDoubleValue <em>Double Value</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEDouble <em>EDouble</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEDoubles <em>EDoubles</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEByte <em>EByte</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEByteArray <em>EByte Array</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEChar <em>EChar</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEDate <em>EDate</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEFloat <em>EFloat</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getELong <em>ELong</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getEShort <em>EShort</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.impl.ETypesImpl#getUris <em>Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ETypesImpl extends EObjectImpl implements ETypes {
	/**
	 * The default value of the '{@link #getEString() <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEString()
	 */
	protected static final String ESTRING_EDEFAULT = null;
	/**
	 * The default value of the '{@link #isEBoolean() <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #isEBoolean()
	 */
	protected static final boolean EBOOLEAN_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getEInt() <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEInt()
	 */
	protected static final int EINT_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getDoubleValue()
	 */
	protected static final Double DOUBLE_VALUE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getEDouble() <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEDouble()
	 */
	protected static final double EDOUBLE_EDEFAULT = 0.0;
	/**
	 * The default value of the '{@link #getEByte() <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEByte()
	 */
	protected static final byte EBYTE_EDEFAULT = 0x00;
	/**
	 * The default value of the '{@link #getEByteArray() <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEByteArray()
	 */
	protected static final byte[] EBYTE_ARRAY_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getEChar() <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEChar()
	 */
	protected static final char ECHAR_EDEFAULT = '\u0000';
	/**
	 * The default value of the '{@link #getEDate() <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEDate()
	 */
	protected static final Date EDATE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getEFloat() <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEFloat()
	 */
	protected static final float EFLOAT_EDEFAULT = 0.0F;
	/**
	 * The default value of the '{@link #getELong() <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getELong()
	 */
	protected static final long ELONG_EDEFAULT = 0L;
	/**
	 * The default value of the '{@link #getEShort() <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEShort()
	 */
	protected static final short ESHORT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getEString() <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEString()
	 */
	@GwtTransient
	protected String eString = ESTRING_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEStrings() <em>EStrings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEStrings()
	 */
	@GwtTransient
	protected EList<String> eStrings;
	/**
	 * The cached value of the '{@link #isEBoolean() <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #isEBoolean()
	 */
	@GwtTransient
	protected boolean eBoolean = EBOOLEAN_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEBooleans() <em>EBooleans</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEBooleans()
	 */
	@GwtTransient
	protected EList<Boolean> eBooleans;
	/**
	 * The cached value of the '{@link #getEInt() <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEInt()
	 */
	@GwtTransient
	protected int eInt = EINT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEInts() <em>EInts</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEInts()
	 */
	@GwtTransient
	protected EList<Integer> eInts;
	/**
	 * The cached value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getDoubleValue()
	 */
	@GwtTransient
	protected Double doubleValue = DOUBLE_VALUE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEDouble() <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEDouble()
	 */
	@GwtTransient
	protected double eDouble = EDOUBLE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEDoubles() <em>EDoubles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEDoubles()
	 */
	@GwtTransient
	protected EList<Double> eDoubles;
	/**
	 * The cached value of the '{@link #getEByte() <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEByte()
	 */
	@GwtTransient
	protected byte eByte = EBYTE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEByteArray() <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEByteArray()
	 */
	@GwtTransient
	protected byte[] eByteArray = EBYTE_ARRAY_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEChar() <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEChar()
	 */
	@GwtTransient
	protected char eChar = ECHAR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEDate() <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEDate()
	 */
	@GwtTransient
	protected Date eDate = EDATE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEFloat() <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEFloat()
	 */
	@GwtTransient
	protected float eFloat = EFLOAT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getELong() <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getELong()
	 */
	@GwtTransient
	protected long eLong = ELONG_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEShort() <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getEShort()
	 */
	@GwtTransient
	protected short eShort = ESHORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUris() <em>Uris</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getUris()
	 */
	@GwtTransient
	protected EList<URI> uris;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ETypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ETYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getEString() {
		return eString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEString(String newEString) {
		String oldEString = eString;
		eString = newEString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ESTRING, oldEString, eString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<String> getEStrings() {
		if (eStrings == null) {
			eStrings = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.ETYPES__ESTRINGS);
		}
		return eStrings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isEBoolean() {
		return eBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEBoolean(boolean newEBoolean) {
		boolean oldEBoolean = eBoolean;
		eBoolean = newEBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBOOLEAN, oldEBoolean, eBoolean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<Boolean> getEBooleans() {
		if (eBooleans == null) {
			eBooleans = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, ModelPackage.ETYPES__EBOOLEANS);
		}
		return eBooleans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public int getEInt() {
		return eInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEInt(int newEInt) {
		int oldEInt = eInt;
		eInt = newEInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EINT, oldEInt, eInt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<Integer> getEInts() {
		if (eInts == null) {
			eInts = new EDataTypeUniqueEList<Integer>(Integer.class, this, ModelPackage.ETYPES__EINTS);
		}
		return eInts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setDoubleValue(Double newDoubleValue) {
		Double oldDoubleValue = doubleValue;
		doubleValue = newDoubleValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__DOUBLE_VALUE, oldDoubleValue, doubleValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public double getEDouble() {
		return eDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEDouble(double newEDouble) {
		double oldEDouble = eDouble;
		eDouble = newEDouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EDOUBLE, oldEDouble, eDouble));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<Double> getEDoubles() {
		if (eDoubles == null) {
			eDoubles = new EDataTypeUniqueEList<Double>(Double.class, this, ModelPackage.ETYPES__EDOUBLES);
		}
		return eDoubles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public byte getEByte() {
		return eByte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEByte(byte newEByte) {
		byte oldEByte = eByte;
		eByte = newEByte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBYTE, oldEByte, eByte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public byte[] getEByteArray() {
		return eByteArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEByteArray(byte[] newEByteArray) {
		byte[] oldEByteArray = eByteArray;
		eByteArray = newEByteArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBYTE_ARRAY, oldEByteArray, eByteArray));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public char getEChar() {
		return eChar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEChar(char newEChar) {
		char oldEChar = eChar;
		eChar = newEChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ECHAR, oldEChar, eChar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Date getEDate() {
		return eDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEDate(Date newEDate) {
		Date oldEDate = eDate;
		eDate = newEDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EDATE, oldEDate, eDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public float getEFloat() {
		return eFloat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEFloat(float newEFloat) {
		float oldEFloat = eFloat;
		eFloat = newEFloat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EFLOAT, oldEFloat, eFloat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public long getELong() {
		return eLong;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setELong(long newELong) {
		long oldELong = eLong;
		eLong = newELong;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ELONG, oldELong, eLong));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public short getEShort() {
		return eShort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEShort(short newEShort) {
		short oldEShort = eShort;
		eShort = newEShort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ESHORT, oldEShort, eShort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<URI> getUris() {
		if (uris == null) {
			uris = new EDataTypeUniqueEList<URI>(URI.class, this, ModelPackage.ETYPES__URIS);
		}
		return uris;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ETYPES__ESTRING:
				return getEString();
			case ModelPackage.ETYPES__ESTRINGS:
				return getEStrings();
			case ModelPackage.ETYPES__EBOOLEAN:
				return isEBoolean();
			case ModelPackage.ETYPES__EBOOLEANS:
				return getEBooleans();
			case ModelPackage.ETYPES__EINT:
				return getEInt();
			case ModelPackage.ETYPES__EINTS:
				return getEInts();
			case ModelPackage.ETYPES__DOUBLE_VALUE:
				return getDoubleValue();
			case ModelPackage.ETYPES__EDOUBLE:
				return getEDouble();
			case ModelPackage.ETYPES__EDOUBLES:
				return getEDoubles();
			case ModelPackage.ETYPES__EBYTE:
				return getEByte();
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				return getEByteArray();
			case ModelPackage.ETYPES__ECHAR:
				return getEChar();
			case ModelPackage.ETYPES__EDATE:
				return getEDate();
			case ModelPackage.ETYPES__EFLOAT:
				return getEFloat();
			case ModelPackage.ETYPES__ELONG:
				return getELong();
			case ModelPackage.ETYPES__ESHORT:
				return getEShort();
			case ModelPackage.ETYPES__URIS:
				return getUris();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ETYPES__ESTRING:
				setEString((String) newValue);
				return;
			case ModelPackage.ETYPES__ESTRINGS:
				getEStrings().clear();
				getEStrings().addAll((Collection<? extends String>) newValue);
				return;
			case ModelPackage.ETYPES__EBOOLEAN:
				setEBoolean((Boolean) newValue);
				return;
			case ModelPackage.ETYPES__EBOOLEANS:
				getEBooleans().clear();
				getEBooleans().addAll((Collection<? extends Boolean>) newValue);
				return;
			case ModelPackage.ETYPES__EINT:
				setEInt((Integer) newValue);
				return;
			case ModelPackage.ETYPES__EINTS:
				getEInts().clear();
				getEInts().addAll((Collection<? extends Integer>) newValue);
				return;
			case ModelPackage.ETYPES__DOUBLE_VALUE:
				setDoubleValue((Double) newValue);
				return;
			case ModelPackage.ETYPES__EDOUBLE:
				setEDouble((Double) newValue);
				return;
			case ModelPackage.ETYPES__EDOUBLES:
				getEDoubles().clear();
				getEDoubles().addAll((Collection<? extends Double>) newValue);
				return;
			case ModelPackage.ETYPES__EBYTE:
				setEByte((Byte) newValue);
				return;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				setEByteArray((byte[]) newValue);
				return;
			case ModelPackage.ETYPES__ECHAR:
				setEChar((Character) newValue);
				return;
			case ModelPackage.ETYPES__EDATE:
				setEDate((Date) newValue);
				return;
			case ModelPackage.ETYPES__EFLOAT:
				setEFloat((Float) newValue);
				return;
			case ModelPackage.ETYPES__ELONG:
				setELong((Long) newValue);
				return;
			case ModelPackage.ETYPES__ESHORT:
				setEShort((Short) newValue);
				return;
			case ModelPackage.ETYPES__URIS:
				getUris().clear();
				getUris().addAll((Collection<? extends URI>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.ETYPES__ESTRING:
				setEString(ESTRING_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ESTRINGS:
				getEStrings().clear();
				return;
			case ModelPackage.ETYPES__EBOOLEAN:
				setEBoolean(EBOOLEAN_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBOOLEANS:
				getEBooleans().clear();
				return;
			case ModelPackage.ETYPES__EINT:
				setEInt(EINT_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EINTS:
				getEInts().clear();
				return;
			case ModelPackage.ETYPES__DOUBLE_VALUE:
				setDoubleValue(DOUBLE_VALUE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EDOUBLE:
				setEDouble(EDOUBLE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EDOUBLES:
				getEDoubles().clear();
				return;
			case ModelPackage.ETYPES__EBYTE:
				setEByte(EBYTE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				setEByteArray(EBYTE_ARRAY_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ECHAR:
				setEChar(ECHAR_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EDATE:
				setEDate(EDATE_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EFLOAT:
				setEFloat(EFLOAT_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ELONG:
				setELong(ELONG_EDEFAULT);
				return;
			case ModelPackage.ETYPES__ESHORT:
				setEShort(ESHORT_EDEFAULT);
				return;
			case ModelPackage.ETYPES__URIS:
				getUris().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.ETYPES__ESTRING:
				return ESTRING_EDEFAULT == null ? eString != null : !ESTRING_EDEFAULT.equals(eString);
			case ModelPackage.ETYPES__ESTRINGS:
				return eStrings != null && !eStrings.isEmpty();
			case ModelPackage.ETYPES__EBOOLEAN:
				return eBoolean != EBOOLEAN_EDEFAULT;
			case ModelPackage.ETYPES__EBOOLEANS:
				return eBooleans != null && !eBooleans.isEmpty();
			case ModelPackage.ETYPES__EINT:
				return eInt != EINT_EDEFAULT;
			case ModelPackage.ETYPES__EINTS:
				return eInts != null && !eInts.isEmpty();
			case ModelPackage.ETYPES__DOUBLE_VALUE:
				return DOUBLE_VALUE_EDEFAULT == null ? doubleValue != null : !DOUBLE_VALUE_EDEFAULT.equals(doubleValue);
			case ModelPackage.ETYPES__EDOUBLE:
				return eDouble != EDOUBLE_EDEFAULT;
			case ModelPackage.ETYPES__EDOUBLES:
				return eDoubles != null && !eDoubles.isEmpty();
			case ModelPackage.ETYPES__EBYTE:
				return eByte != EBYTE_EDEFAULT;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				return EBYTE_ARRAY_EDEFAULT == null ? eByteArray != null : !EBYTE_ARRAY_EDEFAULT.equals(eByteArray);
			case ModelPackage.ETYPES__ECHAR:
				return eChar != ECHAR_EDEFAULT;
			case ModelPackage.ETYPES__EDATE:
				return EDATE_EDEFAULT == null ? eDate != null : !EDATE_EDEFAULT.equals(eDate);
			case ModelPackage.ETYPES__EFLOAT:
				return eFloat != EFLOAT_EDEFAULT;
			case ModelPackage.ETYPES__ELONG:
				return eLong != ELONG_EDEFAULT;
			case ModelPackage.ETYPES__ESHORT:
				return eShort != ESHORT_EDEFAULT;
			case ModelPackage.ETYPES__URIS:
				return uris != null && !uris.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (eString: ");
		result.append(eString);
		result.append(", eStrings: ");
		result.append(eStrings);
		result.append(", eBoolean: ");
		result.append(eBoolean);
		result.append(", eBooleans: ");
		result.append(eBooleans);
		result.append(", eInt: ");
		result.append(eInt);
		result.append(", eInts: ");
		result.append(eInts);
		result.append(", doubleValue: ");
		result.append(doubleValue);
		result.append(", eDouble: ");
		result.append(eDouble);
		result.append(", eDoubles: ");
		result.append(eDoubles);
		result.append(", eByte: ");
		result.append(eByte);
		result.append(", eByteArray: ");
		result.append(eByteArray);
		result.append(", eChar: ");
		result.append(eChar);
		result.append(", eDate: ");
		result.append(eDate);
		result.append(", eFloat: ");
		result.append(eFloat);
		result.append(", eLong: ");
		result.append(eLong);
		result.append(", eShort: ");
		result.append(eShort);
		result.append(", uris: ");
		result.append(uris);
		result.append(')');
		return result.toString();
	}

} //ETypesImpl
