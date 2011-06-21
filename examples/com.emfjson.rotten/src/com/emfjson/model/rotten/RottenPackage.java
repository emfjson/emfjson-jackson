/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.emfjson.model.rotten;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.emfjson.model.rotten.RottenFactory
 * @model kind="package"
 * @generated
 */
public interface RottenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rotten";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/rottentomatoes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rotten";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RottenPackage eINSTANCE = com.emfjson.model.rotten.impl.RottenPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.emfjson.model.rotten.impl.MovieImpl <em>Movie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.rotten.impl.MovieImpl
	 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getMovie()
	 * @generated
	 */
	int MOVIE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__ID = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__YEAR = 2;

	/**
	 * The feature id for the '<em><b>Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__RUNTIME = 3;

	/**
	 * The feature id for the '<em><b>Synopsis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__SYNOPSIS = 4;

	/**
	 * The feature id for the '<em><b>Releases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__RELEASES = 5;

	/**
	 * The feature id for the '<em><b>Ratings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__RATINGS = 6;

	/**
	 * The feature id for the '<em><b>Posters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__POSTERS = 7;

	/**
	 * The feature id for the '<em><b>Castings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__CASTINGS = 8;

	/**
	 * The number of structural features of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.emfjson.model.rotten.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.rotten.impl.ReleaseImpl
	 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 1;

	/**
	 * The feature id for the '<em><b>Theater</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__THEATER = 0;

	/**
	 * The feature id for the '<em><b>Dvd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__DVD = 1;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.emfjson.model.rotten.impl.RatingImpl <em>Rating</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.rotten.impl.RatingImpl
	 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getRating()
	 * @generated
	 */
	int RATING = 2;

	/**
	 * The feature id for the '<em><b>Critics Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATING__CRITICS_SCORE = 0;

	/**
	 * The feature id for the '<em><b>Audience Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATING__AUDIENCE_SCORE = 1;

	/**
	 * The number of structural features of the '<em>Rating</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.emfjson.model.rotten.impl.PosterImpl <em>Poster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.rotten.impl.PosterImpl
	 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getPoster()
	 * @generated
	 */
	int POSTER = 3;

	/**
	 * The feature id for the '<em><b>Thumbnail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTER__THUMBNAIL = 0;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTER__PROFILE = 1;

	/**
	 * The feature id for the '<em><b>Detailed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTER__DETAILED = 2;

	/**
	 * The feature id for the '<em><b>Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTER__ORIGINAL = 3;

	/**
	 * The number of structural features of the '<em>Poster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.emfjson.model.rotten.impl.CastImpl <em>Cast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.emfjson.model.rotten.impl.CastImpl
	 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getCast()
	 * @generated
	 */
	int CAST = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__NAME = 0;

	/**
	 * The feature id for the '<em><b>Characters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__CHARACTERS = 1;

	/**
	 * The number of structural features of the '<em>Cast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.emfjson.model.rotten.Movie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movie</em>'.
	 * @see com.emfjson.model.rotten.Movie
	 * @generated
	 */
	EClass getMovie();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Movie#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.emfjson.model.rotten.Movie#getId()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Movie#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.emfjson.model.rotten.Movie#getTitle()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Title();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Movie#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see com.emfjson.model.rotten.Movie#getYear()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Year();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Movie#getRuntime <em>Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runtime</em>'.
	 * @see com.emfjson.model.rotten.Movie#getRuntime()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Runtime();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Movie#getSynopsis <em>Synopsis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synopsis</em>'.
	 * @see com.emfjson.model.rotten.Movie#getSynopsis()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Synopsis();

	/**
	 * Returns the meta object for the containment reference list '{@link com.emfjson.model.rotten.Movie#getReleases <em>Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Releases</em>'.
	 * @see com.emfjson.model.rotten.Movie#getReleases()
	 * @see #getMovie()
	 * @generated
	 */
	EReference getMovie_Releases();

	/**
	 * Returns the meta object for the containment reference list '{@link com.emfjson.model.rotten.Movie#getRatings <em>Ratings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ratings</em>'.
	 * @see com.emfjson.model.rotten.Movie#getRatings()
	 * @see #getMovie()
	 * @generated
	 */
	EReference getMovie_Ratings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.emfjson.model.rotten.Movie#getPosters <em>Posters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Posters</em>'.
	 * @see com.emfjson.model.rotten.Movie#getPosters()
	 * @see #getMovie()
	 * @generated
	 */
	EReference getMovie_Posters();

	/**
	 * Returns the meta object for the containment reference list '{@link com.emfjson.model.rotten.Movie#getCastings <em>Castings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Castings</em>'.
	 * @see com.emfjson.model.rotten.Movie#getCastings()
	 * @see #getMovie()
	 * @generated
	 */
	EReference getMovie_Castings();

	/**
	 * Returns the meta object for class '{@link com.emfjson.model.rotten.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see com.emfjson.model.rotten.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Release#getTheater <em>Theater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theater</em>'.
	 * @see com.emfjson.model.rotten.Release#getTheater()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Theater();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Release#getDvd <em>Dvd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dvd</em>'.
	 * @see com.emfjson.model.rotten.Release#getDvd()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Dvd();

	/**
	 * Returns the meta object for class '{@link com.emfjson.model.rotten.Rating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rating</em>'.
	 * @see com.emfjson.model.rotten.Rating
	 * @generated
	 */
	EClass getRating();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Rating#getCriticsScore <em>Critics Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Critics Score</em>'.
	 * @see com.emfjson.model.rotten.Rating#getCriticsScore()
	 * @see #getRating()
	 * @generated
	 */
	EAttribute getRating_CriticsScore();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Rating#getAudienceScore <em>Audience Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audience Score</em>'.
	 * @see com.emfjson.model.rotten.Rating#getAudienceScore()
	 * @see #getRating()
	 * @generated
	 */
	EAttribute getRating_AudienceScore();

	/**
	 * Returns the meta object for class '{@link com.emfjson.model.rotten.Poster <em>Poster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Poster</em>'.
	 * @see com.emfjson.model.rotten.Poster
	 * @generated
	 */
	EClass getPoster();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Poster#getThumbnail <em>Thumbnail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thumbnail</em>'.
	 * @see com.emfjson.model.rotten.Poster#getThumbnail()
	 * @see #getPoster()
	 * @generated
	 */
	EAttribute getPoster_Thumbnail();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Poster#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile</em>'.
	 * @see com.emfjson.model.rotten.Poster#getProfile()
	 * @see #getPoster()
	 * @generated
	 */
	EAttribute getPoster_Profile();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Poster#getDetailed <em>Detailed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detailed</em>'.
	 * @see com.emfjson.model.rotten.Poster#getDetailed()
	 * @see #getPoster()
	 * @generated
	 */
	EAttribute getPoster_Detailed();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Poster#getOriginal <em>Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original</em>'.
	 * @see com.emfjson.model.rotten.Poster#getOriginal()
	 * @see #getPoster()
	 * @generated
	 */
	EAttribute getPoster_Original();

	/**
	 * Returns the meta object for class '{@link com.emfjson.model.rotten.Cast <em>Cast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cast</em>'.
	 * @see com.emfjson.model.rotten.Cast
	 * @generated
	 */
	EClass getCast();

	/**
	 * Returns the meta object for the attribute '{@link com.emfjson.model.rotten.Cast#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.emfjson.model.rotten.Cast#getName()
	 * @see #getCast()
	 * @generated
	 */
	EAttribute getCast_Name();

	/**
	 * Returns the meta object for the attribute list '{@link com.emfjson.model.rotten.Cast#getCharacters <em>Characters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Characters</em>'.
	 * @see com.emfjson.model.rotten.Cast#getCharacters()
	 * @see #getCast()
	 * @generated
	 */
	EAttribute getCast_Characters();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RottenFactory getRottenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.emfjson.model.rotten.impl.MovieImpl <em>Movie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.rotten.impl.MovieImpl
		 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getMovie()
		 * @generated
		 */
		EClass MOVIE = eINSTANCE.getMovie();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__ID = eINSTANCE.getMovie_Id();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__TITLE = eINSTANCE.getMovie_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__YEAR = eINSTANCE.getMovie_Year();

		/**
		 * The meta object literal for the '<em><b>Runtime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__RUNTIME = eINSTANCE.getMovie_Runtime();

		/**
		 * The meta object literal for the '<em><b>Synopsis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__SYNOPSIS = eINSTANCE.getMovie_Synopsis();

		/**
		 * The meta object literal for the '<em><b>Releases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE__RELEASES = eINSTANCE.getMovie_Releases();

		/**
		 * The meta object literal for the '<em><b>Ratings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE__RATINGS = eINSTANCE.getMovie_Ratings();

		/**
		 * The meta object literal for the '<em><b>Posters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE__POSTERS = eINSTANCE.getMovie_Posters();

		/**
		 * The meta object literal for the '<em><b>Castings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE__CASTINGS = eINSTANCE.getMovie_Castings();

		/**
		 * The meta object literal for the '{@link com.emfjson.model.rotten.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.rotten.impl.ReleaseImpl
		 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '<em><b>Theater</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__THEATER = eINSTANCE.getRelease_Theater();

		/**
		 * The meta object literal for the '<em><b>Dvd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__DVD = eINSTANCE.getRelease_Dvd();

		/**
		 * The meta object literal for the '{@link com.emfjson.model.rotten.impl.RatingImpl <em>Rating</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.rotten.impl.RatingImpl
		 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getRating()
		 * @generated
		 */
		EClass RATING = eINSTANCE.getRating();

		/**
		 * The meta object literal for the '<em><b>Critics Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RATING__CRITICS_SCORE = eINSTANCE.getRating_CriticsScore();

		/**
		 * The meta object literal for the '<em><b>Audience Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RATING__AUDIENCE_SCORE = eINSTANCE.getRating_AudienceScore();

		/**
		 * The meta object literal for the '{@link com.emfjson.model.rotten.impl.PosterImpl <em>Poster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.rotten.impl.PosterImpl
		 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getPoster()
		 * @generated
		 */
		EClass POSTER = eINSTANCE.getPoster();

		/**
		 * The meta object literal for the '<em><b>Thumbnail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTER__THUMBNAIL = eINSTANCE.getPoster_Thumbnail();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTER__PROFILE = eINSTANCE.getPoster_Profile();

		/**
		 * The meta object literal for the '<em><b>Detailed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTER__DETAILED = eINSTANCE.getPoster_Detailed();

		/**
		 * The meta object literal for the '<em><b>Original</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTER__ORIGINAL = eINSTANCE.getPoster_Original();

		/**
		 * The meta object literal for the '{@link com.emfjson.model.rotten.impl.CastImpl <em>Cast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.emfjson.model.rotten.impl.CastImpl
		 * @see com.emfjson.model.rotten.impl.RottenPackageImpl#getCast()
		 * @generated
		 */
		EClass CAST = eINSTANCE.getCast();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAST__NAME = eINSTANCE.getCast_Name();

		/**
		 * The meta object literal for the '<em><b>Characters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAST__CHARACTERS = eINSTANCE.getCast_Characters();

	}

} //RottenPackage
