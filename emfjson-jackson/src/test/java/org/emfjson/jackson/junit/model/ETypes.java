/**
 */
package org.emfjson.jackson.junit.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETypes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEString <em>EString</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEStrings <em>EStrings</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#isEBoolean <em>EBoolean</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEBooleans <em>EBooleans</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEInt <em>EInt</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEInts <em>EInts</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getDoubleValue <em>Double Value</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEDouble <em>EDouble</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEDoubles <em>EDoubles</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEBigDecimal <em>EBig Decimal</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEBigInteger <em>EBig Integer</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEByte <em>EByte</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEByteArray <em>EByte Array</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEChar <em>EChar</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEDate <em>EDate</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEFloat <em>EFloat</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getELong <em>ELong</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getEShort <em>EShort</em>}</li>
 *   <li>{@link org.emfjson.jackson.junit.model.ETypes#getUris <em>Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ETypes extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getEString() <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEString()
	 * @generated
	 * @ordered
	 */
	protected static final String ESTRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEString() <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEString()
	 * @generated
	 * @ordered
	 */
	protected String eString = ESTRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEStrings() <em>EStrings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEStrings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> eStrings;

	/**
	 * The default value of the '{@link #isEBoolean() <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EBOOLEAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEBoolean() <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEBoolean()
	 * @generated
	 * @ordered
	 */
	protected boolean eBoolean = EBOOLEAN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEBooleans() <em>EBooleans</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBooleans()
	 * @generated
	 * @ordered
	 */
	protected EList<Boolean> eBooleans;

	/**
	 * The default value of the '{@link #getEInt() <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEInt()
	 * @generated
	 * @ordered
	 */
	protected static final int EINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEInt() <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEInt()
	 * @generated
	 * @ordered
	 */
	protected int eInt = EINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEInts() <em>EInts</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEInts()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> eInts;

	/**
	 * The default value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected static final Double DOUBLE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected Double doubleValue = DOUBLE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEDouble() <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDouble()
	 * @generated
	 * @ordered
	 */
	protected static final double EDOUBLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEDouble() <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDouble()
	 * @generated
	 * @ordered
	 */
	protected double eDouble = EDOUBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEDoubles() <em>EDoubles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDoubles()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> eDoubles;

	/**
	 * The default value of the '{@link #getEBigDecimal() <em>EBig Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal EBIG_DECIMAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEBigDecimal() <em>EBig Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal eBigDecimal = EBIG_DECIMAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEBigInteger() <em>EBig Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigInteger()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger EBIG_INTEGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEBigInteger() <em>EBig Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEBigInteger()
	 * @generated
	 * @ordered
	 */
	protected BigInteger eBigInteger = EBIG_INTEGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEByte() <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByte()
	 * @generated
	 * @ordered
	 */
	protected static final byte EBYTE_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getEByte() <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByte()
	 * @generated
	 * @ordered
	 */
	protected byte eByte = EBYTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEByteArray() <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByteArray()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] EBYTE_ARRAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEByteArray() <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEByteArray()
	 * @generated
	 * @ordered
	 */
	protected byte[] eByteArray = EBYTE_ARRAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getEChar() <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEChar()
	 * @generated
	 * @ordered
	 */
	protected static final char ECHAR_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getEChar() <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEChar()
	 * @generated
	 * @ordered
	 */
	protected char eChar = ECHAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getEDate() <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date EDATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEDate() <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDate()
	 * @generated
	 * @ordered
	 */
	protected Date eDate = EDATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEFloat() <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFloat()
	 * @generated
	 * @ordered
	 */
	protected static final float EFLOAT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getEFloat() <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFloat()
	 * @generated
	 * @ordered
	 */
	protected float eFloat = EFLOAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getELong() <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getELong()
	 * @generated
	 * @ordered
	 */
	protected static final long ELONG_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getELong() <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getELong()
	 * @generated
	 * @ordered
	 */
	protected long eLong = ELONG_EDEFAULT;

	/**
	 * The default value of the '{@link #getEShort() <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEShort()
	 * @generated
	 * @ordered
	 */
	protected static final short ESHORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEShort() <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEShort()
	 * @generated
	 * @ordered
	 */
	protected short eShort = ESHORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUris() <em>Uris</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUris()
	 * @generated
	 * @ordered
	 */
	protected EList<URI> uris;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETypes() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ETYPES;
	}

	/**
	 * Returns the value of the '<em><b>EString</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EString</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EString</em>' attribute.
	 * @see #setEString(String)
	 * @generated
	 */
	public String getEString() {
		return eString;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEString <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EString</em>' attribute.
	 * @see #getEString()
	 * @generated
	 */
	public void setEString(String newEString) {
		String oldEString = eString;
		eString = newEString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ESTRING, oldEString, eString));
	}

	/**
	 * Returns the value of the '<em><b>EStrings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EStrings</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EStrings</em>' attribute list.
	 * @generated
	 */
	public List<String> getEStrings() {
		if (eStrings == null) {
			eStrings = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.ETYPES__ESTRINGS);
		}
		return eStrings;
	}

	/**
	 * Returns the value of the '<em><b>EBoolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBoolean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EBoolean</em>' attribute.
	 * @see #setEBoolean(boolean)
	 * @generated
	 */
	public boolean isEBoolean() {
		return eBoolean;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#isEBoolean <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EBoolean</em>' attribute.
	 * @see #isEBoolean()
	 * @generated
	 */
	public void setEBoolean(boolean newEBoolean) {
		boolean oldEBoolean = eBoolean;
		eBoolean = newEBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBOOLEAN, oldEBoolean, eBoolean));
	}

	/**
	 * Returns the value of the '<em><b>EBooleans</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBooleans</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EBooleans</em>' attribute list.
	 * @generated
	 */
	public List<Boolean> getEBooleans() {
		if (eBooleans == null) {
			eBooleans = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, ModelPackage.ETYPES__EBOOLEANS);
		}
		return eBooleans;
	}

	/**
	 * Returns the value of the '<em><b>EInt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EInt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EInt</em>' attribute.
	 * @see #setEInt(int)
	 * @generated
	 */
	public int getEInt() {
		return eInt;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEInt <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EInt</em>' attribute.
	 * @see #getEInt()
	 * @generated
	 */
	public void setEInt(int newEInt) {
		int oldEInt = eInt;
		eInt = newEInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EINT, oldEInt, eInt));
	}

	/**
	 * Returns the value of the '<em><b>EInts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EInts</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EInts</em>' attribute list.
	 * @generated
	 */
	public List<Integer> getEInts() {
		if (eInts == null) {
			eInts = new EDataTypeUniqueEList<Integer>(Integer.class, this, ModelPackage.ETYPES__EINTS);
		}
		return eInts;
	}

	/**
	 * Returns the value of the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Value</em>' attribute.
	 * @see #setDoubleValue(Double)
	 * @generated
	 */
	public Double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getDoubleValue <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Value</em>' attribute.
	 * @see #getDoubleValue()
	 * @generated
	 */
	public void setDoubleValue(Double newDoubleValue) {
		Double oldDoubleValue = doubleValue;
		doubleValue = newDoubleValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__DOUBLE_VALUE, oldDoubleValue, doubleValue));
	}

	/**
	 * Returns the value of the '<em><b>EDouble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDouble</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EDouble</em>' attribute.
	 * @see #setEDouble(double)
	 * @generated
	 */
	public double getEDouble() {
		return eDouble;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEDouble <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EDouble</em>' attribute.
	 * @see #getEDouble()
	 * @generated
	 */
	public void setEDouble(double newEDouble) {
		double oldEDouble = eDouble;
		eDouble = newEDouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EDOUBLE, oldEDouble, eDouble));
	}

	/**
	 * Returns the value of the '<em><b>EDoubles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDoubles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EDoubles</em>' attribute list.
	 * @generated
	 */
	public List<Double> getEDoubles() {
		if (eDoubles == null) {
			eDoubles = new EDataTypeUniqueEList<Double>(Double.class, this, ModelPackage.ETYPES__EDOUBLES);
		}
		return eDoubles;
	}

	/**
	 * Returns the value of the '<em><b>EBig Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBig Decimal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EBig Decimal</em>' attribute.
	 * @see #setEBigDecimal(BigDecimal)
	 * @generated
	 */
	public BigDecimal getEBigDecimal() {
		return eBigDecimal;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEBigDecimal <em>EBig Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EBig Decimal</em>' attribute.
	 * @see #getEBigDecimal()
	 * @generated
	 */
	public void setEBigDecimal(BigDecimal newEBigDecimal) {
		BigDecimal oldEBigDecimal = eBigDecimal;
		eBigDecimal = newEBigDecimal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBIG_DECIMAL, oldEBigDecimal, eBigDecimal));
	}

	/**
	 * Returns the value of the '<em><b>EBig Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBig Integer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EBig Integer</em>' attribute.
	 * @see #setEBigInteger(BigInteger)
	 * @generated
	 */
	public BigInteger getEBigInteger() {
		return eBigInteger;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEBigInteger <em>EBig Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EBig Integer</em>' attribute.
	 * @see #getEBigInteger()
	 * @generated
	 */
	public void setEBigInteger(BigInteger newEBigInteger) {
		BigInteger oldEBigInteger = eBigInteger;
		eBigInteger = newEBigInteger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBIG_INTEGER, oldEBigInteger, eBigInteger));
	}

	/**
	 * Returns the value of the '<em><b>EByte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EByte</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EByte</em>' attribute.
	 * @see #setEByte(byte)
	 * @generated
	 */
	public byte getEByte() {
		return eByte;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEByte <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EByte</em>' attribute.
	 * @see #getEByte()
	 * @generated
	 */
	public void setEByte(byte newEByte) {
		byte oldEByte = eByte;
		eByte = newEByte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBYTE, oldEByte, eByte));
	}

	/**
	 * Returns the value of the '<em><b>EByte Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EByte Array</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EByte Array</em>' attribute.
	 * @see #setEByteArray(byte[])
	 * @generated
	 */
	public byte[] getEByteArray() {
		return eByteArray;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEByteArray <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EByte Array</em>' attribute.
	 * @see #getEByteArray()
	 * @generated
	 */
	public void setEByteArray(byte[] newEByteArray) {
		byte[] oldEByteArray = eByteArray;
		eByteArray = newEByteArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EBYTE_ARRAY, oldEByteArray, eByteArray));
	}

	/**
	 * Returns the value of the '<em><b>EChar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EChar</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EChar</em>' attribute.
	 * @see #setEChar(char)
	 * @generated
	 */
	public char getEChar() {
		return eChar;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEChar <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EChar</em>' attribute.
	 * @see #getEChar()
	 * @generated
	 */
	public void setEChar(char newEChar) {
		char oldEChar = eChar;
		eChar = newEChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ECHAR, oldEChar, eChar));
	}

	/**
	 * Returns the value of the '<em><b>EDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EDate</em>' attribute.
	 * @see #setEDate(Date)
	 * @generated
	 */
	public Date getEDate() {
		return eDate;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEDate <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EDate</em>' attribute.
	 * @see #getEDate()
	 * @generated
	 */
	public void setEDate(Date newEDate) {
		Date oldEDate = eDate;
		eDate = newEDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EDATE, oldEDate, eDate));
	}

	/**
	 * Returns the value of the '<em><b>EFloat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EFloat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EFloat</em>' attribute.
	 * @see #setEFloat(float)
	 * @generated
	 */
	public float getEFloat() {
		return eFloat;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEFloat <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EFloat</em>' attribute.
	 * @see #getEFloat()
	 * @generated
	 */
	public void setEFloat(float newEFloat) {
		float oldEFloat = eFloat;
		eFloat = newEFloat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__EFLOAT, oldEFloat, eFloat));
	}

	/**
	 * Returns the value of the '<em><b>ELong</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ELong</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ELong</em>' attribute.
	 * @see #setELong(long)
	 * @generated
	 */
	public long getELong() {
		return eLong;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getELong <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ELong</em>' attribute.
	 * @see #getELong()
	 * @generated
	 */
	public void setELong(long newELong) {
		long oldELong = eLong;
		eLong = newELong;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ELONG, oldELong, eLong));
	}

	/**
	 * Returns the value of the '<em><b>EShort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EShort</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EShort</em>' attribute.
	 * @see #setEShort(short)
	 * @generated
	 */
	public short getEShort() {
		return eShort;
	}

	/**
	 * Sets the value of the '{@link org.emfjson.jackson.junit.model.ETypes#getEShort <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EShort</em>' attribute.
	 * @see #getEShort()
	 * @generated
	 */
	public void setEShort(short newEShort) {
		short oldEShort = eShort;
		eShort = newEShort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ETYPES__ESHORT, oldEShort, eShort));
	}

	/**
	 * Returns the value of the '<em><b>Uris</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.common.util.URI}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uris</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uris</em>' attribute list.
	 * @generated
	 */
	public List<URI> getUris() {
		if (uris == null) {
			uris = new EDataTypeUniqueEList<URI>(URI.class, this, ModelPackage.ETYPES__URIS);
		}
		return uris;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				return getEBigDecimal();
			case ModelPackage.ETYPES__EBIG_INTEGER:
				return getEBigInteger();
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
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ETYPES__ESTRING:
				setEString((String)newValue);
				return;
			case ModelPackage.ETYPES__ESTRINGS:
				getEStrings().clear();
				getEStrings().addAll((Collection<? extends String>)newValue);
				return;
			case ModelPackage.ETYPES__EBOOLEAN:
				setEBoolean((Boolean)newValue);
				return;
			case ModelPackage.ETYPES__EBOOLEANS:
				getEBooleans().clear();
				getEBooleans().addAll((Collection<? extends Boolean>)newValue);
				return;
			case ModelPackage.ETYPES__EINT:
				setEInt((Integer)newValue);
				return;
			case ModelPackage.ETYPES__EINTS:
				getEInts().clear();
				getEInts().addAll((Collection<? extends Integer>)newValue);
				return;
			case ModelPackage.ETYPES__DOUBLE_VALUE:
				setDoubleValue((Double)newValue);
				return;
			case ModelPackage.ETYPES__EDOUBLE:
				setEDouble((Double)newValue);
				return;
			case ModelPackage.ETYPES__EDOUBLES:
				getEDoubles().clear();
				getEDoubles().addAll((Collection<? extends Double>)newValue);
				return;
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				setEBigDecimal((BigDecimal)newValue);
				return;
			case ModelPackage.ETYPES__EBIG_INTEGER:
				setEBigInteger((BigInteger)newValue);
				return;
			case ModelPackage.ETYPES__EBYTE:
				setEByte((Byte)newValue);
				return;
			case ModelPackage.ETYPES__EBYTE_ARRAY:
				setEByteArray((byte[])newValue);
				return;
			case ModelPackage.ETYPES__ECHAR:
				setEChar((Character)newValue);
				return;
			case ModelPackage.ETYPES__EDATE:
				setEDate((Date)newValue);
				return;
			case ModelPackage.ETYPES__EFLOAT:
				setEFloat((Float)newValue);
				return;
			case ModelPackage.ETYPES__ELONG:
				setELong((Long)newValue);
				return;
			case ModelPackage.ETYPES__ESHORT:
				setEShort((Short)newValue);
				return;
			case ModelPackage.ETYPES__URIS:
				getUris().clear();
				getUris().addAll((Collection<? extends URI>)newValue);
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				setEBigDecimal(EBIG_DECIMAL_EDEFAULT);
				return;
			case ModelPackage.ETYPES__EBIG_INTEGER:
				setEBigInteger(EBIG_INTEGER_EDEFAULT);
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
			case ModelPackage.ETYPES__EBIG_DECIMAL:
				return EBIG_DECIMAL_EDEFAULT == null ? eBigDecimal != null : !EBIG_DECIMAL_EDEFAULT.equals(eBigDecimal);
			case ModelPackage.ETYPES__EBIG_INTEGER:
				return EBIG_INTEGER_EDEFAULT == null ? eBigInteger != null : !EBIG_INTEGER_EDEFAULT.equals(eBigInteger);
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
		result.append(", eBigDecimal: ");
		result.append(eBigDecimal);
		result.append(", eBigInteger: ");
		result.append(eBigInteger);
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

} // ETypes
