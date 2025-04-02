package controladores.FrontEnd;

import ApiServices.FrontEnd.ClientSerivce;
import modelos.Movie;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaPelicula {

    private Serializadora serializadora;
    private ArrayList<Movie> carrito;
    private ClientSerivce service;


    public ControladorVistaPelicula() {
        serializadora = new Serializadora();
        carrito = serializadora.leerCarrito();
        service = new ClientSerivce();
    }

    public void agregarCarrito(Movie pelicula) {
        carrito.add(pelicula);
        serializadora.guardarCarrito(carrito);
        for(Movie p : carrito) {
            System.out.println(p);
        }
    }
}
