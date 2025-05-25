/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import ApiServices.ClientService;
import ApiServices.JwtService;
import Models.Person;

/**
 *
 * @author andre
 */
public class ControllerViewLogin {
    
    ClientService service;
    JwtService jwtService;
    
    @Autowired
    public ControllerViewLogin(ClientService service){
    	this.jwtService = new JwtService();
    	this.service = service;
    	
    }
    
    public String generateJwtToken(Person user) {
    	return jwtService.generateJwtToken(user);
    }
    
    public void initJwtToken() {
    	this.jwtService.init();
    }
    
    public Person getClient(String user) {
    	return service.getClientByUser(user);
    }
		
	public Person validateUser(String user, String password) {
    	return service.validateUser(user, password);
    }
    
	public boolean validateToken() {
		return service.validateJwt();
	}
    public Integer getIdRol(String rol) {
    	return service.getIdRol(rol);
    }
    
}
