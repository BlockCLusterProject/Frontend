/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices.FrontEnd;

import java.util.List;

import modelos.Client;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author Dell
 */
public interface ClientSerivce {
    // LOGIN 
    @GET("/api/users/search")
    Call<List<Client>> buscarUsuarios(
        @Query("user") String users,
        @Query("password") String password
    );
    
    @GET("/api/user/available_movies")
    Call<Client> getAvailableMovies();

    @GET("/api/user/available_movies")
    Call<List<Client>> getAvailableMovies(
        @Query("genre") int genre
    );
    // @GET("api/movies")
}
