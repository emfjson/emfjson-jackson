/**
 */
package org.eclipselabs.emfjson.json;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
public interface JSONPackage extends EPackage
{
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
	String eNS_URI = "http://eclipselabs.org/emfjson/JSON";

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
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.JElement <em>JElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.JElement
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJElement()
	 * @generated
	 */
	int JELEMENT = 0;

	/**
	 * The number of structural features of the '<em>JElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>JElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.JNode <em>JNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.JNode
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJNode()
	 * @generated
	 */
	int JNODE = 1;

	/**
	 * The number of structural features of the '<em>JNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNODE_FEATURE_COUNT = JELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>JNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNODE_OPERATION_COUNT = JELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JObjectImpl <em>JObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JObjectImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJObject()
	 * @generated
	 */
	int JOBJECT = 2;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' map.
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
	 * The operation id for the '<em>Put</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT___PUT__STRING_JNODE = JNODE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Put</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT___PUT__STRING_STRING = JNODE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Put</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT___PUT__STRING_BOOLEAN = JNODE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Put</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT___PUT__STRING_DOUBLE = JNODE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT___GET__STRING = JNODE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT___CONTAINS__STRING = JNODE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>JObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOBJECT_OPERATION_COUNT = JNODE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.JArrayImpl <em>JArray</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.JArrayImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJArray()
	 * @generated
	 */
	int JARRAY = 3;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
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
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.JValue <em>JValue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.JValue
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
	 * The operation id for the '<em>As Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVALUE___AS_TEXT = JNODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>JValue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVALUE_OPERATION_COUNT = JNODE_OPERATION_COUNT + 1;

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
	 * The operation id for the '<em>As Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBOOLEAN___AS_TEXT = JVALUE___AS_TEXT;

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
	 * The operation id for the '<em>As Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNUMBER___AS_TEXT = JVALUE___AS_TEXT;

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
	 * The operation id for the '<em>As Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNULL___AS_TEXT = JVALUE___AS_TEXT;

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
	 * The operation id for the '<em>As Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTRING___AS_TEXT = JVALUE___AS_TEXT;

	/**
	 * The number of operations of the '<em>JString</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTRING_OPERATION_COUNT = JVALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.emfjson.json.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.emfjson.json.impl.EntryImpl
	 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.emfjson.json.JElement <em>JElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JElement</em>'.
	 * @see org.eclipselabs.emfjson.json.JElement
	 * @generated
	 */
	EClass getJElement();

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
	 * Returns the meta object for the map '{@link org.eclipselabs.emfjson.json.JObject#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Fields</em>'.
	 * @see org.eclipselabs.emfjson.json.JObject#getFields()
	 * @see #getJObject()
	 * @generated
	 */
	EReference getJObject_Fields();

	/**
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JObject#put(java.lang.String, org.eclipselabs.emfjson.json.JNode) <em>Put</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Put</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JObject#put(java.lang.String, org.eclipselabs.emfjson.json.JNode)
	 * @generated
	 */
	EOperation getJObject__Put__String_JNode();

	/**
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JObject#put(java.lang.String, java.lang.String) <em>Put</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Put</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JObject#put(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getJObject__Put__String_String();

	/**
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JObject#put(java.lang.String, boolean) <em>Put</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Put</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JObject#put(java.lang.String, boolean)
	 * @generated
	 */
	EOperation getJObject__Put__String_boolean();

	/**
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JObject#put(java.lang.String, double) <em>Put</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Put</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JObject#put(java.lang.String, double)
	 * @generated
	 */
	EOperation getJObject__Put__String_double();

	/**
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JObject#get(java.lang.String) <em>Get</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JObject#get(java.lang.String)
	 * @generated
	 */
	EOperation getJObject__Get__String();

	/**
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JObject#contains(java.lang.String) <em>Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contains</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JObject#contains(java.lang.String)
	 * @generated
	 */
	EOperation getJObject__Contains__String();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.emfjson.json.JArray#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipselabs.emfjson.json.JArray#getElements()
	 * @see #getJArray()
	 * @generated
	 */
	EReference getJArray_Elements();

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
	 * Returns the meta object for the '{@link org.eclipselabs.emfjson.json.JValue#asText() <em>As Text</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>As Text</em>' operation.
	 * @see org.eclipselabs.emfjson.json.JValue#asText()
	 * @generated
	 */
	EOperation getJValue__AsText();

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
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipselabs.emfjson.json.JNode" valueContainment="true"
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_Value();

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
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.JElement <em>JElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.JElement
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJElement()
		 * @generated
		 */
		EClass JELEMENT = eINSTANCE.getJElement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.JNode <em>JNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.JNode
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
		 * The meta object literal for the '<em><b>Fields</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOBJECT__FIELDS = eINSTANCE.getJObject_Fields();

		/**
		 * The meta object literal for the '<em><b>Put</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOBJECT___PUT__STRING_JNODE = eINSTANCE.getJObject__Put__String_JNode();

		/**
		 * The meta object literal for the '<em><b>Put</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOBJECT___PUT__STRING_STRING = eINSTANCE.getJObject__Put__String_String();

		/**
		 * The meta object literal for the '<em><b>Put</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOBJECT___PUT__STRING_BOOLEAN = eINSTANCE.getJObject__Put__String_boolean();

		/**
		 * The meta object literal for the '<em><b>Put</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOBJECT___PUT__STRING_DOUBLE = eINSTANCE.getJObject__Put__String_double();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOBJECT___GET__STRING = eINSTANCE.getJObject__Get__String();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOBJECT___CONTAINS__STRING = eINSTANCE.getJObject__Contains__String();

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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JARRAY__ELEMENTS = eINSTANCE.getJArray_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.JValue <em>JValue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.JValue
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getJValue()
		 * @generated
		 */
		EClass JVALUE = eINSTANCE.getJValue();

		/**
		 * The meta object literal for the '<em><b>As Text</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JVALUE___AS_TEXT = eINSTANCE.getJValue__AsText();

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

		/**
		 * The meta object literal for the '{@link org.eclipselabs.emfjson.json.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.emfjson.json.impl.EntryImpl
		 * @see org.eclipselabs.emfjson.json.impl.JSONPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__KEY = eINSTANCE.getEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__VALUE = eINSTANCE.getEntry_Value();

	}

} //JSONPackage
