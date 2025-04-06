/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import Models.Client;
import Models.Movie;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author Dell
 */
interface AdminApiService {
    // API MOVIEDB
    @GET("/api/movie/trending_movies")
    Call<List<Movie>> getMovieDbMovies(
            @Query("genre") int genre);

    @GET("/api/movie/available_movies")
    Call<List<Movie>> getOwnMovies(
            @Query("genre") int genre);

    // OWN BACK
    @POST("/api/movie")
    Call<Movie> createMovie(@Body Movie movie);

    @PATCH("api/movie")
    Call<Movie> updateMovie(@Query("id_movie") int idMovie, @Body Movie movie);

    @DELETE("api/movie")
    Call<Movie> deleteMovie(@Query("id_movie") int idMovie);

    // @GET("api/movies")
}

public class AdminService {
    static Dotenv dotenv = Dotenv.load();
    private static final String BASE_URL = dotenv.get("API_URL");
    private static AdminApiService apiService;

    public AdminService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(AdminApiService.class);
    }

    public List<Movie> getAvailableMovies(int genre) {
        try {
            Response<List<Movie>> response = apiService.getOwnMovies(genre).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Movie> getTrendingMovies(){
    	try {
    		Response<List<Movie>> response = apiService.getMovieDbMovies(0).execute();
    		if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
                return null;
            }
    	} catch  (IOException e){
    		 e.printStackTrace();
             return null;
    	}
    }
}
