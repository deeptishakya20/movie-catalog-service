package com.capgemini.moviecatalogservice.entity;

public class Movie {
	
	private int movieId;
	private String movieTitle;
	private String moviewDescription;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(int movieId, String movieTitle, String moviewDescription) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.moviewDescription = moviewDescription;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieTitle() {
		return movieTitle;
	}


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}


	public String getMoviewDescription() {
		return moviewDescription;
	}


	public void setMoviewDescription(String moviewDescription) {
		this.moviewDescription = moviewDescription;
	}
	
	

}
