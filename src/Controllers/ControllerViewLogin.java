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
    
    public Person   validateClient(String userName, String password){
    	return service.validateClient(userName,password);
    }
    
    public Person validateAdmin (String userName, String password) {
    	return service.validateAdmin(userName,password);
    }
    
    public Person getClient(String user) {
    	return service.getClientByUser(user);
    }
}
