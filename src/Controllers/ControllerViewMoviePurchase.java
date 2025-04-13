package Controllers;

import Models.Movie;
import persistence.Serializer;

import java.util.ArrayList;
import java.util.List;

import ApiServices.ClientService;

public class ControllerViewMoviePurchase {
    private List<Movie> carrito;
    private Serializer serializer;
    private ClientService service;

    public ControllerViewMoviePurchase() {
    	serializer = new Serializer();
    	carrito = serializer.readShoppingCar();
    	this.service = new ClientService();
    }

    public List<Movie> getCarrito() {
        return carrito;
    }
    
    public void vaciarCarrito() {
        carrito.clear();
        serializer.saveShoppingCar(carrito);
    }
    
    public String generateQr(String message) {
    	return service.generateQr(message);
    }
}
