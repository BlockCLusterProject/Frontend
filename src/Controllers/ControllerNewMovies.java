/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import ApiServices.AdminService;
import Models.Movie;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ControllerNewMovies {

    private int PELICULAS_POR_FILA = 4;
    private AdminService service;
    private List<Movie> movies;
    public ControllerNewMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public List<Movie> getMovies() {
        return this.movies;
    }

    public int getPELICULAS_POR_FILA() {
            return PELICULAS_POR_FILA;
    }
    
    public int getCantidadPeliculas() {
            return movies.size();
    }
    
    public String getTituloByIdx(int idx) {
            return movies.get(idx).getTitle();
    }
    
    public double getPuntuacionByIdx(int idx) {
            return movies.get(idx).getVote_average();
    }
    
    public Movie entregarPelicula(int n) {
            return movies.get(n);
    }
    
    public int getFilas() {
        if (movies.size() <= PELICULAS_POR_FILA) {
                return 1;
        } else {
            int c = 1;
            int filas = movies.size();
            while (filas > PELICULAS_POR_FILA) {
                    c++;
                    filas -= PELICULAS_POR_FILA;
            }
            return c;
        }
    }
}
