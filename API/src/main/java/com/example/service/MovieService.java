package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CategoryDao;
import com.example.dao.MovieDao;
import com.example.dto.MovieDto;
import com.example.dto.PersonDto;
import com.example.exception.MovieException;
import com.example.model.Category;
import com.example.model.Movie;


@Service
public class MovieService implements MovieInterface{

	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private CategoryDao categoryDao;

	
	/*
	 * récupérer la liste des films
	 */

	@Override
	public List<MovieDto> getAllMovies() throws MovieException {
		 List<Movie> movies=movieDao.findAll();
		 
		 if (movies.isEmpty()) { 
			 throw new MovieException("No movies found in the database"); 
		 }
		 
			 List<MovieDto> moviesDto=new ArrayList<>();
			 movies.forEach(movie->{
				 MovieDto  movieDto=new MovieDto();
				 PersonDto  personDto=new PersonDto();
				 movieDto.setId(movie.getId());
				 movieDto.setTitle(movie.getTitle());
				 movieDto.setLanguage(movie.getLanguage());
				 movieDto.setRecordedYear(movie.getRecordedYear());
				 movieDto.setImage(movie.getImage());
				 personDto.setFirstName(movie.getFirstName());
				 personDto.setLastName(movie.getLastName());
				 movieDto.setSpecialMention(personDto);
				 movieDto.setDescription(movie.getDescription());
				 movieDto.setSelected(movie.isSelected());
				 movieDto.setCategoryId(movie.getCategory().getId());
				 moviesDto.add(movieDto);
			 });
			 return moviesDto;
	}
	

	@Override
	public List<Category> getAllCategories() throws MovieException {
		 List<Category> categories=categoryDao.findAll();
		 
		 if (categories.isEmpty()) {
			 throw new MovieException("No categories found in the database");
		 } 
		 
		 return categories;
	}


	/**
	 * sauvegarder un film  
	 */
	
	@Override
	public MovieDto saveMovie(final MovieDto movieDto) throws MovieException {
	
		if (movieDto.getCategoryId()==null) {
			throw new MovieException("A movie must be associated with a category");
	}
	Category category=categoryDao.findById(movieDto.getCategoryId()).get();
	
	if (category==null) {
		throw new MovieException ("the category whose id "+movieDto.getCategoryId()+" cannot be found in the database");
	}
	
		System.out.println(movieDto.getTitle());
		
		if (movieDao.findByTitle(movieDto.getTitle())!=null) {
			throw new MovieException("the movie already exists");
		}
		
		Movie movie=new Movie();
		movie.setTitle(movieDto.getTitle());
		movie.setLanguage(movieDto.getLanguage());
		movie.setRecordedYear(movieDto.getRecordedYear());
		movie.setImage(movieDto.getImage());
		movie.setFirstName(movieDto.getSpecialMention().getFirstName());
		movie.setLastName(movieDto.getSpecialMention().getLastName());
		movie.setDescription(movieDto.getDescription());
		movie.setSelected(movieDto.isSelected());
		movie.setCategory(category);
		movieDao.save(movie);
		
		 MovieDto  movieDtoResult=new MovieDto();
		 PersonDto  personDto=new PersonDto();
		 movieDtoResult.setId(movie.getId());
		 movieDtoResult.setTitle(movie.getTitle());
		 movieDtoResult.setLanguage(movie.getLanguage());
		 movieDtoResult.setRecordedYear(movie.getRecordedYear());
		 movieDtoResult.setImage(movie.getImage());
		 personDto.setFirstName(movie.getFirstName());
		 personDto.setLastName(movie.getLastName());
		 movieDtoResult.setSpecialMention(personDto);
		 movieDtoResult.setDescription(movie.getDescription());
		 movieDtoResult.setSelected(movie.isSelected());
		 movieDtoResult.setCategoryId(movie.getCategory().getId());
		return movieDtoResult;
	}


	/**
	 * mettre à jour un film
	 */
	@Override
	public void updateMovie(final MovieDto movieDto) throws MovieException {
		if (movieDto.getCategoryId()==null) {
			throw new MovieException("A movie must be associated with a category");
		}
		
		Category category=categoryDao.findById(movieDto.getCategoryId()).get();
		System.out.println(category);
		
		if (category==null) {
			throw new MovieException("the category whose id "+movieDto.getCategoryId()+" cannot be found in the database");
		}	
		Movie movieById=movieDao.findById(movieDto.getId()).get();
		
		if (movieById==null) {
			throw new MovieException("the movie whose id "+movieDto.getId()+" cannot be found in the database");
		}
		
		movieById.setTitle(movieDto.getTitle());
		movieById.setLanguage(movieDto.getLanguage());
		movieById.setRecordedYear(movieDto.getRecordedYear());
		movieById.setImage(movieDto.getImage());
		movieById.setFirstName(movieDto.getSpecialMention().getFirstName());
		movieById.setLastName(movieDto.getSpecialMention().getLastName());
		movieById.setDescription(movieDto.getDescription());
		movieById.setSelected(movieDto.isSelected());
		movieById.setCategory(category);
		movieDao.save(movieById);

	}


	/**
	 * supprimer un film
	 */
	@Override
	public void deleteMovie(final Long movieId) throws MovieException {

		if (movieId==null) {
			throw new MovieException("the movie id  equal to null");
		}
		Movie movie=movieDao.findById(movieId).get();
		if (movie==null) {
			throw new MovieException("the movie whose id "+ movieId +" cannot be found in the database");
		}
		
		movieDao.delete(movie);
	}

	/**
	 * ajouter un film dans la collection
	 */

	@Override
	public void addOrRemoveMovieToCollection(final Long movieId) throws MovieException {
		if (movieId==null) {
			throw new MovieException("the movie id  equal to null");
		}
		Movie movie=movieDao.findById(movieId).get();
		if (movie==null) {
			throw new MovieException("the movie whose id "+ movieId +" cannot be found in the database");
		}	
		
		movie.setSelected(!movie.isSelected());
		
		movieDao.save(movie);
	}
	


}
