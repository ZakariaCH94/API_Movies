package com.example;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CategoryDao;
import com.example.dao.MovieDao;
import com.example.model.Category;
import com.example.model.Movie;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

//	@Autowired
//	private  CategoryDao categoryDao;
//	@Autowired
//	private  MovieDao movieDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//	Category category=new Category();
//	category.setTitle("French anime");
//	category.setEmojiStyle("emoji-simple-swell");
//	category.setEmoji("simple-swell");
//	categoryDao.save(category);
//	
//	Category category3=new Category();
//	category3.setTitle("Crazy movies");
//	category3.setEmojiStyle("emoji-swell");
//	category3.setEmoji("swell");
//	categoryDao.save(category3);
//	
//	Category category1=new Category();
//	category1.setTitle("Music themed");
//	category1.setEmojiStyle("emoji-rotate");
//	category1.setEmoji("rotate");
//	categoryDao.save(category1);
//	
//	Category category2=new Category();
//	category2.setTitle("Father’s Day");
//	category2.setEmojiStyle("emoji-swell");
//	category2.setEmoji("swell");
//	categoryDao.save(category2);
//		Movie movie=new Movie();
//		movie.setTitle("title");
//		movie.setLanguage("language");
//		movie.setRecordedYear(2000);
//		movie.setImage("image");
//		movie.setDescription("description");
//		movie.setLastName("lastName");
//		movie.setFirstName("firstName");
//		movie.setSelected(false);
//		movie.setCategory(category);
//		movieDao.save(movie);
//
//		Movie movie1=new Movie();
//		movie1.setTitle("title1");
//		movie1.setLanguage("language");
//		movie1.setRecordedYear(2000);
//		movie1.setImage("image");
//		movie1.setDescription("description");
//		movie1.setLastName("lastName");
//		movie1.setFirstName("firstName");
//		movie1.setSelected(false);
//		movie1.setCategory(category);
//		
//		movieDao.save(movie1);
//		
//		List<Movie> movies=new ArrayList<>();
//		movieDao.findAll().forEach(mov->{
//			
//			if (mov.getCategory().getId()==1) {
//				movies.add(mov);
//			}
//			
//		});
//		
//		movies.forEach(mov->{
//			System.out.println(mov.getTitle());
//		});
//		
//	
//	
	
		
	}

}
