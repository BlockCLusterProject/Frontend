package Controllers;

import ApiServices.ClientService;
import Models.Client;

public class ControllerViewRegister {

	ClientService service;
	
    public ControllerViewRegister(ClientService service){
    	
    	this.service = service;
    	
    }
    
    public boolean registerClient(Client user) {
    	return service.registerClient(user);
    }
}
