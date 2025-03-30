package controladores.FrontEnd;

import modelos.Pelicula;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaCompraPelicula {
    private Serializadora serializadora;
    private ArrayList<Pelicula> carrito;

    public ControladorVistaCompraPelicula() {
        serializadora = new Serializadora();
        carrito = serializadora.leerCarrito();
    }

    public ArrayList<Pelicula> getCarrito() {
        return carrito;
    }
}
