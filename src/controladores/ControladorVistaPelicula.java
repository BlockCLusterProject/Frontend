package controladores;

import modelos.Pelicula;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaPelicula {

    private Serializadora serializadora;
    private ArrayList<Pelicula> carrito;


    public ControladorVistaPelicula() {
        serializadora = new Serializadora();
        carrito = serializadora.leerCarrito();
    }

    public void agregarCarrito(Pelicula pelicula) {
        carrito.add(pelicula);
        serializadora.guardarCarrito(carrito);
        for(Pelicula p : carrito) {
            System.out.println(p);
        }
        System.out.println("Guarda en carrito");
    }
}
