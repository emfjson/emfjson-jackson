/**
 */
package org.eclipselabs.emfjson.json;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emfjson.json.JSONPackage
 * @generated
 */
public interface JSONFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JSONFactory eINSTANCE = org.eclipselabs.emfjson.json.impl.JSONFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>JObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JObject</em>'.
	 * @generated
	 */
	JObject createJObject();

	/**
	 * Returns a new object of class '<em>JArray</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JArray</em>'.
	 * @generated
	 */
	JArray createJArray();

	/**
	 * Returns a new object of class '<em>JBoolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JBoolean</em>'.
	 * @generated
	 */
	JBoolean createJBoolean();

	/**
	 * Returns a new object of class '<em>JNumber</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JNumber</em>'.
	 * @generated
	 */
	JNumber createJNumber();

	/**
	 * Returns a new object of class '<em>JNull</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JNull</em>'.
	 * @generated
	 */
	JNull createJNull();

	/**
	 * Returns a new object of class '<em>JString</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JString</em>'.
	 * @generated
	 */
	JString createJString();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JSONPackage getJSONPackage();

} //JSONFactory
