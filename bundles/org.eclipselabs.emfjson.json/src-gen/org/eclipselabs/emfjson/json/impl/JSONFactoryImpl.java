/**
 */
package org.eclipselabs.emfjson.json.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JField;
import org.eclipselabs.emfjson.json.JNull;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JSONFactory;
import org.eclipselabs.emfjson.json.JSONPackage;
import org.eclipselabs.emfjson.json.JString;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JSONFactoryImpl extends EFactoryImpl implements JSONFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JSONFactory init() {
		try {
			JSONFactory theJSONFactory = (JSONFactory)EPackage.Registry.INSTANCE.getEFactory(JSONPackage.eNS_URI);
			if (theJSONFactory != null) {
				return theJSONFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JSONFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JSONPackage.JOBJECT: return createJObject();
			case JSONPackage.JARRAY: return createJArray();
			case JSONPackage.JFIELD: return createJField();
			case JSONPackage.JBOOLEAN: return createJBoolean();
			case JSONPackage.JNUMBER: return createJNumber();
			case JSONPackage.JNULL: return createJNull();
			case JSONPackage.JSTRING: return createJString();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JObject createJObject() {
		JObjectImpl jObject = new JObjectImpl();
		return jObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JArray createJArray() {
		JArrayImpl jArray = new JArrayImpl();
		return jArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JField createJField() {
		JFieldImpl jField = new JFieldImpl();
		return jField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JBoolean createJBoolean() {
		JBooleanImpl jBoolean = new JBooleanImpl();
		return jBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNumber createJNumber() {
		JNumberImpl jNumber = new JNumberImpl();
		return jNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNull createJNull() {
		JNullImpl jNull = new JNullImpl();
		return jNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JString createJString() {
		JStringImpl jString = new JStringImpl();
		return jString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONPackage getJSONPackage() {
		return (JSONPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JSONPackage getPackage() {
		return JSONPackage.eINSTANCE;
	}

} //JSONFactoryImpl
