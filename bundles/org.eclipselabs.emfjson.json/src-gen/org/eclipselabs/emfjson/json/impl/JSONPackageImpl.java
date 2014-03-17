/**
 */
package org.eclipselabs.emfjson.json.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipselabs.emfjson.json.JArray;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JElement;
import org.eclipselabs.emfjson.json.JNode;
import org.eclipselabs.emfjson.json.JNull;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JObject;
import org.eclipselabs.emfjson.json.JSONFactory;
import org.eclipselabs.emfjson.json.JSONPackage;
import org.eclipselabs.emfjson.json.JString;
import org.eclipselabs.emfjson.json.JValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JSONPackageImpl extends EPackageImpl implements JSONPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jBooleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jNullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.emfjson.json.JSONPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JSONPackageImpl()
	{
		super(eNS_URI, JSONFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JSONPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JSONPackage init()
	{
		if (isInited) return (JSONPackage)EPackage.Registry.INSTANCE.getEPackage(JSONPackage.eNS_URI);

		// Obtain or create and register package
		JSONPackageImpl theJSONPackage = (JSONPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JSONPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JSONPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJSONPackage.createPackageContents();

		// Initialize created meta-data
		theJSONPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJSONPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JSONPackage.eNS_URI, theJSONPackage);
		return theJSONPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJElement()
	{
		return jElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJNode()
	{
		return jNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJObject()
	{
		return jObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJObject_Fields()
	{
		return (EReference)jObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJObject__Put__String_JNode()
	{
		return jObjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJObject__Put__String_String()
	{
		return jObjectEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJObject__Put__String_boolean()
	{
		return jObjectEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJObject__Put__String_double()
	{
		return jObjectEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJObject__Get__String()
	{
		return jObjectEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJObject__Contains__String()
	{
		return jObjectEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJArray()
	{
		return jArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJArray_Elements()
	{
		return (EReference)jArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJValue()
	{
		return jValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJValue__AsText()
	{
		return jValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJBoolean()
	{
		return jBooleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJBoolean_BooleanValue()
	{
		return (EAttribute)jBooleanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJNumber()
	{
		return jNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJNumber_NumberValue()
	{
		return (EAttribute)jNumberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJNull()
	{
		return jNullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJString()
	{
		return jStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJString_StringValue()
	{
		return (EAttribute)jStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntry()
	{
		return entryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntry_Key()
	{
		return (EAttribute)entryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntry_Value()
	{
		return (EReference)entryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONFactory getJSONFactory()
	{
		return (JSONFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		jElementEClass = createEClass(JELEMENT);

		jNodeEClass = createEClass(JNODE);

		jObjectEClass = createEClass(JOBJECT);
		createEReference(jObjectEClass, JOBJECT__FIELDS);
		createEOperation(jObjectEClass, JOBJECT___PUT__STRING_JNODE);
		createEOperation(jObjectEClass, JOBJECT___PUT__STRING_STRING);
		createEOperation(jObjectEClass, JOBJECT___PUT__STRING_BOOLEAN);
		createEOperation(jObjectEClass, JOBJECT___PUT__STRING_DOUBLE);
		createEOperation(jObjectEClass, JOBJECT___GET__STRING);
		createEOperation(jObjectEClass, JOBJECT___CONTAINS__STRING);

		jArrayEClass = createEClass(JARRAY);
		createEReference(jArrayEClass, JARRAY__ELEMENTS);

		jValueEClass = createEClass(JVALUE);
		createEOperation(jValueEClass, JVALUE___AS_TEXT);

		jBooleanEClass = createEClass(JBOOLEAN);
		createEAttribute(jBooleanEClass, JBOOLEAN__BOOLEAN_VALUE);

		jNumberEClass = createEClass(JNUMBER);
		createEAttribute(jNumberEClass, JNUMBER__NUMBER_VALUE);

		jNullEClass = createEClass(JNULL);

		jStringEClass = createEClass(JSTRING);
		createEAttribute(jStringEClass, JSTRING__STRING_VALUE);

		entryEClass = createEClass(ENTRY);
		createEAttribute(entryEClass, ENTRY__KEY);
		createEReference(entryEClass, ENTRY__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		jNodeEClass.getESuperTypes().add(this.getJElement());
		jObjectEClass.getESuperTypes().add(this.getJNode());
		jArrayEClass.getESuperTypes().add(this.getJNode());
		jValueEClass.getESuperTypes().add(this.getJNode());
		jBooleanEClass.getESuperTypes().add(this.getJValue());
		jNumberEClass.getESuperTypes().add(this.getJValue());
		jNullEClass.getESuperTypes().add(this.getJValue());
		jStringEClass.getESuperTypes().add(this.getJValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(jElementEClass, JElement.class, "JElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jNodeEClass, JNode.class, "JNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jObjectEClass, JObject.class, "JObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJObject_Fields(), this.getEntry(), null, "fields", null, 0, -1, JObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getJObject__Put__String_JNode(), null, "put", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getJNode(), "value", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getJObject__Put__String_String(), null, "put", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getJObject__Put__String_boolean(), null, "put", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getJObject__Put__String_double(), null, "put", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getJObject__Get__String(), this.getJNode(), "get", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getJObject__Contains__String(), ecorePackage.getEBoolean(), "contains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jArrayEClass, JArray.class, "JArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJArray_Elements(), this.getJNode(), null, "elements", null, 0, -1, JArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jValueEClass, JValue.class, "JValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getJValue__AsText(), ecorePackage.getEString(), "asText", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jBooleanEClass, JBoolean.class, "JBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJBoolean_BooleanValue(), ecorePackage.getEBoolean(), "booleanValue", "false", 0, 1, JBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jNumberEClass, JNumber.class, "JNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJNumber_NumberValue(), ecorePackage.getEDouble(), "numberValue", null, 0, 1, JNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jNullEClass, JNull.class, "JNull", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jStringEClass, JString.class, "JString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJString_StringValue(), ecorePackage.getEString(), "stringValue", null, 0, 1, JString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryEClass, Map.Entry.class, "Entry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntry_Value(), this.getJNode(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //JSONPackageImpl
