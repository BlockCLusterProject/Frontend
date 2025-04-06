package Controllers;

import Models.Movie;
import persistence.Serializer;

import java.util.ArrayList;
import java.util.List;

public class ControllerViewMoviePurchase {
    private List<Movie> carrito;
    private Serializer serializer;

    public ControllerViewMoviePurchase() {
    	serializer = new Serializer();
    	carrito = serializer.readShoppingCar();
    }

    public List<Movie> getCarrito() {
        return carrito;
    }
}
