package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class PurchaseHistory {
	private Integer id;

	@JsonProperty("client_id")
	@SerializedName("client_id")
	public Integer clientId;

	@JsonProperty("movie_id")
	@SerializedName("movie_id")
	public Integer movieId;
	
	@JsonProperty("quantity")
	@SerializedName("quantity")
	private Integer quantity;
	
	@JsonProperty("price")
	@SerializedName("price")
	public Double price;
	
	public PurchaseHistory() {};
	
	public PurchaseHistory(
			Integer id,
			Integer client_id,
			Integer movie_id,
			Integer quantity,
			Double price) {
		this.id = id;
		this.clientId = client_id;
		this.movieId = movie_id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public PurchaseHistory(
			Integer client_id,
			Integer movie_id,
			Integer quantity,
			Double price) {
		this.clientId = client_id;
		this.movieId = movie_id;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer client_id) {
		this.clientId = client_id;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movie_id) {
		this.movieId = movie_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [client_id=" + clientId + ", movie_id=" + movieId + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
