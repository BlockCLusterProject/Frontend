package Controllers;

import ApiServices.ClientSerivce;

import Models.Movie;

import java.util.ArrayList;

public class ControllerViewMovie {

    private ArrayList<Movie> carrito;
    private ClientSerivce service;


    public ControllerViewMovie() {
    	carrito = new ArrayList<>();
        service = new ClientSerivce();
    }

    public void agregarCarrito(Movie pelicula) {
        carrito.add(pelicula);
        for(Movie p : carrito) {
            System.out.println(p);
        }
    }
}
