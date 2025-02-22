/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class VentaPelicula {
    private ArrayList<Pelicula> peliculas;
    private boolean active;
    
    public VentaPelicula(ArrayList<Pelicula> peliculas, boolean active){
        this.peliculas = peliculas;
        this.active = active;
    }   
    
    public VentaPelicula(){
        
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
}
