/**
 */
package org.eclipselabs.emfjson.json.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipselabs.emfjson.json.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JSONFactoryImpl extends EFactoryImpl implements JSONFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JSONFactory init()
	{
		try
		{
			JSONFactory theJSONFactory = (JSONFactory)EPackage.Registry.INSTANCE.getEFactory(JSONPackage.eNS_URI);
			if (theJSONFactory != null)
			{
				return theJSONFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JSONFactoryImplCustom();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case JSONPackage.JOBJECT: return createJObject();
			case JSONPackage.JARRAY: return createJArray();
			case JSONPackage.JBOOLEAN: return createJBoolean();
			case JSONPackage.JNUMBER: return createJNumber();
			case JSONPackage.JNULL: return createJNull();
			case JSONPackage.JSTRING: return createJString();
			case JSONPackage.ENTRY: return (EObject)createEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JObject createJObject()
	{
		JObjectImplCustom jObject = new JObjectImplCustom();
		return jObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JArray createJArray()
	{
		JArrayImplCustom jArray = new JArrayImplCustom();
		return jArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JBoolean createJBoolean()
	{
		JBooleanImplCustom jBoolean = new JBooleanImplCustom();
		return jBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNumber createJNumber()
	{
		JNumberImplCustom jNumber = new JNumberImplCustom();
		return jNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNull createJNull()
	{
		JNullImplCustom jNull = new JNullImplCustom();
		return jNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JString createJString()
	{
		JStringImplCustom jString = new JStringImplCustom();
		return jString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, JNode> createEntry()
	{
		EntryImplCustom entry = new EntryImplCustom();
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONPackage getJSONPackage()
	{
		return (JSONPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JSONPackage getPackage()
	{
		return JSONPackage.eINSTANCE;
	}

} //JSONFactoryImpl
