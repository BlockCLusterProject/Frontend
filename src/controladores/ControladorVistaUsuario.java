/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.Pelicula;

import java.util.ArrayList;

/**
 *
 * @author JuanCGallo
 */
public class ControladorVistaUsuario {
    //  TODO: sacar lista de peliculas de una DB o de donde sea
	private ArrayList<Pelicula> peliculas;
	private Pelicula p1 = new Pelicula("gogogo", 120, 6.6, 15000,"dfkj", "/img/terminator_2.jpg");
	private Pelicula p2 = new Pelicula("Terminator 2", 137, 8.6, 11000,
			"Algunos años antes, un viajero del tiempo le reveló " +
					"a la madre de John que su hijo sería el salvador de " +
					"la humanidad. Cuando un nuevo androide mejorado llega " +
					"del futuro para asesinar a John, un viejo modelo será " +
					"enviado para protegerle.", "/img/terminator_2.jpg");
	private Pelicula p3 = new Pelicula("p3", 3, 3.3, 30000, "3", "/img/terminator_2.jpg");
	private Pelicula p4 = new Pelicula("p4", 4, 4.4, 40000, "4", "/img/terminator_2.jpg");
	private Pelicula p5 = new Pelicula("p5", 5, 5.5, 50000, "5", "/img/terminator_2.jpg");
	private Pelicula p6 = new Pelicula("p6", 6, 6.6, 60000, "6", "/img/terminator_2.jpg");
	private int PELICULAS_POR_FILA = 4;

	public ControladorVistaUsuario() {
		peliculas = new ArrayList<>();
		peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
		peliculas.add(p4);
		peliculas.add(p5);
		peliculas.add(p6);
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public Pelicula entregarPelicula(int n) {
		return peliculas.get(n);
	}

	public int getPELICULAS_POR_FILA() {
		return PELICULAS_POR_FILA;
	}

	public int getFilas() {
		if (peliculas.size() <= PELICULAS_POR_FILA) {
			return 1;
		} else {
			int c = 1;
			int filas = peliculas.size();
			while (filas > PELICULAS_POR_FILA) {
				c++;
				filas -= PELICULAS_POR_FILA;
			}
			return c;
		}
	}
}
