package Controllers;

import ApiServices.ClientService;
import ApiServices.JwtService;
import Models.Person;

public class ControllerViewRegister {

	ClientService service;
	JwtService jwtService;
	
    public ControllerViewRegister(ClientService service){
    	this.jwtService = new JwtService();
    	this.service = service;
    	
    }
    
    public boolean registerClient(Person user) {
    	return service.registerClient(user.toString());
    }
    
    public String generateJwtToken(Person user) {
    	return jwtService.generateJwtToken(user);
    }
}
