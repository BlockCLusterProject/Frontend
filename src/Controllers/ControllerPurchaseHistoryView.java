package Controllers;

import java.util.List;

import ApiServices.ClientService;
import Models.Movie;

public class ControllerPurchaseHistoryView {
	private ClientService service;
	
	public ControllerPurchaseHistoryView() {
		this.service = new ClientService();
	}
	
	public List<Movie> getHistory() {
		return service.getPurchaseHistory();
	}
}
