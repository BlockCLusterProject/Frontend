package controladores.FrontEnd;

import modelos.Movie;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaPelicula {

    private Serializadora serializadora;
    private ArrayList<Movie> carrito;


    public ControladorVistaPelicula() {
        serializadora = new Serializadora();
        carrito = serializadora.leerCarrito();
    }

    public void agregarCarrito(Movie pelicula) {
        carrito.add(pelicula);
        serializadora.guardarCarrito(carrito);
        for(Movie p : carrito) {
            System.out.println(p);
        }
        System.out.println("Guarda en carrito");
    }
}
