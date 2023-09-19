package com.praticas.model;

import java.util.Objects;

public class Usuario {
	
	private int id;
	private String nombreUsuario;
	private String nombre;
    private String clave;
    private String apellidos;
    private TipoUsuario tipo;
    
    public Usuario(int id, String nombreUsuario, String nombre, String clave, String apellidos, TipoUsuario tipo) {
        this.nombreUsuario = nombreUsuario;
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo = tipo;
    }
  
    


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombreUsuario() {
		return nombreUsuario;
	}




	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getClave() {
		return clave;
	}




	public void setClave(String clave) {
		this.clave = clave;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}







	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", nombre=" + nombre + ", clave=" + clave
				+ ", apellidos=" + apellidos + ", tipo=" + tipo + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombreUsuario, other.nombreUsuario);
	}




	public TipoUsuario getTipo() {
		return tipo;
	}




	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
    
    
 
	
}
