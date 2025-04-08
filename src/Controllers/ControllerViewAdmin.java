/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ApiServices.AdminService;
import Models.Genre;
import Models.Movie;

/**
 *
 * @author Dell
 */
public class ControllerViewAdmin {
	private AdminService service;
	private List<Movie> peliculas;
	public ControllerViewAdmin() {
		service = new AdminService();
	}

	public List<Movie> generateMovies(int genre){
		peliculas = service.getAvailableMovies(genre);
		return this.peliculas;
	}

	public List<Movie> getPeliculas() {
		return peliculas;
	}
	
	public List<Movie> getTrendingMovies(){
		List<Movie> trendingMovies = service.getTrendingMovies();
		return trendingMovies;
	}
	
	public boolean updateMovie(int idMovie, Movie movie) {
		return service.updateMovie(idMovie, movie);
	}
}
