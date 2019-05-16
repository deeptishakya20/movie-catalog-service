package com.capgemini.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.ls.LSInput;

import com.capgemini.moviecatalogservice.entity.Movie;
import com.capgemini.moviecatalogservice.entity.MovieCatalog;
import com.capgemini.moviecatalogservice.entity.Rating;
import com.capgemini.moviecatalogservice.entity.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	

	@GetMapping("/{userId}")
	public ResponseEntity<List<MovieCatalog>>getMovieCatalog(@PathVariable String userId){
		//Get the movie ratings for the user.
		UserRating userRatings = 
				restTemplate.getForEntity("http://MOVIE-RATING-SERVICE/ratings/" +userId, UserRating.class).getBody();
		
		List<Rating> movieRatings = userRatings.getUserRatings();
		List<MovieCatalog> movieCatalog = new ArrayList<MovieCatalog>();
		
		
		//Get the movie information and creating movie catalog
		for(Rating rating:movieRatings) {
		Movie movie = restTemplate.getForEntity("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(), Movie.class).getBody();
		
		
		
		//Combine and return MovieCatatlog
		movieCatalog.add(new MovieCatalog(movie.getMovieTitle(), movie.getMoviewDescription(),rating.getRating()));
		}
		
		return new ResponseEntity<List<MovieCatalog>>(movieCatalog, HttpStatus.OK);
	}
	
}
