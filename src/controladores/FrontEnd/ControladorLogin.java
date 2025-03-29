/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.FrontEnd;

import modelos.Admin;
import modelos.Cliente;
import modelos.Persona;
import modelos.Usuario;

/**
 *
 * @author andre
 */
public class ControladorLogin {
    
    private Admin admin;
    private Cliente cliente1;
    
    public ControladorLogin(){
        String nombre = "juan";
        String id = "123";
        String edad = "25";
        String correo = "notiene@notiene";
        String telefono = "32323232";
        String usuarioAdmin = "blockcluster";
        String contrasenaAdmin = "123";
        
        admin = new Admin(nombre,id,edad,correo,telefono,usuarioAdmin,contrasenaAdmin);
        
        String nombreCliente = "andrea";
        String idCliente = "111";
        String edadCliente = "20";
        String correoCliente = "notiene@notiene";
        String telefonoCliente = "32323232";
        String usuario = "cliente1";
        String contrasena = "cliente1";
        
        cliente1 = new Cliente(nombreCliente,idCliente,edadCliente,correoCliente,telefonoCliente,usuario,contrasena);
    }
    
    public Persona   login(String nombreUsuario, String contrasena){
        
        if(admin.getUsuario().equals(nombreUsuario) && admin.getContrasena().equals(contrasena)){
            return admin;
        }else if(cliente1.getUsuario().equals(nombreUsuario) && cliente1.getContrasena().equals(contrasena)){
            return cliente1;
        }
        return null;
    }
}
