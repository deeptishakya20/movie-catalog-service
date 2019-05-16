package com.capgemini.moviecatalogservice.entity;

public class MovieCatalog {

	private String movieName;
	private String movieDescription;
	private int movieRating;
	
	public MovieCatalog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieCatalog(String movieName, String movieDescription, int movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	
	

}
