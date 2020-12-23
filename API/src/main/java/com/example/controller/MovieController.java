package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MovieDto;

import com.example.result.Result;
import com.example.ws.MovieWebService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin("*")
@RestController
public class MovieController {
	
	
	
	private static final String PREFIXE_URL="/movie";
	private static final String RESSOURCE_ALL_MOVIES= PREFIXE_URL+ "/movies";
	private static final String RESSOURCE_ALL_CATEGORIES= PREFIXE_URL+ "/categories";
	private static final String RESSOURCE_SAVE_MOVIE= PREFIXE_URL+ "/save";
	private static final String RESSOURCE_UPDATE_MOVIE= PREFIXE_URL+ "/update";
	private static final String RESSOURCE_DELETE_MOVIE= PREFIXE_URL+ "/delete/{movieId}";
	private static final String RESSOURCE_ADD_OR_REMOVE_MOVIE_COLLECTION= PREFIXE_URL+ "/addOrRemove/{movieId}";
	
	@Autowired
	private MovieWebService movieWebService;

	@ApiOperation("retourne la liste des films")
	@RequestMapping(value=RESSOURCE_ALL_MOVIES,method=RequestMethod.GET)
	public ResponseEntity<Result> getAllMovies()  {
	
	return movieWebService.getAllMovies();
		
	}
	
	@ApiOperation("retourne la liste des categories")
	@RequestMapping(value=RESSOURCE_ALL_CATEGORIES,method=RequestMethod.GET)
	public ResponseEntity<Result> getAllCategories()  {
		
		return movieWebService.getAllCategories();

	}

	@ApiOperation("sauvegarder un film")
	@RequestMapping(value=RESSOURCE_SAVE_MOVIE,method=RequestMethod.POST)
	public ResponseEntity<Result> saveMovie(@RequestBody final MovieDto movieDto ) {
		
	return movieWebService.saveMovie(movieDto);
	
	}

	@ApiOperation("mettre à jour un film")
	@RequestMapping(value=RESSOURCE_UPDATE_MOVIE,method=RequestMethod.PUT)
	public ResponseEntity<Result> updateMovie(@RequestBody final MovieDto movieDto) {
		
		return movieWebService.updateMovie(movieDto);

	}


	@ApiOperation("supprimer un film")
	@RequestMapping(value=RESSOURCE_DELETE_MOVIE,method=RequestMethod.DELETE)
	public ResponseEntity<Result> deleteMovie(@PathVariable final Long movieId)  {
	
		return movieWebService.deleteMovie(movieId);
	}

	@ApiOperation("ajouter ou supprimer un film de la collection")
	@RequestMapping(value=RESSOURCE_ADD_OR_REMOVE_MOVIE_COLLECTION,method=RequestMethod.PUT)
	public ResponseEntity<Result> addOrRemoveMovieToCollection(@PathVariable final Long movieId) {
		
	return movieWebService.addOrRemoveMovieToCollection(movieId);
	}

}
