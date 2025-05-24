package Controllers;

import java.util.List;

import ApiServices.ClientService;
import Models.ClientSesion;
import Models.Movie;
import Models.PurchaseHistory;

public class ControllerPurchaseHistoryView {
	private ClientService service;
	
	public ControllerPurchaseHistoryView() {
		this.service = new ClientService();
	}
	
	public List<PurchaseHistory> getHistory() {
		return service.getPuchaseByUser(ClientSesion.getInstance().getClient().getUser());
	}
}
