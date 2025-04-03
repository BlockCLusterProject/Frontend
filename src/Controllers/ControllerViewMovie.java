package Controllers;

import ApiServices.ClientService;

import Models.Movie;

import java.util.ArrayList;

public class ControllerViewMovie {

    private ArrayList<Movie> carrito;
    private ClientService service;


    public ControllerViewMovie() {
    	carrito = new ArrayList<>();
        service = new ClientService();
    }

    public void agregarCarrito(Movie pelicula) {
        carrito.add(pelicula);
        for(Movie p : carrito) {
            System.out.println(p);
        }
    }
}
