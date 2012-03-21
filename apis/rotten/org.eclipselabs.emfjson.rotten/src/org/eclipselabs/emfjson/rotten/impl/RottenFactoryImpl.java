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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RottenFactoryImpl extends EFactoryImpl implements RottenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RottenFactory init() {
		try {
			RottenFactory theRottenFactory = (RottenFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/rottentomatoes"); 
			if (theRottenFactory != null) {
				return theRottenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RottenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RottenFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RottenPackage.MOVIES: return createMovies();
			case RottenPackage.MOVIE: return createMovie();
			case RottenPackage.RELEASE: return createRelease();
			case RottenPackage.RATING: return createRating();
			case RottenPackage.POSTER: return createPoster();
			case RottenPackage.CAST: return createCast();
			case RottenPackage.REVIEWS: return createReviews();
			case RottenPackage.REVIEW: return createReview();
			case RottenPackage.REVIEW_LINK: return createReviewLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Movies createMovies() {
		MoviesImpl movies = new MoviesImpl();
		return movies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Movie createMovie() {
		MovieImpl movie = new MovieImpl();
		return movie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rating createRating() {
		RatingImpl rating = new RatingImpl();
		return rating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Poster createPoster() {
		PosterImpl poster = new PosterImpl();
		return poster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cast createCast() {
		CastImpl cast = new CastImpl();
		return cast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reviews createReviews() {
		ReviewsImpl reviews = new ReviewsImpl();
		return reviews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Review createReview() {
		ReviewImpl review = new ReviewImpl();
		return review;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReviewLink createReviewLink() {
		ReviewLinkImpl reviewLink = new ReviewLinkImpl();
		return reviewLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RottenPackage getRottenPackage() {
		return (RottenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RottenPackage getPackage() {
		return RottenPackage.eINSTANCE;
	}

} //RottenFactoryImpl
