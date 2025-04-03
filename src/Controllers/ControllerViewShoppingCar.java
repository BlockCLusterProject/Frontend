package Controllers;


import Controllers.ControllerViewUser;
import Models.Movie;

import java.util.ArrayList;

public class ControllerViewShoppingCar {
    private ArrayList<Movie> carrito;
    private ControllerViewUser controladorVistaUsuario;

    public ControllerViewShoppingCar() {
    	carrito = new ArrayList<>();
        controladorVistaUsuario = new ControllerViewUser(null);
    }

    public ArrayList<Movie> getCarrito() {
        return carrito;
    }

    public void vaciarCarrito() {
        carrito.clear();
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

}
