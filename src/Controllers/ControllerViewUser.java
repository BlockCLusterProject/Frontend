/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import ApiServices.ClientService;
import Models.Genre;
import Models.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JuanCGallo
 */
public class ControllerViewUser {
    //  TODO: sacar lista de peliculas de una DB o de donde sea
	private List<Movie> peliculas;

	private int PELICULAS_POR_FILA = 4;
	private ClientService service;

	public ControllerViewUser() {
		service = new ClientService();
		peliculas = service.getAvailableMovies();
	}


	public List<Movie> getPeliculas() {
		return peliculas;
	}

	public Movie entregarPelicula(int n) {
		return peliculas.get(n);
	}

	public int getPELICULAS_POR_FILA() {
		return PELICULAS_POR_FILA;
	}

	public int getCantidadPeliculas() {
		return peliculas.size();
	}

	public String getTituloByIdx(int idx) {
		return peliculas.get(idx).getTitulo();
	}

	public double getPuntuacionByIdx(int idx) {
		return peliculas.get(idx).getPuntuacion();
	}

	public int getFilas() {
		if (peliculas.size() <= PELICULAS_POR_FILA) {
			return 1;
		} else {
			int c = 1;
			int filas = peliculas.size();
			while (filas > PELICULAS_POR_FILA) {
				c++;
				filas -= PELICULAS_POR_FILA;
			}
			return c;
		}
	}
}
