/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.emfjson.youtube;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Aspect Ratio</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emfjson.youtube.YoutubePackage#getAspectRatio()
 * @model
 * @generated
 */
public enum AspectRatio implements Enumerator {
	/**
	 * The '<em><b>WIDESCREEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDESCREEN_VALUE
	 * @generated
	 * @ordered
	 */
	WIDESCREEN(0, "WIDESCREEN", "WIDESCREEN");

	/**
	 * The '<em><b>WIDESCREEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WIDESCREEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WIDESCREEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIDESCREEN_VALUE = 0;

	/**
	 * An array of all the '<em><b>Aspect Ratio</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AspectRatio[] VALUES_ARRAY =
		new AspectRatio[] {
			WIDESCREEN,
		};

	/**
	 * A public read-only list of all the '<em><b>Aspect Ratio</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AspectRatio> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Aspect Ratio</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AspectRatio get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AspectRatio result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Aspect Ratio</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AspectRatio getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AspectRatio result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Aspect Ratio</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AspectRatio get(int value) {
		switch (value) {
			case WIDESCREEN_VALUE: return WIDESCREEN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AspectRatio(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AspectRatio
