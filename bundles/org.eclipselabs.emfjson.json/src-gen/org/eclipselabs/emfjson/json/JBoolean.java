/**
 */
package org.eclipselabs.emfjson.json;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JBoolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.json.JBoolean#isBooleanValue <em>Boolean Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.json.JSONPackage#getJBoolean()
 * @model
 * @generated
 */
public interface JBoolean extends JValue {
	/**
	 * Returns the value of the '<em><b>Boolean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Value</em>' attribute.
	 * @see #setBooleanValue(boolean)
	 * @see org.eclipselabs.emfjson.json.JSONPackage#getJBoolean_BooleanValue()
	 * @model
	 * @generated
	 */
	boolean isBooleanValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.json.JBoolean#isBooleanValue <em>Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Value</em>' attribute.
	 * @see #isBooleanValue()
	 * @generated
	 */
	void setBooleanValue(boolean value);

} // JBoolean
