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
    private int runtime;
    @JsonProperty("vote_average")
    @SerializedName("vote_average")
    private double puntuacion;
    @JsonProperty("genres")
    @SerializedName("genres")
    private List<Genre> generos;
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
            String title,
            int runtime,
            double puntuacion,
            List<Genre> generos,
            double precio,
            String sinopsis,
            String rutaPortada,
            int cantidad
    ) {
        this.title = title;
        this.runtime = runtime;
        this.puntuacion = puntuacion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.rutaPortada = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }
    
    public Movie() {}

    @Override
    public String toString() {
        return "{" +
            "\"title\":\"" + title + "\"," +
            "\"runtime\":" + runtime + "," +
            "\"rate\":" + puntuacion + "," +
            "\"genre_ids\":" + genre_ids + "," +
            "\"price\":" + precio + "," +
            "\"overview\":\"" + sinopsis + "\"," +
            "\"backdrop_path\":\"" + rutaPortada + "\"," +
            "\"active\":" + active + "," +
            "\"cantidad\":" + cantidad +
        "}";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double vote_average) {
        this.puntuacion = vote_average;
    }

    public List<Genre> getGenres() {
        return generos;
    }

    public void setGenres(List<Genre> generos) {
        this.generos = generos;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public double getPrice() {
        return precio;
    }

    public void setPrice(double precio) {
        this.precio = precio;
    }

    public String getOverview() {
        return sinopsis;
    }

    public void setOverview(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getBackdrop_path() {
        return rutaPortada;
    }

    public void setBackdrop_path(String rutaPortada) {
        this.rutaPortada = rutaPortada;
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

}
