/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.List;

import ApiServices.AdminService;
import Models.PurchaseHistory;

/**
 *
 * @author Dell
 */
public class ControllerPurchaseHistoryAdmin {
    public AdminService _service;
    public ControllerPurchaseHistoryAdmin() {
    	_service = new AdminService();
    }
    
    public List<PurchaseHistory> getPurchaseHistory(){
    	 return _service.getPurchaseHistory();
    }	
}
