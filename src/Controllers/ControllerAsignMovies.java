/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.List;

import ApiServices.AdminService;
import Models.Movie;

/**
 *
 * @author Dell
 */
public class ControllerAsignMovies {
	private List<Movie> movies;
	private AdminService service;
    public ControllerAsignMovies(List<Movie> movies) {
    	this.movies = movies;
    	service = new AdminService();
    }
    
    public List<Movie> getMovies() {
    	return movies;
    }
    
    public void setMovies(List<Movie> movies) {
    	this.movies = movies;
    }
    
    public void publishNewMovies(List<Movie> movies)  {
    	service.publishMovies(movies);
    }
}
