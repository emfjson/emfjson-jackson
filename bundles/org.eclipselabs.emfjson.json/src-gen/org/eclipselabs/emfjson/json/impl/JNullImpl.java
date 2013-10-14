/**
 */
package org.eclipselabs.emfjson.json.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.emfjson.json.JNull;
import org.eclipselabs.emfjson.json.JSONPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>JNull</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class JNullImpl extends MinimalEObjectImpl.Container implements JNull {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JNullImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JSONPackage.Literals.JNULL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String asText() {
		return "undefined";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case JSONPackage.JNULL___AS_TEXT:
			return asText();
		}
		return super.eInvoke(operationID, arguments);
	}

} // JNullImpl
