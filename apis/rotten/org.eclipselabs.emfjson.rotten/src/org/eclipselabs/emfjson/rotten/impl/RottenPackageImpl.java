/**
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 * 
 */
package org.eclipselabs.emfjson.rotten.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipselabs.emfjson.rotten.Cast;
import org.eclipselabs.emfjson.rotten.Movie;
import org.eclipselabs.emfjson.rotten.Movies;
import org.eclipselabs.emfjson.rotten.Poster;
import org.eclipselabs.emfjson.rotten.Rating;
import org.eclipselabs.emfjson.rotten.Release;
import org.eclipselabs.emfjson.rotten.Review;
import org.eclipselabs.emfjson.rotten.ReviewLink;
import org.eclipselabs.emfjson.rotten.Reviews;
import org.eclipselabs.emfjson.rotten.RottenFactory;
import org.eclipselabs.emfjson.rotten.RottenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RottenPackageImpl extends EPackageImpl implements RottenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moviesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass releaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ratingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass posterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass castEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reviewsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reviewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reviewLinkEClass = null;

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
	 * @see org.eclipselabs.emfjson.rotten.RottenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RottenPackageImpl() {
		super(eNS_URI, RottenFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RottenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RottenPackage init() {
		if (isInited) return (RottenPackage)EPackage.Registry.INSTANCE.getEPackage(RottenPackage.eNS_URI);

		// Obtain or create and register package
		RottenPackageImpl theRottenPackage = (RottenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RottenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RottenPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theRottenPackage.createPackageContents();

		// Initialize created meta-data
		theRottenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRottenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RottenPackage.eNS_URI, theRottenPackage);
		return theRottenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovies() {
		return moviesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovies_Total() {
		return (EAttribute)moviesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovies_Movies() {
		return (EReference)moviesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovie() {
		return movieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Id() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Title() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Year() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Runtime() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Synopsis() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovie_Releases() {
		return (EReference)movieEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovie_Ratings() {
		return (EReference)movieEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovie_Posters() {
		return (EReference)movieEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovie_Castings() {
		return (EReference)movieEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelease() {
		return releaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelease_Theater() {
		return (EAttribute)releaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelease_Dvd() {
		return (EAttribute)releaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRating() {
		return ratingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRating_CriticsScore() {
		return (EAttribute)ratingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRating_AudienceScore() {
		return (EAttribute)ratingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoster() {
		return posterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoster_Thumbnail() {
		return (EAttribute)posterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoster_Profile() {
		return (EAttribute)posterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoster_Detailed() {
		return (EAttribute)posterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoster_Original() {
		return (EAttribute)posterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCast() {
		return castEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCast_Name() {
		return (EAttribute)castEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCast_Characters() {
		return (EAttribute)castEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReviews() {
		return reviewsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReviews_Reviews() {
		return (EReference)reviewsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReview() {
		return reviewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReview_Critic() {
		return (EAttribute)reviewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReview_Date() {
		return (EAttribute)reviewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReview_Publication() {
		return (EAttribute)reviewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReview_Quote() {
		return (EAttribute)reviewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReview_Links() {
		return (EReference)reviewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReviewLink() {
		return reviewLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReviewLink_ReviewLink() {
		return (EAttribute)reviewLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RottenFactory getRottenFactory() {
		return (RottenFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		moviesEClass = createEClass(MOVIES);
		createEAttribute(moviesEClass, MOVIES__TOTAL);
		createEReference(moviesEClass, MOVIES__MOVIES);

		movieEClass = createEClass(MOVIE);
		createEAttribute(movieEClass, MOVIE__ID);
		createEAttribute(movieEClass, MOVIE__TITLE);
		createEAttribute(movieEClass, MOVIE__YEAR);
		createEAttribute(movieEClass, MOVIE__RUNTIME);
		createEAttribute(movieEClass, MOVIE__SYNOPSIS);
		createEReference(movieEClass, MOVIE__RELEASES);
		createEReference(movieEClass, MOVIE__RATINGS);
		createEReference(movieEClass, MOVIE__POSTERS);
		createEReference(movieEClass, MOVIE__CASTINGS);

		releaseEClass = createEClass(RELEASE);
		createEAttribute(releaseEClass, RELEASE__THEATER);
		createEAttribute(releaseEClass, RELEASE__DVD);

		ratingEClass = createEClass(RATING);
		createEAttribute(ratingEClass, RATING__CRITICS_SCORE);
		createEAttribute(ratingEClass, RATING__AUDIENCE_SCORE);

		posterEClass = createEClass(POSTER);
		createEAttribute(posterEClass, POSTER__THUMBNAIL);
		createEAttribute(posterEClass, POSTER__PROFILE);
		createEAttribute(posterEClass, POSTER__DETAILED);
		createEAttribute(posterEClass, POSTER__ORIGINAL);

		castEClass = createEClass(CAST);
		createEAttribute(castEClass, CAST__NAME);
		createEAttribute(castEClass, CAST__CHARACTERS);

		reviewsEClass = createEClass(REVIEWS);
		createEReference(reviewsEClass, REVIEWS__REVIEWS);

		reviewEClass = createEClass(REVIEW);
		createEAttribute(reviewEClass, REVIEW__CRITIC);
		createEAttribute(reviewEClass, REVIEW__DATE);
		createEAttribute(reviewEClass, REVIEW__PUBLICATION);
		createEAttribute(reviewEClass, REVIEW__QUOTE);
		createEReference(reviewEClass, REVIEW__LINKS);

		reviewLinkEClass = createEClass(REVIEW_LINK);
		createEAttribute(reviewLinkEClass, REVIEW_LINK__REVIEW_LINK);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(moviesEClass, Movies.class, "Movies", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovies_Total(), ecorePackage.getEIntegerObject(), "total", null, 0, 1, Movies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovies_Movies(), this.getMovie(), null, "movies", null, 0, -1, Movies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(movieEClass, Movie.class, "Movie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovie_Id(), ecorePackage.getEString(), "id", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Title(), ecorePackage.getEString(), "title", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Year(), ecorePackage.getEIntegerObject(), "year", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Runtime(), ecorePackage.getEIntegerObject(), "runtime", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Synopsis(), ecorePackage.getEString(), "synopsis", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovie_Releases(), this.getRelease(), null, "releases", null, 0, -1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovie_Ratings(), this.getRating(), null, "ratings", null, 0, -1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovie_Posters(), this.getPoster(), null, "posters", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovie_Castings(), this.getCast(), null, "castings", null, 0, -1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(releaseEClass, Release.class, "Release", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelease_Theater(), ecorePackage.getEString(), "theater", null, 0, 1, Release.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelease_Dvd(), ecorePackage.getEString(), "dvd", null, 0, 1, Release.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ratingEClass, Rating.class, "Rating", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRating_CriticsScore(), ecorePackage.getEIntegerObject(), "criticsScore", null, 0, 1, Rating.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRating_AudienceScore(), ecorePackage.getEIntegerObject(), "audienceScore", null, 0, 1, Rating.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(posterEClass, Poster.class, "Poster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoster_Thumbnail(), ecorePackage.getEString(), "thumbnail", null, 0, 1, Poster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoster_Profile(), ecorePackage.getEString(), "profile", null, 0, 1, Poster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoster_Detailed(), ecorePackage.getEString(), "detailed", null, 0, 1, Poster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoster_Original(), ecorePackage.getEString(), "original", null, 0, 1, Poster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(castEClass, Cast.class, "Cast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCast_Name(), ecorePackage.getEString(), "name", null, 0, 1, Cast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCast_Characters(), ecorePackage.getEString(), "characters", null, 0, -1, Cast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reviewsEClass, Reviews.class, "Reviews", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReviews_Reviews(), this.getReview(), null, "reviews", null, 0, 1, Reviews.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reviewEClass, Review.class, "Review", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReview_Critic(), ecorePackage.getEString(), "critic", null, 0, 1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReview_Date(), ecorePackage.getEString(), "date", null, 0, 1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReview_Publication(), ecorePackage.getEString(), "publication", null, 0, 1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReview_Quote(), ecorePackage.getEString(), "quote", null, 0, 1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReview_Links(), this.getReviewLink(), null, "links", null, 0, -1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reviewLinkEClass, ReviewLink.class, "ReviewLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReviewLink_ReviewLink(), ecorePackage.getEString(), "reviewLink", null, 0, 1, ReviewLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// JSON
		createJSONAnnotations();
	}

	/**
	 * Initializes the annotations for <b>JSON</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createJSONAnnotations() {
		String source = "JSON";		
		addAnnotation
		  (moviesEClass, 
		   source, 
		   new String[] {
			 "root", "true"
		   });		
		addAnnotation
		  (getMovies_Movies(), 
		   source, 
		   new String[] {
			 "element", "movies"
		   });		
		addAnnotation
		  (getMovie_Releases(), 
		   source, 
		   new String[] {
			 "element", "release_dates"
		   });		
		addAnnotation
		  (getMovie_Castings(), 
		   source, 
		   new String[] {
			 "element", "abridged_cast"
		   });		
		addAnnotation
		  (getRating_CriticsScore(), 
		   source, 
		   new String[] {
			 "element", "critics_score"
		   });		
		addAnnotation
		  (getRating_AudienceScore(), 
		   source, 
		   new String[] {
			 "element", "audience_score"
		   });		
		addAnnotation
		  (reviewsEClass, 
		   source, 
		   new String[] {
			 "root", "true"
		   });		
		addAnnotation
		  (getReviews_Reviews(), 
		   source, 
		   new String[] {
			 "element", "reviews"
		   });
	}

} //RottenPackageImpl
