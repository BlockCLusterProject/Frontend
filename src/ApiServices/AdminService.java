package ApiServices;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import Models.JwtPersistence;
import Models.Movie;
import Models.PurchaseHistory;
import Models.PurchaseHistoryDTO;
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

    @GET("/api/movie/getAllMovies")
    Call<List<Movie>> getAllMovies();

    // OWN BACK
    @POST("/api/movie/create_movie")
    Call<Movie> createMovie(@Query("movie") String movie);
    
    @POST("/api/movie/publishMovies")
    Call<Boolean> publishMovies(@Query("movie") String movie, @Header("Authorization") String token);
    
    @GET("/api/movie/getPurchaseHistory")
    Call<List<PurchaseHistoryDTO>> getPurchaseHistory();

    @PATCH("api/movie/update_movies")
    Call<Movie> updateMovie(@Query("id_movie") int idMovie, @Query("movie") String movie);

    @DELETE("api/movie")
    Call<Movie> deleteMovie(@Query("id_movie") int idMovie);
    
    @PATCH("api/movie")
    Call<Movie> updateUser(@Path("id") int userId, @Body Map<String, Movie> updates);

    // @GET("api/movies")
}

public class AdminService {
    static Dotenv dotenv = Dotenv.load();
    private static final String BASE_URL = dotenv.get("API_URL");
    private static AdminApiService apiService;

    public AdminService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        apiService = retrofit.create(AdminApiService.class);
    }

    public List<Movie> getAllMovies() {
        try {
            Response<List<Movie>> response = apiService.getAllMovies().execute();
            System.out.println(response.body().get(0).getTitle());
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
    
    public boolean updateMovie(int idMovie, String movie) {
    	try {
    		// System.out.println("Front Service");
    		// System.out.println(movie);
    		Response<Movie> response = apiService.updateMovie(idMovie, movie).execute();
    		if (response.isSuccessful()) {
                return true;
            } else {
                System.out.println("Error: " + response.code());
                return false;
            }
    	} catch  (IOException e){
    		 e.printStackTrace();
             return false;
    	}
    }
    
    public Movie createMovie(String movie) {
    	try {
    		Response<Movie> response = apiService.createMovie(movie).execute();
    		if(response.isSuccessful()) {
    			return response.body();
    		} else {
    			return null;
    		}
    	} catch (IOException e) {
    		return null;
    	}
    }
    
    public boolean publishMovies(List<Movie> movies) {
    	try {
    		String movie = movies.toString();
    		Response<Boolean> response = apiService.publishMovies(movie, "Bearer " + JwtPersistence.getInstance().getToken()).execute();
    		if(response.isSuccessful()) {
    			return response.body();
    		} else {
    			return false;
    		}
    	} catch (IOException e) {
    		return false;
    	}
    }
    
    public List<PurchaseHistoryDTO> getPurchaseHistory() {
    	try {
    		Response<List<PurchaseHistoryDTO>> response = apiService.getPurchaseHistory().execute();
    		if(response.isSuccessful()) {
    			return response.body();
    		} else {
    			return null;
    		}
    	} catch (IOException e) {
    		System.out.print(e.getMessage());
    		return null;
    	}
    }
}
