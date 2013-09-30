/**
 */
package org.eclipselabs.emfjson.json;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.emfjson.json.JSONFactory
 * @model kind="package"
 * @generated
 */
public interface JSONPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "json";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipselabs.org/emfjson/2013/json";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "json";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JSONPackage eINSTANCE = org.eclipselabs.emfjson.json.impl.JSONPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JNodeImpl <em>JNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JNodeImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNode()
	 * @generated
	 */
	int JNODE = 0;

	/**
	 * The number of structural features of the '<em>JNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNODE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>JNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JObjectImpl <em>JObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JObjectImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJObject()
	 * @generated
	 */
	int JOBJECT = 1;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT__FIELDS = JNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT_FEATURE_COUNT = JNODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT_OPERATION_COUNT = JNODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JArrayImpl <em>JArray</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JArrayImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJArray()
	 * @generated
	 */
	int JARRAY = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY__ELEMENTS = JNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JArray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY_FEATURE_COUNT = JNODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JArray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY_OPERATION_COUNT = JNODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JFieldImpl <em>JField</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JFieldImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJField()
	 * @generated
	 */
	int JFIELD = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFIELD__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFIELD__VALUE = 1;

	/**
	 * The number of structural features of the '<em>JField</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFIELD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>JField</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JValueImpl <em>JValue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JValueImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJValue()
	 * @generated
	 */
	int JVALUE = 4;

	/**
	 * The number of structural features of the '<em>JValue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVALUE_FEATURE_COUNT = JNODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>JValue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVALUE_OPERATION_COUNT = JNODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JBooleanImpl <em>JBoolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JBooleanImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJBoolean()
	 * @generated
	 */
	int JBOOLEAN = 5;

	/**
	 * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBOOLEAN__BOOLEAN_VALUE = JVALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JBoolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBOOLEAN_FEATURE_COUNT = JVALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JBoolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBOOLEAN_OPERATION_COUNT = JVALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JNumberImpl <em>JNumber</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JNumberImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNumber()
	 * @generated
	 */
	int JNUMBER = 6;

	/**
	 * The feature id for the '<em><b>Number Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNUMBER__NUMBER_VALUE = JVALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JNumber</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNUMBER_FEATURE_COUNT = JVALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JNumber</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNUMBER_OPERATION_COUNT = JVALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JNullImpl <em>JNull</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JNullImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNull()
	 * @generated
	 */
	int JNULL = 7;

	/**
	 * The number of structural features of the '<em>JNull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNULL_FEATURE_COUNT = JVALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>JNull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNULL_OPERATION_COUNT = JVALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JStringImpl <em>JString</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JStringImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJString()
	 * @generated
	 */
	int JSTRING = 8;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTRING__STRING_VALUE = JVALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JString</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTRING_FEATURE_COUNT = JVALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JString</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTRING_OPERATION_COUNT = JVALUE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JNode <em>JNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JNode</em>'.
	 * @see org.eclipselabs.emfjson.json.JNode
	 * @generated
	 */
	EClass getJNode();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JObject <em>JObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JObject</em>'.
	 * @see org.eclipselabs.emfjson.json.JObject
	 * @generated
	 */
	EClass getJObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emfjson.json.JObject#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.eclipselabs.emfjson.json.JObject#getFields()
	 * @see #getJObject()
	 * @generated
	 */
	EReference getJObject_Fields();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JArray <em>JArray</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JArray</em>'.
	 * @see org.eclipselabs.emfjson.json.JArray
	 * @generated
	 */
	EClass getJArray();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.emfjson.json.JArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.eclipselabs.emfjson.json.JArray#getElements()
	 * @see #getJArray()
	 * @generated
	 */
	EReference getJArray_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JField <em>JField</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JField</em>'.
	 * @see org.eclipselabs.emfjson.json.JField
	 * @generated
	 */
	EClass getJField();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.json.JField#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipselabs.emfjson.json.JField#getKey()
	 * @see #getJField()
	 * @generated
	 */
	EAttribute getJField_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.emfjson.json.JField#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipselabs.emfjson.json.JField#getValue()
	 * @see #getJField()
	 * @generated
	 */
	EReference getJField_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JValue <em>JValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JValue</em>'.
	 * @see org.eclipselabs.emfjson.json.JValue
	 * @generated
	 */
	EClass getJValue();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JBoolean <em>JBoolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JBoolean</em>'.
	 * @see org.eclipselabs.emfjson.json.JBoolean
	 * @generated
	 */
	EClass getJBoolean();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.json.JBoolean#isBooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Value</em>'.
	 * @see org.eclipselabs.emfjson.json.JBoolean#isBooleanValue()
	 * @see #getJBoolean()
	 * @generated
	 */
	EAttribute getJBoolean_BooleanValue();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JNumber <em>JNumber</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JNumber</em>'.
	 * @see org.eclipselabs.emfjson.json.JNumber
	 * @generated
	 */
	EClass getJNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.json.JNumber#getNumberValue <em>Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Value</em>'.
	 * @see org.eclipselabs.emfjson.json.JNumber#getNumberValue()
	 * @see #getJNumber()
	 * @generated
	 */
	EAttribute getJNumber_NumberValue();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JNull <em>JNull</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JNull</em>'.
	 * @see org.eclipselabs.emfjson.json.JNull
	 * @generated
	 */
	EClass getJNull();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JString <em>JString</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JString</em>'.
	 * @see org.eclipselabs.emfjson.json.JString
	 * @generated
	 */
	EClass getJString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.emfjson.json.JString#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.eclipselabs.emfjson.json.JString#getStringValue()
	 * @see #getJString()
	 * @generated
	 */
	EAttribute getJString_StringValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JSONFactory getJSONFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JNodeImpl <em>JNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JNodeImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNode()
		 * @generated
		 */
		EClass JNODE = eINSTANCE.getJNode();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JObjectImpl <em>JObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JObjectImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJObject()
		 * @generated
		 */
		EClass JOBJECT = eINSTANCE.getJObject();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOBJECT__FIELDS = eINSTANCE.getJObject_Fields();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JArrayImpl <em>JArray</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JArrayImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJArray()
		 * @generated
		 */
		EClass JARRAY = eINSTANCE.getJArray();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JARRAY__ELEMENTS = eINSTANCE.getJArray_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JFieldImpl <em>JField</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JFieldImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJField()
		 * @generated
		 */
		EClass JFIELD = eINSTANCE.getJField();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JFIELD__KEY = eINSTANCE.getJField_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JFIELD__VALUE = eINSTANCE.getJField_Value();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JValueImpl <em>JValue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JValueImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJValue()
		 * @generated
		 */
		EClass JVALUE = eINSTANCE.getJValue();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JBooleanImpl <em>JBoolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JBooleanImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJBoolean()
		 * @generated
		 */
		EClass JBOOLEAN = eINSTANCE.getJBoolean();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JBOOLEAN__BOOLEAN_VALUE = eINSTANCE.getJBoolean_BooleanValue();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JNumberImpl <em>JNumber</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JNumberImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNumber()
		 * @generated
		 */
		EClass JNUMBER = eINSTANCE.getJNumber();

		/**
		 * The meta object literal for the '<em><b>Number Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JNUMBER__NUMBER_VALUE = eINSTANCE.getJNumber_NumberValue();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JNullImpl <em>JNull</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JNullImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNull()
		 * @generated
		 */
		EClass JNULL = eINSTANCE.getJNull();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.JStringImpl <em>JString</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.JStringImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJString()
		 * @generated
		 */
		EClass JSTRING = eINSTANCE.getJString();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSTRING__STRING_VALUE = eINSTANCE.getJString_StringValue();

	}

} //JSONPackage
