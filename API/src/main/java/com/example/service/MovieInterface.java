package com.example.service;

import java.util.List;

import com.example.dto.MovieDto;
import com.example.exception.MovieException;
import com.example.model.Category;

public interface MovieInterface {

	public List<MovieDto> getAllMovies() throws MovieException;
	public List<Category> getAllCategories() throws MovieException;
	public MovieDto saveMovie(final MovieDto movieDto ) throws MovieException;
	public void updateMovie(final MovieDto movieDto ) throws MovieException;
	public void deleteMovie(final Long movieId ) throws MovieException;
	public void addOrRemoveMovieToCollection(final Long movieId ) throws MovieException;



	
}
