/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices;

import java.io.IOException;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import Models.Admin;
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

	// Login Client Validation 
	@GET("/api/users/validateClient")
	Call<Client> validateClient(
			@Query("user") String user,
			@Query("password") String password
			);

	// Login Admin Validation
	@GET("/api/users/validateAdmin")
	Call<Admin> validateAdmin(
			@Query("user") String user,
			@Query("password") String password
			);
	
	// Register Client
	@POST("/api/user/addUser")
	Call<Client> registerClient(
			@Body Client user);
	

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
	private final String BASE_URL = dotenv.get("API_URL");
	private ClientApiService apiService;

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

	public Client validateClient(String user, String password) {
		try {
			Response<Client> response = apiService.validateClient(user, password).execute();
			if(response.isSuccessful()) {
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

	public Admin validateAdmin(String user, String password) {
		try {
			Response<Admin> response = apiService.validateAdmin(user, password).execute();
			if(response.isSuccessful()) {
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
	
	public boolean registerClient(Client user) {
		try {
			Response<Client> response = apiService.registerClient(user).execute();
			if(response.isSuccessful()) {
				return true;
			} else {
				System.out.println("Error: " + response.code());
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
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
