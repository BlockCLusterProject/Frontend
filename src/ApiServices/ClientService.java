/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices;

import java.io.IOException;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import Models.Person;
import Models.Movie;
import Models.PurchaseHistory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.*;

/**
 *
 * @author Dell
 */
interface ClientApiService {
	// LOGIN 
	@GET("/api/users/search")
	Call<List<Person>> searchUsers(
			@Query("user") String users,
			@Query("password") String password
			);

	// Login Client Validation 
	@GET("/api/users/validateUser")
	Call<Person> validateUser(
			@Query("user") String user,
			@Query("password") String password
		);
	
	@GET("api/users/getIdRol/{rol}")
	Call<Integer> getIdRol(@Query("rol") String rol);
	
	// Register Client
	@POST("/api/user/addUser")
	Call<Person> registerClient(
			@Body Person user);
	

	@GET("/api/users/available_movies")
	Call<List<Movie>> getAvailableMovies();

	@GET("/api/users/available_movies/{genre}")
	Call<List<Movie>> getMoviesByGenre(
			@Path("genre") int genre
			);
	
	@GET("api/users/get_purchase_history")
	Call<List<Movie>> getPurchaseHistory();
	
	@GET("api/users/{user}")
	Call<Person> getClientByUser(@Path("user") String user);
}

interface QrApiService {
	@GET("/api/users/generate-qr")
	Call<String> generateQr(@Query("message") String message);
}

public class ClientService {

	Dotenv dotenv = Dotenv.load();
	private final String BASE_URL = dotenv.get("API_URL");
	private ClientApiService apiService;
	private QrApiService qrService;

	public ClientService() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(ScalarsConverterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		apiService = retrofit.create(ClientApiService.class);
		qrService = retrofit.create(QrApiService.class);
	}

	public List<Person> searchUsers(String user, String password) {
		try {
			Response<List<Person>> response = apiService.searchUsers(user, password).execute();
			if(response.isSuccessful()) {
				List<Person> users = response.body();
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

	public Person validateUser(String user, String password) {
		try {
			Response<Person> response = apiService.validateUser(user, password).execute();
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
	
	public Integer getIdRol(String rol) {
		try {
			Response<Integer> response = apiService.getIdRol(rol).execute();
			if(response.isSuccessful()) {
				return response.body();
			} else {
				System.out.println("Error: " + response.code());
				return null;
			}
		} catch(IOException e) {
			return null;
		}
	}

	public boolean registerClient(Person user) {
		try {
			Response<Person> response = apiService.registerClient(user).execute();
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
	
	public List<Movie> getPurchaseHistory() {
		try {
			Response<List<Movie>> response = apiService.getPurchaseHistory().execute();
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
	
	public Person getClientByUser(String user) {
		try {
			Response<Person> response = apiService.getClientByUser(user).execute();
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

	public String generateQr(String message) {
		try {
			Response<String> response = qrService.generateQr(message).execute();
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
