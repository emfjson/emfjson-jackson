/**
 */
package org.eclipselabs.emfjson.json.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JElement;
import org.eclipselabs.emfjson.json.JField;
import org.eclipselabs.emfjson.json.JNode;
import org.eclipselabs.emfjson.json.JNull;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JSONPackage;
import org.eclipselabs.emfjson.json.JString;
import org.eclipselabs.emfjson.json.JValue;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emfjson.json.JSONPackage
 * @generated
 */
public class JSONSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JSONPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONSwitch() {
		if (modelPackage == null) {
			modelPackage = JSONPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JSONPackage.JELEMENT: {
				JElement jElement = (JElement)theEObject;
				T result = caseJElement(jElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JNODE: {
				JNode jNode = (JNode)theEObject;
				T result = caseJNode(jNode);
				if (result == null) result = caseJElement(jNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JOBJECT: {
				JObject jObject = (JObject)theEObject;
				T result = caseJObject(jObject);
				if (result == null) result = caseJNode(jObject);
				if (result == null) result = caseJElement(jObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JARRAY: {
				JArray jArray = (JArray)theEObject;
				T result = caseJArray(jArray);
				if (result == null) result = caseJNode(jArray);
				if (result == null) result = caseJElement(jArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JFIELD: {
				JField jField = (JField)theEObject;
				T result = caseJField(jField);
				if (result == null) result = caseJElement(jField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JVALUE: {
				JValue jValue = (JValue)theEObject;
				T result = caseJValue(jValue);
				if (result == null) result = caseJNode(jValue);
				if (result == null) result = caseJElement(jValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JBOOLEAN: {
				JBoolean jBoolean = (JBoolean)theEObject;
				T result = caseJBoolean(jBoolean);
				if (result == null) result = caseJValue(jBoolean);
				if (result == null) result = caseJNode(jBoolean);
				if (result == null) result = caseJElement(jBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JNUMBER: {
				JNumber jNumber = (JNumber)theEObject;
				T result = caseJNumber(jNumber);
				if (result == null) result = caseJValue(jNumber);
				if (result == null) result = caseJNode(jNumber);
				if (result == null) result = caseJElement(jNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JNULL: {
				JNull jNull = (JNull)theEObject;
				T result = caseJNull(jNull);
				if (result == null) result = caseJValue(jNull);
				if (result == null) result = caseJNode(jNull);
				if (result == null) result = caseJElement(jNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JSONPackage.JSTRING: {
				JString jString = (JString)theEObject;
				T result = caseJString(jString);
				if (result == null) result = caseJValue(jString);
				if (result == null) result = caseJNode(jString);
				if (result == null) result = caseJElement(jString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJElement(JElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJNode(JNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJObject(JObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JArray</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JArray</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJArray(JArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JField</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JField</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJField(JField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JValue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JValue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJValue(JValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JBoolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JBoolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJBoolean(JBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JNumber</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JNumber</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJNumber(JNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JNull</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JNull</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJNull(JNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JString</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JString</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJString(JString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //JSONSwitch
