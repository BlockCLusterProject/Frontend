/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiServices;

import java.io.IOException;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import Models.Person;
import Models.JwtPersistence;
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
	
	@GET("/api/users/validateJwt")
	Call<String> validateJwt(
			@Header("Authorization") String token);
	
	@GET("api/users/getIdRol/{rol}")
	Call<Integer> getIdRol(@Query("rol") String rol);
	
	// Register Client
	@POST("api/users/addUser")
	Call<Person> registerClient(
			@Query("user") String user,@Header("Authorization") String token);
	

	@GET("/api/users/available_movies")
	Call<List<Movie>> getAvailableMovies();

	@GET("/api/users/available_movies/{genre}")
	Call<List<Movie>> getMoviesByGenre(
			@Path("genre") int genre
			);
	
	@GET("api/users/get_purchase_history")
	Call<List<Movie>> getPurchaseHistory();
	
	@GET("api/users/get_all_purchases")
	Call<List<PurchaseHistory>> getAllPurchases();
	
	@GET("api/users/get_purchase_by_user")
	Call<List<PurchaseHistory>> getPurchaseByUser(@Query("user") String user);
	
	@GET("api/users/client")
	Call<Person> getClientByUser(@Query("user") String user);
	
	@POST("api/users/movie/add-purchase-history")
	Call<Boolean> addPurchaseHistory(@Query("purchase") String puchase);
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
	
	public List<PurchaseHistory> getPuchaseByUser(String user) {
		try {
			Response<List<PurchaseHistory>> response = apiService.getPurchaseByUser(user).execute();
			if(response.isSuccessful()) {
				return response.body();
			} else {
				System.out.println("Error :" + response.code());
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PurchaseHistory> getAllPurchases() {
		try {
			Response<List<PurchaseHistory>> response = apiService.getAllPurchases().execute();
			if(response.isSuccessful()) {
				return response.body();
			} else {
				System.out.println("Error :" + response.code());
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addPurchaseHistory(PurchaseHistory purchase) {
		try {
			Response<Boolean> response = apiService.addPurchaseHistory(purchase.toString()).execute();
			if(response.isSuccessful()) {
				return response.body();
			} else {
				System.out.println("Error :" + response.code());
				return false;
			}
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Person validateUser(String user, String password) {
		try {
			
			Response<Person> response = apiService.validateUser(user,password).execute();
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
	
	public boolean validateJwt() {
		String token = JwtPersistence.getInstance().getToken();
		try {
			Response<String> response = apiService.validateJwt("Bearer " + token).execute();
			if(response.isSuccessful()) {
				return response.body().equalsIgnoreCase("True");
			} else {
				System.out.println("Error: " + response.code());
				return response.body().equalsIgnoreCase("False");
			}
		} catch(IOException e) {
			return false;
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

	public boolean registerClient(String user) {
		try {
			Response<Person> response = apiService.registerClient(user, "Bearer " + JwtPersistence.getInstance().getToken()).execute();
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
			System.out.println(response);
			System.out.println(response.body());
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
