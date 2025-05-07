package Controllers;

import ApiServices.ClientService;
import Models.Person;

public class ControllerViewRegister {

	ClientService service;
	
    public ControllerViewRegister(ClientService service){
    	
    	this.service = service;
    	
    }
    
    public boolean registerClient(Person user) {
    	return service.registerClient(user);
    }
}
