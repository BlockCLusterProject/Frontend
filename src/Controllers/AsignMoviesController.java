/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.List;

import Models.Movie;

/**
 *
 * @author Dell
 */
public class AsignMoviesController {
	private List<Movie> movies;
    public AsignMoviesController(List<Movie> movies) {
    	this.movies = movies;
    }
    
    public List<Movie> getMovies() {
    	return movies;
    }
    
    public void setMovies(List<Movie> movies) {
    	this.movies = movies;
    }
}
