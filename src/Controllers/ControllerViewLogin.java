/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import ApiServices.ClientService;
import Models.Admin;
import Models.Client;
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
    
    public Client   validateClient(String userName, String password){
    	return service.validateClient(userName,password);
    }
    
    public Admin validateAdmin (String userName, String password) {
    	return service.validateAdmin(userName,password);
    }
}
