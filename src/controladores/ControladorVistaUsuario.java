/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.Generos;
import modelos.Pelicula;
import persistencia.Serializadora;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JuanCGallo
 */
public class ControladorVistaUsuario {
    //  TODO: sacar lista de peliculas de una DB o de donde sea
	private ArrayList<Pelicula> peliculas;
	private Pelicula p1 = new Pelicula(
			"gogogo",
			120,
			6.6,
			new ArrayList<>(Arrays.asList(Generos.ACCION, Generos.COMEDIA)),
			1000,
			"dfkj",
			"/img/terminator_2.jpg", 0);
	private Pelicula p2 = new Pelicula("Terminator 2", 137, 6.6,
			new ArrayList<>(Arrays.asList(Generos.AVENTURA, Generos.FANTASIA)), 11000,
			"Algunos años antes, un viajero del tiempo le reveló " +
					"a la madre de John que su hijo sería el salvador de " +
					"la humanidad. Cuando un nuevo androide mejorado llega " +
					"del futuro para asesinar a John, un viejo modelo será " +
					"enviado para protegerle.", "/img/terminator_2.jpg", 0);
	private Pelicula p3 = new Pelicula("p3", 3, 3.3,
		new ArrayList<>(Arrays.asList(Generos.COMEDIA, Generos.CIENCIA_FICCION)),30000, "3", "/img/terminator_2.jpg", 0);
	private Pelicula p4 = new Pelicula("p4", 4, 4.4,
			new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR)),40000, "4", "/img/terminator_2.jpg", 0);
	private Pelicula p5 = new Pelicula("p5", 5, 5.5,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 50000, "5", "/img/terminator_2.jpg", 0);
	private Pelicula p6 = new Pelicula("p6", 6, 6.6,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "6", "/img/terminator_2.jpg", 0);
	private Pelicula p7 = new Pelicula("p7", 7, 7.7,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "7", "/img/terminator_2.jpg", 0);
	private Pelicula p8 = new Pelicula("p8", 8, 8.8,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "8", "/img/terminator_2.jpg", 0);
	private Pelicula p9 = new Pelicula("p9", 9, 9.9,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "9", "/img/terminator_2.jpg", 0);
	private Pelicula p10 = new Pelicula("p10", 10, 10.0,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 100000, "10", "/img/terminator_2.jpg", 0);
	private Pelicula p11 = new Pelicula("p11", 11, 11.1,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 110000, "11", "/img/terminator_2.jpg", 0);
	private Pelicula p12 = new Pelicula("p12", 12, 12.2,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 120000, "12", "/img/terminator_2.jpg", 0);
	private Pelicula p13 = new Pelicula("p13", 13, 13.3,
new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 130000, "13", "/img/terminator_2.jpg", 0);
	private int PELICULAS_POR_FILA = 4;
	private Serializadora serializadora;

	public ControladorVistaUsuario() {
		peliculas = new ArrayList<>();
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
		serializadora = new Serializadora();
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

	public int getCantidadPeliculas() {
		return peliculas.size();
	}

	public String getTituloByIdx(int idx) {
		return peliculas.get(idx).getTitulo();
	}

	public double getPuntuacionByIdx(int idx) {
		return peliculas.get(idx).getPuntuacion();
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
