/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices;

import java.io.IOException;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import Models.Client;
import Models.Movie;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

/**
 *
 * @author Dell
 */
interface ClientApiService {
    // LOGIN 
    @GET("/api/users/search")
    Call<List<Client>> searchUsers(
        @Query("user") String users,
        @Query("password") String password
    );
    
    @GET("/api/users/available_movies")
    Call<List<Movie>> getAvailableMovies();

    @GET("/api/users/available_movies/{genre}")
    Call<List<Movie>> getMoviesByGenre(
        @Path("genre") int genre
    );
    // @GET("api/movies")
}

public class ClientService {
    Dotenv dotenv = Dotenv.load();
    private static final String BASE_URL = System.getenv("API_URL");
    private static ClientApiService apiService;

    public ClientService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ClientApiService.class);
    }

    public List<Client> searchUsers(String user, String password) {
        try {
            Response<List<Client>> response = apiService.searchUsers(user, password).execute();
            if(response.isSuccessful()) {
                List<Client> users = response.body();
                users.forEach(u -> System.out.println(u));
                return users;
            } else {
                System.out.println("Error: " + response.code());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Movie> getAvailableMovies() {
        try {
            Response<List<Movie>> response = apiService.getAvailableMovies().execute();
            if(response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
                return null;
            }
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Movie> getMoviesByGenre(int genre) {
        try {
            Response<List<Movie>> response = apiService.getMoviesByGenre(genre).execute();
            if(response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
                return null;
            }
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
