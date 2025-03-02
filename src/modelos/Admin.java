/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author andre
 */
public class Admin extends Persona{
    
    private String usuario;
    private String contrasena;

    public Admin(String usuario, String contrasena, String nombre, String id, String edad, String correo, String telefono) {
        super(nombre, id, edad, correo, telefono);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    

    
    
}
