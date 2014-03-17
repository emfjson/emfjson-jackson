/**
 */
package org.eclipselabs.emfjson.json;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JNumber</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.json.JNumber#getNumberValue <em>Number Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.json.JSONPackage#getJNumber()
 * @model
 * @generated
 */
public interface JNumber extends JValue
{
	/**
	 * Returns the value of the '<em><b>Number Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Value</em>' attribute.
	 * @see #setNumberValue(double)
	 * @see org.eclipselabs.emfjson.json.JSONPackage#getJNumber_NumberValue()
	 * @model
	 * @generated
	 */
	double getNumberValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.json.JNumber#getNumberValue <em>Number Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Value</em>' attribute.
	 * @see #getNumberValue()
	 * @generated
	 */
	void setNumberValue(double value);

} // JNumber
