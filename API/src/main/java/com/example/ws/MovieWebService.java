package com.example.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.MovieDto;
import com.example.exception.MovieException;
import com.example.model.Category;
import com.example.result.ErrorResult;
import com.example.result.Result;
import com.example.result.SuccessResult;
import com.example.service.MovieInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieWebService {

	
	@Autowired
	private MovieInterface movieInterface;

	/*
	 * récupérer la liste des films
	 */

	public ResponseEntity<Result> getAllMovies()  {
	
		try {
			List<MovieDto> moviesDto=movieInterface.getAllMovies();
            return new ResponseEntity<Result>(new SuccessResult(moviesDto), HttpStatus.OK);

			
		} catch (MovieException e) {
			log.debug("error while retrieving movies list" + e.getMessage());
            return new ResponseEntity<Result>(new ErrorResult(e.getMessage()), HttpStatus.CONFLICT);

		}
		
	}

	public ResponseEntity<Result> getAllCategories()  {
		try {
			List<Category> category=movieInterface.getAllCategories();
            return new ResponseEntity<Result>(new SuccessResult(category), HttpStatus.OK);

			
		} catch (MovieException e) {
			log.debug("error while retrieving categories list" + e.getMessage());
            return new ResponseEntity<Result>(new ErrorResult(e.getMessage()), HttpStatus.CONFLICT);

		}
	}

	/**
	 * sauvegarder un film  
	 */
	
	public ResponseEntity<Result> saveMovie(final MovieDto movieDto ) {
		
		try {
			MovieDto movie =movieInterface.saveMovie(movieDto);
            return new ResponseEntity<Result>(new SuccessResult(movie), HttpStatus.OK);

			
		} catch (MovieException e) {
			log.debug("error while save movie" + e.getMessage());
            return new ResponseEntity<Result>(new ErrorResult(e.getMessage()), HttpStatus.CONFLICT);
		}
	
	}


	/**
	 * mettre à jour un film
	 */

	public ResponseEntity<Result>  updateMovie(final MovieDto movieDto) {
		
		try {
			movieInterface.updateMovie(movieDto);
            return new ResponseEntity<Result>(new SuccessResult(), HttpStatus.OK);

			
		} catch (MovieException e) {
			log.debug("error while update movie" + e.getMessage());
            return new ResponseEntity<Result>(new ErrorResult(e.getMessage()), HttpStatus.CONFLICT);
		}	
	
	}


	/**
	 * supprimer un film
	 */
	public ResponseEntity<Result> deleteMovie(final Long movieId)  {
		try {
			movieInterface.deleteMovie(movieId);
            return new ResponseEntity<Result>(new SuccessResult(), HttpStatus.OK);
			
		} catch (MovieException e) {
			log.debug("error while delete movie" + e.getMessage());
            return new ResponseEntity<Result>(new ErrorResult(e.getMessage()), HttpStatus.CONFLICT);
		}	

	}

	/**
	 * ajouter un film dans la collection
	 */

	public ResponseEntity<Result> addOrRemoveMovieToCollection(final Long movieId) {
		
		try {
			movieInterface.addOrRemoveMovieToCollection(movieId);
            return new ResponseEntity<Result>(new SuccessResult(), HttpStatus.OK);
			
		} catch (MovieException e) {
			log.debug("error while add or remove movie to collection" + e.getMessage());
            return new ResponseEntity<Result>(new ErrorResult(e.getMessage()), HttpStatus.CONFLICT);
		}	
	}
	
}
