package Controllers;


import Controllers.ControllerViewUser;
import Models.ClientSesion;
import Models.Movie;
import Models.Person;
import Models.PurchaseHistory;
import persistence.Serializer;

import java.util.ArrayList;
import java.util.List;

import ApiServices.ClientService;

public class ControllerViewShoppingCar {
    private List<Movie> carrito;
    private ControllerViewUser controladorVistaUsuario;
    private ClientService service;
    private Serializer serializer;

    public ControllerViewShoppingCar() {
        controladorVistaUsuario = new ControllerViewUser(null);
        service = new ClientService();
        this.serializer = new Serializer();
    	carrito = serializer.readShoppingCar();
    }

    public List<Movie> getCarrito() {
        return carrito;
    }

    public void vaciarCarrito() {
        carrito.clear();
        serializer.saveShoppingCar(carrito);
    }

    public int getFilas() {
        int PELICULAS_POR_FILA = controladorVistaUsuario.getPELICULAS_POR_FILA();
        if (carrito.size() <= PELICULAS_POR_FILA) {
            return 1;
        } else {
            int c = 1;
            int filas = carrito.size();
            while (filas > PELICULAS_POR_FILA) {
                c++;
                filas -= PELICULAS_POR_FILA;
            }
            return c;
        }
    }
    
    public void saveCarrito() {
    	serializer.saveShoppingCar(carrito);
    }
    
    public void buy() {
    	Person client = ClientSesion.getInstance().getClient();
    	for(Movie movie : carrito) {
			PurchaseHistory purchase = new PurchaseHistory(
				client.getId(),
				movie.getId(),
				1,
				movie.getPrice());
			service.addPurchaseHistory(purchase);
    	}
    }

}
