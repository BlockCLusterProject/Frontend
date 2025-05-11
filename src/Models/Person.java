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
public class Person {
    
    private String nombre;
    private Integer id;
    private Integer idRol;
    private String cedula;
    private Integer edad;
    private String correo;
    private String telefono;
    private String user;
    private String password;
    private List<Genre> preferences;

    public Person(
    		String nombre, 
    		Integer id, 
    		Integer idRol,
    		String cedula,
    		Integer edad, 
    		String correo, 
    		String telefono,
    		String user,
    		String password) {
        this.nombre = nombre;
        this.id = id;
        this.idRol = idRol;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.user = user;
        this.password = password;
    }

    public Person(
    		String nombre, 
    		String cedula,
    		Integer edad, 
    		String correo, 
    		String telefono,
    		String user,
    		String password,
    		List<Genre> preferences) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.user = user;
        this.password = password;
        this.preferences = preferences;
    }
    
    
    public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getCedula() {
    	return cedula;
    }
    
    public void setCedula(String cedula) {
    	this.cedula = cedula;
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


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public List<Genre> getPreferences(){
        return preferences;
    }
    
    
    
}
