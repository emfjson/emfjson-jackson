/**
 */
package org.eclipselabs.emfjson.junit.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getSex <em>Sex</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getFriends <em>Friends</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getUniqueFriend <em>Unique Friend</em>}</li>
 *   <li>{@link org.eclipselabs.emfjson.junit.model.User#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser()
 * @model annotation="JSON root='true'"
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_UserId()
	 * @model id="true"
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Date</em>' attribute.
	 * @see #setBirthDate(Date)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_BirthDate()
	 * @model
	 * @generated
	 */
	Date getBirthDate();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.User#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @see #getBirthDate()
	 * @generated
	 */
	void setBirthDate(Date value);

	/**
	 * Returns the value of the '<em><b>Sex</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.emfjson.junit.model.Sex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex</em>' attribute.
	 * @see org.eclipselabs.emfjson.junit.model.Sex
	 * @see #setSex(Sex)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_Sex()
	 * @model
	 * @generated
	 */
	Sex getSex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.User#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sex</em>' attribute.
	 * @see org.eclipselabs.emfjson.junit.model.Sex
	 * @see #getSex()
	 * @generated
	 */
	void setSex(Sex value);

	/**
	 * Returns the value of the '<em><b>Friends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.emfjson.junit.model.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Friends</em>' reference list.
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_Friends()
	 * @model resolveProxies="false"
	 * @generated
	 */
	EList<User> getFriends();

	/**
	 * Returns the value of the '<em><b>Unique Friend</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Friend</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Friend</em>' reference.
	 * @see #setUniqueFriend(User)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_UniqueFriend()
	 * @model resolveProxies="false"
	 * @generated
	 */
	User getUniqueFriend();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.User#getUniqueFriend <em>Unique Friend</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique Friend</em>' reference.
	 * @see #getUniqueFriend()
	 * @generated
	 */
	void setUniqueFriend(User value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see org.eclipselabs.emfjson.junit.model.ModelPackage#getUser_Address()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.eclipselabs.emfjson.junit.model.User#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

} // User
