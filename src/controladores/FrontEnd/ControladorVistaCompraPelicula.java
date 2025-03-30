package controladores.FrontEnd;

import modelos.Movie;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaCompraPelicula {
    private Serializadora serializadora;
    private ArrayList<Movie> carrito;

    public ControladorVistaCompraPelicula() {
        serializadora = new Serializadora();
        carrito = serializadora.leerCarrito();
    }

    public ArrayList<Movie> getCarrito() {
        return carrito;
    }
}
