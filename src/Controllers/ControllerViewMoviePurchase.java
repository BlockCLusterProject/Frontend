package Controllers;

import Models.Movie;

import java.util.ArrayList;

public class ControllerViewMoviePurchase {
    private ArrayList<Movie> carrito;

    public ControllerViewMoviePurchase() {
    	carrito = new ArrayList<>();
    }

    public ArrayList<Movie> getCarrito() {
        return carrito;
    }
}
