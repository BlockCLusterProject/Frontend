/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Pelicula;

/**
 *
 * @author Dell
 */
public class ControladorVistaAdmin {
        private ArrayList<Pelicula> peliculas= new ArrayList<>();
    		private Pelicula p1 = new Pelicula("gogogo", 120, 6.6, 15000,"dfkj", "/img/terminator_2.jpg", 0);
	private Pelicula p2 = new Pelicula("Terminator 2", 137, 8.6, 1100,
			"Algunos años antes, un viajero del tiempo le reveló " +
					"a la madre de John que su hijo sería el salvador de " +
					"la humanidad. Cuando un nuevo androide mejorado llega " +
					"del futuro para asesinar a John, un viejo modelo será " +
					"enviado para protegerle.", "/img/terminator_2.jpg", 0);
	private Pelicula p3 = new Pelicula("p3", 3, 3.3, 30000, "3", "/img/terminator_2.jpg", 0);
	private Pelicula p4 = new Pelicula("p4", 4, 4.4, 40000, "4", "/img/terminator_2.jpg", 0);
	private Pelicula p5 = new Pelicula("p5", 5, 5.5, 50000, "5", "/img/terminator_2.jpg", 0);
	private Pelicula p6 = new Pelicula("p6", 6, 6.6, 60000, "6", "/img/terminator_2.jpg", 0);
	private Pelicula p7 = new Pelicula("p7", 7, 7.7, 60000, "7", "/img/terminator_2.jpg", 0);
	private Pelicula p8 = new Pelicula("p8", 8, 8.8, 60000, "8", "/img/terminator_2.jpg", 0);
	private Pelicula p9 = new Pelicula("p9", 9, 9.9, 60000, "9", "/img/terminator_2.jpg", 0);
	private Pelicula p10 = new Pelicula("p10", 10, 10.0, 100000, "10", "/img/terminator_2.jpg", 0);
	private Pelicula p11 = new Pelicula("p11", 11, 11.1, 110000, "11", "/img/terminator_2.jpg", 0);
	private Pelicula p12 = new Pelicula("p12", 12, 12.2, 120000, "12", "/img/terminator_2.jpg", 0);
	private Pelicula p13 = new Pelicula("p13", 13, 13.3, 130000, "13", "/img/terminator_2.jpg", 0);
        public ControladorVistaAdmin() {
            peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
		peliculas.add(p4);
		peliculas.add(p5);
		peliculas.add(p6);
		peliculas.add(p7);
		peliculas.add(p8);
		peliculas.add(p9);
		peliculas.add(p10);
		peliculas.add(p11);
		peliculas.add(p12);
		peliculas.add(p13);
        }
        
        public ArrayList<Pelicula> getPeliculas (){
                return peliculas;
        }
}
