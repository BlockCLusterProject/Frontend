package Controllers;

import ApiServices.ClientService;

import Models.Movie;
import persistence.Serializer;

import java.util.ArrayList;
import java.util.List;

public class ControllerViewMovie {

    private List<Movie> carrito;
    private ClientService service;
    private Serializer serializer;


    public ControllerViewMovie() {
        service = new ClientService();
        serializer = new Serializer();
    	carrito = serializer.readShoppingCar();
    }

    public void agregarCarrito(Movie pelicula) {
        carrito.add(pelicula);
        serializer.saveShoppingCar(carrito);
    }
}
