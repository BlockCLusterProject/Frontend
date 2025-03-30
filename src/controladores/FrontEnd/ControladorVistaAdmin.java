/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.FrontEnd;

import java.util.ArrayList;
import java.util.Arrays;

import modelos.Generos;
import modelos.Movie;

/**
 *
 * @author Dell
 */
public class ControladorVistaAdmin {
        private ArrayList<Movie> peliculas= new ArrayList<>();
    		private Movie p1 = new Movie(
			"gogogo",
			120,
			6.6,
			new ArrayList<>(Arrays.asList(Generos.ACCION, Generos.COMEDIA)),
			1000,
			"dfkj",
			"/img/terminator_2.jpg", 0);
	private Movie p2 = new Movie("Terminator 2", 137, 6.6,
			new ArrayList<>(Arrays.asList(Generos.AVENTURA, Generos.FANTASIA)), 11000,
			"Algunos años antes, un viajero del tiempo le reveló " +
					"a la madre de John que su hijo sería el salvador de " +
					"la humanidad. Cuando un nuevo androide mejorado llega " +
					"del futuro para asesinar a John, un viejo modelo será " +
					"enviado para protegerle.", "/img/terminator_2.jpg", 0);
	private Movie p3 = new Movie("p3", 3, 3.3,
		new ArrayList<>(Arrays.asList(Generos.COMEDIA, Generos.CIENCIA_FICCION)),30000, "3", "/img/terminator_2.jpg", 0);
	private Movie p4 = new Movie("p4", 4, 4.4,
			new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR)),40000, "4", "/img/terminator_2.jpg", 0);
	private Movie p5 = new Movie("p5", 5, 5.5,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 50000, "5", "/img/terminator_2.jpg", 0);
	private Movie p6 = new Movie("p6", 6, 6.6,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "6", "/img/terminator_2.jpg", 0);
	private Movie p7 = new Movie("p7", 7, 7.7,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "7", "/img/terminator_2.jpg", 0);
	private Movie p8 = new Movie("p8", 8, 8.8,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "8", "/img/terminator_2.jpg", 0);
	private Movie p9 = new Movie("p9", 9, 9.9,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "9", "/img/terminator_2.jpg", 0);
	private Movie p10 = new Movie("p10", 10, 10.0,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 100000, "10", "/img/terminator_2.jpg", 0);
	private Movie p11 = new Movie("p11", 11, 11.1,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 110000, "11", "/img/terminator_2.jpg", 0);
	private Movie p12 = new Movie("p12", 12, 12.2,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 120000, "12", "/img/terminator_2.jpg", 0);
	private Movie p13 = new Movie("p13", 13, 13.3,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 130000, "13", "/img/terminator_2.jpg", 0);
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
        
        public ArrayList<Movie> getPeliculas (){
                return peliculas;
        }
}
