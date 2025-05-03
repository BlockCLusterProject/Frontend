/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
import java.util.List;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.core.deps.com.google.gson.annotations.SerializedName;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author JuanCGallo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {
	// MOVIE FRONTEND
	@SerializedName("title")
	@JsonProperty("title")
    private String title;
	@JsonProperty("runtime")
	@SerializedName("runtime")
    private int duracion;
    @JsonProperty("vote_average")
    @SerializedName("vote_average")
    private double puntuacion;
    @JsonProperty("genres")
    @SerializedName("genres")
    private List<Genre> genres;
    @JsonProperty("genre_ids")
    @SerializedName("genre_ids")
    private List<Integer> genre_ids;
    private double precio;
    @JsonProperty("overview")
    @SerializedName("overview")
    private String sinopsis;
    @JsonProperty("backdrop_path")
    @SerializedName("backdrop_path")
    private String rutaPortada;
    @JsonProperty("active")
    @SerializedName("active")
    private boolean active = true;
    @SerializedName("cantidad")
    private int cantidad = 0;
    private static int counter = 1;
    @SerializedName("id")
    @JsonProperty("id")
    private int id;

    public Movie(
            String titulo,
            int duracion,
            double puntuacion,
            List<Genre> generos,
            double precio,
            String sinopsis,
            String rutaPortada,
            int cantidad
    ) {
        this.title = titulo;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.rutaPortada = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }
    
    public List<Integer> getGenre_ids() {
    	return genre_ids;
    }
    
    public void setGenre_ids(List<Integer> genre_ids) {
    	this.genre_ids = genre_ids;
    }
    
    public Movie() {}

    public String getRutaPortada() {
        return rutaPortada;
    }

    @Override
    public String toString() {
        return "{" +
            "\"title\":\"" + title + "\"," +
            "\"runtime\":" + duracion + "," +
            "\"rate\":" + puntuacion + "," +
            "\"genre_ids\":" + genre_ids + "," +
            "\"price\":" + precio + "," +
            "\"overview\":\"" + sinopsis + "\"," +
            "\"backdrop_path\":\"" + rutaPortada + "\"," +
            "\"active\":" + active + "," +
            "\"cantidad\":" + cantidad + "," +
            "\"id\":" + id +
        "}";
    }

    public String getTitle() {
        return title;
    }

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRutaPortada(String rutaPortada) {
		this.rutaPortada = rutaPortada;
	}

}
