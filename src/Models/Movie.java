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
    private double vote_average;
    @JsonProperty("genres")
    @SerializedName("genres")
    private List<Genre> generos;
    @JsonProperty("genre_ids")
    @SerializedName("genre_ids")
    private List<Integer> genre_ids;
    private double price;
    @JsonProperty("overview")
    @SerializedName("overview")
    private String overview;
    @JsonProperty("backdrop_path")
    @SerializedName("backdrop_path")
    private String backdrop_path;
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
            double vote_average,
            List<Genre> generos,
            double precio,
            String overview,
            String rutaPortada,
            int cantidad
    ) {
        this.title = titulo;
        this.runtime = duracion;
        this.vote_average = vote_average;
        this.price = precio;
        this.overview = overview;
        this.backdrop_path = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }
    
    public Movie() {}

    @Override
    public String toString() {
        return "{" +
            "\"title\":\"" + escape(title) + "\"," +
            "\"runtime\":" + runtime + "," +
            "\"vote_average\":" + vote_average + "," +
            "\"price\":" + price + "," +
            "\"overview\":\"" + escape(overview) + "\"," +
            "\"backdrop_path\":\"" + escape(backdrop_path) + "\"," +
            "\"active\":" + active + "," +
            "\"quantity\":" + cantidad +
        "}";
    }

    // Método de apoyo para escapar comillas
    private String escape(String input) {
        if (input == null) return "";
        return input.replace("\"", "\\\"");
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

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
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
        return price;
    }

    public void setPrice(double precio) {
        this.price = precio;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String sinopsis) {
        this.overview = sinopsis;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String rutaPortada) {
        this.backdrop_path = rutaPortada;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getQuantity() {
        return cantidad;
    }

    public void setQuantity(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
