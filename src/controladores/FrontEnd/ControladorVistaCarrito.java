package controladores.FrontEnd;


import controladores.FrontEnd.ControladorVistaUsuario;
import modelos.Pelicula;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaCarrito {
    private Serializadora serializadora;
    private ArrayList<Pelicula> carrito;
    private ControladorVistaUsuario controladorVistaUsuario;

    public ControladorVistaCarrito() {
        serializadora = new Serializadora();
        carrito = serializadora.leerCarrito();
        controladorVistaUsuario = new ControladorVistaUsuario();
    }

    public ArrayList<Pelicula> getCarrito() {
        return carrito;
    }

    public void vaciarCarrito() {
        carrito.clear();
        serializadora.guardarCarrito(carrito);
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
