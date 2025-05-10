/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import ApiServices.ClientService;
import Models.Person;

/**
 *
 * @author andre
 */
public class ControllerViewLogin {
    
    ClientService service;
    public ControllerViewLogin(ClientService service){
    	
    	this.service = service;
    	
    }
    
    public Person getClient(String user) {
    	return service.getClientByUser(user);
    }
		
	public Person validateUser(String user, String password) {
    	return service.validateUser(user, password);
    }
    
    public Integer getIdRol(String rol) {
    	return service.getIdRol(rol);
    }
    
}
