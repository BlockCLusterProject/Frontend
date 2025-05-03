/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author andre
 */
public class Client extends Person{
    
    private String user;
    private String password;
    private List<String> preference;

    public Client(String nombre, String id, String edad, String correo, String telefono, String user, String password, List preference) {
        super(nombre, id, edad, correo, telefono);
        this.user = user;
        this.password = password;
        this.preference = preference;
    }
    
    public List<String> getPreference() {
        return preference;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setContrasena(String password) {
        this.password = password;
    }
    
    
    
    
}
