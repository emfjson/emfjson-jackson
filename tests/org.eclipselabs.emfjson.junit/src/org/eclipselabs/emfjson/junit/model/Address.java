/**
 */
package org.eclipselabs.emfjson.junit.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.Address#getAddId <em>Add Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.Address#getCity <em>City</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.Address#getStreet <em>Street</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.Address#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getAddress()
 * @model
 * @generated
 */
public interface Address extends EObject {
	/**
	 * Returns the value of the '<em><b>Add Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Id</em>' attribute.
	 * @see #setAddId(String)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getAddress_AddId()
	 * @model id="true"
	 * @generated
	 */
	String getAddId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.Address#getAddId <em>Add Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Id</em>' attribute.
	 * @see #getAddId()
	 * @generated
	 */
	void setAddId(String value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>City</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getAddress_City()
	 * @model
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.Address#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getAddress_Street()
	 * @model
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.Address#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(Integer)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getAddress_Number()
	 * @model
	 * @generated
	 */
	Integer getNumber();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.Address#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(Integer value);

} // Address
