/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Models.Movie;

/**
 *
 * @author JuanCGallo
 */



public class Serializer {
	public void saveShoppingCar(List<Movie> cart) {
		try {
			FileOutputStream file = new FileOutputStream("carrito.dat");
			ObjectOutputStream writer = new ObjectOutputStream(file);
			writer.writeObject(cart);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Movie> readShoppingCar() {
		try {
			FileInputStream file = new FileInputStream("carrito.dat");
			ObjectInputStream reader = new ObjectInputStream(file);
			return (List<Movie>) reader.readObject();
		} catch(IOException | ClassNotFoundException e) {
			return new ArrayList<>();
		}
	}
}





