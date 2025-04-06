package Controllers;


import Controllers.ControllerViewUser;
import Models.Movie;
import persistence.Serializer;

import java.util.ArrayList;
import java.util.List;

public class ControllerViewShoppingCar {
    private List<Movie> carrito;
    private ControllerViewUser controladorVistaUsuario;
    private Serializer serializer;

    public ControllerViewShoppingCar() {
        controladorVistaUsuario = new ControllerViewUser(null);
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

}
