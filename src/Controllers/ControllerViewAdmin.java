/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ApiServices.AdminService;
import ApiServices.ClientSerivce;
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

	public List<Movie> generateMovies(int genre, String movieName){
		peliculas = service.getAvailableMovies(genre, movieName);
		return this.peliculas;
	}

	public List<Movie> getPeliculas() {
		return peliculas;
	}
}
