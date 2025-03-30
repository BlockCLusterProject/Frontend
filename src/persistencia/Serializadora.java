/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelos.Movie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author JuanCGallo
 */
public class Serializadora {
	public void guardarCarrito(ArrayList<Movie> carrito) {
        try {
            FileOutputStream archivo = new FileOutputStream("carrito.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(carrito);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movie> leerCarrito() {
        try {
            FileInputStream archivo = new FileInputStream("carrito.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<Movie>) lector.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
