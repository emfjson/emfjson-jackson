/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.model.rotten;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.emfjson.model.rotten.Movie#getId <em>Id</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getTitle <em>Title</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getYear <em>Year</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getRuntime <em>Runtime</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getSynopsis <em>Synopsis</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getReleases <em>Releases</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getRatings <em>Ratings</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getPosters <em>Posters</em>}</li>
 *   <li>{@link com.emfjson.model.rotten.Movie#getCastings <em>Castings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.emfjson.model.rotten.RottenPackage#getMovie()
 * @model annotation="JSON root='true' element='movies'"
 * @generated
 */
public interface Movie extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Movie#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Movie#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(Integer)
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Year()
	 * @model
	 * @generated
	 */
	Integer getYear();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Movie#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(Integer value);

	/**
	 * Returns the value of the '<em><b>Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime</em>' attribute.
	 * @see #setRuntime(Integer)
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Runtime()
	 * @model
	 * @generated
	 */
	Integer getRuntime();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Movie#getRuntime <em>Runtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime</em>' attribute.
	 * @see #getRuntime()
	 * @generated
	 */
	void setRuntime(Integer value);

	/**
	 * Returns the value of the '<em><b>Synopsis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synopsis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synopsis</em>' attribute.
	 * @see #setSynopsis(String)
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Synopsis()
	 * @model
	 * @generated
	 */
	String getSynopsis();

	/**
	 * Sets the value of the '{@link com.emfjson.model.rotten.Movie#getSynopsis <em>Synopsis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synopsis</em>' attribute.
	 * @see #getSynopsis()
	 * @generated
	 */
	void setSynopsis(String value);

	/**
	 * Returns the value of the '<em><b>Releases</b></em>' containment reference list.
	 * The list contents are of type {@link com.emfjson.model.rotten.Release}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Releases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Releases</em>' containment reference list.
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Releases()
	 * @model containment="true"
	 *        annotation="JSON element='release_dates'"
	 * @generated
	 */
	EList<Release> getReleases();

	/**
	 * Returns the value of the '<em><b>Ratings</b></em>' containment reference list.
	 * The list contents are of type {@link com.emfjson.model.rotten.Rating}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ratings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ratings</em>' containment reference list.
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Ratings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rating> getRatings();

	/**
	 * Returns the value of the '<em><b>Posters</b></em>' containment reference list.
	 * The list contents are of type {@link com.emfjson.model.rotten.Poster}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Posters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Posters</em>' containment reference list.
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Posters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Poster> getPosters();

	/**
	 * Returns the value of the '<em><b>Castings</b></em>' containment reference list.
	 * The list contents are of type {@link com.emfjson.model.rotten.Cast}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Castings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Castings</em>' containment reference list.
	 * @see com.emfjson.model.rotten.RottenPackage#getMovie_Castings()
	 * @model containment="true"
	 *        annotation="JSON element='abridged_cast'"
	 * @generated
	 */
	EList<Cast> getCastings();

} // Movie
