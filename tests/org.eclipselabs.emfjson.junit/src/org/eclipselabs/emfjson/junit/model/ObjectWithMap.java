/**
 */
package org.eclipselabs.emfjson.junit.model;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object With Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.ObjectWithMap#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.ObjectWithMap#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getObjectWithMap()
 * @model
 * @generated
 */
public interface ObjectWithMap extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' map.
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getObjectWithMap_Entries()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 *        annotation="JSON dynamicMap='true'"
	 * @generated
	 */
	EMap<String, String> getEntries();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' map.
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getObjectWithMap_Dependencies()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getDependencies();

} // ObjectWithMap
