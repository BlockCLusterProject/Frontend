/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

import Models.Client;
import Models.Movie;

/**
 *
 * @author Dell
 */
public interface AdminService {
    // API MOVIEDB
    @GET("/api/trending_movies")
    Call<List<Client>> buscarPeliculas(
        @Query("genre") int genre
    );

    @GET("/api/trending_movies")
    Call<List<Client>> buscarPeliculas(
        @Query("genre") int genre,
        @Query("movie_name") String movieName  
    );
    
    // OWN BACK
    @POST("/api/movie")
    Call<Client> createMovie(@Body Movie movie);

    @PATCH("api/movie")
    Call<Client> updateMovie( @Query("id_movie") int idMovie, @Body Movie movie);

    @DELETE("api/movie")
    Call<Client> deleteMovie(@Query("id_movie") int idMovie);
    
    // @GET("api/movies")
}