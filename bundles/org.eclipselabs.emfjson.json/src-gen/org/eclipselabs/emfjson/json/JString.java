/**
 */
package org.eclipselabs.emfjson.json;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JString</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.json.JString#getStringValue <em>String Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.json.JSONPackage#getJString()
 * @model
 * @generated
 */
public interface JString extends JValue {
	/**
	 * Returns the value of the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Value</em>' attribute.
	 * @see #setStringValue(String)
	 * @see org.eclipselabs.emfjson.json.JSONPackage#getJString_StringValue()
	 * @model
	 * @generated
	 */
	String getStringValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.json.JString#getStringValue <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Value</em>' attribute.
	 * @see #getStringValue()
	 * @generated
	 */
	void setStringValue(String value);

} // JString
