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
package org.emfjson.gwt.junit.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETypes</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEString <em>EString</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEStrings <em>EStrings</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#isEBoolean <em>EBoolean</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEBooleans <em>EBooleans</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEInt <em>EInt</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEInts <em>EInts</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getDoubleValue <em>Double Value</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEDouble <em>EDouble</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEDoubles <em>EDoubles</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEByte <em>EByte</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEByteArray <em>EByte Array</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEChar <em>EChar</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEDate <em>EDate</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEFloat <em>EFloat</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getELong <em>ELong</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getEShort <em>EShort</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.ETypes#getUris <em>Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes()
 */
public interface ETypes extends EObject {
	/**
	 * Returns the value of the '<em><b>EString</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EString</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EString</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEString(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EString()
	 */
	String getEString();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEString <em>EString</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EString</em>' attribute.
	 * @generated
	 * @see #getEString()
	 */
	void setEString(String value);

	/**
	 * Returns the value of the '<em><b>EStrings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EStrings</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EStrings</em>' attribute list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EStrings()
	 */
	EList<String> getEStrings();

	/**
	 * Returns the value of the '<em><b>EBoolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBoolean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EBoolean</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEBoolean(boolean)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EBoolean()
	 */
	boolean isEBoolean();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#isEBoolean <em>EBoolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EBoolean</em>' attribute.
	 * @generated
	 * @see #isEBoolean()
	 */
	void setEBoolean(boolean value);

	/**
	 * Returns the value of the '<em><b>EBooleans</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EBooleans</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EBooleans</em>' attribute list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EBooleans()
	 */
	EList<Boolean> getEBooleans();

	/**
	 * Returns the value of the '<em><b>EInt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EInt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EInt</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEInt(int)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EInt()
	 */
	int getEInt();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEInt <em>EInt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EInt</em>' attribute.
	 * @generated
	 * @see #getEInt()
	 */
	void setEInt(int value);

	/**
	 * Returns the value of the '<em><b>EInts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EInts</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EInts</em>' attribute list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EInts()
	 */
	EList<Integer> getEInts();

	/**
	 * Returns the value of the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Double Value</em>' attribute.
	 * @model
	 * @generated
	 * @see #setDoubleValue(Double)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_DoubleValue()
	 */
	Double getDoubleValue();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getDoubleValue <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Double Value</em>' attribute.
	 * @generated
	 * @see #getDoubleValue()
	 */
	void setDoubleValue(Double value);

	/**
	 * Returns the value of the '<em><b>EDouble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDouble</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EDouble</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEDouble(double)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EDouble()
	 */
	double getEDouble();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEDouble <em>EDouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EDouble</em>' attribute.
	 * @generated
	 * @see #getEDouble()
	 */
	void setEDouble(double value);

	/**
	 * Returns the value of the '<em><b>EDoubles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDoubles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EDoubles</em>' attribute list.
	 * @model
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EDoubles()
	 */
	EList<Double> getEDoubles();

	/**
	 * Returns the value of the '<em><b>EByte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EByte</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EByte</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEByte(byte)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EByte()
	 */
	byte getEByte();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEByte <em>EByte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EByte</em>' attribute.
	 * @generated
	 * @see #getEByte()
	 */
	void setEByte(byte value);

	/**
	 * Returns the value of the '<em><b>EByte Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EByte Array</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EByte Array</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEByteArray(byte[])
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EByteArray()
	 */
	byte[] getEByteArray();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEByteArray <em>EByte Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EByte Array</em>' attribute.
	 * @generated
	 * @see #getEByteArray()
	 */
	void setEByteArray(byte[] value);

	/**
	 * Returns the value of the '<em><b>EChar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EChar</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EChar</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEChar(char)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EChar()
	 */
	char getEChar();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEChar <em>EChar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EChar</em>' attribute.
	 * @generated
	 * @see #getEChar()
	 */
	void setEChar(char value);

	/**
	 * Returns the value of the '<em><b>EDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EDate</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEDate(Date)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EDate()
	 */
	Date getEDate();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEDate <em>EDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EDate</em>' attribute.
	 * @generated
	 * @see #getEDate()
	 */
	void setEDate(Date value);

	/**
	 * Returns the value of the '<em><b>EFloat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EFloat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EFloat</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEFloat(float)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EFloat()
	 */
	float getEFloat();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEFloat <em>EFloat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EFloat</em>' attribute.
	 * @generated
	 * @see #getEFloat()
	 */
	void setEFloat(float value);

	/**
	 * Returns the value of the '<em><b>ELong</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ELong</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>ELong</em>' attribute.
	 * @model
	 * @generated
	 * @see #setELong(long)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_ELong()
	 */
	long getELong();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getELong <em>ELong</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>ELong</em>' attribute.
	 * @generated
	 * @see #getELong()
	 */
	void setELong(long value);

	/**
	 * Returns the value of the '<em><b>EShort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EShort</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>EShort</em>' attribute.
	 * @model
	 * @generated
	 * @see #setEShort(short)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_EShort()
	 */
	short getEShort();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.ETypes#getEShort <em>EShort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>EShort</em>' attribute.
	 * @generated
	 * @see #getEShort()
	 */
	void setEShort(short value);

	/**
	 * Returns the value of the '<em><b>Uris</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.common.util.URI}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uris</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Uris</em>' attribute list.
	 * @model dataType="org.eclipselabs.emfjson.junit.model.URI"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getETypes_Uris()
	 */
	EList<URI> getUris();

} // ETypes
