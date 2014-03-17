/**
 */
package org.eclipselabs.emfjson.json;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JObject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.json.JObject#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.json.JSONPackage#getJObject()
 * @model
 * @generated
 */
public interface JObject extends JNode
{
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipselabs.emfjson.json.JNode},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' map.
	 * @see org.eclipselabs.emfjson.json.JSONPackage#getJObject_Fields()
	 * @model mapType="org.eclipselabs.emfjson.json.Entry<org.eclipse.emf.ecore.EString, org.eclipselabs.emfjson.json.JNode>"
	 * @generated
	 */
	EMap<String, JNode> getFields();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model keyRequired="true" valueRequired="true"
	 * @generated
	 */
	void put(String key, JNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void put(String key, String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void put(String key, boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void put(String key, double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	JNode get(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean contains(String key);

} // JObject
